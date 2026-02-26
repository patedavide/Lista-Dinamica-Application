package com.example.listadinamica;

public class Lista {

    private Nodo head;
    private Nodo cursor;

    public Lista() {
        head = null;
        cursor = null;
    }

    public void aggiungi(String valore) {
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

    public String visita() {
        if (cursor == null) {
            return null;
        }

        String valore = cursor.value;
        cursor = cursor.next;
        return valore;
    }

    public boolean modifica(String vecchio, String nuovo) {
        Nodo temp = head;

        while (temp != null) {
            if (temp.value.equals(vecchio)) {
                temp.value = nuovo;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public boolean elimina(String valore) {

        if (head == null) {
            return false;
        }

        if (head.value.equals(valore)) {
            head = head.next;
            return true;
        }

        Nodo temp = head;

        while (temp.next != null) {
            if (temp.next.value.equals(valore)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}