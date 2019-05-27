package com.prototype.robot.game;

import static com.prototype.robot.game.Constants.*;

import com.prototype.robot.game.exception.PositionNotValidException;
public class Robot {
	
		private Integer xCordinate;
		private Integer yCordinate;
		private String direction;
		
		
		public Robot(Integer xCordinate, Integer yCordinate, String direction) {
			super();
			this.xCordinate = xCordinate;
			this.yCordinate = yCordinate;
			this.direction = direction;
		}

		public void move() throws PositionNotValidException {
			
			if(direction.equalsIgnoreCase(NORTH_DIRECTION)){
				Integer tempCoordinate = yCordinate ;
				if(checkValidity(++tempCoordinate)){
					yCordinate++;
				}else{
					throw new PositionNotValidException("This is not a valid position for movement");
				}
				
			}
			else if(direction.equalsIgnoreCase(SOUTH_DIRECTION)){
				Integer tempCoordinate = yCordinate ;
				if(checkValidity(--tempCoordinate)){
					yCordinate--;
					}else{
						throw new PositionNotValidException("This is not a valid position for movement");
					}
				}
			else if(direction.equalsIgnoreCase(EAST_DIRECTION)){
					Integer tempCoordinate = xCordinate ;
					if(checkValidity(++tempCoordinate)){
						xCordinate++;
						}else{
							throw new PositionNotValidException("This is not a valid position for movement");
						}
					}
			else if(direction.equalsIgnoreCase(WEST_DIRECTION)){
				Integer tempCoordinate = xCordinate ;
				if(checkValidity(--tempCoordinate)){
					xCordinate--;
					}else{
						throw new PositionNotValidException("This is not a valid position for movement");
					}
				}
		}	
		
		private boolean checkValidity(Integer integer) {
			
			if(integer < 0 || integer > 4){
				return false;
			}else{
				return true;
			}
			
		}

		public Integer getxCordinate() {
			return xCordinate;
		}


		public void setxCordinate(Integer xCordinate) {
			this.xCordinate = xCordinate;
		}


		public Integer getyCordinate() {
			return yCordinate;
		}


		public void setyCordinate(Integer yCordinate) {
			this.yCordinate = yCordinate;
		}


		public String getDirection() {
			return direction;
		}


		public void setDirection(String direction) {
			this.direction = direction;
		}

	
		
		@Override
		public String toString() {
			return "Robot position is :-- [xCordinate=" + xCordinate + ", yCordinate=" + yCordinate + ", direction=" + direction + "]";
		}


		
		
	
		
		

}
