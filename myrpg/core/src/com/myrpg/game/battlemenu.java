/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class battlemenu {

     PerspectiveCamera cam;
     ShapeRenderer shaper;
     BitmapFont bf;
     Texture tex;
     public SpriteBatch sb;
   
    public battlemenu(PerspectiveCamera cam){
        this.cam = cam;
        shaper = new ShapeRenderer();
        sb = new SpriteBatch(); 
        bf = new BitmapFont();
        tex = new Texture(Gdx.files.internal("default.png"));
     }
    void drawmenu(){
        shaper.begin(ShapeType.Line);
        shaper.setColor(Color.RED);
        shaper.box(Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/10), 0, 0,( Gdx.graphics.getWidth()/10), Gdx.graphics.getHeight()/2, 0);

        shaper.end();
       
    }
    void fillmenu(){
        sb.begin();
        sb.draw(tex, Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/10),
                0f, ( Gdx.graphics.getWidth()/10),  Gdx.graphics.getHeight()/2);
        
      

  
        sb.end();
                
    
    }
}