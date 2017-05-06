/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.towns;

import com.badlogic.gdx.math.Vector2;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Stefan
 */
public class locationmap implements Serializable {
       HashMap<String, Vector2> town = new HashMap<String, Vector2>();
       
       public locationmap(){
       
       }
       public  void settown(String g, Vector2 v){
       
       town.put(g, v);
           
       }
       public Vector2 gettown(String g){
         Vector2 v =town.get(g);
         return  v;
       
       }
}
