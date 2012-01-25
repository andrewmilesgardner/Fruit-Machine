package com.badlogic.androidgames.game;

import java.util.List;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class MainMenuScreen extends Screen 
{
    public MainMenuScreen(Game game) 
    {
        super(game);      
    }   

    @Override
    public void update(float deltaTime) 
    {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();       
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) 
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) 
            {
                if(inBounds(event, 0, g.getHeight() - 64, 64, 64)) 
                {
                    Settings.soundEnabled = !Settings.soundEnabled;
                }
                if(inBounds(event, 64, 220, 192, 42) ) 
                {
                    game.setScreen(new GameScreen(game));
                    return;
                }
               
            }
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) 
    {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) 
    {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.logo, (g.getWidth()-Assets.logo.getWidth())/2, 40);
        g.drawPixmap(Assets.mainMenu, (g.getWidth()-Assets.mainMenu.getWidth())/2, 215);
        if(Settings.soundEnabled)
            g.drawPixmap(Assets.buttons, 0, 416, 0, 0, 64, 64);
        else
            g.drawPixmap(Assets.buttons, 0, 416, 64, 0, 64, 64);
    }

    @Override
    public void pause() 
    {        
        Settings.save(game.getFileIO());
    }

    @Override
    public void resume() 
    {

    }

    @Override
    public void dispose() 
    {

    }
}
