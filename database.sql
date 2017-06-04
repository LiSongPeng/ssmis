-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: ssmis
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `Exam`
--

DROP TABLE IF EXISTS `Exam`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exam` (
  `dpm`      CHAR(8)      NOT NULL,
  `crs`      CHAR(8)      NOT NULL,
  `date`     VARCHAR(100) NOT NULL,
  `location` VARCHAR(64)  NOT NULL,
  `status`   TINYINT(4)   NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm`, `crs`),
  KEY `exam_course_crs_id_fk` (`crs`),
  CONSTRAINT `exam_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `exam_department_dpm_id_fk` FOREIGN KEY (`dpm`) REFERENCES `department` (`dpm_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `tch_id`     VARCHAR(8)  NOT NULL,
  `name`       VARCHAR(32) NOT NULL,
  `password`   VARCHAR(32) NOT NULL,
  `email`      VARCHAR(64)          DEFAULT NULL,
  `address`    VARCHAR(128)         DEFAULT NULL,
  `phone`      VARCHAR(13) NOT NULL,
  `birthday`   DATE        NOT NULL,
  `gender`     TINYINT(1)  NOT NULL DEFAULT '0',
  `biography`  VARCHAR(128)         DEFAULT NULL,
  `tch_status` TINYINT(4)  NOT NULL DEFAULT '1',
  `dpm_id`     CHAR(8)     NOT NULL,
  PRIMARY KEY (`tch_id`),
  UNIQUE KEY `teacher_tch_id_uindex` (`tch_id`),
  KEY `teacher_department_dpm_id_fk` (`dpm_id`),
  CONSTRAINT `teacher_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `appeal`
--

DROP TABLE IF EXISTS `appeal`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appeal` (
  `dpm_id`   CHAR(8)      NOT NULL,
  `crs_id`   CHAR(8)      NOT NULL,
  `tch_id`   CHAR(8)      NOT NULL,
  `stu_id`   CHAR(8)      NOT NULL,
  `date`     DATE         NOT NULL,
  `content`  VARCHAR(128) NOT NULL,
  `response` VARCHAR(128)          DEFAULT '未回执',
  `status`   TINYINT(4)   NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm_id`, `crs_id`, `tch_id`, `stu_id`, `date`),
  KEY `appeal_student_stu_id_fk` (`stu_id`),
  KEY `appeal_teacher_tch_id_fk` (`tch_id`),
  KEY `appeal_course_crs_id_fk` (`crs_id`),
  CONSTRAINT `appeal_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `appeal_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `appeal_student_stu_id_fk` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `appeal_teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `teacher` (`tch_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `dpm`     CHAR(8)      NOT NULL,
  `crs`     CHAR(8)      NOT NULL,
  `tch`     CHAR(8)      NOT NULL,
  `date`    DATE         NOT NULL,
  `content` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`dpm`, `tch`, `crs`, `date`),
  KEY `comment_teacher_tch_id_fk` (`tch`),
  KEY `comment_course_crs_id_fk` (`crs`),
  CONSTRAINT `comment_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `comment_department_dpm_id_fk` FOREIGN KEY (`dpm`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `comment_teacher_tch_id_fk` FOREIGN KEY (`tch`) REFERENCES `teacher` (`tch_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `crs_id`        CHAR(8)     NOT NULL,
  `crs_name`      VARCHAR(64) NOT NULL,
  `summarization` VARCHAR(128) DEFAULT NULL
  COMMENT '简介',
  PRIMARY KEY (`crs_id`),
  UNIQUE KEY `course_crs_id_uindex` (`crs_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course_schedule`
--

DROP TABLE IF EXISTS `course_schedule`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_schedule` (
  `dpm_id`   CHAR(8)    NOT NULL,
  `crs_id`   CHAR(8)    NOT NULL,
  `tch_id`   CHAR(8)    NOT NULL,
  `type`     TINYINT(4) NOT NULL DEFAULT '0'
  COMMENT '课程类型',
  `preriods` TINYINT(4) NOT NULL DEFAULT '0',
  `credit`   TINYINT(4) NOT NULL,
  `term`     TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm_id`, `tch_id`, `crs_id`),
  KEY `course_schedule_course_crs_id_fk` (`crs_id`),
  KEY `course_schedule_teacher_tch_id_fk` (`tch_id`),
  CONSTRAINT `course_schedule_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `course_schedule_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `course_schedule_teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `Teacher` (`tch_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `courses_table`
--

DROP TABLE IF EXISTS `courses_table`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_table` (
  `dpm_id` CHAR(8)      NOT NULL,
  `crs_id` CHAR(8)      NOT NULL,
  `tch_id` CHAR(8)      NOT NULL,
  `weeks`  VARCHAR(100) NOT NULL,
  `off`    VARCHAR(100) NOT NULL,
  `site`   VARCHAR(30)  NOT NULL,
  PRIMARY KEY (`crs_id`, `dpm_id`, `tch_id`),
  KEY `courses_table_teacher_tch_id_fk` (`tch_id`),
  KEY `courses_table_department_dpm_id_fk` (`dpm_id`),
  CONSTRAINT `courses_table_Teacher_tch_id_fk` FOREIGN KEY (`tch_id`) REFERENCES `Teacher` (`tch_id`),
  CONSTRAINT `courses_table_course_crs_id_fk` FOREIGN KEY (`crs_id`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `courses_table_department_dpm_id_fk` FOREIGN KEY (`dpm_id`) REFERENCES `department` (`dpm_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dpm_id`   CHAR(8)     NOT NULL,
  `dpm_name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`dpm_id`),
  UNIQUE KEY `department_dpm_id_uindex` (`dpm_id`),
  UNIQUE KEY `department_dpm_name_uindex` (`dpm_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_id`     CHAR(8)     NOT NULL,
  `name`       VARCHAR(32) NOT NULL,
  `password`   VARCHAR(32) NOT NULL,
  `email`      VARCHAR(64)          DEFAULT NULL,
  `address`    VARCHAR(128)         DEFAULT NULL,
  `phone`      VARCHAR(13) NOT NULL,
  `birthday`   DATE        NOT NULL,
  `gender`     TINYINT(1)  NOT NULL DEFAULT '0',
  `grade`      SMALLINT(6) NOT NULL DEFAULT '1',
  `class_no`   TINYINT(4)  NOT NULL DEFAULT '1',
  `stu_status` TINYINT(4)           DEFAULT '1',
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `student_stu_id_uindex` (`stu_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_schedule`
--

DROP TABLE IF EXISTS `student_schedule`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_schedule` (
  `dpm`         CHAR(8)    NOT NULL,
  `crs`         CHAR(8)    NOT NULL,
  `tch`         CHAR(8)    NOT NULL,
  `stu`         CHAR(8)    NOT NULL,
  `term`        TINYINT(4) NOT NULL,
  `score`       FLOAT      NOT NULL DEFAULT '-1',
  `exam_status` TINYINT    NOT NULL DEFAULT '0',
  PRIMARY KEY (`dpm`, `crs`, `tch`, `stu`),
  KEY `student_chedule_teacher_tch_id_fk` (`tch`),
  KEY `student_chedule_student_stu_id_fk` (`stu`),
  KEY `student_chedule_course_crs_id_fk` (`crs`),
  CONSTRAINT `student_chedule_course_crs_id_fk` FOREIGN KEY (`crs`) REFERENCES `course` (`crs_id`),
  CONSTRAINT `student_chedule_department_dpm_id_fk` FOREIGN KEY (`dpm`) REFERENCES `department` (`dpm_id`),
  CONSTRAINT `student_chedule_student_stu_id_fk` FOREIGN KEY (`stu`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `student_schedule_Teacher_tch_id_fk` FOREIGN KEY (`tch`) REFERENCES `Teacher` (`tch_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20  8:36:56


