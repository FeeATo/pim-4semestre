package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.model.Usuario;
import com.unip.pim.payctions.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BemVindoUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BemVindoUsuarioFragment extends Fragment {

    Usuario usuario;

    TextView txtUsuario, txtCargo, txtDesde, txtCdFuncionario;

    public BemVindoUsuarioFragment() {
        // Required empty public constructor
    }

    public static BemVindoUsuarioFragment newInstance(String param1, String param2) {
        BemVindoUsuarioFragment fragment = new BemVindoUsuarioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bem_vindo_usuario_fragment, container, false);
        usuario = Usuario.buscaUsuarioPorCd((Integer) getArguments().get(Usuario.CD_USUARIO));
        preencheTextosComUsuario(usuario, view);
        return view;
    }

    private void preencheTextosComUsuario(Usuario usuario, View view) {
        inicializaCampos(view);

        txtDesde.setText(String.format(getResources().getString(R.string.home_user_since), Utils.formatData(usuario.getFuncionario().getDtContratacao(), "dd/MM/yyyy")));
        txtCdFuncionario.setText(String.format(getResources().getString(R.string.home_user_id), usuario.getFuncionario().getCdFuncionario()));
        txtCargo.setText(String.format(getResources().getString(R.string.home_user_role), usuario.getFuncionario().getCargo().getNomeCargo()));
        txtUsuario.setText(usuario.getFuncionario().getNome());
    }

    private void inicializaCampos(View view){
        txtUsuario = view.findViewById(R.id.txtNome_menu);
        txtCargo = view.findViewById(R.id.txtCargo_menu);
        txtDesde = view.findViewById(R.id.txtDesde_menu);
        txtCdFuncionario = view.findViewById(R.id.txtCdFuncionario_menu);
    }
}