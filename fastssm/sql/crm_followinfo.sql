/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : ims

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-13 10:58:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `crm_followinfo`
-- ----------------------------
DROP TABLE IF EXISTS `crm_followinfo`;
CREATE TABLE `crm_followinfo` (
  `follow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户ID',
  `username` varchar(20) DEFAULT NULL COMMENT '跟进人',
  `content` varchar(1000) DEFAULT NULL COMMENT '跟进内容',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastmodifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creator_department_id` varchar(50) DEFAULT NULL COMMENT '创建者所属部门',
  `creator_user_id` varchar(36) DEFAULT NULL COMMENT '创建者ID',
  PRIMARY KEY (`follow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_followinfo
-- ----------------------------
