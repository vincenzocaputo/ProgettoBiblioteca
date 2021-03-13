package ordinamento;

import biblioteca.LibroCollocato;

public interface CriterioOrdinamento {
	public int confronta(LibroCollocato libro1, LibroCollocato libro2);
}
