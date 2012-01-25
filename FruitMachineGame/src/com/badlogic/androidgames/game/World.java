package com.badlogic.androidgames.game;
import android.util.Log;
import android.view.Display;

import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.game.GameScreen.GameState;

public class World 
{
    static final int WORLD_WIDTH = 10;
    static final int WORLD_HEIGHT = 13;
    static final int SCORE_INCREMENT = 10;
    static final float TICK = 0.05f;

    public Coin coinArray[] = {new Coin(Constants.COIN_1_X_POS,Constants.COIN_1_Y_POS), new Coin(Constants.COIN_2_X_POS,Constants.COIN_2_Y_POS), new Coin(Constants.COIN_3_X_POS,Constants.COIN_3_Y_POS)};
    public FruitGroup fruitArray[] = {new FruitGroup(Constants.FRUIT_STRIP_1_BUTTON_X_POS,Constants.FRUIT_STRIP_1_BUTTON_Y_POS),new FruitGroup(Constants.FRUIT_STRIP_2_BUTTON_X_POS,Constants.FRUIT_STRIP_2_BUTTON_Y_POS),new FruitGroup(Constants.FRUIT_STRIP_3_BUTTON_X_POS,Constants.FRUIT_STRIP_3_BUTTON_Y_POS)};
    public Button buttonArray[] = {new Button(Constants.STOP_FRUIT_1_X_POS,Constants.STOP_FRUIT_1_Y_POS),new Button(Constants.STOP_FRUIT_2_X_POS,Constants.STOP_FRUIT_2_Y_POS),new Button(Constants.STOP_FRUIT_3_X_POS,Constants.STOP_FRUIT_3_Y_POS)};
    
    public boolean gameOver = false;
    public int credits = 0;
    public int winnings = 0;
    public int score = 0;
	public boolean turn = false;
	public boolean playing = false;
	
    float tickTime = 0;
    static float tick = TICK;

    public World() 
    {

    }
    
    public boolean checkForWin()
    {
    	if((playing)&&(credits>0))
    	{
    		if((fruitArray[0].stopped)&&(fruitArray[1].stopped)&&(fruitArray[2].stopped))
        	{
        		if((fruitArray[0].fruitPos[1]==fruitArray[1].fruitPos[1]) && (fruitArray[0].fruitPos[1]==fruitArray[2].fruitPos[1]))
        		{
        			win();
        			return true;
        		}
        		lose();
        	}
    	}	
 	   return false;
    }
    
    public void win()
    {
    	if(Settings.soundEnabled) Assets.fly.play(1);
    	playing=false;
    	Button.flashUpdateTime=2;
		winnings+=10*credits;
		GameScreen.state=GameState.win;
		throwCoins();
		credits=0;
    }
    
    public void lose()
    {
    	if(Settings.soundEnabled) Assets.fly.play(1);
    	playing=false;
    	credits=0;
		throwCoins();
		GameScreen.state=GameState.GameOver;
    }
    
    public void throwCoins()
    {
    	for(int j=0;j<coinArray.length;j++)
    	{
    		int aNumber = (int) (Math.random() * 10 + 1);
    		int aNumber2 = (int) (Math.random() * 18 + 8);
    		if((int) (Math.random() * 2 + 1) == 2) aNumber = -aNumber;
    		aNumber2 = -aNumber2;
    		coinArray[j].setMove(aNumber, aNumber2, Coin.GRAVITY_SPEED);
    	}
    }
    
   public void play()
   {
	   for(int i=0;i<fruitArray.length;i++) fruitArray[i].setMove(0, FruitGroup.MOVESPEED);
	   playing=true;
   }
   
   public void insertCoin()
   {
	  credits+=1;
   }
   
   public void reset()
   {
	   for(int i=0;i<fruitArray.length;i++) fruitArray[i].reset();
	   for(int j=0;j<coinArray.length;j++) coinArray[j].reset();
	   coinArray[0].setPos((int)Constants.COIN_1_X_POS,(int)Constants.COIN_1_Y_POS);
	   coinArray[1].setPos((int)Constants.COIN_2_X_POS,(int)Constants.COIN_2_Y_POS);
	   coinArray[2].setPos((int)Constants.COIN_3_X_POS,(int)Constants.COIN_3_Y_POS);
	   Button.flashUpdateTime=20;
	   for(int k=0;k<buttonArray.length;k++) buttonArray[k].animationFrame = ((int) (Math.random() * 2 + 1))-1;
   }
    
    public void update(float deltaTime) 
    {
    	tickTime += deltaTime;
    	
    	while (tickTime > tick) 
        {
    		tickTime -= tick;
        	
        	// update fruit
            for(int i=0;i<fruitArray.length;i++) fruitArray[i].update(deltaTime);
            
            // update coins
            for(int j=0;j<coinArray.length;j++) coinArray[j].update(deltaTime);
            
            // update buttons
            for(int k=0;k<buttonArray.length;k++) buttonArray[k].update(deltaTime);
            
            checkForWin();
        }
    }
}
