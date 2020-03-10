package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListView extends AppCompatActivity {

    ListView listView;

    String title[] = {"nome", "rg", "cpf", "telefone", "email", "senha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
    }
}
