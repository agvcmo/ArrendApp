package com.obando.mejia.arrendapp.Controlador.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.obando.mejia.arrendapp.Controlador.Adapter.UsuariosAdapter;
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario;
import com.obando.mejia.arrendapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.obando.mejia.arrendapp.Controlador.Activity.MainActivity.ListaUsuarios;
import static com.obando.mejia.arrendapp.Controlador.Activity.MainActivity.urlGetUsuarios;

public class VerUsuariosActivity extends AppCompatActivity {
    RecyclerView RclUsuarios;
    UsuariosAdapter AdpUsuarios;
    FloatingActionButton BtnCrearUsuarios;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        mInstanciarObjetos();
        mAsignarEventos();
    }

    private boolean mValidarUsuariosNuevo(ClsUsuario paramUsuario)
    {
        for (ClsUsuario usuarios:ListaUsuarios) {
            if (usuarios.getId() == paramUsuario.getId()) {
                return true;
            }
        }
        return false;
    }

    private void mInstanciarObjetos() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando datos...");
        BtnCrearUsuarios = (FloatingActionButton) findViewById(R.id.BtnCrearUsuarios);
        if (ListaUsuarios == null)
            mIniciarActividad(CrearUsuarioActivity.class);
        else {
            RclUsuarios = (RecyclerView) findViewById(R.id.rclUsuarios);
            RclUsuarios.setLayoutManager(new LinearLayoutManager(this));
            RclUsuarios.setHasFixedSize(true);
            AdpUsuarios = new UsuariosAdapter(this, ListaUsuarios);
            RclUsuarios.setAdapter(AdpUsuarios);
            JsonArrayRequest request = new JsonArrayRequest(urlGetUsuarios, new Response.Listener<JSONArray>() {
                public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                try {
                    ClsUsuario usuarioInsertar = null;
                    JSONObject object=response.getJSONObject(i);
                    int Id = object.getInt("Id");

                    String Nombre = object.getString("Nombre");
                    String Apellido = object.getString("Apellido");
                    String SegundoApellido = object.getString("SegundoApellido");
                    String NombreUsuario = object.getString("NombreUsuario");
                    String Clave = object.getString("Clave");
                    String Telefono = object.getString("Telefono");
                    String Celular = object.getString("Celular");
                    String Direccion = object.getString("Direccion");
                    String Correo = object.getString("Correo");
                    int Edad = object.getInt("Edad");
                    EnumGenero Genero = EnumGenero.GeneroEnumeracion(object.getInt("Genero"));
                    EnumRolUsuario Tipo = EnumRolUsuario.RolUsuarioEnumeracion(object.getInt("Tipo")) ;
                    usuarioInsertar = new ClsUsuario(
                            Id, Nombre, Apellido, SegundoApellido, NombreUsuario, Clave,Telefono, Celular, Direccion, Correo, Edad, Genero,Tipo);
                    if (!mValidarUsuariosNuevo(usuarioInsertar)) {
                        ListaUsuarios.add(usuarioInsertar);
                    }
                } catch (JSONException e) {
                    //Toast.makeText(MainActivity.this,""+e, Toast.LENGTH_LONG).show();
                }
            }AdpUsuarios.notifyDataSetChanged();

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    requestQueue.add(request);
        }
    }

    private void mAsignarEventos() {
        BtnCrearUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIniciarActividad(CrearUsuarioActivity.class);
            }
        });
    }

    private void mIniciarActividad(Class paramActivity) {
        Intent intent = new Intent(this, paramActivity);
        startActivity(intent);
    }
}
