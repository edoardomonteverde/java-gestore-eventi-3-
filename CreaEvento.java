import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreaEvento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String titolo;
            while (true) {
                try {
                    System.out.println("Inserisci il titolo dell'evento:");
                    titolo = scanner.nextLine();
                    if (titolo == null || titolo.trim().isEmpty() || titolo.length() > 60) {
                        throw new IllegalArgumentException("Il titolo non può essere nullo, vuoto o superare i 60 caratteri.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            LocalDate data;
            while (true) {
                try {
                    System.out.println("Inserisci la data dell'evento (formato YYYY-MM-DD):");
                    data = LocalDate.parse(scanner.nextLine());

                    if (data.isBefore(LocalDate.now())) {
                        throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
                    }

                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato data non valido. Usa il formato YYYY-MM-DD.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            int postiTotali;
            while (true) {
                try {
                    System.out.println("Inserisci il numero di posti totali:");
                    String input = scanner.nextLine();
                    if (input == null || input.trim().isEmpty()) {
                        throw new IllegalArgumentException("Il numero di posti totali non può essere vuoto.");
                    }
                    postiTotali = Integer.parseInt(input);
                    if (postiTotali <= 0) {
                        throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Inserisci un numero valido per i posti totali.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            Evento evento = new Evento(titolo, data, postiTotali);

            System.out.println("Evento creato: " + evento);

            System.out.println("Vuoi fare una prenotazione? (Y/N):");
            String rispostaPrenotazione;
            while (true) {
                rispostaPrenotazione = scanner.nextLine().trim().toUpperCase();
                if (rispostaPrenotazione.equals("Y") || rispostaPrenotazione.equals("N")) {
                    break;
                } else {
                    System.out.println("Risposta non valida. Inserisci 'Y' o 'N':");
                }
            }

            while (rispostaPrenotazione.equals("Y")) {
                while (true) {
                    try {
                        System.out.println("Quanti posti vuoi prenotare?");
                        int postiDaPrenotare = Integer.parseInt(scanner.nextLine());

                        if (postiDaPrenotare <= 0) {
                            throw new IllegalArgumentException("Il numero di posti da prenotare deve essere positivo.");
                        }
                        if (postiDaPrenotare > (evento.getPostiTotali() - evento.getPostiPrenotati())) {
                            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
                        }

                        for (int i = 0; i < postiDaPrenotare; i++) {
                            evento.prenota();
                        }

                        System.out.println("Posti prenotati con successo.");
                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero valido.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("Vuoi fare un'altra prenotazione? (Y/N):");
                while (true) {
                    rispostaPrenotazione = scanner.nextLine().trim().toUpperCase();
                    if (rispostaPrenotazione.equals("Y") || rispostaPrenotazione.equals("N")) {
                        break;
                    } else {
                        System.out.println("Risposta non valida. Inserisci 'Y' o 'N':");
                    }
                }
            }

            System.out.println("Resoconto attuale:");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            System.out.println("Vuoi disdire una prenotazione? (Y/N):");
            String rispostaDisdetta;
            while (true) {
                rispostaDisdetta = scanner.nextLine().trim().toUpperCase();
                if (rispostaDisdetta.equals("Y") || rispostaDisdetta.equals("N")) {
                    break;
                } else {
                    System.out.println("Risposta non valida. Inserisci 'Y' o 'N':");
                }
            }

            while (rispostaDisdetta.equals("Y")) {
                while (true) {
                    try {
                        System.out.println("Quanti posti vuoi disdire?");
                        int postiDaDisdire = Integer.parseInt(scanner.nextLine());

                        if (postiDaDisdire <= 0) {
                            throw new IllegalArgumentException("Il numero di posti da disdire deve essere positivo.");
                        }
                        if (postiDaDisdire > evento.getPostiPrenotati()) {
                            throw new IllegalArgumentException("Non puoi disdire più posti di quelli prenotati.");
                        }

                        for (int i = 0; i < postiDaDisdire; i++) {
                            evento.disdici();
                        }

                        System.out.println("Posti disdetti con successo.");
                        System.out.println("Resoconto attuale:");
                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero valido.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("Vuoi disdire un'altra prenotazione? (Y/N):");
                while (true) {
                    rispostaDisdetta = scanner.nextLine().trim().toUpperCase();
                    if (rispostaDisdetta.equals("Y") || rispostaDisdetta.equals("N")) {
                        break;
                    } else {
                        System.out.println("Risposta non valida. Inserisci 'Y' o 'N':");
                    }
                }
            }

            System.out.println("Resoconto finale:");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            System.out.println("Grazie per aver usato il sistema di gestione eventi!");
        } catch (Exception e) {
            System.out.println("Si è verificato un errore imprevisto: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}