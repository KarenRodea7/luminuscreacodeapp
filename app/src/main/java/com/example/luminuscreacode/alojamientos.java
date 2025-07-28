package com.example.luminuscreacode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class alojamientos extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_alojamientos;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return R.id.menu_explorar;
    }

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        listView=(ListView)findViewById(R.id.ListaP);
        String[] nombres={"Durazno","Fresa","Mango","Manzana","Piña", "Sandía"};
        String[] descripcion ={"Durazno","Fresa","Mango","Manzana","Piña", "Sandía"};
        String[] precios ={"30","40","35","20","55", "33"};
        Integer[]  imagen= {R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img};
        AdapterList adapter = new AdapterList(this, nombres, descripcion, precios, imagen);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), detalle_alojam.class);
                startActivity(intent);
            }
        });

    }


}