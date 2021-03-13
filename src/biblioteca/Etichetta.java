package biblioteca;

import java.io.Serializable;

/**
 * Un'Etichetta identifica univocamente una posizione all'interno della biblioteca.
 * È composta dall'identificativo della stanza, dall'identificativo dello scaffale e dal
 * numero del posto sullo scaffale.
 */
public final class Etichetta implements Cloneable, Serializable{
	private char idStanza;
	private int idScaffale;
	private int idPosto;
	
	/**
	 * Costruisce un'etichetta.
	 * @param idStanza Identificativo della stanza
	 * @param idScaffale Identificativo dello scaffale
	 * @param idPosto Numero posto
	 */
	public Etichetta(char idStanza, int idScaffale, int idPosto) {
		this.idStanza = idStanza;
		this.idScaffale = idScaffale;
		this.idPosto = idPosto;
	}
	
	/**
	 * Restituisce idStanza
	 * @return Identificativo univoco della stanza
	 */
	public char getIdStanza() { return idStanza; }
	
	/**
	 * Restituisce idScaffale
	 * @return Identificativo univoco dello scaffale
	 */
	public int getIdScaffale() { return idScaffale; }
	
	/**
	 * Restituisce idPosto
	 * @return Identificativo univoco del posto sullo scaffale
	 */
	public int getIdPosto() { return idPosto; }
	
	/**
	 * Restituisce una stringa che descrive l'etichetta.
	 * @return una stringa che descrive l'etichetta.
	 */
	public String toString() {
		return getClass().getName() + "[idStanza="+idStanza+", idScaffale="+idScaffale+", idPosto="
				+idPosto+"]";
	}
	
	/**
	 * Controlla che due etichette sono identiche.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se l'oggetto è identico a questa istanza, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != getClass()) return false;
		
		Etichetta tmp = (Etichetta) obj;
		return tmp.idStanza == idStanza && tmp.idScaffale == idScaffale &&
				tmp.idPosto == idPosto;
	}
	
	/**
	 * Crea un'etichetta identica a questa istanza.
	 * @return un'etichetta identica a questa istanza.
	 */
	public Etichetta clone() {
		try {
			Etichetta cloned = (Etichetta) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
