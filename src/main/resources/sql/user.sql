/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 04/04/2020 16:41:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(4) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'zs', '123456', 12, '32');
INSERT INTO `user` VALUES (5, '2222', '12345678', 18, '666');
INSERT INTO `user` VALUES (6, '你好', 'nirui3431665', 12, '13421192910');
INSERT INTO `user` VALUES (7, '我还会', '444444444', 17, '13421192910');
INSERT INTO `user` VALUES (8, 'lisi', '12345678', 12, '13');
INSERT INTO `user` VALUES (9, '牛牛牛', '123456', 12, '12');
INSERT INTO `user` VALUES (10, '13456', '1', 1, '1');
INSERT INTO `user` VALUES (11, '星游记', '1234', 12, '1312');
INSERT INTO `user` VALUES (12, '121111', '123456', 100, '3421');
INSERT INTO `user` VALUES (13, '11267', '123444', 11, '3421');
INSERT INTO `user` VALUES (14, '到底', '345678', 23, '你下班');
INSERT INTO `user` VALUES (15, '111111', '123', 123, '123');
INSERT INTO `user` VALUES (16, '觉得你觉得', '1111', 12, '13');
INSERT INTO `user` VALUES (17, '觉得你觉得ee', '11111111111111111111111111111', 121, '131');
INSERT INTO `user` VALUES (18, '哎我', '23', 11, '11');
INSERT INTO `user` VALUES (19, '1111w', 'er', 12, '345678');
INSERT INTO `user` VALUES (20, '1111w', 'er', 12, '345678');
INSERT INTO `user` VALUES (21, '孙悟空·', '66fr', 12, '很棒');
INSERT INTO `user` VALUES (22, '5678', '123456', 13, '5690');

SET FOREIGN_KEY_CHECKS = 1;
