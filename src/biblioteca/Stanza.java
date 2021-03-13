package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Una stanza è composta da un insieme di scaffali.
 *
 */
public class Stanza implements Cloneable, Serializable{
	private ArrayList<Scaffale> scaffali;
	private char idStanza;
	
	/**
	 * Costruisce una nuova stanza vuota, senza scaffali.
	 */
	public Stanza() {
		scaffali = new ArrayList<Scaffale>();
	}
	
	/**
	 * Crea e aggiunge uno scaffale alla stanza.
	 * @param numeroPosti numero dei posti che dovrà avere il nuovo scaffale.
	 */
	public void aggiungiScaffale(int numeroPosti) {
		Scaffale nuovoScaffale = new Scaffale(idStanza, scaffali.size()+1, numeroPosti);
		scaffali.add(nuovoScaffale);
	}
	
	/**
	 * Imposta l'idStanza.
	 * @param idStanza identificativo univoco della stanza all'interno della biblioteca.
	 */
	public void setIdStanza(char idStanza) {
		this.idStanza = idStanza;
	}
	
	/**
	 * Restituisce il numero di scaffali presenti nella stanza.
	 * @return numero di scaffali nella stanza.
	 */
	public int getNumeroScaffali() {
		return scaffali.size();
	}
	
	/**
	 * Restituisce l'id della stanza.
	 * @return identificativo univoco della stanza.
	 */
	public char getIdStanza() {
		return idStanza;
	}
	
	/**
	 * Calcola la capienza della stanza.
	 * @return capienza totale della stanza.
	 */
	public int getCapienza() {
		int capienza = 0;
		for(Scaffale s : scaffali) {
			capienza += s.getNumeroPosti();
		}
		return capienza;
	}
	
	/**
	 * Restituisce il numero di volumi.
	 * @return Numero di volumi presenti nella stanza.
	 */
	public int getNumeroVolumi() {
		int nVolumi = 0;
		for(Scaffale s : scaffali) {
			nVolumi += s.getNumeroVolumi();
		}
		return nVolumi;
	}
		
	/**
	 * Restituisce insieme degli scaffali.
	 * @return Lista degli scaffali presenti nella stanza.
	 */
	public ArrayList<Scaffale> getScaffali() {
		return scaffali;
	}
	
	/**
	 * Restituisce uno scaffale dato l'indentificativo.
	 * @param id identificativo univoco dello scaffale
	 * @return Uno scaffale della stanza.
	 */
	public Scaffale getScaffale(int id) {
		return scaffali.get(id);
	}
	
	/**
	 * Restituisce una stringa che descrive la stanza e le sue caratteristiche.
	 * @return una stringa che descrive la stanza.
	 */
	public String toString() {
		return getClass().getName() + "[idStanza="+idStanza+", scaffali="+scaffali.toString()+"]";
	}
	
	/**
	 * Controlla se due stanze sono identiche.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se le due stanze sono identiche, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj.getClass() != this.getClass()) return false;
		
		Stanza tmp = (Stanza) obj;
		return tmp.idStanza == idStanza && tmp.scaffali.equals(scaffali);
	}
	
	/**
	 * Crea un oggetto identico a questa istanza.
	 * @return oggetto identico a questa istanza.
	 */
	public Stanza clone() {
		try {
			Stanza cloned = (Stanza) super.clone();
			
			int i=0;
			for(Scaffale s:scaffali) {
				cloned.scaffali.set(i, s.clone());
				i++;
			}
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
