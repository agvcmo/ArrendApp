package com.obando.mejia.arrendapp.Controlador.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.obando.mejia.arrendapp.Controlador.Activity.MainActivity.ListaUsuarios;
import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero.Genero;

import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario;
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.R;

import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario.RolUsuario;

public class CrearUsuarioActivity extends AppCompatActivity {

    FloatingActionButton BtnGuardar;
    Spinner SpGenero, SpTipoUsuario;
    EditText EditNombre, EditApellido, EditSegundoApellido, EditNombreUsuario, EditClave, EditTelefono, EditCelular, EditDireccion, EditEdad, EditCorreo;
    int fGenero;
    int fTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    private void mInstanciarObjetos() {
        EditNombre = (EditText) findViewById(R.id.Nombre);
        EditApellido = (EditText) findViewById(R.id.Apellido);
        EditSegundoApellido = (EditText) findViewById(R.id.SegundoApellido);
        EditNombreUsuario = (EditText) findViewById(R.id.NombreUsuario);
        EditClave = (EditText) findViewById(R.id.Clave);
        EditTelefono = (EditText) findViewById(R.id.Telefono);
        EditCelular = (EditText) findViewById(R.id.Celular);
        EditDireccion = (EditText) findViewById(R.id.Direccion);
        EditEdad = (EditText) findViewById(R.id.Edad);
        EditCorreo = (EditText) findViewById(R.id.Correo);

        ArrayAdapter adapterGenero = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Genero());
        SpGenero = (Spinner) findViewById(R.id.spGenero);
        SpGenero.setAdapter(adapterGenero);
        SpGenero.setSelection(0);

        ArrayAdapter adapterTipoUsuario = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, RolUsuario());
        SpTipoUsuario = (Spinner) findViewById(R.id.spTipo);
        SpTipoUsuario.setAdapter(adapterTipoUsuario);
        SpTipoUsuario.setSelection(0);

        BtnGuardar = (FloatingActionButton) findViewById(R.id.BtnGuardar);


    }

    private void mAsignarEventos() {
        SpGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                fGenero = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        SpTipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies, int position, long id) {
                fTipoUsuario = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsUsuario oUsuario = new ClsUsuario();
                try {
                    oUsuario.setGenero(EnumGenero.values()[fGenero]);
                    oUsuario.setTipoUsuario(EnumRolUsuario.values()[fTipoUsuario]);
                    oUsuario.setNombre(EditNombre.getText().toString());
                    oUsuario.setApellido(EditApellido.getText().toString());
                    oUsuario.setSegundoApellido(EditSegundoApellido.getText().toString());
                    oUsuario.setNombreUsuario(EditNombreUsuario.getText().toString());
                    oUsuario.setClave(EditClave.getText().toString());
                    oUsuario.setTelefono(EditTelefono.getText().toString());
                    oUsuario.setCelular(EditCelular.getText().toString());
                    oUsuario.setDireccion(EditDireccion.getText().toString());
                    oUsuario.setEdad(Integer.parseInt(EditEdad.getText().toString()));
                    oUsuario.setCorreo(EditCorreo.getText().toString());

                    if ((ListaUsuarios==null) || (!ListaUsuarios.contains(oUsuario)))
                    {
                        ListaUsuarios.add(oUsuario);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mLimpiarCampos();
                }
            }
        });
    }

    private void mLimpiarCampos() {

        EditNombre.setText("");
        EditApellido.setText("");
        EditSegundoApellido.setText("");
        EditNombreUsuario.setText("");
        EditClave.setText("");
        EditTelefono.setText("");
        EditCelular.setText("");
        EditDireccion.setText("");
        EditEdad.setText("");
        EditCorreo.setText("");
        SpGenero.setSelection(0);
        SpTipoUsuario.setSelection(1);
    }
//endregion Metodos
}
