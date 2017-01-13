package com.obando.mejia.arrendapp.Modelo.Enumeraciones;

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
