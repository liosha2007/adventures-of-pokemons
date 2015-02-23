package com.github.liosha2007.android.adventuresofpokemons.scene;

import com.github.liosha2007.android.adventuresofpokemons.base.BaseScene;
import com.github.liosha2007.android.adventuresofpokemons.manager.SceneManager;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_HEIGHT;
import static com.github.liosha2007.android.adventuresofpokemons.GameActivity.CAMERA_WIDTH;

/**
 * @author Aleksey Permyakov (07.12.2014)
 */
public class LoadingScene extends BaseScene {
    @Override
    public void createScene()
    {
        setBackground(new Background(Color.WHITE));
        Text text = new Text(400, 240, resourcesManager.font, "Loading...", vbom);
        text.setPosition((CAMERA_WIDTH - text.getWidth()) / 2, (CAMERA_HEIGHT - text.getHeight()) / 2);
        attachChild(text);
    }

    @Override
    public void onBackKeyPressed()
    {
        return;
    }

    @Override
    public SceneManager.SceneType getSceneType()
    {
        return SceneManager.SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene()
    {

    }
}
