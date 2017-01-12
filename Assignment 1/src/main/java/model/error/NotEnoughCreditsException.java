package main.java.model.error;

@SuppressWarnings("serial")
public class NotEnoughCreditsException extends Exception {
	
	public NotEnoughCreditsException(String description){
		super(description);
	}
	
	public NotEnoughCreditsException(){
	}

}
