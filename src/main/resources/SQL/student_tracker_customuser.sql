-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: student_tracker
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `customuser`
--

DROP TABLE IF EXISTS `customuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customuser` (
  `id` bigint(15) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `active` int DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customuser`
--

LOCK TABLES `customuser` WRITE;
/*!40000 ALTER TABLE `customuser` DISABLE KEYS */;
INSERT INTO `customuser` VALUES (000000000000001,'ashik','$2a$10$widDJPFjZDN5wNRZ31kRZungK6iM0jXtoMVj7erEs1CAE/5htFhAa',1,NULL,NULL,NULL),(000000000000002,'rahim','$2a$10$widDJPFjZDN5wNRZ31kRZungK6iM0jXtoMVj7erEs1CAE/5htFhAa',1,NULL,NULL,NULL),(000000000000003,'karim','$2a$10$widDJPFjZDN5wNRZ31kRZungK6iM0jXtoMVj7erEs1CAE/5htFhAa',1,NULL,NULL,NULL),(000000000000004,'ashik_ali','$2a$10$QgMUJ7M8VnpkL9BaniKltum/VuCHA/kknAIix9G2CstFlbeQxEDae',1,'Md. Ashik Ali','Khan','khan.ashik@gmail.com'),(000000000000005,'iftekhar','$2a$10$IDavtBqYOkQ6xFgSj3HxzukH7tnkfcMKZpM44gZ28E4ye4S09FLnK',1,'Iftekhar Mahmud','Fuad','iftekhar.mahmud@gmail.com'),(000000000000006,'sabbir_hossain','$2a$10$jG6bF2FnVNMsZWaG05Dd7.HIjr4XZe83ovYDPBqMozzRZ0pRyOnny',1,'Sabbir','Hossain','abc@def.com');
/*!40000 ALTER TABLE `customuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-17 17:26:25