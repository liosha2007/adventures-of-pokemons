package com.github.liosha2007.android.adventuresofpokemons.manager;

import android.graphics.Color;

import com.github.liosha2007.android.adventuresofpokemons.GameActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.StrokeFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_HEIGHT;
import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_WIDTH;

/**
 * Created by liosha on 07.12.2014.
 */
public class ResourcesManager {
    private static final ResourcesManager INSTANCE = new ResourcesManager();

    public Engine engine;
    public GameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;

    private BitmapTextureAtlas splashTextureAtlas;
    public TextureRegion splash_region;

    private BuildableBitmapTextureAtlas menuTextureAtlas;
    public TextureRegion menu_background_region;
    public TextureRegion play_region;
    public TextureRegion options_region;
    public StrokeFont font;

    //---------------------------------------------
    // TEXTURES & TEXTURE REGIONS
    //---------------------------------------------

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    public void loadMenuResources() {
        loadMenuGraphics();
        loadMenuFonts();
        loadMenuAudio();
    }

    public void loadGameResources() {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
        menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
        menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "menu_background.png");
        play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.png");
        options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "options.png");

        try {
            this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
            this.menuTextureAtlas.load();
        } catch (final ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }

    }

    private void loadMenuAudio() {

    }

    private void loadMenuFonts() {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
        font.load();
    }

    public void unloadMenuTextures() {
        menuTextureAtlas.unload();
    }

    public void loadMenuTextures() {
        menuTextureAtlas.load();
    }

    private void loadGameGraphics() {

    }

    private void loadGameFonts() {

    }

    private void loadGameAudio() {

    }

    public void unloadGameTextures()
    {
        // TODO (Since we did not create any textures for game scene yet)
    }

    public void loadSplashScreen() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
        splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
        splashTextureAtlas.load();
    }

    public void unloadSplashScreen() {
        splashTextureAtlas.unload();
        splash_region = null;
    }

    /**
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static ResourcesManager getInstance() {
        return INSTANCE;
    }
}
