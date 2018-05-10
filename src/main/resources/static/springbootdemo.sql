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

/*Table structure for table `Module` */

DROP TABLE IF EXISTS `Module`;

CREATE TABLE `Module` (
  `MID` int(11) NOT NULL AUTO_INCREMENT,
  `MODULENAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `Module` */

insert  into `Module`(`MID`,`MODULENAME`) values (1,'add'),(2,'delete'),(3,'update'),(4,'query');

/*Table structure for table `Role` */

DROP TABLE IF EXISTS `Role`;

CREATE TABLE `Role` (
  `RID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLENAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`RID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `Role` */

insert  into `Role`(`RID`,`ROLENAME`) values (1,'admin'),(2,'customer');

/*Table structure for table `Role-Module` */

DROP TABLE IF EXISTS `Role-Module`;

CREATE TABLE `Role-Module` (
  `RID` int(11) DEFAULT NULL,
  `MID` int(11) DEFAULT NULL,
  KEY `M_FK` (`MID`),
  KEY `FK_R` (`RID`),
  CONSTRAINT `FK_R` FOREIGN KEY (`RID`) REFERENCES `Role` (`RID`),
  CONSTRAINT `M_FK` FOREIGN KEY (`MID`) REFERENCES `Module` (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `Role-Module` */

insert  into `Role-Module`(`RID`,`MID`) values (1,1),(1,2),(1,3),(1,4),(2,4);

/*Table structure for table `User` */

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `AREA` varchar(32) DEFAULT NULL,
  `DEPARTMENT` varchar(32) DEFAULT NULL,
  `TEL` varchar(32) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `E-MAIL` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `User` */

/*Table structure for table `User-Role` */

DROP TABLE IF EXISTS `User-Role`;

CREATE TABLE `User-Role` (
  `UID` int(11) DEFAULT NULL,
  `RID` int(11) DEFAULT NULL,
  KEY `R_FK` (`RID`),
  KEY `U_FK` (`UID`),
  CONSTRAINT `R_FK` FOREIGN KEY (`RID`) REFERENCES `Role` (`RID`),
  CONSTRAINT `U_FK` FOREIGN KEY (`UID`) REFERENCES `User` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `User-Role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
