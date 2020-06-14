DROP TABLE IF EXISTS `weatherdatalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weatherdatalog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(25) NOT NULL,
  `temperature` varchar(5) DEFAULT NULL,
  `cloudiness` varchar(20) DEFAULT NULL,
  `windspeed` varchar(4) DEFAULT NULL,
  `humidity` varchar(3) DEFAULT NULL,
  `pressure` varchar(4) DEFAULT NULL,
  `sunset` bigint DEFAULT NULL,
  `sunrise` bigint DEFAULT NULL,
  `temp_timestamp` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)