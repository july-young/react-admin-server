/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.29 : Database - react-admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`react-admin` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `react-admin`;

/*Table structure for table `r_role_permission` */

DROP TABLE IF EXISTS `r_role_permission`;

CREATE TABLE `r_role_permission` (
  `id` bigint(20) NOT NULL COMMENT '数据id',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `permission_id` bigint(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `r_role_permission` */

insert  into `r_role_permission`(`id`,`role_id`,`permission_id`) values
(2,2,2),
(3,2,1),
(4,2,14),
(5,2,3),
(6,2,4),
(7,2,5),
(8,2,6),
(9,2,7),
(10,2,8),
(11,2,9),
(12,2,10),
(13,2,11),
(14,2,12),
(15,2,13),
(672808050263851008,1,4),
(672808050272239616,1,5),
(672808050284822528,1,6),
(672808050293211136,1,7);

/*Table structure for table `r_user_role` */

DROP TABLE IF EXISTS `r_user_role`;

CREATE TABLE `r_user_role` (
  `id` bigint(20) NOT NULL COMMENT '数据id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '授权时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '授权人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `r_user_role` */

insert  into `r_user_role`(`id`,`user_id`,`role_id`,`gmt_create`,`creator`) values
(1,1,1,'2020-01-30 23:33:04',NULL),
(3,2,2,'2020-01-30 23:33:04',NULL),
(672922160905322496,672922160901128192,672808601055657984,NULL,NULL),
(672922160947265536,672922160901128192,672771928833916928,NULL,NULL),
(672922654721703936,672922654713315328,672808601055657984,NULL,NULL),
(672922654763646976,672922654713315328,672771928833916928,NULL,NULL),
(672922745331253248,672922745322864640,672808601055657984,NULL,NULL),
(672922745348030464,672922745322864640,672771928833916928,NULL,NULL),
(672924724845608960,672924724661059584,672808601055657984,NULL,NULL),
(672924724967243776,672924724661059584,672771928833916928,NULL,NULL),
(672926810127728640,672922076100689920,672771928833916928,NULL,NULL);

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `version` int(255) NOT NULL DEFAULT '1' COMMENT '版本',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的修改时间',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据更新人  0系统',
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=670014328505630721 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_category` */

insert  into `t_category`(`id`,`name`,`version`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`,`parent_id`) values
(666785609326526464,'家用电器',1,'2020-01-14 23:28:00','2020-01-14 23:28:00',1,0,0,0),
(666785743896576000,'医药食品2',1,'2020-01-14 23:28:29','2020-01-14 23:28:29',1,0,0,0),
(666795589391876096,'AAA',1,'2020-01-15 00:07:36','2020-01-15 00:07:36',1,0,0,0),
(666795613643341824,'BBB',1,'2020-01-15 00:07:42','2020-01-15 00:07:42',1,0,0,666795589391876096),
(666795629644611584,'CCC',1,'2020-01-15 00:07:46','2020-01-15 00:07:46',1,0,0,0),
(666795643460648960,'DDD',1,'2020-01-15 00:07:49','2020-01-15 00:07:49',1,0,0,0),
(668184559484928000,'DDD',1,'2020-01-18 20:06:53','2020-01-18 20:06:53',1,0,0,666795589391876096),
(670014328505630720,'EEE',1,'2020-01-23 21:17:44','2020-01-23 21:17:44',1,0,0,666795589391876096);

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `url` varchar(255) NOT NULL COMMENT 'URL',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `pid` bigint(11) NOT NULL COMMENT '父级id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '数据的更新时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) DEFAULT '0' COMMENT '数据更新人  0系统',
  `icon` varchar(31) CHARACTER SET latin1 DEFAULT NULL COMMENT 'icon图标',
  `has_pub` tinyint(1) DEFAULT '0' COMMENT '是否公开',
  `type` int(11) DEFAULT '1' COMMENT '1 接口 2 menu',
  `method` varchar(7) DEFAULT 'GET' COMMENT 'get post put delete',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`url`,`name`,`description`,`pid`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`,`icon`,`has_pub`,`type`,`method`) values
(1,'/menu','获取菜单',NULL,0,NULL,NULL,1,0,0,NULL,0,1,NULL),
(2,'/user/admin','admin',NULL,0,NULL,NULL,1,0,0,NULL,0,1,NULL),
(3,'/home','首页',NULL,0,NULL,NULL,1,0,0,'home',1,2,NULL),
(4,'/products','商品',NULL,0,NULL,NULL,1,0,0,'appstore',0,2,NULL),
(5,'/category','品类管理',NULL,4,NULL,NULL,1,0,0,'bars',0,2,NULL),
(6,'/product','商品管理',NULL,4,NULL,NULL,1,0,0,'tool',0,2,NULL),
(7,'/user','用户管理',NULL,0,NULL,NULL,1,0,0,'user',0,2,NULL),
(8,'/role','角色管理',NULL,0,'2020-01-11 00:09:20',NULL,1,0,0,'safety',0,2,NULL),
(9,'/charts','图形图表',NULL,0,NULL,NULL,1,0,0,'area-chart',0,2,NULL),
(10,'/charts/bar','柱形图',NULL,9,NULL,NULL,1,0,0,'bar-chart',0,2,NULL),
(11,'/charts/line','折线图',NULL,9,NULL,NULL,1,0,0,'line-chart',0,2,NULL),
(12,'/charts/pie','饼图',NULL,9,NULL,NULL,1,0,0,'pie-chart',0,2,NULL),
(13,'/order','订单管理',NULL,0,NULL,NULL,0,0,0,'windows',0,2,NULL),
(14,'weather','获取天气',NULL,0,NULL,NULL,1,0,0,NULL,0,1,'GET');

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` bigint(11) NOT NULL COMMENT '数据id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `version` int(255) NOT NULL DEFAULT '1' COMMENT '版本',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的修改时间',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据更新人  0系统',
  `imgs` varchar(511) DEFAULT NULL COMMENT '图片地址（json数组）',
  `price` decimal(8,2) DEFAULT NULL COMMENT '价格',
  `detail` varchar(2000) DEFAULT NULL COMMENT '描述（富文本）',
  `p_category_id` bigint(20) DEFAULT NULL COMMENT '分类的父级ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类的ID',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) DEFAULT NULL COMMENT '2 上架 1 下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`name`,`version`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`,`imgs`,`price`,`detail`,`p_category_id`,`category_id`,`description`,`status`) values
(669313912675500032,'qqq2',1,'2020-01-21 22:54:34','2020-01-21 22:54:34',1,0,0,'[\"20200201174658.jpg\"]',12.00,'<p><strong>adsfasdf</strong></p>\n',666795589391876096,666795613643341824,'www',NULL),
(670031727774662656,'qqq',1,'2020-01-23 22:26:56','2020-01-23 22:26:56',1,0,0,'[]',12.00,NULL,666795589391876096,668184559484928000,'www',NULL),
(670032895334678528,'qqq',1,'2020-01-23 22:31:30','2020-01-23 22:31:30',1,0,0,'[]',14.00,'<p><strong>dddddddddddddssssss</strong></p>\n',666795589391876096,668184559484928000,'www',NULL),
(670034664156561408,'qqq',1,'2020-01-23 22:38:32','2020-01-23 22:38:32',1,0,0,'[]',14.00,NULL,666795589391876096,668184559484928000,'www',NULL),
(670042157997883392,'qqq',1,'2020-01-23 23:08:19','2020-01-23 23:08:19',1,0,0,'[]',14.00,'<p>ddddd</p>\n',666795589391876096,668184559484928000,'www',NULL);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的修改时间',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) NOT NULL COMMENT '数据创建人  0系统',
  `updater` bigint(20) NOT NULL COMMENT '数据更新人  0系统',
  `gmt_auth` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '授权时间',
  `auth_user_id` bigint(20) DEFAULT NULL COMMENT '授权人Id',
  `auth_user_name` varchar(31) DEFAULT NULL COMMENT '授权人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=672808690461442049 DEFAULT CHARSET=latin1;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`,`gmt_auth`,`auth_user_id`,`auth_user_name`) values
(1,'USER','2020-01-06 23:26:42','2020-01-06 23:26:42',1,0,2,'2020-01-30 23:35:01',2,'admin'),
(2,'ADMIN','2020-01-06 23:26:42','2020-01-06 23:26:42',1,0,0,'2020-01-30 23:35:01',0,'sys'),
(672770752046432256,'test','2020-01-31 11:50:46','2020-01-31 11:50:46',1,2,2,'2020-01-31 11:50:46',2,'admin'),
(672770917058740224,'test2','2020-01-31 11:51:45','2020-01-31 11:51:45',1,2,2,'2020-01-31 11:51:45',2,'admin'),
(672771804778987520,'test02','2020-01-31 11:54:58','2020-01-31 11:54:58',1,2,2,'2020-01-31 11:54:58',2,'admin'),
(672771872441499648,'test','2020-01-31 11:55:18','2020-01-31 11:55:18',1,2,2,'2020-01-31 11:55:18',2,'admin'),
(672771928833916928,'qqqq','2020-01-31 11:55:27','2020-01-31 11:55:27',1,2,2,'2020-01-31 11:55:27',2,'admin'),
(672808601055657984,'ddddd','2020-01-31 14:21:10','2020-01-31 14:21:10',1,2,2,'2020-01-31 14:21:10',2,'admin'),
(672808690461442048,'eeee','2020-01-31 14:21:31','2020-01-31 14:21:31',1,2,2,'2020-01-31 14:21:31',2,'admin');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `username` varchar(255) CHARACTER SET latin1 NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET latin1 NOT NULL COMMENT '密码',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的修改时间',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据更新人  0系统',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(31) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=672922076100689921 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`,`phone`,`email`) values
(1,'user','$2a$10$95s/ecu/Euks2P/iMtLC/OGjkbMaHbMsLwNPmwAC90p7lJq9AzsyC','2020-01-06 23:16:41','2020-01-06 23:16:41',1,0,0,'18268732124','1103225671@qq.com'),
(2,'admin','$2a$10$95s/ecu/Euks2P/iMtLC/OGjkbMaHbMsLwNPmwAC90p7lJq9AzsyC','2020-01-06 23:16:41','2020-01-06 23:16:41',1,0,0,'18268732125','1103225672@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
