package com.flysnow.software.builder.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * 项目名称: GDXBuilder.
 * 创建时间: 2016/8/30.
 * 创 建 人: Var_雨中行.
 * 类 描 述: 从源文件创建双线性优化的纹理贴图.
 */
public class BuildTexture {
    /**
     * 从指定的路径创建双线性优化的纹理贴图
     *
     * @param path 指定资源的路径
     * @return 返回双线性优化的纹理贴图
     */
    public static Texture build(String path) {
        /*创建纹理*/
        Texture texture = new Texture(path);
        /*设置纹理双线性优化*/
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        /*返回优化后的纹理*/
        return texture;
    }

    /**
     * 从指定路径创建图像的方法
     *
     * @param path 指定的路径
     * @return 返回创建的图形
     */
    public static TextureRegionDrawable drawable(String path) {
        /*创建图像*/
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(build(path)));
        /*返回创建过后的图像*/
        return drawable;
    }
}
