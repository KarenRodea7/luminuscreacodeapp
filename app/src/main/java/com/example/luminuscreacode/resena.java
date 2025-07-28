package com.example.luminuscreacode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resena extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_resena;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return 0;
    }

    EditText inputEstrellas, inputComentario;
    Button btnPublicar;
    String estrellas, comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        inputEstrellas = findViewById(R.id.inputEstrellas);
        inputComentario = findViewById(R.id.inputComentario);
        btnPublicar = findViewById(R.id.btnPublicar);

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estrellas = inputEstrellas.getText().toString().trim();
                comentario = inputComentario.getText().toString().trim();

                if (estrellas.isEmpty() || comentario.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getApplicationContext(), "Gracias por tu reseña.", Toast.LENGTH_LONG).show();
                inputEstrellas.setText("");
                inputComentario.setText("");

            }

        });

    }
}