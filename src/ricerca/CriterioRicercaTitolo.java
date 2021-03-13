package ricerca;

import biblioteca.PostoScaffale;

/**
 * Criterio di ricerca, in base al titolo.
 *
 */
public class CriterioRicercaTitolo implements CriterioRicerca{
	private String titolo;
	
	/**
	 * Costruisce un nuovo criterio "stesso titolo".
	 * @param titolo chiave di ricerca del criterio.
	 */
	public CriterioRicercaTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	/**
	 * Controlla se in un posto è presente un libro con un determinato libro.
	 * @param p posto scaffale su cui effettuare il controllo.
	 */
	@Override
	public boolean test(PostoScaffale p) {
		if(p.getLibro().getTitolo().equals(titolo))
			return true;
		else
			return false;
	}

}
