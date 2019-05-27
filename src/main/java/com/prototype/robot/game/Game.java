package com.prototype.robot.game;

import com.prototype.robot.game.exception.NotValidCommand;

public class Game {

	public static void main(String[] args) {

		String[] statements = {

				"place 0 0 North", 
				"move",
				"report",
				"place 0 0 North", 
				"left",
				"report",
				"place 1 2 East", 
				"move",
				"move",
				"left",
				"move",
				"report",
				"place 5 2 East",
				"move",
				"report",
				};

		GameHelper gameHelper = new GameHelper();

		for (String statement : statements) {

			try {
				gameHelper.process(statement);

			} catch (NotValidCommand e) {
				System.out.println(e.getMessage());

			}

		}

	}

}
