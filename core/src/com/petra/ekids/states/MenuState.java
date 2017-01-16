package com.petra.ekids.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Timer;
import com.petra.ekids.EkidsClass;

/**
 * Created by Ghost on 15-Oct-16.
 */
class MenuState extends State {
    private Texture mainhall, ajayImg;
    //private TextureRegion textureRegion;
    private Sprite sprite;
    private TextureAtlas textureAtlas;
    private int currentFrame = 1;
    private String currentAtlasKey = "0001";
    private Music music;
    //private long startingTime;

    MenuState(EkidsStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, EkidsClass.WIDTH / 2, EkidsClass.HEIGHT / 2);
        mainhall = new Texture("mainhall.png");
        ajayImg = new Texture("ajay.png");
        textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion("0001");
        sprite = new Sprite(region);
        sprite.setPosition(camera.position.x - ajayImg.getWidth() / 2, 50);
        final Timer timer = new Timer();

        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                currentFrame++;
                if (currentFrame > 7) {
                    currentFrame = 1;
                    timer.stop();
                    timer.clear();
                }

                currentAtlasKey = String.format("%04d", currentFrame);
                sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));

            }
        }, 0, 5 / 30.0f);

        //textureRegion = new TextureRegion(ajayHandup);

//        startingTime = System.currentTimeMillis();
    }

    @Override
    protected void handleinput() {

    }

    @Override
    public void update(float dt) {
        handleinput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(mainhall, 0, 0);
        sprite.draw(spriteBatch);
        music = Gdx.audio.newMusic(Gdx.files.internal("myname.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();


        //if (TimeUtils.timeSinceMillis(startingTime) > 2000) {
        //spriteBatch.draw(ajayHandup, camera.position.x - 38, 124,26, 96,0,0,26,96,true,false);
        //spriteBatch.draw(textureRegion,camera.position.x-38,124,0,0,26,96,1f,1f,180);
        //}
        //spriteBatch.draw(ajayHandup, camera.position.x - 38, 124);
        //spriteBatch.draw(ajayHandup,camera.position.x-38,196);
//        spriteBatch.draw(textureRegion, camera.position.x - 30, 188, 0, 0, 26, 96, 1f, 1f, 37);
//        spriteBatch.draw(textureRegion, camera.position.x - 30, 188, 0, 0, 26, 96, 1f, 1f, 53);
//        spriteBatch.draw(textureRegion, camera.position.x - 38, 196);
//        spriteBatch.draw(ajayImg, camera.position.x - ajayImg.getWidth() / 2, 50);


        spriteBatch.end();

    }

    @Override
    public void dispose() {
        mainhall.dispose();
        ajayImg.dispose();
        textureAtlas.dispose();
        music.dispose();
    }
}
