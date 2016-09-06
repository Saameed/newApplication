-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: grp
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `authkey`
--

DROP TABLE IF EXISTS `authkey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authkey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authkey`
--

LOCK TABLES `authkey` WRITE;
/*!40000 ALTER TABLE `authkey` DISABLE KEYS */;
/*!40000 ALTER TABLE `authkey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `status` tinyblob,
  `group_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c7dm5ttsjn6mvxieuelnv794h` (`group_id`),
  KEY `FK_tok7rip026jr8b5lkolmwfum3` (`lesson_id`),
  CONSTRAINT `FK_c7dm5ttsjn6mvxieuelnv794h` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_tok7rip026jr8b5lkolmwfum3` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exampoint`
--

DROP TABLE IF EXISTS `exampoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exampoint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `afterPoint` int(11) DEFAULT NULL,
  `beforePoint` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `sumPoint` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2j69f8mi06rcq1bxee6kxguym` (`lesson_id`),
  KEY `FK_b01jxsi1bly25eopi7iatnyj4` (`student_id`),
  CONSTRAINT `FK_2j69f8mi06rcq1bxee6kxguym` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FK_b01jxsi1bly25eopi7iatnyj4` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exampoint`
--

LOCK TABLES `exampoint` WRITE;
/*!40000 ALTER TABLE `exampoint` DISABLE KEYS */;
/*!40000 ALTER TABLE `exampoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examstatus`
--

DROP TABLE IF EXISTS `examstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examstatus`
--

LOCK TABLES `examstatus` WRITE;
/*!40000 ALTER TABLE `examstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `examstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finalgroup`
--

DROP TABLE IF EXISTS `finalgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finalgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `final_point` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_he7rwv9gfj889vkhlf2vmaqgp` (`group_id`),
  CONSTRAINT `FK_he7rwv9gfj889vkhlf2vmaqgp` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finalgroup`
--

LOCK TABLES `finalgroup` WRITE;
/*!40000 ALTER TABLE `finalgroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `finalgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `speciality_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3se75c5c0ybb19da5e96kjrhs` (`speciality_id`),
  CONSTRAINT `FK_3se75c5c0ybb19da5e96kjrhs` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `doc_path` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hcdbkoyt806aly9wlxd971uuv` (`group_id`),
  KEY `FK_rombsyb9e4ewx5tx97dl4m0j2` (`lesson_id`),
  CONSTRAINT `FK_hcdbkoyt806aly9wlxd971uuv` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_rombsyb9e4ewx5tx97dl4m0j2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory`
--

LOCK TABLES `laboratory` WRITE;
/*!40000 ALTER TABLE `laboratory` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `speciality` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c8ojobutymi9i01q4fwqntfsb` (`group_id`),
  KEY `FK_b2nlmlusfb9q821x5trm9dvot` (`speciality`),
  CONSTRAINT `FK_b2nlmlusfb9q821x5trm9dvot` FOREIGN KEY (`speciality`) REFERENCES `speciality` (`id`),
  CONSTRAINT `FK_c8ojobutymi9i01q4fwqntfsb` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitoring`
--

DROP TABLE IF EXISTS `monitoring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitoring` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f336hg2y0vly7aijd6t0ft0eb` (`group_id`),
  KEY `FK_evduf21yghkagqek7dtvi0osh` (`lesson_id`),
  CONSTRAINT `FK_evduf21yghkagqek7dtvi0osh` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FK_f336hg2y0vly7aijd6t0ft0eb` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitoring`
--

LOCK TABLES `monitoring` WRITE;
/*!40000 ALTER TABLE `monitoring` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitoring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitoringpoint`
--

DROP TABLE IF EXISTS `monitoringpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitoringpoint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p3mkxxtjlgnpcl3xspap3h80r` (`lesson_id`),
  KEY `FK_9rx4aoegsut1mqrnasj0t6egb` (`student_id`),
  CONSTRAINT `FK_9rx4aoegsut1mqrnasj0t6egb` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_p3mkxxtjlgnpcl3xspap3h80r` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitoringpoint`
--

LOCK TABLES `monitoringpoint` WRITE;
/*!40000 ALTER TABLE `monitoringpoint` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitoringpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `points`
--

DROP TABLE IF EXISTS `points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `points` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `sub_lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_le589pnmn7c6sen0c9t6ehfgs` (`student_id`),
  KEY `FK_1vc6cd3318cp91lbx9atuq9q5` (`sub_lesson_id`),
  CONSTRAINT `FK_1vc6cd3318cp91lbx9atuq9q5` FOREIGN KEY (`sub_lesson_id`) REFERENCES `sub_lesson` (`id`),
  CONSTRAINT `FK_le589pnmn7c6sen0c9t6ehfgs` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `points`
--

LOCK TABLES `points` WRITE;
/*!40000 ALTER TABLE `points` DISABLE KEYS */;
/*!40000 ALTER TABLE `points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registerstatus`
--

DROP TABLE IF EXISTS `registerstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registerstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registerstatus`
--

LOCK TABLES `registerstatus` WRITE;
/*!40000 ALTER TABLE `registerstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `registerstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registertransaction`
--

DROP TABLE IF EXISTS `registertransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registertransaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `reg_key` varchar(255) DEFAULT NULL,
  `register_status_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6d0fww2ptb8dfngu5ruv7jdmm` (`register_status_id`),
  KEY `FK_50iti66qb8eiqn3o97sxltqtc` (`student_id`),
  KEY `FK_8252jqvo9g0s5e8v2a86lrb2u` (`user_id`),
  CONSTRAINT `FK_50iti66qb8eiqn3o97sxltqtc` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_6d0fww2ptb8dfngu5ruv7jdmm` FOREIGN KEY (`register_status_id`) REFERENCES `registerstatus` (`id`),
  CONSTRAINT `FK_8252jqvo9g0s5e8v2a86lrb2u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registertransaction`
--

LOCK TABLES `registertransaction` WRITE;
/*!40000 ALTER TABLE `registertransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `registertransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `week_type` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `sub_lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5a8mv7tscuu50l4jlhts19pxs` (`group_id`),
  KEY `FK_j1ejulqbqgtxiyngn86pww9y` (`sub_lesson_id`),
  CONSTRAINT `FK_5a8mv7tscuu50l4jlhts19pxs` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_j1ejulqbqgtxiyngn86pww9y` FOREIGN KEY (`sub_lesson_id`) REFERENCES `sub_lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendedsms`
--

DROP TABLE IF EXISTS `sendedsms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendedsms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lyyp3pkueyfn4yj8vhtnt34rs` (`student_id`),
  CONSTRAINT `FK_lyyp3pkueyfn4yj8vhtnt34rs` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendedsms`
--

LOCK TABLES `sendedsms` WRITE;
/*!40000 ALTER TABLE `sendedsms` DISABLE KEYS */;
/*!40000 ALTER TABLE `sendedsms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `specialty_code` int(11) DEFAULT NULL,
  `student_ticket_no` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_20su8ubuwt33je1a3ygal7wd6` (`group_id`),
  KEY `FK_bbjof5v50tuo75cdbyd32ilfq` (`privilege_id`),
  CONSTRAINT `FK_20su8ubuwt33je1a3ygal7wd6` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_bbjof5v50tuo75cdbyd32ilfq` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentpoints`
--

DROP TABLE IF EXISTS `studentpoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentpoints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance` int(11) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `daily` varchar(255) DEFAULT NULL,
  `kollekvum` int(11) DEFAULT NULL,
  `laboratory` int(11) DEFAULT NULL,
  `selfwork` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9j4pg4rqqu93gs1mwvxp68yb` (`lesson_id`),
  KEY `FK_crg1hbdbluds59rnkyo3ir0fp` (`student_id`),
  CONSTRAINT `FK_9j4pg4rqqu93gs1mwvxp68yb` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FK_crg1hbdbluds59rnkyo3ir0fp` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentpoints`
--

LOCK TABLES `studentpoints` WRITE;
/*!40000 ALTER TABLE `studentpoints` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentpoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_lesson`
--

DROP TABLE IF EXISTS `sub_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `hours` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_lesson_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rrj4vtb1jailcr841gsgvbcsk` (`parent_lesson_id`),
  KEY `FK_f91l095c8ttfkoo5iaagty2yx` (`type_id`),
  KEY `FK_4auvmj25mdiia0q36pbokl517` (`teacher_id`),
  CONSTRAINT `FK_4auvmj25mdiia0q36pbokl517` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FK_f91l095c8ttfkoo5iaagty2yx` FOREIGN KEY (`type_id`) REFERENCES `sub_lesson` (`id`),
  CONSTRAINT `FK_rrj4vtb1jailcr841gsgvbcsk` FOREIGN KEY (`parent_lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_lesson`
--

LOCK TABLES `sub_lesson` WRITE;
/*!40000 ALTER TABLE `sub_lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `doc_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ffnnljgks5l66hprh3310yd0` (`lesson_id`),
  KEY `FK_gn542tlpalerquw0pwc4ekc7p` (`student_id`),
  KEY `FK_l2s9tdcuk3cgxo8n6nl8e1ged` (`status_id`),
  CONSTRAINT `FK_ffnnljgks5l66hprh3310yd0` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FK_gn542tlpalerquw0pwc4ekc7p` FOREIGN KEY (`student_id`) REFERENCES `sub_lesson` (`id`),
  CONSTRAINT `FK_l2s9tdcuk3cgxo8n6nl8e1ged` FOREIGN KEY (`status_id`) REFERENCES `summarystatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary`
--

LOCK TABLES `summary` WRITE;
/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summarystatus`
--

DROP TABLE IF EXISTS `summarystatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summarystatus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summarystatus`
--

LOCK TABLES `summarystatus` WRITE;
/*!40000 ALTER TABLE `summarystatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `summarystatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r15vbjxgm07s2amaqcwrw0ivd` (`schedule_id`),
  CONSTRAINT `FK_r15vbjxgm07s2amaqcwrw0ivd` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherprogram`
--

DROP TABLE IF EXISTS `teacherprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacherprogram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `hour` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8385hwj4x5k2frpuhk75cxqum` (`group_id`),
  KEY `FK_t98jivax1guy5u4h3402wb3er` (`lesson_id`),
  KEY `FK_2jgffiofmba3qxs52p4gj0k3i` (`teacher_id`),
  CONSTRAINT `FK_2jgffiofmba3qxs52p4gj0k3i` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FK_8385hwj4x5k2frpuhk75cxqum` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_t98jivax1guy5u4h3402wb3er` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherprogram`
--

LOCK TABLES `teacherprogram` WRITE;
/*!40000 ALTER TABLE `teacherprogram` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacherprogram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionorigin`
--

DROP TABLE IF EXISTS `transactionorigin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionorigin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionorigin`
--

LOCK TABLES `transactionorigin` WRITE;
/*!40000 ALTER TABLE `transactionorigin` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionorigin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionstatus`
--

DROP TABLE IF EXISTS `transactionstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionstatus`
--

LOCK TABLES `transactionstatus` WRITE;
/*!40000 ALTER TABLE `transactionstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontype`
--

LOCK TABLES `transactiontype` WRITE;
/*!40000 ALTER TABLE `transactiontype` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typecategory`
--

DROP TABLE IF EXISTS `typecategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typecategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `daily` int(11) DEFAULT NULL,
  `final` int(11) DEFAULT NULL,
  `kollekvum` int(11) DEFAULT NULL,
  `laboratory` int(11) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `selfwork` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typecategory`
--

LOCK TABLES `typecategory` WRITE;
/*!40000 ALTER TABLE `typecategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `typecategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `register_status_id` int(11) DEFAULT NULL,
  `type_category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f487rb6dsdje8k0gryrpgix7v` (`register_status_id`),
  KEY `FK_6x3mk8sbkg0gv5g33494ke6g6` (`type_category`),
  CONSTRAINT `FK_6x3mk8sbkg0gv5g33494ke6g6` FOREIGN KEY (`type_category`) REFERENCES `typecategory` (`id`),
  CONSTRAINT `FK_f487rb6dsdje8k0gryrpgix7v` FOREIGN KEY (`register_status_id`) REFERENCES `registerstatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` decimal(19,2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_mobile` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `second_mobile` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dj30o8sk9wmgrmofoyqwkvltg` (`privilege_id`),
  CONSTRAINT `FK_dj30o8sk9wmgrmofoyqwkvltg` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useractivity`
--

DROP TABLE IF EXISTS `useractivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useractivity` (
  `transaction_id` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `register_status_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_p0raggnf83cpk7r8ntmhwd0ff` (`register_status_id`),
  KEY `FK_qn0mujlwf9emb3y5635ctv6of` (`student_id`),
  KEY `FK_aat6sjd8qrytxyjpm0a1vr16` (`user_id`),
  CONSTRAINT `FK_aat6sjd8qrytxyjpm0a1vr16` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_p0raggnf83cpk7r8ntmhwd0ff` FOREIGN KEY (`register_status_id`) REFERENCES `registerstatus` (`id`),
  CONSTRAINT `FK_qn0mujlwf9emb3y5635ctv6of` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useractivity`
--

LOCK TABLES `useractivity` WRITE;
/*!40000 ALTER TABLE `useractivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `useractivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercardinfo`
--

DROP TABLE IF EXISTS `usercardinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercardinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardbindingid` varchar(255) DEFAULT NULL,
  `cardholder_name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qgja0u9nlrvby4bm3fyx9mt65` (`status_id`),
  KEY `FK_sqng9d3pjtt0rylplfqjswdc` (`user_id`),
  CONSTRAINT `FK_qgja0u9nlrvby4bm3fyx9mt65` FOREIGN KEY (`status_id`) REFERENCES `usercardstatus` (`id`),
  CONSTRAINT `FK_sqng9d3pjtt0rylplfqjswdc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercardinfo`
--

LOCK TABLES `usercardinfo` WRITE;
/*!40000 ALTER TABLE `usercardinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercardinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercardstatus`
--

DROP TABLE IF EXISTS `usercardstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercardstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercardstatus`
--

LOCK TABLES `usercardstatus` WRITE;
/*!40000 ALTER TABLE `usercardstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercardstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertransaction`
--

DROP TABLE IF EXISTS `usertransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertransaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `bind_card` bit(1) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `payment_key` varchar(255) DEFAULT NULL,
  `origin_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9lhsoek6qi71rqsk03uhtkqob` (`origin_id`),
  KEY `FK_ne4jw1fktup7mid0hfinq1wgx` (`status_id`),
  KEY `FK_s7yco58vorctefhxunxq9p1s6` (`type_id`),
  KEY `FK_jhhpw4bat4fos5sy61bap9i1h` (`user_id`),
  CONSTRAINT `FK_9lhsoek6qi71rqsk03uhtkqob` FOREIGN KEY (`origin_id`) REFERENCES `transactionorigin` (`id`),
  CONSTRAINT `FK_jhhpw4bat4fos5sy61bap9i1h` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_ne4jw1fktup7mid0hfinq1wgx` FOREIGN KEY (`status_id`) REFERENCES `transactionstatus` (`id`),
  CONSTRAINT `FK_s7yco58vorctefhxunxq9p1s6` FOREIGN KEY (`type_id`) REFERENCES `transactiontype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertransaction`
--

LOCK TABLES `usertransaction` WRITE;
/*!40000 ALTER TABLE `usertransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertypeactivity`
--

DROP TABLE IF EXISTS `usertypeactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertypeactivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `useractivity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_70htdkabftvf9dh9bcgsbabcr` (`type_id`),
  KEY `FK_nm7pqkui5cve6a0a64mflqdb1` (`useractivity_id`),
  CONSTRAINT `FK_70htdkabftvf9dh9bcgsbabcr` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  CONSTRAINT `FK_nm7pqkui5cve6a0a64mflqdb1` FOREIGN KEY (`useractivity_id`) REFERENCES `useractivity` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertypeactivity`
--

LOCK TABLES `usertypeactivity` WRITE;
/*!40000 ALTER TABLE `usertypeactivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertypeactivity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-14 21:58:23
