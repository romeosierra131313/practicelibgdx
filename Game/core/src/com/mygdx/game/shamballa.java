/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.mygdx.game.towns.locationmap;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Constants.place;
import java.util.Iterator;

/**
 *
 * @author Stefan
 */
public class shamballa extends ApplicationAdapter implements InputProcessor{
     

       
    
       Stage stage;
       Skin skin;
       Texture test;
       SpriteBatch sb;
       place place;
       cursor cursor;
       overworld overworld;
       locationmap locationmap;
       Texture t ;
       Sprite s;
        final float worldheight = 720;
       OrthographicCamera cam;
       Rectangle r;
        
    public shamballa(Stage stage,Skin skin){
        
                 this.stage = stage;
                 this.skin = skin;

                cam = new OrthographicCamera(); // set 0,0 to bottom left 
                cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/
                               Gdx.graphics.getHeight(),720);  // turn it right side up
                
                cam.update();
               
                locationmap = new locationmap();  //creates hash map with over wold coords
                place = place.overworld;
                overworld = new overworld();                               
    
                sb = new SpriteBatch();
        
         Gdx.input.setInputProcessor(this);
    
    }
 
    public void Resize(int height,int width){
            cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/Gdx.graphics.getHeight(),720);   
            sb.setProjectionMatrix(cam.combined);
            cam.update();
    }    
       @Override
     public void render(){
                Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                
               
                sb.setProjectionMatrix(cam.combined);
                    sb.begin();
                        
                        overworld.drawworld(sb);
                        
                       
                    sb.end();
  
                stage.draw();
   
     
     }



    @Override
    public boolean keyDown(int i) {
      
                     if(Gdx.input.isKeyJustPressed(Keys.A)){
                         }
                     if(Gdx.input.isKeyJustPressed(Keys.S)){
                         }
                                                    return true;
    }

    @Override
    public boolean keyUp(int i) {
 return true;  }

    @Override
    public boolean keyTyped(char c) {
       return false; }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
                System.out.println("t");
               Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
               cam.unproject(touchPos);
               
                  for(Rectangle r : overworld.townrec ){
                     if(r.contains(touchPos.x, touchPos.y)){
                         openmenu(overworld.townrec.iterator());
                       System.out.println(overworld.townrec.get(i3));
                  }else { System.out.println("not touched");}
                  
                  }
              
           
        return false;  }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
       return false;  }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;  }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;  }

    @Override
    public boolean scrolled(int i) {
        return false; }

    private void openmenu(Iterator<Rectangle> iterator) {
        System.out.println(iterator);  }



}
