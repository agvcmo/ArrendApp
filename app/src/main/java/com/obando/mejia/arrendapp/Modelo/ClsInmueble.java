//region Librerias
package com.obando.mejia.arrendapp.Modelo;
//endregion Librerias

/**
 * Created by personal on 03/01/2017.
 */

public class ClsInmueble {
    //region Propiedades
    private int Id;
    private int IdTipoHabitacion;
    private int IdArrendatario;
    private int IdArrendador;
    private int BanosComunes;
    private int IdContrato;
    private int IdArchivo;
    private int Estrato;
    private String Direccion;
    private String Telefono;
    private String Tipo;
    private Double Area;
    private Double Precio;
    private Boolean Parqueadero;
    private Boolean SalaComedor;
    private Boolean Lavadero;
    private Boolean Comedor;
    private Boolean Patio;
    private Boolean Sala;

    //endregion Propiedades

    //region Construtor
    public ClsInmueble(int id, int idArrendador, int idArrendatario) {
        IdArrendatario = idArrendatario;
        Id = id;
        IdArrendador = idArrendador;
    }

    public ClsInmueble(int id, int idArrendatario) {
        IdArrendatario = idArrendatario;
        Id = id;
    }

    public ClsInmueble(int id) {
        Id = id;
    }
    public ClsInmueble() {

    }

    //endregion Construtor

    //region Metodos
    public int Id() {
        return Id;
    }

    public void Id(int id) {
        Id = id;
    }

    public int IdTipoHabitacion() {
        return IdTipoHabitacion;
    }

    public void IdTipoHabitacion(int idTipoHabitacion) {
        IdTipoHabitacion = idTipoHabitacion;
    }

    public int IdArrendatario() {
        return IdArrendatario;
    }

    public void IdArrendatario(int idArrendatario) {
        IdArrendatario = idArrendatario;
    }

    public int IdArrendador() {
        return IdArrendador;
    }

    public void IdArrendador(int idArrendador) {
        IdArrendador = idArrendador;
    }

    public int BanosComunes() {
        return BanosComunes;
    }

    public void BanosComunes(int banosComunes) {
        BanosComunes = banosComunes;
    }

    public int IdContrato() {
        return IdContrato;
    }

    public void IdContrato(int idContrato) {
        IdContrato = idContrato;
    }

    public int IdArchivo() {
        return IdArchivo;
    }

    public void IdArchivo(int idArchivo) {
        IdArchivo = idArchivo;
    }

    public int Estrato() {
        return Estrato;
    }

    public void Estrato(int estrato) {
        Estrato = estrato;
    }

    public String Direccion() {
        return Direccion;
    }

    public void Direccion(String direccion) {
        Direccion = direccion;
    }

    public String Telefono() {
        return Telefono;
    }

    public void Telefono(String telefono) {
        Telefono = telefono;
    }

    public String Tipo() {
        return Tipo;
    }

    public void Tipo(String tipo) {
        Tipo = tipo;
    }

    public Double Area() {
        return Area;
    }

    public void Area(Double area) {
        Area = area;
    }

    public Double Precio() {
        return Precio;
    }

    public void Precio(Double precio) {
        Precio = precio;
    }

    public Boolean Parqueadero() {
        return Parqueadero;
    }

    public void Parqueadero(Boolean parqueadero) {
        Parqueadero = parqueadero;
    }

    public Boolean SalaComedor() {
        return SalaComedor;
    }

    public void SalaComedor(Boolean salaComedor) {
        SalaComedor = salaComedor;
    }

    public Boolean Lavadero() {
        return Lavadero;
    }

    public void Lavadero(Boolean lavadero) {
        Lavadero = lavadero;
    }

    public Boolean Comedor() {
        return Comedor;
    }

    public void Comedor(Boolean comedor) {
        Comedor = comedor;
    }

    public Boolean Patio() {
        return Patio;
    }

    public void Patio(Boolean patio) {
        Patio = patio;
    }

    public Boolean Sala() {
        return Sala;
    }

    public void Sala(Boolean sala) {
        Sala = sala;
    }
    //endregion Metodos
}
