package com.unip.pim.payctions.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.fragment.BemVindoUsuarioFragment;
import com.unip.pim.payctions.fragment.HomeMasterEstadoSolicitacoesFragment;
import com.unip.pim.payctions.fragment.HomeMasterMenuFragment;
import com.unip.pim.payctions.fragment.HomeRhEMasterHomeBotoesFragment;
import com.unip.pim.payctions.fragment.HomeRhMenuFragment;
import com.unip.pim.payctions.interfaces.fragment.FragmentActionListener;
import com.unip.pim.payctions.model.Usuario;

public class HomeActivity extends AppCompatActivity implements FragmentActionListener {

    Usuario usuario;
    FragmentTransaction fragmentTransaction = null;
    FragmentManager fragmentManager = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        usuario = Usuario.buscaUsuarioPorCd((Integer) bundle.get(Usuario.CD_USUARIO));
        fragmentManager = getSupportFragmentManager();

        carregaFragmentosDoUsuario(usuario);
    }

    private void carregaFragmentosDoUsuario(Usuario usuario) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundleUsuario = new Bundle();
        bundleUsuario.putInt(Usuario.CD_USUARIO, usuario.getCdUsuario());
        fragmentTransaction.add(R.id.flInformacoesUsuario, BemVindoUsuarioFragment.class, bundleUsuario);

        Character tipoPerfil = usuario.getPerfil();
        if (tipoPerfil.equals('A')) {
            fragmentTransaction.add(R.id.flMenu, HomeRhMenuFragment.class, null);
            fragmentTransaction.add(R.id.flPrincipal, HomeRhEMasterHomeBotoesFragment.class, null);
        } else if (tipoPerfil.equals('O')) {

        } else if(tipoPerfil.equals('M')) {
            Bundle bundle = new Bundle();
            bundle.putInt(FragmentActionListener.opcaoSelecionada, R.id.home_llHome);

            HomeMasterMenuFragment homeMasterMenuFragment = new HomeMasterMenuFragment();
            homeMasterMenuFragment.setMenuFragmentActionListener(this);
            homeMasterMenuFragment.setArguments(bundle);

            fragmentTransaction.add(R.id.flMenu, homeMasterMenuFragment);
            fragmentTransaction.add(R.id.flPrincipal, HomeRhEMasterHomeBotoesFragment.class, null);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onMenuSelected(Bundle bundle) {
        fragmentTransaction = fragmentManager.beginTransaction();

        HomeMasterMenuFragment homeMasterMenuFragment = new HomeMasterMenuFragment();
        homeMasterMenuFragment.setMenuFragmentActionListener(this);
        homeMasterMenuFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.flMenu, homeMasterMenuFragment);

        int idMenu = bundle.getInt(FragmentActionListener.opcaoSelecionada);

        if(idMenu == R.id.home_llHome) {
            fragmentTransaction.replace(R.id.flPrincipal, HomeRhEMasterHomeBotoesFragment.class, null);
        } else if (idMenu == R.id.home_llEstadoSolicitacoes) {
            fragmentTransaction.replace(R.id.flPrincipal, HomeMasterEstadoSolicitacoesFragment.class, null);
        } else if (idMenu == R.id.home_llHistoricoPagamentos) {

        }

        fragmentTransaction.commit();

    }
}