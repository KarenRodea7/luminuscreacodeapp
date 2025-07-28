package com.example.luminuscreacode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pagos extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_pagos;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return 0;
    }

    Spinner spinnerMetodoPago;
    LinearLayout contenedorPago;
    Button btnPagar, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        spinnerMetodoPago = findViewById(R.id.spinnerMetodoPago);
        contenedorPago = findViewById(R.id.contenedorPago);
        btnPagar = findViewById(R.id.btnPagar);

        // Opciones del Spinner
        String[] metodos = {"Selecciona un método", "Tarjeta", "Transferencia", "Oxxo Pay"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, metodos);
        spinnerMetodoPago.setAdapter(adapter);

        spinnerMetodoPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String metodo = (String) parent.getItemAtPosition(position);
                mostrarFormularioPago(metodo);
            }
            @Override public void onNothingSelected(AdapterView<?> parent) { }
        });

        btnPagar.setOnClickListener(v -> {
            Toast.makeText(this, "Pago procesado correctamente", Toast.LENGTH_SHORT).show();
            // Aquí puedes abrir una nueva pantalla de "Gracias"
        });

        cancel = findViewById(R.id.btnCancelar);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), alojamientos.class);
                startActivity(intent);
            }
        });
    }

    private void mostrarFormularioPago(String metodo) {
        contenedorPago.removeAllViews();

        switch (metodo) {
            case "Tarjeta":
                agregarCampoTexto("Número de tarjeta", "XXXX XXXX XXXX XXXX");
                agregarCampoTexto("Nombre del titular", "Como aparece en la tarjeta");
                agregarCampoTexto("Fecha de vencimiento", "MM/AA");
                agregarCampoTexto("CVV", "XXX");
                break;

            case "Transferencia":
                agregarTextoFijo("Transferencia: Realiza un pago vía SPEI.");
                agregarTextoFijo("Banco: Banco Ejemplo S.A.");
                agregarTextoFijo("Cuenta: 123456789012345");
                agregarTextoFijo("CLABE: 012345678901234567");
                break;

            case "Oxxo Pay":
                agregarCampoTexto("Correo para recibir el comprobante", "tu@email.com");
                agregarTextoFijo("Referencia: 123456789");
                agregarTextoFijo("Hotel: Playa Coral");
                agregarTextoFijo("Total: $2,400.00 MXN");

                // Aquí podrías mostrar un ImageView con un QR precargado o generar uno con una librería
                ImageView qrImage = new ImageView(this);
                qrImage.setImageResource(R.drawable.ic_launcher_background); // Coloca un QR en drawable
                qrImage.setLayoutParams(new LinearLayout.LayoutParams(400, 400));
                qrImage.setPadding(0, 20, 0, 20);
                contenedorPago.addView(qrImage);
                break;
        }
    }

    private void agregarCampoTexto(String label, String hint) {
        // Label (TextView)
        TextView tv = new TextView(this);
        tv.setText(label);
        tv.setTextSize(16);
        tv.setPadding(0, 16, 0, 4);
        contenedorPago.addView(tv);

        // Campo de entrada (EditText)
        EditText et = new EditText(this);
        et.setHint(hint);
        et.setTextSize(16);
        et.setPadding(20, 20, 20, 20);
        et.setBackgroundResource(android.R.drawable.edit_text);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(params);
        contenedorPago.addView(et);
    }

    private void agregarTextoFijo(String texto) {
        TextView tv = new TextView(this);
        tv.setText(texto);
        tv.setTextSize(16);
        tv.setPadding(0, 12, 0, 4);
        contenedorPago.addView(tv);
    }
}
