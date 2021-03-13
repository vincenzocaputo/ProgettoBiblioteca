package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import biblioteca.Scaffale;

/**
 * Pannello che rappresenta uno scaffale.
 *
 */
public class PannelloScaffale extends JPanel {
	private Scaffale scaffale; 
	
	/**
	 * Costruisce un PannelloScaffale, con un bottone per ogni posto.
	 * @param scaffale scaffale da rappresentare nel pannello.
	 * @param opzione operazione da eseguire.
	 */
	public PannelloScaffale(Scaffale scaffale, int opzione) {
		super();
		this.scaffale = scaffale;
		setLayout(new GridLayout(1, scaffale.getNumeroPosti()));
		setBorder(new TitledBorder(new EtchedBorder(), "Scaffale "+scaffale.getIdScaffale()));
		setBackground(new Color(183,112,0));
		
		for(int i=0; i<scaffale.getNumeroPosti(); i++) {

			ComponentePosto pp = new ComponentePosto(scaffale.getPosto(i), opzione);
			
			add(pp);

		}
	}
}
