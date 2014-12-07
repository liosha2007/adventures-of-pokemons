package com.github.liosha2007.android.adventuresofpokemons.scene;

import com.github.liosha2007.android.adventuresofpokemons.GameActivity;
import com.github.liosha2007.android.adventuresofpokemons.base.BaseScene;
import com.github.liosha2007.android.adventuresofpokemons.manager.SceneManager;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_HEIGHT;
import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_WIDTH;

/**
 * @author Aleksey Permyakov (07.12.2014)
 */
public class SplashScene extends BaseScene {
    private Sprite splash;

    @Override
    public void createScene() {
        splash = new Sprite(0, 0, resourcesManager.splash_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        splash.setScale(1.5f);
        splash.setPosition(
                (CAMERA_WIDTH - resourcesManager.splash_region.getWidth()) / 2,
                (CAMERA_HEIGHT - resourcesManager.splash_region.getHeight()) / 2
        );
        attachChild(splash);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
        splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();
    }
}
