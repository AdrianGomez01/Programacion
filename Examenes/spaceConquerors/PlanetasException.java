package spaceConquerors;

public class PlanetasException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanetasException(String message) {
        super(message);
    }

    public PlanetasException(Throwable cause) {
        super(cause);
    }

    public PlanetasException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlanetasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}