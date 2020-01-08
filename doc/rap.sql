/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.18-log : Database - react-admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`react-admin` /*!40100 DEFAULT CHARACTER SET latin1 */;

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
(1,1,1),
(2,2,1),
(3,2,2);

/*Table structure for table `r_user_role` */

DROP TABLE IF EXISTS `r_user_role`;

CREATE TABLE `r_user_role` (
  `id` bigint(20) NOT NULL COMMENT '数据id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `r_user_role` */

insert  into `r_user_role`(`id`,`user_id`,`role_id`) values 
(1,1,1),
(2,2,1),
(3,2,2);

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `url` varchar(255) NOT NULL COMMENT 'URL',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `pid` bigint(11) NOT NULL COMMENT '父级id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '数据的更新时间',
  `state` tinyint(4) DEFAULT '0' COMMENT '1有效 0删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) DEFAULT '0' COMMENT '数据更新人  0系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`url`,`name`,`description`,`pid`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`) values 
(1,'/user/common','common',NULL,0,NULL,NULL,0,0,0),
(2,'/user/admin','admin',NULL,0,NULL,NULL,0,0,0);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`) values 
(1,'USER','2020-01-06 23:26:42','2020-01-06 23:26:42',1,0,0),
(2,'ADMIN','2020-01-06 23:26:42','2020-01-06 23:26:42',1,0,0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `username` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的创建时间',
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据的修改时间',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0删除',
  `creator` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据创建人  0系统',
  `updater` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据更新人  0系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`gmt_create`,`gmt_update`,`state`,`creator`,`updater`) values 
(1,'user','e10adc3949ba59abbe56e057f20f883e','2020-01-06 23:16:41','2020-01-06 23:16:41',1,0,0),
(2,'admin','e10adc3949ba59abbe56e057f20f883e','2020-01-06 23:16:41','2020-01-06 23:16:41',1,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
