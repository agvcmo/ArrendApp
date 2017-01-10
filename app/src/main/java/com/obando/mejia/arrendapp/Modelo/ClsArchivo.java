package com.obando.mejia.arrendapp.Modelo;

import com.obando.mejia.arrendapp.Enumeraciones.EnumTipoArchivo;

import java.util.Date;

public class ClsArchivo {
    private int Id;
    private String Ruta;
    private EnumTipoArchivo Tipo;
    private Date Fecha;
    private String Descripcion;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    public EnumTipoArchivo getTipo() {
        return Tipo;
    }

    public void setTipo(EnumTipoArchivo tipo) {
        Tipo = tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }


}
