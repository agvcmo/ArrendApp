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
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsHabitacion;
import com.obando.mejia.arrendapp.R;

import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumSiNo.SiNO;
//endregion Librerias

public class HabitacionActivity extends AppCompatActivity {
    //region Propiedades
    FloatingActionButton BtnGuardar;
    EditText EdtArmario;
    Spinner SpBano;
    boolean BlnBano;
    //endregion Propieades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitacion);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    //region Metodos
    private void mInstanciarObjetos() {
        ArrayAdapter adapterSiNO = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, SiNO());
        SpBano = (Spinner) findViewById(R.id.spBano);
        SpBano.setAdapter(adapterSiNO);
        SpBano.setSelection(1);
        EdtArmario = (EditText) findViewById(R.id.Armario);
        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);

    }

    private void mAsignarEventos() {
        SpBano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                BlnBano = (position == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsHabitacion clsHabitacion = new ClsHabitacion();
                try {
                    clsHabitacion.Armario(Integer.parseInt(EdtArmario.getText().toString()));
                    clsHabitacion.Bano(BlnBano);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    mLimpiarCampos();
                }
            }
        });
    }

    private void mLimpiarCampos() {
        EdtArmario.setText("");
        SpBano.setSelection(1);
    }
    //endregion Metodos
}
