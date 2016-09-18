package com.flysnow.software.builder.control;

import com.flysnow.software.builder.control.type.Type;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/9/6.
 * 创 建 人: Var_雨中行.
 * 类 描 述: Image对象.
 */
public class BaseImage extends Base {

    private String texture;

    public BaseImage() {
        this.setType(Type.Image);
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
