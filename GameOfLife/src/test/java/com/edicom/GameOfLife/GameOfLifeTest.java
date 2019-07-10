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
	public static Object[][] dataCellProviderForAlive(){
		
		return new Object[][] {
			{true, true},
			{false, false},
			{true, true},
			};
	}
	
	@DataProvider
	public static Object[][] dataCellProviderForLessThanTwoNeighbors(){
		
		return new Object[][] {
			{0, true},
			{1, true},
			{2, false},
			{3, false},
			};
	}
	
	
	@DataProvider
	public static Object[][] dataCellProviderForTwoOrThree(){
		
		return new Object[][] {
			{0, false},
			{1, false},
			{2, true},
			{3, true},
			{4, false},

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
	
	

}
