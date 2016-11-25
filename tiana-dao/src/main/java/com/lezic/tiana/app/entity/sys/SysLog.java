package com.lezic.tiana.app.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统日志
 * 
 * @author cielo
 * @date Mon Nov 28 14:10:44 CST 2016
 */
@Entity
@Table(name = "sys_log")
public class SysLog implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * clue
     */
    @Column(name = "clue", length = 36, unique = true)
    private String clue;

    /**
     * 模块
     */
    @Column(name = "module", length = 100, unique = true)
    private String module;

    /**
     * 时间点
     */
    @Column(name = "time", unique = true)
    private Date time;

    /**
     * 耗时
     */
    @Column(name = "cost_time", unique = true)
    private Integer costTime;

    /**
     * 内容
     */
    @Column(name = "detail", length = 500, unique = true)
    private String detail;

    /**
     * 菜单
     */
    @Column(name = "menu", length = 100, unique = true)
    private String menu;

    /**
     * 用户ID
     */
    @Column(name = "user_id", length = 255, unique = true)
    private String userId;

    /**
     * 结果
     */
    @Column(name = "result", length = 100, unique = true)
    private String result;

    /**
     * 设置 clue
     */
    public void setClue(String clue) {
        this.clue = clue;
    }

    /**
     * 获取 clue
     */
    public String getClue() {
        return this.clue;
    }

    /**
     * 设置 模块
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 获取 模块
     */
    public String getModule() {
        return this.module;
    }

    /**
     * 设置 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 主键
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 时间点
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取 时间点
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * 设置 耗时
     */
    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    /**
     * 获取 耗时
     */
    public Integer getCostTime() {
        return this.costTime;
    }

    /**
     * 设置 内容
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取 内容
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * 设置 菜单
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * 获取 菜单
     */
    public String getMenu() {
        return this.menu;
    }

    /**
     * 设置 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户ID
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取 结果
     */
    public String getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return "SysLog [" + "clue=" + clue + ", " + "module=" + module + ", " + "id=" + id + ", " + "time=" + time
                + ", " + "costTime=" + costTime + ", " + "detail=" + detail + ", " + "menu=" + menu + ", " + "userId="
                + userId + ", " + "result=" + result + "]";
    }

}
