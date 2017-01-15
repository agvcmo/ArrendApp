package com.obando.mejia.arrendapp.Enumeraciones;

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

    public static  int RolUsuarioEntero(String rolUsuarioString)
    {
        switch (rolUsuarioString)
        {
            case "Arrendatario" :
                return 0;
            case "Arrendador":
                return 1;
            default:
                return 0;
        }
    }
}
