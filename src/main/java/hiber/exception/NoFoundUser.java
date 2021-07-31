package hiber.exception;

public class NoFoundUser extends Exception{

    public NoFoundUser() {
    }
    public NoFoundUser(String message) {
        super(message);
    }
}
