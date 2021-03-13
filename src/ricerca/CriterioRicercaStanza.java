package ricerca;

import biblioteca.PostoScaffale;

/**
 * Criterio per la ricerca, in base alla stanza. 
 *
 */
public class CriterioRicercaStanza implements CriterioRicerca{
	private char idStanza;
	
	/**
	 * Cosrtuisce un nuovo criterio di ricerca "stessa stanza".
	 * @param idStanza chiave di ricerca del criterio.
	 */
	public CriterioRicercaStanza(char idStanza) {
		this.idStanza = idStanza;
	}
	/**
	 * Controlla se un posto della biblioteca è in una determinata stanza.
	 * @param p posto dello scaffale su cui effettuare il test.
	 */
	@Override
	public boolean test(PostoScaffale p) {
		if(p.getIdStanza()==idStanza)
			return true;
		else
			return false;
	}

}
