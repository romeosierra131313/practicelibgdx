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
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import static com.badlogic.gdx.utils.Select.instance;

/**
 *
 * @author Stefan
 */
public final  class maploader implements java.io.Serializable {
   
    
      Model model;
      ModelInstance instance;
      Array<ModelInstance> masterinstances = new Array<ModelInstance>();;// change to add map blocks and actors to this///
                                           // render this in modelbatch ////
   public AssetManager ass;
   public actormanager actormanager;
   public transient Model ship;
   map map;
   String type;
   block block;
   int counter=0;
   int actorcount;
   
   Json json = new Json();
   
   
    int scroller; //place holder for get next actorposition
    float x;
    float y;
    float z;
 
   
 public  maploader (AssetManager assets){
     this.ass = assets;
      ass.load("grass.g3db", Model.class);
      ass.load("ship.g3db",Model.class);
      ass.load("cube3.g3db",Model.class);
      ass.finishLoading();
      ass.update();
      map = new map(ass,masterinstances);
      actormanager = new actormanager(ass);

   }

        public void loadmap(){
            json.setTypeName(null);
            json.setUsePrototypes(false);
            json.setIgnoreUnknownFields(true);
            json.setOutputType(JsonWriter.OutputType.json);
              String text ="plane";
              FileHandle file = Gdx.files.local(text +".json");
                map.objects.clear();
                Array<JsonValue> oo = json.fromJson(Array.class, file);
                 for(JsonValue v: oo){
                     map.objects.add(json.readValue(block.class, v));
                       
                        
                           
                  } rebuildmap();
                    buildactors();
        }
        public void rebuildmap(){

             
            int o = 0;
            
            for(block b : map.objects){
         
         b = map.objects.get(o);
         o ++;
         
        this.type = b.type;
        map.x = b.x;
        map.y = b.y;
        map.z = b.z;
       
        
        map.addblock(b.x,b.y,b.z);
        
        }
         
       
           
    }
        public void buildactors(){
            int tempx = 0;
           actormanager.loadactors();
           int actormanagertemp = 0 ;
           model = ass.get("cube3.g3db");
           ass.finishLoading();
         
           for(actor a : actormanager.actors){
                System.out.println(a.actorName + a.jobname );
               a.setjob();
             actormanager.addactor(a.actorId, a.actorName,tempx,2,20);
               instance = new ModelInstance(model);
             instance.transform.setToTranslation(tempx, 2, 20);
             masterinstances.add(instance);
             
             tempx+=4;
             actormanagertemp++;
                 
           }actorcount = actormanagertemp;
            scroller = actorcount;
          
        }
        void addcursor() {
          map.counter = 0;

          map.addblock(0,3,20);
          map.newblock(map.type, 0,3,20);
         }
        public float getx(Array<ModelInstance> instances,int counter){
            this.counter = counter;
            Array<ModelInstance> tempinstances = new Array<ModelInstance>();
            instance = tempinstances.get(counter);
            Vector3 position;
            position = instance.transform.getTranslation(new Vector3());
        
        return position.x;
    }
        public float getz(){
        instance = masterinstances.get(counter);
        Vector3 position;
        position = instance.transform.getTranslation(new Vector3());
        
        return position.z;
    }
        public float gety(){
        instance = masterinstances.get(counter);
        Vector3 position;
        position = instance.transform.getTranslation(new Vector3());
        
        return position.y;
    } 
        Vector3 getnextactorposition() {
        instance = actormanager.aminstances.get(scroller);
        Vector3 position;
        position = instance.transform.getTranslation(new Vector3());
        position.y += 2;
         System.out.println( " scroller " + scroller);
         System.out.println( " actor at  " + position + actormanager.actors.get(scroller).actorName + actormanager.actors.get(scroller).jobname );
         System.out.println(position);
        return position;
       }
        public void superflat(){
            float x=0;
            float y=0;
            float z=0;
             map.addblock(x, y, z);
            for(int i = 0; i <=398 ; i++){
             
            x++;
            if (x == 20){
            x = 0;
            z+=1;
            }
             map.addblock(x, y, z);
            
            }buildactors();
            
        }

    void buildmasterinstances() {
        }
        
        }

