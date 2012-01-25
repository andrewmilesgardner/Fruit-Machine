package com.badlogic.androidgames.game;

import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.Game;
import android.graphics.Color;
import android.util.Log;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Animation;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;
import com.badlogic.androidgames.framework.impl.GLGraphics;
import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.Screen;


import android.app.Activity;

public class GameScreen extends Screen 
{
    enum GameState {Running,Paused,GameOver,win}
    
    // assets
    private Pixmap fruitArray1[] = {Assets.fruitOrange1_1, Assets.fruitStrawberry1_1, Assets.fruitBanana1_1, Assets.fruitCherry1_1, Assets.fruitGrape1_1, Assets.fruitApple1_1,Assets.fruitWaterMelon1_1,Assets.fruitOrange2_1, Assets.fruitStrawberry2_1, Assets.fruitBanana2_1, Assets.fruitCherry2_1, Assets.fruitGrape2_1, Assets.fruitApple2_1,Assets.fruitWaterMelon2_1};
    private Pixmap fruitArray2[] = {Assets.fruitOrange1_2, Assets.fruitStrawberry1_2, Assets.fruitBanana1_2, Assets.fruitCherry1_2, Assets.fruitGrape1_2, Assets.fruitApple1_2,Assets.fruitWaterMelon1_2,Assets.fruitOrange2_2, Assets.fruitStrawberry2_2, Assets.fruitBanana2_2, Assets.fruitCherry2_2, Assets.fruitGrape2_2, Assets.fruitApple2_2,Assets.fruitWaterMelon2_2};
    private Pixmap fruitArray3[] = {Assets.fruitOrange1_3, Assets.fruitStrawberry1_3, Assets.fruitBanana1_3, Assets.fruitCherry1_3, Assets.fruitGrape1_3, Assets.fruitApple1_3,Assets.fruitWaterMelon1_3,Assets.fruitOrange2_3, Assets.fruitStrawberry2_2, Assets.fruitBanana2_3, Assets.fruitCherry2_3, Assets.fruitGrape2_3, Assets.fruitApple2_3,Assets.fruitWaterMelon2_3}; 
    public static GameState oldState, state = GameState.GameOver;
    private World world;

    public static Game game = null;
    
    public GameScreen(Game game) 
    {
        super(game);
        this.game = game; 
        world = new World();
        state = GameState.GameOver;
    }

    @Override
    public void update(float deltaTime) 
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();      
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents, deltaTime);      
        if(state == GameState.win)
            updateWin(touchEvents, deltaTime);       
    }
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) 
    {
    	 world.update(deltaTime);
    	 
    	 int len = touchEvents.size();
         for(int i = 0; i < len; i++) 
         {
        	 TouchEvent event = touchEvents.get(i);
        	 if(event.type == TouchEvent.TOUCH_UP) 
        	 {
        		 if(event.x > Constants.PAUSE_BUTTON_X_POS && event.x <= Constants.PAUSE_BUTTON_X_POS+64) {
                     if(event.y > Constants.PAUSE_BUTTON_Y_POS && event.y <= Constants.PAUSE_BUTTON_Y_POS+64) {
                    	 oldState=state;
                         state = GameState.Paused;
                        
                         return;
                    	 
                     }
        		 } // define the stop fruit spin 1 button
        		 if(event.x > Constants.FRUIT_STRIP_1_BUTTON_X_POS && event.x <= Constants.FRUIT_STRIP_1_BUTTON_X_POS+50) {
                     if(event.y > (Constants.FRUIT_STRIP_1_BUTTON_Y_POS-150) && event.y <= Constants.FRUIT_STRIP_1_BUTTON_Y_POS) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[0].pressed=true;
                         return;
                    	 
                     }
        		 } // define the stop fruit spin 2 button
        		 if(event.x > Constants.FRUIT_STRIP_2_BUTTON_X_POS && event.x <= Constants.FRUIT_STRIP_2_BUTTON_X_POS+50) {
                     if(event.y > (Constants.FRUIT_STRIP_2_BUTTON_Y_POS-150) && event.y <= Constants.FRUIT_STRIP_2_BUTTON_Y_POS) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[1].pressed=true;
                    	
                         return;
                    	 
                     }
        		 } // define the stop fruit spin 3 button
        		 if(event.x > Constants.FRUIT_STRIP_3_BUTTON_X_POS && event.x <= Constants.FRUIT_STRIP_3_BUTTON_X_POS+50) {
                     if(event.y > (Constants.FRUIT_STRIP_2_BUTTON_Y_POS-150) && event.y <= Constants.FRUIT_STRIP_3_BUTTON_Y_POS) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[2].pressed=true;
                         return;
                    	 
                     }
        		 }
        		 if(event.x > Constants.STOP_FRUIT_1_X_POS && event.x <= Constants.STOP_FRUIT_1_X_POS+50) {
                     if(event.y > (Constants.STOP_FRUIT_1_Y_POS) && event.y <= Constants.STOP_FRUIT_1_Y_POS+50) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[0].pressed=true;
                         return;
                    	 
                     }
        		 }
        		 if(event.x > Constants.STOP_FRUIT_2_X_POS && event.x <= Constants.STOP_FRUIT_2_X_POS+50) {
                     if(event.y > (Constants.STOP_FRUIT_2_Y_POS) && event.y <= Constants.STOP_FRUIT_2_Y_POS+50) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[1].pressed=true;
                         return;
                    	 
                     }
        		 }
        		 if(event.x > Constants.STOP_FRUIT_3_X_POS && event.x <= Constants.STOP_FRUIT_3_X_POS+50) {
                     if(event.y > (Constants.STOP_FRUIT_3_Y_POS) && event.y <= Constants.STOP_FRUIT_3_Y_POS+50) {
                    	 if(Settings.soundEnabled) Assets.select.play(1);
                    	 world.fruitArray[2].pressed=true;
                         return; 
                     }
        		 }
             }
         }
    }
    
    private void updatePaused(List<TouchEvent> touchEvents) 
    {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > Constants.PAUSE_RESUME_X_POS && event.x <= Constants.PAUSE_RESUME_X_POS+160) {
                    if(event.y > Constants.PAUSE_RESUME_Y_POS && event.y <= Constants.PAUSE_RESUME_Y_POS+48) {
                       state = oldState;
                        return;
                    }                    
                    else if(event.y > Constants.PAUSE_QUIT_Y_POS && event.y < Constants.PAUSE_QUIT_Y_POS+48) {
                        game.setScreen(new MainMenuScreen(game));                        
                        return;
                    }
                }
            }
        }
    }
    
    private void updateGameOver(List<TouchEvent> touchEvents, float deltaTime) 
    {
    	world.update(deltaTime);
    	
    	 int len = touchEvents.size();
         for(int i = 0; i < len; i++) 
         {
        	 TouchEvent event = touchEvents.get(i);
        	 if(event.type == TouchEvent.TOUCH_UP) {
        		 if(event.type == TouchEvent.TOUCH_UP) 
            	 {
            		 if(event.x > Constants.PAUSE_BUTTON_X_POS && event.x <= Constants.PAUSE_BUTTON_X_POS+64) {
                         if(event.y > Constants.PAUSE_BUTTON_Y_POS && event.y <= Constants.PAUSE_BUTTON_Y_POS+64) {
                        	 oldState=state;
                             state = GameState.Paused;
                             return;
                        	 
                         }
            		 }
            	 }
        	 if (event.x > Constants.COIN_BUTTON_X_POS
					&& event.x <= Constants.COIN_BUTTON_X_POS + 100) {
				if (event.y > (Constants.COIN_BUTTON_Y_POS)
						&& event.y <= Constants.COIN_BUTTON_Y_POS + 50) {
					if (Settings.soundEnabled) Assets.coin.play(1);
					world.reset();
					world.insertCoin();
					return;
				}
			}
			if (event.x > Constants.GAMBLE_BUTTON_X_POS
					&& event.x <= Constants.GAMBLE_BUTTON_X_POS + 100) {
				if (event.y > (Constants.GAMBLE_BUTTON_Y_POS)
						&& event.y <= Constants.GAMBLE_BUTTON_Y_POS + 50) {

					if (world.credits > 0) {
						if (Settings.soundEnabled)
							Assets.select.play(1);
						
						state = GameState.Running;
						world.play();
					}
					return;
				}
			}
        	 }
         }
    }
    
    private void updateWin(List<TouchEvent> touchEvents, float deltaTime) 
    {
    	updateGameOver(touchEvents, deltaTime);
    }
    
    @Override
    public void present(float deltaTime) 
    {
        Graphics g = game.getGraphics();

        g.clear(Color.BLACK);
        drawWorld(world);
        
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();
        if(state == GameState.win)
            drawWin();
        
        String pointsString = "000000";
        pointsString = pointsString.substring(0, (pointsString.length()-Integer.toString(world.winnings).length()))+world.winnings;
        drawText(g, pointsString, g.getWidth() / 2 - pointsString.length()*20 / 2, g.getHeight() - 48);                
    }
    
    private void drawWorld(World world) 
    {
        Graphics g = game.getGraphics();
        for(int i = 0; i < world.fruitArray[0].parts.size(); i++) 
        {
        	for(int j=0; j<world.fruitArray.length;j++) 
        	{
        		FruitPiece piece = world.fruitArray[j].parts.get(i);
        		g.drawPixmap(fruitArray1[i], piece.x, piece.y);
        	}
        }
    }
    
    private void drawPausedUI() 
    {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.panelTop, 0, (Constants.FRUIT_Y_POS-150)-(Assets.panelTop.getHeight()));
        g.drawPixmap(Assets.panelBottom, 0, Constants.FRUIT_Y_POS);
        g.drawPixmap(Assets.buttons, Constants.PAUSE_BUTTON_X_POS, Constants.PAUSE_BUTTON_Y_POS, 64, 128, 64, 64);
        g.drawPixmap(Assets.pause, Constants.PAUSE_MENU_X_POS, Constants.PAUSE_MENU_Y_POS);
    }
    
    private void drawRunningUI() 
    {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.panelTop, 0, (Constants.FRUIT_Y_POS-150)-(Assets.panelTop.getHeight()));
        g.drawPixmap(Assets.panelBottom, 0, Constants.FRUIT_Y_POS);
        g.drawPixmap(Assets.buttons, Constants.PAUSE_BUTTON_X_POS, Constants.PAUSE_BUTTON_Y_POS, 64, 128, 64, 64);
        
        String pointsString = "000000";
        pointsString = pointsString.substring(0, (pointsString.length()-Integer.toString(world.credits).length()))+world.credits;
        
        drawText(g, pointsString, (g.getWidth() / 2)+27 , 10);
        
        g.drawPixmap(Assets.button, Constants.COIN_BUTTON_X_POS, Constants.COIN_BUTTON_Y_POS, 0, 200, 100, 40);
        g.drawPixmap(Assets.button, Constants.GAMBLE_BUTTON_X_POS, Constants.GAMBLE_BUTTON_Y_POS, 0, 150, 100, 40);
        
        for(int i = 0; i<world.buttonArray.length;i++) g.drawPixmap(Assets.button, (int)world.buttonArray[i].x, (int)world.buttonArray[i].y, (int)Button.textureArray[world.buttonArray[i].animationFrame].u1, (int)Button.textureArray[world.buttonArray[i].animationFrame].v1, (int)Button.textureArray[world.buttonArray[i].animationFrame].u2, (int)Button.textureArray[world.buttonArray[i].animationFrame].v2);      
        for (int i=0; i<world.coinArray.length; i++) g.drawPixmap(Assets.coinImg, (int)world.coinArray[i].x, (int)world.coinArray[i].y);

    }
    
    private void drawGameOverUI() 
    {
    	drawRunningUI();
    }
    
    private void drawWin() 
    {
    	Graphics g = game.getGraphics();

        g.drawPixmap(Assets.panelTop, 0, (Constants.FRUIT_Y_POS-150)-(Assets.panelTop.getHeight()));
        g.drawPixmap(Assets.panelBottom, 0, Constants.FRUIT_Y_POS);
        g.drawPixmap(Assets.buttons, Constants.PAUSE_BUTTON_X_POS, Constants.PAUSE_BUTTON_Y_POS, 64, 128, 64, 64);
        
        String pointsString = "000000";
        pointsString = pointsString.substring(0, (pointsString.length()-Integer.toString(world.credits).length()))+world.credits;
        
        drawText(g, pointsString, (g.getWidth() / 2)+27 , 10);
        
        g.drawPixmap(Assets.button, Constants.COIN_BUTTON_X_POS, Constants.COIN_BUTTON_Y_POS, 0, 200, 100, 40);
        g.drawPixmap(Assets.button, Constants.GAMBLE_BUTTON_X_POS, Constants.GAMBLE_BUTTON_Y_POS, 0, 150, 100, 40);
        
        for(int i = 0; i<world.buttonArray.length;i++) g.drawPixmap(Assets.button, (int)world.buttonArray[i].x, (int)world.buttonArray[i].y, (int)Button.textureArray[world.buttonArray[i].animationFrame].u1, (int)Button.textureArray[world.buttonArray[i].animationFrame].v1, (int)Button.textureArray[world.buttonArray[i].animationFrame].u2, (int)Button.textureArray[world.buttonArray[i].animationFrame].v2);
                       
        for (int i=0; i<world.coinArray.length; i++) g.drawPixmap(Assets.coinImg, (int)world.coinArray[i].x, (int)world.coinArray[i].y);
    }
    
    public void drawText(Graphics g, String line, int x, int y) 
    {
        int len = line.length();
        for (int i = 0; i < len; i++) 
        {
            char character = line.charAt(i);

            if (character == ' ') 
            {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') 
            {
                srcX = 200;
                srcWidth = 10;
            } else 
            {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }
    
    @Override
    public void pause() 
    {
        if(state == GameState.Running) state = GameState.Paused;

    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
        
    }
}