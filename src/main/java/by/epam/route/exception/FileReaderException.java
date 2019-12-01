package by.epam.route.exception;

public class FileReaderException extends Exception {
    public FileReaderException() {
        super();
    }

    public FileReaderException(String message) {
        super(message);
    }

    public FileReaderException(Exception e) {
        super(e);
    }

    public FileReaderException(String message, Exception e) {
        super(message, e);
    }
}
