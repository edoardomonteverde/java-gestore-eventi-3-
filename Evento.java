/*

* Creare una [classe Evento] che abbia le seguenti proprietà [attributi]:

- titolo
- data
- numero di posti in totale
- numero di posti prenotati

* Quando si istanzia un nuovo evento questi [attributi] devono essere tutti valorizzati nel [costruttore],

  tranne ( posti prenotati ) che va inizializzato a 0.

* Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. 

* In caso contrario il programma deve lanciare una eccezione. (nel costruttore e nel setter)

* Aggiungere [metodi getter e setter ] in modo che:
* titolo sia in lettura e in scrittura
* data sia in lettura e scrittura
* numero di posti totale sia solo in lettura
* numero di posti prenotati sia solo in lettura

* Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:

 - prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve restituire un’eccezione.

 - disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce un’eccezione.

 - l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo

* Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.

*/

// Classe Evento
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    // Costruttore con parametri
    public Evento ( String titolo, LocalDate data, int postiTotali) {

            // Controlli sui parametri
            if (titolo == null || titolo.trim().isEmpty() || titolo.length() > 60) {
                throw new IllegalArgumentException("Il titolo non può essere nullo, vuoto, o superare ai 60 caratteri. ");
                }
            if (data.isBefore(LocalDate.now())){
                throw new IllegalArgumentException(" La data dell'evento non può essere nel passato. ");
                }
            if (postiTotali <= 0 || Integer.toString(postiTotali).trim().isEmpty()) {
                throw new IllegalArgumentException (" Il numero dei posti totali deve essere positivo. ");
            }
    
            // Assegnazione dei parametri alle variabili d'istanza
            this.titolo = titolo;
            this.data = data;
            this.postiTotali = postiTotali;
            this.postiPrenotati = 0;

    }

    // Getters e Setters

    public String getTitolo () {
        return titolo;
    }

    public void setTitolo (String titolo) {
        if (titolo == null || titolo.trim().isEmpty() || titolo.length() > 60) {
            throw new IllegalArgumentException(" Il titolo non può essere nullo, vuoto o superare i 60 caratteri");
        }
        this.titolo = titolo;
    }

    public LocalDate getData () {
        return data;
    }

    public String getDataFormattata() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(dateFormatter);
    }

    public void setData (LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException (" La data dell' evento non può essere nel passato");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // Metodi 

    public void prenota () {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException ( "Non è possibile prenotare un evento già passato");
        }
        if (postiTotali - postiPrenotati <= 0) {
            throw new IllegalStateException ("Non ci sono abbastanza posti disponibili. ");
        }
        postiPrenotati++;
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Non è possibile disdire un evento già passato.");
        }
        if (postiPrenotati <= 0) {
            throw new IllegalStateException("Non ci sono prenotazioni da disdire.");
        }
        postiPrenotati -= 1;
    }

    @Override
public String toString() {
    return titolo + " - " + getDataFormattata();
}

    

}
