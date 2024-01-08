CREATE DATABASE  IF NOT EXISTS `smart_warehouse` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smart_warehouse`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: smart_warehouse
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_client`
--

DROP TABLE IF EXISTS `tbl_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_client` (
  `client_code` char(6) NOT NULL,
  `client_name` varchar(50) DEFAULT NULL,
  `no` varchar(20) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `fax_no` varchar(10) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `register_person` varchar(20) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `update_person` varchar(20) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `client_status` int DEFAULT NULL,
  PRIMARY KEY (`client_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_client`
--

LOCK TABLES `tbl_client` WRITE;
/*!40000 ALTER TABLE `tbl_client` DISABLE KEYS */;
INSERT INTO `tbl_client` VALUES ('C0001','Kay Jay Agencies (Pvt) Ltd.','618','Aluthmawatha','Colomobo 15','infor@kayjay-group.com','0112456685','0114587650','Gihan','Hansaja','0766822918',NULL,'2021-09-28',NULL,'2021-10-08',1),('C0002','Happy Cook Lanka Pvt Ltd.','123/2','Main street','Galle',NULL,'011548647',NULL,'Sarath ','Kumara','0458795455',NULL,'2021-09-28',NULL,NULL,1),('C0003','brandix Lanka Ltd.','25','Rheinland Pl','Colombo 03','brandix_lanka@com','0114585647','0114727222','Palitha ','Perera','015478953',NULL,'2021-09-30',NULL,'2021-10-08',1),('C0004','American & Efird Lanka (Pvt) Ltd.','67','Avissawella Road, Welivita','Kaduwela','amarian&efird@export-group.com','0114546985','','Upali','Wijesinghe','070658658',NULL,'2021-10-08',NULL,'2021-10-08',1),('C0005','Akbar Brothers Export (Pvt) Ltd.','','','Wattala','','011554860','0112568742','Palitha','Perera','','Gihan Hansaja','2021-10-08',NULL,'2021-10-08',1),('C0006','Kay Jay Agencies (Pvt) Ltd.','618','Aluthmawatha','Colomobo 15','infor@kayjay-group.com','0702145698','0112456685','Gihan','Hansaja','0112458960',NULL,'2021-10-09','Gihan Hansaja','2021-10-09',1),('C0007','gihan','abc','163','Colombo','gihan@gmail.com','0556444555','','hansaja','','','Gihan Hansaja','2024-01-04',NULL,NULL,1);
/*!40000 ALTER TABLE `tbl_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_item`
--

DROP TABLE IF EXISTS `tbl_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `job_id` char(6) NOT NULL,
  `product_category` varchar(30) DEFAULT NULL,
  `product_details` varchar(200) DEFAULT NULL,
  `sq_ft_area` double DEFAULT NULL,
  `units` int DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `days` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_tbl_item_tbl_job1_idx` (`job_id`),
  CONSTRAINT `fk_tbl_item_tbl_job1` FOREIGN KEY (`job_id`) REFERENCES `tbl_job` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_item`
--

LOCK TABLES `tbl_item` WRITE;
/*!40000 ALTER TABLE `tbl_item` DISABLE KEYS */;
INSERT INTO `tbl_item` VALUES (1,'SW0001','Plastic','Plastic , Toy, Plastic',500,2,5000,'2021-10-01','2021-10-11',10,100000),(2,'SW0001','Glass','Black Glass, Transparent Glass',1000,2,10000,'2021-10-01','2021-10-31',30,600000),(3,'SW0002','Apparel','T-shart , Trousers',1000,2,10000,'2021-10-10','2021-10-31',21,420000),(4,'SW0002','Confectionary','Chocolate',500,3,5000,'2021-10-10','2021-10-15',5,75000),(5,'SW0004','Item 1','Plastic',500,1,5000,'2021-10-01','2021-10-06',5,25000),(6,'SW0004','Item 2','Glass',1000,1,10000,'2021-10-01','2021-10-06',5,50000),(7,'SW0004','Item 3','Apparel',500,1,5000,'2021-10-01','2021-10-05',4,20000),(8,'SW0005','Item 1','Plastic',500,2,5000,'2021-10-01','2021-10-03',2,20000),(9,'SW0005','Item 2','Glass',500,1,5000,'2021-10-01','2021-10-05',4,20000),(10,'SW0005','Item 3','Apparel',500,3,5000,'2021-10-01','2021-10-15',14,210000),(20,'SW0003','Item 1','Plastic',1000,2,10000,'2021-10-10','2021-10-15',5,100000),(21,'SW0003','Item 2','Confectionary',500,5,5000,'2021-10-10','2021-10-31',21,525000),(22,'SW0003','Item 3','Plastic',1000,2,10000,'2021-10-10','2021-10-15',5,100000),(25,'SW0006','Item 1','Apparel',1000,4,10000,'2021-10-10','2021-10-20',10,400000),(26,'SW0006','Item 2','Plastic',500,5,5000,'2021-10-10','2021-10-20',10,250000),(27,'SW0006','Item 3','Apparel',500,2,5000,'2021-10-10','2021-10-20',10,100000);
/*!40000 ALTER TABLE `tbl_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_job`
--

DROP TABLE IF EXISTS `tbl_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_job` (
  `job_id` char(6) NOT NULL,
  `client_code` char(6) NOT NULL,
  `job_date` date DEFAULT NULL,
  `billing_month` varchar(45) DEFAULT NULL,
  `tax_no` varchar(45) DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `net_val` double DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  `job_status` int DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `fk_tbl_bill_master_tbl_client1_idx` (`client_code`),
  CONSTRAINT `fk_tbl_bill_master_tbl_client1` FOREIGN KEY (`client_code`) REFERENCES `tbl_client` (`client_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_job`
--

LOCK TABLES `tbl_job` WRITE;
/*!40000 ALTER TABLE `tbl_job` DISABLE KEYS */;
INSERT INTO `tbl_job` VALUES ('SW0001','C0001','2021-10-01','2021-Octomber','1200-450',700000,20000,680000,NULL,1),('SW0002','C0002','2021-10-05','2021-Octomber','7669558-18',495000,5000,490000,NULL,1),('SW0003','C0003','2021-10-05','2020-October','0114568524',725000,5000,720000,'2021-10-03',0),('SW0004','C0003','2021-10-05','2021-Octomber','464646',95000,5000,90000,'2021-10-15',0),('SW0005','C0001','2021-10-05','2021-Octomber','0114585455',250000,10000,2490000,NULL,1),('SW0006','C0003','2021-10-10','2021-October','0112458960',750000,5000,745000,'2021-10-20',0);
/*!40000 ALTER TABLE `tbl_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `user_id` char(4) NOT NULL,
  `f_name` varchar(20) DEFAULT NULL,
  `l_name` varchar(20) DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `user_role` varchar(20) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES ('E001','Gihan','Hansaja','0702845960','gihan@admin.com','gihan','gihan123','Manager',1),('E002','Anjana','Dilshan','075646466','anjana@gmail.com','anjana','anjana123','Operator',1),('E004','Amisha','Dineth','074666666','amisha123@gmail.com','amisha','amisha123','Manager',1),('E005','Kasun','Sameera','0702845960','kasunsameera@gmail.com','kasun','kasun123','Operator',1);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-04 12:33:21
