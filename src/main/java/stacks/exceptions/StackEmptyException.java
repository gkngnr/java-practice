package stacks.exceptions;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException() {
        super("Stack is empty!");
    }
}
