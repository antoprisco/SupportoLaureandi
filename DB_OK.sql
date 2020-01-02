CREATE DATABASE  IF NOT EXISTS `supportolaureandi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `supportolaureandi`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: supportolaureandi
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allegati`
--

DROP TABLE IF EXISTS `allegati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allegati` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `FILENAME` varchar(200) NOT NULL,
  `FK_USER` varchar(50) NOT NULL,
  `FK_REQCS` int(3) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USER` (`FK_USER`),
  KEY `FK_REQCS` (`FK_REQCS`),
  CONSTRAINT `request_ibfk_1111` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`),
  CONSTRAINT `request_ibfk_2222` FOREIGN KEY (`FK_REQCS`) REFERENCES `requestcs` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allegati`
--

LOCK TABLES `allegati` WRITE;
/*!40000 ALTER TABLE `allegati` DISABLE KEYS */;
INSERT INTO `allegati` VALUES (52,'C:\\Users\\Pietro\\SupportoLaureandi\\IscrizioneLentisco_Firmata.pdf','p.lentisco1@studenti.unisa.it',9),(53,'C:\\Users\\Pietro\\SupportoLaureandi\\DocumentoLentiscoPietro.pdf','p.lentisco1@studenti.unisa.it',9);
/*!40000 ALTER TABLE `allegati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attached`
--

DROP TABLE IF EXISTS `attached`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attached` (
  `ID_ATTACHED` int(20) NOT NULL AUTO_INCREMENT,
  `FILENAME` varchar(50) NOT NULL,
  `FK_REQUEST` int(20) NOT NULL,
  `FK_USER` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_ATTACHED`),
  KEY `FK_REQUEST` (`FK_REQUEST`),
  KEY `FK_USER` (`FK_USER`),
  CONSTRAINT `attached_ibfk_1` FOREIGN KEY (`FK_REQUEST`) REFERENCES `request` (`ID_REQUEST`),
  CONSTRAINT `attached_ibfk_2` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attached`
--

LOCK TABLES `attached` WRITE;
/*!40000 ALTER TABLE `attached` DISABLE KEYS */;
INSERT INTO `attached` VALUES (1,'certificato.pdf',1,'prova@unisa.it');
/*!40000 ALTER TABLE `attached` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi`
--

DROP TABLE IF EXISTS `corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corsi` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(30) NOT NULL,
  `SEMESTRE` int(1) NOT NULL,
  `CFU` int(2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi`
--

LOCK TABLES `corsi` WRITE;
/*!40000 ALTER TABLE `corsi` DISABLE KEYS */;
INSERT INTO `corsi` VALUES (1,'ALGORITMI AVANZATI',2,6),(9,'INTELLIGENZA ARTIFICIALE',1,6),(10,'BASI DI DATI II',1,6),(11,'CLOUD COMPUTING',1,6),(12,'COMPILATORI',2,6),(13,'COMPRESSIONE DATI',2,9),(14,'CYBERSECURITY',1,9),(15,'DIDATTICA DELL\'INFORMATICA',2,9),(16,'DIGITAL FORENCIS',2,9);
/*!40000 ALTER TABLE `corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ente`
--

DROP TABLE IF EXISTS `ente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ente` (
  `ID_ENTE` int(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(50) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `SITE` varchar(50) NOT NULL,
  `STATO` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_ENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ente`
--

LOCK TABLES `ente` WRITE;
/*!40000 ALTER TABLE `ente` DISABLE KEYS */;
INSERT INTO `ente` VALUES (1,'','Cambridge Assessment English','',1),(2,'','City and Guilds (Pitman)','',1),(3,'','Edexcel /Pearson Ltd','',1),(4,'','Educational Testing Service (ETS)','',1),(5,'','English Speaking Board (ESB)','',1),(6,'','International English Language Testing System (IELTS)','',1),(7,'emailTest@libero.it','Pearson - LCCI','',1),(8,'','Pearson - EDI','www.google.it',1),(9,'','Trinity College London (TCL)','',1),(10,'','Department of English, Faculty of Arts - University of Malta','',1),(11,'','NQAI - ACELS','',1),(12,'','Ascentis','',1),(13,'','AIM Awards','',1),(14,'','Learning Resource Network (LRN)','',1),(15,'','British Institutes','',1),(16,'','Gatehouse Awards Ltd','',1),(17,'','LanguageCert','',1);
/*!40000 ALTER TABLE `ente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestiscecs`
--

DROP TABLE IF EXISTS `gestiscecs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gestiscecs` (
  `FK_USER` varchar(50) NOT NULL,
  `FK_REQCS` int(3) NOT NULL,
  KEY `FK_USER` (`FK_USER`),
  KEY `FK_REQCS` (`FK_REQCS`),
  CONSTRAINT `request_ibfk_11` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`),
  CONSTRAINT `request_ibfk_22` FOREIGN KEY (`FK_REQCS`) REFERENCES `requestcs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestiscecs`
--

LOCK TABLES `gestiscecs` WRITE;
/*!40000 ALTER TABLE `gestiscecs` DISABLE KEYS */;
INSERT INTO `gestiscecs` VALUES ('p.lentisco1@studenti.unisa.it',9);
/*!40000 ALTER TABLE `gestiscecs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `include`
--

DROP TABLE IF EXISTS `include`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `include` (
  `FK_CORSI` int(50) NOT NULL,
  `FK_REQCS` int(3) NOT NULL,
  KEY `FK_CORSI` (`FK_CORSI`),
  KEY `FK_REQCS` (`FK_REQCS`),
  CONSTRAINT `request_ibfk_111` FOREIGN KEY (`FK_CORSI`) REFERENCES `corsi` (`ID`),
  CONSTRAINT `request_ibfk_222` FOREIGN KEY (`FK_REQCS`) REFERENCES `requestcs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `include`
--

LOCK TABLES `include` WRITE;
/*!40000 ALTER TABLE `include` DISABLE KEYS */;
/*!40000 ALTER TABLE `include` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `ID_REQUEST` int(20) NOT NULL AUTO_INCREMENT,
  `CERTIFICATE_SERIAL` varchar(50) NOT NULL,
  `LEVEL` varchar(7) NOT NULL,
  `RELEASE_DATE` date NOT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `YEAR` year(4) NOT NULL,
  `REQUESTED_CFU` tinyint(2) NOT NULL,
  `SERIAL` int(10) NOT NULL,
  `VALIDATED_CFU` tinyint(2) NOT NULL,
  `FK_USER` varchar(50) NOT NULL,
  `FK_CERTIFIER` int(20) NOT NULL,
  `FK_STATE` int(20) NOT NULL,
  PRIMARY KEY (`ID_REQUEST`),
  KEY `FK_USER` (`FK_USER`),
  KEY `FK_STATE` (`FK_STATE`),
  KEY `FK_CERTIFIER` (`FK_CERTIFIER`),
  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`),
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`FK_STATE`) REFERENCES `state` (`ID_STATE`),
  CONSTRAINT `request_ibfk_3` FOREIGN KEY (`FK_CERTIFIER`) REFERENCES `ente` (`ID_ENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'B.6.56546','A1','2017-05-25','2018-05-25',2018,3,512103579,6,'prova@unisa.it',7,3);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_ou`
--

DROP TABLE IF EXISTS `request_ou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_ou` (
  `FK_ID_SKILL` int(3) DEFAULT NULL,
  `FK_EMAIL` varchar(50) NOT NULL,
  `DATE_OF_BIRTH` varchar(20) NOT NULL,
  `CELL_NUMBER` varchar(12) NOT NULL,
  KEY `FK_EMAIL` (`FK_EMAIL`),
  KEY `FK_ID_SKILL` (`FK_ID_SKILL`),
  CONSTRAINT `RequestOu_ibfk_1` FOREIGN KEY (`FK_EMAIL`) REFERENCES `user` (`EMAIL`),
  CONSTRAINT `RequestOu_ibfk_2` FOREIGN KEY (`FK_ID_SKILL`) REFERENCES `skill` (`ID_SKILL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_ou`
--

LOCK TABLES `request_ou` WRITE;
/*!40000 ALTER TABLE `request_ou` DISABLE KEYS */;
INSERT INTO `request_ou` VALUES (11,'a.napoli94@studenti.unisa.it','1998-12-04','3333333333'),(11,'p.lentisco1@studenti.unisa.it','1994-10-10','3661044433'),(NULL,'p.lentisco1@studenti.unisa.it','1994-10-10','3661044433');
/*!40000 ALTER TABLE `request_ou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestcs`
--

DROP TABLE IF EXISTS `requestcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestcs` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `FK_STATE` int(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STATE` (`FK_STATE`),
  CONSTRAINT `request_ibfk_27` FOREIGN KEY (`FK_STATE`) REFERENCES `state` (`ID_STATE`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestcs`
--

LOCK TABLES `requestcs` WRITE;
/*!40000 ALTER TABLE `requestcs` DISABLE KEYS */;
INSERT INTO `requestcs` VALUES (9,'Pietro','Lentisco',1);
/*!40000 ALTER TABLE `requestcs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestlm`
--

DROP TABLE IF EXISTS `requestlm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestlm` (
  `id_req` int(20) NOT NULL AUTO_INCREMENT,
  `curriculum` varchar(50) NOT NULL,
  `anno` int(20) NOT NULL,
  `FK_USER` varchar(50) NOT NULL,
  PRIMARY KEY (`id_req`),
  KEY `FK_USER` (`FK_USER`),
  CONSTRAINT `requestlm_ibfk_1` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestlm`
--

LOCK TABLES `requestlm` WRITE;
/*!40000 ALTER TABLE `requestlm` DISABLE KEYS */;
INSERT INTO `requestlm` VALUES (120,'SICUREZZA INFORMATICA',2020,'p.lentisco1@studenti.unisa.it');
/*!40000 ALTER TABLE `requestlm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `ID_SKILL` int(3) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `TIPO` smallint(1) NOT NULL,
  `LIVELLO` varchar(2) NOT NULL,
  PRIMARY KEY (`ID_SKILL`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (11,'java',0,'a'); /*Il livello della skill è gestito con "a": alto,"m": medio, "b":basso*/
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `ID_STATE` int(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_STATE`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Parzialmente Completata'),(2,'In elaborazione dalla Segreteria'),(3,'In elaborazione dall&quot; Amministratore'),(4,'Accettata e In elaborazione dal Consiglio Didattico'),(5,'Rifiutata e In elaborazione dal Consiglio Didattico'),(6,'Conclusa e Accettata'),(7,'Conclusa e Rifiutata');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_attribute`
--

DROP TABLE IF EXISTS `system_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_attribute` (
  `SLUG` varchar(50) NOT NULL,
  `VALUE` varchar(100) NOT NULL,
  `FK_USER` varchar(50) NOT NULL,
  PRIMARY KEY (`SLUG`),
  KEY `FK_USER` (`FK_USER`),
  CONSTRAINT `system_attribute_ibfk_1` FOREIGN KEY (`FK_USER`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_attribute`
--

LOCK TABLES `system_attribute` WRITE;
/*!40000 ALTER TABLE `system_attribute` DISABLE KEYS */;
INSERT INTO `system_attribute` VALUES ('request-accepted','6','fferrucci@unisa.it'),('request-allowed-extension-upload','.pdf','fferrucci@unisa.it'),('request-matriculation-year-range','5','fferrucci@unisa.it'),('request-max-cfu','12','fferrucci@unisa.it'),('request-min-cfu','1','fferrucci@unisa.it'),('request-number-max-upload','2','fferrucci@unisa.it'),('request-partially-completed','1','fferrucci@unisa.it'),('request-refused','7','fferrucci@unisa.it'),('request-upload-path','//home//vale//newWorkspace//EV_EnglishValidation//uploads','fferrucci@unisa.it'),('request-working-admin','3','fferrucci@unisa.it'),('request-working-educational-advice-1','4','fferrucci@unisa.it'),('request-working-educational-advice-2','5','fferrucci@unisa.it'),('request-working-secretary','2','fferrucci@unisa.it');
/*!40000 ALTER TABLE `system_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `EMAIL` varchar(50) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `SURNAME` varchar(50) NOT NULL,
  `SEX` char(1) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `USER_TYPE` tinyint(1) NOT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('04wmljf0wy.@studenti.unisa.it','Giuseppe','Cirino','M','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b',0),('a.napoli94@studenti.unisa.it','Antonio','Napoli','M','77d5477c94bf3a33e53c6bb08ad720c7072b0fee',0),('fferrucci@unisa.it','Filomena','Ferrucci','F','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b',2),('s.avolicino@studenti.unisa.it','Simone','Avolicino','M','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b',0),('segreteria@unisa.it','Segreteria','Studenti','M','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b',1);
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

-- Dump completed on 2019-12-28 16:24:39
