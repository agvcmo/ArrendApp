package com.obando.mejia.arrendapp.Modelo.Entidades;
//region Librerias

import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumGenero;
import com.obando.mejia.arrendapp.Modelo.Enumeraciones.EnumRolUsuario;

//endregion Librerias
public class ClsUsuario {
    // region Atributos
    private int fId;
    private String fNombre;
    private String fApellido;
    private String fSegundoApellido;
    private String fNombreUsuario;
    private String fClave;
    private String fTelefono;
    private String fCelular;
    private String fDireccion;
    private String fCorreo;
    private int fEdad;
    private EnumGenero fGenero;
    private EnumRolUsuario fTipo;


    //endregion Atributos


    public ClsUsuario() {
    }


    public ClsUsuario(int paramid, String paramnombre, String paramApellido, String segundoApellido, String paramNombreUsuario, String paramClave, String paramTelefono, String paramCelular, String paramDireccion, String paramCorreo, int paramEdad, EnumGenero paramGenero, EnumRolUsuario paramTipo) {
        fId = paramid;
        fNombre = paramnombre;
        fApellido = paramApellido;
        fSegundoApellido = segundoApellido;
        fNombreUsuario = paramNombreUsuario;
        fClave = paramClave;
        fTelefono = paramTelefono;
        fCelular = paramCelular;
        fDireccion = paramDireccion;
        fCorreo = paramCorreo;
        fEdad = paramEdad;
        fGenero = paramGenero;
        fTipo = paramTipo;
    }

    public int getId() {
        return fId;
    }

    public void setId(int id) {
        fId = id;
    }

    public String getNombre() {
        return fNombre;
    }

    public void setNombre(String nombre) {
        fNombre = nombre;
    }

    public String getApellido() {
        return fApellido;
    }

    public void setApellido(String apellido) {
        fApellido = apellido;
    }

    public String getNombreUsuario() {
        return fNombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        fNombreUsuario = nombreUsuario;
    }

    public EnumGenero getGenero() {
        return fGenero;
    }

    public void setGenero(EnumGenero genero) {
        fGenero = genero;
    }

    public EnumRolUsuario getTipo() {
        return fTipo;
    }

    public void setTipo(EnumRolUsuario tipo) {
        fTipo = tipo;
    }

    public int getEdad() {
        return fEdad;
    }

    public void setEdad(int edad) {
        fEdad = edad;
    }

    public String getDireccion() {
        return fDireccion;
    }

    public void setDireccion(String direccion) {
        fDireccion = direccion;
    }

    public String getCorreo() {
        return fCorreo;
    }

    public void setCorreo(String correo) {
        fCorreo = correo;
    }

    public String getCelular() {
        return fCelular;
    }

    public void setCelular(String celular) {
        fCelular = celular;
    }

    public String getTelefono() {
        return fTelefono;
    }

    public void setTelefono(String telefono) {
        fTelefono = telefono;
    }

    public String getClave() {
        return fClave;
    }

    public void setClave(String clave) {
        fClave = clave;
    }

    public String getSegundoApellido() {
        return fSegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        fSegundoApellido = segundoApellido;
    }

    public ClsUsuario mUsuarioValido(String paramUsuario, String paramClave) {
        ClsUsuario oUsuario = new ClsUsuario();
        return oUsuario;
    }
}
