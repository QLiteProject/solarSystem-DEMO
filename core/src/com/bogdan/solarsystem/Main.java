package com.bogdan.solarsystem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.bogdan.solarsystem.view.GameScreen;

public class Main extends Game {
	private Screen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
}
