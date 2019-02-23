package com.bogdan.solarsystem.model;

import com.badlogic.gdx.graphics.Texture;

public class Body extends GameObject {

    public Body(Texture texture, float x, float y, float height, float width) {
        super(texture, x, y, height, width);
    }

    public Body(Texture texture, float height, float width, Body obj, float radius,  float def_step){
        super(texture, height, width, obj, radius, def_step);
    }
}


