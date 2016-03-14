package be.vdab.exceptions;

public class FiliaalHeeftNogWerknemersException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FiliaalHeeftNogWerknemersException() {
	}

	public FiliaalHeeftNogWerknemersException(String msg) {
		super(msg);
	}

	public FiliaalHeeftNogWerknemersException(String message, Throwable cause) {
		super(message, cause);
	}

	public FiliaalHeeftNogWerknemersException(Throwable cause) {
		super(cause);
	}
}
