package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

// создаем снаряд
public class Projectile {
    public float x;
    public float y;
    private float vx;  // скорость по х
    private float vy;  // скорость по у
    private Texture texture;
    private boolean active;
    private float speed;
    private Target target;

    public boolean isActive() {
        return active;
    }

    public Projectile() {
        this.speed = 600.0f;
        texture = new Texture("projectile.png");

    }

    public void shoot(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.vx = speed * MathUtils.cosDeg(angle);
        this.vy = speed * MathUtils.sinDeg(angle);
        this.active = true;



    }

    public void update(float dt) {
        x += vx * dt;
        y += vy * dt;
        if(x > 0 && x < 1280 && y > 0 && y < 720){
                target.del(x,y,dt);
        }
        if (x < 0 || x > 1280 || y < 0 || y > 720) {
            active = false;
        }

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 8, y - 8, 8, 8, 16, 16, 2, 2, 0, 0, 0, 16, 16, false, false);
    }

    public void dispose() {
        texture.dispose();

    }
}
