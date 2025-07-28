package com.example.luminuscreacode;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class reserva extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_reserva;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return 0;
    }

    EditText etFechaEntrada, etFechaSalida;
    Button pago, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        etFechaEntrada = findViewById(R.id.etFechaEntrada);
        etFechaSalida = findViewById(R.id.etFechaSalida);
        pago = findViewById(R.id.btnContinuar);

        etFechaEntrada.setOnClickListener(view -> mostrarDatePicker(etFechaEntrada));
        etFechaSalida.setOnClickListener(view -> mostrarDatePicker(etFechaSalida));

        pago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pagos.class);
                startActivity(intent);
            }
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

    private void mostrarDatePicker(EditText campo) {
        final Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog selectorFecha = new DatePickerDialog(
                reserva.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        String fecha = String.format("%02d/%02d/%04d", d, m + 1, y);
                        campo.setText(fecha);
                    }
                },
                año, mes, dia
        );

        selectorFecha.show();
    }
}