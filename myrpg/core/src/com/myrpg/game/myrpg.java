package com.myrpg.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

public class myrpg extends ApplicationAdapter {
    public cameracontroller can;
    public maploader ml;
    public battlemenu bm;
    public PerspectiveCamera cam;
    public OrthographicCamera ocam;
    
    public ModelBatch modelBatch;
    public SpriteBatch sb;
    public AssetManager assets; 
    public Environment environment;
    public Boolean loadingmap = true;
    public String fileName;
     
    @Override
    public void create () {
       
        
        
        sb = new SpriteBatch();
        modelBatch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(25f, 25f, 30f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
        
        ocam = new OrthographicCamera();
        ocam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        ocam.setToOrtho(true, Gdx.graphics.getWidth()   ,Gdx.graphics.getHeight());

        
        ocam.update();
        
        
             // for menus
        assets = new AssetManager();
        ml = new maploader(assets);
        bm = new battlemenu(cam);
       
        
        
        //temp 
        
        can = new cameracontroller(ml,cam);
       
        
        Gdx.input.setInputProcessor(can);
    }
 


    @Override
    public void render () {
        sb.setProjectionMatrix(cam.projection);
        cam.update();
         
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        
        modelBatch.begin(cam);
        if(loadingmap){
        ml.superflat();
        
        loadingmap = false;}
        ml.buildmasterinstances();
       
        modelBatch.render(ml.masterinstances, environment);
        
        modelBatch.end();
        
        sb.begin();
        bm.drawmenu();
        bm.fillmenu();
        sb.end();
    }
     
    @Override
    public void dispose () {
        modelBatch.dispose();
        assets.dispose();
    }

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}