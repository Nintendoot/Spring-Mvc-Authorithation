package by.nintendo.exeption;

public class NoSuchUserExeption extends RuntimeException{
    public NoSuchUserExeption(String message) {
        super(message);
    }
}
