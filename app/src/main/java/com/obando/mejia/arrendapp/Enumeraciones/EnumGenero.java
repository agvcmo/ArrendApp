package com.obando.mejia.arrendapp.Enumeraciones;

public enum EnumGenero{
    Femenino,
    Masculino;

    public String[] retornarEnumeracion() {
        EnumGenero[] enumGeneros = values();
        String[] tipos = new String[enumGeneros.length];

        for (int i = 0; i < enumGeneros.length; i++) {
            tipos[i] = enumGeneros[i].name();
        }
        return tipos;
    }

}
