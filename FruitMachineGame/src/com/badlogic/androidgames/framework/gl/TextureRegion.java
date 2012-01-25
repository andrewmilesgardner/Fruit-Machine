package com.badlogic.androidgames.framework.gl;

public class TextureRegion {    
    public final float u1, v1;
    public final float u2, v2;
    public final Texture texture;
    
    public TextureRegion(Texture texture, float x, float y, float width, float height) {
        this.u1 = x ;
        this.v1 = y ;
        this.u2 = width;
        this.v2 = height;        
        this.texture = texture;
    }
}
