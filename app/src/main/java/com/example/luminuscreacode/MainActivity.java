package com.example.luminuscreacode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends BaseActivity {

    Button Alojamientos;

    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return R.id.menu_inicio;
    }

    Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        /*setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        Alojamientos = findViewById(R.id.Alojamientos);

        Alojamientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), alojamientos.class);
                startActivity(intent);
            }
        });

        listView=(ListView)findViewById(R.id.ListaTipoAloj);
        String[] nombres={"Casa","Hotel","Hostal","Departamento"};
        String[] descripcion ={"","","",""};
        String[] precios ={"","","",""};
        Integer[]  imagen= {R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img};
        AdapterList adapter = new AdapterList(this, nombres, descripcion, precios, imagen);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), alojamientos.class);
                startActivity(intent);
            }
        });
    }
}