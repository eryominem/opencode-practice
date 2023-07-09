package open.code.exception.directory_exception;

public class DirectoryNotFoundException extends DirectoryException {
    private String message;

    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
