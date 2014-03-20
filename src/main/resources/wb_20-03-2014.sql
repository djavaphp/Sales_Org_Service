/*
SQLyog Community v8.4 RC2
MySQL - 5.5.12 : Database - wb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `wb`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) DEFAULT NULL,
  `company_address` varchar(100) DEFAULT NULL,
  `company_phoneno` varchar(20) DEFAULT NULL,
  `company_mobileno` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `item_master` */

DROP TABLE IF EXISTS `item_master`;

CREATE TABLE `item_master` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(20) DEFAULT NULL,
  `item_name` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Table structure for table `map_sales_item` */

DROP TABLE IF EXISTS `map_sales_item`;

CREATE TABLE `map_sales_item` (
  `map_sale_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(20) DEFAULT NULL,
  `item_name` varchar(200) DEFAULT NULL,
  `item_qty` int(20) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `sales_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`map_sale_item_id`),
  KEY `FK_map_sales_item` (`sales_id`),
  CONSTRAINT `FK_map_sales_item` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`sales_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `mst_area` */

DROP TABLE IF EXISTS `mst_area`;

CREATE TABLE `mst_area` (
  `mst_area_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mst_area_code` varchar(20) DEFAULT NULL,
  `mst_area_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`mst_area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `mst_bill_book` */

DROP TABLE IF EXISTS `mst_bill_book`;

CREATE TABLE `mst_bill_book` (
  `bill_book_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `bill_book_number` varchar(10) DEFAULT NULL,
  `start_range` varchar(20) DEFAULT NULL,
  `end_range` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bill_book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `mst_employee` */

DROP TABLE IF EXISTS `mst_employee`;

CREATE TABLE `mst_employee` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `password` varchar(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `emp_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `retailer_master` */

DROP TABLE IF EXISTS `retailer_master`;

CREATE TABLE `retailer_master` (
  `retailer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `retailer_name` varchar(50) DEFAULT NULL,
  `shop_name` varchar(50) DEFAULT NULL,
  `shop_address` varchar(200) DEFAULT NULL,
  `shop_phone_number` varchar(15) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`retailer_id`),
  KEY `FK_retailer_master_area_id` (`area_id`),
  CONSTRAINT `FK_retailer_master_area_id` FOREIGN KEY (`area_id`) REFERENCES `mst_area` (`mst_area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `sales_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_id` bigint(20) DEFAULT NULL,
  `area_name` varchar(200) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`sales_id`),
  KEY `FK_sales` (`emp_id`),
  CONSTRAINT `FK_sales` FOREIGN KEY (`emp_id`) REFERENCES `mst_employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
