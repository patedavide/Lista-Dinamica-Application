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

    public int getNumeroVerbale() {
        return numeroVerbale;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Multa m = (Multa) obj;

        return this.numeroVerbale == m.numeroVerbale;
    }

    @Override
    public String toString() {

        return "Nominativo: " + nominativo +
                " | Documento: " + numeroDocumento +
                " | Importo: " + importo +
                " | Verbale: " + numeroVerbale;
    }
}