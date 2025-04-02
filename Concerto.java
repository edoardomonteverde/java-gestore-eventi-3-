
/* Creare una [classe Concerto] che [estende Evento],
*  che ha anche gli [attributi] :
 - ora (LocalTime)
 - prezzo (double)

* Aggiungere questi attributi nel [costruttore] e implementarne getter e setter.

* Aggiungere i [metodi] per restituire:
 - data e ora formattata
 - e prezzo formattato (##,##€) 

* Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo:
- data
- ora formattata
- titolo 
- prezzo formattato

 */

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Concerto extends Evento {
    private final LocalTime ora;
    private final double prezzo;

    public Concerto(String titolo, LocalDate data, LocalTime ora, int postiTotali, double prezzo) {
        super(titolo, data, postiTotali);
        if (ora == null) {
            throw new IllegalArgumentException("L'ora non può essere null.");
        }
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero.");
        }
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getOraFormattata() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(timeFormatter);
    }


    public String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        return df.format(prezzo);
    }

  
    @Override
    public String toString() {
        return super.toString() + " - " + getOraFormattata() + " - " + getPrezzoFormattato();
    }
}
