package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Finestra con messaggio.
 *
 */
public class FinestraMessaggio extends JFrame{
	public static final int ALT=100, LUNG=300;
	/**
	 * Costruisce una finestra con un messaggio.
	 * @param msg messaggio da stampare.
	 */
	public FinestraMessaggio(String msg) {
		super();
		setLayout(new GridLayout(2,1));
		add(new JLabel(msg));
		
		JPanel pannello = new JPanel();
		JButton bottoneOk = new JButton("Ok");
		bottoneOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();				
			}
		});
		
		pannello.add(bottoneOk);
		add(pannello);
		setVisible(true);
		this.setSize(LUNG, ALT);
		setAlwaysOnTop(true);
	}
}
