package biblioteca;

import java.io.Serializable;

/**
 * Un libro ha un titolo, un autore, una casa editrice, un anno di pubblicazione e un genere
 */

public class Libro implements Cloneable, Serializable{
	private String titolo;
	private String autore;
	private String casaEditrice;
	private String anno;
	private String genere;
	
	/**
	 * Costruisce un libro, dato un titolo, un autore, un editore, un anno di pubblicazione
	 * e un genere
	 * @param titolo titolo del libro
	 * @param autore nome autore del libro
	 * @param casaEditrice casa editore del libro
	 * @param anno anno di pubblicazione del libro
	 * @param genere genere del libro
	 */
	public Libro(String titolo, String autore, String casaEditrice, String anno, String genere) {
		this.titolo = titolo;
		this.autore = autore;
		this.casaEditrice = casaEditrice;
		this.anno = anno;
		this.genere = genere;
	}
	
	/**
	 * Restituisce il titolo
	 * @return Titolo del libro
	 */
	public String getTitolo() { return titolo; }
	/**
	 * Restituisce l'autore
	 * @return Nome dell'autore del libro
	 */
	public String getAutore() { return autore; }
	/**
	 * Restituisce l'editore
	 * @return Nome casa editrice del libro
	 */
	public String getCasaEditrice() { return casaEditrice; }
	/**
	 * Restituisce l'anno
	 * @return Anno di pubblicazione del libro
	 */
	public String getAnno() { return anno; }
	/**
	 * Restituisce il genere
	 * @return Genere del libro
	 */
	public String getGenere() { return genere; }
	
	/**
	 * Restituisce una stringa che descrive il libro e le sue caratteristiche.
	 * @return una stringa che descrive il libro.
	 */
	public String toString() {
		return getClass().getName() + "[titolo="+titolo+", autore="+autore+", casaEditrice="+casaEditrice+
				", anno="+anno+", genere="+genere+"]";
	}
	
	/**
	 * Controlla che due libri sono identici.
	 * @param obj oggetto con cui confrontare questa istanza.
	 * @return true se i due oggetti sono identici, false altrimenti.
	 */
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj.getClass() != this.getClass()) return false;
		
		Libro tmp = (Libro) obj;
		return tmp.titolo.equals(titolo) && tmp.autore.equals(autore) && tmp.casaEditrice.equals(casaEditrice)
				&& tmp.anno.equals(anno) && tmp.genere.equals(genere);
	}
	
	/**
	 * Crea un libro identico a questa istanza.
	 * @return un oggetto identico a questa istanza.
	 */
	public Libro clone() {
		try {
			Libro cloned = (Libro) super.clone();
			
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
