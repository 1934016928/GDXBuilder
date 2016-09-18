package com.flysnow.software.builder.base;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.flysnow.software.builder.compoment.ObjectPane;
import com.flysnow.software.builder.scenes.MainWindow;
import com.flysnow.software.builder.util.BuildTexture;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/2.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 左侧工具栏.
 */
public class LeftBar {

    private MainWindow window;
    private ImageButton object;
    private boolean isObjct = false;
    private Group leftbar;
    private ObjectPane objectPane;
    private Stage stage;
    private ImageButton.ImageButtonStyle style;

    /**
     * 构造方法
     *
     * @param window MainWindow实例
     */
    public LeftBar(MainWindow window) {
        this.window = window;
        this.stage = window.getStage();
        leftbar = window.getLeftBar();
        initActor();
        initListener();
    }

    private void initListener() {
        object.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (isObjct) {
                    objectPane.setVisible(false);
                    isObjct = false;
                } else {
                    objectPane.setVisible(true);
                    isObjct = true;
                }
                super.clicked(event, x, y);
            }
        });
    }

    /**
     * 初始化演员
     */
    private void initActor() {
        style = new ImageButton.ImageButtonStyle();
        style.imageUp = BuildTexture.drawable("assets/data/ui/object.png");
        style.imageChecked = BuildTexture.drawable("assets/data/ui/object_down.png");
        object = new ImageButton(style);
        object.setBounds(0, leftbar.getHeight() - 40, 40, 40);
        objectPane = new ObjectPane(window);
    }

    /**
     * 添加演员的方法
     */
    public void add() {
        leftbar.addActor(object);
        stage.addActor(objectPane);
    }
}
