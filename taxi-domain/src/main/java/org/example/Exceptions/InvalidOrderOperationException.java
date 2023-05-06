package org.example.Exceptions;

public class InvalidOrderOperationException extends Exception{
    public InvalidOrderOperationException() {}

    public InvalidOrderOperationException(String message){
        super(message);
    }
}
