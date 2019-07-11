package com.edicom.GameOfLife;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	Scanner sc = new Scanner(System.in);
        System.out.println( "Height: " );
    	int height = Integer.valueOf(sc.nextLine()).intValue();
        System.out.println( "Width: " );
    	int width = Integer.valueOf(sc.nextLine()).intValue();
   	
    	
    	String entrada = "";
    	
		while(!entrada.equals("exit")) {
			
	    	boolean [][] world = new boolean[height][width];
    	
			System.out.println("Valores random?");
			int random = Integer.valueOf(sc.nextLine()).intValue();
    	
			for(int i=0; i<height; i++)
				for(int y=0; y<width; y++) {
    			
					if (random == 1) world[i][y] = Math.random() > 0.5 ? true : false;
					else {
						System.out.println( "Celda (" + i +", " + y +"): ");
						int cell = Integer.valueOf(sc.nextLine()).intValue();
						world[i][y] = cell == 1 ? true : false;
						printWorld(world);
					}
				}
    	
			if (random == 1) printWorld(world);

			System.out.println("Pulsa Enter para empezar. Exit para salir. Reset para reinicar.");
    	
			entrada = sc.nextLine();
    	
			while(!entrada.equals("exit") && !entrada.equals("reset")) {
    		
				world = GameOfLife.nextWorld(world);
				printWorld(world);
				entrada = sc.nextLine();
    		
			}
		}
    	
    	System.out.println("Adiós");



    }
    
    public static void printWorld(boolean [][] world ) {
    	
    	for(int i=0; i<world.length; i++) {
    		System.out.println();
    		for(int y=0; y<world[i].length; y++) {
    			String salida = world[i][y] ? "X" : " ";
    			System.out.print("[" + salida + "] ");
    		}
    	}
    	
		System.out.println();
    
    }
}
