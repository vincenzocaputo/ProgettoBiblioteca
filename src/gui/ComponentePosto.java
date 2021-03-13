package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import biblioteca.LibroCollocato.Stato;
import biblioteca.PostoScaffale;

/**
 * Componente che rappresenta graficamente un posto.
 *
 */
public class ComponentePosto extends JButton{
	private PostoScaffale posto;
	
	/**
	 * Costruisce un ComponentePosto.
	 * @param posto posto da rappresentare.
	 * @param opzione operazione da eseguire.
	 */
	public ComponentePosto(PostoScaffale posto, int opzione) {
		super();
		this.posto = posto;
		setToolTipText("Posto: "+posto.getIdPosto());
		setPreferredSize(new Dimension(30,30));
		//if(posto.getLibro()!=null || opzione==1) {
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FinestraDialogo(posto, opzione);
				}
				
			});
		//}
	}
	
	/**
	 * Disegna graficamente il posto. In particolare sarà bianco se il posto è libero, rosso se è occupato da un libro prestato
	 * e verde se è occupato da un libro disponibile.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(0,0, getWidth(), getHeight());
		if(posto.getLibro() == null)
			g2.setColor(Color.WHITE);
		else if(posto.getLibro().getStato() == Stato.PRESTATO) 
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.GREEN);
		g2.draw(box);
		g2.fill(box);
	}
}
