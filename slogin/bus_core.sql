/*
SQLyog - Free MySQL GUI v5.17
Host - 5.5.27 : Database - bus_core
*********************************************************************
Server version : 5.5.27
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `bus_core`;

USE `bus_core`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `data` */

DROP TABLE IF EXISTS `data`;

CREATE TABLE `data` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data` */

insert into `data` (`Username`,`Password`,`Role`) values ('Ansh','2345','clerk');
insert into `data` (`Username`,`Password`,`Role`) values ('dimpi','2341','clerk');
insert into `data` (`Username`,`Password`,`Role`) values ('Ishita','0987','admin');
insert into `data` (`Username`,`Password`,`Role`) values ('Palak','0123','admin');
insert into `data` (`Username`,`Password`,`Role`) values ('Poorvi','1230','clerk');
insert into `data` (`Username`,`Password`,`Role`) values ('priyanshi','3455','admin');
insert into `data` (`Username`,`Password`,`Role`) values ('Riya','2034','admin');
insert into `data` (`Username`,`Password`,`Role`) values ('Sanju','3456','clerk');
insert into `data` (`Username`,`Password`,`Role`) values ('Shini','7890','clerk');

/*Table structure for table `img` */

DROP TABLE IF EXISTS `img`;

CREATE TABLE `img` (
  `nm` varchar(20) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `img` */

insert into `img` (`nm`,`id`) values ('time','time.jpg');

/*Table structure for table `tables1` */

DROP TABLE IF EXISTS `tables1`;

CREATE TABLE `tables1` (
  `time` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tables1` */

insert into `tables1` (`time`,`source`,`destination`) values ('9:30 am','Kota','Jaipur');
insert into `tables1` (`time`,`source`,`destination`) values ('10:30 am','Jhalawar','Udaipur');
insert into `tables1` (`time`,`source`,`destination`) values ('10:30 am','Kota','Jaipur');
insert into `tables1` (`time`,`source`,`destination`) values ('9:50 am','Kota','Udaipur');
insert into `tables1` (`time`,`source`,`destination`) values ('11:50 am','Bundi','Ajmer');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `ticket_no` int(20) DEFAULT NULL,
  `ticket_price` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ticket` */

insert into `ticket` (`ticket_no`,`ticket_price`) values (12345,500);
insert into `ticket` (`ticket_no`,`ticket_price`) values (2345,500);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
