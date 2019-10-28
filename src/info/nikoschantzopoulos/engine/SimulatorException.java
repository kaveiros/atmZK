package info.nikoschantzopoulos.engine;

/**
 * Custom Exception for ATM simulator program.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class SimulatorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private boolean internalError;
	
	public SimulatorException (String message) {
		this(message, false);
	}

	public SimulatorException(String message, boolean isInternalError) {
		 super(message);
	     internalError = isInternalError;
	}
	
	public boolean isInternalError() {
		return internalError;
	}

}
