/*
 Navicat MySQL Data Transfer

 Source Server         : stu
 Source Server Type    : MySQL
 Source Server Version : 50558
 Source Host           : alphaae.com:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50558
 File Encoding         : 65001

 Date: 10/10/2019 19:39:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_time` datetime NULL DEFAULT NULL,
  `last_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('', '123456', '', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('ac', '123456', 'acc@aa.com', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, '2019-07-05 11:00:06', '113.204.144.202');
INSERT INTO `users` VALUES ('ae', '202cb962ac59075b964b07152d234b70', NULL, NULL, '2019-06-20 08:28:50', '123.147.246.223');
INSERT INTO `users` VALUES ('ae123', '123456', 'ae@0.com', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('alphaae', 'e10adc3949ba59abbe56e057f20f883e', 'alphaae@foxmail.com', '暂无', '2019-07-05 08:48:32', '113.204.144.201');

SET FOREIGN_KEY_CHECKS = 1;
