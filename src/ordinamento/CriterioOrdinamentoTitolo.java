package ordinamento;

import biblioteca.LibroCollocato;

public class CriterioOrdinamentoTitolo implements CriterioOrdinamento{

	/**
	 * Costruttore vuoto.
	 */
	public CriterioOrdinamentoTitolo() {
		
	}
	
	/**
	 * Confronta due libri nella biblioteca, in base al titolo, in ordine alfabetico.
	 * @param libro1 primo libro della biblioteca da confrontare.
	 * @param libro2 secondo libro della biblioteca da confrontare.
	 * @return -1 se il primo libro precede il secondo, 0 se sono uguali, 1 se il secondo libro precede il primo libro.
	 */
	@Override
	public int confronta(LibroCollocato libro1, LibroCollocato libro2) {
		String titolo1 = libro1.getTitolo();
		String titolo2 = libro2.getTitolo();
		titolo1 = titolo1.replaceAll(" ","");
		titolo2 = titolo2.replaceAll(" ","");
		if(titolo1.compareToIgnoreCase(titolo2)<0)
			return -1;
		else if(titolo1.compareToIgnoreCase(titolo2)==0)
			return 0;
		else
			return 1; 
	}

}
