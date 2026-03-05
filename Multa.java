package com.example.listadinamica;

public class Multa {

    private String nominativo;
    private String numeroDocumento;
    private float importo;
    private int numeroVerbale;

    public Multa(String nominativo, String numeroDocumento, float importo, int numeroVerbale) {
        this.nominativo = nominativo;
        this.numeroDocumento = numeroDocumento;
        this.importo = importo;
        this.numeroVerbale = numeroVerbale;
    }

    public String getNominativo() {
        return nominativo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public float getImporto() {
        return importo;
    }

    public int getNumeroVerbale() {
        return numeroVerbale;
    }

        @Override
    public String toString() {
        return "Multa[" + "nominativo='" + nominativo + '\'' + ", numeroDocumento='" + numeroDocumento + '\'' + ", importo=" + importo + ", numeroVerbale=" + numeroVerbale + ']';
    }

}
