package com.obando.mejia.arrendapp.Enumeraciones;

/**
 * Created by ALEXANDER on 10/01/2017.
 */

public enum EnumRolUsuario {
    Arrendatario,
    Arrendador;

    public static String[] RolUsuario() {
        EnumRolUsuario[] enumRolUsuarios = values();
        String[] tipos = new String[enumRolUsuarios.length];

        for (int i = 0; i < enumRolUsuarios.length; i++) {
            tipos[i] = enumRolUsuarios[i].name();
        }
        return tipos;
    }
}
