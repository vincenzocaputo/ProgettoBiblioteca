package biblioteca;

import java.io.Serializable;

import biblioteca.LibroCollocato.Stato;
import eccezioni.EccezionePostoOccupato;

/**
 * Un PostoScaffale è uno spazio in cui può essere messo un libro.
 */
public class PostoScaffale implements Cloneable, Serializable {
	private LibroCollocato libro;
	private char idStanza;
	private int idScaffale;
	private int idPosto;
	
	/**
	 * Costruisce un posto vuoto.
	 * @param idStanza identificativo univoco della stanza di appartenenza.
	 * @param idScaffale identificativo unvico dello scaffale di appartenenza.
	 * @param idPosto identificativo univoco del posto sullo scaffale.
	 */
	public PostoScaffale(char idStanza, int idScaffale, int idPosto) {
		this.idStanza = idStanza;
		this.idScaffale = idScaffale;
		this.idPosto = idPosto;
		libro = null;
	}
	
	/**
	 * Aggiunge un libro.
	 * @param nuovoLibro libro da aggiungere in questo posto.
	 * @throws EccezionePostoOccupato se il posto è occupato da un altro libro.
	 */
	public void aggiungiLibro(Libro nuovoLibro) throws EccezionePostoOccupato {
		if(libro!=null)
			throw new EccezionePostoOccupato("Il posto è occupato da un altro libro.");
		Etichetta collocazione = new Etichetta(idStanza,idScaffale,idPosto);
		libro = new LibroCollocato(nuovoLibro.getTitolo(),nuovoLibro.getAutore(),nuovoLibro.getCasaEditrice(),
				nuovoLibro.getAnno(),nuovoLibro.getGenere(), collocazione);
	}
	
	/**
	 * Rimuove il libro presente.
	 */
	public void rimuoviLibro() {
		libro = null;
	}
	
	/**
	 * Imposta lo stato del libro a "prestato".
	 */
	public void effettuaPrestito() {
		if(libro!=null)
			libro.setStato(Stato.PRESTATO);
	}
	
	/**
	 * Imposta lo stato del libro a "disponibile".
	 */
	public void effettuaRestituzione() {
		if(libro!=null)
			libro.setStato(Stato.DISPONIBILE);
	}
	
	/**
	 * Restituisce il libro.
	 * @return Restituisce il libro presente nel posto.
	 */
	public LibroCollocato getLibro() {
		return libro;
	}

	/**
	 * Restituisce l'identificativo della stanza.
	 * @return identificativo della stanza di appartenenza.
	 */
	public char getIdStanza() {
		return idStanza;
	}
	
	/**
	 * Restituisce l'identificativo dello scaffale.
	 * @return identificativo dello scaffale di appartenenza.
	 */
	public int getIdScaffale() {
		return idScaffale;
	}
	
	/**
	 * Restituisce l'identificativo di questo posto.
	 * @return identificativo del posto.
	 */
	public int getIdPosto() {
		return idPosto;
	}
	
	/**
	 * Restituisce una stringa che descrive il posto e le sue caratteristiche.
	 * @return stringa che descrive il posto.
	 */
	public String toString() {
		return getClass().getName() + "[idStanza="+idStanza+", idScaffale="+idScaffale+", idPosto="+idPosto+", libro="+libro+"]";
	}
	
	/**
	 * Crea un posto identico a questa istanza.
	 * @return un posto identico a questa istanza.
	 */
	public PostoScaffale clone() {
		try {
			PostoScaffale cloned = (PostoScaffale) super.clone();
			
			cloned.libro = libro.clone();
			
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	/**
	 * Controlla che due posti sono identici.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se i due oggetti sono identici, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != getClass()) return false;
		
		PostoScaffale tmp = (PostoScaffale) obj;
		return tmp.idStanza == idStanza && tmp.idScaffale == idScaffale && 
				tmp.idPosto == idPosto && tmp.libro.equals(libro);
	}
}
