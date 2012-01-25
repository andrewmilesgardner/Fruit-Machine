package com.badlogic.androidgames.game;

import com.badlogic.androidgames.framework.math.Vector2;

public class Coin 
{
	public static final float GRAVITY_SPEED = 3;
	private static double gravity = 0.0;
	public float x, y;
	public Vector2 vec = new Vector2(0,0);

	public Coin(float x, float y) 
	{
		setPos(x, y);
		vec = new Vector2(0,0);
		gravity=0;
	}
	
	public void reset() 
	{
		gravity= 0.0;
		setMove(0, 0, 0.0);
	}
	
	public void setPos(float x, float y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public void setMove(float vx, float vy,double gravity) 
	{
		this.gravity=gravity;
		vec.x = vx;
		vec.y = vy;
	}

	// moves the sprite
	public void update(float deltaTime) 
	{
		// apply gravity
		vec.y += gravity;
		
		this.x += vec.x /** deltaTime */;
		this.y += vec.y /** deltaTime */;
	}

}