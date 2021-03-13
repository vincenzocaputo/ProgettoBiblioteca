package biblioteca;

/**
 * Un LibroCollocato è un libro presente in biblioteca, può essere in uno dei due stati:
 * Prestato oppure Disponibile. È caratterizzato da un'etichetta che identifica univocamente il suo posto.
 *
 */

public class LibroCollocato extends Libro{
	/**
	 * Stato del libro: può essere disponibile, oppure prestato.
	 */
	public enum Stato{DISPONIBILE, PRESTATO};
	private Stato statoLibro;
	private Etichetta collocazione;
	
	/**
	 * Costruisce un libro in biblioteca.
	 * @param titolo Titolo del libro
	 * @param autore Autore del libro
	 * @param editore Editore del libro
	 * @param anno Anno del libro
	 * @param genere Genere del libro
	 * @param collocazione Etichetta che identifica univocamente il posto in cui verrà inserito il libro.
	 */
	public LibroCollocato(String titolo, String autore, String editore, String anno, String genere,
							Etichetta collocazione) {
		super(titolo,autore,editore,anno,genere);
		statoLibro = Stato.DISPONIBILE;
		this.collocazione = collocazione;
	}
	
	/**
	 * Cambia lo stato del libro.
	 * @param nuovoStato Nuovo stato del libro.
	 */
	public void setStato(Stato nuovoStato) {
		statoLibro = nuovoStato;
	}
	
	/**
	 * Restituisce lo stato del libro.
	 * @return stato del libro.
	 */
	public Stato getStato() { return statoLibro; }
	
	/**
	 * Restituisce la collocazione del libro.
	 * @return etichetta che identifica univocamente il posto in cui il libro si trova.
	 */
	public Etichetta getCollocazione() {
		return collocazione;
	}
	
	/**
	 * Restituisce una stringa che descrive il libro e le sue caratteristiche.
	 * @return una stringa che descrive il libro.
	 */
	public String toString() {
		return super.toString() + "[statoLibro="+statoLibro+", collocazione="+collocazione+"]";
	}
	
	/**
	 * Controlla che due libri collocati siano identici.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se i due oggetti sono identici, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		
		LibroCollocato tmp = (LibroCollocato) obj;
		return tmp.collocazione.equals(collocazione) && tmp.statoLibro == statoLibro;
	}
	
	/**
	 * Crea un libro collocato identico a questa istanza.
	 * @return un libro collocato identico a questa istanza.
	 */
	public LibroCollocato clone() {
		LibroCollocato cloned = (LibroCollocato) super.clone();
		
		cloned.collocazione = collocazione;
		return cloned;
	}
}
