package biblioteca;

import java.io.Serializable;

/**
 * Uno scaffale è composto da un numero predefinito di posti in cui possono alloggiare i libri.
 */
public class Scaffale implements Cloneable, Serializable{
	private PostoScaffale[] posti;
	private char idStanza;
	private int idScaffale;

	/**
	 * Costruisce uno scaffale con un numero di posti.
	 * @param idStanza identificativo univoco della stanza in cui è presente lo scaffale.
	 * @param idScaffale identificativo univoco dello scaffale.
	 * @param numeroPosti numero dei posti presenti sullo scaffale.
	 */
	public Scaffale(char idStanza, int idScaffale, int numeroPosti) {
		this.idStanza = idStanza;
		this.idScaffale = idScaffale;
		posti = new PostoScaffale[numeroPosti];
		for(int i=0; i<numeroPosti; i++) {
			posti[i] = new PostoScaffale(idStanza, idScaffale, i+1);
		}
	}
	
	/**
	 * Restituisce il numero di posti sullo scaffale.
	 * @return numero dei posti dello scaffale.
	 */
	public int getNumeroPosti() { return posti.length; }
	
	/**
	 * Restituisce il numero di libri.
	 * @return Numero di libri presenti sullo scaffale.
	 */
	public int getNumeroVolumi() {
		int nVolumi = 0;
		for(PostoScaffale p : posti) {
			if(p.getLibro()!=null) 
				nVolumi ++;
		}
		return nVolumi;
	}
	
	/**
	 * Restituisce l'id della stanza in cui è presente lo scaffale.
	 * @return identificativo univoco della stanza in cui è presente lo scaffale.
	 */
	public char getIdStanza() {
		return idStanza;
	}

	/**
	 * Restituisce l'insieme dei posti
	 * @return Lista dei posti sullo scaffale
	 */
	public PostoScaffale[] getPosti() {
		return posti;
	}
	
	/**
	 * Restituisce un posto dello scaffale.
	 * @param id codice che identifica il posto.
	 * @return posto selezionato.
	 */
	public PostoScaffale getPosto(int id) {
		return posti[id];
	}
	
	/**
	 * Restituisce identificativo dello scaffale.
	 * @return codice intenditificato dello scaffale.
	 */
	public int getIdScaffale() {
		return idScaffale;
	}
	
	/**
	 * Restituisce una stringa che descrive lo scaffale e le sue caratteristiche.
	 * @return una stringa che descrive lo scaffale.
	 */
	public String toString() {
		String s=getClass().getName() + "[idStanza="+idStanza+", idScaffale="+idScaffale+", posti=";
		for(int i=0; i<posti.length; i++) {
			s = s + posti[i].toString();
		}
		s = s+"]";
		return s;
	}
	
	/**
	 * Controlla se due scaffali sono identici.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se l'oggetto è identico a questa istanza, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj.getClass() != this.getClass()) return false;
		
		Scaffale tmp = (Scaffale) obj;
		return tmp.idStanza == idStanza && tmp.idScaffale == idScaffale && 
				tmp.posti.equals(posti);
	}
	
	/**
	 * Crea uno scaffale identico a questa istanza.
	 * @return uno scaffale identico a questa istanza.
	 */
	public Scaffale clone() {
		try {
			Scaffale cloned = (Scaffale) super.clone();
			
			int i=0;
			for(PostoScaffale s: posti) {
				cloned.posti[i] = s.clone();
				i++;
			}
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
