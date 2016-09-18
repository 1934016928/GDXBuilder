package com.flysnow.software.builder.control;

import com.badlogic.gdx.graphics.Color;
import com.flysnow.software.builder.control.type.Type;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/6.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 控件对象的基类.
 */
public class Base {

    private Type type;
    private String name;
    private float width;
    private float height;
    private float x;
    private float y;
    private boolean visible;
    private float originX;
    private float originY;
    private float scaleX;
    private float scaleY;
    private float rotation;
    private Color color;

    public Base() {
        this.name = "";
        this.visible = true;
        this.scaleX = 1.0F;
        this.scaleY = 1.0F;
        this.color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getOriginX() {
        return originX;
    }

    public void setOriginX(float originX) {
        this.originX = originX;
    }

    public float getOriginY() {
        return originY;
    }

    public void setOriginY(float originY) {
        this.originY = originY;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
