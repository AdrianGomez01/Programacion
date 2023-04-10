package spaceConquerors;

public class DadosException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadosException(String message) {
        super(message);
    }

    public DadosException(Throwable cause) {
        super(cause);
    }

    public DadosException(String message, Throwable cause) {
        super(message, cause);
    }

    public DadosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
