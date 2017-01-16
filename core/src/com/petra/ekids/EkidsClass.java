package com.petra.ekids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.petra.ekids.states.EkidsStateManager;
import com.petra.ekids.states.SplashState;

public class EkidsClass extends ApplicationAdapter {
    public static final int WIDTH = 1600;
	public static final int HEIGHT = 1000;
	public static final String TITLE = "E KIDS";
	private SpriteBatch batch;
	private Music music;
	private EkidsStateManager gsm;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        gsm = new EkidsStateManager();
//        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
//        music.setLooping(true);
//        music.setVolume(0.1f);
//        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);

        gsm.push(new SplashState(gsm));
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
        //music.dispose();
        super.dispose();
	}
}
