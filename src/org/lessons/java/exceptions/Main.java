package org.lessons.java.exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializzo lo scanner da tastiera
        Scanner scan = new Scanner(System.in);

        // Chiedo a utente quanti libri vuole aggiungere
        int bookNumber = 0;
        boolean exitNumberBook = false;
        while (!exitNumberBook) {
            // Chiedo numero pagine libro a utente
            System.out.println("Quanti libri vuoi aggiungere?");
            System.out.print("Inserisci un numero: ");
            String bookNumberString = scan.nextLine();
            // Provo a convertire il numero ricevuto dallo scanner in un intero
            try {
                bookNumber = Integer.parseInt(bookNumberString);
                // Se riesco a convertire ed è maggiore di 0
                if (bookNumber > 0) {
                    exitNumberBook = true;
                } // Altrimenti
                else {
                    System.out.println("Inserire un numero maggiore di 0.");
                    exitNumberBook = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserire un numero.");
                exitNumberBook = false;
            }
        }

        // Creo array di libri con numero preso da input utente tramite scanner
        Libro[] libri = new Libro[bookNumber];

        for (int i = 0; i < libri.length; i++) {
            // Inizializzo bookNumeroPagineString e bookNumeroPagine
            // Per usarli sia nel try che nel catch
            String bookNumeroPagineString = "";
            int bookNumeroPagine = 0;

            // Inizializzo condizione per uscire dal ciclo while uguale a false
            boolean exit = false;

            // Creo loop finchè exit non diventa true
            while (!exit) {
                try {
                    // Chiedo titolo libro a utente
                    System.out.print("Inserisci il titolo: ");
                    String bookTitolo = scan.nextLine();

                    boolean exitPagine = false;
                    while (!exitPagine) {
                        // Chiedo numero pagine libro a utente
                        System.out.print("Inserisci il numero delle pagine: ");
                        bookNumeroPagineString = scan.nextLine();
                        try {
                            bookNumeroPagine = Integer.parseInt(bookNumeroPagineString);
                            exitPagine = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserire un numero.");
                            exitPagine = false;
                        }
                    }

                    // Chiedo autore libro a utente
                    System.out.print("Inserisci l'autore: ");
                    String bookAutore = scan.nextLine();

                    // Chiedo editore libro a utente
                    System.out.print("Inserisci l'editore: ");
                    String bookEditore = scan.nextLine();

                    // Creo un nuovo oggetto libro
                    Libro libro = new Libro(bookTitolo, bookNumeroPagine, bookAutore, bookEditore);
                    libri[i] = libro;

                    // Setto exit a true per uscire dal loop
                    exit = true;
                } catch (Exception e) {
                    // Stampo il messaggio di errore;
                    System.out.println(e.getMessage());
                    exit = false;
                }
            }

            System.out.println("-------------");
        }

        // Chiudo lo scanner da tastiera
        scan.close();

        //Stampo info ogni libro
        for (Libro singolo_libro : libri) {
            System.out.println(singolo_libro);
            System.out.println("-------------");
        }
    }
}
