/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : hongbao

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 10/01/2022 11:48:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for envelope
-- ----------------------------
DROP TABLE IF EXISTS `envelope`;
CREATE TABLE `envelope`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '红包id',
  `amount` int(10) DEFAULT NULL COMMENT '红包总金额\r\n',
  `number` int(10) DEFAULT NULL COMMENT '红包个数',
  `organizer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发红包的人',
  `status` int(10) DEFAULT NULL COMMENT '红包剩余数量\r\n',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '红包描述（比方说祝福语）',
  `deadline` datetime(0) DEFAULT NULL COMMENT '红包过期时间点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of envelope
-- ----------------------------
INSERT INTO `envelope` VALUES (18, 10, 1, '张三', 1, NULL, '2022-01-07 21:45:47');
INSERT INTO `envelope` VALUES (19, 10, 1, '张三', 1, NULL, '2022-01-07 21:48:17');
INSERT INTO `envelope` VALUES (20, 10, 1, '张三', 1, NULL, '2022-01-07 21:48:33');
INSERT INTO `envelope` VALUES (21, 10, 1, '张三', 1, NULL, '2022-01-07 21:52:29');
INSERT INTO `envelope` VALUES (22, 10, 1, '张三', 1, NULL, '2022-01-08 08:17:32');
INSERT INTO `envelope` VALUES (23, 10, 1, '张三', 1, NULL, '2022-01-08 08:19:05');
INSERT INTO `envelope` VALUES (24, 10, 1, '张三', 1, NULL, '2022-01-08 08:21:15');
INSERT INTO `envelope` VALUES (25, 10, 1, '张三', 1, NULL, '2022-01-08 08:24:05');
INSERT INTO `envelope` VALUES (26, 1000, 1, '张三', 1, NULL, '2022-01-08 08:49:08');
INSERT INTO `envelope` VALUES (27, 1000, 1, '张三', 1, NULL, '2022-01-08 08:55:09');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '抢到红包的人',
  `e_id` bigint(20) DEFAULT NULL COMMENT '红包id',
  `money` int(10) DEFAULT NULL COMMENT '抢到的钱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 1, 21, 1);
INSERT INTO `record` VALUES (2, 1, 23, 1);
INSERT INTO `record` VALUES (3, 1, 25, 1);
INSERT INTO `record` VALUES (4, 2, 26, 1000);
INSERT INTO `record` VALUES (5, 2, 27, 1000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` bigint(20) DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '123', 18121);
INSERT INTO `user` VALUES (2, '李四', '123456', 21000);

SET FOREIGN_KEY_CHECKS = 1;
