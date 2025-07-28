package com.example.luminuscreacode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detalle_reserva extends BaseActivity {

    protected int getLayoutResourceId() {
        return R.layout.activity_detalle_reserva;
    }

    @Override
    protected int getSelectedMenuItemId() {
        return 0;
    }

    Button cancelar_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


    }
}