package com.example.listadinamica;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LDinamicaController {

    @FXML
    private TextField txtInserisci;

    @FXML
    private TextField txtCerca;

    @FXML
    private TextField txtNuovo;

    @FXML
    private TextArea txtOutput;

    private Lista lista = new Lista();

    @FXML
    protected void onAggiungiClick() {

        String valore = txtInserisci.getText();

        if (!valore.isEmpty()) {
            lista.aggiungi(valore);
            txtOutput.setText("Elemento aggiunto!\n");
            txtInserisci.clear();
        }
    }

    @FXML
    protected void onVisualizzaClick() {

        txtOutput.clear();
        lista.resetIteratore();

        String valore;

        while ((valore = lista.visita()) != null) {
            txtOutput.appendText(valore + "\n");
        }
    }

    @FXML
    protected void onModificaClick() {

        String vecchio = txtCerca.getText();
        String nuovo = txtNuovo.getText();

        if (lista.modifica(vecchio, nuovo)) {
            txtOutput.setText("Modifica effettuata!\n");
        } else {
            txtOutput.setText("Elemento non trovato.\n");
        }

        txtCerca.clear();
        txtNuovo.clear();
    }

    @FXML
    protected void onEliminaClick() {

        String valore = txtCerca.getText();

        if (lista.elimina(valore)) {
            txtOutput.setText("Elemento eliminato!\n");
        } else {
            txtOutput.setText("Elemento non trovato.\n");
        }

        txtCerca.clear();
    }
}