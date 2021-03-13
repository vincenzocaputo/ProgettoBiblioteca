package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import biblioteca.Stanza;

/**
 * Finestra che raffigura l'interno della stanza. Mostra delle informazioni generali sulla stanza e permette all'utente
 * di scegliere il posto in cui applicare l'operazione.
 */
public class FinestraStanza extends JFrame{
	private Stanza stanza;
	private int opzione;

	/**
	 * Costruisce una finestra che rappresenta la stanza.
	 * @param stanza stanza da rappresentare.
	 * @param opzione operazione da effettuare.
	 */
	public FinestraStanza(Stanza stanza, int opzione) {
		super("Stanza"+stanza.getIdStanza());
		
		this.stanza = stanza;
		this.opzione = opzione;		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel pannelloDettagli = creaPannelloDettagli();
		JPanel pannelloStanza = creaPannelloStanza();

		add(pannelloDettagli,BorderLayout.NORTH);
		add(pannelloStanza, BorderLayout.CENTER);
		setVisible(true);
		pack();
		
	}
	
	/**
	 * Crea il pannello contenente i dettagli sulla stanza. In particolare l'indetificativo
	 * della stanza e la capienza totale.
	 * @return Pannello con i dettagli della stanza.
	 */
	public JPanel creaPannelloDettagli() {
		JPanel pannello = new JPanel();
		pannello.setBorder(new TitledBorder(new EtchedBorder(), "Dettagli stanza"));
		pannello.setLayout(new GridLayout(2,2));
		
		JLabel etichettaIdStanza = new JLabel(String.valueOf(stanza.getIdStanza()), JLabel.RIGHT);
		JLabel etichettaCapienza = new JLabel(String.valueOf(stanza.getCapienza()), JLabel.RIGHT);
		
		pannello.add(new JLabel("Id Stanza: "));
		pannello.add(etichettaIdStanza);
		pannello.add(new JLabel("Capienza: "));
		pannello.add(etichettaCapienza);
		return pannello;
	}
	
	/**
	 * Crea il pannello con la rappresentazione dei posti nella stanza.
	 * @return Pannello che rappresenta graficamente la stanza.
	 */
	public JPanel creaPannelloStanza() {
		JPanel pannello = new JPanel();
		pannello.setBorder(new TitledBorder(new EtchedBorder(),"Stanza"));
		int numScaffali = stanza.getNumeroScaffali();
		PannelloScaffale[] pannelliScaffali = new PannelloScaffale[numScaffali];
		
		
		pannello.setLayout(new GridLayout(numScaffali,1,10,10));
		for(int i=0; i<numScaffali; i++) {
			pannelliScaffali[i] = new PannelloScaffale(stanza.getScaffale(i), opzione);
			pannello.add(pannelliScaffali[i]);
		}
		return pannello; 
	}

}
