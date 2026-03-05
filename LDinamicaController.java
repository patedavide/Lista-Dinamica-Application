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

        String valore = input.getText();

        if (!valore.isEmpty()) {
            lista.aggiungi(valore);
            output.setText("Elemento aggiunto: " + valore + "\n");
            input.clear();
        }
    }

    @FXML
    protected void visualizzaClick() {

        output.clear();
        lista.resetIteratore();

        String valore;

        while ((valore = lista.visita()) != null) {
            output.appendText(valore + "\n");
        }
    }

    @FXML
    protected void modificaClick() {

        String vecchio = cercaTxt.getText();
        String nuovo = nuovoTxt.getText();

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

        String valore = cercaTxt.getText();

        if (lista.elimina(valore)) {
            output.setText("Elemento eliminato: " + valore + "\n");
        } else {
            output.setText("Elemento non trovato.\n");
        }

        cercaTxt.clear();
    }

    @FXML
    protected void cercaClick() {

        String valore = cercaTxt.getText();
        boolean trovato = false;

        lista.resetIteratore();
        String elemento;

        while ((elemento = lista.visita()) != null) {
            if (elemento.equals(valore)) {
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