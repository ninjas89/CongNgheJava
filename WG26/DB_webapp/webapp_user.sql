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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `EMAIL` varchar(50) NOT NULL,
  `HO` varchar(5) NOT NULL,
  `TEN` varchar(10) NOT NULL,
  `NGAYTAO` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `GIOITINH` varchar(11) NOT NULL,
  `SOTIEN` int NOT NULL DEFAULT '0',
  `TOKEN` varchar(60) NOT NULL,
  `MATKHAU` varchar(70) NOT NULL,
  `ROLE` varchar(11) NOT NULL DEFAULT 'User',
  `SDT` varchar(12) NOT NULL,
  `URL` varchar(500) NOT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1890sjlanrh@gmail.com','Lý','Khoa','2021-05-16 00:00:00','Nam',500000,'1ce927f875864094e3906a4a0b5ece68','$2y$10$oCPmRvHHQG8Zj0rnmnmkWuXw112GtakAxRvL4MQOz9lo7YjTC0lG2','User','0120356916',''),('admin@gmail.com','Mai','Văn Mạnh','2021-05-16 00:00:00','Nam',0,'c3e878e27f52e2a57ace4d9a76fd9acf','$2y$10$txdoH/Ji3Kc0Dfch99xob.laemoDvOM9DdggCH.t4qXKyPO0tZcve','Admin','0867412624',''),('developer@gmail.com','Hồ','Đức','2021-05-16 00:00:00','Nữ',464000,'98dce83da57b0395e163467c9dae521b','$2y$10$31ND9QPalvleN0LpMdNZVuw2NewWXX.M3rX2bwJ1C0I7wma36D/zO','Developer','0969433943',''),('developer1@gmail.com','Chí','Cường','2001-06-19 00:00:00','Nam',50000,'e2ef524fbf3d9fe611d5a8e90fefdc9c','$2y$10$upLCVFXfgy5IWvzM4fGhwujAzISh2kA0jB.Kk.loHU0KVSzNAouhe','Developer','0785641286','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-18  0:47:45
