/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : pm_system

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 07/10/2019 12:15:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `aid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uempid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工id',
  `uempname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `ayear` int(11) NULL DEFAULT NULL COMMENT '年份',
  `amonth` int(11) NULL DEFAULT NULL COMMENT '月份',
  `alatecome` int(11) NULL DEFAULT NULL COMMENT '迟到次数',
  `aearlyleave` int(11) NULL DEFAULT NULL COMMENT '早退次数',
  `aearlycome` int(11) NULL DEFAULT NULL COMMENT '早到次数',
  `workovertime` int(11) NULL DEFAULT NULL COMMENT '工作日加班次数',
  `aleave` int(11) NULL DEFAULT NULL COMMENT '请假次数',
  `bonusres` double NULL DEFAULT NULL COMMENT '奖罚结果',
  `wovertime` int(11) NULL DEFAULT NULL COMMENT '双休日加班次数',
  `hovertime` int(11) NULL DEFAULT NULL COMMENT '国定假日加班次数',
  PRIMARY KEY (`aid`, `uempid`) USING BTREE,
  UNIQUE INDEX `uempid_UNIQUE`(`uempid`) USING BTREE,
  UNIQUE INDEX `uempname_UNIQUE`(`uempname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for attendance_set
-- ----------------------------
DROP TABLE IF EXISTS `attendance_set`;
CREATE TABLE `attendance_set`  (
  `setid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `setlatecome` double NULL DEFAULT NULL COMMENT '迟到惩罚',
  `setearlyleave` double NULL DEFAULT NULL COMMENT '早退惩罚',
  `setearlycome` double NULL DEFAULT NULL COMMENT '早到奖励',
  `setworkovertime` double NULL DEFAULT NULL COMMENT '工作日加班奖励',
  `setleave` double NULL DEFAULT NULL COMMENT '请假奖罚',
  `setwovertime` double NULL DEFAULT NULL COMMENT '双休日加班奖励',
  `sethovertime` double NULL DEFAULT NULL COMMENT '国定假日加班奖励',
  PRIMARY KEY (`setid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `did` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `deptname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '部门名称',
  `deptnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '部门编号',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '部门电话',
  PRIMARY KEY (`did`) USING BTREE,
  UNIQUE INDEX `deptnum_UNIQUE`(`deptnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uempid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工工号',
  `uempname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别（0：男1：女）',
  `idnum` varchar(18) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '身份证号',
  `telnum` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
  `startdate` datetime(0) NULL DEFAULT NULL COMMENT '转正时间',
  `deptnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '所属部门编号',
  PRIMARY KEY (`uid`, `uempid`) USING BTREE,
  UNIQUE INDEX `uempid_UNIQUE`(`uempid`) USING BTREE,
  UNIQUE INDEX `uid_UNIQUE`(`uid`) USING BTREE,
  UNIQUE INDEX `deptnum_UNIQUE`(`deptnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for perfomance_set
-- ----------------------------
DROP TABLE IF EXISTS `perfomance_set`;
CREATE TABLE `perfomance_set`  (
  `pset_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `grade` int(11) NULL DEFAULT NULL COMMENT '绩效等级',
  `bonus_set` double NULL DEFAULT NULL COMMENT '奖罚设置',
  PRIMARY KEY (`pset_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance`  (
  `pid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `pyear` int(11) NULL DEFAULT NULL COMMENT '年份',
  `pmonth` int(11) NULL DEFAULT NULL COMMENT '月份',
  `performance` double NULL DEFAULT NULL COMMENT '绩效总分',
  PRIMARY KEY (`pid`) USING BTREE,
  UNIQUE INDEX `pid_UNIQUE`(`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `basesalary` double NULL DEFAULT NULL COMMENT '基本工资',
  `finalsalary` double NULL DEFAULT NULL COMMENT '最终工资',
  `year` int(11) NULL DEFAULT NULL COMMENT '年份',
  `month` int(11) NULL DEFAULT NULL COMMENT '月份',
  `attendence` double NULL DEFAULT NULL COMMENT '考勤奖罚',
  `kpi` double NULL DEFAULT NULL COMMENT '绩效奖罚',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uid_UNIQUE`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for salary_set
-- ----------------------------
DROP TABLE IF EXISTS `salary_set`;
CREATE TABLE `salary_set`  (
  `salarysetid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `deptnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '部门编号',
  `basesalary` double NULL DEFAULT NULL COMMENT '基本工资',
  `role` int(11) NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`salarysetid`) USING BTREE,
  UNIQUE INDEX `deptnum_UNIQUE`(`deptnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task_management
-- ----------------------------
DROP TABLE IF EXISTS `task_management`;
CREATE TABLE `task_management`  (
  `tid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '任务名称',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '任务详情',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deadline` datetime(0) NULL DEFAULT NULL COMMENT '完成期限',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态（0：未完成；1：进行中；2：已完成）',
  PRIMARY KEY (`tid`) USING BTREE,
  UNIQUE INDEX `uid_UNIQUE`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `role` int(11) NOT NULL COMMENT '角色（0：管理员1：部门经理2：普通员工）',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uid_UNIQUE`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'llx', 'e10adc3949ba59abbe56e057f20f883e', 0);

-- ----------------------------
-- Table structure for workplan
-- ----------------------------
DROP TABLE IF EXISTS `workplan`;
CREATE TABLE `workplan`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工编号',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `dailyplan` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '当日计划',
  `completion` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '完成情况',
  `supv_rating` double NULL DEFAULT NULL COMMENT '主管评分',
  `self_rating` double NULL DEFAULT NULL COMMENT '自评分',
  `adst_rating` double NULL DEFAULT NULL COMMENT '管理员评分',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uid_UNIQUE`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
