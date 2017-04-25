/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : ims

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-11 16:59:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bs_service`
-- ----------------------------
DROP TABLE IF EXISTS `bs_service`;
CREATE TABLE `bs_service` (
  `businessid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) DEFAULT NULL COMMENT '业务编码',
  `name` varchar(100) DEFAULT NULL COMMENT '业务名称',
  `describ` varchar(500) DEFAULT NULL COMMENT '业务描述',
  `status` int(11) DEFAULT NULL COMMENT '状态\r\n            0无效，1有效',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`businessid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表';

-- ----------------------------
-- Records of bs_service
-- ----------------------------

-- ----------------------------
-- Table structure for `uc_datarule`
-- ----------------------------
DROP TABLE IF EXISTS `uc_datarule`;
CREATE TABLE `uc_datarule` (
  `ruleid` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色ID',
  `permission_id` varchar(255) DEFAULT NULL,
  `business_code` varchar(50) DEFAULT NULL COMMENT '业务数据编码\r\n            查询列表必填，并且需要配置查询规则\r\n            与AOP注解配置一致',
  `rule` varchar(500) DEFAULT NULL COMMENT '规则',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ruleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据查询规则';

-- ----------------------------
-- Records of uc_datarule
-- ----------------------------
INSERT INTO `uc_datarule` VALUES ('1', '1', '013', 'user', 'CreatorUserIdEqualTo', '2017-04-04 22:55:30', '2017-04-04 22:55:30');

-- ----------------------------
-- Table structure for `uc_datarule_template`
-- ----------------------------
DROP TABLE IF EXISTS `uc_datarule_template`;
CREATE TABLE `uc_datarule_template` (
  `ruleid` varchar(36) NOT NULL COMMENT '主键',
  `rule` varchar(100) DEFAULT NULL COMMENT '规则',
  `orders` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ruleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据查询规则模板';

-- ----------------------------
-- Records of uc_datarule_template
-- ----------------------------

-- ----------------------------
-- Table structure for `uc_organization`
-- ----------------------------
DROP TABLE IF EXISTS `uc_organization`;
CREATE TABLE `uc_organization` (
  `department_id` varchar(50) NOT NULL COMMENT '编号',
  `pid` varchar(36) DEFAULT NULL COMMENT '父级部门',
  `name` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '组织描述',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门（组织）';

-- ----------------------------
-- Records of uc_organization
-- ----------------------------

-- ----------------------------
-- Table structure for `uc_permission`
-- ----------------------------
DROP TABLE IF EXISTS `uc_permission`;
CREATE TABLE `uc_permission` (
  `permission_id` varchar(36) NOT NULL COMMENT '主键',
  `pid` varchar(36) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(1:菜单,2:按钮)',
  `uri` varchar(100) DEFAULT NULL COMMENT 'URI路径',
  `classpath` varchar(100) DEFAULT NULL COMMENT '控制层类全路径(类全路径:方法名)，与AOP注解配置一致',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  `islist` int(11) DEFAULT NULL COMMENT '是否查询列表\r\n            0否1是',
  `business_code` varchar(50) DEFAULT NULL COMMENT '业务数据编码\r\n            查询列表必填，并且需要配置查询规则\r\n            与AOP注解配置一致',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能权限(资源)';

-- ----------------------------
-- Records of uc_permission
-- ----------------------------
INSERT INTO `uc_permission` VALUES ('01', '0', '系统管理', '1', null, null, 'icon-desktop', '1', '2017-04-03 19:24:03', '1', '0', null, '2017-04-03 23:50:12');
INSERT INTO `uc_permission` VALUES ('013', '01', '用户管理', '1', 'user/list.action', 'com.mashen.user.controller.UserManageController:pageSearch', null, '1', '2017-04-03 19:25:49', '1', '1', 'user', '2017-04-04 00:02:43');
INSERT INTO `uc_permission` VALUES ('0131', '013', '新增', '2', 'user/edit.action', 'com.mashen.user.controller.UserManageController:doAdd', null, null, '2017-04-04 22:13:24', null, null, null, '2017-04-04 22:13:41');
INSERT INTO `uc_permission` VALUES ('02', '0', '客户管理', '1', null, null, 'icon-list', '1', '2017-04-03 19:25:11', '2', '0', null, '2017-04-04 10:56:43');
INSERT INTO `uc_permission` VALUES ('024', '02', '客户列表', '1', 'user/list.action', 'com.mashen.user.controller.UserManageController:pageSearch', null, null, '2017-04-04 00:05:48', '1', '1', null, '2017-04-04 00:06:15');

-- ----------------------------
-- Table structure for `uc_role`
-- ----------------------------
DROP TABLE IF EXISTS `uc_role`;
CREATE TABLE `uc_role` (
  `role_id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of uc_role
-- ----------------------------
INSERT INTO `uc_role` VALUES ('1', '超级管理员', null, '1', '2017-04-03 23:26:16', '2017-04-03 23:26:16');

-- ----------------------------
-- Table structure for `uc_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_permission`;
CREATE TABLE `uc_role_permission` (
  `role_permission_id` varchar(36) NOT NULL COMMENT '主键',
  `permission_id` varchar(36) DEFAULT NULL COMMENT '功能ID',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色ID',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色_权限';

-- ----------------------------
-- Records of uc_role_permission
-- ----------------------------
INSERT INTO `uc_role_permission` VALUES ('1', '01', '1', '2017-04-03 23:29:00', '2017-04-03 23:30:19');
INSERT INTO `uc_role_permission` VALUES ('2', '02', '1', '2017-04-03 23:29:04', '2017-04-04 00:08:07');
INSERT INTO `uc_role_permission` VALUES ('3', '013', '1', '2017-04-03 23:30:27', '2017-04-03 23:30:27');
INSERT INTO `uc_role_permission` VALUES ('4', '024', '1', '2017-04-04 00:07:08', '2017-04-04 00:07:08');
INSERT INTO `uc_role_permission` VALUES ('5', '0131', '1', '2017-04-04 22:14:10', '2017-04-04 22:28:46');

-- ----------------------------
-- Table structure for `uc_user`
-- ----------------------------
DROP TABLE IF EXISTS `uc_user`;
CREATE TABLE `uc_user` (
  `user_id` varchar(36) NOT NULL COMMENT '主键',
  `account` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(32) NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(36) DEFAULT NULL COMMENT '盐',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `department_id` char(50) DEFAULT NULL COMMENT '用户所属部门',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creator_department_id` varchar(50) DEFAULT NULL COMMENT '创建者所属部门',
  `creator_user_id` varchar(36) DEFAULT NULL COMMENT '创建者ID',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of uc_user
-- ----------------------------
INSERT INTO `uc_user` VALUES ('01dd5123-9888-4d89-b9f5-e81c659013d7', 'user', '5ab22361b169cb147bfb569aa4320499', '0050ba6c-b3c0-43db-a37a-5d78237cbaee', '普通用户', null, '123323232', null, null, null, null, '2017-04-04 23:34:16', '2017-04-04 23:34:16', null, null);
INSERT INTO `uc_user` VALUES ('e8dcfd97-731f-4e4f-b394-47b3fa1b844b', 'admin', 'ba9a98cc42855494e44ae0c2e32e3a60', 'ed4878c1-93d2-4d81-8ede-fa6fa7806612', '管理员', null, '123323232', null, null, '1', null, '2017-04-02 22:19:02', '2017-04-02 22:45:30', '1', 'e8dcfd97-731f-4e4f-b394-47b3fa1b844b');

-- ----------------------------
-- Table structure for `uc_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_role`;
CREATE TABLE `uc_user_role` (
  `user_role_id` varchar(36) NOT NULL COMMENT '主键',
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色ID',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_角色';

-- ----------------------------
-- Records of uc_user_role
-- ----------------------------
INSERT INTO `uc_user_role` VALUES ('', 'e8dcfd97-731f-4e4f-b394-47b3fa1b844b', '1', '2017-04-03 23:26:59', '2017-04-03 23:26:59');

-- ----------------------------
-- Table structure for `uid_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `uid_sequence`;
CREATE TABLE `uid_sequence` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(1) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uid_sequence
-- ----------------------------
INSERT INTO `uid_sequence` VALUES ('46', '1');
