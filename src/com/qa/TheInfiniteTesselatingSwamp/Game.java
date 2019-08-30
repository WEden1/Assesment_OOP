package com.qa.TheInfiniteTesselatingSwamp;

import java.util.Scanner;
import java.math.*; 

public class Game extends Game_Environment{
	
	Scanner sc = new Scanner(System.in);
	
	private int playerPosX;
	private int playerPosY;
	private int distanceFromExit;
	private int exit;
	private int boardSize;
	
	public Game() {  
	}
	
	public Game(int playerPosX, int playerPosY, int distanceFromExit, int exit, int boardSize) {
		this.playerPosX = playerPosX;
		this.playerPosY = playerPosY;
		this.distanceFromExit = distanceFromExit;
		this.exit = exit; 
		this.boardSize = boardSize;
		
	}
	
	public void setPlayerPosX(int playerPosX) {
		this.playerPosX = playerPosX;
	}
	
	public int getPlayerPosX() {
		return this.playerPosX;
	}
	
	public void setPlayerPosY(int playerPosY) {
		this.playerPosY = playerPosY;
	}
	
	public int getPlayerPosY() {
		return this.playerPosY;
	}
	
	public void setDistanceFromExit(int distanceFromExit) {
		this.distanceFromExit = distanceFromExit;
	}
	
	public int getDistanceFromExit() {
		return this.distanceFromExit;
	}
	
	public void playGame() {
		
		System.out.println("Set a board size (1-100): ");
		this.boardSize = sc.nextInt();
		this.boardSize  = (int) Math.pow(this.boardSize, 2);
		this.exit = (int) (Math.random() * boardSize);
		this.playerPosX = (int) Math.sqrt((int) (Math.random() * boardSize));
		this.playerPosY = (int) Math.sqrt((int) (Math.random() * boardSize));

		//test
		System.out.println(exit);
		
		
		sc.nextLine();
		
		System.out.println("You find yourself in a swamp surrounded by fogg, you can see no way out\n"
				+ "your only tool is a magic compass which tells you how close you are to the exit\n"
				+ "enter your move, type 'N'/'E'/'S'/'W' in order to escape: ");
		
		
		while(true) {
		
			String playerMove = sc.next();
			
			switch (playerMove) {
			
				case "N":
				{
					this.playerPosY += 1;
					break;
				}
				
				case "E":
				{
					this.playerPosX += 1;
					break;
				}
				case "S":
				{
					this.playerPosY -= 1;
					break;
				}
				case "W":
				{
					this.playerPosX -= 1;
					break;
				}
				default:
				{
					break;
				}
			}
		
			int playerPos = (int) (Math.pow(this.playerPosX, 2) + Math.pow(this.playerPosY, 2));
			playerPos = (int) Math.sqrt(playerPos);
		
			if (playerPos == exit) {
				System.out.println("You found the exit!!!");
				break;
			}
			
			else {
				System.out.println("keep on sludgingly..");
			}
			System.out.println(playerPos);
		}
	}
}
