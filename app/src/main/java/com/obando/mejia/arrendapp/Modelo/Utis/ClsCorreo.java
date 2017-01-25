package com.obando.mejia.arrendapp.Modelo.Utis;

/**
 * Created by personal on 24/01/2017.
 */

public class ClsCorreo {
    //region Atributos

    private String fDestinario;
    private String fAsunto;
    private String fCuerpo;

    //endregion Atributos

    //region Metodos
    public ClsCorreo() {
    }

    public String getDestinario() {
        return fDestinario;
    }

    public void setfDestinario(String fDestinario) {
        this.fDestinario = fDestinario;
    }

    public String getfAsunto() {
        return fAsunto;
    }

    public void setfAsunto(String fAsunto) {
        this.fAsunto = fAsunto;
    }

    public String getfCuerpo() {
        return fCuerpo;
    }

    public void setfCuerpo(String fCuerpo) {
        this.fCuerpo = fCuerpo;
    }

    public void mEnviarCorreo() {

    }
    //endregion Metodos
}
