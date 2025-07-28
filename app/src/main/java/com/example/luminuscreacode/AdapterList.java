package com.example.luminuscreacode;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[]  nombres;
    private final String[] descripcion;
    private final String[]  precios;
    private final Integer[] imagen;

    public AdapterList(Activity context, String[] nombres, String[] descrpcion, String[] precios, Integer[] imagen) {
        super(context,R.layout.item,nombres);
        this.context = context;
        this.nombres = nombres;
        this.descripcion = descrpcion;
        this.precios = precios;
        this.imagen = imagen;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item,null);
        TextView _nombre=(TextView)rowView.findViewById(R.id.nombre);
        TextView _descripcion=(TextView)rowView.findViewById(R.id.descripcion);
        TextView _precio=(TextView)rowView.findViewById(R.id.precio);
        ImageView _imagen=(ImageView)rowView.findViewById(R.id.imagen);
        _nombre.setText(nombres[position]);
        _descripcion.setText(descripcion[position]);
        _precio.setText(precios[position]);
        _imagen.setImageResource(imagen[position]);
        return rowView;
    }
}
