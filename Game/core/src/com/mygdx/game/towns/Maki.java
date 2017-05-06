/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.towns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Constants;

/**
 *
 * @author Stefan
 */
public class Maki extends town {
    
    Vector2 makilocation = new Vector2();
    
    public Maki(){
    
    name = "Maki";
    x = 400;
    y = 260;
    
    townt = new Texture(Gdx.files.internal("town.jpg"));
    towns = new Sprite(townt);
    r.set(x,y, rside, rside);

   
    }
    public void setuptown(){
        towns.setSize(32  , 32);
        towns.setPosition(x,y);
    }
}
