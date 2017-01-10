package com.obando.mejia.arrendapp.Enumeraciones;

public enum EnumTipoArchivo {
    png,
    jpg,
    bmp,
    txt,
    pdf,
    zip,
    docx,
    xlsx,
    xls,
    rar,
    ppt,
    otro;

    public static String[] TipoArchivo() {
        EnumTipoArchivo[] enumTipoArchivos = values();
        String[] tipos = new String[enumTipoArchivos.length];

        for (int i = 0; i < enumTipoArchivos.length; i++) {
            tipos[i] = enumTipoArchivos[i].name();
        }

        return tipos;
    }
}
