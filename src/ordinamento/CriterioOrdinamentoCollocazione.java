package ordinamento;

import biblioteca.Etichetta;
import biblioteca.LibroCollocato;

public class CriterioOrdinamentoCollocazione implements CriterioOrdinamento{

	/**
	 * Costruttore vuoto.
	 */
	public CriterioOrdinamentoCollocazione() {
		
	}
	
	/**
	 * Confronta due libri della biblioteca, in base alla collocazione: in ordine di stanza secondo l'ordine alfabetico crescente,
	 * a parità di stanza in ordine crescente di numero di scaffale e a parità di scaffale in ordine crescente di numero di posto.
	 * @param libro1 primo libro da confrontare.
	 * @param libro2 secondo libro da confrontare.
	 * @return -1 se il primo libro precede il secondo, 0 se sono uguali, 1 se il secondo libro precede il primo.
	 */
	@Override
	public int confronta(LibroCollocato libro1, LibroCollocato libro2) {
		Etichetta collocazione1 = libro1.getCollocazione();
		Etichetta collocazione2 = libro2.getCollocazione();
		if(collocazione1.getIdStanza()<collocazione2.getIdStanza() || collocazione1.getIdScaffale()<collocazione2.getIdScaffale() || collocazione1.getIdPosto() < collocazione2.getIdPosto())
			return -1;
		else if(collocazione1.equals(collocazione2))
			return 0;
		else return 1;
	}

}
