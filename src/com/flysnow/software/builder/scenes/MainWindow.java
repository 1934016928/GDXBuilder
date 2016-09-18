package com.flysnow.software.builder.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.flysnow.software.builder.base.LeftBar;
import com.flysnow.software.builder.base.MenuBar;
import com.flysnow.software.builder.base.RightBar;
import com.flysnow.software.builder.base.ToolBar;
import com.flysnow.software.builder.manager.MainManager;
import com.flysnow.software.builder.util.BuildTexture;
import com.flysnow.software.builder.util.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/8/30.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 主窗口,程序启动最先显示的窗口.
 */
public class MainWindow implements Screen {

    private MainManager manager;
    private Stage stage;
    private OrthographicCamera camera;
    private float width;
    private float height;
    private Image background;
    private Image menuBack;
    private Image toolBack;
    private Image leftBack;
    private Image rightBack;
    private Image ruler_w;
    private Image ruler_h;
    private Image desingerBack;
    private Image ckx_w_top;
    private Image ckx_w_bttom;
    private Image ckx_h_left;
    private Image ckx_h_right;
    private Group menuBar;
    private Group toolBar;
    private Group leftBar;
    private Group rightBar;
    private Group desinger;
    private Group base;
    private InputMultiplexer multiplexer;
    private Actor selectActor;
    private int i = 0;
    private Group resize;
    private Image top;
    private Image bttom;
    private Image left;
    private Image right;
    private Image lt;
    private Image lb;
    private Image rt;
    private Image rb;

    public MainWindow(MainManager manager) {
        this.manager = manager;
        this.stage = manager.getStage();
        this.camera = (OrthographicCamera) stage.getCamera();
        this.width = stage.getWidth();
        this.height = stage.getHeight();
    }

    @Override
    public void show() {
        /*设置输入*/
        multiplexer = new InputMultiplexer();
        /*设置舞台监听*/
        multiplexer.addProcessor(this.stage);
        /*设置外部操作监听*/
        multiplexer.addProcessor(new Input(this));
        /*设置监听*/
        Gdx.input.setInputProcessor(multiplexer);
        /*初始化演员*/
        initActor();
    }

    @Override
    public void render(float v) {
        Gdx.gl20.glClearColor(0, 0, 0, 0);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void initActor() {
        /*初始化stage背景*/
        background = new Image(BuildTexture.build("assets/data/ui/baseback.png"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        /*初始化菜单栏工具栏等背景图*/
        Texture back = BuildTexture.build("assets/data/ui/lrback.png");
        menuBack = new Image(BuildTexture.build("assets/data/ui/menuback.png"));
        toolBack = new Image(BuildTexture.build("assets/data/ui/toolback.png"));
        leftBack = new Image(back);
        rightBack = new Image(back);
        /*初始化菜单栏,工具栏等*/
        menuBar = new Group();
        toolBar = new Group();
        leftBar = new Group();
        rightBar = new Group();
        /*初始化设计面板*/
        desinger = new Group();
        desinger.setBounds(65, 25, stage.getWidth() - 105, stage.getHeight() - 80);
        /*初始化设计表格背景*/
        desingerBack = new Image(BuildTexture.build("assets/data/ui/rectgrid.png"));
        desingerBack.setPosition(-1503, -1503);
        desinger.addActor(desingerBack);
        /*初始化标尺*/
        ruler_w = new Image(BuildTexture.build("assets/data/ui/ruler_w.png"));
        ruler_h = new Image(BuildTexture.build("assets/data/ui/ruler_h.png"));
        /*设置标尺的位置*/
        ruler_w.setPosition(-2038, 0);
        ruler_h.setPosition(40, -2078);
        /*设置菜单栏*/
        //菜单栏
        menuBar.setBounds(0, stage.getHeight() - 25, stage.getWidth(), 25);
        menuBack.setBounds(0, 0, menuBar.getWidth(), menuBar.getHeight());
        menuBar.addActor(menuBack);
        //工具栏
        toolBar.setBounds(0, stage.getHeight() - 55, stage.getWidth(), 30);
        toolBack.setBounds(0, 0, toolBar.getWidth(), toolBar.getHeight());
        toolBar.addActor(toolBack);
        //左侧工具栏
        leftBar.setBounds(0, 0, 40, stage.getHeight() - 56);
        leftBack.setBounds(0, 0, leftBar.getWidth(), leftBar.getHeight());
        leftBar.addActor(leftBack);
        //右侧工具栏
        rightBar.setBounds(stage.getWidth() - 40, 0, 40, stage.getHeight() - 56);
        rightBack.setBounds(0, 0, rightBar.getWidth(), rightBar.getHeight());
        rightBar.addActor(rightBack);
        /*添加演员*/
        stage.addActor(background);
        stage.addActor(desinger);
        stage.addActor(ruler_h);
        stage.addActor(ruler_w);
        stage.addActor(menuBar);
        stage.addActor(toolBar);
        stage.addActor(leftBar);
        stage.addActor(rightBar);
        /*创建场景*/
        creatScene();
        /*箱工具栏中添加元素*/
        new MenuBar(this).add();
        new ToolBar(this).add();
        new LeftBar(this).add();
        new RightBar(this).add();
        /*初始化大小调整线*/
        initResize();
    }

    private void initResize() {
        /*初始化大小调整边缘线*/
        Texture line = BuildTexture.build("assets/data/ui/line.png");
        resize = new Group();
        resize.setBounds(0, 0, 100, 100);
        /*初始化线条*/
        top = new Image(line);
        bttom = new Image(line);
        left = new Image(line);
        right = new Image(line);
        /*初始化大小调整点位*/
        lt = new Image(line);
        lb = new Image(line);
        rt = new Image(line);
        rb = new Image(line);
        /*设置边缘线位置*/
        setResize();
        resize.addActor(top);
        resize.addActor(bttom);
        resize.addActor(left);
        resize.addActor(right);
        resize.addActor(lt);
        resize.addActor(lb);
        resize.addActor(rt);
        resize.addActor(rb);
        resize.setVisible(false);
        base.addActor(resize);
    }

    /**
     * 移动Actor
     *
     * @param x x轴移动的距离
     * @param y y轴移动的距离
     */
    public void moveActor(float x, float y) {
        if (selectActor != null) {
            resize.setPosition(resize.getX() + x, resize.getY() + y);
            selectActor.setPosition(selectActor.getX() + x, selectActor.getY() + y);
            setResize();
        }
    }

    /**
     * 调整边缘线大小
     */
    private void setResize() {
        /*设置渲染顺序*/
        resize.setZIndex(resize.getChildren().size);
        /*设置边缘线位置*/
        top.setBounds(3, resize.getHeight() + 3, resize.getWidth() - 3, 3);
        bttom.setBounds(3, -3, resize.getWidth() - 3, 3);
        left.setBounds(-3, 3, 3, resize.getHeight() - 3);
        right.setBounds(resize.getWidth() + 3, 3, 3, resize.getHeight() - 3);
        lt.setBounds(-3, resize.getHeight() + 3, 3, 3);
        lb.setBounds(-3, -3, 3, 3);
        rt.setBounds(resize.getWidth() + 3, resize.getHeight() + 3, 3, 3);
        rb.setBounds(resize.getWidth() + 3, -3, 3, 3);
    }

    /**
     * 设置缩放
     *
     * @param scrolled 鼠标滑动的方向
     */
    public void scalerScene(int scrolled) {
        if (scrolled == -1) {

        } else if (scrolled == 1) {

        }
    }

    /**
     * 创建场景
     */
    private void creatScene() {
        /*参考线初始化*/
        Texture ckx_w = BuildTexture.build("assets/data/ui/ckx_w.png");
        Texture ckx_h = BuildTexture.build("assets/data/ui/ckx_h.png");
        ckx_w_top = new Image(ckx_w);
        ckx_w_bttom = new Image(ckx_w);
        ckx_h_left = new Image(ckx_h);
        ckx_h_right = new Image(ckx_h);
        /*设计场景基础容器*/
        Group base = new Group();
        this.base = base;
        base.setBounds(0, 0, 800, 480);
        base.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                List<Actor> actors = new ArrayList<>();
                for (Actor actor : base.getChildren()) {
                    if (x <= actor.getX() + actor.getWidth() && x >= actor.getX() && y <= actor.getY() + actor.getHeight() && y >= actor.getY()) {
                        if (!actor.equals(resize)) {
                            actors.add(actor);
                        }
                    }
                }
                /*传入当前鼠标选择的Actor*/
                if (actors.size() != 0) {
                    selectActor = actors.get(actors.size() - 1);
                    resize.setBounds(selectActor.getX(), selectActor.getY(), selectActor.getWidth(), selectActor.getHeight());
                    setResize();
                    resizeVisible(true);
                } else {
                    selectActor = null;
                    resizeVisible(false);
                }
            }
        });
        /*设置参考线*/
        setCkx();
        desinger.addActor(base);
        desinger.addActor(ckx_w_top);
        desinger.addActor(ckx_w_bttom);
        desinger.addActor(ckx_h_left);
        desinger.addActor(ckx_h_right);
    }

    public void resizeVisible(boolean isShow) {
        resize.setVisible(isShow);
        if (!isShow) {
            selectActor = null;
        }
    }

    /**
     * 拖动调整设计器
     *
     * @param x 拖动的X轴距离
     * @param y 拖动的Y轴距离
     */
    public void dropDesinger(int x, int y) {
        /*设置设计器的背景拖动后的位置*/
        desingerBack.setPosition(desingerBack.getX() + x, desingerBack.getY() + y);
        /*设置场景拖动后的位置*/
        base.setPosition(base.getX() + x, base.getY() + y);
        /*设置横向标尺拖动后的位置*/
        ruler_w.setPosition(ruler_w.getX() + x, ruler_w.getY());
        /*设置垂直标尺拖动后的位置*/
        ruler_h.setPosition(ruler_h.getX(), ruler_h.getY() + y);
        /*更新参考线*/
        setCkx();
    }

    /**
     * 设置参考线
     */
    private void setCkx() {
        ckx_w_top.setPosition(0, base.getY() + base.getHeight());
        ckx_w_bttom.setPosition(0, base.getY() - 3);
        ckx_h_left.setPosition(base.getX() - 3, 0);
        ckx_h_right.setPosition(base.getX() + base.getWidth() - 3, 0);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Group getMenuBar() {
        return menuBar;
    }

    public Group getToolBar() {
        return toolBar;
    }

    public Group getLeftBar() {
        return leftBar;
    }

    public Group getRightBar() {
        return rightBar;
    }

    public Stage getStage() {
        return stage;
    }

    public Group getDesinger() {
        return desinger;
    }

    /**
     * 添加演员到设计器中
     *
     * @param str 演员名称
     * @param x   放置的x坐标
     * @param y   放置的y坐标
     */
    public void addDropActor(Object str, float x, float y) {
        float drawX = x - base.getX();
        float drawY = y - base.getY();
        if (str.equals("Image")) {
            Image image = new Image(BuildTexture.build("assets/data/img/gdx.png"));
            image.setPosition(drawX - image.getWidth() / 2, drawY - image.getHeight() / 2);
            image.setName(str.toString() + i);
            base.addActor(image);
            i += 1;
        }
    }

    /**
     * 删除演员对象
     */
    public void removeActor() {
        if (selectActor != null) {
            base.removeActor(selectActor);
        }
    }
}
