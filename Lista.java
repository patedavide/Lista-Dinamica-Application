package com.example.listadinamica;

public class Lista {

    private Nodo head;
    private Nodo cursor;

    public Lista() {
        head = null;
        cursor = null;
    }

    public void aggiungi(Multa valore) {

        Nodo nuovo = new Nodo(valore);

        if (head == null) {
            head = nuovo;
            return;
        }

        Nodo temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nuovo;
    }

    public void resetIteratore() {
        cursor = head;
    }

    public Multa visita() {

        if (cursor == null)
            return null;

        Multa valore = cursor.value;
        cursor = cursor.next;

        return valore;
    }

    public Multa cerca(int verbale) {

        Nodo temp = head;

        while (temp != null) {

            if (temp.value.getNumeroVerbale() == verbale)
                return temp.value;

            temp = temp.next;
        }

        return null;
    }

    public boolean modifica(int verbale, Multa nuovo) {

        Nodo temp = head;

        while (temp != null) {

            if (temp.value.getNumeroVerbale() == verbale) {
                temp.value = nuovo;
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public boolean elimina(int verbale) {

        if (head == null)
            return false;

        if (head.value.getNumeroVerbale() == verbale) {
            head = head.next;
            return true;
        }

        Nodo temp = head;

        while (temp.next != null) {

            if (temp.next.value.getNumeroVerbale() == verbale) {
                temp.next = temp.next.next;
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}