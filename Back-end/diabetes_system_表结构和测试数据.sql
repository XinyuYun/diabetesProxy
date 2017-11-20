/*
Navicat MySQL Data Transfer

Source Server         : 预发布数据库
Source Server Version : 50717
Source Host           : 121.40.79.210:3306
Source Database       : diabetes_system

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-20 09:12:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent_info
-- ----------------------------
DROP TABLE IF EXISTS `agent_info`;
CREATE TABLE `agent_info` (
  `id` varchar(255) NOT NULL,
  `agent_name` varchar(64) NOT NULL,
  `agent_psw` varchar(64) NOT NULL,
  `is_active` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_info
-- ----------------------------
INSERT INTO `agent_info` VALUES ('0943755e46bc4de49ebd887b1d855a0a', '001', '309ce6f2a3348103dfc3391f79fa6cb66612a9ea', '0', '2017-10-09 15:31:42', '2017-10-09 15:31:42', 'admin', 'admin', '0');
INSERT INTO `agent_info` VALUES ('2a7396beb58f476d993dea4101e4c4a9', 'fang', '7678d5b290e577299c558d8167f5a6394efbe316', '0', '2017-09-28 17:06:59', '2017-10-09 15:02:34', 'admin', 'admin', '1');
INSERT INTO `agent_info` VALUES ('4a128d4d56d64371b4d45b1d15b0874e', '12', '5f80d65f8d16f37a1fc2e5d35e8d4726c1171818', '0', '2017-09-28 16:41:35', '2017-10-09 15:02:41', 'admin', 'admin', '1');
INSERT INTO `agent_info` VALUES ('4e4c8c7cde284d4886f7e445273b44c1', '宁波代理商', '309ce6f2a3348103dfc3391f79fa6cb66612a9ea', '0', '2017-10-09 15:03:01', '2017-10-09 15:31:20', 'admin', 'admin', '1');
INSERT INTO `agent_info` VALUES ('aaa', 'ddd', 'd896368d11637a9d0cb8a3fc58b81157211c7105', '0', '2017-09-25 16:09:47', '2017-10-09 15:02:43', null, 'admin', '1');
INSERT INTO `agent_info` VALUES ('d8ad047fd6934f0d800e2cbe3a79b8e4', 'admin', '3ddadea592665ac4e5ae847205fdf04759ba618a', '0', '2017-09-27 10:22:45', '2017-10-09 15:02:45', 'admin', 'admin', '1');
INSERT INTO `agent_info` VALUES ('e3621ca440cc48e4bae05143c1637490', 'test', '3b07a601889a5c98a1e12c74146172b61010e89b', '0', '2017-11-20 00:45:13', '2017-11-20 00:45:13', 'admin', 'admin', '0');
INSERT INTO `agent_info` VALUES ('e94d070097644e4686c14c8e7d75bb99', 'ceshi', 'c9746fe5115c63f05e964db0f8b2aa924a6a7638', '0', '2017-09-26 16:39:18', '2017-10-09 15:02:47', 'admin', 'admin', '1');
INSERT INTO `agent_info` VALUES ('fa32ebd089c74fe4ad452998fff08cef', 'test', '3b07a601889a5c98a1e12c74146172b61010e89b', '0', '2017-11-19 20:51:50', '2017-11-20 00:03:07', 'admin', 'admin', '1');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` varchar(255) NOT NULL,
  `student_name` varchar(64) NOT NULL,
  `student_age` int(11) DEFAULT NULL,
  `student_sex` varchar(5) DEFAULT NULL,
  `contact_info` varchar(128) DEFAULT NULL,
  `diabetes_year` varchar(4) DEFAULT NULL,
  `insulin_year` varchar(4) DEFAULT NULL,
  `insulin_type` varchar(32) DEFAULT NULL,
  `insulin_dosage` varchar(16) DEFAULT NULL,
  `training_id` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('089a4442177044739e9860706f28fb45', '学员', '30', '男', '13788008800', '20', '1', 'xxx', '100', '100d9a03042646e287a340c6743c8897', '2017-09-27 17:19:36', '2017-09-28 12:57:19', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('75a70e9eb99549159863af1413f9ec15', '张三', '30', '男', '宁波市', '2', '1', 'AAA', '2', '3d6dbce3945141a6ade136daf3f5a420', '2017-09-27 15:51:05', '2017-09-27 15:51:05', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('82fa4d2bfb0d42ba9ca8d67f9a3a153c', 'a2', '31', '男', '22222', '1', '3', 'xxx2', '300', '811739bd1f7748919c5ca272d68b8815', '2017-09-29 09:30:19', '2017-09-29 09:30:19', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('8e36d0c05ad34b9db2065c4479aa3329', '12', '1', '男', '13767588080', '1', '2', '3', '1212121', '100d9a03042646e287a340c6743c8897', '2017-09-27 17:25:48', '2017-09-28 10:02:14', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('989c876bb70a4eb8973f76920a33e99c', '小东', '0', '男', '', '', '', '', '', 'b2e4e86aa17149e385788f4d5dc3e258', '2017-10-09 15:36:00', '2017-10-09 15:36:27', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('b220b16b2abe41e982e8bbc30fdecca1', '小明', '25', '男', '18276420680', '2', '1.5', 'w', '1', 'b2e4e86aa17149e385788f4d5dc3e258', '2017-10-09 15:33:59', '2017-10-09 15:33:59', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('c0870326b5e24ca5afb2942073849599', '333', '2', '男', '2121', '3', '4', '5', '7', '100d9a03042646e287a340c6743c8897', '2017-09-28 10:00:45', '2017-09-28 10:02:01', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('d2d5d89ebe5e47e186089fc4a631c8d1', 'fang', '25', '男', '18368494191', '1', '1', 'xxx', 'xx', '100d9a03042646e287a340c6743c8897', '2017-09-28 17:10:01', '2017-09-28 17:10:01', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('e6603113dc6e424a9f132f886aa4e4c3', '1', '30', '男', '13788008800', '20', '1', 'xxx', '100', '100d9a03042646e287a340c6743c8897', '2017-09-29 09:11:31', '2017-09-29 09:11:31', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('e7d0872fa70b4c2a8d91125ddcef1409', '张五改', '35', '男', '宁波市', '2', '1', 'BBB', '2', '3d6dbce3945141a6ade136daf3f5a420', '2017-09-27 15:51:47', '2017-09-27 15:52:53', 'admin', 'admin', '1');
INSERT INTO `student_info` VALUES ('ed9fdebc8d0d4781b0c67b05e1a572cb', 'asdf', '123', '男', 'asdf', 'asdf', 'asdf', 'asdf', 'asdf', 'f0f971f5e01a41898a54bba20f6397c7', '2017-11-20 00:46:36', '2017-11-20 00:47:36', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('fddcf5dbb2a24443a1aba0b01f92364e', '方浩杰', '26', '男', '18267420680', '2', '1', '种类', '1', '3eedf44c3410429fadebe713396a69cd', '2017-10-09 15:06:05', '2017-10-09 15:06:05', 'admin', 'admin', '0');
INSERT INTO `student_info` VALUES ('fea6df790b89402fa86b2c0f8ffc43be', 'a1', '12', '女', '11111111', '1', '2', 'xxx1', '100', '811739bd1f7748919c5ca272d68b8815', '2017-09-29 09:30:00', '2017-09-29 09:30:00', 'admin', 'admin', '0');

-- ----------------------------
-- Table structure for tracking_info
-- ----------------------------
DROP TABLE IF EXISTS `tracking_info`;
CREATE TABLE `tracking_info` (
  `id` varchar(255) NOT NULL,
  `tracking_date` date NOT NULL,
  `tracking_type` int(11) DEFAULT NULL,
  `diet_recommend` varchar(255) DEFAULT NULL,
  `sport_recommend` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `blood_sugar` varchar(16) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  `insulin_dosage_recommend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tracking_info
-- ----------------------------
INSERT INTO `tracking_info` VALUES ('0490a3cb11a943bfb777407f0fd06f2b', '2017-09-28', '2', '133g&203g&203g', '增加&20min', '089a4442177044739e9860706f28fb45', null, '2017-09-28 16:09:52', '2017-09-28 16:28:50', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('34ea9d63c1fb427fa40cc03c7f488314', '2017-10-09', '0', '2&3&4', '5&6', 'fddcf5dbb2a24443a1aba0b01f92364e', '12', '2017-10-09 15:07:53', '2017-10-09 15:19:00', 'admin', 'admin', '0', '1');
INSERT INTO `tracking_info` VALUES ('35d5316b70f14d06843a247273d687bd', '2017-09-26', '2', '101g&201g&301g', '减少&31min', '089a4442177044739e9860706f28fb45', null, '2017-09-28 15:39:47', '2017-09-28 15:39:47', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('3e36bf1d60d74dacb7ae89d97667e923', '2017-09-02', '1', 'eat more and more', 'run and run', '75a70e9eb99549159863af1413f9ec15', null, '2017-09-27 19:37:34', '2017-09-27 19:37:34', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('4c967021d1884fcda4ebea11e186c499', '2017-09-28', '1', '100g&200g&300g', '增加&30min', '089a4442177044739e9860706f28fb45', '200', '2017-09-28 15:38:19', '2017-09-28 16:46:21', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('5b8be1828c1541e0aa0d7b81a575eac9', '2017-09-26', '0', '100g&200g&300g', '增加&30min', '82fa4d2bfb0d42ba9ca8d67f9a3a153c', '1000', '2017-09-29 09:38:46', '2017-09-29 09:53:43', 'admin', 'admin', '0', '300');
INSERT INTO `tracking_info` VALUES ('62d3bec1319d4dc389620b24f661a50e', '2017-09-02', '0', 'eat more', 'run', '75a70e9eb99549159863af1413f9ec15', '6.1', '2017-09-27 15:55:36', '2017-09-27 16:01:04', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('75cdb308e7194f3489be51545416ba5c', '2017-09-28', '0', '12g&2g&3g', '增加&10min', '089a4442177044739e9860706f28fb45', null, '2017-09-28 16:29:11', '2017-09-28 16:29:20', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('93635ea623c54302ac9410e92e144750', '2017-10-11', '1', '1&1&1', '1&1', 'b220b16b2abe41e982e8bbc30fdecca1', null, '2017-10-09 15:35:36', '2017-10-09 15:35:36', 'admin', 'admin', '0', '1');
INSERT INTO `tracking_info` VALUES ('93eb9059c996428f832350127256e712', '2017-09-27', '0', '102g&202g&302g', '减少&20min', '089a4442177044739e9860706f28fb45', null, '2017-09-28 15:40:55', '2017-09-28 15:40:55', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('9597da6493034a5c97893bd7f1d62adb', '2017-09-03', '0', 'eat more and more and more', 'run and run', '75a70e9eb99549159863af1413f9ec15', null, '2017-09-27 19:38:05', '2017-09-27 19:38:05', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('bd085e5d86e14d1881da5b3bf6d593a5', '2017-09-02', '2', 'eat more and more and more', 'run and run', '75a70e9eb99549159863af1413f9ec15', null, '2017-09-27 19:37:55', '2017-09-27 19:37:55', 'admin', 'admin', '0', null);
INSERT INTO `tracking_info` VALUES ('d0e0ba80bb7344a198b51d3d6be1125d', '2017-10-11', '0', '一勺&两勺&三勺', '中&一小时', 'b220b16b2abe41e982e8bbc30fdecca1', '15', '2017-10-09 15:35:17', '2017-10-13 13:29:37', 'admin', 'admin', '0', '1');
INSERT INTO `tracking_info` VALUES ('de1db2859414442884094a085db6c126', '2017-10-11', '2', '2&2&2', '2&2', 'b220b16b2abe41e982e8bbc30fdecca1', null, '2017-10-09 15:35:42', '2017-10-09 15:35:42', 'admin', 'admin', '0', '2');
INSERT INTO `tracking_info` VALUES ('f49fd99a6ce248ba8db0287c42b5957b', '2017-10-09', '1', '2&3&4', '5&6', 'fddcf5dbb2a24443a1aba0b01f92364e', null, '2017-10-09 15:08:06', '2017-10-09 15:08:06', 'admin', 'admin', '0', '1');

-- ----------------------------
-- Table structure for training_info
-- ----------------------------
DROP TABLE IF EXISTS `training_info`;
CREATE TABLE `training_info` (
  `id` varchar(255) NOT NULL,
  `training_name` varchar(80) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `agent_id` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of training_info
-- ----------------------------
INSERT INTO `training_info` VALUES ('100d9a03042646e287a340c6743c8897', '测试场次', '2017-09-04 00:00:00', '2017-09-28 00:00:00', 'd8ad047fd6934f0d800e2cbe3a79b8e4', '2017-09-27 10:03:45', '2017-09-28 17:23:27', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('3d6dbce3945141a6ade136daf3f5a420', '宁波第二场', '2017-09-29 00:00:00', '2017-10-05 00:00:00', 'aaa', '2017-09-26 15:36:15', '2017-09-26 15:39:11', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('3eedf44c3410429fadebe713396a69cd', '宁波十月场', '2017-10-09 00:00:00', '2017-10-13 00:00:00', '4e4c8c7cde284d4886f7e445273b44c1', '2017-10-09 15:03:25', '2017-10-09 15:31:21', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('756e4bc087514a65bba8a2e91fa29b81', '测试场次2', '2017-11-05 00:00:00', '2017-11-09 00:00:00', '2a7396beb58f476d993dea4101e4c4a9', '2017-09-28 17:07:47', '2017-10-09 15:02:36', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('77ba545c771b432d94f92454f9fcf7d5', 'ceshi', '2017-10-09 00:00:00', '2017-10-20 00:00:00', 'e94d070097644e4686c14c8e7d75bb99', '2017-10-09 14:33:15', '2017-10-09 15:02:38', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('811739bd1f7748919c5ca272d68b8815', '宁波第一场', '2017-09-26 00:00:00', '2017-10-01 00:00:00', 'd8ad047fd6934f0d800e2cbe3a79b8e4', '2017-09-26 15:35:43', '2017-10-09 15:02:40', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('9fd959b97a194943bceeda2e962321af', 'aaa', '2017-09-02 00:00:00', '2017-09-07 00:00:00', 'd8ad047fd6934f0d800e2cbe3a79b8e4', '2017-09-28 16:30:58', '2017-09-28 16:31:22', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('b03d1310b6094c4485f64c190e65de95', '1', '2017-09-06 00:00:00', '2017-09-30 00:00:00', 'aaa', '2017-09-28 16:33:43', '2017-09-28 16:33:54', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('b2e4e86aa17149e385788f4d5dc3e258', '宁波十月场', '2017-10-11 00:00:00', '2017-10-16 00:00:00', '0943755e46bc4de49ebd887b1d855a0a', '2017-10-09 15:32:17', '2017-10-09 15:32:17', 'admin', 'admin', '0');
INSERT INTO `training_info` VALUES ('d1d077410dcf442fbf839abca90bff5e', '测试2', '2017-09-06 00:00:00', '2017-09-14 00:00:00', 'aaa', '2017-09-27 10:10:51', '2017-09-27 10:13:47', 'admin', 'admin', '1');
INSERT INTO `training_info` VALUES ('f0f971f5e01a41898a54bba20f6397c7', 'test', '2017-11-19 00:00:00', '2017-11-26 00:00:00', 'e3621ca440cc48e4bae05143c1637490', '2017-11-20 00:45:26', '2017-11-20 00:45:26', 'admin', 'admin', '0');
