package eccezioni;

/**
 * Eccezione che rappresenta il caso di errore in cui l'output di ricerca è vuoto.
 *
 */
public class EccezioneNessunRisultato extends NullPointerException {
	
	/**
	 * Crea una nuova eccezione.
	 */
	public EccezioneNessunRisultato() {
		super("Nessun risultato.");
	}
	
	/**
	 * Crea una nuova eccezione, con un determinato messaggio.
	 * @param msg messaggio dell'eccezione.
	 */
	public EccezioneNessunRisultato(String msg) {
		super(msg);
	}
}
