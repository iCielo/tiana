/**
 * lincl
 * 2016年9月12日 下午5:35:45
 * 
 */
package com.lezic.tiana.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于日志的注解
 * 
 * @author lincl
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /** 日志内容 例如： 新增用户记录，用户名：{0} */
    String value();

}
