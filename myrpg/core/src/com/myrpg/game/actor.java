/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.utils.Array;


public class actor {
    int actorId;
    String actorName;
    String jobname  ;
    job job;
    soldier soldier;
    archer archer;
    
public actor(){

}
public void setjob(){
        //int actorId,String jobb 
           if ("soldier".equals(jobname)){
               job = new soldier();
               job.equals(soldier);
               
               
    System.out.println(actorName + jobname );
    }else  if("archer".equals(jobname)){
              job = new archer();
               job.equals(soldier);}
     //else if
}
public void getjob(){
               if ("soldier".equals(jobname)){
               job = new soldier();
               job.equals(soldier);
              // return soldier.skills
               
               
    System.out.println(actorName + jobname );
    }else  if("archer".equals(jobname)){
              job = new archer();
               job.equals(soldier);}
  }
}
