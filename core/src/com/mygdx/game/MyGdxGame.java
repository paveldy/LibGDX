package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch; // грубо говоря рабочий экран
    //  private Texture img; //картинка видео памяти
    //private float x;
    private Tank tank;
    private Target target;

    @Override
    public void create() {   // создаем СпарйтБатч и Текстуру
        batch = new SpriteBatch();
        tank = new Tank();
        target = new Target();
//        img = new Texture("tank.png");
//        x = 0.0f;
    }

    @Override
    public void render() { // отрисовка по умолчанию стоит 60FPS (60 раз в секунду)
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // альфа - прозрачность цвета, 0.1 - очень прозрачный цвет
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin(); //начинаем рисоавть. ниже ВСЕ рисуем

//        batch.draw(img, x, 0); //начинаем движение , так как х увеличивается выше с каждым обновлением
        tank.render(batch);
        target.render(batch);



        batch.end();// заканчиваем рисовать
    }

    //создаем метод для рисования объекта и его движения
    public void update(float dt) {
        tank.update(dt);
//        x += 100 * dt;  //меняем координату за дельта тайм, которую получаем выше.100 - скоростьь движения за 1 сек
// ниже провекряем координаты
//        if (Gdx.input.justTouched()) {
//            System.out.println(Gdx.input.getX());
//            System.out.println(Gdx.graphics.getHeight() - Gdx.input.getX());
//        }
        target.update(dt);


    }

    @Override
    public void dispose() { // при закрытии приложения мы должны очистить видепамять. Для этого есть этот метод
        batch.dispose();
//        img.dispose();
        tank.dispose();
        target.dispose();
    }
}
