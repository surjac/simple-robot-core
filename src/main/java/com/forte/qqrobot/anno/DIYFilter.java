/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  simple-robot-core
 * File     DIYFilter.java
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 *
 */

package com.forte.qqrobot.anno;

import com.forte.qqrobot.anno.depend.Beans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义过滤规则的
 * @author <a href="https://github.com/ForteScarlet"> ForteScarlet </a>
 */
@Retention(RetentionPolicy.RUNTIME)    //注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.TYPE}) //接口、类、枚举、注解、方法
@Beans
public @interface DIYFilter {

    /**
     * 自定义filter的名称。如果不填或者使用的是@Beans注解，则使用类名小写作为名称。
     * 此名称也同样会映射为{@link Beans}的依赖名称
     */
    String value() default "";

    /** 是否为单例，默认为单例 */
    @AnnotateMapping(type = Beans.class)
    boolean single() default true;


    /** 根据参数类型列表来指定构造函数，默认为无参构造。仅标注在类上的时候有效 */
    @AnnotateMapping(type = Beans.class)
    Class[] constructor() default {};



}
