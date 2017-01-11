package com.obando.mejia.arrendapp.Modelo;

/**
 * Created by personal on 10/01/2017.
 */

public class ClsHabitacion {
    private int Id;
    private int Armario;
    private Boolean Bano;

    public ClsHabitacion() {
    }

    public int Id() {
        return Id;
    }

    public void Id(int id) {
        Id = id;
    }

    public int Armario() {
        return Armario;
    }

    public void Armario(int armario) {
        Armario = armario;
    }

    public Boolean Bano() {
        return Bano;
    }

    public void Bano(Boolean bano) {
        Bano = bano;
    }
}
