package com.petra.ekids.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Ghost on 8/17/2016.
 */
abstract class State {
    OrthographicCamera camera;
    EkidsStateManager gsm;

    State(EkidsStateManager gsm) {
        this.gsm = gsm;
        Vector3 mouse = new Vector3();
        this.camera = new OrthographicCamera();
    }

    protected abstract void handleinput();

    public abstract void update(float dt);


    public abstract void render(SpriteBatch spriteBatch);

    public abstract void dispose();
}
