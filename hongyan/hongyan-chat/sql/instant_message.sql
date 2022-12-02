/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : instant_message

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 12/01/2022 12:51:21
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_room
-- ----------------------------
DROP TABLE IF EXISTS `chat_room`;
CREATE TABLE `chat_room`  (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL COMMENT '???',
  `user_id` int(11) NOT NULL COMMENT '????id',
  `user_state` int(11) NOT NULL COMMENT '????????0??? 1??????',
  `user_role` int(11) NOT NULL COMMENT '???????0????? 1???? 2????',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chat_room
-- ----------------------------

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `friend_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (1, 1, 2);
INSERT INTO `friend` VALUES (2, 1, 3);
INSERT INTO `friend` VALUES (3, 1, 4);
INSERT INTO `friend` VALUES (4, 2, 1);
INSERT INTO `friend` VALUES (5, 1, 5);

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(12) NOT NULL COMMENT '??id',
  `request_id` bigint(12) NOT NULL COMMENT '??????id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of request
-- ----------------------------

-- ----------------------------
-- Table structure for shield
-- ----------------------------
DROP TABLE IF EXISTS `shield`;
CREATE TABLE `shield`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `shield_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shield
-- ----------------------------
INSERT INTO `shield` VALUES (1, 1, 3);

-- ----------------------------
-- Table structure for t1_user
-- ----------------------------
DROP TABLE IF EXISTS `t1_user`;
CREATE TABLE `t1_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '???',
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '??',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t1_user
-- ----------------------------
INSERT INTO `t1_user` VALUES (1, 'aa', '1');
INSERT INTO `t1_user` VALUES (2, 'bb', '1');
INSERT INTO `t1_user` VALUES (3, 'cc', '1');
INSERT INTO `t1_user` VALUES (4, 'dd', '1');
INSERT INTO `t1_user` VALUES (5, 'ee', '1');

SET FOREIGN_KEY_CHECKS = 1;
