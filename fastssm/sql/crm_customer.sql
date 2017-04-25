/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : ims

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-13 10:58:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `crm_customer`
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别:1男，2女',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `profession` varchar(50) DEFAULT NULL COMMENT '专业',
  `degree` varchar(20) DEFAULT NULL COMMENT '学历',
  `graduationtime` varchar(20) DEFAULT NULL COMMENT '毕业时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `source` varchar(50) DEFAULT NULL COMMENT '客户来源',
  `isopen` varchar(20) DEFAULT NULL COMMENT '公共public\r\n            私有private',
  `baseinfo` varchar(100) DEFAULT NULL COMMENT '基本情况',
  `economicinfo` varchar(500) DEFAULT NULL COMMENT '经济情况',
  `loaninf` varchar(20) DEFAULT NULL COMMENT '贷款情况',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creator_department_id` varchar(50) DEFAULT NULL COMMENT '创建者所属部门',
  `creator_user_id` varchar(36) DEFAULT NULL COMMENT '创建者ID(设置为私有的时候需改变为设置者的userid)',
  `first_creator_user_id` varchar(36) DEFAULT NULL COMMENT '首次创建人',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
