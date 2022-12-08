package se.lexicon.exceptions.workshop.Exceptions;

public class DuplicateNameException extends Exception{
    private String paramValue;



    public DuplicateNameException(String message, String paramValue){
        super(message);
        this.paramValue = paramValue;
    }


    public String getParamValue() {
        return paramValue;
    }
}
