package com.example.listadinamica;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LDinamicaController {

    @FXML
    private TextField input;

    @FXML
    private TextField cercaTxt;

    @FXML
    private TextField nuovoTxt;

    @FXML
    private TextArea output;

    private Lista lista = new Lista();

    private Multa creaMulta(String testo) {

        String[] dati = testo.split(",");

        String nominativo = dati[0];
        String documento = dati[1];
        float importo = Float.parseFloat(dati[2]);
        int verbale = Integer.parseInt(dati[3]);

        return new Multa(nominativo, documento, importo, verbale);
    }

    @FXML
    protected void aggiungiClick() {

        Multa multa = creaMulta(input.getText());

        lista.aggiungi(multa);

        output.setText("Elemento aggiunto:\n" + multa);

        input.clear();
    }

    @FXML
    protected void visualizzaClick() {

        output.clear();

        lista.resetIteratore();

        Multa multa;

        while ((multa = lista.visita()) != null) {
            output.appendText(multa + "\n");
        }
    }

    @FXML
    protected void cercaClick() {

        int verbale = Integer.parseInt(cercaTxt.getText());

        Multa trovata = lista.cerca(verbale);

        if (trovata != null)
            output.setText("Elemento trovato:\n" + trovata);
        else
            output.setText("Elemento non trovato");

        cercaTxt.clear();
    }

    @FXML
    protected void eliminaClick() {

        int verbale = Integer.parseInt(cercaTxt.getText());

        if (lista.elimina(verbale))
            output.setText("Elemento eliminato");
        else
            output.setText("Elemento non trovato");

        cercaTxt.clear();
    }

    @FXML
    protected void modificaClick() {

        int verbale = Integer.parseInt(cercaTxt.getText());

        Multa nuova = creaMulta(nuovoTxt.getText());

        if (lista.modifica(verbale, nuova))
            output.setText("Elemento modificato");
        else
            output.setText("Elemento non trovato");

        cercaTxt.clear();
        nuovoTxt.clear();
    }
}