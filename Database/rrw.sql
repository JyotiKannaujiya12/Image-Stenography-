/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - rrw
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `rrw`;

USE `rrw`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `adminid` varchar(20) NOT NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`,`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`name`,`password`,`adminid`,`address`,`phone`,`email`) values (1,'admin','admin','admin','bangalore','9900917574','yogendragd@gmail.com');

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `img_id` int(11) NOT NULL auto_increment,
  `img_name` varchar(100) default NULL,
  `img_user` varchar(50) default NULL,
  PRIMARY KEY  (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

insert into `m_image` (`img_id`,`img_name`,`img_user`) values (1,'MARBLES.bmp','verma');

/*Table structure for table `m_secret` */

DROP TABLE IF EXISTS `m_secret`;

CREATE TABLE `m_secret` (
  `img_id` int(11) NOT NULL auto_increment,
  `img_name` varchar(100) default NULL,
  `img_user` varchar(50) default NULL,
  PRIMARY KEY  (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_secret` */

insert into `m_secret` (`img_id`,`img_name`,`img_user`) values (1,'6565hp logo.jpg','verma');

/*Table structure for table `m_trans` */

DROP TABLE IF EXISTS `m_trans`;

CREATE TABLE `m_trans` (
  `trans_id` int(5) NOT NULL auto_increment,
  `from_id` varchar(100) default NULL,
  `to_id` varchar(100) default NULL,
  `img_name` varchar(100) default NULL,
  `img_sub` varchar(200) default NULL,
  `date` varchar(25) default NULL,
  `time` varchar(25) default NULL,
  `day` varchar(25) default NULL,
  PRIMARY KEY  (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_trans` */

insert into `m_trans` (`trans_id`,`from_id`,`to_id`,`img_name`,`img_sub`,`date`,`time`,`day`) values (1,'verma','ram','verma-53748.bmp','hp image','23-05-2016','11:22:19','Monday');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `id` int(5) NOT NULL auto_increment,
  `userid` varchar(50) NOT NULL,
  `password` varchar(50) default NULL,
  `username` varchar(20) default NULL,
  `gender` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `phone` varchar(12) default NULL,
  PRIMARY KEY  (`id`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`id`,`userid`,`password`,`username`,`gender`,`address`,`city`,`email`,`phone`) values (16,'verma','verma','verma','Male','jay nagar','Bangalore','verma@gmail.com','9900917574');
insert into `m_user` (`id`,`userid`,`password`,`username`,`gender`,`address`,`city`,`email`,`phone`) values (17,'ram','ram','Ram','Male','ram','bangalore','ram@gmail.com','9900917574');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
