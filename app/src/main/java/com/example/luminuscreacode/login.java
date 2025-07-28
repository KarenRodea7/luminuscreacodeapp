package com.example.luminuscreacode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    SharedPreferences preferences;

    int sum;
    String usu, pswd, nom;
    TextView Registrarse;
    Button Acceder;
    EditText user, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Registrarse = findViewById(R.id.Registro);
        Acceder = findViewById(R.id.Acceder);
        user = (EditText)findViewById(R.id.User);
        pass = (EditText)findViewById(R.id.Pass);


        Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registro.class);
                startActivity(intent);
            }
        });

        leerOpc();

        Acceder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(sum<3){
                    sum = sum + 1;

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    String datos = user.getText().toString();
                    String contr = pass.getText().toString();


                    if(datos.equals(usu) & contr.equals(pswd)){
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Cuenta o contraseña incorrectos, te quedan:  " +(3-sum)+" Intentos",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Excediste tus oportunidades",Toast.LENGTH_SHORT).show();
                    Acceder.setEnabled(false);
                }
            }
        });

    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        usu = preferences.getString("user","No hay datos");
        pswd = preferences.getString("pass", "No hay datos");
        nom = preferences.getString("nombre", "No hay datos");
    }
}