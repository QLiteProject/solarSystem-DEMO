package com.bogdan.solarsystem.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.bogdan.solarsystem.model.Body;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Body sun, earth, moon, exclusive;

    private int screenW = Gdx.graphics.getWidth();
    private int screenH = Gdx.graphics.getHeight();

    private Stage stage;
    private Button button_ssGame;
    private Skin skinPack = new Skin(Gdx.files.internal("assets/skin/skin.json"));

    private int row_height = screenW / 12;
    private int col_width =  screenH / 12;

    private boolean gameplay = true;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        button_ssGame = new TextButton("Start/Stop", skinPack);
        button_ssGame.setSize(col_width * 2, row_height / 2);
        button_ssGame.setPosition(0,0);
        button_ssGame.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                gameplay = !gameplay;
                return true;
            }});

        stage.addActor(button_ssGame);

        batch     = new SpriteBatch();

        sun       = new Body(new Texture(Gdx.files.internal("assets/sun.png")),screenW / 2, screenH / 2, 200, 200);
        exclusive = new Body(new Texture(Gdx.files.internal("assets/blue-planet.png")),  80,  80, sun,  400, (float) 0.7);
        earth     = new Body(new Texture(Gdx.files.internal("assets/earth_planet.png")), 100, 100, sun, 220, (float) 0.5);
        moon      = new Body(new Texture(Gdx.files.internal("assets/moon.png")),         30,  30, earth,90,  (float) 2);

    }

    @Override
    public void render(float v) {

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act(); stage.draw();

            batch.begin();

            sun.draw(batch);
            earth.draw(batch);
            moon.draw(batch);
            exclusive.draw(batch);

            if (gameplay) { earth.rotation(); moon.rotation(); exclusive.rotation(); }

            batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.dispose();
    }
}
