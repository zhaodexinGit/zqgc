/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : project_database

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-01 16:39:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单地址',
  `is_disable` char(1) DEFAULT '1' COMMENT '0禁用1启用',
  `menu_level` char(1) DEFAULT NULL COMMENT '菜单等级',
  `parent_menu_id` int(5) DEFAULT NULL COMMENT '父级菜单id',
  `order_num` int(5) DEFAULT NULL COMMENT '菜单排序',
  `icon_class` varchar(50) DEFAULT NULL COMMENT '图标样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '基础设置', '', '1', '1', '0', '1', 'icon-wrench');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '/sys/user/userList.htm', '1', '2', '1', '2', '');
INSERT INTO `sys_menu` VALUES ('3', '菜单管理', '/sys/sysMenu/sysMenuList.htm', '1', '2', '1', '3', '');
INSERT INTO `sys_menu` VALUES ('4', '权限管理', '/sys/sysUserMenu/toSysUserMenu.htm', '1', '2', '1', '4', '');
INSERT INTO `sys_menu` VALUES ('5', '角色管理', '/sys/sysRole/sysRoleList.htm', '1', '2', '1', '5', '');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_code` varchar(200) NOT NULL COMMENT '角色编码',
  `role_name` varchar(200) NOT NULL COMMENT '角色名称',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '1启用、0禁用',
  `remark` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `creator` int(10) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `menu_id` int(5) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=520 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------
INSERT INTO `sys_user_menu` VALUES ('515', '1', '1');
INSERT INTO `sys_user_menu` VALUES ('516', '1', '2');
INSERT INTO `sys_user_menu` VALUES ('517', '1', '3');
INSERT INTO `sys_user_menu` VALUES ('518', '1', '4');
INSERT INTO `sys_user_menu` VALUES ('519', '1', '5');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `role_id` int(10) NOT NULL COMMENT '角色ID',
  `creator` int(10) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(300) DEFAULT NULL COMMENT 'email',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `login_ip` varchar(50) DEFAULT NULL COMMENT '登陆ip',
  `enable_status` int(10) NOT NULL DEFAULT '1' COMMENT '0禁用,1启用',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '登陆时间',
  `failed_times` int(10) DEFAULT NULL COMMENT '登陆失败次数',
  `salt` varchar(100) DEFAULT NULL COMMENT '密码+算法',
  `roles` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '7b51896e27dfe2f39885c21656d59659f6d2ee44', '系统管理员', '1249119842@qq.com', '13124795268', '127.0.0.1', '1', 'admin', '2015-01-14 12:29:36', '2015-01-16 16:42:24', '0', '2cbcf7bdc2fb79ae', '');
