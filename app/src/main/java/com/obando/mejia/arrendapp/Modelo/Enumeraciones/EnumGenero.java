package com.obando.mejia.arrendapp.Modelo.Enumeraciones;

public enum EnumGenero {
    Femenino,
    Masculino;

    public static String[] Genero() {
        EnumGenero[] enumGeneros = values();
        String[] tipos = new String[enumGeneros.length];

        for (int i = 0; i < enumGeneros.length; i++) {
            tipos[i] = enumGeneros[i].name();
        }
        return tipos;
    }

    public static  int GeneroEntero(String generoString)
    {
        switch (generoString)
        {
            case "Femenino" :
                return 0;
            case "Masculino":
                return 1;
            default:
                return 0;
        }
    }

}
