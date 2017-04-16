/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

/**
 *
 * @author Stefan
 */
public class actormanager implements java.io.Serializable {
    
      AssetManager ass; 
      int counter;
      Json json;
      Array<actor>  actors;
      Model ammodel;
      ModelInstance aminstance;
      Array<ModelInstance> aminstances = new Array<ModelInstance>();;
        float x = 1;
        float y = 3;
        float z = 0;
    
           public actormanager(AssetManager assets){
              this.ass = assets;
              ammodel = new Model();
              
               ass.load("ship.g3db", Model.class);
               ass.update();
               ammodel = ass.get("ship.g3db");
               
      
        
        actors = new Array<actor>();
        json = new Json();  
        json.setTypeName(null);
        json.setUsePrototypes(false);
        json.setIgnoreUnknownFields(true);
        json.setOutputType(JsonWriter.OutputType.json);
         
         ammodel = ass.get("cube3.g3db");
         aminstance = new ModelInstance(ammodel);
      
         
    
    }
           public void loadactors(){
              Array<JsonValue> oo;
              actors.clear();
              FileHandle file = Gdx.files.local("actors.json");
              System.out.println(json.fromJson(Array.class, file));
              oo = json.fromJson(Array.class, file);
                 
                 for(JsonValue v: oo){
                     System.out.println(v); 
                     actors.add(json.readValue(actor.class, v));
                     
                     
                  }
         }
           public void saveactors(){
           {
           
            String g =  json.toJson(actors);
            System.out.println(actors.size);
                   FileHandle file = Gdx.files.local( "actors.json");
                   file.writeString(g, true);
                   System.out.println(g); }
           }
           public void addactor(int actorId , String actorName,float x,float y,float z){
           this.x = x;
           this.y = y;
           this.z = z;
            System.out.println(x);
           ammodel = ass.get("cube3.g3db");
           aminstance = new ModelInstance(ammodel);
           aminstance.transform.setToTranslation(x,y,z);
           aminstances.add(aminstance);
                   
           }

         public void addcursor() {
         ammodel = ass.get("ship.g3db");
         aminstance = new ModelInstance(ammodel);
         aminstance.transform.setToTranslation(0, 4, 0);
         aminstances.add(aminstance);
         System.out.println("aminstances size " + (aminstances.size-1));
    }

}
