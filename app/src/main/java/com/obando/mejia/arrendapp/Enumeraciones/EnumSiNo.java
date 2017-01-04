package com.obando.mejia.arrendapp.Enumeraciones;

/**
 * Created by personal on 04/01/2017.
 */

public enum EnumSiNo {
    Sí,
    No;
    public static String[] SiNO() {
        EnumSiNo[] enumSiNo = values();
        String[] tipos = new String[enumSiNo.length];

        for (int i = 0; i < enumSiNo.length; i++) {
            tipos[i] = enumSiNo[i].name();
        }

        return tipos;
    }
}
