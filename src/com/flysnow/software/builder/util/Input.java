package com.flysnow.software.builder.util;

import com.badlogic.gdx.InputProcessor;
import com.flysnow.software.builder.scenes.MainWindow;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/8/31.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 监听输入发类.
 */
public class Input implements InputProcessor {

    private MainWindow window;
    private int touchX = 0;
    private int touchY = 0;
    private float clickX = 0;
    private float clickY = 0;
    private boolean isDrop = false;
    private float width;
    private float height;
    private boolean isMove = false;

    public Input(MainWindow window) {
        this.window = window;
        this.width = window.getWidth();
        this.height = window.getHeight();
    }

    @Override
    public boolean keyDown(int i) {
        /*当Delete键按下时*/
        if (i == 112) {
            /*调用删除演员的方法*/
            window.removeActor();
            window.resizeVisible(false);
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        /*判断鼠标按下的键是否是左键*/
        if (i3 == 0) {
            this.clickX = width - i;
            this.clickY = i1;
            isMove = true;
        }
        /*判断鼠标按下的键是否是右键*/
        if (i3 == 1) {
            window.resizeVisible(false);
            this.touchX = (int) (width - i);
            this.touchY = i1;
            isDrop = true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        isDrop = false;
        isMove = false;
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        /*当Ctrl键按下,并且鼠标点击开始拖动时*/
        if (isDrop) {
            window.dropDesinger((int) (touchX - (width - i)), touchY - i1);
            this.touchX = (int) (width - i);
            this.touchY = i1;
        }
        if (isMove) {
            window.moveActor(clickX - (width - i), clickY - i1);
            this.clickX = width - i;
            this.clickY = i1;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    /**
     * 鼠标滚轮滑动
     *
     * @param i 滑动的方向 1为向前滑动,-1为向后滑动
     * @return
     */
    @Override
    public boolean scrolled(int i) {
        window.scalerScene(i);
        return false;
    }
}
