package com.obando.mejia.arrendapp.Modelo;

import com.obando.mejia.arrendapp.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Enumeraciones.EnumRolUsuario;

/**
 * Created by ALEXANDER on 10/01/2017.
 */

public class ClsUsuario {
    private int Id;
    private String Nombre;
    private String Apellido;
    private String SegundoApellido;
    private String NombreUsuario;
    private String Clave;
    private String Telefono;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public EnumGenero getGenero() {
        return Genero;
    }

    public void setGenero(EnumGenero genero) {
        Genero = genero;
    }

    public EnumRolUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(EnumRolUsuario tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    private String Celular;
    private String Direccion;
    private int Edad;
    private EnumGenero Genero;
    private EnumRolUsuario TipoUsuario;


}
