package open.code.exception.directory_exception;

import open.code.exception.directory_exception.DirectoryException;

public class DirectoryNotFoundException extends DirectoryException {
    private String message;

    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
