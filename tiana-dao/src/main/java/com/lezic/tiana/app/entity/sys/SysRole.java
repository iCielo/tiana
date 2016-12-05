package com.lezic.tiana.app.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色
 * 
 * @author cielo
 * @date Mon Dec 05 11:12:02 CST 2016
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * 备注
     */
    @Column(name = "remark", length = 255, unique = true)
    private String remark;

    /**
     * 操作用户ID
     */
    @Column(name = "op_user_id", length = 36, unique = true)
    private String opUserId;

    /**
     * 主键
     */
    @Column(name = "code", length = 20, unique = true, nullable = false)
    private String code;

    /**
     * 状态 1:启用 0:禁用
     */
    @Column(name = "status", unique = true)
    private Integer status;

    /**
     * 操作时间
     */
    @Column(name = "op_time", unique = true)
    private Date opTime;

    /**
     * 角色名
     */
    @Column(name = "name", length = 255, unique = true, nullable = false)
    private String name;

    /**
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取 备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置 操作用户ID
     */
    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }

    /**
     * 获取 操作用户ID
     */
    public String getOpUserId() {
        return this.opUserId;
    }

    /**
     * 设置
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 主键
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 主键
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 状态 1:启用 0:禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 状态 1:启用 0:禁用
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置 操作时间
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 获取 操作时间
     */
    public Date getOpTime() {
        return this.opTime;
    }

    /**
     * 设置 角色名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 角色名
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "SysRole [" + "remark=" + remark + ", " + "opUserId=" + opUserId + ", " + "id=" + id + ", " + "code="
                + code + ", " + "status=" + status + ", " + "opTime=" + opTime + ", " + "name=" + name + "]";
    }

}
