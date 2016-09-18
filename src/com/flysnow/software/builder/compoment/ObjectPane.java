package com.flysnow.software.builder.compoment;

import com.flysnow.software.builder.base.BaseObjectComp;
import com.flysnow.software.builder.base.BasePane;
import com.flysnow.software.builder.scenes.MainWindow;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/2.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 对象面板.
 */
public class ObjectPane extends BasePane {

    private BaseObjectComp image;
    private MainWindow window;

    /**
     * 构造方法
     */
    public ObjectPane(MainWindow window) {
        this.window = window;
        setPosition(41, 1);
        setVisible(false);
        initActor();
        initListener();
        add();
    }

    private void initListener() {

    }

    /**
     * 初始化演员
     */
    private void initActor() {
        image = new BaseObjectComp(window, "assets/data/img/jl.png", "图片", "Image");
        image.setName("Image");
        image.setPosition(10, this.getHeight() - (image.getHeight() + 10));
    }

    /**
     * 添加演员到舞台
     */
    private void add() {
        addActor(image);
    }
}
