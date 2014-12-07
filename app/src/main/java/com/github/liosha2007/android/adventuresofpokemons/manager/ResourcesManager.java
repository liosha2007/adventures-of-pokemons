package com.github.liosha2007.android.adventuresofpokemons.manager;

import com.github.liosha2007.android.adventuresofpokemons.GameActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by liosha on 07.12.2014.
 */
public class ResourcesManager {
    private static final ResourcesManager INSTANCE = new ResourcesManager();

    public Engine engine;
    public GameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;

    //---------------------------------------------
    // TEXTURES & TEXTURE REGIONS
    //---------------------------------------------

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    public void loadMenuResources()
    {
        loadMenuGraphics();
        loadMenuAudio();
    }

    public void loadGameResources()
    {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics()
    {

    }

    private void loadMenuAudio()
    {

    }

    private void loadGameGraphics()
    {

    }

    private void loadGameFonts()
    {

    }

    private void loadGameAudio()
    {

    }

    public void loadSplashScreen()
    {

    }

    public void unloadSplashScreen()
    {

    }

    /**
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static ResourcesManager getInstance()
    {
        return INSTANCE;
    }
}
