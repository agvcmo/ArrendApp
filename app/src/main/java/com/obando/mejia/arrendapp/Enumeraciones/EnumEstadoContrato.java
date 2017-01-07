package com.obando.mejia.arrendapp.Enumeraciones;

/**
 * Created by personal on 06/01/2017.
 */

public enum EnumEstadoContrato {
    Activo(0),
    Inactivo(1),
    Suspendido(2);

    private final int estado;

    EnumEstadoContrato(int paramEstado) {
        estado = paramEstado;
    }

    public int EnumEstadoContrato() {
        return estado;
    }

    public static String[] EstadosDeContrato() {
        EnumEstadoContrato[] enumEstadoContrato = values();
        String[] estados = new String[enumEstadoContrato.length];

        for (int i = 0; i < enumEstadoContrato.length; i++) {
            estados[i] = enumEstadoContrato[i].name();
        }

        return estados;
    }

}
