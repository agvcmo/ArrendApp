package com.obando.mejia.arrendapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.obando.mejia.arrendapp.Enumeraciones.EnumGenero.Genero;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.obando.mejia.arrendapp.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Enumeraciones.EnumRolUsuario;
import com.obando.mejia.arrendapp.Modelo.ClsUsuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.obando.mejia.arrendapp.Enumeraciones.EnumRolUsuario.RolUsuario;

public class UsuarioActivity extends AppCompatActivity {

    FloatingActionButton BtnGuardar;
    Spinner SpGenero, SpTipoUsuario;
    EditText EditNombre, EditApellido, EditSegundoApellido, EditNombreUsuario, EditClave, EditTelefono, EditCelular, EditDireccion, EditEdad, EditCorreo;
    int fGenero;
    int fTipoUsuario;
    RequestQueue requestQueue;
    private static final String url="http://192.168.1.54:56820/api/usuarios";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
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
        requestQueue= Volley.newRequestQueue(this);

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
                ClsUsuario clsUsuario = new ClsUsuario();
                try {
                    clsUsuario.setGenero(EnumGenero.values()[fGenero]);
                    clsUsuario.setTipo(EnumRolUsuario.values()[fTipoUsuario]);
                    clsUsuario.setNombre(EditNombre.getText().toString());
                    clsUsuario.setApellido(EditApellido.getText().toString());
                    clsUsuario.setSegundoApellido(EditSegundoApellido.getText().toString());
                    clsUsuario.setNombreUsuario(EditNombreUsuario.getText().toString());
                    clsUsuario.setClave(EditClave.getText().toString());
                    clsUsuario.setTelefono(EditTelefono.getText().toString());
                    clsUsuario.setCelular(EditCelular.getText().toString());
                    clsUsuario.setDireccion(EditDireccion.getText().toString());
                    clsUsuario.setEdad(Integer.parseInt(EditEdad.getText().toString()));
                    clsUsuario.setCorreo(EditCorreo.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mLimpiarCampos();
                }

                setJsonDataToWebservices(url, clsUsuario);
            }
        });
    }

    public void setJsonDataToWebservices(String url,ClsUsuario clsUsuario){
        JSONObject params = new JSONObject();
        try {
            params.put("Nombre",clsUsuario.getNombre());
            params.put("Apellido", clsUsuario.getApellido());
            params.put("SegundoApellido", clsUsuario.getSegundoApellido());
            params.put("NombreUsuario", clsUsuario.getNombreUsuario());
            params.put("Clave",clsUsuario.getClave());
            params.put("Telefono",clsUsuario.getTelefono());
            params.put("Celular", clsUsuario.getCelular());
            params.put("Direccion", clsUsuario.getDireccion());
            params.put("Correo", clsUsuario.getCorreo());
            params.put("Edad", clsUsuario.getEdad());
            params.put("Genero", EnumGenero.GeneroEntero(clsUsuario.getGenero().toString()));
            params.put("Tipo", EnumRolUsuario.RolUsuarioEntero(clsUsuario.getTipo().toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Toast.makeText(getApplicationContext(),"Sus datos se enviaron",Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new  HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        requestQueue.add(jsonObjectRequest);
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
