package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText txtCpf, txtSenha, txtConfirmaSenha, txtTelefone, txtRg, txtNome;
    Button btnRegistar, btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        txtCpf = findViewById(R.id.idCPF);
        txtRg = findViewById(R.id.idRG);
        txtTelefone = findViewById(R.id.idTelefone);
        txtNome = findViewById(R.id.idNome);
        txtSenha = findViewById(R.id.idSenha);
        txtConfirmaSenha = findViewById(R.id.idConfirmaSenha);

        btnLogin = findViewById(R.id.idBtnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegistar = findViewById(R.id.idBtnRegistrar);

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf, senha, confirmaSenha, telefone, rg, nome;

                cpf = txtCpf.getText().toString();
                rg = txtRg.getText().toString();
                telefone = txtTelefone.getText().toString();
                nome = txtNome.getText().toString();
                senha = txtSenha.getText().toString();
                confirmaSenha = txtConfirmaSenha.getText().toString();

                if (cpf.equals("") || senha.equals("") || confirmaSenha.equals("")) {
                    Toast.makeText(getApplicationContext(), "Favor inserir valores!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (senha.equals(confirmaSenha)) {
                        Boolean checharCpf = db.validarCpf(cpf);
                        if (checharCpf == true) {
                            Boolean inserir = db.insert(cpf, rg, telefone, nome, senha);
                            if (inserir == true) {
                                Toast.makeText(getApplicationContext(), "Registro inserido com sucesso!!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email inserido já existe!!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Senha não confere!!!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}
