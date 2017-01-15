package com.obando.mejia.arrendapp.Controlador.Activity;
//region Librerias

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.obando.mejia.arrendapp.Modelo.Entidades.ClsHabitacion;
import com.obando.mejia.arrendapp.R;

//endregion Librerias

public class HabitacionActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    //region Propiedades
    FloatingActionButton BtnGuardar;
    EditText EdtArmario;
    SwitchCompat SwtBano;
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
        EdtArmario = (EditText) findViewById(R.id.Armario);
        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);
        SwtBano = (SwitchCompat) findViewById(R.id.SwtBano);
    }

    private void mAsignarEventos() {
        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsHabitacion clsHabitacion = new ClsHabitacion();
                try {
                    clsHabitacion.Armario(Integer.parseInt(EdtArmario.getText().toString()));
                    clsHabitacion.Bano(BlnBano);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mLimpiarCampos();
                }
            }
        });
        SwtBano.setOnCheckedChangeListener(this);
    }

    private void mLimpiarCampos() {
        EdtArmario.setText("");
        SwtBano.setChecked(false);
    }
    //endregion Metodos

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.SwtBano:
                BlnBano = isChecked;
                break;

            default:
                break;
        }
    }

}
