/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : lezic

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-12-07 10:35:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crud_column
-- ----------------------------
DROP TABLE IF EXISTS `crud_column`;
CREATE TABLE `crud_column` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `TABLE_NAME` varchar(50) NOT NULL COMMENT '表名',
  `COLUMN_NAME` varchar(50) NOT NULL COMMENT '列名',
  `COLUMN_TYPE` varchar(50) NOT NULL COMMENT '数据类型',
  `JAVA_NAME` varchar(50) NOT NULL COMMENT 'java名称',
  `JAVA_METHOD_NAME` varchar(255) DEFAULT NULL COMMENT 'java用以方法的命名，即字段首字母大写',
  `JAVA_TYPE` varchar(50) NOT NULL COMMENT 'java类型',
  `LABEL` varchar(50) NOT NULL COMMENT '显示名',
  `PLACEHOLDER` varchar(100) DEFAULT NULL COMMENT '输入提示',
  `INPUT_TYPE` varchar(50) NOT NULL COMMENT '数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框',
  `DICT_TYPE` varchar(50) DEFAULT NULL COMMENT '数据字典类型',
  `DICT_LIST` varchar(255) DEFAULT NULL COMMENT '自定义数据字典',
  `PRIMARY_KEY` int(2) DEFAULT NULL COMMENT '是否主键 ',
  `NULLABLE` int(2) DEFAULT NULL COMMENT '是否可空',
  `LENGTH` int(11) DEFAULT NULL COMMENT '字符长度',
  `RULES` varchar(255) DEFAULT NULL COMMENT '校验规则',
  `OP_USER_ID` varchar(36) DEFAULT NULL COMMENT '操作用户',
  `OP_TIME` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crud_column
-- ----------------------------
INSERT INTO `crud_column` VALUES ('10', 'sys_role', 'id', 'bigint', 'id', 'Id', 'String', '', null, 'text', null, null, '1', '0', null, 'required;', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('11', 'sys_role', 'code', 'varchar', 'code', 'Code', 'String', '主键', null, 'text', null, null, '0', '0', '20', 'required;length(~20);', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('12', 'sys_role', 'name', 'varchar', 'name', 'Name', 'String', '角色名', null, 'text', null, null, '0', '0', '255', 'required;length(~255);', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('13', 'sys_role', 'remark', 'varchar', 'remark', 'Remark', 'String', '备注', null, 'text', null, null, '0', '1', '255', 'length(~255);', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('14', 'sys_role', 'status', 'int', 'status', 'Status', 'Integer', '状态 1:启用 0:禁用', null, 'text', null, null, '0', '1', null, 'integer;', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('15', 'sys_role', 'op_user_id', 'varchar', 'opUserId', 'OpUserId', 'String', '操作用户ID', null, 'text', null, null, '0', '1', '36', 'length(~36);', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('16', 'sys_role', 'op_time', 'datetime', 'opTime', 'OpTime', 'Date', '操作时间', null, 'text', null, null, '0', '1', null, '', null, '2016-12-06 15:32:15');
INSERT INTO `crud_column` VALUES ('17', 'sys_user', 'id', 'bigint', 'id', 'Id', 'String', '主键', null, 'text', null, null, '1', '0', null, 'required;', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('18', 'sys_user', 'account', 'varchar', 'account', 'Account', 'String', '账号', null, 'text', null, null, '0', '0', '200', 'required;length(~200);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('19', 'sys_user', 'password', 'varchar', 'password', 'Password', 'String', '密码', null, 'text', null, null, '0', '0', '200', 'required;length(~200);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('20', 'sys_user', 'name', 'varchar', 'name', 'Name', 'String', '姓名', null, 'text', null, null, '0', '0', '100', 'required;length(~100);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('21', 'sys_user', 'sex', 'varchar', 'sex', 'Sex', 'String', '性别', null, 'text', null, null, '0', '1', '10', 'length(~10);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('22', 'sys_user', 'status', 'int', 'status', 'Status', 'Integer', '状态 on:1 off:0', null, 'text', null, null, '0', '1', null, 'integer;', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('23', 'sys_user', 'phone', 'varchar', 'phone', 'Phone', 'String', '手机号码', null, 'text', null, null, '0', '1', '100', 'length(~100);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('24', 'sys_user', 'email', 'varchar', 'email', 'Email', 'String', '邮箱地址', null, 'text', null, null, '0', '0', '100', 'required;length(~100);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('25', 'sys_user', 'remark', 'varchar', 'remark', 'Remark', 'String', '备注', null, 'text', null, null, '0', '1', '255', 'length(~255);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('26', 'sys_user', 'op_user_id', 'varchar', 'opUserId', 'OpUserId', 'String', '操作用户ID', null, 'text', null, null, '0', '1', '36', 'length(~36);', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('27', 'sys_user', 'op_time', 'datetime', 'opTime', 'OpTime', 'Date', '操作时间', null, 'text', null, null, '0', '1', null, '', null, '2016-12-06 15:32:17');
INSERT INTO `crud_column` VALUES ('44', 'sys_resource', 'id', 'bigint', 'id', 'Id', 'String', '主键', null, 'text', null, null, '1', '0', null, 'required;', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('45', 'sys_resource', 'code', 'varchar', 'code', 'Code', 'String', '资源码', null, 'text', null, null, '0', '0', '255', 'required;length(~255);', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('46', 'sys_resource', 'name', 'varchar', 'name', 'Name', 'String', '资源名称', null, 'text', null, null, '0', '0', '255', 'required;length(~255);', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('47', 'sys_resource', 'url', 'varchar', 'url', 'Url', 'String', '资源链接地址', null, 'text', null, null, '0', '0', '255', 'required;length(~255);', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('48', 'sys_resource', 'parent_code', 'varchar', 'parentCode', 'ParentCode', 'String', '父资源', null, 'text', null, null, '0', '0', '255', 'required;length(~255);', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('49', 'sys_resource', 'type', 'int', 'type', 'Type', 'Integer', '类型', '', 'select', 'SYS_RESOURCE_TYPE', '', '0', '0', null, 'required;integer;', null, null);
INSERT INTO `crud_column` VALUES ('50', 'sys_resource', 'op_user_id', 'varchar', 'opUserId', 'OpUserId', 'String', '操作用户ID', null, 'text', null, null, '0', '1', '36', 'length(~36);', null, '2016-12-07 10:21:44');
INSERT INTO `crud_column` VALUES ('51', 'sys_resource', 'op_time', 'datetime', 'opTime', 'OpTime', 'Date', '操作时间', null, 'text', null, null, '0', '1', null, '', null, '2016-12-07 10:21:44');

-- ----------------------------
-- Table structure for crud_table
-- ----------------------------
DROP TABLE IF EXISTS `crud_table`;
CREATE TABLE `crud_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `TABLE_NAME` varchar(20) NOT NULL COMMENT '表名',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单名',
  `MODULE_NAME` varchar(50) NOT NULL COMMENT '模块名',
  `MODULE_CODE` varchar(20) NOT NULL COMMENT '模块代码',
  `ENTITY` varchar(255) NOT NULL COMMENT '实体类名',
  `ENTITY_BEAN` varchar(255) DEFAULT NULL COMMENT '实体类作为bean的名称',
  `ENTITY_PACKAGE` varchar(255) NOT NULL COMMENT '实体类包路径',
  `CONTROLLER_URL` varchar(255) NOT NULL COMMENT '控制器映射路径',
  `CONTROLLER` varchar(255) NOT NULL COMMENT '控制器类',
  `CONTROLLER_BEAN` varchar(255) DEFAULT NULL COMMENT '控制器类作为bean的名称',
  `CONTROLLER_PACKAGE` varchar(255) NOT NULL COMMENT '控制器包路径',
  `SERVICE` varchar(255) NOT NULL COMMENT '服务层类',
  `SERVICE_BEAN` varchar(255) DEFAULT NULL COMMENT '服务层作为bean的名称',
  `SERVICE_PACKAGE` varchar(255) NOT NULL COMMENT '服务层包路径',
  `LIST_URL` varchar(255) NOT NULL COMMENT '列表映射',
  `LIST_JSP` varchar(255) NOT NULL COMMENT '列表JSP',
  `ADD_URL` varchar(255) NOT NULL COMMENT '新增映射',
  `ADD_JSP` varchar(255) NOT NULL COMMENT '新增JSP',
  `UPD_URL` varchar(255) NOT NULL COMMENT '修改映射',
  `UPD_JSP` varchar(255) NOT NULL COMMENT '修改JSP',
  `MYBATIS_XML` varchar(255) NOT NULL COMMENT 'mybatis的xml配置',
  `OP_USER_ID` varchar(36) DEFAULT NULL COMMENT '操作用户',
  `OP_TIME` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_crud_table_table_name` (`TABLE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crud_table
-- ----------------------------
INSERT INTO `crud_table` VALUES ('6', 'sys_log', '系统日志', '系统管理', 'sys', 'SysLog', 'sysLog', 'com.lezic.tiana.app.entity.sys', '/sys/log.do', 'SysLogController', 'sysLogController', 'com.lezic.tiana.app.action.sys', 'SysLogService', 'sysLogService', 'com.lezic.tiana.app.service.sys', '/sys/log.do?method=list', '/sys/log/SysLog-list', '/sys/log.do?method=add', '/sys/log/SysLog-add', '/sys/log.do?method=upd', '/sys/log/SysLog-upd', '/sys/SysLog-sql', null, null);
INSERT INTO `crud_table` VALUES ('7', 'sys_role', '用户角色', '系统管理', 'sys', 'SysRole', 'sysRole', 'com.lezic.app.sys.role.entity', '/sys/role.do', 'SysRoleController', 'sysRoleController', 'com.lezic.app.sys.role.action', 'SysRoleService', 'sysRoleService', 'com.lezic.app.sys.role.service', '/sys/role.do?method=list', '/sys/role/SysRole-list', '/sys/role.do?method=add', '/sys/role/SysRole-add', '/sys/role.do?method=upd', '/sys/role/SysRole-upd', '/sys/SysRole-sql', null, null);
INSERT INTO `crud_table` VALUES ('8', 'sys_user', '用户管理', '系统管理', 'sys', 'SysUser', 'sysUser', 'com.lezic.app.sys.user.entity', '/sys/user.do', 'SysUserController', 'sysUserController', 'com.lezic.app.sys.user.action', 'SysUserService', 'sysUserService', 'com.lezic.app.sys.user.service', '/sys/user.do?method=list', '/sys/user/SysUser-list', '/sys/user.do?method=add', '/sys/user/SysUser-add', '/sys/user.do?method=upd', '/sys/user/SysUser-upd', '/sys/SysUser-sql', null, null);
INSERT INTO `crud_table` VALUES ('9', 'sys_resource', '资源菜单', '系统管理', 'sys', 'SysResource', 'sysResource', 'com.lezic.tiana.app.entity.sys', '/sys/resource.do', 'SysResourceController', 'sysResourceController', 'com.lezic.tiana.app.action.sys', 'SysResourceService', 'sysResourceService', 'com.lezic.tiana.app.service.sys', '/sys/resource.do?method=list', '/sys/resource/SysResource-list', '/sys/resource.do?method=add', '/sys/resource/SysResource-add', '/sys/resource.do?method=upd', '/sys/resource/SysResource-upd', '/sys/SysResource-sql', null, null);

-- ----------------------------
-- Table structure for hibernate_sequences
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequences
-- ----------------------------
INSERT INTO `hibernate_sequences` VALUES ('sys_role', '1');

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sort` varchar(255) NOT NULL COMMENT '分类',
  `dict_key` varchar(255) NOT NULL COMMENT '字典键',
  `dict_value` varchar(255) NOT NULL COMMENT '字典值',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态：1，0',
  `seq` int(5) NOT NULL COMMENT '排序值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `op_user_id` int(36) DEFAULT NULL COMMENT '操作用户',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', 'STATUS', '1', '启用', '1', '1', '启用', null, null);
INSERT INTO `sys_dictionary` VALUES ('2', 'STATUS', '0', '禁用', '1', '2', '启用', null, null);
INSERT INTO `sys_dictionary` VALUES ('6', 'SEX', 'M', '男', '1', '1', '', null, null);
INSERT INTO `sys_dictionary` VALUES ('7', 'SEX', 'F', '女', '1', '2', '', null, null);
INSERT INTO `sys_dictionary` VALUES ('8', 'SEX', 'N', '其它', '1', '3', '', null, null);
INSERT INTO `sys_dictionary` VALUES ('10', 'SYS_RESOURCE_TYPE', '2', '功能码', '1', '2', '1：菜单 2：功能码', null, null);
INSERT INTO `sys_dictionary` VALUES ('11', 'SYS_RESOURCE_TYPE', '1', '菜单', '1', '1', '1：菜单 2：功能码', null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `clue` varchar(36) DEFAULT NULL COMMENT '线索ID',
  `time` datetime DEFAULT NULL COMMENT '时间点',
  `module` varchar(100) DEFAULT NULL COMMENT '模块',
  `menu` varchar(100) DEFAULT NULL COMMENT '菜单',
  `detail` varchar(500) DEFAULT NULL COMMENT '内容',
  `result` varchar(100) DEFAULT NULL COMMENT '结果',
  `cost_time` int(11) DEFAULT NULL COMMENT '耗时',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'b1ee7513-c2dd-4135-a808-4a7e135a7249', '2016-11-28 14:38:42', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '67', null);
INSERT INTO `sys_log` VALUES ('2', '02b2505b-ff09-4bf7-8645-096b0d34c670', '2016-11-28 14:38:56', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '1', null);
INSERT INTO `sys_log` VALUES ('3', '8de809ae-5215-4e2f-919c-cff931653f6e', '2016-11-28 14:38:56', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '0', null);
INSERT INTO `sys_log` VALUES ('4', '65a0063d-5c2b-404d-b2fe-dfbefa8a39c5', '2016-11-28 14:38:57', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '0', null);
INSERT INTO `sys_log` VALUES ('5', 'e9617560-c478-499b-aae6-ebc9dcf36a21', '2016-11-28 14:38:57', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '1', null);
INSERT INTO `sys_log` VALUES ('6', 'a2aaa9ac-9b60-418c-bc72-a0376969b0b3', '2016-11-28 14:39:18', 'API', '学生管理', '根据ID主键获取学生,ID：1', '[SUCCESS]', '58', null);
INSERT INTO `sys_log` VALUES ('7', '35107f00-f488-4fd4-bbe4-a483c3fefa59', '2016-11-28 14:45:33', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '41', null);
INSERT INTO `sys_log` VALUES ('8', 'f1584f3b-a296-4ae2-901b-c99d3c8bfb00', '2016-11-28 15:00:46', 'API', '登录退出', '用户登录系统，获取token。用户名：11', '[SUCCESS]登录成功', '49', null);
INSERT INTO `sys_log` VALUES ('9', '739d45d3-ee37-4054-8da6-4cde73f15df7', '2016-12-05 14:25:22', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '106', null);
INSERT INTO `sys_log` VALUES ('10', '252e444c-24b6-41c9-a4bd-4759961840c2', '2016-12-05 14:26:18', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('11', '902ee313-2cab-4bfd-a4f3-7b12e32fcecc', '2016-12-05 14:47:30', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '133', null);
INSERT INTO `sys_log` VALUES ('12', '56351fe0-1078-4e29-a8ff-cf2f3c2aaea3', '2016-12-05 14:48:30', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '137', null);
INSERT INTO `sys_log` VALUES ('13', '9b29d088-56ec-4eed-bd09-4be58ac41eaf', '2016-12-05 15:12:59', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '144', null);
INSERT INTO `sys_log` VALUES ('14', '1a278a1a-fd17-40ad-b3a6-78a59cafd002', '2016-12-05 15:13:08', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('15', '89c519bd-f6db-4a81-8631-c16c0f3ab3dc', '2016-12-05 15:14:27', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('16', '99429338-7c63-4b48-8913-c5b37c9f8e67', '2016-12-05 15:14:29', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('17', 'a0fbddff-e47a-4e9d-973e-0c5f1007d733', '2016-12-05 15:16:41', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('18', '468364e6-9a2c-4223-9a5e-31faea9bb226', '2016-12-05 15:17:18', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('19', 'bde9c658-2c90-4a11-b6d2-11deb07a1977', '2016-12-05 15:17:20', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('20', '96b9accb-7609-4b3d-94db-50bc6cf9056c', '2016-12-05 15:17:48', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('21', 'da588151-34c0-4403-97f8-27338b3327a3', '2016-12-05 15:17:51', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('22', '76386ff3-ca3c-44a0-b292-c4d2c140df63', '2016-12-05 15:18:07', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('23', 'ad1bd2e5-6fc4-431e-a745-b250e402baa7', '2016-12-05 15:18:09', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('24', '23cd305a-1d75-42d3-bc5c-358d1cd35c5f', '2016-12-05 15:31:59', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('25', 'a128b65e-a291-4f72-817d-df4ea1bf0b34', '2016-12-05 15:32:07', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('26', 'd7527146-15c6-49d3-91a6-12180f671a90', '2016-12-05 15:32:13', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('27', 'acd05607-0c83-4677-88ef-bacf6675c473', '2016-12-05 15:33:03', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('28', 'e3104d5f-2bc0-47e1-8c9f-1850d08076c9', '2016-12-05 15:33:18', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('29', 'cc5542ab-e9ce-4439-87ad-85706819ccc9', '2016-12-05 15:33:43', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('30', '33d24098-cdae-4de4-b407-f4ad36e6606f', '2016-12-05 15:44:25', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('31', '685a7dab-7e9a-42af-bf2d-e89efadc0e31', '2016-12-05 15:44:43', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('32', '44e22ebc-abc4-451e-a2d7-7a079aa7d07b', '2016-12-05 15:44:45', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('33', '6e23319d-3998-415f-947d-d3fce6d2aa0b', '2016-12-05 15:53:23', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '63', null);
INSERT INTO `sys_log` VALUES ('34', 'a6b0e743-7b9e-409f-8471-562968bdfbae', '2016-12-05 15:57:24', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '92', null);
INSERT INTO `sys_log` VALUES ('35', 'cc0c80d8-0a55-4b0d-a7e6-2824ea6e8585', '2016-12-05 15:57:29', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('36', '746e5549-f05a-4249-944c-f093aa9c2da5', '2016-12-05 15:59:07', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('37', '55dd47bd-15cd-4ba8-9488-1088d290fc46', '2016-12-05 16:00:04', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('38', '189a8cdc-2ef5-4858-a68e-cd5f5d779fdb', '2016-12-05 16:00:20', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('39', '36fe24d3-7f2e-4c20-87b8-5c7b8e70272f', '2016-12-05 16:01:05', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('40', '2c9e2a7c-ff94-4196-b611-f651a2e54c1b', '2016-12-05 16:01:21', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('41', '24c4b0e8-9e9c-45c6-a1ee-92ac3c4dc0df', '2016-12-05 16:01:37', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('42', 'eaf09bc0-8fb1-4598-af3d-bb71229270ea', '2016-12-05 16:01:47', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('43', '48325b48-8d63-4ce3-a449-d04f6299217e', '2016-12-05 16:02:28', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('44', '2c2f948d-dbfd-4111-bd19-213f36f2cc83', '2016-12-05 16:02:42', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('45', '3a840934-58d7-481e-ad62-ae1595ea2e82', '2016-12-05 16:03:09', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('46', '5b8a3971-baf3-4c72-bfba-e70684fda527', '2016-12-05 16:03:10', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('47', '8dadb8db-c7e9-46d7-a33c-e56e9ef764aa', '2016-12-05 16:03:17', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('48', '62cc1812-6907-4300-b878-0b20f69a0966', '2016-12-05 16:03:27', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '1', null);
INSERT INTO `sys_log` VALUES ('49', 'f7465d24-02dd-4e68-be39-3252afa84cfa', '2016-12-05 16:03:34', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('50', '35abd7b7-7fb0-4f56-a622-28eb828caf89', '2016-12-05 16:03:40', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('51', 'c044154e-325a-49fb-b7e3-95c089a66840', '2016-12-05 16:05:53', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('52', '6a9ef2d3-7757-4f56-adaa-dc79be11dba3', '2016-12-05 16:10:45', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('53', 'fce23c46-4728-4631-abf7-a7d6409e2d38', '2016-12-05 16:11:18', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('54', 'c99f8ed3-ae8b-413b-9b1b-bbd48e46e5b8', '2016-12-05 16:12:00', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('55', 'cf9393ff-d1c1-4ad2-af2b-9e25fecdfff3', '2016-12-05 16:16:15', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('56', '70fcd5d1-cd8b-4f1b-bfe2-e128e77ac97d', '2016-12-05 16:18:13', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('57', 'c6a49510-34f4-477c-ac92-1f5c65afb98d', '2016-12-05 16:18:16', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('58', 'a74dbe2f-3a22-4bcb-bb9c-af9e9ee7b2b7', '2016-12-05 16:19:03', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('59', 'f26d7213-32a3-48c6-a9db-9e1a80db3969', '2016-12-05 16:19:47', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '1', null);
INSERT INTO `sys_log` VALUES ('60', 'f6ae22a6-5f63-4ca9-86fc-d3607ba4f338', '2016-12-05 17:52:19', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '286', null);
INSERT INTO `sys_log` VALUES ('61', 'beb94b45-b876-4d57-b726-06ef842a74b8', '2016-12-05 17:52:46', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('62', 'a6ab35fc-5c6a-44d4-9416-feaee0e05811', '2016-12-05 17:59:22', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('63', '7d05a8d2-9c85-4904-bd28-693f99d6a19e', '2016-12-05 17:59:41', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('64', 'a95f7a85-5842-45c5-9ea1-4af56b9acaa4', '2016-12-05 18:03:11', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('65', 'e3eaf499-c748-43f1-97ed-e260ed77d7e1', '2016-12-05 18:04:13', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('66', '4b6474e0-7738-45e3-8127-b15dfdcbbc78', '2016-12-05 18:06:20', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('67', 'b2af671e-c401-4987-a267-2486ada9d0e9', '2016-12-05 18:09:55', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('68', '3ed008f6-d5c2-44a4-8811-9d1b4029dac7', '2016-12-05 18:10:04', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('69', '8dc95a30-8203-410e-b17b-f6a22b93f4cf', '2016-12-05 18:10:50', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('70', '7e5d0f2b-39a6-4e7d-afd7-eeb67302c5cb', '2016-12-05 18:14:36', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('71', '4b75d195-d36b-4323-bbea-d8b7040b4f62', '2016-12-05 18:17:27', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);
INSERT INTO `sys_log` VALUES ('72', 'a4243225-30f2-4159-aeea-ffe3d3fe9d88', '2016-12-05 18:29:03', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('73', '5f3f425e-d6d6-44e1-aa48-cc472c0237f8', '2016-12-05 18:29:28', '系统管理', '用户角色', '访问用户角色新增列表', '/sys/role/SysRole-add', '0', null);
INSERT INTO `sys_log` VALUES ('74', '69b493a9-31d5-470b-b8ef-1b996d1dc5b7', '2016-12-06 09:44:41', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '289', null);
INSERT INTO `sys_log` VALUES ('75', '5bf6e1bd-b6f5-4fd7-b7eb-b5f423174044', '2016-12-06 10:11:08', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '309', null);
INSERT INTO `sys_log` VALUES ('76', '77b5bb91-a449-48b3-908d-48cc1e084d2a', '2016-12-06 11:02:46', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '101', null);
INSERT INTO `sys_log` VALUES ('77', '62b6494f-1521-4595-ae73-8977aaf55ef9', '2016-12-06 16:20:04', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '81', null);
INSERT INTO `sys_log` VALUES ('78', 'f2066591-c22d-4c2f-9d9d-bda04e880c5d', '2016-12-06 18:22:05', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '25', null);
INSERT INTO `sys_log` VALUES ('79', '41283261-78cb-4c00-b071-155ad5cff48f', '2016-12-06 18:23:12', '系统管理', '用户角色', '访问用户角色列表', '/sys/role/SysRole-list', '0', null);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) NOT NULL COMMENT '资源码',
  `name` varchar(255) NOT NULL COMMENT '资源名称',
  `url` varchar(255) NOT NULL COMMENT '资源链接地址',
  `parent_code` varchar(255) NOT NULL COMMENT '父资源',
  `type` int(11) NOT NULL COMMENT '类型 1：菜单 2：功能码',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '角色名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT NULL COMMENT '状态 1:启用 0:禁用',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '12', '1', '1', '0', null, null);
INSERT INTO `sys_role` VALUES ('2', 'admin', 'admin', '', '1', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(200) NOT NULL COMMENT '账号',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `status` int(2) DEFAULT NULL COMMENT '状态 on:1 off:0',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) NOT NULL COMMENT '邮箱地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `op_user_id` varchar(36) DEFAULT NULL COMMENT '操作用户ID',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '林', 'M', '1', '13000022313', 'sdf@sina.com', '111', null, null);
INSERT INTO `sys_user` VALUES ('2', 'demo', 'tiana0.1', '厦门', 'M', '1', '13912341234', 'skdfj@sina.com', '', null, null);
SET FOREIGN_KEY_CHECKS=1;
