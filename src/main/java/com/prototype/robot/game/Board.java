package com.prototype.robot.game;

import java.util.ArrayList;
import java.util.List;

import com.prototype.robot.game.exception.PositionNotValidException;

public class Board {

	private static final String EMPTY_BOX = "Empty";
	private static final String ROBOT_BOX = "Robot";

	private Integer rows;
	private Integer columns;
	// private List<Character>[][] positions = new ArrayList[rows][columns];
	// TO DO --Modify with correct Collection type if possible
	public String[][] positions = new String[5][5];
	private boolean initialPosition = true;

	// private String[][] squares= new String[5][5];

	/*
	 * public Board(Integer rows, Integer columns, List<Character >[][]
	 * positions) { super(); this.rows = rows; this.columns = columns;
	 * this.positions = positions; }
	 */

	public Board(Integer rows, Integer columns) {
		super();
		this.rows = rows;
		this.columns = columns;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				positions[i][j] = EMPTY_BOX;
			}
		}
	}

	public void drawBoard() {

		for (Integer i = --rows; i >= 0; i--) {

			for (Integer j = 0; j < columns; j++) {

				System.out.print("(" + j + "," + i + "," + positions[j][i] + ")");
			}

			System.out.println();

		}

		rows++;

	}

	/**
	 * Set the position of the Robot when the x, y co-ordinate and direction is
	 * passed
	 * 
	 * @return void
	 * @throws PositionNotValidException
	 */
	public void setRobotPosition(Integer xCordinate, Integer yCordinate, String direction, Robot robot)
			throws PositionNotValidException {

		if (!checkValidPosition(xCordinate, yCordinate)) {

			StringBuilder reason = new StringBuilder();
			reason.append("(").append(xCordinate).append(",").append(yCordinate).append(")");

			throw new PositionNotValidException("This position is not valid for movement ", reason.toString());

		} else {

			Integer tempX = robot.getxCordinate();
			Integer tempY = robot.getyCordinate();
			positions[tempX][tempY] = EMPTY_BOX;

			robot.setDirection(direction);
			robot.setxCordinate(xCordinate);
			robot.setyCordinate(yCordinate);
			positions[xCordinate][yCordinate] = ROBOT_BOX;

		}

	}

	// check the validity of the position of robot

	public boolean checkValidPosition(Integer xCordinate, Integer yCordinate) {

		if (xCordinate < 0 || xCordinate > 4 || yCordinate < 0 || yCordinate > 4) {

			return false;
		} else {

			return true;
		}

	}

	/**
	 * Set the position of the Robot for any move
	 * 
	 * @return void
	 */

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	/*
	 * public List<Character>[][] getPositions() { return positions; }
	 * 
	 * public void setPositions(List<Character>[][] positions) { this.positions
	 * = positions; }
	 */

	public String[][] getPositions() {
		return positions;
	}

	public void setPositions(String[][] positions) {
		this.positions = positions;
	}

}
