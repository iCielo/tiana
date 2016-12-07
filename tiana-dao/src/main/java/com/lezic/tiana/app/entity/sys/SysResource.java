package com.lezic.tiana.app.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源菜单
 * @author cielo
 * @date 2016-12-07 09:31:55
 */
@Entity
@Table(name = "sys_resource")
public class SysResource implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
			/**
		* 主键
		*/
				@Id
		@GeneratedValue(strategy = GenerationType.AUTO)  
				@Column(name = "id"  , unique = true   , nullable = false )
		private String id;
		
			/**
		* 资源码
		*/
				@Column(name = "code" ,  length = 255   , unique = true   , nullable = false )
		private String code;
		
			/**
		* 资源名称
		*/
				@Column(name = "name" ,  length = 255   , unique = true   , nullable = false )
		private String name;
		
			/**
		* 资源链接地址
		*/
				@Column(name = "url" ,  length = 255   , unique = true   , nullable = false )
		private String url;
		
			/**
		* 父资源
		*/
				@Column(name = "parent_code" ,  length = 255   , unique = true   , nullable = false )
		private String parentCode;
		
			/**
		* 类型 1：菜单 2：功能码
		*/
				@Column(name = "type"  , unique = true   , nullable = false )
		private Integer type;
		
			/**
		* 操作用户ID
		*/
				@Column(name = "op_user_id" ,  length = 36   , unique = true  )
		private String opUserId;
		
			/**
		* 操作时间
		*/
				@Column(name = "op_time"  , unique = true  )
		private Date opTime;
		
		
			/**
		* 设置 主键
		*/
		public void setId(String id){
			this.id = id;
		}
		
		/**
		* 获取 主键
		*/
		public String getId(){
			return this.id;
		}
			/**
		* 设置 资源码
		*/
		public void setCode(String code){
			this.code = code;
		}
		
		/**
		* 获取 资源码
		*/
		public String getCode(){
			return this.code;
		}
			/**
		* 设置 资源名称
		*/
		public void setName(String name){
			this.name = name;
		}
		
		/**
		* 获取 资源名称
		*/
		public String getName(){
			return this.name;
		}
			/**
		* 设置 资源链接地址
		*/
		public void setUrl(String url){
			this.url = url;
		}
		
		/**
		* 获取 资源链接地址
		*/
		public String getUrl(){
			return this.url;
		}
			/**
		* 设置 父资源
		*/
		public void setParentCode(String parentCode){
			this.parentCode = parentCode;
		}
		
		/**
		* 获取 父资源
		*/
		public String getParentCode(){
			return this.parentCode;
		}
			/**
		* 设置 类型 1：菜单 2：功能码
		*/
		public void setType(Integer type){
			this.type = type;
		}
		
		/**
		* 获取 类型 1：菜单 2：功能码
		*/
		public Integer getType(){
			return this.type;
		}
			/**
		* 设置 操作用户ID
		*/
		public void setOpUserId(String opUserId){
			this.opUserId = opUserId;
		}
		
		/**
		* 获取 操作用户ID
		*/
		public String getOpUserId(){
			return this.opUserId;
		}
			/**
		* 设置 操作时间
		*/
		public void setOpTime(Date opTime){
			this.opTime = opTime;
		}
		
		/**
		* 获取 操作时间
		*/
		public Date getOpTime(){
			return this.opTime;
		}
		
	@Override
	public String toString() {
		return "SysResource ["
								+ "id=" + id +", "								+ "code=" + code +", "								+ "name=" + name +", "								+ "url=" + url +", "								+ "parentCode=" + parentCode +", "								+ "type=" + type +", "								+ "opUserId=" + opUserId +", "								+ "opTime=" + opTime 								+ "]";
	}

}
