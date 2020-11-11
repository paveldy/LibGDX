package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Tank {
    private Texture texture;
    private Texture textureWeapon;
    private float x;
    private float y;
    private float speed;
    private float angle; //угол поворота танка
    private float angleWeapon;
    private Projectile projectile;
    private float scale;
    private int typeOfDirection;
    private int angleInput;

    public Tank() {
        this.texture = new Texture("tank.png");
        this.textureWeapon = new Texture("weapon.png");
        this.projectile = new Projectile();
        this.x = 100;
        this.y = 100;
        this.speed = 240;
        this.angle = 00.0f;
        this.angleWeapon = 0.0f;
        this.scale = 3.0f;


    }

    public void update(float dt) {
//        x += 100 * dt;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//            x += 100 * dt;
//            x+=speed*dt;
            angle -= 90.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//            x -= 100 * dt;
//            x-=speed*dt;
            angle += 90.0f * dt;
        }
//        ниже чтобы танк поворачивался сразу на 90 градусов
//        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
//            angle -= 90.0f;
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
//            angle += 90.0f;
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            x = checkCoordinat(x, y, dt, 1, angle)[0];
            y = checkCoordinat(x, y, dt, 1, angle)[1];
//            angle = checkCoordinat(x, y, dt, 1, angle)[2];
//            if (x >= 0 && x <= 1280 && y >= 0 && y <= 720) {
//                x += speed * MathUtils.cosDeg(angle) * dt;
//                y += speed * MathUtils.sinDeg(angle) * dt;
//            }
//            if (x < 0) {
//                x = 0;
//                y += speed * MathUtils.sinDeg(angle) * dt;
//
//            }
//            if (x > 1280) {
//                x = 1280;
//                y += speed * MathUtils.sinDeg(angle) * dt;
//            }
//            if (y < 0) {
//                y = 0;
//                x += speed * MathUtils.cosDeg(angle) * dt;
//            }
//            if (y > 720) {
//                y = 720;
//                x += speed * MathUtils.cosDeg(angle) * dt;
//            }


//            int r = 1;
//            y += 100 * dt;
//            if (checkCoorDirect == true) {
//            x += speed * MathUtils.cosDeg(angle) * dt;
//            y += speed * MathUtils.sinDeg(angle) * dt;
//            checkCoordinat(x, y, dt, r);
//            } else if (checkCoorDirect == false && angle != angleInput) {
//                checkCoorDirect = true;
//            } else {
//                checkCoorReir = true;
//                k = 5.0f;
//                x -= speed * MathUtils.cosDeg(angle) * dt * 0.4f; // умножаем на 0,2 что бы уменьшить скокрость задним ходом.
//                y -= speed * MathUtils.sinDeg(angle) * dt * 0.4f;
//        }
//            else {
//                x -= speed * MathUtils.cosDeg(angle) * dt;
//                y -= speed * MathUtils.sinDeg(angle) * dt;
//            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            x = checkCoordinat(x, y, dt, 2, angle)[0];
            y = checkCoordinat(x, y, dt, 2, angle)[1];
//            angle = checkCoordinat(x, y, dt, 2, angle)[2];

//            char S = 'S';
//            y -= 100 * dt;
//            if (checkCoorReir == true) {
//            x -= speed * MathUtils.cosDeg(angle) * dt * 0.2f; // умножаем на 0,2 что бы уменьшить скокрость задним ходом.
//            y -= speed * MathUtils.sinDeg(angle) * dt * 0.2f;
//                k = 1.0f;
//            } else {
//                x += speed * MathUtils.cosDeg(angle) * dt;
//                y += speed * MathUtils.sinDeg(angle) * dt;
//                checkCoorDirect = true;
//            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            x += 100 * dt;
//            x+=speed*dt;
            angleWeapon -= 90.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            x -= 100 * dt;
//            x-=speed*dt;
            angleWeapon += 90.0f * dt;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !projectile.isActive()) {
            projectile = new Projectile();
            projectile.shoot(x, y, angle + angleWeapon);
        }
        projectile.update(dt);
    }

    public float[] checkCoordinat(float x, float y, float dt, int typeOfDirection, float angle) {
        float[] massiveOfXY = new float[3];
//        angleInput = (int) angle % 360;
        if (typeOfDirection == 1) {
            if (x >= 0 && x <= 1280 && y >= 0 && y <= 720) {
                massiveOfXY[0] = x + speed * MathUtils.cosDeg(angle) * dt;
                massiveOfXY[1] = y + speed * MathUtils.sinDeg(angle) * dt;
//                massiveOfXY[2] = angleInput;
            }
            if (x < 0) {
                massiveOfXY[0] = 0.0f;
                massiveOfXY[1] = y + speed * MathUtils.sinDeg(angle) * dt;
//                if (angleInput > 90 && angleInput < 180) {
//                    massiveOfXY[2] = 90.0f;
//                } else if (angleInput > 180 && angleInput < 270) {
//                    massiveOfXY[2] = 270.0f;
//                } else if (angleInput > -270 && angleInput < -180) {
//                    massiveOfXY[2] = -270.0f;
//                } else if (angleInput > -90 && angleInput < -180) {
//                    massiveOfXY[2] = -90.0f;
//                }
            }
            if (x > 1280) {
                massiveOfXY[0] = 1280.0f;
                massiveOfXY[1] = y + speed * MathUtils.sinDeg(angle) * dt;
            }
            if (y < 0) {
                massiveOfXY[0] = x + speed * MathUtils.cosDeg(angle) * dt;
                massiveOfXY[1] = 0.0f;
            }
            if (y > 720) {
                massiveOfXY[0] = x + speed * MathUtils.cosDeg(angle) * dt;
                massiveOfXY[1] = 720.0f;
            }
        }
        if (typeOfDirection == 2) {
            if (x >= 0 && x <= 1280 && y >= 0 && y <= 720) {
                massiveOfXY[0] = x - speed * MathUtils.cosDeg(angle) * dt * 0.2f;
                massiveOfXY[1] = y - speed * MathUtils.sinDeg(angle) * dt * 0.2f;
            }
            if (x < 0) {
                massiveOfXY[0] = 0.0f;
                massiveOfXY[1] = y - speed * MathUtils.sinDeg(angle) * dt * 0.2f;
            }
            if (x > 1280) {
                massiveOfXY[0] = 1280.0f;
                massiveOfXY[1] = y - speed * MathUtils.sinDeg(angle) * dt * 0.2f;
            }
            if (y < 0) {
                massiveOfXY[0] = x - speed * MathUtils.cosDeg(angle) * dt * 0.2f;
                massiveOfXY[1] = 0.0f;
            }
            if (y > 720) {
                massiveOfXY[0] = x - speed * MathUtils.cosDeg(angle) * dt * 0.2f;
                massiveOfXY[1] = 720.0f;
            }
        }
        return massiveOfXY;
    }

    public void render(SpriteBatch batch) {
        // ниже строка отрисовывает такн
        batch.draw(texture, x - 20, y - 20, 20, 20, 40, 40, scale, scale, angle, 0, 0, 40, 40, false, false); //  говорим, что надо нарисовать текстуру в точку х и у.
// в x y пишем -20, чтобы смести таблицу координат в центр танка.
        //ниже строка отрисовывает башню.
        batch.draw(textureWeapon, x - 20, y - 20, 20, 20, 40, 40, scale, scale, angle + angleWeapon, 0, 0, 40, 40, false, false); //  говорим, что надо нарисовать текстуру в точку х и у.
//angle+angleWeapon - мы привязываем пушку к танку, т.е. пушка смотрит туда, куда едет танк.
        if (projectile.isActive()) {
            projectile.render(batch); //мы говорим, что после как нарисовался танк, надо рисовать пулю
        }
    }
 
    public void dispose() {
        texture.dispose();
        projectile.dispose();
    }
}
