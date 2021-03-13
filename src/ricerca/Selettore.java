package ricerca;

import java.util.ArrayList;
import biblioteca.Biblioteca;
import biblioteca.LibroCollocato;
import biblioteca.Stanza;
import biblioteca.Scaffale;
import biblioteca.PostoScaffale;

/**
 * Classe contenente metodo di servizio per effettuare ricerche.
 */
public class Selettore {
	private Biblioteca biblioteca;
	
	/**
	 * Costruisce un nuovo selettore, sulla base di una biblioteca.
	 * @param biblioteca biblioteca su cui effettuare operazioni di ricerca.
	 */
	public Selettore(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	/**
	 * Effettua una ricerca nella biblioteca, secondo un criterio di ricerca.
	 * @param c criterio di ricerca.
	 * @return output della ricerca.
	 */
	public ArrayList<LibroCollocato> ricerca(CriterioRicerca c) {
		ArrayList<LibroCollocato> output = new ArrayList<LibroCollocato>();
		for(Stanza s:biblioteca.getStanze()) {
			for(Scaffale sc: s.getScaffali()) {
				for(PostoScaffale p:sc.getPosti()) {
					if(p.getLibro()!=null && c.test(p) == true) {
						output.add(p.getLibro());
					}
				}
			}
		}
		return output;
	}
}
