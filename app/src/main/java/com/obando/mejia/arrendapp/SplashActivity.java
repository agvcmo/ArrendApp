package com.obando.mejia.arrendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Thread tiempoEjecutacion = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException IExc) {
                    IExc.printStackTrace();
                } finally {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        progressBar.setVisibility(View.VISIBLE);
        tiempoEjecutacion.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        progressBar.setVisibility(View.GONE);
        finish();
    }
}
