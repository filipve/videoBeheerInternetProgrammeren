package domain;

/**
 * Created by filip on 18/02/2016.
 */
public class DomainException extends RuntimeException{

    public DomainException(){

    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(Throwable exception) {

        super(exception);
    }

    public DomainException(String message, Throwable exception) {

        super(message, exception);
    }
}
