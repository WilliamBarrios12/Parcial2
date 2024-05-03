package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_is;
    EditText ed_usuario;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_is = findViewById(R.id.btn_is);
        ed_usuario = findViewById(R.id.ed_usuario);

        sharedPreferences = getSharedPreferences("dataUser", MODE_PRIVATE);

        String savedUsername = sharedPreferences.getString("user", "");

        if (!savedUsername.isEmpty()) {
            Intent i = new Intent(MainActivity.this, MainAdaptador.class);
            startActivity(i);
            finish();
        }

        btn_is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed_usuario.getText().toString();
                if (!username.isEmpty()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user", username);
                    editor.apply();

                    Intent i = new Intent(MainActivity.this, MainAdaptador.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor ingresa un usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}