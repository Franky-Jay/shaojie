/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mashen

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-04-13 17:46:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phonum` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `intention` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `class_intention` (`intention`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', 'a', 'a', 'a', 'a', 'ui', 'a', '2017-04-13 16:07:41');
INSERT INTO `application` VALUES ('2', 'b', 'b', 'b', 'b', 'java', 'b', '2017-04-13 16:07:58');
INSERT INTO `application` VALUES ('3', 'c', 'c', 'c', 'c', 'java', 'c', '2017-04-13 16:08:14');
