package com.example.luminuscreacode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class perfil extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_perfil;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return R.id.menu_perfil;
    }

    TextView detalle_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        detalle_res = findViewById(R.id.textReservaDetalle);

        detalle_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), detalle_reserva.class);
                startActivity(intent);
            }
        });

    }
}