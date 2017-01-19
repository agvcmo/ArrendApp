package com.obando.mejia.arrendapp.Controlador.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.obando.mejia.arrendapp.Controlador.Activity.MainActivity.ListaUsuarios;
import static com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero.Genero;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    RequestQueue requestQueue;
    private static final String url = "http://192.168.1.54:56820/api/usuarios";

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
        requestQueue = Volley.newRequestQueue(this);

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
                if (mValidarCampos()) {
                    ClsUsuario oUsuario = new ClsUsuario();
                    try {
                        oUsuario.setGenero(EnumGenero.values()[fGenero]);
                        oUsuario.setTipo(EnumRolUsuario.values()[fTipoUsuario]);
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

                        if ((ListaUsuarios == null) || (!ListaUsuarios.contains(oUsuario))) {
                            ListaUsuarios.add(oUsuario);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        mLimpiarCampos();
                    }

                    setJsonDataToWebservices(url, oUsuario);
                }
            }

        });

        EditCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!EditCorreo.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && EditCorreo.getText().toString().length() > 0) {
                    EditCorreo.setError("Mail invalido");
                    EditCorreo.requestFocus();
                }
            }
        });
        EditCorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    if (!EditCorreo.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && EditCorreo.getText().toString().length() > 0) {
                        EditCorreo.setError("Mail invalido");
                        EditCorreo.requestFocus();
                    }

                }
            }
        });
    }

    private boolean mValidarCampos() {
        Boolean oValido = true;
        if (mEditTextValido(EditNombre)) {
            if (mEditTextValido(EditApellido)) {
                if (mEditTextValido(EditNombreUsuario)) {
                    if (mEditTextValido(EditClave)) {
                        if (mEditTextValido(EditTelefono)) {
                            if (!mEditTextValido(EditEdad)) {
                                oValido = false;
                            }
                        } else oValido = false;
                    } else oValido = false;
                } else oValido = false;
            } else oValido = false;
        } else oValido = false;
        return oValido;
    }

    private boolean mEditTextValido(EditText paramEdit) {
        if (!(paramEdit.getText().length() > 0)) {
            paramEdit.setError("Campo obligatorio");
            paramEdit.requestFocus();
            return false;
        } else
            return true;
    }

    public void setJsonDataToWebservices(String url, ClsUsuario clsUsuario) {
        JSONObject params = new JSONObject();
        try {
            params.put("Nombre", clsUsuario.getNombre());
            params.put("Apellido", clsUsuario.getApellido());
            params.put("SegundoApellido", clsUsuario.getSegundoApellido());
            params.put("NombreUsuario", clsUsuario.getNombreUsuario());
            params.put("Clave", clsUsuario.getClave());
            params.put("Telefono", clsUsuario.getTelefono());
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
                        Toast.makeText(getApplicationContext(), "Sus datos se enviaron", Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }

    private void mLimpiarCampos() {
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
        EditNombre.setText("");
        EditNombre.requestFocus();
    }
//endregion Metodos
}
