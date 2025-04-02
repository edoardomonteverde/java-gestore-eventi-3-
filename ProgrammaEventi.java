/* Creare una classe ProgrammaEventi con i seguenti attributi: 
- titolo: String
- eventi: List<Evento>

* Nel costruttore:
- valorizzare il titolo, passato come parametro
- inizializzare la lista di eventi come una nuova ArrayList

* Aggiungere i seguenti metodi :
- un metodo che aggiunge alla lista un Evento, passato come parametro
- un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
- un metodo che restituisce quanti eventi sono presenti nel programma
- un metodo che svuota la lista di eventi
- un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
- - data1 - titolo1
- - data2 - titolo2 
…
 */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    // Costruttore
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Metodo per aggiungere un evento alla lista
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    
}

    // Metodo che restituisce una lista di eventi presenti in una certa data
public List<Evento> getEventiPerData(LocalDate data) {
    List<Evento> eventiFilitrati = new ArrayList<>();
    for (Evento evento : eventi) {
        if (evento.getData().equals(data)) {
            eventiFilitrati.add(evento);
        }
    }
    return eventiFilitrati;
}

    // Metodo che restituisce il numero di eventi presenti nel programma
public int numeroEventi() {
    return eventi.size();
}

    // Metodo che svuota la lista di eventi presenti nel programma
public void svuotaEventi() {
    eventi.clear();
}

    // Metodo che restituisce il programma ordinato per data utilizzando una nuova lista
    public String programmaOrdinatoPerData() {
        String risultato = "Programma: " + titolo + "\n";

        // Creazione di una nuova lista e copia degli eventi originali
        List<Evento> eventiOrdinati = new ArrayList<>(eventi);

        // Ordinamento della nuova lista per data
        eventiOrdinati.sort(Comparator.comparing(Evento::getData));

        // Costruzione della stringa con gli eventi ordinati
        for (Evento evento : eventiOrdinati) {
            risultato += evento.getDataFormattata() + " - " + evento.getTitolo() + "\n";
        }

        return risultato;
    }
}


