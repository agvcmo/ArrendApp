package com.obando.mejia.arrendapp.Controlador.Activity;

//region Librerias

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.obando.mejia.arrendapp.Modelo.Entidades.ClsInmueble;
import com.obando.mejia.arrendapp.R;

import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumSiNo.SiNO;
import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumTipoInmueble.TiposInmuebles;
//endregion Librerias

public class InmuebleActivity extends AppCompatActivity {
    //region Propiedades

    EditText EdtArrendatario, EdtArrendador, EdtDireccion, EdtTelefono, EdtBanosComunes;
    EditText EdtArea, EdtArchivo, EdtEstrato, EdtContrato, EdtPrecio, EdtHabitaciones;
    FloatingActionButton BtnGuardar;
    Spinner SpTipoInmueble, SpParqueadero, SpLavadero, SpComedor, SpSalaComedor, SpSala, SpPatio;
    Boolean BlnParqueadero, BlnLavadero, BlnComedor, BlnSalaComedor, BlnSala, BlnPatio;
    String[] fTipoInmuebles;
    String fTipoInmueble;

    //endregion Propiedades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmueble);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    //region Metodos

    private void mInstanciarObjetos() {
        EdtArrendador = (EditText) findViewById(R.id.Arrendador);
        EdtArrendatario = (EditText) findViewById(R.id.Arrendatario);
        EdtArchivo = (EditText) findViewById(R.id.Archivo);
        EdtArea = (EditText) findViewById(R.id.Area);
        EdtBanosComunes = (EditText) findViewById(R.id.BanosComunes);
        EdtDireccion = (EditText) findViewById(R.id.Direccion);
        EdtEstrato = (EditText) findViewById(R.id.Estrato);
        EdtHabitaciones = (EditText) findViewById(R.id.Habitaciones);
        EdtContrato = (EditText) findViewById(R.id.Contrato);
        EdtPrecio = (EditText) findViewById(R.id.Precio);
        EdtTelefono = (EditText) findViewById(R.id.Telefono);
        ArrayAdapter adapterTipoInmueble = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, TiposInmuebles());
        ArrayAdapter adapterSiNo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, SiNO());
        SpTipoInmueble = (Spinner) findViewById(R.id.spTipoInmueble);
        SpTipoInmueble.setAdapter(adapterTipoInmueble);
        SpTipoInmueble.setSelection(0);
        SpComedor = (Spinner) findViewById(R.id.spComedor);
        SpComedor.setAdapter(adapterSiNo);
        SpComedor.setSelection(1);
        SpLavadero = (Spinner) findViewById(R.id.spLavadero);
        SpLavadero.setAdapter(adapterSiNo);
        SpLavadero.setSelection(1);
        SpParqueadero = (Spinner) findViewById(R.id.spParqueadero);
        SpParqueadero.setAdapter(adapterSiNo);
        SpParqueadero.setSelection(1);
        SpSala = (Spinner) findViewById(R.id.spSala);
        SpSala.setAdapter(adapterSiNo);
        SpSala.setSelection(1);
        SpSalaComedor = (Spinner) findViewById(R.id.spSalaComedor);
        SpSalaComedor.setAdapter(adapterSiNo);
        SpSalaComedor.setSelection(1);
        SpPatio = (Spinner) findViewById(R.id.spPatio);
        SpPatio.setAdapter(adapterSiNo);
        SpPatio.setSelection(1);
        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);
        fTipoInmuebles = TiposInmuebles();
    }

    private void mAsignarEventos() {
        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsInmueble clsInmueble = new ClsInmueble();
                try {


                    clsInmueble.Id(1);
                    clsInmueble.IdArrendatario(Integer.parseInt(EdtArrendatario.getText().toString()));
                    clsInmueble.IdArrendador(Integer.parseInt(EdtArrendador.getText().toString()));
                    clsInmueble.Area(Double.valueOf(EdtArea.getText().toString()));
                    clsInmueble.BanosComunes(Integer.parseInt(EdtBanosComunes.getText().toString()));
                    clsInmueble.Direccion(EdtDireccion.getText().toString());
                    clsInmueble.Estrato(Integer.parseInt(EdtEstrato.getText().toString()));
                    clsInmueble.IdContrato(Integer.parseInt(EdtContrato.getText().toString()));
                    clsInmueble.IdArchivo(Integer.parseInt(EdtArchivo.getText().toString()));
                    clsInmueble.Telefono(EdtTelefono.getText().toString());
                    clsInmueble.Tipo(fTipoInmueble);
                    clsInmueble.Sala(BlnSala);
                    clsInmueble.Parqueadero(BlnParqueadero);
                    clsInmueble.SalaComedor(BlnSalaComedor);
                    clsInmueble.Lavadero(BlnLavadero);
                    clsInmueble.Comedor(BlnComedor);
                    clsInmueble.Patio(BlnPatio);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mLimpiarCampos();
                }
            }
        });

        SpTipoInmueble.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                fTipoInmueble = fTipoInmuebles[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        SpSalaComedor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnSalaComedor = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        SpSala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnSala = (position == 0);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });


        SpParqueadero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnParqueadero = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });


        SpLavadero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnLavadero = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        SpComedor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnComedor = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        SpPatio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnPatio = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });
    }

    private void mLimpiarCampos() {
        EdtArchivo.setText("");
        EdtArea.setText("");
        EdtArrendador.setText("");
        EdtArrendatario.setText("");
        EdtPrecio.setText("");
        EdtHabitaciones.setText("");
        EdtEstrato.setText("");
        EdtTelefono.setText("");
        EdtBanosComunes.setText("");
        EdtContrato.setText("");
        SpTipoInmueble.setSelection(0);
        SpComedor.setSelection(1);
        SpLavadero.setSelection(1);
        SpPatio.setSelection(1);
        SpParqueadero.setSelection(1);
        SpSala.setSelection(1);
        SpSalaComedor.setSelection(1);
    }
    //endregion Metodos
}
