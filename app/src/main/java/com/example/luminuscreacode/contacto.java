package com.example.luminuscreacode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class contacto extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_contacto;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return R.id.menu_contacto;
    }

    Button enviarBtn;
    EditText nombreInput, correoInput, mensajeInput;
    private boolean intentoDeEnvio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        enviarBtn = findViewById(R.id.enviarBtn);
        nombreInput = findViewById(R.id.nombreInput);
        correoInput = findViewById(R.id.correoInput);
        mensajeInput = findViewById(R.id.mensajeInput);

        enviarBtn.setOnClickListener(v -> {
            String nombre = nombreInput.getText().toString().trim();
            String correo = correoInput.getText().toString().trim();
            String mensaje = mensajeInput.getText().toString().trim();

            if (nombre.isEmpty() || correo.isEmpty() || mensaje.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            String destinatario = "9991404825j@gmail.com";
            String[] copia = {"krnrodea@gmail.com", "ran_di_001@hotmail.com"};
            String asunto = "Contacto desde LuminusCrea Booking";
            String cuerpo = "Nombre: " + nombre + "\n" + mensaje;

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Mensaje listo para enviar")
                    .setMessage("Para completar el envío, se abrirá tu app de correo en unos segundos.")
                    .setCancelable(false)
                    .create();

            dialog.show();

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                dialog.dismiss();

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario});
                intent.putExtra(Intent.EXTRA_CC, copia);
                intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                intent.putExtra(Intent.EXTRA_TEXT, cuerpo);

                try {
                    intentoDeEnvio = true;
                    startActivity(Intent.createChooser(intent, "Enviar mensaje con:"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show();
                }
            }, 2500);
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (intentoDeEnvio) {
            // Limpiar campos
            nombreInput.setText("");
            correoInput.setText("");
            mensajeInput.setText("");

            // Mostrar mensaje de agradecimiento
            Toast.makeText(this, "Gracias por tu mensaje", Toast.LENGTH_LONG).show();

            // Reiniciar la bandera
            intentoDeEnvio = false;
        }
    }
}