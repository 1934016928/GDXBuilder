package com.flysnow.software.builder;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.flysnow.software.builder.control.Base;
import com.flysnow.software.builder.control.BaseImage;
import com.flysnow.software.builder.control.BaseLayer;
import com.flysnow.software.builder.manager.MainManager;
import com.google.gson.Gson;

import java.awt.*;

public class Main {

    private static float WIDTH;
    private static float HEIGHT;
    private static Dimension size;
    private static LwjglApplicationConfiguration config;

    public static void main(String[] args) {
        /*获得Dimension实例*/
        size = getScreensSize();
        /*获取屏幕宽度*/
        WIDTH = (float) size.getWidth();
        /*获取屏幕高度*/
        HEIGHT = (float) size.getHeight();
        /*初始化窗口配置类*/
        config = new LwjglApplicationConfiguration();
        /*设置窗口标题栏*/
        config.title = "GDXBuilder v0.0.1 -- By Var 雨中行";
        /*禁用垂直同步*/
        config.vSyncEnabled = false;
        /*设置窗口大小*/
        config.width = (int) WIDTH;
        config.height = (int) HEIGHT;
        config.addIcon("assets/data/gdx_32_32.png", Files.FileType.Internal);
        /*显示窗口*/
        new LwjglApplication(new MainManager(), config);
    }

    /**
     * 获取屏幕大小的方法
     *
     * @return 返回屏幕大小
     */
    private static Dimension getScreensSize() {
        Toolkit size = Toolkit.getDefaultToolkit();
        Dimension screen = size.getScreenSize();
        return screen;
    }
}
