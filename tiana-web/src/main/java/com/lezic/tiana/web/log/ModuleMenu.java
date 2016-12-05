/**
 * lincl
 * 2016年11月7日 上午9:49:34
 * 
 */
package com.lezic.tiana.web.log;

/**
 * 模块菜单枚举
 * 
 * @author lincl
 * 
 */
public enum ModuleMenu {
    
    /** 系统管理 > 用户角色 */
    SYS_ROLE("系统管理", "用户角色"),
    /** 系统管理 > 系统用户 */
    SYS_USER("系统管理", "系统用户"),
    
    /** API > 学生管理 */
    API_STUDENT("API", "学生管理"),
    /** API > 登录退出 */
    API_TOKEN("API", "登录退出"),
    /** 其它 > 其它 */
    OTHER("其它", "其它");

    /** 模块名称 */
    private String module;

    /** 菜单名称 */
    private String menu;

    /**
     * 构造方法
     * 
     * @param module
     * @param menu
     */
    private ModuleMenu(String module, String menu) {
        this.module = module;
        this.menu = menu;
    }

    /**
     * 模块名称
     * 
     * @return
     * @author lincl
     * @date 2016年11月7日 上午10:51:13
     */
    public String getModule() {
        return module;
    }

    /**
     * 菜单名称
     * 
     * @return
     * @author lincl
     * @date 2016年11月7日 上午10:51:08
     */
    public String getMenu() {
        return menu;
    }

    /**
     * 获取名称
     * 
     * @return
     * @author lincl
     * @date 2016年11月7日 上午10:50:59
     */
    public String getName() {
        return this.module + " > " + this.menu;
    }

}
