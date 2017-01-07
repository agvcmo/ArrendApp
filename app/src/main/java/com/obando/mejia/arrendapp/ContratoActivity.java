package com.obando.mejia.arrendapp;
//region Librerias

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.obando.mejia.arrendapp.Enumeraciones.EnumEstadoContrato;
import com.obando.mejia.arrendapp.Modelo.ClsContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import static com.obando.mejia.arrendapp.Enumeraciones.EnumEstadoContrato.EstadosDeContrato;

//endregion Librerias


public class ContratoActivity extends AppCompatActivity implements FechaFragment.onFechaSeleccionada {

    //region Propiedades
    FloatingActionButton BtnGuardar;
    Spinner SpEstadoContrato;
    int fEstadoContrato;
    String fFechaInicial, fFechaFinal;
    SimpleDateFormat fFormatoFecha;
    //endregion Propiedades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    //region Metodos Sobrecargados
    @Override
    public void FechaSeleccionada(String paramFecha) {
        String auxFecha[] = paramFecha.split("/");
        if (auxFecha[0].equals("I"))
            fFechaInicial(auxFecha[1]);
        else
            fFechaFinal(auxFecha[1]);
    }
    //endregion Metodos Sobrecargados

    //region Metodos
    public String fFechaInicial() {
        return fFechaInicial;
    }

    public void fFechaInicial(String fFechaInicial) {
        this.fFechaInicial = fFechaInicial;
    }

    public String fFechaFinal() {
        return fFechaFinal;
    }

    public void fFechaFinal(String fFechaFinal) {
        this.fFechaFinal = fFechaFinal;
    }

    private void mInstanciarObjetos() {
        fFormatoFecha = new SimpleDateFormat("dd-mm-yyyy");

        ArrayAdapter adapterEstados = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, EstadosDeContrato());
        SpEstadoContrato = (Spinner) findViewById(R.id.spEstado);
        SpEstadoContrato.setAdapter(adapterEstados);
        SpEstadoContrato.setSelection(0);

        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        Fragment frgFechaInicial = new FechaFragment();
        Bundle bundleI = new Bundle();
        bundleI.putString("TipoFecha", "I");
        frgFechaInicial.setArguments(bundleI);
        FT.add(R.id.fragment_fechaInicial, frgFechaInicial);

        Fragment frgFechaFinal = new FechaFragment();
        Bundle bundlef = new Bundle();
        bundlef.putString("TipoFecha", "F");
        frgFechaFinal.setArguments(bundlef);
        FT.add(R.id.fragment_fechaFinal, frgFechaFinal);
        FT.commit();
    }

    private void mAsignarEventos() {
        SpEstadoContrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                fEstadoContrato = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsContrato clsContrato = new ClsContrato();
                clsContrato.Estado(EnumEstadoContrato.values()[fEstadoContrato]);
                try {
                    clsContrato.FechaInicio(fFormatoFecha.parse(fFechaInicial()));
                    clsContrato.FechaFin(fFormatoFecha.parse(fFechaFinal()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
//endregion Metodos

}
