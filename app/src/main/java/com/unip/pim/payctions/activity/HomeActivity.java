package com.unip.pim.payctions.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.fragment.JustificarFaltasFragment;
import com.unip.pim.payctions.fragment.UsuarioInfoFragment;
import com.unip.pim.payctions.fragment.HomeMasterEstadoSolicitacoesFragment;
import com.unip.pim.payctions.fragment.HomeMasterMenuFragment;
import com.unip.pim.payctions.fragment.HomeRhEMasterHomeBotoesFragment;
import com.unip.pim.payctions.fragment.HomeRhMenuFragment;
import com.unip.pim.payctions.interfaces.fragment.FragmentActionListener;
import com.unip.pim.payctions.model.Funcionario;
import com.unip.pim.payctions.model.Usuario;

import java.util.List;

import kotlin.NotImplementedError;

public class HomeActivity extends AppCompatActivity implements FragmentActionListener {

    Usuario usuario;
    FragmentTransaction fragmentTransaction = null;
    FragmentManager fragmentManager = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.botoesColor));

        Bundle bundle = getIntent().getExtras();
        usuario = Usuario.buscaUsuarioPorCd((Integer) bundle.get(Usuario.CD_USUARIO));
        fragmentManager = getSupportFragmentManager();

        carregaFragmentosDoUsuario(usuario);
    }

    /**
     * Usado quando é aberto pela primeira vez
     **/
    private void carregaFragmentosDoUsuario(Usuario usuario) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flInformacoesUsuario, UsuarioInfoFragment.class, montaBundleUsuarioInfo(usuario,
                R.layout.fragment_bem_vindo_usuario_fragment,
                R.color.botoesColor));

        Character tipoPerfil = usuario.getPerfil();
        if (tipoPerfil.equals('A')) {
            fragmentTransaction.add(R.id.flMenu, HomeRhMenuFragment.class, null);
            fragmentTransaction.add(R.id.flPrincipal, montaHomeRhEMasterHomeBotoesFragment(), null);
        } else if (tipoPerfil.equals('O')) {

        } else if (tipoPerfil.equals('M')) {
            Bundle bundle = new Bundle();
            bundle.putInt(FragmentActionListener.opcaoSelecionada, R.id.home_llHome);

            HomeMasterMenuFragment homeMasterMenuFragment = new HomeMasterMenuFragment();
            homeMasterMenuFragment.setMenuFragmentActionListener(this);
            homeMasterMenuFragment.setArguments(bundle);

            fragmentTransaction.add(R.id.flMenu, homeMasterMenuFragment);
            fragmentTransaction.add(R.id.flPrincipal, montaHomeRhEMasterHomeBotoesFragment(), null);
        }

        fragmentTransaction.commit();
    }

    private HomeRhEMasterHomeBotoesFragment montaHomeRhEMasterHomeBotoesFragment() {
        HomeRhEMasterHomeBotoesFragment homeRhEMasterHomeBotoesFragment = new HomeRhEMasterHomeBotoesFragment();
        homeRhEMasterHomeBotoesFragment.setMenuFragmentActionListener(this);
        return homeRhEMasterHomeBotoesFragment;
    }

    /**
     * @return Retorna um Bundle com CDUSUARIO, NOMEFUNCIONARIO,CARGO, DESDE e LAYOUT que será mostrado no topo
     */
    private Bundle montaBundleUsuarioInfo(Usuario usuario,
                                          int layoutId,
                                          int corLayout) {
        Bundle bundle = new Bundle();
        bundle.putInt(UsuarioInfoFragment.CD_FUNCIONARIO, usuario.getFuncionario().getCdFuncionario());
        bundle.putSerializable(UsuarioInfoFragment.DESDE, usuario.getFuncionario().getDtContratacao());
        bundle.putString(UsuarioInfoFragment.CARGO, usuario.getFuncionario().getCargo().getNomeCargo());
        bundle.putString(UsuarioInfoFragment.NOME_FUNCIONARIO, usuario.getFuncionario().getNome());
        bundle.putInt(UsuarioInfoFragment.LAYOUT, layoutId);
        bundle.putInt(UsuarioInfoFragment.COR_LAYOUT, corLayout);

        return bundle;
    }

    @Override
    public void onMenuSelected(Bundle bundle) {
        fragmentTransaction = fragmentManager.beginTransaction();

        HomeMasterMenuFragment homeMasterMenuFragment = new HomeMasterMenuFragment();
        homeMasterMenuFragment.setMenuFragmentActionListener(this);
        homeMasterMenuFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.flMenu, homeMasterMenuFragment);

        int idMenuSelecionado = bundle.getInt(FragmentActionListener.opcaoSelecionada);
        int idMenuAtivo = bundle.getInt(FragmentActionListener.opcaoAtiva);

        montaCustomAnimation(idMenuAtivo, idMenuSelecionado);
        if (usuario.getPerfil().equals('M')) {
            if (idMenuSelecionado == R.id.home_llHome) {
                fragmentTransaction.replace(R.id.flInformacoesUsuario
                        , UsuarioInfoFragment.class,
                        montaBundleUsuarioInfo(usuario,
                                R.layout.fragment_bem_vindo_usuario_fragment,
                                R.color.botoesColor));
                fragmentTransaction.replace(R.id.flPrincipal, montaHomeRhEMasterHomeBotoesFragment(), null);
            } else if (idMenuSelecionado == R.id.home_llEstadoSolicitacoes) {
                fragmentTransaction.replace(R.id.flInformacoesUsuario, UsuarioInfoFragment.class, montaBundleUsuarioInfo(usuario,
                        R.layout.fragment_bem_vindo_usuario_fragment,
                        R.color.cactusBackground));
                fragmentTransaction.replace(R.id.flPrincipal, HomeMasterEstadoSolicitacoesFragment.class, null);
            } else if (idMenuSelecionado == R.id.home_llHistoricoPagamentos) {

            }
        } else {
            throw new NotImplementedError("Ainda não feito para outros usuários sem ser M");
        }

        if (idMenuSelecionado == R.id.homeBotoesFragment_btnJustificarFalta) {
            fragmentTransaction.replace(R.id.flInformacoesUsuario, UsuarioInfoFragment.class, montaBundleUsuarioInfo(usuario,
                    R.layout.fragment_usuario_info,
                    R.color.cactusBackground));
            fragmentTransaction.replace(R.id.flPrincipal, JustificarFaltasFragment.class, null);
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
//        Integer color = montaBackgroundColorMenuSelecionado(idMenuSelecionado);
//        if (color != null) {
//            getWindow().getDecorView().setBackgroundColor(color);
//        }
    }

    private int montaBackgroundColorMenuSelecionado(int opcaoSelecionada) {
        Integer color = null;
        if (opcaoSelecionada == R.id.home_llHome) {
            color = ContextCompat.getColor(this, R.color.botoesColor);
        } else if (opcaoSelecionada == R.id.home_llEstadoSolicitacoes) {
            color = ContextCompat.getColor(this, R.color.cactusBackground);
        }
        return color;
    }

    private void montaCustomAnimation(int menuAtivo, int menuSelecionado) {
        if (usuario.getPerfil().equals('M')) {
            List<Integer> sequenciaMenus = HomeMasterMenuFragment.sequenciaMenus;
            int indexOfMenuAtivo = sequenciaMenus.indexOf(menuAtivo);
            int indexOfMenuSelecionado = sequenciaMenus.indexOf(menuSelecionado);

            if (indexOfMenuAtivo < indexOfMenuSelecionado) {
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.enter_from_right, R.anim.enter_from_right, R.anim.enter_from_right);
            } else if (indexOfMenuAtivo > indexOfMenuSelecionado) {
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.enter_from_left, R.anim.enter_from_left, R.anim.enter_from_left);
            }
        }

    }
}