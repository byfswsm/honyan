/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : test_11_21

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 09/01/2022 18:09:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_record
-- ----------------------------
DROP TABLE IF EXISTS `class_record`;
CREATE TABLE `class_record`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `course_id` bigint(11) DEFAULT NULL COMMENT '课程的课序号',
  `start_time` datetime(0) DEFAULT NULL COMMENT '开始上课的时间',
  `end_time` datetime(0) DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '上课记录表，即每上一次课，就往表中插入一条数据' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for class_record_sign
-- ----------------------------
DROP TABLE IF EXISTS `class_record_sign`;
CREATE TABLE `class_record_sign`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_id` bigint(11) DEFAULT NULL COMMENT '学生的id',
  `class_record_id` bigint(11) DEFAULT NULL COMMENT '上课记录表的id',
  `state` int(1) DEFAULT NULL COMMENT '签到状态',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间 - 签到时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生签到记录表，class_record表增加一条数据，本表加入所有上该门课的学生，并填补签到状态' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class_record_sign
-- ----------------------------
INSERT INTO `class_record_sign` VALUES (1, 1, 1, 0, '2021-12-02 13:42:52', '2021-12-02 13:42:55');
INSERT INTO `class_record_sign` VALUES (2, 2, 2, 1, '2021-12-02 13:43:08', '2021-12-02 13:43:10');
INSERT INTO `class_record_sign` VALUES (3, 3, 2, 2, '2021-12-02 13:43:27', '2021-12-02 13:43:30');
INSERT INTO `class_record_sign` VALUES (4, 4, 3, 1, '2021-12-02 13:43:44', '2021-12-02 13:43:47');

-- ----------------------------
-- Table structure for class_room
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '教室的id',
  `room_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教室的编号(A2101)',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教室表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '班级的ID',
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '年级',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级名称',
  `college_id` bigint(11) DEFAULT NULL COMMENT '所属于学院的id',
  `major_id` bigint(11) DEFAULT NULL COMMENT '专业主键id',
  `teacher_id` bigint(11) DEFAULT NULL COMMENT '当前导员的id',
  `start_date` datetime(0) DEFAULT NULL COMMENT '成立时间，同学生入学时间',
  `number` bigint(11) DEFAULT NULL COMMENT '班级人数',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '班级表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '18级', '二班', 1, 1, 1, '2021-11-24 18:42:55', 30, '2021-11-24 18:43:01', '2021-11-24 19:31:59');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '课程的id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课程的名字',
  `classroom_id` bigint(11) DEFAULT NULL COMMENT '教室的id',
  `course_id` bigint(11) DEFAULT NULL COMMENT '课序号，同主键id,unique',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '母猪的产后护理', 1, 1, NULL, '2021-12-09 17:10:50');
INSERT INTO `course` VALUES (2, '9彩神风', 2, 2, '2021-12-02 12:47:39', '2021-12-02 12:47:41');
INSERT INTO `course` VALUES (3, '线上班', 3, 3, '2021-12-02 12:47:50', '2021-12-02 12:47:54');
INSERT INTO `course` VALUES (7, 'qcby', 2, 7, NULL, '2021-12-09 17:11:00');
INSERT INTO `course` VALUES (8, 'long', 22, 8, NULL, '2021-12-09 17:11:02');
INSERT INTO `course` VALUES (9, 'long', 22, 9, NULL, '2021-12-09 17:11:03');
INSERT INTO `course` VALUES (10, '地址波动学', 10, 10, NULL, '2021-12-09 17:11:32');
INSERT INTO `course` VALUES (11, '原子核裂变原理', 11, 11, NULL, '2021-12-09 17:11:38');

-- ----------------------------
-- Table structure for dic_college
-- ----------------------------
DROP TABLE IF EXISTS `dic_college`;
CREATE TABLE `dic_college`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '学院的id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院的名称',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '院长,对应用户表的id',
  `major_num` bigint(11) DEFAULT NULL COMMENT '学院中专业的个数',
  `student_num` bigint(11) DEFAULT NULL COMMENT '学院中学生的个数',
  `detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学院简介',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学院表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dic_college
-- ----------------------------
INSERT INTO `dic_college` VALUES (1, '计算机学院', '11', 11, 200, '教学计算机的学院', '2021-11-24 18:33:18', '2021-11-24 18:33:21');

-- ----------------------------
-- Table structure for dic_major
-- ----------------------------
DROP TABLE IF EXISTS `dic_major`;
CREATE TABLE `dic_major`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '专业的id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '专业名字',
  `college_id` bigint(11) DEFAULT NULL COMMENT '所属于学院的id',
  `student_num` bigint(11) DEFAULT NULL COMMENT '专业人数',
  `class_num` bigint(11) DEFAULT NULL COMMENT '所拥有的班级个数',
  `start_date` datetime(0) DEFAULT NULL COMMENT '成立时间',
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专业表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dic_major
-- ----------------------------
INSERT INTO `dic_major` VALUES (1, '计算机科学与技术', 1, 60, 1, '2021-11-24 18:34:26', '\r\n计科专业', '2021-11-24 18:34:35', '2021-11-24 18:34:39');

-- ----------------------------
-- Table structure for dic_teacher_degree
-- ----------------------------
DROP TABLE IF EXISTS `dic_teacher_degree`;
CREATE TABLE `dic_teacher_degree`  (
  `id` bigint(11) NOT NULL COMMENT '主键id',
  `degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '学位名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '教师学位' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dic_teacher_degree
-- ----------------------------
INSERT INTO `dic_teacher_degree` VALUES (1, '博士后');
INSERT INTO `dic_teacher_degree` VALUES (2, '在读博士');
INSERT INTO `dic_teacher_degree` VALUES (3, '研究生');
INSERT INTO `dic_teacher_degree` VALUES (4, '本科生');
INSERT INTO `dic_teacher_degree` VALUES (5, '专科生');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据库字段id',
  `dormitory_id` bigint(11) NOT NULL COMMENT '宿舍楼id',
  `room_num` bigint(11) NOT NULL COMMENT '宿舍编号',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '宿舍状态，是否被使用',
  `capacity` bigint(11) DEFAULT NULL COMMENT '宿舍能容纳的人数',
  `numbers` bigint(11) DEFAULT NULL COMMENT '现住人数',
  `detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '详情，人员信息',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改事件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '宿舍表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES (1, 1, 126, '可以被使用', 1000, 500, '126宿舍', '2021-11-24 18:37:10', '2021-11-24 19:04:22');

-- ----------------------------
-- Table structure for dormitory_floor
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_floor`;
CREATE TABLE `dormitory_floor`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍楼id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '宿舍楼名字',
  `teacher_id` bigint(11) DEFAULT NULL COMMENT '负责人 ,老师',
  `start_date` datetime(0) DEFAULT NULL COMMENT '建造时间\r\n',
  `numbers` bigint(11) DEFAULT NULL COMMENT '现宿舍住宿人数',
  `capacity` bigint(11) DEFAULT NULL COMMENT '宿舍楼个数',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改事件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '宿舍楼表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dormitory_floor
-- ----------------------------
INSERT INTO `dormitory_floor` VALUES (1, '第一宿舍楼', 11, '2021-11-24 18:41:08', 500, 1000, '2021-11-24 18:41:32', '2021-11-24 18:41:34');

-- ----------------------------
-- Table structure for duties
-- ----------------------------
DROP TABLE IF EXISTS `duties`;
CREATE TABLE `duties`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '职务的id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '职务名',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改事件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职务表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of duties
-- ----------------------------
INSERT INTO `duties` VALUES (1, '超级管理员', '2021-11-21 21:50:16', '2021-11-21 21:50:18');
INSERT INTO `duties` VALUES (2, '老师', '2021-12-09 12:56:44', '2021-12-09 12:56:45');
INSERT INTO `duties` VALUES (3, '学生', '2021-12-09 12:56:46', '2021-12-09 12:56:47');

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '考试表主键id',
  `classroom_id` bigint(11) DEFAULT NULL COMMENT '考试地点',
  `course_id` bigint(11) DEFAULT NULL COMMENT '课序号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '考试的开始时间',
  `over_time` datetime(0) DEFAULT NULL COMMENT '考试的结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考试表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES (1, NULL, 1, NULL, NULL);

-- ----------------------------
-- Table structure for log_login
-- ----------------------------
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE `log_login`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '登录表的id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户的id',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录者ip',
  `create_time` datetime(0) DEFAULT NULL COMMENT '登录时间 _创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of log_login
-- ----------------------------
INSERT INTO `log_login` VALUES (1, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 00:07:23');
INSERT INTO `log_login` VALUES (2, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 22:47:35');
INSERT INTO `log_login` VALUES (3, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 23:06:08');
INSERT INTO `log_login` VALUES (4, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 23:09:06');
INSERT INTO `log_login` VALUES (5, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 23:10:39');
INSERT INTO `log_login` VALUES (6, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 23:12:37');
INSERT INTO `log_login` VALUES (7, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-01 23:19:40');
INSERT INTO `log_login` VALUES (8, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-02 14:47:02');
INSERT INTO `log_login` VALUES (9, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-02 14:54:19');
INSERT INTO `log_login` VALUES (10, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-02 15:25:24');
INSERT INTO `log_login` VALUES (11, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-02 15:38:38');
INSERT INTO `log_login` VALUES (12, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-04 21:45:52');
INSERT INTO `log_login` VALUES (13, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-07 13:04:27');
INSERT INTO `log_login` VALUES (14, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 16:11:09');
INSERT INTO `log_login` VALUES (15, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 16:17:50');
INSERT INTO `log_login` VALUES (16, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 16:18:07');
INSERT INTO `log_login` VALUES (17, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 16:50:35');
INSERT INTO `log_login` VALUES (18, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 17:22:25');
INSERT INTO `log_login` VALUES (19, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 18:24:27');
INSERT INTO `log_login` VALUES (20, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 18:24:31');
INSERT INTO `log_login` VALUES (21, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 18:24:40');
INSERT INTO `log_login` VALUES (22, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 18:24:58');
INSERT INTO `log_login` VALUES (23, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 20:15:26');
INSERT INTO `log_login` VALUES (24, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 22:57:49');
INSERT INTO `log_login` VALUES (25, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:03:27');
INSERT INTO `log_login` VALUES (26, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:03:58');
INSERT INTO `log_login` VALUES (27, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:04:47');
INSERT INTO `log_login` VALUES (28, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:06:20');
INSERT INTO `log_login` VALUES (29, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:08:50');
INSERT INTO `log_login` VALUES (30, 'gg321', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:13:07');
INSERT INTO `log_login` VALUES (31, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-09 23:13:36');
INSERT INTO `log_login` VALUES (32, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-10 11:01:01');
INSERT INTO `log_login` VALUES (33, 'gg123', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-10 11:10:29');
INSERT INTO `log_login` VALUES (34, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-10 11:21:23');
INSERT INTO `log_login` VALUES (35, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-10 20:45:10');
INSERT INTO `log_login` VALUES (36, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-13 10:17:58');
INSERT INTO `log_login` VALUES (37, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-13 20:29:50');
INSERT INTO `log_login` VALUES (38, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-13 20:48:30');
INSERT INTO `log_login` VALUES (39, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-14 03:17:57');
INSERT INTO `log_login` VALUES (40, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-15 14:37:11');
INSERT INTO `log_login` VALUES (41, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-15 15:08:23');
INSERT INTO `log_login` VALUES (42, 'admin', 'WIN-LFQQNEUN9TP/192.168.149.1', '2021-12-15 15:38:45');

-- ----------------------------
-- Table structure for log_operation
-- ----------------------------
DROP TABLE IF EXISTS `log_operation`;
CREATE TABLE `log_operation`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '操作id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '访问方法名',
  `input_parameter` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '入参',
  `output_parameter` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '出参',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of log_operation
-- ----------------------------
INSERT INTO `log_operation` VALUES (1, 2, 'detailStudent', '[null]', 'null', '2021-11-24 23:16:02');
INSERT INTO `log_operation` VALUES (2, 2, 'detailStudent', '[1]', 'Student(id=1, userId=2, name=王毅, username=gg123, sex=0, sexName=男, startDate=Sat Sep 01 18:31:21 CST 2018, overDate=Thu Jun 30 18:31:35 CST 2022, birthday=0526, nation=汉族, collegeId=1, collegeName=计算机学院, majorId=1, majorName=计算机科学与技术, classId=1, className=二班, teacherId=1, teacherName=张老师, dormId=1, dormDetail=126宿舍, dormfloorId=1, dormName=第一宿舍楼, photo=null, idCard=132930111111111, phone=15369819325, religion=无, state=1, createTime=Wed Nov 24 18:43:33 CST 2021, updateTime=Wed Nov 24 19:20:35 CST 2021, menuUrlPathList=null, token=null)', '2021-11-24 23:16:19');
INSERT INTO `log_operation` VALUES (3, 2, 'deleteEmail', '[1234561]', 'ResultJson(code=500, msg=操作失败, data=null)', '2021-12-01 22:49:53');
INSERT INTO `log_operation` VALUES (4, 2, 'deleteEmail', '[123456]', 'ResultJson(code=500, msg=操作失败, data=null)', '2021-12-01 23:24:13');
INSERT INTO `log_operation` VALUES (5, 2, 'deletePhone', '[123456]', 'ResultJson(code=500, msg=操作失败, data=null)', '2021-12-01 23:26:35');
INSERT INTO `log_operation` VALUES (6, 1, 'insertManagerNotice', '[Notice(id=1, title=管理员标题测试1, fromId=1, toId=1, createTime=2021-12-02T14:48:32.795, updateTime=null, content=管理员内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:48:33');
INSERT INTO `log_operation` VALUES (7, 1, 'insertManagerNotice', '[Notice(id=3, title=管理员标题测试1, fromId=1, toId=1, createTime=2021-12-02T14:49:18.916, updateTime=null, content=管理员内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:49:19');
INSERT INTO `log_operation` VALUES (8, 1, 'insertManagerNotice', '[Notice(id=5, title=管理员标题测试1, fromId=1, toId=1, createTime=2021-12-02T14:50:04.213, updateTime=null, content=管理员内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:50:05');
INSERT INTO `log_operation` VALUES (9, 1, 'insertManagerNotice', '[Notice(id=7, title=管理员标题测试1, fromId=1, toId=1, createTime=2021-12-02T14:51:40.356, updateTime=null, content=管理员内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:51:41');
INSERT INTO `log_operation` VALUES (10, 1, 'insertTeacherNotice', '[Notice(id=8, title=老师标题测试1, fromId=1, toId=1, createTime=2021-12-02T14:53:52.633, updateTime=null, content=老师内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:53:53');
INSERT INTO `log_operation` VALUES (11, 3, 'insertTeacherNotice', '[Notice(id=9, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:54:32.122, updateTime=null, content=老师内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:54:32');
INSERT INTO `log_operation` VALUES (12, 3, 'insertTeacherNotice', '[Notice(id=10, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:55:02.132, updateTime=null, content=老师内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:55:02');
INSERT INTO `log_operation` VALUES (13, 3, 'insertTeacherNotice', '[Notice(id=11, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:55:56.477, updateTime=null, content=老师内容测试1, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:55:57');
INSERT INTO `log_operation` VALUES (14, 3, 'insertTeacherNotice', '[Notice(id=12, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:56:01.229, updateTime=null, content=老师内容测试1, state=0, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:56:01');
INSERT INTO `log_operation` VALUES (15, 3, 'insertTeacherNotice', '[Notice(id=13, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:56:02.055, updateTime=null, content=老师内容测试1, state=0, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:56:02');
INSERT INTO `log_operation` VALUES (16, 3, 'insertTeacherNotice', '[Notice(id=14, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:56:02.590, updateTime=null, content=老师内容测试1, state=0, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:56:03');
INSERT INTO `log_operation` VALUES (17, 3, 'insertTeacherNotice', '[Notice(id=15, title=老师标题测试1, fromId=3, toId=1, createTime=2021-12-02T14:56:02.949, updateTime=null, content=老师内容测试1, state=0, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-02 14:56:03');
INSERT INTO `log_operation` VALUES (18, 3, 'getOtherStudentNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@3bfac209)', '2021-12-02 15:15:29');
INSERT INTO `log_operation` VALUES (19, 3, 'getTeacherNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@1cd037d8)', '2021-12-02 15:17:01');
INSERT INTO `log_operation` VALUES (20, 3, 'getTeacherNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@ca6a0fc)', '2021-12-02 15:23:42');
INSERT INTO `log_operation` VALUES (21, 3, 'getTeacherDraftBox', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@7f465fc)', '2021-12-02 15:25:34');
INSERT INTO `log_operation` VALUES (22, 3, 'getTeacherDraftBox', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@319c49a8)', '2021-12-02 15:27:35');
INSERT INTO `log_operation` VALUES (23, 2, 'getTeacherDraftBox', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@8f46b2f)', '2021-12-02 15:38:55');
INSERT INTO `log_operation` VALUES (24, 2, 'getTeacherNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@6242470)', '2021-12-02 15:39:26');
INSERT INTO `log_operation` VALUES (25, 2, 'getStudentNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@1e284a5)', '2021-12-02 15:39:35');
INSERT INTO `log_operation` VALUES (26, 2, 'getStudentNotice', '[1, 20, Notice(id=null, title=null, fromId=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@229c7720)', '2021-12-02 15:39:55');
INSERT INTO `log_operation` VALUES (27, 2, 'insertPhone', '[1727575707@qq.com, 123456]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-07 13:05:41');
INSERT INTO `log_operation` VALUES (28, 2, 'insertPhone', '[1229505432@qq.com, 123456]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-07 13:06:41');
INSERT INTO `log_operation` VALUES (29, 3, 'teacherGetCourse', 'null', 'ResultJson(code=500, msg=操作失败, data=null)', '2021-12-09 17:22:50');
INSERT INTO `log_operation` VALUES (30, 3, 'teacherGetCourse', 'null', 'ResultJson(code=500, msg=操作失败, data=null)', '2021-12-09 17:24:00');
INSERT INTO `log_operation` VALUES (31, 3, 'teacherGetCourse', 'null', 'ResultJson(code=200, msg=操作成功, data=[Course(id=1, name=母猪的产后护理, classroomId=1, courseId=1, createTime=null, updateTime=2021-12-09 17:10:50), Course(id=2, name=9彩神风, classroomId=2, courseId=2, createTime=Thu Dec 02 12:47:39 CST 2021, updateTime=2021-12-02 12:47:41), Course(id=11, name=原子核裂变原理, classroomId=11, courseId=11, createTime=null, updateTime=2021-12-09 17:11:38)])', '2021-12-09 17:25:20');
INSERT INTO `log_operation` VALUES (32, 1, 'insertManagerNotice', '[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, createTime=2021-12-10T11:22:40.217, updateTime=null, content=呵呵, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-10 11:22:41');
INSERT INTO `log_operation` VALUES (33, 1, 'insertManagerNotice', '[Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, createTime=2021-12-10T20:45:45.729, updateTime=null, content=呵呵, state=1, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-10 20:45:46');
INSERT INTO `log_operation` VALUES (34, 1, 'getDraftBox', '[1, 20, Notice(id=null, title=哈哈, fromId=null, name=null, toId=1, createTime=2021, updateTime=null, content=呵呵, state=null, fromName=null)]', 'ResultJson(code=200, msg=操作成功, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@3aa7602b)', '2021-12-10 20:57:05');
INSERT INTO `log_operation` VALUES (35, 1, 'byAdminInsert', '[RefStudentExamination(studentId=1, examinationId=2, achievement=1.0, createTime=2021-12-13T10:19:41.159, updateTime=null)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-13 10:19:41');
INSERT INTO `log_operation` VALUES (36, 1, 'byAdminInsert', '[RefStudentExamination(studentId=1, examinationId=3, achievement=81.0, createTime=2021-12-13T20:52:11.507, updateTime=2021-12-13T20:52:11.507)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-13 20:52:12');
INSERT INTO `log_operation` VALUES (37, 1, 'byAdminInsert', '[RefStudentExamination(studentId=1, examinationId=4, achievement=81.0, createTime=2021-12-14T03:18:38.116, updateTime=2021-12-14T03:18:38.116)]', 'ResultJson(code=200, msg=操作成功, data=null)', '2021-12-14 03:18:38');
INSERT INTO `log_operation` VALUES (38, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=ha, fromId=null, name=null, toId=null, createTime=null, updateTime=null, content=null, state=null, fromName=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=0, params=null, records=[]))', '2021-12-15 14:51:20');
INSERT INTO `log_operation` VALUES (39, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 14:55:44');
INSERT INTO `log_operation` VALUES (40, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 14:58:28');
INSERT INTO `log_operation` VALUES (41, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 14:58:55');
INSERT INTO `log_operation` VALUES (42, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 14:59:48');
INSERT INTO `log_operation` VALUES (43, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 15:00:00');
INSERT INTO `log_operation` VALUES (44, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 15:00:13');
INSERT INTO `log_operation` VALUES (45, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=120, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=120, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 15:00:19');
INSERT INTO `log_operation` VALUES (46, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:05:59');
INSERT INTO `log_operation` VALUES (47, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:06:56');
INSERT INTO `log_operation` VALUES (48, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:09:34');
INSERT INTO `log_operation` VALUES (49, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:10:20');
INSERT INTO `log_operation` VALUES (50, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:10:46');
INSERT INTO `log_operation` VALUES (51, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:11:35');
INSERT INTO `log_operation` VALUES (52, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:12:18');
INSERT INTO `log_operation` VALUES (53, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:12:56');
INSERT INTO `log_operation` VALUES (54, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:13:23');
INSERT INTO `log_operation` VALUES (55, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 15:16:21');
INSERT INTO `log_operation` VALUES (56, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:19:28');
INSERT INTO `log_operation` VALUES (57, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:20:54');
INSERT INTO `log_operation` VALUES (58, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:22:10');
INSERT INTO `log_operation` VALUES (59, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:32:32');
INSERT INTO `log_operation` VALUES (60, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:33:47');
INSERT INTO `log_operation` VALUES (61, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:35:49');
INSERT INTO `log_operation` VALUES (62, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:35:58');
INSERT INTO `log_operation` VALUES (63, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:36:17');
INSERT INTO `log_operation` VALUES (64, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:36:34');
INSERT INTO `log_operation` VALUES (65, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:36:53');
INSERT INTO `log_operation` VALUES (66, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:37:04');
INSERT INTO `log_operation` VALUES (67, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:37:12');
INSERT INTO `log_operation` VALUES (68, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:37:18');
INSERT INTO `log_operation` VALUES (69, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:38:35');
INSERT INTO `log_operation` VALUES (70, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:43:16');
INSERT INTO `log_operation` VALUES (71, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:54:09');
INSERT INTO `log_operation` VALUES (72, 1, 'getManagerNotice', '[PageWeb(pageNum=0, pageSize=0, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=0, totalSize=2, params=null, records=[]))', '2021-12-15 15:58:38');
INSERT INTO `log_operation` VALUES (73, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 16:01:31');
INSERT INTO `log_operation` VALUES (74, 1, 'getManagerNotice', '[PageWeb(pageNum=1, pageSize=20, totalSize=0, params=Notice(id=null, title=哈, fromId=null, name=null, toId=null, content=null, state=null, fromName=null, createTime=null, updateTime=null), records=null)]', 'ResultJson(code=200, msg=操作成功, data=PageWeb(pageNum=1, pageSize=20, totalSize=2, params=null, records=[Notice(id=16, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T11:22:40, updateTime=null), Notice(id=17, title=哈哈, fromId=1, name=null, toId=1, content=呵呵, state=1, fromName=null, createTime=2021-12-10T20:45:46, updateTime=null)]))', '2021-12-15 16:08:42');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单的url路径',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '菜单的层级，按钮是0，列表就是1',
  `jurisdiction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限字符串',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理模块', '/systemMannager', 0, 'systemMannager', NULL, '2021-12-09 13:08:57');
INSERT INTO `menu` VALUES (2, '用户管理:管理端', '/systemMannager/managerUser', 1, 'managerUser', NULL, '2021-12-09 16:24:50');
INSERT INTO `menu` VALUES (3, '删除用户', '/systemMannager/managerUser/deleteUser', 2, 'managerUser:deleteUser', NULL, '2021-12-09 16:26:03');
INSERT INTO `menu` VALUES (4, '增加用户', '/systemMannager/managerUser/addUser', 2, 'managerUser:addUser', NULL, '2021-12-09 16:26:07');
INSERT INTO `menu` VALUES (5, '更改用户', '/systemMannager/managerUser/userUpdate', 2, 'managerUser:userUpdate', NULL, '2021-12-09 16:26:10');
INSERT INTO `menu` VALUES (6, '查询用户', '/systemMannager/managerUser/searchUser', 2, 'managerUser:searchUser', NULL, '2021-12-09 16:26:16');
INSERT INTO `menu` VALUES (7, '用户添加角色', '/systemMannager/managerUser/userAddRole', 2, 'managerUser:userAddRole', NULL, '2021-12-09 16:26:24');
INSERT INTO `menu` VALUES (8, '角色管理:管理端', '/systemMannager/managerRole', 1, 'managerRole', NULL, '2021-12-09 16:25:02');
INSERT INTO `menu` VALUES (9, '增加角色', '/systemMannager/managerRole/addRole', 8, 'managerRole:addRole', NULL, '2021-12-09 16:25:04');
INSERT INTO `menu` VALUES (10, '删除角色', '/systemMannager/managerRole/deleteRole', 8, 'managerRole:deleteRole', NULL, '2021-12-09 16:25:07');
INSERT INTO `menu` VALUES (11, '修改角色', '/systemMannager/managerRole/updateRole', 8, 'managerRole:updateRole', NULL, '2021-12-09 16:25:09');
INSERT INTO `menu` VALUES (12, '查询角色', '/systemMannager/managerRole/getRole', 8, 'managerRole:getRole', NULL, '2021-12-09 16:25:16');
INSERT INTO `menu` VALUES (13, '角色添加权限', '/systemMannager/managerRole/roleAddMenu', 8, 'managerRole:roleAddMenu', NULL, '2021-12-09 16:25:18');
INSERT INTO `menu` VALUES (14, '权限管理:管理端', '/systemMannager/managerMenu', 1, 'managerMenu', NULL, '2021-12-09 16:25:19');
INSERT INTO `menu` VALUES (15, '新增权限', '/systemMannager/managerMenu/addMenu', 14, 'managerMenu:addMenu', NULL, '2021-12-09 16:25:21');
INSERT INTO `menu` VALUES (16, '修改权限', '/systemMannager/managerMenu/updateMenu', 14, 'managerMenu:updateMenu', NULL, '2021-12-09 16:25:23');
INSERT INTO `menu` VALUES (17, '删除权限', '/systemMannager/managerMenu/deleteMenu', 14, 'managerMenu:deleteMenu', NULL, '2021-12-09 16:25:25');
INSERT INTO `menu` VALUES (18, '查询权限', '/systemMannager/managerMenu/getMenu', 14, 'managerMenu:getMenu', NULL, '2021-12-09 16:25:28');
INSERT INTO `menu` VALUES (19, '通知公告模块', '/notice', 0, 'notice', NULL, '2021-12-09 14:33:19');
INSERT INTO `menu` VALUES (20, '通知公告:管理端', '/notice/manager', 19, 'notice:manager', NULL, '2021-12-09 14:33:20');
INSERT INTO `menu` VALUES (21, '发布通知公告', '/notice/manager/insertManagerNotice', 20, 'notice:insertManagerNotice', NULL, '2021-12-09 14:32:07');
INSERT INTO `menu` VALUES (22, '删除通知公告', '/notice/manager/deleteManagerNotice', 20, 'notice:deleteManagerNotice', NULL, '2021-12-09 14:32:04');
INSERT INTO `menu` VALUES (23, '查看通知公告', '/notice/manager/getManagerNotice', 20, 'notice:getManagerNotice', NULL, '2021-12-09 14:32:10');
INSERT INTO `menu` VALUES (24, '查看草稿箱', '/notice/manager/getDraftBox', 20, 'notice:getDraftBox', NULL, '2021-12-09 14:32:14');
INSERT INTO `menu` VALUES (25, '发布草稿箱公告', '/notice/manager/insertDraftBox', 20, 'notice:insertDraftBox', NULL, '2021-12-09 14:32:17');
INSERT INTO `menu` VALUES (26, '通知公告:教师端', '/notice/teacher', 19, 'notice:teacher', NULL, '2021-12-09 13:33:46');
INSERT INTO `menu` VALUES (27, '发布通知公告', '/notice/teacher/insertTeacherNotice', 26, 'notice:insertTeacherNotice', NULL, '2021-12-09 14:32:22');
INSERT INTO `menu` VALUES (28, '删除通知公告', '/notice/teacher/deleteTeacherNotice', 26, 'notice:deleteTeacherNotice', NULL, '2021-12-09 14:32:27');
INSERT INTO `menu` VALUES (29, '查看自己通知别人公告', '/notice/teacher/getOtherStudentNotice', 26, 'notice:getOtherStudentNotice', NULL, '2021-12-09 14:32:31');
INSERT INTO `menu` VALUES (30, '查看自己被通知公告', '/notice/getTeacherNotice', 26, 'notice:getTeacherNotice', NULL, NULL);
INSERT INTO `menu` VALUES (31, '查看自己被通知公告', '/notice/teacher/getTeacherNotice', 26, 'notice:getTeacherNotice', NULL, '2021-12-09 14:32:34');
INSERT INTO `menu` VALUES (32, '查看草稿箱', '/notice/teacher/getTeacherDraftBox', 26, 'notice:getTeacherDraftBox', NULL, '2021-12-09 14:32:39');
INSERT INTO `menu` VALUES (33, '发布草稿箱公告', '/notice/teacher/insertTeacherDraftBox', 26, 'notice:insertTeacherDraftBox', NULL, '2021-12-09 14:32:42');
INSERT INTO `menu` VALUES (34, '通知公告:学生端', '/notice/student', 19, 'notice:student', NULL, '2021-12-09 13:36:31');
INSERT INTO `menu` VALUES (35, '查看通知公告', '/notice/student/getStudentNotice', 34, 'notice:getStudentNotice', NULL, '2021-12-09 14:32:48');
INSERT INTO `menu` VALUES (36, '信息管理模块', '/information', 0, 'information', NULL, '2021-12-09 14:28:55');
INSERT INTO `menu` VALUES (37, '学生列表:管理端', '/information/managerStudent', 36, 'information:managerStudent', NULL, '2021-12-09 14:37:31');
INSERT INTO `menu` VALUES (38, '删除学生', '/information/managerStudent/deleteStudent', 37, 'information:deleteStudent', NULL, '2021-12-09 14:36:57');
INSERT INTO `menu` VALUES (39, '增加学生', '/information/managerStudent/addStudent', 37, 'information:addStudent', NULL, '2021-12-09 14:37:01');
INSERT INTO `menu` VALUES (40, '学生列表', '/information/managerStudent/getStudentList', 37, 'information:getStudentList', NULL, '2021-12-09 14:37:04');
INSERT INTO `menu` VALUES (41, '更改学生信息', '/information/managerStudent/updateStudent', 37, 'information:updateStudent', NULL, '2021-12-09 14:37:09');
INSERT INTO `menu` VALUES (42, '学生详情', '/information/managerStudent/detailStudent', 37, ':information:detailStudent', NULL, '2021-12-09 14:37:13');
INSERT INTO `menu` VALUES (43, '班级列表:管理端', '/information/managerClass', 36, 'information:managerClass', NULL, '2021-12-09 14:37:42');
INSERT INTO `menu` VALUES (44, '增加班级', '/information/managerClass/addClassos', 43, 'information:addClassos', NULL, '2021-12-09 14:39:45');
INSERT INTO `menu` VALUES (45, '班级列表', '/information/managerClass/searchClassosList', 43, 'information:searchClassosList', NULL, '2021-12-09 14:39:48');
INSERT INTO `menu` VALUES (46, '删除班级', '/information/managerClass/deleteClassos', 43, 'information:deleteClassos', NULL, '2021-12-09 14:39:50');
INSERT INTO `menu` VALUES (47, '修改班级信息', '/information/managerClass/updateClassos', 43, 'information:updateClassos', NULL, '2021-12-09 14:39:53');
INSERT INTO `menu` VALUES (48, '教师列表:管理端', '/information/managerTeacher', 36, 'information:managerTeacher', NULL, '2021-12-09 14:40:48');
INSERT INTO `menu` VALUES (49, '增加教师', '/information/managerTeacher/addTeacher', 48, 'information:addTeacher', NULL, '2021-12-09 14:42:48');
INSERT INTO `menu` VALUES (50, '删除教师', '/information/managerTeacher/deleteTeacher', 48, 'information:deleteTeacher', NULL, '2021-12-09 14:42:49');
INSERT INTO `menu` VALUES (51, '修改教师信息', '/information/managerTeacher/updateTeacher', 48, 'information:updateTeacher', NULL, '2021-12-09 14:42:52');
INSERT INTO `menu` VALUES (52, '查询教师信息', '/information/managerTeacher/selectTeacher', 48, 'information:selectTeacher', NULL, '2021-12-09 14:42:54');
INSERT INTO `menu` VALUES (53, '老师详情', '/information/managerTeacher/detailTeacher', 48, 'information:detailTeacher', NULL, '2021-12-09 14:42:56');
INSERT INTO `menu` VALUES (54, '学院管理:管理端', '/information/managerCollege', 36, 'information:managerCollege', NULL, '2021-12-09 14:44:26');
INSERT INTO `menu` VALUES (55, '增加学院', '/information/managerCollege/addCollege', 54, 'information:addCollege', NULL, '2021-12-09 14:48:46');
INSERT INTO `menu` VALUES (56, '删除学院', '/information/managerCollege/deleteCollege', 54, 'information:deleteCollege', NULL, '2021-12-09 14:48:48');
INSERT INTO `menu` VALUES (57, '修改学院信息', '/information/managerCollege/updateCollege', 54, 'information:updateCollege', NULL, '2021-12-09 14:48:50');
INSERT INTO `menu` VALUES (58, '查询学院', '/information/managerCollege/searchCollege', 54, 'information:searchCollege', NULL, '2021-12-09 14:48:52');
INSERT INTO `menu` VALUES (59, '学院详情', '/information/managerCollege/detailCollege', 54, 'information:detailCollege', NULL, '2021-12-09 14:48:57');
INSERT INTO `menu` VALUES (60, '专业管理:管理端', '/information/managerMajor', 36, 'information:managerMajor', NULL, '2021-12-09 14:46:45');
INSERT INTO `menu` VALUES (61, '增加专业', '/information/managerMajor/addMajor', 60, 'information:addMajor', NULL, '2021-12-09 14:48:33');
INSERT INTO `menu` VALUES (62, '删除专业', '/information/managerMajor/deleteMajor', 60, 'information:deleteMajor', NULL, '2021-12-09 14:48:35');
INSERT INTO `menu` VALUES (63, '修改专业信息', '/information/managerMajor/updateMajor', 60, 'information:updateMajor', NULL, '2021-12-09 14:48:37');
INSERT INTO `menu` VALUES (64, '查询专业信息', '/information/managerMajor/searchMajor', 60, 'information:searchMajor', NULL, '2021-12-09 14:48:38');
INSERT INTO `menu` VALUES (65, '专业详情', '/information/detailMajor', 60, 'information:detailMajor', NULL, NULL);
INSERT INTO `menu` VALUES (66, '专业详情', '/information/managerMajor/detailMajor', 60, 'information:detailMajor', NULL, '2021-12-09 14:48:42');
INSERT INTO `menu` VALUES (67, '课程列表:老师端', '/information/teacherClass', 36, 'information:teacherClass', NULL, '2021-12-09 14:49:59');
INSERT INTO `menu` VALUES (68, '查询课程', '/information/teacherClass/teacherGetCourse', 67, 'information:teacherGetCourse', NULL, '2021-12-09 14:51:56');
INSERT INTO `menu` VALUES (69, '学生列表:老师端', '/information/teacherStudent', 36, 'information:teacherStudent', NULL, '2021-12-09 14:51:57');
INSERT INTO `menu` VALUES (70, '成绩分析', '/information/teacherStudent/performanceAnalysis', 69, 'information:performanceAnalysis', NULL, '2021-12-09 14:51:46');
INSERT INTO `menu` VALUES (71, '查询学生', '/information/teacherStudent/teacherSearchStudent', 69, 'information:teacherSearchStudent', NULL, '2021-12-09 14:51:48');
INSERT INTO `menu` VALUES (72, '成绩管理模块', '/achievement', 0, 'achievement', NULL, NULL);
INSERT INTO `menu` VALUES (73, '成绩管理:管理端', '/achievement/manager', 73, 'achievement:manager', NULL, '2021-12-09 14:56:33');
INSERT INTO `menu` VALUES (74, '录入成绩', '/achievement/manager/byAdminInsert', 74, 'achievement:byAdminInsert', NULL, '2021-12-09 15:22:46');
INSERT INTO `menu` VALUES (75, '删除成绩', '/achievement/manager/byAdminDelete', 74, 'achievement:byAdminDelete', NULL, '2021-12-09 14:58:41');
INSERT INTO `menu` VALUES (76, '\r\n修改成绩', '/achievement/manager/byAdminUpdate', 74, 'achievement:byAdminUpdate', NULL, '2021-12-09 14:58:43');
INSERT INTO `menu` VALUES (77, '查看成绩', '/achievement/manager/byAdminSelectAll', 74, 'achievement:byAdminSelectAll', NULL, '2021-12-09 14:58:45');
INSERT INTO `menu` VALUES (78, '成绩管理:老师端', '/achievement/teacher', 73, 'achievement:teacher', NULL, '2021-12-09 14:59:52');
INSERT INTO `menu` VALUES (79, '录入成绩', '/achievement/teacher/byTeacherInsert', 79, 'achievement:byTeacherInsert', NULL, '2021-12-09 15:01:31');
INSERT INTO `menu` VALUES (80, '删除成绩', '/achievement/teacher/byTeacherDelete', 79, 'achievement:byTeacherDelete', NULL, '2021-12-09 15:01:34');
INSERT INTO `menu` VALUES (81, '修改成绩', '/achievement/teacher/byTeacherUpdate', 79, 'achievement:byTeacherUpdate', NULL, '2021-12-09 15:01:37');
INSERT INTO `menu` VALUES (82, '查看成绩', '/achievement/teacher/byTeacherSelect', 79, 'achievement:byTeacherSelect', NULL, '2021-12-09 15:01:39');
INSERT INTO `menu` VALUES (83, '成绩管理:学生端', '/achievement/student', 73, 'achievement:student', NULL, '2021-12-09 15:02:10');
INSERT INTO `menu` VALUES (84, '查看成绩', '/achievement/student/byStudentSelect', 84, 'achievement:byStudentSelect', NULL, '2021-12-09 15:02:40');
INSERT INTO `menu` VALUES (85, '上课管理模块', '/course', 0, 'course', NULL, '2021-12-09 15:07:53');
INSERT INTO `menu` VALUES (86, '上课管理:管理端', '/course/manager', 85, 'course:manager', NULL, '2021-12-09 15:08:30');
INSERT INTO `menu` VALUES (87, '增加老师课程列表', '/course/manager/insertTeacherCourse', 86, 'course:insertTeacherCourse', NULL, '2021-12-09 15:10:19');
INSERT INTO `menu` VALUES (88, '查看课程列表', '/course/manager/getCourseList', 86, 'course:getCourseList', NULL, '2021-12-09 15:10:57');
INSERT INTO `menu` VALUES (89, '增加学生课程列表', '/course/manager/inserttoStudentCourse', 86, 'course:inserttoStudentCourse', NULL, '2021-12-09 15:10:59');
INSERT INTO `menu` VALUES (90, '删除学生的课程列表', '/course/manager/deletetoStudentCourse', 86, 'course:deletetoStudentCourse', NULL, '2021-12-09 15:11:00');
INSERT INTO `menu` VALUES (91, '删除老师的课程列表', '/course/manager/deleteTeacherCourse', 86, 'course:deleteTeacherCourse', NULL, '2021-12-09 15:11:02');
INSERT INTO `menu` VALUES (92, '更改课程列表', '/course/manager/updateCourse', 86, 'course:updateCourse', NULL, '2021-12-09 15:11:01');
INSERT INTO `menu` VALUES (93, '增加课程列表', '/course/manager/insertCourse', 86, 'course:insertCourse', NULL, '2021-12-09 15:11:03');
INSERT INTO `menu` VALUES (94, '删除课程列表', '/course/manager/deleteCourse', 86, 'course:deleteCourse', NULL, '2021-12-09 15:11:05');
INSERT INTO `menu` VALUES (95, '上课管理:老师端', '/course/teacher', 85, 'course:teacher', NULL, '2021-12-09 15:13:05');
INSERT INTO `menu` VALUES (96, '查看老师个人课程列表', '/course/teacher/getOwnerTeacherList', 95, 'course:getOwnerTeacherList', NULL, '2021-12-09 15:13:36');
INSERT INTO `menu` VALUES (97, '删除个人所教授课程', '/course/teacher/deleteOwnerTeach', 95, 'course:deleteOwnerTeach', NULL, '2021-12-09 15:13:39');
INSERT INTO `menu` VALUES (98, '增加个人所教授课程', '/course/teacher/insertOwnerTeach', 95, 'course:insertOwnerTeach', NULL, '2021-12-09 15:13:39');
INSERT INTO `menu` VALUES (99, '查看自己所教授课程中某个课程的考勤', '/course/teacher/getCourseAttendance', 95, 'course:getCourseAttendance', NULL, '2021-12-09 15:13:40');
INSERT INTO `menu` VALUES (100, '查看个人的上课记录表', '/course/teacher/getClassRecordList', 95, 'course:getClassRecordList', NULL, '2021-12-09 15:13:47');
INSERT INTO `menu` VALUES (101, '上课管理:学生端', '/course/student', 85, 'course:student', NULL, '2021-12-09 15:15:39');
INSERT INTO `menu` VALUES (102, '查看学生课程', '/course/student/getStudentCourseList', 101, 'course:getStudentCourseList', NULL, '2021-12-09 15:16:13');
INSERT INTO `menu` VALUES (103, '学生选课', '/course/student/insertStudentCourse', 101, 'course:insertStudentCourse', NULL, '2021-12-09 15:16:14');
INSERT INTO `menu` VALUES (104, '学生退选', '/course/student/deleteStudentCourse', 101, 'course:deleteStudentCourse', NULL, '2021-12-09 15:16:16');
INSERT INTO `menu` VALUES (105, '查看某节课的考勤', '/course/student/getCourseLeave', 101, 'course:getCourseLeave', NULL, '2021-12-09 15:16:19');
INSERT INTO `menu` VALUES (106, '请假管理模块', '/leave', 0, 'leave', NULL, '2021-12-09 15:24:07');
INSERT INTO `menu` VALUES (107, '请假管理:管理端', '/leave/manager', 106, 'leave:manager', NULL, '2021-12-09 15:24:04');
INSERT INTO `menu` VALUES (108, '批假', '/leave/manager/byAdminApproveLeave', 107, 'leave:byAdminApproveLeave', NULL, '2021-12-09 15:23:09');
INSERT INTO `menu` VALUES (109, '请假', '/leave/manager/byAdminClearLeave', 107, 'leave:byAdminClearLeave', NULL, '2021-12-09 15:23:56');
INSERT INTO `menu` VALUES (110, '请假列表', '/leave/manager/byAdminSelectAll', 107, 'leave:byAdminSelectAll', NULL, '2021-12-09 15:23:52');
INSERT INTO `menu` VALUES (111, '查询请假', '/leave/manager/byAdminSelect', 107, 'leave:byAdminSelect', NULL, '2021-12-09 15:23:50');
INSERT INTO `menu` VALUES (112, '请假管理:老师端', '/leave/teacher', 106, 'leave:teacher', NULL, '2021-12-09 15:23:49');
INSERT INTO `menu` VALUES (113, '批假', '/leave/teacher/byTeacherUpdateState1', 112, 'leave:byTeacherUpdateState1', NULL, '2021-12-09 15:23:47');
INSERT INTO `menu` VALUES (114, '销假', '/leave/teacher/byTeacherUpdateState2', 112, 'leave:byTeacherUpdateState2', NULL, '2021-12-09 15:23:46');
INSERT INTO `menu` VALUES (115, '查询请假', '/leave/teacher/byTeacherSelect', 112, 'leave:byTeacherSelect', NULL, '2021-12-09 15:23:44');
INSERT INTO `menu` VALUES (116, '请假管理:学生端', '/leave/student', 106, 'leave:student', NULL, '2021-12-09 15:23:41');
INSERT INTO `menu` VALUES (117, '申请请假', '/leave/student/byStudentInsert', 116, 'leave:byStudentInsert', NULL, '2021-12-09 15:23:40');
INSERT INTO `menu` VALUES (118, '查看请假', '/leave/student/byStudentSelect', 116, 'leave:byStudentSelect', NULL, '2021-12-09 15:23:39');
INSERT INTO `menu` VALUES (119, '住宿管理模块', '/dormitory', 0, 'dormitory', NULL, '2021-12-09 15:26:29');
INSERT INTO `menu` VALUES (120, '宿舍管理:管理端', '/dormitory/manager', 119, 'dormitory:manager', NULL, '2021-12-09 15:29:44');
INSERT INTO `menu` VALUES (121, '查询宿舍信息', '/dormitory/manager/getDormitory', 120, 'dormitory:getDormitory', NULL, '2021-12-09 15:30:24');
INSERT INTO `menu` VALUES (122, '更新宿舍信息', '/dormitory/manager/updateDormitory', 120, 'dormitory:updateDormitory', NULL, '2021-12-09 15:30:22');
INSERT INTO `menu` VALUES (123, '添加宿舍', '/dormitory/manager/insertdormitory', 120, 'dormitory:insertdormitory', NULL, '2021-12-09 15:30:20');
INSERT INTO `menu` VALUES (124, '删除宿舍', '/dormitory/manager/deteledormitory', 120, 'dormitory:deteledormitory', NULL, '2021-12-09 15:30:18');
INSERT INTO `menu` VALUES (125, '楼宇管理:管理端', '/dormitoryFloor/manager', 119, 'dormitoryFloor:manager', NULL, '2021-12-09 15:30:17');
INSERT INTO `menu` VALUES (126, '查询宿舍楼', '/dormitoryFloor/manager/getDormitoryFloor', 125, 'dormitoryFloor:getDormitoryFloor', NULL, '2021-12-09 15:30:13');
INSERT INTO `menu` VALUES (127, '更新楼宇', '/dormitoryFloor/manager/updateDormitoryFloor', 125, 'dormitoryFloor:updateDormitoryFloor', NULL, '2021-12-09 15:30:12');
INSERT INTO `menu` VALUES (128, '删除楼宇', '/dormitoryFloor/manager/deleteDormitoryFloor', 125, 'dormitoryFloor:deleteDormitoryFloor', NULL, '2021-12-09 15:30:09');
INSERT INTO `menu` VALUES (129, '添加楼宇', '/dormitoryFloor/manager/insertDormitoryFloor', 125, 'dormitoryFloor:insertDormitoryFloor', NULL, '2021-12-09 15:30:07');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '内容',
  `from_id` bigint(11) DEFAULT NULL COMMENT '发布通知的人',
  `to_id` int(2) DEFAULT NULL COMMENT '发布给学生是0，发布给老师是1，都能看是2',
  `state` int(2) DEFAULT NULL COMMENT '0是未发布,1是已发布',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '管理员标题测试1', '管理员内容测试1', 1, 1, 1, '2021-12-02 14:48:33', '2021-12-02 14:48:48');
INSERT INTO `notice` VALUES (2, '管理员标题测试1', '管理员内容测试1', 1, 1, 1, '2021-12-02 14:48:33', '2021-12-02 14:51:45');
INSERT INTO `notice` VALUES (3, '管理员标题测试1', '管理员内容测试1', 1, 1, 1, '2021-12-02 14:49:19', '2021-12-02 14:51:47');
INSERT INTO `notice` VALUES (4, '管理员标题测试1', '管理员内容测试1', 1, 1, 1, '2021-12-02 14:49:19', '2021-12-02 14:51:50');
INSERT INTO `notice` VALUES (5, '管理员标题测试1', '管理员内容测试1', 1, 0, 1, '2021-12-02 14:50:04', '2021-12-02 14:56:27');
INSERT INTO `notice` VALUES (6, '管理员标题测试1', '管理员内容测试1', 1, 0, 1, '2021-12-02 14:50:05', '2021-12-02 14:56:28');
INSERT INTO `notice` VALUES (7, '管理员标题测试1', '管理员内容测试1', 1, 2, 1, '2021-12-02 14:51:40', '2021-12-02 15:39:52');
INSERT INTO `notice` VALUES (9, '老师标题测试1', '老师内容测试1', 3, 1, 1, '2021-12-02 14:54:32', '2021-12-02 14:55:26');
INSERT INTO `notice` VALUES (10, '老师标题测试1', '老师内容测试1', 3, 1, 1, '2021-12-02 14:55:02', '2021-12-02 14:55:29');
INSERT INTO `notice` VALUES (11, '老师标题测试1', '老师内容测试1', 3, 1, 1, '2021-12-02 14:55:56', NULL);
INSERT INTO `notice` VALUES (12, '老师标题测试1', '老师内容测试1', 3, 1, 0, '2021-12-02 14:56:01', NULL);
INSERT INTO `notice` VALUES (13, '老师标题测试1', '老师内容测试1', 3, 1, 0, '2021-12-02 14:56:02', NULL);
INSERT INTO `notice` VALUES (14, '老师标题测试1', '老师内容测试1', 3, 1, 0, '2021-12-02 14:56:03', NULL);
INSERT INTO `notice` VALUES (15, '老师标题测试1', '老师内容测试1', 3, 1, 0, '2021-12-02 14:56:03', NULL);
INSERT INTO `notice` VALUES (16, '哈哈', '呵呵', 1, 1, 1, '2021-12-10 11:22:40', NULL);
INSERT INTO `notice` VALUES (17, '哈哈', '呵呵', 1, 1, 1, '2021-12-10 20:45:46', NULL);

-- ----------------------------
-- Table structure for ref_duties_menu
-- ----------------------------
DROP TABLE IF EXISTS `ref_duties_menu`;
CREATE TABLE `ref_duties_menu`  (
  `did` bigint(11) NOT NULL COMMENT '职务的id',
  `mid` bigint(11) DEFAULT NULL COMMENT '权限的id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职务和权限的关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ref_duties_menu
-- ----------------------------
INSERT INTO `ref_duties_menu` VALUES (1, 1, '2021-12-09 13:25:13', '2021-12-09 13:25:16');
INSERT INTO `ref_duties_menu` VALUES (1, 2, '2021-12-09 13:25:33', '2021-12-09 13:25:33');
INSERT INTO `ref_duties_menu` VALUES (1, 3, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 4, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 5, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 6, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 7, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 8, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 9, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 10, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 11, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 12, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 13, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 14, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 15, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 16, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 17, '2021-12-09 13:25:34', '2021-12-09 13:25:34');
INSERT INTO `ref_duties_menu` VALUES (1, 18, '2021-12-09 13:25:35', '2021-12-09 13:25:35');
INSERT INTO `ref_duties_menu` VALUES (1, 19, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 20, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 21, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 22, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 23, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 24, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (1, 25, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (2, 26, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (2, 27, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (2, 28, '2021-12-09 13:55:42', '2021-12-09 13:55:42');
INSERT INTO `ref_duties_menu` VALUES (2, 29, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (2, 30, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (2, 31, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (2, 32, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (3, 34, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (3, 35, '2021-12-09 13:55:43', '2021-12-09 13:55:43');
INSERT INTO `ref_duties_menu` VALUES (1, 36, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 37, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 38, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 39, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 40, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 41, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 42, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 43, '2021-12-09 14:53:50', '2021-12-09 14:53:50');
INSERT INTO `ref_duties_menu` VALUES (1, 44, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 45, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 46, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 47, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 48, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 49, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 50, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 51, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 52, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 53, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 54, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 55, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 56, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 57, '2021-12-09 14:53:51', '2021-12-09 14:53:51');
INSERT INTO `ref_duties_menu` VALUES (1, 58, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 59, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 60, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 61, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 62, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 63, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 64, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 65, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 66, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (2, 67, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (2, 68, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (2, 69, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (2, 70, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (2, 71, '2021-12-09 14:53:52', '2021-12-09 14:53:52');
INSERT INTO `ref_duties_menu` VALUES (1, 72, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (1, 73, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (1, 74, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (1, 75, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (1, 76, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (1, 77, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (2, 78, '2021-12-09 15:07:03', '2021-12-09 15:07:03');
INSERT INTO `ref_duties_menu` VALUES (2, 79, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (2, 80, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (2, 81, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (2, 82, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (3, 83, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (3, 84, '2021-12-09 15:07:04', '2021-12-09 15:07:04');
INSERT INTO `ref_duties_menu` VALUES (1, 85, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 86, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 87, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 88, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 89, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 90, '2021-12-09 15:17:44', '2021-12-09 15:17:44');
INSERT INTO `ref_duties_menu` VALUES (1, 91, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (1, 92, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (1, 93, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (1, 94, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 95, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 96, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 97, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 98, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 99, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (2, 100, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (3, 101, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (3, 102, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (3, 103, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (3, 104, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (3, 105, '2021-12-09 15:17:45', '2021-12-09 15:17:45');
INSERT INTO `ref_duties_menu` VALUES (1, 106, '2021-12-09 15:25:40', '2021-12-09 15:25:40');
INSERT INTO `ref_duties_menu` VALUES (1, 107, '2021-12-09 15:25:40', '2021-12-09 15:25:40');
INSERT INTO `ref_duties_menu` VALUES (1, 108, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (1, 109, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (1, 110, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (1, 111, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (2, 112, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (2, 113, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (2, 114, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (2, 115, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (3, 116, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (3, 117, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (3, 118, '2021-12-09 15:25:41', '2021-12-09 15:25:41');
INSERT INTO `ref_duties_menu` VALUES (1, 119, '2021-12-09 15:31:23', '2021-12-09 15:31:23');
INSERT INTO `ref_duties_menu` VALUES (1, 120, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 121, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 122, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 123, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 124, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 125, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 126, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 127, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 128, '2021-12-09 15:31:24', '2021-12-09 15:31:24');
INSERT INTO `ref_duties_menu` VALUES (1, 129, '2021-12-09 15:31:24', '2021-12-09 15:31:24');

-- ----------------------------
-- Table structure for ref_student_course
-- ----------------------------
DROP TABLE IF EXISTS `ref_student_course`;
CREATE TABLE `ref_student_course`  (
  `student_id` bigint(11) NOT NULL COMMENT '学生的id',
  `course_id` bigint(11) NOT NULL COMMENT '课程的课序号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`student_id`, `course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生和课程对应的关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ref_student_course
-- ----------------------------
INSERT INTO `ref_student_course` VALUES (1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for ref_student_examination
-- ----------------------------
DROP TABLE IF EXISTS `ref_student_examination`;
CREATE TABLE `ref_student_examination`  (
  `student_id` bigint(11) NOT NULL COMMENT '学生id',
  `examination_id` bigint(11) NOT NULL COMMENT '考试id',
  `achievement` double(4, 1) DEFAULT NULL COMMENT '学生考的成绩',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`student_id`, `examination_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生考试关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ref_student_examination
-- ----------------------------
INSERT INTO `ref_student_examination` VALUES (1, 1, 98.0, '2021-12-08 16:08:05', '2021-12-14 03:19:37');
INSERT INTO `ref_student_examination` VALUES (1, 2, 77.0, '2021-12-13 10:19:41', '2021-12-13 10:24:08');
INSERT INTO `ref_student_examination` VALUES (1, 3, 81.0, '2021-12-13 20:52:12', '2021-12-13 20:52:12');
INSERT INTO `ref_student_examination` VALUES (1, 4, 81.0, '2021-12-14 03:18:38', '2021-12-14 03:18:38');

-- ----------------------------
-- Table structure for ref_teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `ref_teacher_course`;
CREATE TABLE `ref_teacher_course`  (
  `teacher_id` bigint(11) NOT NULL COMMENT '老师的id',
  `course_id` bigint(11) NOT NULL COMMENT '课程的课序号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`teacher_id`, `course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老师选课表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ref_teacher_course
-- ----------------------------
INSERT INTO `ref_teacher_course` VALUES (3, 1, NULL, '2021-12-09 17:15:37');
INSERT INTO `ref_teacher_course` VALUES (3, 2, '2021-12-02 17:22:54', '2021-12-09 17:15:39');
INSERT INTO `ref_teacher_course` VALUES (3, 11, '2021-12-03 18:08:00', '2021-12-09 17:15:48');
INSERT INTO `ref_teacher_course` VALUES (5, 1, '2021-12-02 18:23:49', '2021-12-02 18:23:53');

-- ----------------------------
-- Table structure for ref_user_duties
-- ----------------------------
DROP TABLE IF EXISTS `ref_user_duties`;
CREATE TABLE `ref_user_duties`  (
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `duties_id` bigint(11) NOT NULL COMMENT '职务的id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`user_id`, `duties_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户对应的职务表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ref_user_duties
-- ----------------------------
INSERT INTO `ref_user_duties` VALUES (1, 1, '2021-11-21 21:51:00', '2021-11-21 21:51:04');
INSERT INTO `ref_user_duties` VALUES (2, 3, NULL, '2021-12-09 15:51:09');
INSERT INTO `ref_user_duties` VALUES (3, 2, NULL, '2021-12-09 15:51:10');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '学生表的id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生的姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号  == 用户名',
  `sex` int(2) NOT NULL COMMENT '性别',
  `start_date` datetime(0) DEFAULT NULL COMMENT '入学时间',
  `over_date` datetime(0) DEFAULT NULL COMMENT '毕业时间，没毕业默认9999-01-01',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '出生日期',
  `nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '民族',
  `college_id` bigint(11) DEFAULT NULL COMMENT '所属学院的id',
  `major_id` bigint(11) DEFAULT NULL COMMENT '所属专业的id',
  `class_id` bigint(11) DEFAULT NULL COMMENT '所属班级的id',
  `teacher_id` bigint(11) DEFAULT NULL COMMENT '属于哪个老师管理，对应老师的id',
  `dorm_id` bigint(11) DEFAULT NULL COMMENT '所属宿舍楼',
  `dormfloor_id` bigint(11) DEFAULT NULL COMMENT '所属宿舍号',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学生照片，存放照片的地址',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱地址',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `religion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '宗教',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学生状态，正常，休学，留校察看等',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 2, '王毅', 'gg123', 0, '2018-09-01 18:31:21', '2022-06-30 18:31:35', '0526', '汉族', 1, 1, 1, 1, 1, 1, NULL, '132930111111111', '1229505432@qq.com', '15369819325', '无', '1', '2021-11-24 18:43:33', '2021-12-07 13:06:41');

-- ----------------------------
-- Table structure for student_leave
-- ----------------------------
DROP TABLE IF EXISTS `student_leave`;
CREATE TABLE `student_leave`  (
  `id` bigint(11) NOT NULL COMMENT '请假主键id',
  `student_id` bigint(11) NOT NULL COMMENT '学生的id，请假人',
  `teacher_id` bigint(11) NOT NULL COMMENT '学生向哪个老师请假',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请假原因',
  `start_date` datetime(0) DEFAULT NULL COMMENT '请假开始的时间',
  `over_date` datetime(0) DEFAULT NULL COMMENT '请假结束的时间',
  `state` int(2) DEFAULT NULL COMMENT '状态，（以1请假，2未批准，3待销，4已过期，5已销假）',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请假表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_leave
-- ----------------------------
INSERT INTO `student_leave` VALUES (1, 1, 1, '剪头', NULL, NULL, 1, '2021-12-06 10:34:04', '2021-12-06 10:34:04');
INSERT INTO `student_leave` VALUES (2, 2, 1, '购物', NULL, NULL, 5, '2021-12-06 10:37:34', '2021-12-06 10:37:33');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '老师的id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '对应用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '老师的姓名',
  `username` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '老师的教师号，也是他的登录名',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '出生年月',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱地址',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `start_date` datetime(0) DEFAULT NULL COMMENT '入职时间',
  `over_date` datetime(0) DEFAULT NULL COMMENT '离职时间 未离职9999-01-01',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '存的是照片粗放的地址',
  `degree_id` bigint(11) DEFAULT NULL COMMENT '学位,教师学位表主键id',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老师表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 3, '张老师', 'gg321', 1, '0413', '1229505432@qq.com', '12345678978', '2021-11-24 19:19:47', '2021-11-24 19:19:50', NULL, 2, NULL, '2021-11-24 19:20:00', '2021-11-29 14:19:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '对应教职工号或者学号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `state` int(2) DEFAULT NULL COMMENT '-1开除,0在校,1出校',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 1, '2021-11-21 21:47:55', '2021-11-21 21:48:00');
INSERT INTO `user` VALUES (2, 'gg123', 'gg123', 1, '2021-11-24 18:28:45', '2021-11-24 18:28:49');
INSERT INTO `user` VALUES (3, 'gg321', 'gg321', 1, '2021-11-24 18:29:01', '2021-11-24 18:29:03');

SET FOREIGN_KEY_CHECKS = 1;
