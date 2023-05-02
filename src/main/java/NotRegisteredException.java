public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String text) {
        super(text + "is not registered");
    }
}
