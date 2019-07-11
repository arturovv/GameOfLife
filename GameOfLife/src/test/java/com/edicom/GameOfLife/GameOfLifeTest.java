package com.edicom.GameOfLife;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class GameOfLifeTest {

	@DataProvider
	public static Object[][] dataCellProviderForAlive() {

		return new Object[][] { { true, true }, { false, false }, { true, true }, };
	}

	@DataProvider
	public static Object[][] dataCellProviderForLessThanTwoNeighbors() {

		return new Object[][] { { 0, true }, { 1, true }, { 2, false }, { 3, false }, };
	}

	@DataProvider
	public static Object[][] dataCellProviderForTwoOrThree() {

		return new Object[][] { { 0, false }, { 1, false }, { 2, true }, { 3, true }, { 4, false },

		};
	}

	@DataProvider
	public static Object[][] dataCellProviderForMoreThanThree() {

		return new Object[][] { { 0, false }, { 1, false }, { 2, false }, { 3, false }, { 4, true }, { 5, true },

		};
	}

	@DataProvider
	public static Object[][] dataCellProviderForThree() {

		return new Object[][] { { 0, false }, { 1, false }, { 2, false }, { 3, true }, { 4, false },

		};
	}

	@DataProvider
	public static Object[][] dataCellProviderForNextStep() {

		return new Object[][] { { true, 0, false }, { true, 1, false }, { true, 2, true }, { true, 3, true },
				{ true, 4, false }, { true, 5, false }, { true, 6, false }, { true, 7, false }, { true, 8, false },
				{ false, 0, false }, { false, 1, false }, { false, 2, false }, { false, 3, true }, { false, 4, false },
				{ false, 5, false }, { false, 6, false }, { false, 7, false }, { false, 8, false }, };
	}
	
	private static boolean [][] testWorld1 = {
			{false, false, false},
			{true,false, false},
			{false,true,false}
	};
	
	@DataProvider
	public static Object[][] dataCellProviderForCountAliveNeighbors() {

		return new Object[][] { 
			{testWorld1, 0, 0, 1}, 
			{testWorld1, 0, 1, 1}, 
			{testWorld1, 0, 2, 0}, 
			{testWorld1, 1, 0, 1}, 
			{testWorld1, 1, 1, 2}, 
			{testWorld1, 1, 2, 1}, 
			{testWorld1, 2, 0, 2}, 
			{testWorld1, 2, 1, 1}, 
			{testWorld1, 2, 2, 1}, 

		};
	}
	
	private static boolean [][] testWorld2 = {
			{false, false, false},
			{true , true , false},
			{false, true , false}
	};
	
	
	@DataProvider
	public static Object[][] dataCellProviderForNextStatusOfACellInTheWorld() {

		return new Object[][] { 
			{testWorld2, 0, 0, false}, 
			{testWorld2, 0, 1, false}, 
			{testWorld2, 0, 2, false}, 
			{testWorld2, 1, 0, true}, 
			{testWorld2, 1, 1, true}, 
			{testWorld2, 1, 2, false}, 
			{testWorld2, 2, 0, true}, 
			{testWorld2, 2, 1, true}, 
			{testWorld2, 2, 2, false}, 

		};
	}

	@Test
	@UseDataProvider("dataCellProviderForAlive")
	public void itShouldBeTrueIfAlive(boolean cell, boolean expected) {

		boolean result = GameOfLife.isAlive(cell);

		Assert.assertEquals(expected, result);

	}

	@Test
	@UseDataProvider("dataCellProviderForLessThanTwoNeighbors")
	public void itShouldBeTrueIfLessThanTwoNeighbors(int neighbors, boolean expected) {

		boolean result = GameOfLife.isLessThanTwo(neighbors);

		Assert.assertEquals(expected, result);

	}

	@Test
	@UseDataProvider("dataCellProviderForTwoOrThree")
	public void itShouldBeTrueIfItIsTwoOrThree(int neighbors, boolean expected) {

		boolean result = GameOfLife.isTwoOrThree(neighbors);

		Assert.assertEquals(expected, result);

	}

	@Test
	@UseDataProvider("dataCellProviderForMoreThanThree")
	public void itShouldBeTrueIfMoreThanThree(int neighbors, boolean expected) {

		boolean result = GameOfLife.isMoreThanThree(neighbors);

		Assert.assertEquals(expected, result);

	}

	@Test
	@UseDataProvider("dataCellProviderForThree")
	public void itShouldBeTrueIfItIsThree(int neighbors, boolean expected) {

		boolean result = GameOfLife.isThree(neighbors);

		Assert.assertEquals(expected, result);

	}

	@Test
	@UseDataProvider("dataCellProviderForNextStep")
	public void testNextStep(boolean cell, int neighbors, boolean expected) {

		boolean result = GameOfLife.nextStep(cell, neighbors);

		Assert.assertEquals(expected, result);

	}
	
	@Test
	@UseDataProvider("dataCellProviderForCountAliveNeighbors")
	public void testCountAliveNeighbors(boolean [][] world, int x, int y, int expected) {

		int result = GameOfLife.countAliveNeighbors(world, x, y);

		Assert.assertEquals(expected, result);

	}
	
	
	@Test
	@UseDataProvider("dataCellProviderForNextStatusOfACellInTheWorld")
	public void testNextStatusOfACellInTheWorld(boolean [][] world, int x, int y, boolean expected) {

		boolean result = GameOfLife.nextStatusOfACellInTheWorld(world, x, y);

		Assert.assertEquals(expected, result);

	}
	
	
	@Test
	@UseDataProvider("dataCellProviderForNextWorld")
	public void testNextWorld(boolean [][] world, boolean [][] expected) {

		boolean [][] result = GameOfLife.nextWorld(world);

		Assert.assertEquals(expected, result);

	}
	

}
