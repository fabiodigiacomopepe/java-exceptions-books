package org.lessons.java.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

        // Stampo info ogni libro
        for (Libro singolo_libro : libri) {
            System.out.println(singolo_libro);
            System.out.println("-------------");
        }

        // Setto il workingDir nella mia directory (quindi a ./)
        File workingDir = new File(".");
        // Stampo se la workingDir esiste ed è stata settata
        System.out.println(workingDir.exists());
        // Se esiste ed è settata
        if (workingDir.exists() && workingDir.isDirectory()) {
            // Salvo nell'array files la lista delle cartelle/file della directory
            String[] files = workingDir.list();
            // Stampo nome di ogni cartella/file
            for (String name : files) {
                System.out.println(name);
            }
        }

        // Inizializzo a null il FileWriter
        FileWriter fileWriter = null;
        try {
            // Provo ad aprirlo
            fileWriter = new FileWriter("./resources/data.txt");
            // Provo a scriverci sopra
            for (int i = 0; i < libri.length; i++) {
                fileWriter.write("Libro n." + (i + 1));
                fileWriter.write("\nTitolo: " + libri[i].getTitolo());
                fileWriter.write("\nNumero pagine: " + libri[i].getNumero_pagine());
                fileWriter.write("\nAutore: " + libri[i].getAutore());
                fileWriter.write("\nEditore: " + libri[i].getEditore() + "\n \n");
            }
        } // Se si solleva un'eccezione passo dal catch
        catch (IOException e) {
            System.out.println("Impossibile scrivere sul file.");
        } // Sia che ho terminato il try, sia che sono entrato nel catch passo di qui
        finally {
            try {
                // Se il fileWriter è diverso da null, lo chiudo
                if (fileWriter != null) {
                    System.out.println("Chiudo il file.");
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Provo a leggere il file
        Scanner fileReader = null;
        try {
            // Setto file da leggere
            fileReader = new Scanner(new File("./resources/data.txt"));
            // Creo loop finchè viene trovata una nuova riga
            while (fileReader.hasNextLine()) {
                // Stampo riga
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
