package com.unip.pim.payctions.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.model.Usuario;
import com.unip.pim.payctions.utils.Utils;

public class HomeActivity extends AppCompatActivity {

    Usuario usuario;

    TextView txtUsuario, txtCargo, txtDesde, txtCdFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inicializaCampos();

        Bundle bundle = getIntent().getExtras();

        usuario = new Usuario((Integer) bundle.get(Usuario.CD_USUARIO),
                (String) bundle.get(Usuario.LOGIN),
                null,
                (Character) bundle.get(Usuario.PERFIL),
                (Integer) bundle.get(Usuario.CD_FUNCIONARIO));

        preencheTextosComUsuario(usuario);
    }

    private void preencheTextosComUsuario(Usuario usuario) {
        txtDesde.setText(String.format(getResources().getString(R.string.home_user_since), Utils.formatData(usuario.getFuncionario().getDtContratacao(), "dd/MM/yyyy")));
        txtCdFuncionario.setText(String.format(getResources().getString(R.string.home_user_id), usuario.getFuncionario().getCdFuncionario()));
        txtCargo.setText(String.format(getResources().getString(R.string.home_user_role), usuario.getFuncionario().getCargo().getNomeCargo()));
    }

    private void inicializaCampos(){
        txtUsuario = findViewById(R.id.txtNome_menu);
        txtCargo = findViewById(R.id.txtCargo_menu);
        txtDesde = findViewById(R.id.txtDesde_menu);
        txtCdFuncionario = findViewById(R.id.txtCdFuncionario_menu);
    }


}