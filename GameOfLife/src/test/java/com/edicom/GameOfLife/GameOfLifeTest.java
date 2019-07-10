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
	
	
	
	@Test
	@UseDataProvider("dataCellProviderForAlive")
	public void itShouldBeTrueIfAlive(boolean cell, boolean expected) {
		
		
		
		boolean result = GameOfLife.isAlive(cell);
		
		Assert.assertEquals(expected, result);
		
	}

}
