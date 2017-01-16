package com.petra.ekids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.petra.ekids.EkidsClass;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = EkidsClass.WIDTH;
        config.height = EkidsClass.HEIGHT;
        config.title = EkidsClass.TITLE;
        config.useGL30=true;
        new LwjglApplication(new EkidsClass(), config);
    }
}
