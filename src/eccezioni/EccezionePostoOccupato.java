package eccezioni;

/**
 * Eccezione che rappresenta l'errore nel caso in cui si tenti di inserire un libro in un posto
 * occupato da un altro libro.
 *
 */
public class EccezionePostoOccupato extends Exception{
	
	/**
	 * Crea una nuova eccezione.
	 */
	public EccezionePostoOccupato() {
		super("Posto occupato.");
	}

	/**
	 * Crea una nuova eccezione, con un determinato messaggio.
	 * @param msg messaggio dell'eccezione.
	 */
	public EccezionePostoOccupato(String msg) {
		super(msg);
	}
}
