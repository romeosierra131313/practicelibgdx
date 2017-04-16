/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;


/**
 *
 * @author Stefan
 */
public class map  {
    block block;
    public transient Array<block> objects = new Array<block>();
    public  Array<ModelInstance> instances = new Array<ModelInstance>();
    ModelInstance shipInstance;
    Model ship;
    String type;
    float x=0;
    float y=3;
    float z=20;
    int counter = 0;
    int buttns = 0;
    public AssetManager ass;
    
    
    public map(AssetManager assets, Array<ModelInstance> masterinstances){
      this.instances = masterinstances;  
      block = new block();
      this.ass = assets;
      ship = ass.get("ship.g3db");
      type ="cube";
      addblock(x,y,z);
      ship = ass.get("grass.g3db");
      type ="cube";
     
    }
    public void addblock(float x,float y ,float z ) {
                this.x = x;
                this.y = y;
                this.z = z;
           
       
                shipInstance = new ModelInstance(ship);
                shipInstance.transform.setToTranslation(x,y,z);
                instances.add(shipInstance);
                counter +=1;
                
               
        }
    public void newblock(String type ,float x, float y ,float z){
   
    block =new block();
    block.type = type;
    block.x = this.x;
    block.y = this.y;
    block.z = this.z;
    objects.add(block);
    
    }

}
