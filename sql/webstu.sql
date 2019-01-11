/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : webstu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-11 12:23:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_webstu_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_webstu_book`;
CREATE TABLE `tb_webstu_book` (
  `b_id` varchar(32) NOT NULL,
  `b_name` varchar(50) DEFAULT NULL,
  `b_content` varchar(255) DEFAULT NULL,
  `b_value` int(6) DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_webstu_book
-- ----------------------------

-- ----------------------------
-- Table structure for tb_webstu_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_webstu_user`;
CREATE TABLE `tb_webstu_user` (
  `u_id` varchar(32) NOT NULL COMMENT '主键',
  `u_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `u_pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `u_role_id` varchar(5) DEFAULT NULL COMMENT '角色ID',
  `u_has_money` int(6) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_webstu_user
-- ----------------------------
INSERT INTO `tb_webstu_user` VALUES ('manager', '管理员', '123456', '2', null);
INSERT INTO `tb_webstu_user` VALUES ('user01', '鲁班七号', '123456', '1', '9234');

-- ----------------------------
-- Table structure for tb_webstu_user_book_status
-- ----------------------------
DROP TABLE IF EXISTS `tb_webstu_user_book_status`;
CREATE TABLE `tb_webstu_user_book_status` (
  `ub_id` varchar(255) NOT NULL,
  `ub_user_id` varchar(255) DEFAULT NULL,
  `ub_book_id` varchar(255) DEFAULT NULL,
  `ub_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_webstu_user_book_status
-- ----------------------------
