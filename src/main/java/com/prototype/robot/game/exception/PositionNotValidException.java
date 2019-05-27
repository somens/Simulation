package com.prototype.robot.game.exception;

public class PositionNotValidException extends Exception {
	
	public PositionNotValidException(String message){
		
		super(message);
		
	}

	public PositionNotValidException(String message, String reason) {
		
		super(message + reason);
	}

}
