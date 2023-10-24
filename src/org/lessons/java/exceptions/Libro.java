package org.lessons.java.exceptions;

public class Libro {
    // ATTRIBUTI
    private String titolo;
    private int numero_pagine;
    private String autore;
    private String editore;

    // COSTRUTTORI
    public Libro(String titolo, int numero_pagine, String autore, String editore) throws Exception {
        // Verifico che numero di pagine non sia <=0
        if (titolo.isEmpty()) {
            throw new Exception("Il titolo è obbligatorio.");
        } else if (numero_pagine <= 0) {
            throw new Exception("Il numero delle pagine deve essere maggiore di 0.");
        } else if (autore.isEmpty()) {
            throw new Exception("L'autore è obbligatorio.");
        } else if (editore.isEmpty()) {
            throw new Exception("L'editore è obbligatorio.");
        }

        this.titolo = titolo;
        this.numero_pagine = numero_pagine;
        this.autore = autore;
        this.editore = editore;
    }

    //METODI

    // TITOLO
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if (titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo è obbligatorio.");
        }
        this.titolo = titolo;
    }

    // NUMERO PAGINE
    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        if (numero_pagine <= 0) {
            throw new IllegalArgumentException("Il numero delle pagine deve essere maggiore di 0.");
        }
        this.numero_pagine = numero_pagine;
    }

    // AUTORE
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        if (autore.isEmpty()) {
            throw new IllegalArgumentException("L'autore è obbligatorio.");
        }
        this.autore = autore;
    }

    // EDITORE
    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        if (editore.isEmpty()) {
            throw new IllegalArgumentException("L'editore è obbligatorio.");
        }
        this.editore = editore;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo +
                "\nNumero pagine: " + numero_pagine +
                "\nAutore: " + autore +
                "\nEditore: " + editore;
    }
}
