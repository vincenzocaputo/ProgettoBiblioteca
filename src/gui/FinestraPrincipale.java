package gui;

import biblioteca.Biblioteca;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Prima finestra che si apre all'apertura dell'applicazione. Fornisce delle informazioni sulla biblioteca e un piccolo menù
 * che permette di scegliere una tra le tre operazioni: ricerca, gestione e salvataggio.
 *
 */
public class FinestraPrincipale extends JFrame{
	private Biblioteca biblioteca;
	private JLabel etichettaNumeroStanze, etichettaCapienza, etichettaNumeroVolumi;
	
	/**
	 * Costruisce una finestra.
	 * @param biblioteca biblioteca da gestire.
	 */
	public FinestraPrincipale(Biblioteca biblioteca) {
		super("Biblioteca");
		this.biblioteca = biblioteca;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);
		
		JPanel pannelloDescrizione = creaPanelloDescrizione();
		JPanel pannelloMenu = creaPannelloMenu();
		
		setLayout(new BorderLayout());
		add(pannelloDescrizione, BorderLayout.NORTH);
		add(pannelloMenu, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	/**
	 * Crea il pannello in cui apparirà  la descrizione della biblioteca (Numero stanze, capienza e 
	 * numero volumi presenti).
	 * @return Pannello con alcuni dati sulla biblioteca.
	 */
	public JPanel creaPanelloDescrizione() {
		JPanel pannello = new JPanel();
		
		etichettaNumeroStanze = new JLabel(String.valueOf(biblioteca.getNumeroStanze()), JLabel.RIGHT);
		etichettaCapienza = new JLabel(String.valueOf(biblioteca.getCapienza()), JLabel.RIGHT);
		etichettaNumeroVolumi = new JLabel(String.valueOf(biblioteca.getNumeroVolumi()), JLabel.RIGHT);
		
		pannello.setBorder(new TitledBorder(new EtchedBorder(),"Descrizione"));
		pannello.setLayout(new GridLayout(3,2));
		pannello.add(new JLabel("Numero stanze:"));
		pannello.add(etichettaNumeroStanze);
		pannello.add(new JLabel("Capienza: "));
		pannello.add(etichettaCapienza);
		pannello.add(new JLabel("Numero volumi: "));
		pannello.add(etichettaNumeroVolumi);
		return pannello;
		
	}
	
	/**
	 * Aggiorna informazioni sulla biblioteca.
	 */
	public void aggiorna() {
		etichettaNumeroStanze.setText(String.valueOf(biblioteca.getNumeroStanze()));
		etichettaCapienza.setText(String.valueOf(biblioteca.getCapienza()));
		etichettaNumeroVolumi.setText(String.valueOf(biblioteca.getNumeroVolumi()));
	}
	
	/**
	 * Crea il pannello con i 3 bottoni: Gestione, Ricerca e Salvataggio.
	 * @return Pannello provvisto di bottoni, che comporranno il menù generale.
	 */
	public JPanel creaPannelloMenu() {
		JPanel pannello = new JPanel();
		
		JButton bottoneGestione = new JButton("Gestione");
		JButton bottoneRicerca = new JButton("Ricerca");
		JButton bottoneSalvataggio = new JButton("Salvataggio");
		
		bottoneGestione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FinestraGestione(biblioteca);
			}
		});
		bottoneRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FinestraRicerca(biblioteca);
			}
		});
		bottoneSalvataggio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("biblioteca.dat");
				
				try {
					aggiorna();
					ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
					objOut.writeObject(biblioteca);
					
					objOut.close();
				}catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		
		pannello.add(bottoneRicerca);
		pannello.add(bottoneGestione);
		pannello.add(bottoneSalvataggio);
		return pannello;
	}
}
