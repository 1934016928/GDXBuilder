package com.flysnow.software.builder.control;

import com.flysnow.software.builder.control.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/6.
 * 创 建 人: Var_雨中行.
 * 类 描 述: Layer对象.
 */
public class BaseLayer extends Base {

    private List<Base> actors;

    public BaseLayer() {
        actors = new ArrayList<>();
        this.setType(Type.Layer);
    }

    public void addActor(Base actor) {
        this.actors.add(actor);

    }

    public void removeActor(int index) {
        this.actors.remove(index);
    }

    public List<Base> getActors() {
        return actors;
    }

    public void setActors(List<Base> actors) {
        this.actors = actors;
    }
}
