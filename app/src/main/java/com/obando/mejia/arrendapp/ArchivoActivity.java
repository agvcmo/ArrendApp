package com.obando.mejia.arrendapp;

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
import com.obando.mejia.arrendapp.Enumeraciones.EnumTipoArchivo;
import com.obando.mejia.arrendapp.Modelo.ClsArchivo;
import com.obando.mejia.arrendapp.Modelo.ClsContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.obando.mejia.arrendapp.Enumeraciones.EnumEstadoContrato.EstadosDeContrato;
import static com.obando.mejia.arrendapp.Enumeraciones.EnumTipoArchivo.TipoArchivo;

public class ArchivoActivity extends AppCompatActivity implements FechaFragment.onFechaSeleccionada
{
    FloatingActionButton BtnGuardar;
    Spinner SpTipoArchivo;
    int fTipoArchivo;
    String fFechaInicial;
    SimpleDateFormat fFormatoFecha;
    //endregion Propiedades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivo);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    //region Metodos Sobrecargados
    public void FechaSeleccionada(String paramFecha) {
        String auxFecha[] = paramFecha.split("/");
        if (auxFecha[0].equals("I"))
            fFechaInicial(auxFecha[1]);
    }
    //endregion Metodos Sobrecargados

    //region Metodos
    public String fFechaInicial() {
        return fFechaInicial;
    }

    public void fFechaInicial(String fFechaInicial) {
        this.fFechaInicial = fFechaInicial;
    }

    private void mInstanciarObjetos() {
        fFormatoFecha = new SimpleDateFormat("dd-mm-yyyy");

        ArrayAdapter adapterTipoArchivo = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, TipoArchivo());
        SpTipoArchivo = (Spinner) findViewById(R.id.spTipoArchivo);
        SpTipoArchivo.setAdapter(adapterTipoArchivo);
        SpTipoArchivo.setSelection(0);

        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        Fragment frgFechaInicial = new FechaFragment();
        Bundle bundleI = new Bundle();
        bundleI.putString("TipoFecha", "I");
        frgFechaInicial.setArguments(bundleI);
        FT.add(R.id.fragment_fechaInicial, frgFechaInicial);
        FT.commit();
    }

    private void mAsignarEventos() {
        SpTipoArchivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                fTipoArchivo = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsArchivo clsArchivo = new ClsArchivo();
                clsArchivo.setTipo(EnumTipoArchivo.values()[fTipoArchivo]);
                try {
                    clsArchivo.setFecha(fFormatoFecha.parse(fFechaInicial()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
//endregion Metodos

}
