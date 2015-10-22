-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `user_id` int(11) NOT NULL auto_increment,
  `USER_NAME` varchar(36) NOT NULL,
  `PASS_WORD` varchar(36) default NULL,
  `STATE` varchar(10) default 'AVAILABLE',
  `CREATE_TIME` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `UPDATE_TIME` timestamp NULL default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'a', 'a', 'AVAILABLE', null, null);
INSERT INTO `sys_users` VALUES ('39', 'aaa', 'aaaaa', 'AVAILABLE', '2015-04-07 22:08:35', null);
INSERT INTO `sys_users` VALUES ('33', 'jd', 'pass', 'AVAILABLE', '2015-02-07 18:59:58', null);
INSERT INTO `sys_users` VALUES ('34', 'jnb', 'pass', 'AVAILABLE', '2015-02-07 19:07:49', null);
INSERT INTO `sys_users` VALUES ('35', 'myx', '123456', 'AVAILABLE', '2015-02-07 19:11:05', null);
INSERT INTO `sys_users` VALUES ('38', 'jiaodong', 'pass', 'AVAILABLE', '2015-02-07 21:30:59', null);
