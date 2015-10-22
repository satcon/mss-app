-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` varchar(36) NOT NULL,
  `PARENT_ID` varchar(36) default NULL,
  `STATE` varchar(10) default '',
  `MENU_NAME` varchar(100) NOT NULL,
  `MENU_URL` varchar(200) default NULL,
  `MENU_LEVEL` decimal(2,0) default NULL,
  `MENU_ICON` varchar(20) default NULL,
  `SORT_ORDER` decimal(20,0) default NULL,
  PRIMARY KEY  (`ID`)
) DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', 'open', '首页', '', '1', 'icon-home', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', 'open', '1.测试', null, '2', 'icon-record', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', 'open', '2.资源管理', null, '2', 'icon-config', '2');
INSERT INTO `sys_menu` VALUES ('4', '3', 'open', '2.1.菜单配置', 'sys/menu/viewMenus', '3', 'icon-record', '1');
INSERT INTO `sys_menu` VALUES ('5', '1', 'open', '3.日志管理', null, '2', 'icon-heart', '3');
INSERT INTO `sys_menu` VALUES ('6', '5', 'open', '3.1.登录日志', '', '3', 'icon-record', '1');
INSERT INTO `sys_menu` VALUES ('7', '3', 'open', '2.2.用户配置', 'sys/user/viewUsers', '3', 'icon-man', '2');
