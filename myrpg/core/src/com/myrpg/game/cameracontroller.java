
package com.myrpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;
import static com.badlogic.gdx.utils.Select.instance;

public class cameracontroller implements InputProcessor {
      
      PerspectiveCamera cam;
      maploader ml ;
      float changer;
       float x = 0;
        float y = 3;
         float z = 0;
          
      public cameracontroller( maploader ml,PerspectiveCamera cam){
          this.ml = ml;
          this.cam = cam;
         
      }
            
     @Override
     public boolean keyDown (int keycode) {


         if(keycode == Keys.A){

                ml.scroller -=1;       
               
               if( ml.scroller > 0){
                ml.masterinstances.get(0).transform.setToTranslation( ml.getnextactorposition());
               } 
                if(ml.scroller == 0){
               ml.masterinstances.get(0).transform.setToTranslation( ml.getnextactorposition());
               }System.out.println(ml.scroller);
         
               if(ml.scroller < 0){
               ml.scroller = ml.actormanager.actors.size -1 ;
               ml.masterinstances.get(0).transform.setToTranslation( ml.getnextactorposition());
               }
         }
              
          
         if(keycode == Keys.ENTER){
                 
         
         
         }
             
                     
          
                  if(keycode == Keys.ENTER){
                   ml.map.buttns = 1;
                  textinput listener = new textinput(ml.map.buttns,ml);
                  Gdx.input.getTextInput(listener, "save as", "name","");
                  }   
                  if(keycode == Keys.SHIFT_RIGHT){
                      ml.map.buttns = 2;
                  ml.map.objects.clear();
                  ml.map.instances.clear();
                  textinput listener = new textinput(ml.map.buttns,ml);
                
                  Gdx.input.getTextInput(listener, "load", "name","");
                  
                  
                  System.out.println("dfdf");
                 
                  }   
               
      return false;
   }

     
    
     @Override
   public boolean keyUp (int keycode) {
      return false;
   }
    
     @Override
   public boolean keyTyped (char character) {
      return false;
   }

     @Override
   public boolean touchDown (int x, int y, int pointer, int button) {
      return false;
   }

     @Override
   public boolean touchUp (int x, int y, int pointer, int button) {
      return false;
   }

     @Override
   public boolean touchDragged (int x, int y, int pointer) {
      return false;
   }

     @Override
   public boolean mouseMoved (int x, int y) {
      return false;
   }

     @Override
   public boolean scrolled (int amount) {
      return false;
   }
   
   
   
}

   
 
    

