package com.obando.mejia.arrendapp.Controlador.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.obando.mejia.arrendapp.Controlador.Adapter.UsuariosAdapter;
import com.obando.mejia.arrendapp.R;

import static com.obando.mejia.arrendapp.Controlador.Activity.MainActivity.ListaUsuarios;

public class VerUsuariosActivity extends AppCompatActivity {
    RecyclerView RclUsuarios;
    UsuariosAdapter AdpUsuarios;
    FloatingActionButton BtnCrearUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);
        mInstanciarObjetos();
        mAsignarEventos();
    }

    private void mInstanciarObjetos() {
        BtnCrearUsuarios = (FloatingActionButton) findViewById(R.id.BtnCrearUsuarios);
        if (ListaUsuarios == null)
            mIniciarActividad(CrearUsuarioActivity.class);
        else {
            RclUsuarios = (RecyclerView) findViewById(R.id.rclUsuarios);
            RclUsuarios.setLayoutManager(new LinearLayoutManager(this));
            RclUsuarios.setHasFixedSize(true);
            AdpUsuarios = new UsuariosAdapter(this, ListaUsuarios);
            RclUsuarios.setAdapter(AdpUsuarios);
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
