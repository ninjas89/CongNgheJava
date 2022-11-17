-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: webapp
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `history_app`
--

DROP TABLE IF EXISTS `history_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_app` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(70) NOT NULL,
  `TENAPP` varchar(70) NOT NULL,
  `EMAILDEV` varchar(70) NOT NULL,
  `GIA` int NOT NULL,
  `TINHTRANGTAI` varchar(11) NOT NULL DEFAULT '0',
  `LOAI` varchar(11) NOT NULL,
  `NGAYMUA` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_app`
--

LOCK TABLES `history_app` WRITE;
/*!40000 ALTER TABLE `history_app` DISABLE KEYS */;
INSERT INTO `history_app` VALUES (1,'developer@gmail.com','Hades','developer@gmail.com',200000,'0','game','2021-05-18 00:00:00'),(2,'developer@gmail.com','Human, Fall, Flat','developer@gmail.com',198000,'0','game','2021-05-18 00:00:00'),(3,'nhoxkhoaimon123@gmail.com','Resident Evil 7 Biohazard','developer@gmail.com',398000,'0','game','2021-05-18 00:00:00'),(4,'nhoxkhoaimon123@gmail.com','Stardew Valley','developer@gmail.com',165000,'1','game','2021-05-18 00:00:00'),(5,'nhoxkhoaimon123@gmail.com','Hades','developer@gmail.com',200000,'0','game','2021-05-18 00:00:00');
/*!40000 ALTER TABLE `history_app` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-18  0:47:44
