/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.towns.Maki;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Stefan
 */
public class overworld {
       Texture world;
       float worldx = 0;
       float worldy = 0;
       ArrayList<Rectangle> townrec = new ArrayList();
       
       Vector2 v = new Vector2();
       public HashMap <String,Vector2> townloc = new HashMap<String,Vector2>();
      
       Maki maki;
       
       
       
       
       
       
      
      
       
       public overworld(){
           
       maki = new Maki();
       maki.setuptown();
       townrec.add(0,maki.r);
       world = new Texture(Gdx.files.internal("world.jpg"));
       
      
       
     
       
       }
       
       void drawworld(SpriteBatch sb){
       
           
       sb.draw(world, worldx, worldy);
       maki.towns.draw(sb);
   
       }

   

}
