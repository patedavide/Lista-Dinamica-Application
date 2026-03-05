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

    @FXML
    protected void aggiungiClick() {

        Multa multa = input.getText();

        if (!multa.isEmpty()) {
            lista.aggiungi(multa);
            output.setText("Elemento aggiunto: " + multa + "\n");
            input.clear();
        }
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
    protected void modificaClick() {

        Multa vecchio = cercaTxt.getText();
        Multa nuovo = nuovoTxt.getText();

        if (lista.modifica(vecchio, nuovo)) {
            output.setText("Elemento modificato: " + vecchio + "\n" + "Elemento nuovo: " + nuovo + "\n");
        } else {
            output.setText("Elemento non trovato.\n");
        }

        cercaTxt.clear();
        nuovoTxt.clear();
    }

    @FXML
    protected void eliminaClick() {

        Multa multa = cercaTxt.getText();

        if (lista.elimina(multa)) {
            output.setText("Elemento eliminato: " + multa + "\n");
        } else {
            output.setText("Elemento non trovato.\n");
        }

        cercaTxt.clear();
    }

    @FXML
    protected void cercaClick() {

        Multa multa = cercaTxt.getText();
        boolean trovato = false;

        lista.resetIteratore();
        Multa elemento;

        while ((elemento = lista.visita()) != null) {
            if (elemento.equals(multa)) {
                output.setText("Elemento trovato: " + elemento + "\n");
                trovato = true;
                break;
            }
        }

        if (!trovato) {
            output.setText("Elemento non trovato.\n");
        }

        cercaTxt.clear();
    }
}