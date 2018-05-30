/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - springbootdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootdemo`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `AREA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AREA_NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`AREA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `area` */

insert  into `area`(`AREA_ID`,`AREA_NAME`) values (1,'天南'),(2,'地北'),(3,'西荒'),(4,'东极');

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(128) DEFAULT NULL,
  `AUTHOR` varchar(20) DEFAULT NULL,
  `CONTEXT` varchar(20000) DEFAULT NULL,
  `PUBLISH_TIME` datetime DEFAULT NULL,
  `LAST_EDIT_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `OVERDUE_TIME` datetime DEFAULT NULL,
  `A_LEVEL` int(2) DEFAULT NULL,
  `A_CODE` varchar(64) DEFAULT NULL,
  `A_TYPE` int(2) DEFAULT NULL,
  `A_STATUS` int(2) DEFAULT NULL,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`AID`,`TITLE`,`AUTHOR`,`CONTEXT`,`PUBLISH_TIME`,`LAST_EDIT_TIME`,`OVERDUE_TIME`,`A_LEVEL`,`A_CODE`,`A_TYPE`,`A_STATUS`) values (1,'第一发','xxx','<p>天下无敌之超级猥琐之七上八下之风流之姆改流皮之我在干什么流炼金<br/></p>','2018-05-14 16:48:45','2018-05-21 14:33:32',NULL,1,'啊啊啊',1,2),(2,'第二发测试发文','xxx','<p>天下无敌之超级猥琐之七上八下之风流之姆改流皮之我在干什么流炼金<br/></p>','2018-05-14 17:12:02','2018-05-21 16:34:12',NULL,2,'第二发',1,2),(4,'第四发测试《改1》','xxx','<p><span style=\"font-size: 24px;\"></span></p><hr/><p><span style=\"font-size: 24px;\"></span></p><hr/><p><span style=\"font-size: 24px;\">第四发测</span><span style=\"font-size: 24px; text-decoration: line-through;\">试第四</span><strong><span style=\"font-size: 24px; text-decoration: line-through;\">发测试</span><span style=\"text-decoration: underline; font-size: 24px;\">第四发</span></strong><span style=\"color: rgb(255, 0, 0);\"><strong><span style=\"text-decoration: underline; font-size: 24px;\">测试</span></strong><span style=\"text-decoration: underline; font-size: 24px;\">第四</span><span style=\"background-color: rgb(184, 204, 228);\"><span style=\"background-color: rgb(184, 204, 228); text-decoration: underline; font-size: 24px;\">发测试第四</span>发测试第四</span>发测试第四发测</span>试第四发测试第四发测试<br/></p>','2018-05-21 17:11:20','2018-05-24 16:16:05',NULL,1,'测试',2,0);

/*Table structure for table `article_author` */

DROP TABLE IF EXISTS `article_author`;

CREATE TABLE `article_author` (
  `ARID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  KEY `ARID_FK` (`ARID`),
  KEY `FKey_UID` (`UID`),
  CONSTRAINT `ARID_FK` FOREIGN KEY (`ARID`) REFERENCES `article` (`AID`),
  CONSTRAINT `FKey_UID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_author` */

/*Table structure for table `article_code` */

DROP TABLE IF EXISTS `article_code`;

CREATE TABLE `article_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_NAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_code` */

/*Table structure for table `article_receiver` */

DROP TABLE IF EXISTS `article_receiver`;

CREATE TABLE `article_receiver` (
  `AID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  KEY `FK_AID` (`AID`),
  KEY `UID_FK` (`UID`),
  CONSTRAINT `FK_AID` FOREIGN KEY (`AID`) REFERENCES `article` (`AID`),
  CONSTRAINT `UID_FK` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_receiver` */

/*Table structure for table `article_records` */

DROP TABLE IF EXISTS `article_records`;

CREATE TABLE `article_records` (
  `ARID` int(11) NOT NULL AUTO_INCREMENT,
  `AID` int(11) DEFAULT NULL,
  `TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ARID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_records` */

/*Table structure for table `canteen_completed` */

DROP TABLE IF EXISTS `canteen_completed`;

CREATE TABLE `canteen_completed` (
  `CCID` int(11) NOT NULL AUTO_INCREMENT,
  `COID` int(11) DEFAULT NULL,
  `BREAKFAST` int(2) DEFAULT NULL,
  `LUNCH` int(2) DEFAULT NULL,
  `DINNER` int(2) DEFAULT NULL,
  `INPUT_TIME` datetime DEFAULT NULL,
  `FINISH_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CCID`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `canteen_completed` */

insert  into `canteen_completed`(`CCID`,`COID`,`BREAKFAST`,`LUNCH`,`DINNER`,`INPUT_TIME`,`FINISH_TIME`) values (55,55,NULL,NULL,NULL,'2018-05-30 11:01:06',NULL),(56,56,NULL,NULL,NULL,'2018-05-30 11:01:06',NULL),(57,57,NULL,NULL,NULL,'2018-05-30 11:01:06',NULL),(58,58,NULL,NULL,NULL,'2018-05-30 11:01:06',NULL),(59,59,NULL,NULL,NULL,'2018-05-30 11:01:06',NULL);

/*Table structure for table `canteen_food` */

DROP TABLE IF EXISTS `canteen_food`;

CREATE TABLE `canteen_food` (
  `FID` int(11) NOT NULL AUTO_INCREMENT,
  `FOOD_NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `canteen_food` */

/*Table structure for table `canteen_menu` */

DROP TABLE IF EXISTS `canteen_menu`;

CREATE TABLE `canteen_menu` (
  `CMID` int(11) NOT NULL AUTO_INCREMENT,
  `SUN` varchar(64) DEFAULT NULL,
  `MON` varchar(64) DEFAULT NULL,
  `TUE` varchar(64) DEFAULT NULL,
  `WED` varchar(64) DEFAULT NULL,
  `THU` varchar(64) DEFAULT NULL,
  `FRI` varchar(64) DEFAULT NULL,
  `SAT` varchar(64) DEFAULT NULL,
  `CM_TYPE` int(2) DEFAULT NULL,
  PRIMARY KEY (`CMID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `canteen_menu` */

/*Table structure for table `canteen_order` */

DROP TABLE IF EXISTS `canteen_order`;

CREATE TABLE `canteen_order` (
  `COID` int(11) NOT NULL AUTO_INCREMENT,
  `BREAKFAST` int(2) DEFAULT NULL,
  `BF_MANY` int(2) DEFAULT NULL,
  `LUNCH` int(2) DEFAULT NULL,
  `L_MANY` int(2) DEFAULT NULL,
  `DINNER` int(2) DEFAULT NULL,
  `D_MANY` int(2) DEFAULT NULL,
  `O_TIME` date DEFAULT NULL,
  `O_CRT_TIME` datetime DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  PRIMARY KEY (`COID`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `canteen_order` */

insert  into `canteen_order`(`COID`,`BREAKFAST`,`BF_MANY`,`LUNCH`,`L_MANY`,`DINNER`,`D_MANY`,`O_TIME`,`O_CRT_TIME`,`UID`) values (55,1,1,1,1,0,1,'2018-06-04','2018-05-30 11:01:06',7),(56,1,1,1,1,0,1,'2018-06-05','2018-05-30 11:01:06',7),(57,1,1,1,1,0,1,'2018-06-06','2018-05-30 11:01:06',7),(58,1,1,1,1,0,1,'2018-06-07','2018-05-30 11:01:06',7),(59,1,1,1,1,0,1,'2018-06-08','2018-05-30 11:01:06',7);

/*Table structure for table `canteen_records` */

DROP TABLE IF EXISTS `canteen_records`;

CREATE TABLE `canteen_records` (
  `CRID` int(11) NOT NULL AUTO_INCREMENT,
  `COID` int(11) DEFAULT NULL,
  `CCID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `CR_EDT_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CR_CRT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`CRID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `canteen_records` */

insert  into `canteen_records`(`CRID`,`COID`,`CCID`,`UID`,`CR_EDT_TIME`,`CR_CRT_TIME`) values (11,55,55,7,'2018-05-30 11:01:13','2018-05-30 11:01:06'),(12,56,56,7,'2018-05-30 11:01:13','2018-05-30 11:01:06'),(13,57,57,7,'2018-05-30 11:01:13','2018-05-30 11:01:06'),(14,58,58,7,'2018-05-30 11:01:13','2018-05-30 11:01:06'),(15,59,59,7,'2018-05-30 11:01:13','2018-05-30 11:01:06');

/*Table structure for table `canteen_statistics` */

DROP TABLE IF EXISTS `canteen_statistics`;

CREATE TABLE `canteen_statistics` (
  `CSID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `COUNT_U_CONPLETE` int(5) DEFAULT NULL,
  `COUNT_U_ORDER` int(5) DEFAULT NULL,
  `COUNT_CPL_BF` int(5) DEFAULT NULL,
  `COUNT_CPL_L` int(5) DEFAULT NULL,
  `COUNT_CPL_D` int(5) DEFAULT NULL,
  `CS_DATE` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `canteen_statistics` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `DID` int(11) NOT NULL AUTO_INCREMENT,
  `D_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`DID`,`D_NAME`) values (1,'休门'),(2,'生门'),(3,'伤门'),(4,'杜门'),(5,'景门'),(6,'死门'),(7,'惊门'),(8,'开门');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM_TYPE` int(2) DEFAULT NULL,
  `ITEM_NAME` varchar(64) DEFAULT NULL,
  `MODEL_NUMBER` varchar(64) DEFAULT NULL,
  `SERVICE_NUMBER` varchar(64) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `ITEM_CODE` varchar(64) DEFAULT NULL,
  `KEEPER` int(11) DEFAULT NULL,
  `STORAGE_POSITION` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item` */

/*Table structure for table `item_apply` */

DROP TABLE IF EXISTS `item_apply`;

CREATE TABLE `item_apply` (
  `IAID` int(11) DEFAULT NULL,
  `APPLY_ITEM_TYPE` int(2) DEFAULT NULL,
  `APPLY_ITEM_NAME` varchar(64) DEFAULT NULL,
  `APPLY_ITEM_QUANTITY` int(4) DEFAULT NULL,
  `APPLY_INFO` varchar(1000) DEFAULT NULL,
  `PROPOSER` int(11) DEFAULT NULL,
  `APPLY_TIME` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_apply` */

/*Table structure for table `item_apply_records` */

DROP TABLE IF EXISTS `item_apply_records`;

CREATE TABLE `item_apply_records` (
  `ARID` int(11) NOT NULL AUTO_INCREMENT,
  `IAID` int(11) DEFAULT NULL,
  `APPLY_STATUS` int(2) DEFAULT NULL,
  `AUDITOR` int(11) DEFAULT NULL,
  `AUDITOR_CONFIRM` int(2) DEFAULT NULL,
  `APPLY_ITEM` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`ARID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_apply_records` */

/*Table structure for table `item_records` */

DROP TABLE IF EXISTS `item_records`;

CREATE TABLE `item_records` (
  `IRID` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM_ID` int(11) DEFAULT NULL,
  `ACTION` int(2) DEFAULT NULL,
  `EXECUTER` int(11) DEFAULT NULL,
  `IA_ID` int(11) DEFAULT NULL,
  `IR_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`IRID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_records` */

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `MID` int(11) NOT NULL AUTO_INCREMENT,
  `MODULENAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `module` */

insert  into `module`(`MID`,`MODULENAME`) values (1,'add'),(2,'delete'),(3,'update'),(4,'query');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `RID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLENAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`RID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`RID`,`ROLENAME`) values (1,'admin'),(2,'customer');

/*Table structure for table `role_module` */

DROP TABLE IF EXISTS `role_module`;

CREATE TABLE `role_module` (
  `RID` int(11) DEFAULT NULL,
  `MID` int(11) DEFAULT NULL,
  KEY `M_FK` (`MID`),
  KEY `FK_R` (`RID`),
  CONSTRAINT `FK_R` FOREIGN KEY (`RID`) REFERENCES `role` (`RID`),
  CONSTRAINT `M_FK` FOREIGN KEY (`MID`) REFERENCES `module` (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_module` */

insert  into `role_module`(`RID`,`MID`) values (1,1),(1,2),(1,3),(1,4),(2,4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `NICKNAME` varchar(64) DEFAULT NULL,
  `POSITION` varchar(64) DEFAULT NULL,
  `AREA` varchar(32) DEFAULT NULL,
  `DEPARTMENT` varchar(32) DEFAULT NULL,
  `TEL` varchar(32) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `REGISTER_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`UID`,`USERNAME`,`PASSWORD`,`NICKNAME`,`POSITION`,`AREA`,`DEPARTMENT`,`TEL`,`PHONE`,`EMAIL`,`REGISTER_TIME`) values (6,'person1','7188830057a0a9e5c10434500f042d9a',NULL,NULL,NULL,NULL,NULL,NULL,'person1@person1.com',NULL),(7,'xxx','d8fcc5628b9074112af5900c4e4979f9','hu','mid','地北','伤门','2054878','15966668888','xxx@xxx.com','2018-05-10 15:48:31'),(8,'uuu','a90233ff9a1e911a480793a53fef9cd9',NULL,NULL,NULL,NULL,NULL,NULL,'uuu@uuu.com','2018-05-25 16:04:28');

/*Table structure for table `user_department` */

DROP TABLE IF EXISTS `user_department`;

CREATE TABLE `user_department` (
  `UID` int(11) DEFAULT NULL,
  `DID` int(11) DEFAULT NULL,
  KEY `FRK_UID` (`UID`),
  KEY `FK_DID` (`DID`),
  CONSTRAINT `FK_DID` FOREIGN KEY (`DID`) REFERENCES `department` (`DID`),
  CONSTRAINT `FRK_UID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_department` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `UID` int(11) DEFAULT NULL,
  `RID` int(11) DEFAULT NULL,
  KEY `R_FK` (`RID`),
  KEY `U_FK` (`UID`),
  CONSTRAINT `R_FK` FOREIGN KEY (`RID`) REFERENCES `role` (`RID`),
  CONSTRAINT `U_FK` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`UID`,`RID`) values (6,2),(7,2);

/* Trigger structure for table `canteen_completed` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `CCwhenCreated` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `CCwhenCreated` AFTER INSERT ON `canteen_completed` FOR EACH ROW BEGIN
	update `springbootdemo`.`canteen_records` set `CCID` = new.CCID where `COID` = new.COID;
    END */$$


DELIMITER ;

/* Trigger structure for table `canteen_order` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `COwhenCreated` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `COwhenCreated` AFTER INSERT ON `canteen_order` FOR EACH ROW BEGIN
    	INSERT INTO `springbootdemo`.`canteen_records` (`COID`,`CCID`,`UID`,`CR_CRT_TIME`) VALUE (new.COID,NULL,new.UID,new.O_CRT_TIME);
	INSERT INTO `springbootdemo`.`canteen_completed` (`COID`,`BREAKFAST`,`LUNCH`,`DINNER`,`INPUT_TIME`,`FINISH_TIME`) VALUE (new.COID,NULL,NULL,NULL,new.O_CRT_TIME,null);
    END */$$


DELIMITER ;

/* Trigger structure for table `canteen_order` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `COwhenDelete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `COwhenDelete` AFTER DELETE ON `canteen_order` FOR EACH ROW BEGIN
	delete from canteen_completed where COID = old.COID;
	DELETE FROM canteen_records WHERE COID = old.COID;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
