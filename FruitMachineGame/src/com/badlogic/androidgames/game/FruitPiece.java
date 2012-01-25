package com.badlogic.androidgames.game;

import com.badlogic.androidgames.framework.math.Vector2;

public class FruitPiece 
{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	private static final int MOVESPEED = 5;
	public int x, y;
	private Vector2 vec = new Vector2(0,0);
	 
    public FruitPiece(int x, int y) 
    {
    	this.x = x;
		this.y = y;
		vec = new Vector2(0,0);
    }
    
    
}       

