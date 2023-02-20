package com.timesupteam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.timesupteam.screens.PlayScreen;

public class TimesUpTeamGame extends Game {

	// Virtual width and height
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;

	// PPM - pixels per meter
	public static final float PPM = 100;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
