/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myrpg.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;

/**
 *
 * @author Stefan
 */
public class assetmanager extends AssetManager{
    AssetManager am = new AssetManager(); 
    
  //  public static final AssetDescriptor<Model> someTexture = 
    //    new AssetDescriptor<Model>("cube.blend", Model.class);
    

public void load()
{
    //am.load(someTexture);

}

    @Override
    public void dispose()
{
    //am.dispose();
}
}
