package com.flysnow.software.builder.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.flysnow.software.builder.scenes.MainWindow;
import com.flysnow.software.builder.util.BuildTexture;
import com.flysnow.software.builder.util.DragDrop;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/2.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 单个对象.
 */
public class BaseObjectComp extends Group {

    private Image image;
    private Label label;
    private Label.LabelStyle style;
    private Image bg;
    private MainWindow window;
    private String path;
    private String lableName;
    private String objectName;

    /**
     * 构造方法
     *
     * @param path  指定图片路径
     * @param lable 指定对象组件的名称
     */
    public BaseObjectComp(MainWindow window, String path, String lable, String objectName) {
        this.window = window;
        this.path = path;
        this.lableName = lable;
        this.objectName = objectName;
        /*初始化背景*/
        bg = new Image(BuildTexture.build("assets/data/ui/baseback.png"));
        /*初始化对象图片*/
        this.image = new Image(BuildTexture.build(path));
        /*初始化字体样式*/
        this.style = new Label.LabelStyle();
        style.font = new BitmapFont(Gdx.files.internal("assets/data/font/object.fnt"));
        style.fontColor = new Color(0.9f, 0.9f, 0.9f, 1);
        /*初始化标签*/
        this.label = new Label(lable, style);
        /*设置自身大小*/
        setSize(80, 90);
        /*设置背景位置*/
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        /*隐藏背景*/
        bg.setVisible(false);
        /*添加背景*/
        addActor(bg);
        /*设置对象图片*/
        image.setSize(60, 60);
        /*设置对象图片的位置*/
        image.setPosition(this.getWidth() / 2 - image.getWidth() / 2, 23);
        /*设置文字标签*/
        this.label.setSize(this.getWidth(), 20);
        this.label.setPosition(this.getWidth() / 2 - this.label.getWidth() / 2, 3);
        this.label.setAlignment(1);
        /*初始化监听*/
        initListener();
        /*添加演员*/
        addActor(image);
        addActor(this.label);
    }

    /**
     * 初始化监听的方法
     */
    private void initListener() {
        /*焦点改变监听*/
        this.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                /*显示背景*/
                setBg(true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                /*影藏背景*/
                setBg(false);
            }
        });
        /*启用拖放*/
        new DragDrop(this, window);
    }

    /**
     * 设置背景可见性
     *
     * @param isShow 为true则显示,为false则隐藏
     */
    public void setBg(boolean isShow) {
        bg.setVisible(isShow);
    }

    public String getPath() {
        return path;
    }

    public String getLableName() {
        return lableName;
    }

    public String getObjectName() {
        return objectName;
    }
}
