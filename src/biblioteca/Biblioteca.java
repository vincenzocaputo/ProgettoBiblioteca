package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Una biblioteca è composta da un insieme di stanze. 
 *
 */
public class Biblioteca implements Cloneable, Serializable{
	private ArrayList<Stanza> stanze;
	
	/**
	 * Costruisce una nuova biblioteca vuota, senza stanze.
	 */
	public Biblioteca() {
		stanze = new ArrayList<Stanza>();
	}

	/**
	 * Aggiunge una stanza alla biblioteca.
	 * @param nuovaStanza nuova stanza da aggiungere alla biblioteca.
	 */
	public void aggiungiStanza(Stanza nuovaStanza) {
		nuovaStanza.setIdStanza((char)(stanze.size()+65));
		stanze.add(nuovaStanza);
	}
	
	/**
	 * Restituisce il numero di stanze presenti nella biblioteca.
	 * @return numero di stanze.
	 */
	public int getNumeroStanze() {
		return stanze.size();
	}
	
	/**
	 * Calcola la capienza della biblioteca.
	 * @return capienza totale della biblioteca
	 */
	public int getCapienza() {
		int capienza = 0;
		for(Stanza s : stanze) {
			capienza += s.getCapienza();
		}
		return capienza;
	}
	
	/**
	 * Restituisce il numero dei volumi presenti.
	 * @return numero dei volumi presenti in biblioteca.
	 */
	public int getNumeroVolumi() {
		int nVolumi = 0;
		for(Stanza s : stanze) {
			nVolumi += s.getNumeroVolumi();
		}
		return nVolumi;
	}

	/**
	 * Restituisce la lista delle stanze.
	 * @return lista delle stanze presenti in biblioteca.
	 */
	public ArrayList<Stanza> getStanze() {
		return stanze;
	}
	
	/**
	 * Restituisce una determinata stanza.
	 * @param id identificativo stanza.
	 * @return una stanza.
	 */
	public Stanza getStanza(char id) {
		return stanze.get(id-65);
	}
	
	/**
	 * Restituisce la stringa che descrive la biblioteca.
	 * @return una stringa che descrive la biblioteca.
	 */
	public String toString() {
		return getClass().getName() + "[stanze="+stanze.toString()+"]";
	}
	
	/**
	 * Controlla se due biblioteche sono uguali.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se le biblioteche sono uguali, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj.getClass() != this.getClass()) return false;
		
		Biblioteca tmp = (Biblioteca) obj;
		return tmp.stanze.equals(stanze);
	}
	
	/**
	 * Crea una nuova biblioteca identica a questa istanza.
	 * @return un clone di questa istanza.
	 */
	public Biblioteca clone() {
		try {
			Biblioteca cloned = (Biblioteca) super.clone();
			
			int i=0;
			for(Stanza s:stanze) {
				cloned.stanze.set(i, s.clone());
				i++;
			}
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
