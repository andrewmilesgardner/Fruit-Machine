package com.badlogic.androidgames.game;

import com.badlogic.androidgames.framework.math.Vector2;
import com.badlogic.androidgames.framework.gl.TextureRegion;

public class Button 
{
	public static final int ANIMATION_FLASH_1 = 0;
	public static final int ANIMATION_FLASH_2 = 1;
	public static final int ANIMATION_FLASH_3 = 2;
	public static final int ANIMATION_FLASH_4 = 3;
	//public static final int animationArray[] = {ANIMATION_FLASH_1,ANIMATION_FLASH_2,ANIMATION_FLASH_3,ANIMATION_FLASH_4};
	
	public static TextureRegion textureArray[] = {new TextureRegion(null, 0, 0, 50, 40),new TextureRegion(null, 50, 0, 50, 40)};
	public static int flashUpdateTime = 20;
	public int animationCounter = 0;
	public int animationFrame = ANIMATION_FLASH_1;
	public float x, y;
	public float walkingTime = 0;
	public Vector2 vec = new Vector2(0,0);

	public Button(float x, float y) 
	{
		animationCounter = 0;
		animationFrame = ((int) (Math.random() * 2 + 1))-1;
		setPos(x, y);
		this.vec.set(Math.random() > 0.5f?-0.5f:0.5f, 0);
		this.walkingTime = (float)Math.random() * 10;
	}

	public void setPos(float x, float y) 
	{
		this.x = x;
		this.y = y;
	}

	// update the sprite
	public void update(float deltaTime) 
	{
		if(animationCounter>=flashUpdateTime)
		{
			animationCounter=0;
			animationFrame++;
			if (animationFrame>textureArray.length-1) animationFrame=0;
		}
			
		animationCounter++;
	}

}