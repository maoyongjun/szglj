/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : jeesite

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 28/05/2020 17:26:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for api_log
-- ----------------------------
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问记录的id',
  `api_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'API的编号',
  `api_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'API的名称',
  `response_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求返回的状态码，例如 200 404 500',
  `in_date` date NULL DEFAULT NULL COMMENT '访问进入的时间',
  `out_date` date NULL DEFAULT NULL COMMENT '访问返回的时间',
  `take_time` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '消耗的时长(毫秒)',
  `is_data_pull_status` int(11) NULL DEFAULT NULL COMMENT '数据为主动获取 还是被动接收 0：主动拉取 1：被动接收',
  `dataType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的数据格式，例如xml、JSON',
  `request_data` varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的数据',
  `response_data` varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返回的数据'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'api访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for api_log_total
-- ----------------------------
DROP TABLE IF EXISTS `api_log_total`;
CREATE TABLE `api_log_total`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'id',
  `api_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'API的编号',
  `api_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'API的名称',
  `success_count` bigint(20) NULL DEFAULT NULL COMMENT '访问成功次数',
  `fail_count` bigint(20) NULL DEFAULT NULL COMMENT '访问失败次数',
  `in_date` date NULL DEFAULT NULL COMMENT '访问进入的时间,每小时一条记录',
  `take_avg_time` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '消耗的平均时长(毫秒)'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'api访问次数统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for api_register
-- ----------------------------
DROP TABLE IF EXISTS `api_register`;
CREATE TABLE `api_register`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'id',
  `api_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `api_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `api_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `api_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `cron` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表达式',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `register_time` date NULL DEFAULT NULL COMMENT '注册时间',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `api_type` int(11) NULL DEFAULT NULL COMMENT '是否主动调用'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'api注册记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
