package com.flysnow.software.builder.util;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.lang.reflect.Method;

import com.flysnow.software.builder.control.Base;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/18.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 获取和设置Acrtor的属性.
 */
public class OptionActorInfo {

    private Actor actor;
    private Base base;

    public OptionActorInfo(Actor actor, Base base) {
        this.actor = actor;
        this.base = base;
    }

    public void getMis() {
        Method[] methods = actor.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
