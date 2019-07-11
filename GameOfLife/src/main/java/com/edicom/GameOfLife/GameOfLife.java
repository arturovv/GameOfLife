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


}
