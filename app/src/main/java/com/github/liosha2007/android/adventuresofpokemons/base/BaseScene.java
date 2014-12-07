package com.github.liosha2007.android.adventuresofpokemons.base;

import android.app.Activity;

import com.github.liosha2007.android.adventuresofpokemons.manager.ResourcesManager;
import com.github.liosha2007.android.adventuresofpokemons.manager.SceneManager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * @author Aleksey Permyakov (07.12.2014)
 */
public abstract class BaseScene extends Scene {
    protected Engine engine;
    protected Activity activity;
    protected ResourcesManager resourcesManager;
    protected VertexBufferObjectManager vbom;
    protected Camera camera;

    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------

    public BaseScene()
    {
        this.resourcesManager = ResourcesManager.getInstance();
        this.engine = resourcesManager.engine;
        this.activity = resourcesManager.activity;
        this.vbom = resourcesManager.vbom;
        this.camera = resourcesManager.camera;
        createScene();
    }

    //---------------------------------------------
    // ABSTRACTION
    //---------------------------------------------

    public abstract void createScene();

    public abstract void onBackKeyPressed();

    public abstract SceneManager.SceneType getSceneType();

    public abstract void disposeScene();
}
