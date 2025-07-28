package com.example.luminuscreacode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResourceId();
    protected abstract int getSelectedMenuItemId();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("ToolbarTest", "Toolbar configurada como ActionBar");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Oculta el texto del título
            getSupportActionBar().setDisplayShowHomeEnabled(true);   // Muestra el ícono de la app
            getSupportActionBar().setDisplayUseLogoEnabled(true);    // Usa el logo en lugar del ícono
            getSupportActionBar().setLogo(R.drawable.logoprueba);       // Coloca tu logo
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == getSelectedMenuItemId()) {
            return true;
        }

        if (id == R.id.menu_inicio) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
            return true;
        } else if (id == R.id.menu_explorar) {
            startActivity(new Intent(getApplicationContext(), alojamientos.class));
            finish();
            return true;
        } else if (id == R.id.menu_perfil) {
            startActivity(new Intent(getApplicationContext(), perfil.class));
            finish();
            return true;
        } else if (id == R.id.menu_contacto) {
            startActivity(new Intent(getApplicationContext(), contacto.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
