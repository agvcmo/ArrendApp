package com.obando.mejia.arrendapp.Modelo;

import com.obando.mejia.arrendapp.Enumeraciones.EnumEstadoContrato;

import java.util.Date;

/**
 * Created by personal on 06/01/2017.
 */

public class ClsContrato {
    private int Id;
    private Date FechaInicio;
    private Date FechaFin;
    private EnumEstadoContrato Estado;

    public ClsContrato() {
    }

    public int Id() {
        return Id;
    }

    public void Id(int id) {
        Id = id;
    }

    public Date FechaInicio() {
        return FechaInicio;
    }

    public void FechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date FechaFin() {
        return FechaFin;
    }

    public void FechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public EnumEstadoContrato Estado() {
        return Estado;
    }

    public void Estado(EnumEstadoContrato estado) {
        Estado = estado;
    }
}
