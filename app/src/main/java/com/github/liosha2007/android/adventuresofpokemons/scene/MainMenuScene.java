package com.github.liosha2007.android.adventuresofpokemons.scene;

import android.os.*;
import android.os.Process;

import com.github.liosha2007.android.adventuresofpokemons.GameActivity;
import com.github.liosha2007.android.adventuresofpokemons.base.BaseScene;
import com.github.liosha2007.android.adventuresofpokemons.manager.SceneManager;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_HEIGHT;
import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_WIDTH;

/**
 * @author Aleksey Permyakov (07.12.2014)
 */
public class MainMenuScene extends BaseScene implements MenuScene.IOnMenuItemClickListener {
    private MenuScene menuChildScene;
    private final int MENU_PLAY = 0;
    private final int MENU_OPTIONS = 1;

    @Override
    public void createScene() {
        createBackground();
        createMenuChildScene();
    }

    @Override
    public void onBackKeyPressed() {
        System.exit(0);
        android.os.Process.killProcess(Process.myPid());
    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_MENU;
    }

    @Override
    public void disposeScene() {

    }

    private void createBackground()
    {
        attachChild(new Sprite(
                CAMERA_WIDTH / 2,
                CAMERA_HEIGHT / 2,
                CAMERA_WIDTH,
                CAMERA_HEIGHT,
                resourcesManager.menu_background_region,
                vbom) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        });
    }

    private void createMenuChildScene()
    {
        menuChildScene = new MenuScene(camera);
        menuChildScene.setPosition(0, 0);

        final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resourcesManager.play_region, vbom), 1.2f, 1);
        final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_OPTIONS, resourcesManager.options_region, vbom), 1.2f, 1);

        menuChildScene.addMenuItem(playMenuItem);
        menuChildScene.addMenuItem(optionsMenuItem);

        menuChildScene.buildAnimations();
        menuChildScene.setBackgroundEnabled(false);

        playMenuItem.setPosition(playMenuItem.getX(), playMenuItem.getY() + 40);
        optionsMenuItem.setPosition(optionsMenuItem.getX(), optionsMenuItem.getY() + 50);

        menuChildScene.setOnMenuItemClickListener(this);

        setChildScene(menuChildScene);
    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
        switch(pMenuItem.getID())
        {
            case MENU_PLAY:
                //Load Game Scene!
                SceneManager.getInstance().loadGameScene(engine);
                return true;
            case MENU_OPTIONS:
                return true;
            default:
                return false;
        }
    }
}
