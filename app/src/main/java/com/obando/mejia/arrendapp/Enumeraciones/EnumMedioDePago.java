package com.obando.mejia.arrendapp.Enumeraciones;

public enum EnumMedioDePago {
    Efectivo,
    TargetaCredito,
    TargetaDebito,
    Cheque;

    public static String[] MedioDePago() {
        EnumMedioDePago[] enumMedioDePagos = values();
        String[] tipos = new String[enumMedioDePagos.length];

        for (int i = 0; i < enumMedioDePagos.length; i++) {
            tipos[i] = enumMedioDePagos[i].name();
        }
        return tipos;
    }


}
