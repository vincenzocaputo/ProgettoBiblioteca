package ordinamento;

import java.util.ArrayList;

import biblioteca.LibroCollocato;
import eccezioni.EccezioneNessunRisultato;

/**
 * Classe che contiene un metodo di servizio per effettuare ordinamenti.
 *
 */
public class Ordinamento {
	
	/**
	 * Ordina una lista, secondo un criterio di confronto.
	 * @param lista lista da ordinare.
	 * @param criterio criterio di confrotno.
	 * @return lista ordinata.
	 */
	public static LibroCollocato[] ordina(ArrayList<LibroCollocato> lista, CriterioOrdinamento criterio) {
		LibroCollocato[] listaOrdinata = null;
		if(lista.isEmpty())
			throw new EccezioneNessunRisultato("La ricerca non ha prodotto nessun risultato.");
		listaOrdinata = new LibroCollocato[lista.size()];
		listaOrdinata[0] = lista.get(0).clone();
		int j;
		LibroCollocato prossimo;
		for(int i=1; i<lista.size(); i++) {
			prossimo = lista.get(i).clone();
			j = i;
			while(j>0 && (criterio.confronta(listaOrdinata[j-1], prossimo)==1)) {
				listaOrdinata[j] = listaOrdinata[j-1].clone();
				j--;
			}
			listaOrdinata[j] = prossimo.clone();
			
		}
		return listaOrdinata;
	}
}
