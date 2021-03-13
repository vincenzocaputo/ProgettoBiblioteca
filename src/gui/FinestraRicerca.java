package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.LibroCollocato;
import ordinamento.CriterioOrdinamento;
import ordinamento.CriterioOrdinamentoCollocazione;
import ordinamento.CriterioOrdinamentoTitolo;
import ordinamento.Ordinamento;
import ricerca.CriterioRicerca;
import ricerca.CriterioRicercaStanza;
import ricerca.CriterioRicercaTitolo;
import ricerca.Selettore;

/**
 * Finestra grafica che permette all'utente di effettuare ricerche nella biblioteca.
 */
public class FinestraRicerca extends JFrame{
	private JRadioButton radioRicercaTitolo, radioRicercaStanza, radioRicercaTitoloAutore;
	private JRadioButton radioOrdinamentoTitolo, radioOrdinamentoCollocazione;
	private JPanel pannelloInserimento;
	private JTextField[] chiaviRicerca;
	private JTextArea areaRisultato;
	private JScrollPane barraScorrimento;
	
	/**
	 * Costruisce una nuova finestra per la ricerca dei libri.
	 * @param biblioteca biblioteca in cui cercare i libri.
	 */
	public FinestraRicerca(Biblioteca biblioteca) {
		super("Ricerca");
		
		setLayout(new BorderLayout());
		setSize(800,300);
		
		JPanel pannelloNord = new JPanel();
		JPanel pannelloCentro = new JPanel();
		
		pannelloNord.setLayout(new GridLayout(1,2));
		pannelloCentro.setLayout(new BorderLayout());
		
		JPanel pannelloCriteriRicerca = creaPannelloCriteriRicerca();
		JPanel pannelloCriteriOrdinamento = creaPannelloCriteriOrdinamento();
		JPanel pannelloRisultato = creaPannelloRisultato();
		pannelloInserimento = new JPanel();
		creaPannelloInserimento();
		JPanel pannelloBottoni = creaPannelloBottoni(biblioteca);
		
		pannelloNord.add(pannelloCriteriRicerca);
		pannelloNord.add(pannelloCriteriOrdinamento);
		
		pannelloCentro.add(pannelloInserimento, BorderLayout.CENTER);
		pannelloCentro.add(pannelloBottoni, BorderLayout.SOUTH);
		
		add(pannelloNord, BorderLayout.NORTH);
		add(pannelloCentro, BorderLayout.CENTER);
		add(pannelloRisultato, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Crea un pannello che permette all'utente di scegliere un criterio di ricerca: ricerca per titolo, per stanza e per 
	 * titolo e autore.
	 * @return un pannello che permette all'utente di scegliere un criterio di ricerca.
	 */
	public JPanel creaPannelloCriteriRicerca() {
		JPanel pannello = new JPanel();
		
		pannello.setLayout(new GridLayout(3,1));
		
		radioRicercaTitolo = new JRadioButton("Stesso titolo");
		radioRicercaTitolo.setSelected(true);
		radioRicercaTitolo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				creaPannelloInserimento();
				repaint();
			}
			
		});
		radioRicercaStanza = new JRadioButton("Stessa stanza");
		radioRicercaStanza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				creaPannelloInserimento();
				repaint();
			}
			
		});
		radioRicercaTitoloAutore = new JRadioButton("Stesso titolo e autore");
		radioRicercaTitoloAutore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				creaPannelloInserimento();
				repaint();
			}
			
		});
		
		ButtonGroup gruppoCriteri = new ButtonGroup();
		
		gruppoCriteri.add(radioRicercaTitolo);
		gruppoCriteri.add(radioRicercaStanza);
		gruppoCriteri.add(radioRicercaTitoloAutore);
		
		pannello.add(radioRicercaTitolo);
		pannello.add(radioRicercaStanza);
		pannello.add(radioRicercaTitoloAutore);
		
		return pannello;
	}
	
	/**
	 * Crea un pannello che permette all'utente di scegliere un criterio di ordinamento: ordinamento per titolo e ordinamento
	 * per collocazione.
	 * @return un pannello che permette all'utente di scegliere un criterio di ordinamento.
	 */
	public JPanel creaPannelloCriteriOrdinamento() {
		JPanel pannello = new JPanel();
		
		pannello.setLayout(new GridLayout(3,1));
		
		radioOrdinamentoTitolo = new JRadioButton("Ordina per titolo");
		radioOrdinamentoTitolo.setSelected(true);
		radioOrdinamentoCollocazione = new JRadioButton("Ordina per collocazione");
		
		ButtonGroup gruppoCriteri = new ButtonGroup();
		
		gruppoCriteri.add(radioOrdinamentoTitolo);
		gruppoCriteri.add(radioOrdinamentoCollocazione);
		
		pannello.add(radioOrdinamentoTitolo);
		pannello.add(radioOrdinamentoCollocazione);
		
		return pannello;
	}
	
	/**
	 * Crea un pannello in cui verranno stampati i risultati della ricerca.
	 * @return un pannello in cui appariranno i risultati della ricerca.
	 */
	public JPanel creaPannelloRisultato() {
		JPanel pannello = new JPanel();
		areaRisultato = new JTextArea(6,70);
		

		barraScorrimento = new JScrollPane(areaRisultato);
		pannello.add(barraScorrimento);
		return pannello;
	}
	
	/**
	 * Crea un pannello che permette all'utente di inserire le chiavi di ricerca.
	 */
	public void creaPannelloInserimento() {
		pannelloInserimento.removeAll();
		pannelloInserimento.revalidate();
		
		if(radioRicercaTitolo.isSelected()) {
			chiaviRicerca = new JTextField[1];
			chiaviRicerca[0] = new JTextField(10);
			pannelloInserimento.add(new JLabel("Titolo"));
			pannelloInserimento.add(chiaviRicerca[0]);
		}
		else if(radioRicercaStanza.isSelected()) {
			chiaviRicerca = new JTextField[1];
			chiaviRicerca[0] = new JTextField(1);
			pannelloInserimento.add(new JLabel("Stanza"));
			pannelloInserimento.add(chiaviRicerca[0]);
		}
		else if(radioRicercaTitoloAutore.isSelected()) {
			chiaviRicerca = new JTextField[2];
			chiaviRicerca[0] = new JTextField(10);
			chiaviRicerca[1] = new JTextField(10);
			pannelloInserimento.add(new JLabel("Titolo"));
			pannelloInserimento.add(chiaviRicerca[0]);
			pannelloInserimento.add(new JLabel("Autore"));
			pannelloInserimento.add(chiaviRicerca[1]);
		}
		
	}
	
	/**
	 * Crea un pannello in cui sono presenti bottoni per permettere all'utente di interagire: avviare la ricerca oppure annullare
	 * l'operazione.
	 * @param biblioteca biblioteca in cui effettuare la ricerca.
	 * @return un pannello per avviare o annullare la ricerca.
	 */
	public JPanel creaPannelloBottoni(Biblioteca biblioteca) {
		JPanel pannello = new JPanel();
		
		JButton bottoneOk = new JButton("Ok");
		
		bottoneOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CriterioRicerca c1 = null;
				if(radioRicercaTitolo.isSelected()) {
					String chiave = chiaviRicerca[0].getText();
					c1 = new CriterioRicercaTitolo(chiave);
				}
				else if(radioRicercaStanza.isSelected()) {
					char chiave;
					if(!chiaviRicerca[0].getText().isEmpty())
						chiave = chiaviRicerca[0].getText().charAt(0);
					else
						chiave=' ';
					c1 = new CriterioRicercaStanza(chiave);
				}
				else if(radioRicercaTitoloAutore.isSelected()) {
					String chiave1 = chiaviRicerca[0].getText();
					String chiave2 = chiaviRicerca[1].getText();
					c1 = w -> (w.getLibro().getTitolo().equals(chiave1)&&w.getLibro().getAutore().equals(chiave2));
				}
				CriterioOrdinamento c2 = null;
				if(radioOrdinamentoCollocazione.isSelected()) {
					c2 = new CriterioOrdinamentoCollocazione();
				}
				else if(radioOrdinamentoTitolo.isSelected()) {
					c2 = new CriterioOrdinamentoTitolo();
				}
				Selettore selettore = new Selettore(biblioteca);
				ArrayList<LibroCollocato> risultato = selettore.ricerca(c1);
				if(!risultato.isEmpty()) {
					
					LibroCollocato[] risultatoOrdinato = Ordinamento.ordina(risultato, c2);
					if(risultato.size()<=5)
						barraScorrimento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
					else
						barraScorrimento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						
					areaRisultato.setText("");
					for(Libro l : risultatoOrdinato) {
						areaRisultato.setText(areaRisultato.getText()+l+"\n");
					}
				}
				else
					areaRisultato.setText("Nessun libro trovato");
			}
			
		});
		pannello.add(bottoneOk);
	
		return pannello;
	}
}
