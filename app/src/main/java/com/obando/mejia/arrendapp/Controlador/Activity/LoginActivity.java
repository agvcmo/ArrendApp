package com.obando.mejia.arrendapp.Controlador.Activity;
//region Librerias

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.Modelo.Utis.ClsCorreo;
import com.obando.mejia.arrendapp.R;

//endregion Librerias

public class LoginActivity extends AppCompatActivity {
    //region Propiedades
    EditText EdtUsuario, EdtContrasena;
    Button BtnIngresar;
    TextView TxtRecuperar, TxtCrear;
    Integer fErrores = 0;
    ClsUsuario fUsuario;
    //endregion Propiedades

    //region Constructor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mInstanciarObjetos();
        mAsignarEventos();
    }
    //endregion Constructor

    //region Metodos
    public Integer getfErrores() {
        return fErrores;
    }

    public void setfErrores(Integer fErrores) {
        this.fErrores = fErrores;
        if (this.fErrores >= 5) {
            Toast.makeText(getApplicationContext(), "Ha superado el Número de intentos", Toast.LENGTH_LONG).show();
            finish();
        }
    }


    private void mInstanciarObjetos() {
        EdtUsuario = (EditText) findViewById(R.id.EdtNombreUsuario);
        EdtContrasena = (EditText) findViewById(R.id.Clave);
        BtnIngresar = (Button) findViewById(R.id.BtnIngresar);
        TxtRecuperar = (TextView) findViewById(R.id.TxtRecuperarContrasena);
        TxtCrear = (TextView) findViewById(R.id.TxtCrearUsuario);
        fUsuario = new ClsUsuario();
    }

    private void mAsignarEventos() {
        BtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCamposValidos() || mValidarUsuario()) {
                    mIniciarActividad(MainActivity.class);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuaio y/o Contraseña no validos", Toast.LENGTH_LONG).show();
                    EdtContrasena.setError("Usuaio y/o Contraseña no validos");
                    setfErrores(getfErrores() + 1);
                    TxtRecuperar.setVisibility(View.VISIBLE);
                }
            }
        });
        TxtRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClsCorreo oCorreo = new ClsCorreo();
                oCorreo.setfAsunto("Contraseña");
                //      oCorreo.setfDestinario(oUsuario.getCorreo())
                //     oCorreo.setfCuerpo(oUsuario.getContrasena());
                oCorreo.mEnviarCorreo();
            }
        });
        TxtCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIniciarActividad(CrearUsuarioActivity.class);
            }
        });
    }

    private boolean mCamposValidos() {
        return ((EdtUsuario.getText().length() > 0) || EdtContrasena.getText().length() > 0);
    }

    private boolean mValidarUsuario() {
        return (fUsuario.mUsuarioValido(EdtUsuario.getText().toString(), EdtContrasena.getText().toString()) != null);
    }

    private void mIniciarActividad(Class paramActivity) {
        Intent intent = new Intent(this, paramActivity);
        startActivity(intent);
    }

    //endregion Metodos
}
