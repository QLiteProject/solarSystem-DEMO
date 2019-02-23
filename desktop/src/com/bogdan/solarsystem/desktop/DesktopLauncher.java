package com.bogdan.solarsystem.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bogdan.solarsystem.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200; config.height = 900; config.resizable = false; config.title = "solarSystem by QLiteProject";
		new LwjglApplication(new Main(), config);
	}
}
