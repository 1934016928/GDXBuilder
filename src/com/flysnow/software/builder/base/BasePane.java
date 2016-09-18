package com.flysnow.software.builder.base;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.flysnow.software.builder.util.BuildTexture;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/2.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 基础面板.
 */
public class BasePane extends Group {

    private float width = 300;
    private float height = 1023;

    private Image bg;

    /**
     * 构造函数
     */
    public BasePane() {
        /*设置面板大小*/
        setSize(width, height);
        /*初始化背景*/
        bg = new Image(BuildTexture.build("assets/data/ui/menuback.png"));
        /*初始化背景位置*/
        bg.setBounds(0, 0, this.width, this.height);
        /*将背景添加到面板中*/
        addActor(bg);
    }
}
