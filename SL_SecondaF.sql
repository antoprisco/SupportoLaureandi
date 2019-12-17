DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE skill (
ID_SKILL int(3) auto_increment,
NOME varchar(50) not null,
TIPO int(20) not null,
LIVELLO varchar(5) not null,
PRIMARY KEY(`ID_SKILL`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (11,'java',1,'A2');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Request_Ou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE Request_Ou (
FK_SKILL int(3) not null,
FK_USER varchar(50) not null,
KEY `FK_USER` (`FK_USER`),
KEY `FK_SKILL` (`FK_SKILL`),
CONSTRAINT `RequestOu_ibfk_1` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`),
CONSTRAINT `RequestOu_ibfk_2` FOREIGN KEY (`FK_SKILL`) REFERENCES `skill` (`ID_SKILL`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `request_Ou` WRITE;
/*!40000 ALTER TABLE `Request_Ou` DISABLE KEYS */;
INSERT INTO `Request_Ou` VALUES (11,'a.napoli94@studenti.unisa.it');
/*!40000 ALTER TABLE `Request_Ou` ENABLE KEYS */;
UNLOCK TABLES;