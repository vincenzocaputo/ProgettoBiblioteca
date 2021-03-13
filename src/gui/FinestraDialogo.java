package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.Libro;
import biblioteca.LibroCollocato;
import biblioteca.LibroCollocato.Stato;
import biblioteca.PostoScaffale;
import eccezioni.EccezionePostoOccupato;

/**
 * Finestra di dialogo che permette all'utente di interagire con l'applicazione.
 *
 */
public class FinestraDialogo extends JFrame {
	private JTextField campoTitolo, campoAutore, campoEditore, campoAnno, campoGenere;
	
	/**
	 * Costruisce una nuova finestrad di dialogo.
	 * @param posto posto della biblioteca in cui effettuare un' operazione.
	 * @param opzione operazione da effettuare.
	 */
	public FinestraDialogo(PostoScaffale posto, int opzione) {
		super("Dialogo");
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel pannelloNord = new JPanel();
		JPanel pannelloCentro = new JPanel();
		JPanel pannelloSud = new JPanel();
		
		JLabel etichettaInfo = new JLabel();
		
		if(opzione==1) {  //Inserimento
			etichettaInfo.setText("Inserisci i dati del libro");
			pannelloCentro = creaPannelloInserimento();
		} 
		else if(opzione==2) { //Rimozione
			if(posto.getLibro()==null) {
				new FinestraMessaggio("Il posto è vuoto.");
				dispose();
			}
			else {
				etichettaInfo.setText("Sei sicuro di voler eliminare questo libro?");
				pannelloCentro = creaPannelloDettagli(posto.getLibro()); 
			}
		}
		else if(opzione==3) { //Prestito
			if(posto.getLibro()==null) {
				new FinestraMessaggio("Il posto è vuoto.");
				dispose();
			}
			else if(posto.getLibro().getStato()==Stato.PRESTATO) {
				new FinestraMessaggio("Il libro è già prestato.");
				dispose();
			}
			else {
				etichettaInfo.setText("Sei sicuro di voler prestare questo libro? ");
				pannelloCentro = creaPannelloDettagli(posto.getLibro());
			}
		}
		else if(opzione==4) { //Restituzione
			if(posto.getLibro()==null) {
				new FinestraMessaggio("Il posto è vuoto.");
				dispose();
			}
			else if(posto.getLibro().getStato()==Stato.DISPONIBILE) {
				new FinestraMessaggio("Il libro è già disponibile.");
				dispose();
			}
			else {
				etichettaInfo.setText("Sei sicuro di voler restituire questo libro?");
				pannelloCentro = creaPannelloDettagli(posto.getLibro());
			}
		}
		else if(opzione==5) { //Dettagli
			if(posto.getLibro()==null) {
				new FinestraMessaggio("Il posto è vuoto.");
				dispose();
			}
			else {
				etichettaInfo.setText("Dettagli libro");
				pannelloCentro = creaPannelloDettagli(posto.getLibro());
			}
		}
		
		pannelloNord.add(etichettaInfo);
		
		
		JButton bottoneOk = new JButton("Ok");
		JButton bottoneAnnulla = new JButton("Annulla");
		
		bottoneOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(opzione) {
					case 1: {
						try {
							posto.aggiungiLibro(new Libro(campoTitolo.getText(), campoAutore.getText(), campoEditore.getText(), campoAnno.getText(), campoGenere.getText()));
						}catch(EccezionePostoOccupato ex) {
							new FinestraMessaggio("Il posto è occupato. Scegli una posizione libera.");
							dispose();
						}
					}break;
					case 2: {
						posto.rimuoviLibro();
					}break;
					case 3: {
						posto.effettuaPrestito();
					}break;
					case 4: {
						posto.effettuaRestituzione();
					}break;
				}
				dispose();
			}
			
		});
		
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		pannelloSud.add(bottoneOk);
		pannelloSud.add(bottoneAnnulla);
		
		add(pannelloNord, BorderLayout.NORTH);
		add(pannelloCentro, BorderLayout.CENTER);
		add(pannelloSud, BorderLayout.SOUTH);
		pack();
	}

	/**
	 * Crea un pannello che permette all'utente di inserire dati.
	 * @return un pannello con un modulo da compilare.
	 */
	public JPanel creaPannelloInserimento() {
		campoTitolo = new JTextField();
		campoAutore = new JTextField();
		campoEditore = new JTextField();
		campoAnno = new JTextField();
		campoGenere = new JTextField();
		
		JPanel pannelloModulo = new JPanel();
		
		pannelloModulo.setLayout(new GridLayout(5,2));
		pannelloModulo.add(new JLabel("Titolo: "));
		pannelloModulo.add(campoTitolo);
		pannelloModulo.add(new JLabel("Autore: "));
		pannelloModulo.add(campoAutore);
		pannelloModulo.add(new JLabel("Casa Editrice: "));
		pannelloModulo.add(campoEditore);
		pannelloModulo.add(new JLabel("Anno: "));
		pannelloModulo.add(campoAnno);
		pannelloModulo.add(new JLabel("Genere: "));
		pannelloModulo.add(campoGenere);
		
		return pannelloModulo;
	}
	
	/**
	 * Crea un pannello che riporta i dettagli di un libro.
	 * @param libro libro di cui stampare i dettagli.
	 * @return un pannello che riporta i dettagli del libro.
	 */
	public JPanel creaPannelloDettagli(LibroCollocato libro) {
		JPanel pannello = new JPanel();
		pannello.setLayout(new GridLayout(6,2));
		
		pannello.add(new JLabel("Titolo: "));
		pannello.add(new JLabel(libro.getTitolo()));
		pannello.add(new JLabel("Autore: "));
		pannello.add(new JLabel(libro.getAutore()));
		pannello.add(new JLabel("Casa Editrice: "));
		pannello.add(new JLabel(libro.getCasaEditrice()));
		pannello.add(new JLabel("Anno pubblicazione: "));
		pannello.add(new JLabel(libro.getAnno()));
		pannello.add(new JLabel("Genere: "));
		pannello.add(new JLabel(libro.getGenere()));
		pannello.add(new JLabel("Stato: "));
		pannello.add(new JLabel(String.valueOf(libro.getStato())));
		return pannello;
	}
}
