package com.github.liosha2007.android.adventuresofpokemons.scene;

import com.badlogic.gdx.math.Vector2;
import com.github.liosha2007.android.adventuresofpokemons.GameActivity;
import com.github.liosha2007.android.adventuresofpokemons.base.BaseScene;
import com.github.liosha2007.android.adventuresofpokemons.manager.SceneManager;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.adt.color.Color;

/**
 * @author Aleksey Permyakov (07.12.2014)
 */
public class GameScene extends BaseScene {
    public static final int PHYSICS_STEPS_PER_SECOND = 60;
    private HUD gameHUD;
    private Text scoreText;
    private int score = 0;
    private FixedStepPhysicsWorld physicsWorld;

    @Override
    public void createScene()
    {
        createBackground();
        createHUD();
        createPhysics();
    }

    @Override
    public void onBackKeyPressed()
    {

    }

    @Override
    public SceneManager.SceneType getSceneType()
    {
        return SceneManager.SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene()
    {

    }

    private void createBackground()
    {
        setBackground(new Background(Color.BLUE));
    }

    private void createHUD()
    {
        gameHUD = new HUD();

        // CREATE SCORE TEXT
        scoreText = new Text(125, GameActivity.CAMERA_HEIGHT - 20, resourcesManager.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
//        scoreText.setAnchorCenter(0, 0);
        scoreText.setText("Score: 0");
        gameHUD.attachChild(scoreText);

        camera.setHUD(gameHUD);
    }

    private void addToScore(int i)
    {
        score += i;
        scoreText.setText("Score: " + score);
    }

    private void createPhysics()
    {
        physicsWorld = new FixedStepPhysicsWorld(PHYSICS_STEPS_PER_SECOND, new Vector2(0, -17), false);
        registerUpdateHandler(physicsWorld);
    }

}
