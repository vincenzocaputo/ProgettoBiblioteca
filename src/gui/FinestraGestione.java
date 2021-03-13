package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import biblioteca.Biblioteca;
import biblioteca.Stanza;

/**
 * Finestra di gestione che permette all'utente di scegliere la stanza e l'operazione da effettuare.
 *
 */
public class FinestraGestione extends JFrame {
	private JComboBox<Character> sceltaStanza;
	private JRadioButton radioAggiunta, radioRimozione, radioPrestito, radioRestituzione, radioDettagli;
	
	/**
	 * Costruisce una nuova finestra per la gestione.
	 * @param biblioteca biblioteca in cui effettuare le operazioni.
	 */
	public FinestraGestione(Biblioteca biblioteca) {
		super("Gestione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		JPanel pannelloMenu = creaPannelloMenu(biblioteca);
		
		setLayout(new BorderLayout());
		add(pannelloMenu, BorderLayout.NORTH);
		
		setVisible(true);
		pack();
	}

	/**
	 * Crea il pannello con il menù della gestione. Sarà  composto da un menù per la scelta della 
	 * stanza e da un menù per la scelta dell'operazione.
	 * @param biblioteca biblioteca di riferimento.
	 * @return Pannello con menù.
	 */
	public JPanel creaPannelloMenu(Biblioteca biblioteca) {
		JPanel pannello = new JPanel();
		JPanel pannelloMenu = new JPanel();
		JPanel pannelloSceltaStanza = new JPanel();
		JPanel pannelloSceltaOpzione = new JPanel();
		JPanel pannelloBottoni = new JPanel();
		
		
		pannello.setLayout(new BorderLayout());
		
		pannelloMenu.setLayout(new GridLayout(1,2));
		pannelloSceltaStanza.setBorder(new TitledBorder(new EtchedBorder(), "Scegli stanza"));
		sceltaStanza = new JComboBox<Character>();
		for(Stanza s : biblioteca.getStanze()) {
			sceltaStanza.addItem(s.getIdStanza());
		}
		
		pannelloSceltaStanza.add(sceltaStanza);
		
		pannelloSceltaOpzione.setBorder(new TitledBorder(new EtchedBorder(), "Scegli opzione"));
		pannelloSceltaOpzione.setLayout(new GridLayout(5,1));
		
		radioAggiunta = new JRadioButton("Aggiungi");
		radioAggiunta.setSelected(true);
		radioRimozione = new JRadioButton("Rimuovi");
		radioPrestito = new JRadioButton("Prestito");
		radioRestituzione = new JRadioButton("Restituzione");
		radioDettagli = new JRadioButton("Dettagli");
		ButtonGroup gruppoOpzioni = new ButtonGroup();
		gruppoOpzioni.add(radioAggiunta);
		gruppoOpzioni.add(radioRimozione);
		gruppoOpzioni.add(radioRimozione);
		gruppoOpzioni.add(radioPrestito);
		gruppoOpzioni.add(radioRestituzione);
		gruppoOpzioni.add(radioDettagli);
		
		pannelloSceltaOpzione.add(radioAggiunta);
		pannelloSceltaOpzione.add(radioRimozione);
		pannelloSceltaOpzione.add(radioPrestito);
		pannelloSceltaOpzione.add(radioRestituzione);
		pannelloSceltaOpzione.add(radioDettagli);
		
		pannelloMenu.add(pannelloSceltaStanza);
		pannelloMenu.add(pannelloSceltaOpzione);
		
		JButton bottoneOk = new JButton("Ok");
		JButton bottoneAnnulla = new JButton("Annulla");
		bottoneOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opzione = 0;
				if(radioAggiunta.isSelected())
					opzione = 1;
				else if(radioRimozione.isSelected())
					opzione = 2;
				else if(radioPrestito.isSelected())
					opzione = 3;
				else if(radioRestituzione.isSelected())
					opzione = 4;
				else if(radioDettagli.isSelected())
					opzione = 5;
				new FinestraStanza(biblioteca.getStanza((char)sceltaStanza.getSelectedItem()),opzione);
				dispose();
			}
			
		});
		
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { dispose();	}
		});
		
		pannelloBottoni.add(bottoneOk);
		pannelloBottoni.add(bottoneAnnulla);
		pannello.add(pannelloMenu, BorderLayout.CENTER);
		pannello.add(pannelloBottoni, BorderLayout.SOUTH);
		return pannello;
	}
	
}
