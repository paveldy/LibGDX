package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Target {

    private Texture texture;
    private float x;
    private float y;
    private Projectile projectile;


    public Target(){
        this.texture = new Texture("grass40.png");
        this.x =(float) Math.random()*1280;
        this.y =(float) Math.random()*720;
    }
    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }

    public void dispose() {
        texture.dispose();
    }

    public void update(float dt){
        new Target();

    }
    public void del(float x, float y, float dt){
        if (x<this.x+100&&x>this.x+100&& y>this.y+100&& y<this.y-100){
            update(dt);
        }

    }

}
