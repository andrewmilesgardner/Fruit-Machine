package com.badlogic.androidgames.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class FruitGroup 
{
    public List<FruitPiece> parts = new ArrayList<FruitPiece>();
    public static final int NUM_FRUIT = 14;
    public static final float MOVESPEED = 16;
	public int x, y;
	public int startPos = 0;
	private boolean checkBounds = false;
	private int loopPos = 0;
	public Vector2 vec = new Vector2(0,0);
	public boolean stopped = false;
	public boolean pressed = false;
	public boolean readyToStop = false;
	private int stopPos = -1;
	public int[] fruitPos = new int[] { -1, -1, -1 };
    
    public FruitGroup(int x, int y) 
    {   
    	// create a fruit strip
    	for (int i=0; i<NUM_FRUIT; i++) parts.add(new FruitPiece(x, y+(FruitPiece.HEIGHT*i)));
    	
    	this.checkBounds=checkBounds;
    	this.x=x;
    	this.y=y;
    	
    	setPosition2(x, y, NUM_FRUIT-1); 
    	startPos=x;
    	this.loopPos=y;
    }
    
    public int checkForPieceToStopAt(int pos)
    {
    	for (int i=0; i<NUM_FRUIT; i++) 
	    {
    		if (parts.get(i).y > pos)
    		{
    			return i-1;
    		}	
    	}
    	return -1;
    }
    
    public void stopAtPos(int pos, int x, int y)
    {
    	for (int i=0; i<NUM_FRUIT; i++) 
    	{
    		parts.get(i).y = y;
    		int calc2 = (i-pos)*FruitPiece.HEIGHT;
    		parts.get(i).y += (i-pos)*FruitPiece.HEIGHT;
    	}
    	this.x=parts.get(0).x;
    	this.y=parts.get(0).y;
    }
    
    public void setPosition(int x, int y) 
    {
    	this.x=x;
    	this.y=y;
    	
    	 for(int i = 0; i < parts.size(); i++) 
         {
    		 parts.get(i).x = x;
    		 parts.get(i).y = y+(FruitPiece.HEIGHT*(i+1));
         }
    }
    
    // need to make this method so it puts the any piece in right place from any piece number
    public void setPosition2(int x, int y, int pieceNum) 
    {
    	int count = 1;
    	for(int i = parts.size()-1; i >-1; i--) 
        {
    		parts.get(i).x = x;
    		parts.get(i).y = y - (FruitPiece.HEIGHT*(count));
    		count++;
    		this.x=parts.get(i).x;
    	    this.y=parts.get(i).y;
        }
    }
    
    public void reset() 
    {
    	pressed=false;
    	stopped=false;
    	readyToStop=false;
    	vec.y = 0;
    }
    
    public void setMove(float vx, float vy) 
	{
		vec.x = vx;
		vec.y = vy;
	}
    
    public void update(float deltaTime) 
    {
    	if(!stopped)
        {
    		this.x += vec.x; /* * deltaTime*/;
        	this.y += vec.y; /* * deltaTime*/;
            
            for(int i = parts.size()-1; i > -1; i--) 
            {
            	parts.get(i).y += vec.y /* * deltaTime*/;
            }
            
            if(pressed)
            {
            	if (!readyToStop) stopPos = checkForPieceToStopAt(this.loopPos);
            	if(stopPos != -1)
            	{
            		readyToStop=true;
            		if (checkPutBack(stopPos,this.loopPos,stopPos,this.loopPos)) 
            		{
            			stopped=true;
            			for (int k=0; k<3; k++) fruitPos[k]=stopPos-(2-k);
            		}
            	}
            }
            else
            {
            	checkPutBack(6,this.loopPos,NUM_FRUIT-1,parts.get(6).y);
            }
        }
    }   
    
    public boolean checkPutBack(int pointer, int pos,int point,int y)
    {
    	if (parts.get(pointer).y > pos) 
    	{
    		stopAtPos(point,this.x,y);
    		return true;
    	}
    	return false;
    }
    
  
}
