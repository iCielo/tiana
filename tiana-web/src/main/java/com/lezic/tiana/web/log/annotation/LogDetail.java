/**
 * lincl
 * 2016年9月12日 下午5:35:45
 * 
 */
package com.lezic.tiana.web.log.annotation;

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
public @interface LogDetail {

    /**
     * <p>
     * 日志内容
     * </p>
     * <p>
     * 例1：获取用户记录，用户标志：{0}。
     * </p>
     * <p>
     * 其中序号代表参数在方法参数的索引 method.get(String id,String name,String sex)
     * </p>
     * <p>
     * 例2：搜索用户记录，用户名：{0.username}。
     * </p>
     * <p>
     * 其中序号代表方法参数的索引,key表示参数的成员变量名 method.list(User)
     * </p>
     */
    String value();

}
