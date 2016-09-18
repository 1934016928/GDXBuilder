package com.flysnow.software.builder.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.flysnow.software.builder.scenes.MainWindow;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/8/30.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 窗口管理类.
 */
public class MainManager extends Game {

    private static final float WIDTH = 1920;
    private static final float HEIGHT = 1080;
    private Stage stage;

    public MainWindow mainWindow;

    @Override
    public void create() {
        /*自适应屏幕大小*/
        keepScreen(WIDTH, HEIGHT);
        /*初始化窗口*/
        mainWindow = new MainWindow(this);
        /*设置默认窗口*/
        setScreen(mainWindow);
    }

    /**
     * 自适应屏幕
     *
     * @param w 屏幕宽度
     * @param h 屏幕高度
     */
    private void keepScreen(float w, float h) {
        OrthographicCamera camera = new OrthographicCamera(w, h);
        stage = new Stage(new StretchViewport(w, h, camera));
        camera.update();
    }

    /**
     * 获取stage的方法
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }
}
