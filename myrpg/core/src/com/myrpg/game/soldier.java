/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Stefan
 */
class soldier extends job {
    public Array<String> skills = new Array<String>();
    public soldier(){
    skills.add("walk");
    skills.add("move");
    skills.add("fight");
    skills.add("skills");
    skills.add("wait");
    }
    public Array getskills(){
    
    return skills;
    }
}
