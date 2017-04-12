CREATE DATABASE  IF NOT EXISTS `ssmis` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ssmis`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: ssmis
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `appeal`
--

DROP TABLE IF EXISTS `appeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appeal` (
  `dpm_id` char(8) NOT NULL,
  `crs_id` char(8) NOT NULL,
  `tch_id` char(8) NOT NULL,
  `stu_id` char(8) NOT NULL,
  `date` date NOT NULL,
  `content` varchar(128) NOT NULL,
  `response` varchar(128) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm_id`,`crs_id`,`tch_id`,`stu_id`,`date`),
  KEY `appeal_student_stu_id_fk` (`stu_id`),
  KEY `appeal_teacher_tch_id_fk` (`tch_id`),
  KEY `appeal_course_crs_id_fk` (`crs_id`),
  CONSTRAINT `appeal_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `appeal_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `appeal_student_stu_id_fk` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `appeal_teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `teacher` (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appeal`
--

LOCK TABLES `appeal` WRITE;
/*!40000 ALTER TABLE `appeal` DISABLE KEYS */;
/*!40000 ALTER TABLE `appeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `dpm` char(8) NOT NULL,
  `crs` char(8) NOT NULL,
  `tch` char(8) NOT NULL,
  `date` date NOT NULL,
  `content` varchar(128) NOT NULL,
  PRIMARY KEY (`dpm`,`tch`,`crs`,`date`),
  KEY `comment_teacher_tch_id_fk` (`tch`),
  KEY `comment_course_crs_id_fk` (`crs`),
  CONSTRAINT `comment_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `comment_department_dpm_id_fk` FOREIGN KEY (`dpm`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `comment_teacher_tch_id_fk` FOREIGN KEY (`tch`) REFERENCES `teacher` (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `crs_id` char(8) NOT NULL,
  `crs_name` varchar(64) NOT NULL,
  `summarization` varchar(128) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`crs_id`),
  UNIQUE KEY `course_crs_id_uindex` (`crs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_schedule`
--

DROP TABLE IF EXISTS `course_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_schedule` (
  `dpm_id` char(8) NOT NULL,
  `crs_id` char(8) NOT NULL,
  `tch_id` char(8) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '课程类型',
  `preriods` tinyint(4) NOT NULL DEFAULT '0',
  `credit` tinyint(4) NOT NULL,
  `term` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm_id`,`tch_id`,`crs_id`),
  KEY `course_schedule_course_crs_id_fk` (`crs_id`),
  KEY `course_schedule_teacher_tch_id_fk` (`tch_id`),
  CONSTRAINT `course_schedule_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `course_schedule_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `course_schedule_teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `teacher` (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_schedule`
--

LOCK TABLES `course_schedule` WRITE;
/*!40000 ALTER TABLE `course_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_table`
--

DROP TABLE IF EXISTS `courses_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_table` (
  `dpm_id` char(8) NOT NULL,
  `crs_id` char(8) NOT NULL,
  `tch_id` char(8) NOT NULL,
  `weeks` tinyint(4) NOT NULL DEFAULT '0',
  `off` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`crs_id`,`dpm_id`,`tch_id`,`weeks`,`off`),
  KEY `courses_table_teacher_tch_id_fk` (`tch_id`),
  KEY `courses_table_department_dpm_id_fk` (`dpm_id`),
  CONSTRAINT `courses_table_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `courses_table_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `courses_table_teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `teacher` (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_table`
--

LOCK TABLES `courses_table` WRITE;
/*!40000 ALTER TABLE `courses_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dpm_id` char(8) NOT NULL,
  `dpm_name` varchar(32) NOT NULL,
  PRIMARY KEY (`dpm_id`),
  UNIQUE KEY `department_dpm_id_uindex` (`dpm_id`),
  UNIQUE KEY `department_dpm_name_uindex` (`dpm_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `dmp` char(8) NOT NULL,
  `crs` char(8) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(64) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dmp`,`crs`),
  KEY `exam_course_crs_id_fk` (`crs`),
  CONSTRAINT `exam_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `exam_department_dpm_id_fk` FOREIGN KEY (`dmp`) REFERENCES `department` (`dpm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_id` char(8) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone` varchar(13) NOT NULL,
  `birthday` date NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `grade` tinyint(4) NOT NULL DEFAULT '1',
  `class_no` tinyint(4) NOT NULL DEFAULT '1',
  `stu_status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `student_stu_id_uindex` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_chedule`
--

DROP TABLE IF EXISTS `student_chedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_chedule` (
  `dpm` char(8) NOT NULL,
  `crs` char(8) NOT NULL,
  `tch` char(8) NOT NULL,
  `stu` char(8) NOT NULL,
  `term` tinyint(4) NOT NULL,
  `score` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm`,`crs`,`tch`,`stu`),
  KEY `student_chedule_teacher_tch_id_fk` (`tch`),
  KEY `student_chedule_student_stu_id_fk` (`stu`),
  KEY `student_chedule_course_crs_id_fk` (`crs`),
  CONSTRAINT `student_chedule_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `student_chedule_department_dpm_id_fk` FOREIGN KEY (`dpm`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `student_chedule_student_stu_id_fk` FOREIGN KEY (`stu`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `student_chedule_teacher_tch_id_fk` FOREIGN KEY (`tch`) REFERENCES `teacher` (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_chedule`
--

LOCK TABLES `student_chedule` WRITE;
/*!40000 ALTER TABLE `student_chedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_chedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `tch_id` varchar(8) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone` varchar(13) NOT NULL,
  `birthday` date NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `biography` varchar(128) DEFAULT NULL,
  `tch_status` tinyint(4) NOT NULL DEFAULT '1',
  `dpm_id` char(8) NOT NULL,
  PRIMARY KEY (`tch_id`),
  UNIQUE KEY `teacher_tch_id_uindex` (`tch_id`),
  KEY `teacher_department_dpm_id_fk` (`dpm_id`),
  CONSTRAINT `teacher_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12 19:26:35
