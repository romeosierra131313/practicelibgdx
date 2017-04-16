/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

/**
 *
 * @author Stefan
 */
public class textinput implements TextInputListener {
    Boolean loading = true;
    int buttns;
    maploader ml;
    String g;
    Json json = new Json();
    
    
    public textinput(int buttns, maploader ml){
        
    
        this.buttns = buttns;
        this.ml=ml;
    }
   @Override
   public void input (String text) {
       
json.setTypeName(null);
json.setUsePrototypes(false);
json.setIgnoreUnknownFields(true);
json.setOutputType(OutputType.json);
       
       if(buttns == 1){
           
                   g =  json.toJson(ml.map.objects);
                   System.out.println("g"); 
                   System.out.println(ml.map.objects.size);
                   FileHandle file = Gdx.files.local(text +".json");
                   
                   file.writeString(g, true);
                   System.out.println(g); }
       if(buttns == 2){
                   FileHandle file = Gdx.files.local(text +".json");
                   ml.map.objects.clear();
                   Array<JsonValue> oo = json.fromJson(Array.class, file);
                   for(JsonValue v: oo){
                   ml.map.objects.add(json.readValue(block.class, v));
                   System.out.println(ml.map.objects.size);
                        
                           
                  } ml.rebuildmap();
             }
   }
   public Boolean loading(){
   return loading;
   }

   @Override
   public void canceled () {
   }
   
       
   }

    

