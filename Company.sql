-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(128) NOT NULL,
  `company_address` varchar(128) NOT NULL,
  `company_type` varchar(128) NOT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'CMC','XYZ','Social',_binary '',_binary '\0'),(2,'CCCCC','13131','Global',_binary '',_binary '\0'),(3,'CCCCC','13131','Global',NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `first_name` varchar(128) NOT NULL,
  `surname` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `user_password` varchar(128) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `is_deleted` bit(1) DEFAULT b'0',
  `role_name` varchar(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'Minh','Pham','phamdaiminh0603@gmail.com','admin','$2y$12$ZiI.YykRXdSQ39QY4yAzfenJptydxkMwpWooNRcGPNWO1XYIEOfyi',_binary '',_binary '\0','ADMIN'),(2,1,'Thuan','Nguyen','thuan@123.com','abc','12345',_binary '',_binary '','USER'),(3,2,'Toan','Luong','Toan@123.com','xyx','12345',_binary '',_binary '\0','USER'),(4,1,'Long','Nguyen','avavava','TEST','13131',_binary '',_binary '\0','USER'),(5,1,'AAAAA','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(6,1,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(7,1,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(8,1,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(9,1,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '','USER'),(10,2,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(11,2,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(12,2,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(13,2,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(14,2,'CCCCC','BBBB','avavava','TEST','13131',_binary '',_binary '\0','USER'),(15,NULL,'111','222','1111','','1111111',_binary '',_binary '\0','USER'),(16,NULL,'111','222','1111','','1111111',_binary '',_binary '\0','USER');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `role_permission_id` varchar(128) NOT NULL,
  `role_name` varchar(10) NOT NULL,
  `permission_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES ('1','ADMIN','USER_CREATE'),('2','ADMIN','USER_UPDATE'),('3','ADMIN','USER_DELETE'),('4','ADMIN','USER_READ'),('4','USER','USER_READ');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_token`
--

DROP TABLE IF EXISTS `t_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_token` (
  `token_id` varchar(128) NOT NULL,
  `employee_id` varchar(128) NOT NULL,
  `access_token` varchar(1000) NOT NULL,
  `register_timestamp` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_token`
--

LOCK TABLES `t_token` WRITE;
/*!40000 ALTER TABLE `t_token` DISABLE KEYS */;
INSERT INTO `t_token` VALUES ('32fbe512-9f81-4804-83d2-23fda9dbe63d','1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTkxMjMyNDgsInVzZXIiOnsidXNlclBhc3N3b3JkIjoiJDJ5JDEyJFppSS5ZeWtSWGRTUTM5UVk0eUF6ZmVuSnB0eWR4a013cFdvb05SY0dQTldPMVhZSUVPZnlpIiwiY29tcGFueUlkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwidXNlcklkIjoxLCJhdXRob3JpdGllcyI6WyJVU0VSX0RFTEVURSIsIlVTRVJfQ1JFQVRFIiwiVVNFUl9VUERBVEUiLCJBRE1JTiIsIlVTRVJfUkVBRCJdfX0.acuZoVFy22Loc6RnpdCuiGagxF_iYnrB3mAlKtggDw8',1599123248640);
/*!40000 ALTER TABLE `t_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 17:00:50
