package excepciones;

public class InvalidEntryException extends RuntimeException {
	public InvalidEntryException (String s) {
		super(s);
	}
}
