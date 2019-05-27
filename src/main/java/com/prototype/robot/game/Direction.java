package com.prototype.robot.game;

import static com.prototype.robot.game.Constants.*;
public class Direction {
	
	private String currentDirection;
	private String movementDirection;
	
	public Direction(String currentDirection, String movementDirection) {
		super();
		this.currentDirection = currentDirection;
		this.movementDirection = movementDirection;
	}
	
	/**
	 * Change the direction of the Robot
	 * @param currentDirection
	 * @param movementDirection
	 * @return
	 */

	public String changeDirection(){
		
		String newDirection="" ;	
		
		
		if(movementDirection.equalsIgnoreCase(LEFT_MOVEMENT)){	
			
			newDirection = findLeftDirection(currentDirection);
			
		}else if(movementDirection.equalsIgnoreCase(RIGHT_MOVEMENT)) {
			newDirection = findRightDirection(currentDirection);
		}
		
		return newDirection;
		
	}

	/**
	 * After finishing right movement , we are finding the next direction
	 * @param newDirection
	 * @return
	 */
	private String findRightDirection(String newDirection) {
		
		if(currentDirection.equalsIgnoreCase(EAST_DIRECTION)){
			newDirection = SOUTH_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(SOUTH_DIRECTION)){
			newDirection = WEST_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(WEST_DIRECTION)){
			newDirection = NORTH_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(NORTH_DIRECTION)){
			newDirection = EAST_DIRECTION;
		}
		return newDirection;
	}

	/**
	 * After finishing left movement , we are finding the next direction
	 * @param newDirection
	 * @return
	 */
	private String findLeftDirection(String newDirection) {
		if(currentDirection.equalsIgnoreCase(EAST_DIRECTION)){
			newDirection = NORTH_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(NORTH_DIRECTION)){
			newDirection = WEST_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(WEST_DIRECTION)){
			newDirection = SOUTH_DIRECTION;
		}else if(currentDirection.equalsIgnoreCase(SOUTH_DIRECTION)){
			newDirection = NORTH_DIRECTION;
		}
		return newDirection;
	}
	
	
	
	
	public String getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(String currentDirection) {
		this.currentDirection = currentDirection;
	}

	public String getMovementDirection() {
		return movementDirection;
	}

	public void setMovementDirection(String movementDirection) {
		this.movementDirection = movementDirection;
	}
	
	
	

}
