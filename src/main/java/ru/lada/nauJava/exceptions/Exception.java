package ru.lada.nauJava.exceptions;

public class Exception {
    private String message;

    public Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Exception create(String message){
        return  new Exception(message);
    }

    public static Exception create(Throwable e){
        return new Exception(e.getMessage());
    }
}
