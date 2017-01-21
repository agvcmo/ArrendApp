package com.obando.mejia.arrendapp.Modelo.Entidades;

import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario;

public class ClsUsuario {
    private int Id;
    private String Nombre;

    public ClsUsuario() {
    }

    private String Apellido;
    private String SegundoApellido;
    private String NombreUsuario;

    public ClsUsuario(int id, String nombre, String apellido, String segundoApellido, String nombreUsuario, String clave, String telefono, String celular, String direccion, String correo, int edad, EnumGenero genero, EnumRolUsuario tipo) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        SegundoApellido = segundoApellido;
        NombreUsuario = nombreUsuario;
        Clave = clave;
        Telefono = telefono;
        Celular = celular;
        Direccion = direccion;
        Correo = correo;
        Edad = edad;
        Genero = genero;
        Tipo = tipo;
    }

    private String Clave;
    private String Telefono;
    private String Celular;
    private String Direccion;
    private String Correo;
    private int Edad;
    private EnumGenero Genero;
    private EnumRolUsuario Tipo;

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

    public EnumRolUsuario getTipo() {
        return Tipo;
    }

    public void setTipo(EnumRolUsuario tipo) {
        Tipo = tipo;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
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


}
