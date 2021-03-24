/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.14 : Database - document-flow
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`file_flow` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `file_flow`;

/*Table structure for table `doc_documents` */

DROP TABLE IF EXISTS `doc_documents`;

CREATE TABLE `doc_documents` (
  `document_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '文档id',
  `project_id` int(5) DEFAULT NULL COMMENT '项目id',
  `folder_id` int(5) DEFAULT NULL COMMENT '文件夹id',
  `document_type` int(2) NOT NULL COMMENT '文档类型(1:项目文档 2:公共文档 3:临时文档)',
  `document_name` varchar(30) NOT NULL COMMENT '文档名称',
  `image_url` varchar(255) NOT NULL COMMENT '文档图片地址',
  `document_url` varchar(255) NOT NULL COMMENT '文档下载地址',
  `upload_time` datetime NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='文档信息';

/*Data for the table `doc_documents` */

/*Table structure for table `doc_folders` */

DROP TABLE IF EXISTS `doc_folders`;

CREATE TABLE `doc_folders` (
  `folder_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '文件夹id',
  `folder_name` varchar(20) NOT NULL COMMENT '文件夹名称',
  PRIMARY KEY (`folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `doc_folders` */

/*Table structure for table `doc_projects` */

DROP TABLE IF EXISTS `doc_projects`;

CREATE TABLE `doc_projects` (
  `project_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `project_code` varchar(20) NOT NULL COMMENT '项目编号',
  `project_name` varchar(255) NOT NULL COMMENT '项目名称',
  `path` varchar(255) NOT NULL COMMENT '访问地址',
  `group_id` bigint(20) NOT NULL COMMENT '负责项目的组id',
  `group_name` varchar(20) NOT NULL COMMENT '负责项目的组名称',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='项目信息';

/*Data for the table `doc_projects` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(12) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `enabled` bit(1) NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_name`,`password`,`enabled`) values 
(1,'admin','$2a$10$FGji0e60qDl8Ba9OShZG9.FiS83StMljnM6ohSRTZCJXjaLyXQ4a.','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
