package com.edicom.GameOfLife;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {
	
	@Test
	public void itShouldBeTrueIfAlive(boolean cell, boolean expected) {
		
		
		boolean result = GameOfLife.isAlive(cell);
		
		Assert.assertEquals(expected, result);
		
	}

}
