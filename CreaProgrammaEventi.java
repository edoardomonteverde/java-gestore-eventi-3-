import java.time.LocalDate;

public class CreaProgrammaEventi {
    public static void main(String[] args) {
        // Creazione di un nuovo programma di eventi
        ProgrammaEventi programma = new ProgrammaEventi("Festival della Musica");

        // Creazione di eventi con date diverse
        Evento evento1 = new Evento("Concerto Rock", LocalDate.of(2026, 6, 15), 100);
        Evento evento2 = new Evento("Concerto Jazz", LocalDate.of(2026, 5, 10), 80);
        Evento evento3 = new Evento("Concerto Pop", LocalDate.of(2026, 7, 20), 120);

        // Aggiunta degli eventi al programma
        programma.aggiungiEvento(evento1);
        programma.aggiungiEvento(evento2);
        programma.aggiungiEvento(evento3);

        // Stampa del programma ordinato per data
        System.out.println(programma.programmaOrdinatoPerData());
    }
}
