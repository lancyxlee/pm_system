/*
Navicat MySQL Data Transfer

Source Server         : offer
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : pm_system

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-04 15:41:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance_set
-- ----------------------------
DROP TABLE IF EXISTS `attendance_set`;
CREATE TABLE `attendance_set` (
  `setid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `setlatecome` double DEFAULT NULL COMMENT '迟到惩罚',
  `setearlyleave` double DEFAULT NULL COMMENT '早退惩罚',
  `setearlycome` double DEFAULT NULL COMMENT '早到奖励',
  `setovertime` double DEFAULT NULL COMMENT '加班奖励',
  `setleave` double DEFAULT NULL COMMENT '请假奖罚',
  PRIMARY KEY (`setid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of attendance_set
-- ----------------------------

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence` (
  `aid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uempid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工id',
  `uempname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工姓名',
  `ayear` int(11) DEFAULT NULL COMMENT '年份',
  `amonth` int(11) DEFAULT NULL COMMENT '月份',
  `alatecome` int(11) DEFAULT NULL COMMENT '迟到次数',
  `aearlyleave` int(11) DEFAULT NULL COMMENT '早退次数',
  `aearlycome` int(11) DEFAULT NULL COMMENT '早到次数',
  `aovertime` int(11) DEFAULT NULL COMMENT '加班次数',
  `aleave` int(11) DEFAULT NULL COMMENT '请假次数',
  `bonusres` double DEFAULT NULL COMMENT '奖罚结果',
  PRIMARY KEY (`aid`,`uempid`),
  UNIQUE KEY `uempid_UNIQUE` (`uempid`),
  UNIQUE KEY `uempname_UNIQUE` (`uempname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of attendence
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `deptname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门名称',
  `deptnum` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门编号',
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门电话',
  PRIMARY KEY (`did`),
  UNIQUE KEY `deptnum_UNIQUE` (`deptnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `uid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uempid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工工号',
  `uempname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0：男1：女）',
  `idnum` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `telnum` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `startdate` datetime DEFAULT NULL COMMENT '转正时间',
  `deptnum` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属部门编号',
  PRIMARY KEY (`uid`,`uempid`),
  UNIQUE KEY `uempid_UNIQUE` (`uempid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  UNIQUE KEY `deptnum_UNIQUE` (`deptnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for perfomance_set
-- ----------------------------
DROP TABLE IF EXISTS `perfomance_set`;
CREATE TABLE `perfomance_set` (
  `pset_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `grade` int(11) DEFAULT NULL COMMENT '绩效等级',
  `bonus_set` double DEFAULT NULL COMMENT '奖罚设置',
  PRIMARY KEY (`pset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of perfomance_set
-- ----------------------------

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
  `pid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uid` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `pyear` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '年份',
  `pmonth` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '月份',
  `performance` double DEFAULT NULL COMMENT '绩效总分',
  PRIMARY KEY (`pid`),
  UNIQUE KEY `pid_UNIQUE` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of performance
-- ----------------------------

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `sid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `uid` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `sbasesalary` double DEFAULT NULL COMMENT '基本工资',
  `sfinalsalary` double DEFAULT NULL COMMENT '最终工资',
  `syear` int(11) DEFAULT NULL COMMENT '年份',
  `smonth` int(11) DEFAULT NULL COMMENT '月份',
  `sattendence` double DEFAULT NULL COMMENT '考勤奖罚',
  `skpi` double DEFAULT NULL COMMENT '绩效奖罚',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for salary_set
-- ----------------------------
DROP TABLE IF EXISTS `salary_set`;
CREATE TABLE `salary_set` (
  `salarysetid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `deptnum` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门编号',
  `sbasesalary` double DEFAULT NULL COMMENT '基本工资',
  `role` double DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`salarysetid`),
  UNIQUE KEY `deptnum_UNIQUE` (`deptnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of salary_set
-- ----------------------------

-- ----------------------------
-- Table structure for task_management
-- ----------------------------
DROP TABLE IF EXISTS `task_management`;
CREATE TABLE `task_management` (
  `tid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `uid` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '任务名称',
  `detail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '任务详情',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `deadline` datetime DEFAULT NULL COMMENT '完成期限',
  `status` int(11) DEFAULT NULL COMMENT '状态（0：未完成；1：进行中；2：已完成）',
  PRIMARY KEY (`tid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task_management
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id',
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `role` int(11) NOT NULL COMMENT '角色（0：管理员1：部门经理2：普通员工）',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for workplan
-- ----------------------------
DROP TABLE IF EXISTS `workplan`;
CREATE TABLE `workplan` (
  `uid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工编号',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `dailyplan` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '当日计划',
  `completion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '完成情况',
  `supv_rating` double DEFAULT NULL COMMENT '主管评分',
  `self_rating` double DEFAULT NULL COMMENT '自评分',
  `adst_rating` double DEFAULT NULL COMMENT '管理员评分',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of workplan
-- ----------------------------
