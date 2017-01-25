package com.obando.mejia.arrendapp.Modelo.Utis;
//region Librerias

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//endregion Librerias

public class ClsServicio {

    //region Constantes
    private static final String KURLUsuarios = "http://192.168.1.54:56820/Api/Usuarios";
    //endregion Constantes

    //region Atributos
    RequestQueue fRequestQueue;
    Context fContexto;
    ProgressDialog fProgressDialog;
    //endregion Atributos

    //region Constructor
    public ClsServicio(Context paramContexto) {
        fContexto = paramContexto;
    }
    //endregion Constructor

    //region Metodos
    public ArrayList<ClsUsuario> mListaUsuarios() {

        fProgressDialog = new ProgressDialog(fContexto);
        fProgressDialog.setMessage("cargando datos...");

        fRequestQueue = Volley.newRequestQueue(fContexto);
        final ArrayList<ClsUsuario> oUsuarioLista = null;
        JsonArrayRequest request = new JsonArrayRequest(KURLUsuarios, new Response.Listener<JSONArray>() {
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        ClsUsuario usuarioInsertar = null;
                        JSONObject object = response.getJSONObject(i);
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
                        EnumRolUsuario Tipo = EnumRolUsuario.RolUsuarioEnumeracion(object.getInt("Tipo"));
                        usuarioInsertar = new ClsUsuario(
                                Id, Nombre, Apellido, SegundoApellido, NombreUsuario, Clave, Telefono, Celular, Direccion, Correo, Edad, Genero, Tipo);
                        if (!oUsuarioLista.contains(usuarioInsertar)) {
                            oUsuarioLista.add(usuarioInsertar);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        fRequestQueue.add(request);
        return oUsuarioLista;
    }


    public void mEliminarUsuario(ClsUsuario paramUsuaio) {

    }

    public void mAgregarUsuario(ClsUsuario clsUsuario) {
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
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, KURLUsuarios, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Toast.makeText(fContexto, "Sus datos se enviaron", Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(fContexto, "", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        fRequestQueue.add(jsonObjectRequest);
    }
    //endregion Metodos
}
