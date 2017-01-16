package com.petra.ekids.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.petra.ekids.EkidsClass;

/**
 * Created by Ghost on 15-Oct-16.
 */

public class SplashState extends State {
    private Texture logo;
    private long startingTime;

    public SplashState(final EkidsStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, EkidsClass.WIDTH / 2, EkidsClass.HEIGHT / 2);
        this.logo = new Texture("xitrelogo.png");
        startingTime = System.currentTimeMillis();
    }

    @Override
    protected void handleinput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
//        if (TimeUtils.timeSinceMillis(startingTime) > 3000) {
//        gsm.set(new MenuState(gsm));
//        }

        handleinput();


    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(logo, 0, 0);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

        logo.dispose();
    }
}
