package com.flysnow.software.builder.util;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.flysnow.software.builder.base.BaseObjectComp;
import com.flysnow.software.builder.scenes.MainWindow;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/5.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 处理拖放操作的类.
 */
public class DragDrop {

    private DragAndDrop dragAndDrop;
    private BaseObjectComp comp;
    private MainWindow window;
    private String path;
    private String lableName;
    private String objectName;

    /**
     * 构造方法
     *
     * @param comp   拖放对象实例
     * @param window 主视图
     */
    public DragDrop(BaseObjectComp comp, MainWindow window) {
        this.comp = comp;
        this.window = window;
        this.path = comp.getPath();
        this.lableName = comp.getLableName();
        this.objectName = comp.getObjectName();
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        dragAndDrop = new DragAndDrop();
        /*拖动源*/
        dragAndDrop.addSource(new DragAndDrop.Source(comp) {
            @Override
            public DragAndDrop.Payload dragStart(InputEvent inputEvent, float v, float v1, int i) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setDragActor(new BaseObjectComp(window, path, lableName, objectName));
                payload.setObject(objectName);
                return payload;
            }
        });
        /*放置对象*/
        dragAndDrop.addTarget(new DragAndDrop.Target(window.getDesinger()) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                window.addDropActor(payload.getObject(), v, v1);
            }
        });
    }
}
