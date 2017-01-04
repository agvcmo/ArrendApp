package com.obando.mejia.arrendapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.obando.mejia.arrendapp.Modelo.ClsInmueble;

import java.util.UUID;

public class InmuebleActivity extends AppCompatActivity {

    EditText EdtArrendatario, EdtArrendador;
    FloatingActionButton BtnGuardar;
    ClsInmueble clsInmueble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmueble);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    private void mInstanciarObjetos() {
        EdtArrendador = (EditText) findViewById(R.id.Arrendador);
        EdtArrendatario = (EditText) findViewById(R.id.Arrendatario);
        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);

    }

    private void mAsignarEventos() {
        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clsInmueble = new ClsInmueble(
                            1,
                        Integer.parseInt(EdtArrendador.getText().toString()),
                        Integer.parseInt(EdtArrendatario.getText().toString())
                );
            }
        });
    }

}
