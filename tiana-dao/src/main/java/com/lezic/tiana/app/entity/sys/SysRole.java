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
 * @date Wed Feb 24 09:37:28 CST 2016
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * uuid主键标志
     */
    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

    /**
     * 操作用户ID
     */
    @Column(name = "op_user_id", length = 36)
    private String opUserId;

    /**
     * 角色名
     */
    @Column(name = "name", length = 255)
    private String name;

    /**
     * 操作时间
     */
    @Column(name = "op_time")
    private Date opTime;

    /**
     * 状态 on:启用 off:禁用
     */
    @Column(name = "status", length = 20, unique = true)
    private String status;

    /**
     * 备注
     */
    @Column(name = "remark", length = 255)
    private String remark;

    /**
     * 设置 uuid主键标志
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 uuid主键标志
     */
    public String getId() {
        return this.id;
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
     * 设置 状态 on:启用 off:禁用
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取 状态 on:启用 off:禁用
     */
    public String getStatus() {
        return this.status;
    }

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

}
