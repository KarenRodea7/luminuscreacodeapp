package com.example.luminuscreacode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class detalle_alojam extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_detalle_alojam;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return 0;
    }
    Button reservar, cancel, resena;
    EditText etFechaEntrada, etFechaSalida;

    List<CarouselItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        etFechaEntrada = findViewById(R.id.etFechaEntrada);
        etFechaSalida = findViewById(R.id.etFechaSalida);

        etFechaEntrada.setOnClickListener(view -> mostrarDatePicker(etFechaEntrada));
        etFechaSalida.setOnClickListener(view -> mostrarDatePicker(etFechaSalida));

        reservar = findViewById(R.id.btnReservar);
        cancel = findViewById(R.id.btnCancelar);
        resena = findViewById(R.id.btnResena);

        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), reserva.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), alojamientos.class);
                startActivity(intent);
            }
        });

        resena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), resena.class);
                startActivity(intent);
            }
        });

        ImageCarousel carousel = findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());

        list.add(new CarouselItem(R.drawable.img, "Constelación Canis Maior (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.logoprueba,"Constelación Corvus (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.logoprueba,"Constelación Draco (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.img,"Constelación Leo (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.img,"Constelación Lyra (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.logoprueba,"Constelación Orion (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.logoprueba,"Constelación Pegasus (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.img,"Constelación Scorpius (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.logoprueba,"Constelación Ursa major (Fuente: Stellarium, Free Art License)"));
        list.add(new CarouselItem(R.drawable.img,"Constelación Ursa minor (Fuente: Stellarium, Free Art License)"));

        carousel.setData(list);


    }

    private void mostrarDatePicker(EditText campo) {
        final Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog selectorFecha = new DatePickerDialog(
                detalle_alojam.this,
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