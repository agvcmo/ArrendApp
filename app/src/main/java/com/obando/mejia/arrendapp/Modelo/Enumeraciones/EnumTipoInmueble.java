package com.obando.mejia.arrendapp.Modelo.Enumeraciones;

public enum EnumTipoInmueble {
    Apartamento,
    ApartaEstudio,
    Casa,
    Finca,
    Parqueadero;

    public static String[] TiposInmuebles() {
        EnumTipoInmueble[] enumTipoInmuebles = values();
        String[] tipos = new String[enumTipoInmuebles.length];

        for (int i = 0; i < enumTipoInmuebles.length; i++) {
            tipos[i] = enumTipoInmuebles[i].name();
        }

        return tipos;
    }
}


