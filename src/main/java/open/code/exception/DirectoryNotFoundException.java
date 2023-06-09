package open.code.exception;

public class DirectoryNotFoundException extends RuntimeException {
    private String message;

    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
