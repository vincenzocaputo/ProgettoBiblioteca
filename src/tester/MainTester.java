package tester;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Stanza;
import eccezioni.EccezionePostoOccupato;
import ordinamento.CriterioOrdinamento;
import ordinamento.CriterioOrdinamentoCollocazione;
import ordinamento.CriterioOrdinamentoTitolo;
import ordinamento.Ordinamento;
import ricerca.CriterioRicerca;
import ricerca.CriterioRicercaStanza;
import ricerca.CriterioRicercaTitolo;
import ricerca.Selettore;

public class MainTester {

	public static void main(String[] args) {
		File file = new File("biblioteca.dat");
		Biblioteca biblioteca = null;
		
		if(file.exists()) {
			System.out.println("Il file esiste. Viene eseguita l'apertura e la lettura del contenuto.");
			try {
				ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
			
				biblioteca = (Biblioteca)objIn.readObject();
				
				objIn.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Il file non esiste. Si crea una nuova biblioteca.");
			biblioteca = new Biblioteca();
			Stanza stanzaA = new Stanza();
			Stanza stanzaB = new Stanza();
			Stanza stanzaC = new Stanza();
			
			biblioteca.aggiungiStanza(stanzaA);
			biblioteca.aggiungiStanza(stanzaB);
			biblioteca.aggiungiStanza(stanzaC);
			
			stanzaA.aggiungiScaffale(10);
			stanzaA.aggiungiScaffale(15);
			stanzaA.aggiungiScaffale(12);
			
			stanzaB.aggiungiScaffale(8);
			stanzaB.aggiungiScaffale(10);
			stanzaB.aggiungiScaffale(11);
			stanzaB.aggiungiScaffale(9);
			
			stanzaC.aggiungiScaffale(13);
			stanzaC.aggiungiScaffale(11);
			stanzaC.aggiungiScaffale(8);
			
			System.out.println("La biblioteca viene popolata.");
			try {
				System.out.println("Inserimento di un libro nella stanza A, scaffale 1, posto 5");
				stanzaA.getScaffale(0).getPosto(4).aggiungiLibro(new Libro("Il barone rampante", "I. Calvino", "SEI", "2007", "Romanzo storico"));
				System.out.println("Inserimento di un libro nella stanza A, scaffale 1, posto 7");
				stanzaA.getScaffale(0).getPosto(6).aggiungiLibro(new Libro("Il fu Mattia Pascal", "L. Pirandello", "Giunti","2006", "Romanzo Psicologico"));
				System.out.println("Inserimento di un libro nella stanza A, scaffale 2, posto 2");
				stanzaA.getScaffale(1).getPosto(1).aggiungiLibro(new Libro("Pinocchio", "C. Collodi", "Cairo", "1998", "Fantastico"));
				System.out.println("Inserimento di un libro nella stanza A, scaffale 2, posto 11");
				stanzaA.getScaffale(1).getPosto(10).aggiungiLibro(new Libro("Una Vita","I. Svevo","Bompiani","2001","Romanzo"));
				System.out.println("Inserimento di un libro nella stanza A, scaffale 3, posto 4");
				stanzaA.getScaffale(2).getPosto(5).aggiungiLibro(new Libro("I promessi sposi","A. Manzoni","Einaudi","2010","Romanzo Storico"));
				System.out.println("Inserimento di un libro nella stanza A, scaffale 3, posto 8");
				stanzaA.getScaffale(2).getPosto(7).aggiungiLibro(new Libro("Se questo è un uomo","P. Levi","Einaudi","2007","Romanzo Storico"));
				
				System.out.println("Inserimento di un libro nella stanza B, scaffale 1, posto 5");
				stanzaB.getScaffale(0).getPosto(4).aggiungiLibro(new Libro("1984","G. Orwell","Mondadori","2010","Fantascienza"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 2, posto 4");
				stanzaB.getScaffale(1).getPosto(3).aggiungiLibro(new Libro("Harry Potter e la pietra filosofale", "J.K. Rowling","Salani","2013","Fantasy"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 2, posto 6");
				stanzaB.getScaffale(1).getPosto(5).aggiungiLibro(new Libro("Harry Potter e il calice di fuoco", "J.K. Rowling","Salani","2014","Fantasy"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 2, posto 7");
				stanzaB.getScaffale(1).getPosto(6).aggiungiLibro(new Libro("Harry Potter e l'ordine della fenice", "J.K. Rowling","Salani","2014","Fantasy"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 3, posto 8");
				stanzaB.getScaffale(2).getPosto(7).aggiungiLibro(new Libro("Trono di spade","R.R. Martin","Mondadori","2014","Fantasy"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 4, posto 3");
				stanzaB.getScaffale(3).getPosto(2).aggiungiLibro(new Libro("Il signore degli anelli","J.R.R. Tolkien","Bompiani","2011","Fantasy"));
				System.out.println("Inserimento di un libro nella stanza B, scaffale 4, posto 5");
				stanzaB.getScaffale(3).getPosto(4).aggiungiLibro(new Libro("Lo hobbit","J.R.R. Tolkien","Bompiani","2012","Fantasy"));

				System.out.println("Inserimento di un libro nella stanza C, scaffale 1, posto 3");
				stanzaC.getScaffale(0).getPosto(2).aggiungiLibro(new Libro("1984","G. Orwell","Mondadori","2015","Fantascienza"));
				System.out.println("Inserimento di un libro nella stanza C, scaffale 1, posto 9");
				stanzaC.getScaffale(0).getPosto(8).aggiungiLibro(new Libro("Robinson Crusoe", "D. Defoe", "Garzanti", "2011", "Avventura"));
				System.out.println("Inserimento di un libro nella stanza C, scaffale 2, posto 5");
				stanzaC.getScaffale(1).getPosto(4).aggiungiLibro(new Libro("1984","G. Orwell","Bompiani","2009","Fantascienza"));
				System.out.println("Inserimento di un libro nella stanza C, scaffale 2, posto 9");
				stanzaC.getScaffale(1).getPosto(8).aggiungiLibro(new Libro("Shining","S. King","Bompiani","2013","Horror"));
				System.out.println("Inserimento di un libro nella stanza C, scaffale 3, posto 5");
				stanzaC.getScaffale(2).getPosto(4).aggiungiLibro(new Libro("Una Vita","G. Maupassant","Solani","2012","Realista"));
			} catch(EccezionePostoOccupato e) {
				e.printStackTrace();
			}
		
		}
		System.out.println("Si elimina il libro presente nella stanza A, scaffale 3, posto 4.");
		biblioteca.getStanza('A').getScaffale(2).getPosto(5).rimuoviLibro();
		
		System.out.println("Si effettua il prestito del libro presente nella stanza A, scaffale 2, posto 2.");
		biblioteca.getStanza('A').getScaffale(1).getPosto(1).effettuaPrestito();
		
		System.out.println("Si effettua il prestito del libro presente nella stanza B, scaffale 3, posto 8.");
		biblioteca.getStanza('B').getScaffale(2).getPosto(7).effettuaPrestito();
		
		System.out.println("Si effettua la restituzione del libro presente nella stanza A, scaffale 2, posto 2.");
		biblioteca.getStanza('A').getScaffale(1).getPosto(1).effettuaRestituzione();
		
		CriterioRicerca criterioTitolo = new CriterioRicercaTitolo("1984");
		CriterioRicerca criterioStanza = new CriterioRicercaStanza('A');
		CriterioOrdinamento criterioOrdinamentoCollocazione = new CriterioOrdinamentoCollocazione();
		CriterioOrdinamento criterioOrdinamentoTitolo = new CriterioOrdinamentoTitolo();
		System.out.println("Si effettua una ricerca con criterio \"Stesso titolo\". Ottengo: ");

		Selettore selettore = new Selettore(biblioteca);
		System.out.println(Arrays.toString(Ordinamento.ordina(selettore.ricerca(criterioTitolo), criterioOrdinamentoCollocazione)));
		System.out.println("Si effettua una ricerca con criterio \"Stessa stanza\". Ottengo: ");
		System.out.println(Arrays.toString(Ordinamento.ordina(selettore.ricerca(criterioStanza), criterioOrdinamentoTitolo)));
		
		System.out.println("Avvio della GUI.");
		new gui.FinestraPrincipale(biblioteca);
	}

}
