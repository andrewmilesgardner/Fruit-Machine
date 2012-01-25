package com.badlogic.androidgames.game;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen
{
    public LoadingScreen(Game game) 
    {
        super(game);
    }

    @Override
    public void update(float deltaTime) 
    {
        Graphics g = game.getGraphics();
        // loop through all the assets and load a loading bar
        
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.button = g.newPixmap("button.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);     
        Assets.select = game.getAudio().newSound("select.wav");  
        Assets.fly = game.getAudio().newSound("fly.wav"); 
        Assets.coin = game.getAudio().newSound("coin.wav"); 
        Assets.fruitStrawberry1_1 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange1_1 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape1_1 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon1_1 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry1_1 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana1_1 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple1_1 = g.newPixmap("apple.png", PixmapFormat.ARGB4444);
        Assets.fruitStrawberry2_1 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange2_1 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape2_1 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon2_1 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry2_1 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana2_1 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple2_1 = g.newPixmap("apple.png", PixmapFormat.ARGB4444); 
        Assets.fruitStrawberry1_2 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange1_2 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape1_2 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon1_2 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry1_2 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana1_2 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple1_2 = g.newPixmap("apple.png", PixmapFormat.ARGB4444);
        Assets.fruitStrawberry2_2 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange2_2 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape2_2 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon2_2 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry2_2 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana2_2 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple2_2 = g.newPixmap("apple.png", PixmapFormat.ARGB4444);      
        Assets.fruitStrawberry1_3 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange1_3 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape1_3 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon1_3 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry1_3 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana1_3 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple1_3 = g.newPixmap("apple.png", PixmapFormat.ARGB4444);
        Assets.fruitStrawberry2_3 = g.newPixmap("strawberry.png", PixmapFormat.ARGB4444);
        Assets.fruitOrange2_3 = g.newPixmap("orange.png", PixmapFormat.ARGB4444);
        Assets.fruitGrape2_3 = g.newPixmap("grape.png", PixmapFormat.ARGB4444);
        Assets.fruitWaterMelon2_3 = g.newPixmap("watermelon.png", PixmapFormat.ARGB4444);
        Assets.fruitCherry2_3 = g.newPixmap("cherry.png", PixmapFormat.ARGB4444);
        Assets.fruitBanana2_3 = g.newPixmap("banana.png", PixmapFormat.ARGB4444);
        Assets.fruitApple2_3 = g.newPixmap("apple.png", PixmapFormat.ARGB4444);      
        Assets.panelTop = g.newPixmap("panel.png", PixmapFormat.ARGB4444);
        Assets.panelBottom = g.newPixmap("panel.png", PixmapFormat.ARGB4444);   
        Assets.coinsImg = g.newPixmap("coins.png", PixmapFormat.ARGB4444);
        Assets.coinImg = g.newPixmap("coin.png", PixmapFormat.ARGB4444);
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) 
    {

    }

    @Override
    public void pause() 
    {

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