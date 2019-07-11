package com.edicom.GameOfLife;

public class GameOfLife {

	private static final int OVERPOPULATION = 3;
	private static final int UNDERPOPULATION = 2;

	public static boolean isAlive(boolean cell) {

		return cell;

	}

	public static boolean isLessThanTwo(int neighbors) {

		return neighbors < UNDERPOPULATION;

	}

	public static boolean isTwoOrThree(int neighbors) {

		return neighbors == UNDERPOPULATION || neighbors == OVERPOPULATION;

	}

	public static boolean isMoreThanThree(int neighbors) {

		return neighbors > OVERPOPULATION;

	}
	
	public static boolean isThree(int neighbors) {

		return neighbors == OVERPOPULATION;

	}	
	
	public static boolean nextStep(boolean cell, int neighbors) {

		if(isAlive(cell)) {
			if(isLessThanTwo(neighbors)) return false;
			if(isTwoOrThree(neighbors)) return true;
			if(isMoreThanThree(neighbors)) return false;		
		} else if (isThree(neighbors)) return true;
		
		return cell;
		
	}
	
	public static int countAliveNeighbors(boolean [][] world, int posx, int posy) {
		
		int alive = 0;
		
		for(int x=posx-1; x<=posx+1;x++)
			for(int y=posy-1; y<=posy+1; y++)
				if(x >= 0 && x < world.length && y >= 0 && y < world[x].length && !(x==posx && y==posy) && world[x][y] ) alive++;
		
		return alive;
	}
	
	public static boolean nextStatusOfACellInTheWorld(boolean [][] world, int posx, int posy) {
		
		int neighbors = countAliveNeighbors(world, posx, posy);
		
		return nextStep(world[posx][posy], neighbors);
	}


}
