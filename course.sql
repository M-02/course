/*
 Navicat Premium Data Transfer

 Source Server         : 8.133.236.211
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 8.133.236.211:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 28/03/2021 16:13:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '课程编码',
  `c_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `c_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课单位',
  `c_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类别',
  `c_credit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学分',
  `c_teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任课教师',
  `c_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课时间',
  `c_room` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课地点',
  `c_capacity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程容量',
  `c_allowance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程余量',
  `c_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程状态，1正常，0删除',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '计算机组成原理', '信息工程学院', '必修', '2', '杨航', '1-16周', '1-103', '200', '200', '1');
INSERT INTO `course` VALUES (2, 'JSP网站建设', '信息工程学院', '必修', '2', '向萱', '1-16周', '1-104', '200', '200', '1');
INSERT INTO `course` VALUES (3, '计算机网络1', '信息工程学院', '必修', '2', '王胖子', '1-16周', '1-105', '200', '200', '1');
INSERT INTO `course` VALUES (4, 'java程序设计', '信息工程学院', '必修', '2', '李逵', '1-16周', '1-106', '200', '200', '1');
INSERT INTO `course` VALUES (5, '计算机操作系统', '信息工程学院', '必修', '3', '教师', '1-16周', '1-101', '200', '199', '1');
INSERT INTO `course` VALUES (6, 'java程序设计2', '信息工程学院', '必修', '2', '夏雨', '1-16周', '1-106', '200', '200', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` int(11) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menulevel` int(11) NULL DEFAULT NULL,
  `meneparent` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`menuid`) USING BTREE,
  INDEX `menu_role`(`rid`) USING BTREE,
  CONSTRAINT `menu_role` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '用户管理', 1, 1, 3);
INSERT INTO `menu` VALUES (2, '课程管理', 1, 1, 3);
INSERT INTO `menu` VALUES (3, '我的课程', 1, 1, 2);
INSERT INTO `menu` VALUES (4, '修改密码', 1, 1, 1);
INSERT INTO `menu` VALUES (5, '修改密码', 1, 1, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '学生');
INSERT INTO `role` VALUES (2, '教师');
INSERT INTO `role` VALUES (3, '管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `upassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `rid` int(11) NULL DEFAULT NULL COMMENT '用户角色',
  `utel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `ustatus` int(255) NULL DEFAULT NULL COMMENT '用户状态，1正常，0删除',
  `uimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `ucourse` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的课程',
  `cstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '课程状态，1已选，0未选',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `user_role`(`rid`) USING BTREE,
  CONSTRAINT `user_role` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '教师', '123456', 2, '13037111478', 1, '/assets/images/users/teacher.png', '计算机操作系统', '1');
INSERT INTO `user` VALUES (2, '学生', '123456', 1, '17668977841', 1, '/assets/images/users/student.png', '计算机操作系统', '1');
INSERT INTO `user` VALUES (3, '管理员', '123456', 3, '13222222222', 1, '/assets/images/users/admin.png', NULL, '0');
INSERT INTO `user` VALUES (4, '夏雨', '111', 2, '13333333333', 1, NULL, 'java程序设计2', '1');
INSERT INTO `user` VALUES (5, '白治', '123456', 1, '13444444444', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (6, '向萱', '123456', 2, '12555555555', 1, NULL, 'JSP网站建设', '0');
INSERT INTO `user` VALUES (7, '杨航', '123456', 2, '13666666666', 1, NULL, '计算机组成原理', '0');
INSERT INTO `user` VALUES (8, '王胖子', '123456', 2, '13777777777', 1, NULL, '计算机网络1', '1');
INSERT INTO `user` VALUES (9, '李逵', '123456', 1, '13888888888', 1, NULL, 'java程序设计', '0');
INSERT INTO `user` VALUES (10, '宋江', '123456', 2, '13999999999', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (11, '谭大麻子', '123456', 2, '13000000000', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (12, '李思', '123456', 1, '13025411478', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (13, '司庞资', '123456', 2, '17733333333', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (14, '白飘', '123456', 1, '74174174741', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (15, '黄航', '123456', 1, '12222222222', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (16, '杨岗', '123456', 2, '13034565432', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (17, '撮你', '123456', 1, '17684988765', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (18, '白萱', '123456', 1, '13037111478', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (19, '向治', '123456', 1, '13037111478', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (33, '夏航', '123456', 1, '13325847154', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (34, '杨雨', '123456', 1, '13541466521', 1, NULL, NULL, '0');
INSERT INTO `user` VALUES (35, '刻晴', '123456', 3, '17253649765', 1, '/assets/images/users/刻晴.jpg', NULL, '0');

-- ----------------------------
-- Triggers structure for table course
-- ----------------------------
DROP TRIGGER IF EXISTS `inser_course`;
delimiter ;;
CREATE TRIGGER `inser_course` AFTER INSERT ON `course` FOR EACH ROW BEGIN
		UPDATE user set ucourse = new.c_name 
WHERE
	uname = new.c_teacher;
	END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table course
-- ----------------------------
DROP TRIGGER IF EXISTS `update_course`;
delimiter ;;
CREATE TRIGGER `update_course` AFTER UPDATE ON `course` FOR EACH ROW BEGIN
		UPDATE user set ucourse = new.c_name 
WHERE
	uname = new.c_teacher;
	END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
