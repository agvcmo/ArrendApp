package com.obando.mejia.arrendapp.Controlador.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.obando.mejia.arrendapp.Controlador.Adapter.UsuariosAdapter;
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.Modelo.Utis.ClsServicio;
import com.obando.mejia.arrendapp.R;

import java.util.ArrayList;

public class VerUsuariosActivity extends AppCompatActivity {
    RecyclerView RclUsuarios;
    UsuariosAdapter AdpUsuarios;
    FloatingActionButton BtnCrearUsuarios;
    private ArrayList<ClsUsuario> fListaUsuarios;
    ClsServicio fServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);
        mInstanciarObjetos();
        mAsignarEventos();
    }


    private void mInstanciarObjetos() {
        fServicio = new ClsServicio(getApplicationContext());
        BtnCrearUsuarios = (FloatingActionButton) findViewById(R.id.BtnCrearUsuarios);
        RclUsuarios = (RecyclerView) findViewById(R.id.rclUsuarios);
        RclUsuarios.setLayoutManager(new LinearLayoutManager(this));
        RclUsuarios.setHasFixedSize(true);
        fListaUsuarios = fServicio.mListaUsuarios();
        if (!fListaUsuarios.isEmpty()) {
            AdpUsuarios = new UsuariosAdapter(this, fListaUsuarios);
            RclUsuarios.setAdapter(AdpUsuarios);
            AdpUsuarios.notifyDataSetChanged();
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
