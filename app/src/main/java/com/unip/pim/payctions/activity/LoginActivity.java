package com.unip.pim.payctions.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.model.Funcionario;
import com.unip.pim.payctions.model.Usuario;

import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    TextView btnLogin;

    EditText edtLogin, edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        btnLogin = findViewById(R.id.btnLogin_login);
        edtLogin = findViewById(R.id.edtLogin_login);
        edtSenha = findViewById(R.id.edtSenha_login);

        Context context = this;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = null;
                if ((usuario = Usuario.validaSenha(edtLogin.getText().toString(), edtSenha.getText().toString())) != null) {
                    Intent intent = new Intent(context, HomeActivity.class);
                    intent.putExtra("login", usuario.getLogin());
                    intent.putExtra("nome", usuario.getFuncionario().getNome());
                    intent.putExtra("cdFuncionario", usuario.getCdFuncionario());
                    intent.putExtra("dtContratacao", new Date());

                    startActivity(intent);
                } else {
                    Toast.makeText(context, "Usuário inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}