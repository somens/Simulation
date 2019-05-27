package com.prototype.robot.game;

import com.prototype.robot.game.exception.NotValidCommand;
import com.prototype.robot.game.exception.PositionNotValidException;
import static com.prototype.robot.game.Constants.*;

public class GameHelper {


	private GameCommand gameCommand;
	private String command;
	private Integer xCordinate;
	private Integer yCordinate;
	private String direction;
	private Board board;
	private Robot robot;

	public GameHelper() {

		board = new Board(5, 5);
		robot = new Robot(0, 0, "North");
		board.positions[0][0] = "Robot";

	}

	// Process individual statement
	public void process(String statement) throws NotValidCommand {

		String[] parameters = statement.split(" ");
		String commandString = parameters[0];

		if (commandString.equalsIgnoreCase(PLACE_COMMAND) || commandString.equalsIgnoreCase(MOVE_COMMAND)
				|| commandString.equalsIgnoreCase(REPORT_COMMAND) || commandString.equalsIgnoreCase(LEFT_COMMAND)
				|| commandString.equalsIgnoreCase(RIGHT_COMMAND)) {
			command = commandString;
		} else {

			throw new NotValidCommand("Invalid command for this game. No such command found ", parameters[0]);
		}

		if (parameters.length == 4) {
			xCordinate = Integer.parseInt(parameters[1]);
			yCordinate = Integer.parseInt(parameters[2]);
			direction = parameters[3];
		}

		setCommandFromString(command);

		if (gameCommand != null) {

			doAction();

		}

	}

	// Move the Robot as per the command

	public void doAction() {

		switch (gameCommand) {
		case place:
			try {
				board.setRobotPosition(xCordinate, yCordinate, direction, robot);
			} catch (PositionNotValidException e) {
				System.out.println(e.getMessage());
			}
			break;

		case report:
			//System.out.println("Current Board is looking like below");
			//board.drawBoard();
			System.out.println(robot.toString());
			break;

		case left:
			setDirection(LEFT_COMMAND);
			break;

		case right:
			setDirection(RIGHT_COMMAND);
			break;

		case move:

			moveRobort();

			break;

		default:
			System.out.println("This is the default switch for command");
			break;

		}
	}

	private void moveRobort() {
		//System.out.println("Robot is trying for a move");
		Robot tempRobot = new Robot(robot.getxCordinate(), robot.getyCordinate(), robot.getDirection());

		try {
			tempRobot.move();
			board.positions[robot.getxCordinate()][robot.getyCordinate()] = EMPTY_BOX;
			robot.setxCordinate(tempRobot.getxCordinate());
			robot.setyCordinate(tempRobot.getyCordinate());
			board.positions[robot.getxCordinate()][robot.getyCordinate()] = ROBOT_BOX;
		} catch (PositionNotValidException e) {
			System.out.println(e.getMessage());
		}
	}

	private void setDirection(String changeDirection) {
		//System.out.println("This is for changing the robot direction");
		Direction direction = new Direction(robot.getDirection(), changeDirection);
		String newDirection = direction.changeDirection();
		robot.setDirection(newDirection);
		//System.out.println("Currently Robot is facing the direction of :-  " + newDirection);
	}

	private void setCommandFromString(String commandString) {

		// Get the command from enum GameCommand

		if (commandString.equalsIgnoreCase(GameCommand.place.toString()))
			gameCommand = GameCommand.place;
		else if (commandString.equalsIgnoreCase(GameCommand.move.toString()))
			gameCommand = GameCommand.move;
		else if (commandString.equalsIgnoreCase(GameCommand.report.toString()))
			gameCommand = GameCommand.report;
		else if (commandString.equalsIgnoreCase(GameCommand.left.toString()))
			gameCommand = GameCommand.left;
		else if (commandString.equalsIgnoreCase(GameCommand.right.toString()))
			gameCommand = GameCommand.right;

	}

	@Override
	public String toString() {
		return "GameHelper [command=" + command + ", xCordinate=" + xCordinate + ", yCordinate=" + yCordinate
				+ ", direction=" + direction + "]";
	}

}
