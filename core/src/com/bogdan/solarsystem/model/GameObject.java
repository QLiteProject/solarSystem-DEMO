package com.bogdan.solarsystem.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    protected Rectangle bounds;
    protected Sprite object;

    private float def_radius = 0f;
    private float def_step  = 0.1f;

    private float alpha = 0f;

    private Body parent;

    public GameObject(Texture texture, float x, float y, float height, float width){
        bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
        object = new Sprite(texture);
    }

    public GameObject(Texture texture, float height, float width, Body obj, float radius, float step){
        bounds = new Rectangle(obj.bounds.x - width, obj.bounds.y, width, height);
        object = new Sprite(texture);
        parent = obj;
        def_step  = step;
        def_radius = radius;
    }

    public void rotation(){
        bounds.x = (parent.bounds.x + (parent.bounds.width / 2))  +  (float)Math.cos(Math.toRadians(alpha)) * def_radius - bounds.width / 2;
        bounds.y = (parent.bounds.y + (parent.bounds.height / 2)) +  (float)Math.sin(Math.toRadians(alpha))* def_radius - bounds.height / 2;
        alpha = alpha <= -360 ? 0 : alpha - def_step;
    }


    public void draw(SpriteBatch shell){
        object.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        object.draw(shell);
    }
}
