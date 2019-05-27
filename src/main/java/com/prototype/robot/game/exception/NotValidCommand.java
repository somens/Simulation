package com.prototype.robot.game.exception;

public class NotValidCommand extends Exception {
	
	public NotValidCommand(String message, String reason){
		super("Message is :-" + message +  reason);
	}
}
