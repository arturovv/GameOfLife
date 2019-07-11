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

}
