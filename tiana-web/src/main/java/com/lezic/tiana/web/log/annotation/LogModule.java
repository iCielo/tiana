/**
 * lincl
 * 2016年11月7日 上午10:11:42
 * 
 */
package com.lezic.tiana.web.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lezic.tiana.web.log.ModuleMenu;

/**
 * 模块菜单。用以标记类属于哪个模块哪个菜单的
 * 
 * @author lincl
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogModule {

    /** 模块菜单名称 */
    ModuleMenu value();
}
