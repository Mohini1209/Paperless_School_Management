CREATE DATABASE  IF NOT EXISTS `paperless_school` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `paperless_school`;
-- MariaDB dump 10.17  Distrib 10.4.6-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: paperless_school
-- ------------------------------------------------------
-- Server version	10.4.6-MariaDB

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
-- Table structure for table `attendance_master`
--

DROP TABLE IF EXISTS `attendance_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance_master` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `remark` varchar(10) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `s_id_fk` (`s_id`),
  CONSTRAINT `s_id_fk` FOREIGN KEY (`s_id`) REFERENCES `student_master` (`s_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_master`
--

LOCK TABLES `attendance_master` WRITE;
/*!40000 ALTER TABLE `attendance_master` DISABLE KEYS */;
INSERT INTO `attendance_master` VALUES (1,'2021-06-15','P',1),(2,'2021-06-15','A',2),(3,'2021-06-15','P',3),(4,'2021-06-15','P',4),(5,'2021-06-15','A',5),(6,'2021-06-16','P',1),(7,'2021-06-16','P',2),(8,'2021-06-16','A',3),(9,'2021-06-16','P',4),(10,'2021-06-16','P',5),(11,'2021-06-17','P',1),(12,'2021-06-17','P',2),(13,'2021-06-17','P',3),(14,'2021-06-17','P',4),(15,'2021-06-17','P',5),(16,'2021-06-18','A',1),(17,'2021-06-18','A',2),(18,'2021-06-18','P',3),(19,'2021-06-18','A',4),(20,'2021-06-18','P',5),(21,'2021-07-01','P',1),(22,'2021-07-02','P',1),(23,'2021-07-02','A',2),(24,'2021-07-03','P',1),(25,'2021-07-03','A',7),(26,'2021-07-04','A',2),(27,'2021-07-04','P',6),(28,'2021-07-06','A',1),(29,'2021-07-06','P',7),(30,'2021-03-13','P',2),(31,'2021-03-03','A',6),(32,'2021-07-08','A',2),(33,'2021-07-08','P',6),(34,'2021-07-08','P',9),(35,'2021-07-10','P',2),(36,'2021-07-10','P',6),(37,'2021-07-10','P',9);
/*!40000 ALTER TABLE `attendance_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter_master`
--

DROP TABLE IF EXISTS `chapter_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chapter_master` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `chapter_id` int(11) DEFAULT NULL,
  `chapter_name` varchar(45) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `Chapter_id_fk` (`subject_id`),
  CONSTRAINT `Chapter_id_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject_master` (`Subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter_master`
--

LOCK TABLES `chapter_master` WRITE;
/*!40000 ALTER TABLE `chapter_master` DISABLE KEYS */;
INSERT INTO `chapter_master` VALUES (201,1,'Numbers','https://drive.google.com/file/d/13QDWzEdrhzb_qmLcm6e-iw5uGniwxVbq/view',101),(202,2,'Shapes and Space','https://drive.google.com/file/d/1lPCRR6d1pUu1BtAST6n_3p8qncFXRpMY/view',101),(203,3,'Addition','https://drive.google.com/file/d/1zkAo85B5muQtUcN7r7ppa6KoJ-s5MeUV/view',101),(204,4,'Measurement','https://drive.google.com/file/d/13EXX_fX9ss0nMiU_EH2bi04N92kgwpUW/view',101),(205,5,'Time','https://drive.google.com/file/d/1euQ6PsNdcuzeulmzqUzDJgvpXMUAi4eH/view',101),(206,1,'Alphabets','https://www.youtube.com/watch?v=hq3yfQnllfQ&t=43s',102),(207,2,'Poems','https://drive.google.com/file/d/1Cg3QPCjGKx1Mt1QDGzLcOjTJm4KLX31J/view',102),(208,3,'Story-The Lion And the Mouse','https://drive.google.com/file/d/12U49xAst83A6BXwRKccKugZ_r7Q_EbDI/view',102),(209,4,'Fruits and Vegetables','https://drive.google.com/file/d/1_883VtdbTUM81OdcdhQQnQyuHnk591B1/view',102),(210,5,'Animals and Birds','https://drive.google.com/file/d/1qJFE7PYDp-KBEUTRIdIAenp47qoqiVfg/view',102),(211,1,'Varnamala','http://www.indif.com/kids/learn_marathi/marathi_alphabets.pdf',103),(212,2,'Katha-Chatur Kavla','https://www.youtube.com/watch?v=NWwqJvd1pz4',103),(213,3,'Barakhadi','https://learningprodigy.com/wp-content/uploads/2020/07/Hindi-Bharakadi-chart.pdf',103),(214,4,'Kavita','https://www.youtube.com/watch?v=IBZ_drOU93Q',103),(215,5,'Gosti','https://www.youtube.com/watch?v=4cziux3gmUM',103),(216,1,'Counting in Groups','https://drive.google.com/file/d/1QLAJihNZpgpKfG6vkuaK1Jkudowl0vj5/view',104),(217,2,'How much can you carry?','https://drive.google.com/file/d/1aPAdJYa24e2TChyKNkeqM1JuggKAAJcd/view',104),(218,3,'Add our points','https://drive.google.com/file/d/1h_1ORlqgoTVWfRoKGx2ofTN3goGLNeGc/view',104),(219,4,'Lines ','https://drive.google.com/file/d/1ZmG1fKHeZ_eJvDJbG2InMrmegNVD3KF4/view',104),(220,5,'Birds come Birds go','https://drive.google.com/file/d/1XpGuKzuVvryjY0MW3u4uiEfWHWun73sv/view',104),(221,1,'Poem','https://drive.google.com/file/d/1fsKfF2qoirYu4QnF9ZfnZIvH0zskSZy8/view',105),(222,2,'National Symbols','https://drive.google.com/file/d/10x9kFyUuFyNDh3fuYOSEImk_DhucNtLI/view',105),(223,3,'Story-Three Pots','https://www.youtube.com/watch?v=n7z7rTrIupc',105),(224,4,'Story-Arrogant Lioness','https://www.youtube.com/watch?v=CWSYyAC0EqM',105),(225,5,'Good and Bad habits','https://www.youtube.com/watch?v=mbv63Lz2vAw',105),(226,1,'Maze Shabdbhandar','https://www.youtube.com/watch?v=fd_THUCc6_k',106),(227,2,'Ankavachan 1-100','https://www.youtube.com/watch?v=-BxouM0xiII',106),(228,3,'Katha-Shalecha Abhys','https://www.youtube.com/watch?v=9G0KD2_wCjs',106),(229,4,'Poem-Sasoba','https://www.youtube.com/watch?v=WoShwRwJQ0w',106),(230,5,'Olakh Khelanchi','https://www.youtube.com/watch?v=i0-mUzdBJX4',106),(231,1,'Long and Short','https://drive.google.com/file/d/1y7Yjnb13GQmIR8bzWN5kPfUwt-0u7iCy/view',107),(232,2,'Shapes and Designs','https://drive.google.com/file/d/1TkE44WT9XhRq840pENywlvLXtNXeVZYC/view',107),(233,3,'Rupees and Paise','https://drive.google.com/file/d/1uT_A1m8opQLYu3XVnu6he4lbKvHpcZ9a/view',107),(234,4,'Charts','https://drive.google.com/file/d/1hBH9Tb3OCAJGPLRAS9C2o3ERQXxko6Bc/view',107),(235,5,'Play with Patterns','https://drive.google.com/file/d/1HknCGDjxYuwwQZ3XYZiwQq2ldJqApt3D/view',107),(236,1,'Good Morning','https://drive.google.com/file/d/1k3qVAj5swaL0hbnBPoPWHxm7mzjlCyOI/view',108),(237,2,'Little by Little','https://drive.google.com/file/d/1YBsurXMHtFWR6nrOjtiFxjm64Etkodsk/view',108),(238,3,'A Little Fish Story,Sea Song','https://drive.google.com/file/d/1sPnVpU1D6LhG-bTKqPnDLLv2mqlQ4Lxs/view',108),(239,4,'Trains','https://drive.google.com/file/d/1Nevd3oh7YLk_LkUgYDT4DiJn7dUf8idm/view',108),(240,5,'The Balloon Man','https://drive.google.com/file/d/17uazqfIwkjfOv3okKEEry_EMMni430sP/view',108),(241,1,'Kavita-Dost','https://www.youtube.com/watch?v=VfOcem6uspc',109),(242,2,'Savitri Bai Phule','https://www.youtube.com/watch?v=JfE5TBTNNR0',109),(243,3,'Ranvedi','https://www.youtube.com/watch?v=KTnMnQeRJbo',109),(244,4,'Madh Mashi Ne Keli Kamal','https://www.youtube.com/watch?v=zY-WKfxyAHM',109),(245,5,'Ek Bhartiya Sanshodhak','https://www.youtube.com/watch?v=7cYVzYOJ-GQ',109),(246,1,'Water O Water','https://drive.google.com/file/d/1jfkMpxsh3XMc025f76-ryNMVP5utx0Ct/view',110),(247,2,'The Story of Food','https://drive.google.com/file/d/1_1coyp-MtZFwE6_fQn1u8PXucVdgk4Aw/view',110),(248,3,'Our Friends – Animals','https://drive.google.com/file/d/12TWwOCpwYxTt6L5Wjhj6-b7du7tvrcgF/view',110),(249,4,'What is NOISE POLLUTION','https://www.youtube.com/watch?v=OQWmaYjyolE',110),(250,5,'From Here to There','https://drive.google.com/file/d/1VUwqOAmZEzZGUIQtF0zxRD7FIUOrvNt6/view',110),(251,1,'THE GIVING TREE','https://www.youtube.com/watch?v=GTS_JrMfjyE',111),(252,2,'Going to buy a book','https://drive.google.com/file/d/1_ZNIodmGPWdgX9GWlD22PuQZ_F3Qp91j/view',111),(253,3,'English Grammar','https://www.youtube.com/watch?v=7vE6RMGPT_w',111),(254,4,'Food and Fun','https://drive.google.com/file/d/1sCTLXYuY_eSTvOYApqJxLJhx-zH8QQVQ/view',111),(255,5,'Eating Together','https://drive.google.com/file/d/1rlJNXw6B8mhSz1K3tYu5WSEncTXpM13k/view',111),(256,1,'Zuluk Mi Wahve – Kavita','https://www.youtube.com/watch?v=uTYABW33MpE',112),(257,2,'Mithacha Shodh Swadhyay','https://www.youtube.com/watch?v=PrZqExSEOsU',112),(258,3,'Gun Grahak Raja','https://www.youtube.com/watch?v=fv-uSaR9CaY',112),(259,4,'Mhani chya Gamti','https://www.youtube.com/watch?v=dm5nlHTAIZk',112),(260,5,'EidGah','https://www.youtube.com/watch?v=vmltBqE7Eik',112),(261,1,'India in ancient times','https://www.youtube.com/watch?v=MP01dh9ywm8',113),(262,2,'Work of saints','https://www.youtube.com/watch?v=K69kKicTKZY',113),(263,3,'Maharashtra before shivaji','https://www.youtube.com/watch?v=q3uisFHTKWk',113),(264,4,'History of Shivaji Maharaj ','https://www.youtube.com/watch?v=oM1dGZuy7go',113),(265,5,'Great Warrior Shivaji Maharaj','https://www.youtube.com/watch?v=KYFRkHsN0AM',113),(266,1,'Tables and Shares','https://drive.google.com/file/d/18h2pPtVfKe8YoSnij1GGHw6SGsCKKKsU/view',114),(267,2,'Halves and Quarters','https://drive.google.com/file/d/16ASN9SCHLoj-wUnrVXE7ekht7HU2FrzM/view',114),(268,3,'Multiplication','https://www.youtube.com/watch?v=_3glsxZmHHQ',114),(269,4,'Divison with word problems','https://www.youtube.com/watch?v=feLducmpEgQ',114),(270,5,'Fields and Fences','https://drive.google.com/file/d/1XxVnYdlOT5-7odBBzueoTmCo7t2e6m9L/view',114),(271,1,'Going to School','https://drive.google.com/file/d/1V8gOpZtDCK7R667ivPwWKQJpw9GjcJV3/view',115),(272,2,'Changing Times','https://drive.google.com/file/d/1B2tWI99cC0tJFmBg8ER4Bs6_M6IvrvKK/view',115),(273,3,'Natural Disasters','https://www.youtube.com/watch?v=Yi-ojfacTAw',115),(274,4,'From the Window','https://drive.google.com/file/d/16xCD0DmdRid_roU0AtGgzskH0BCbXUaC/view',115),(275,5,'Safety & First Aid','https://www.youtube.com/watch?v=hfHusPHSS0I',115),(276,1,'Shapes and Angles','https://drive.google.com/file/d/1MisPJT565elGIeaEaekqdEdXwWTQaZvP/view',116),(277,2,'How Many Squares?','https://drive.google.com/file/d/1ZBvY-Jnz30pS-FvlmJt0j6yOC6vnpSIb/view',116),(278,3,'Tenths and Hundredths','https://drive.google.com/file/d/1VYCxLqJurSwN5i277GELykNbTQyNTIOG/view?usp=drive_open',116),(279,4,'Area and its Boundary','https://drive.google.com/file/d/1bzpmLZF7coSLBbg-FXZO0eaWuvkbUWQ7/view',116),(280,5,'Parts and Wholes','https://drive.google.com/file/d/1fL5oFBCEGGaAyXl-kH4SJLTqAWS-cOi7/view',116),(281,1,'Ice-cream Man','https://drive.google.com/file/d/1FG6TmzTIP3Ami-YOTJrkxKGpJhSCEd1x/view',117),(282,2,'Teamwork','https://drive.google.com/file/d/14h5gwZsnmBp52lkpjMf9EPFXaQfFUu5g/view',117),(283,3,'The Lazy Frog','https://drive.google.com/file/d/14R1sPHcU9zKyQiI7nHwIz6XWUZYeCyJJ/view',117),(284,4,'Sing a Song of People','https://drive.google.com/file/d/1s9VbCOO1OVuBZRinjm56mFtZZ2vHTNxA/view',117),(285,5,'Topsy-turvy Land','https://drive.google.com/file/d/1j106bnZbcpR9yMYF5ElzIF2o6T_kZ9by/view',117),(286,1,'Rashtrasant Tukdoji Maharaj','https://www.youtube.com/watch?v=x9GGzjOkpzQ',118),(287,2,'Vasaru-Kavita','https://www.youtube.com/watch?v=ciNxGRH0rtY',118),(288,3,'Banduchi Izzar - Chitrakatha','https://www.youtube.com/watch?v=qpSbIYAfocQ',118),(289,4,'Kathin Samay Yeta...','https://www.youtube.com/watch?v=oCUDLNeVf5E',118),(290,5,'Aati Tithe Maati','https://www.youtube.com/watch?v=GdLzy0teQE0',118),(291,1,'Super Senses','https://drive.google.com/file/d/12E59JE4AVwmxXmwhiMG717OhDSrh_d7G/view',119),(292,2,'From Tasting to Digesting','https://drive.google.com/file/d/1bWwO5x8hg5qWO-XIhqibux2YWIMYofZi/view',119),(293,3,'Whose Forests?','https://drive.google.com/file/d/1kOgZvwTTV8Qwky8lGLQ9OMREZ63vld8D/view',119),(294,4,'No Place for Us?','https://drive.google.com/file/d/1tusp3LyU8hHzZxNlSINqz9FXrxOWjcrM/view',119),(295,5,'Experiments with Water','https://drive.google.com/file/d/1rLowJMJMrHTJmmmoaValgShSqYvYhSKo/view',119),(296,1,'Sources of History','https://www.youtube.com/watch?v=PNOV6zUi0DI&t=158s',120),(297,2,'Our Heritage','https://www.youtube.com/watch?v=VFt1Fl--zxQ&t=593s',120),(298,3,'Historical Monuments','https://www.youtube.com/watch?v=nNwaeCPnUz0&t=156s',120),(299,4,'Vedic Age','https://www.youtube.com/watch?v=-LYioyRKZT0&t=161s',120),(300,5,'What, Where, How and When?','https://www.youtube.com/watch?v=3SYmQwfJosI&t=184s',120),(301,1,'Seven wonders of world','https://www.youtube.com/watch?v=mJCEVIiuiPc',121),(302,2,'Indian states and capitals','https://www.youtube.com/watch?v=mS8V3aKiPmQ',121),(303,3,'Prime ministers of India','https://www.youtube.com/watch?v=8ScBBL4ztTQ',121),(304,4,'National Animals of countries','https://www.youtube.com/watch?v=bcRFqs75FZg',121),(305,5,'National Symbols of India','https://www.youtube.com/watch?v=BOBPylKBQoM',121),(306,6,'Landmarks of World','https://www.youtube.com/watch?v=kDCXqaYWn-U',121);
/*!40000 ALTER TABLE `chapter_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_master`
--

DROP TABLE IF EXISTS `class_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_master` (
  `class_id` int(11) NOT NULL,
  `standard` varchar(45) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `t_id_fk` (`t_id`),
  CONSTRAINT `t_id_fk` FOREIGN KEY (`t_id`) REFERENCES `teacher_master` (`t_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_master`
--

LOCK TABLES `class_master` WRITE;
/*!40000 ALTER TABLE `class_master` DISABLE KEYS */;
INSERT INTO `class_master` VALUES (10,'I',1),(20,'II',2),(30,'III',7),(40,'IV',8),(50,'V',6);
/*!40000 ALTER TABLE `class_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_master`
--

DROP TABLE IF EXISTS `login_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_master` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_master`
--

LOCK TABLES `login_master` WRITE;
/*!40000 ALTER TABLE `login_master` DISABLE KEYS */;
INSERT INTO `login_master` VALUES (2,1001,'Nishi@123','Teacher'),(3,11111,'Amit@123','Admin'),(4,2021001,'Shilpa@123','Student'),(5,1002,'Bakul@123','Teacher'),(6,1003,'Trupti@123','Teacher'),(7,2021002,'Mohini@123','Student'),(8,1004,'Sayli@123','Teacher'),(9,1005,'Shri@123','Teacher'),(10,2021003,'Gayatri@123','Student'),(11,2021004,'Nupur@123','Student'),(12,2021005,'Kimaya@123','Student'),(13,1006,'Sachin@123','Teacher'),(14,2021006,'Shital@123','Student'),(15,2021007,'Vaibhav@123','Student'),(16,2021008,'Kavya@123','Student'),(17,1007,'Sunil@123','Teacher'),(18,2021009,'Radhika@123','Student'),(19,1008,'Neha@123','Teacher');
/*!40000 ALTER TABLE `login_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks_master`
--

DROP TABLE IF EXISTS `marks_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks_master` (
  `mark_id` int(11) NOT NULL AUTO_INCREMENT,
  `out_of_marks` int(11) DEFAULT NULL,
  `obtain_marks` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `progress_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mark_id`),
  KEY `marks_id` (`progress_id`),
  KEY `marks_id_fk` (`subject_id`),
  CONSTRAINT `marks_id` FOREIGN KEY (`progress_id`) REFERENCES `progress_master` (`progress_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `marks_id_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject_master` (`Subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks_master`
--

LOCK TABLES `marks_master` WRITE;
/*!40000 ALTER TABLE `marks_master` DISABLE KEYS */;
INSERT INTO `marks_master` VALUES (1,100,70,116,1),(2,100,80,117,1),(3,100,88,118,1),(4,100,92,119,1),(5,100,87,120,1),(6,100,86,121,1),(7,100,85,101,2),(8,100,80,102,2),(9,100,83,103,2),(10,100,90,107,3),(11,100,77,108,3),(12,100,97,109,3),(13,100,88,110,3),(14,100,93,111,4),(15,100,90,112,4),(16,100,87,119,4),(17,100,77,119,4),(38,100,78,101,9),(39,100,67,102,9),(40,100,89,103,9),(41,100,78,101,6),(42,100,78,102,6),(43,100,78,103,6),(44,100,90,116,7),(45,100,88,117,7),(46,100,94,118,7),(47,50,48,119,7),(48,100,92,120,7),(49,100,99,121,7);
/*!40000 ALTER TABLE `marks_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress_master`
--

DROP TABLE IF EXISTS `progress_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `progress_master` (
  `progress_id` int(11) NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`progress_id`),
  KEY `FKs7v6atdxmbkegy60m94hdawig` (`s_id`),
  CONSTRAINT `FKs7v6atdxmbkegy60m94hdawig` FOREIGN KEY (`s_id`) REFERENCES `student_master` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress_master`
--

LOCK TABLES `progress_master` WRITE;
/*!40000 ALTER TABLE `progress_master` DISABLE KEYS */;
INSERT INTO `progress_master` VALUES (1,'Very Good',1),(2,'Good',2),(3,'Excellent',3),(4,'Good',4),(5,'well done',5),(6,'Good',6),(7,'Very Good',7),(8,'Excellent',8),(9,'Excellent',9);
/*!40000 ALTER TABLE `progress_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `query_master`
--

DROP TABLE IF EXISTS `query_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `query_master` (
  `query_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(100) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`query_id`),
  KEY `FK4pn9bqq2h5x4wfv1f1byehoq2` (`subject_id`),
  KEY `s_query_id_fk` (`s_id`),
  CONSTRAINT `FK4pn9bqq2h5x4wfv1f1byehoq2` FOREIGN KEY (`subject_id`) REFERENCES `subject_master` (`subject_id`),
  CONSTRAINT `s_query_id_fk` FOREIGN KEY (`s_id`) REFERENCES `student_master` (`s_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `query_master`
--

LOCK TABLES `query_master` WRITE;
/*!40000 ALTER TABLE `query_master` DISABLE KEYS */;
INSERT INTO `query_master` VALUES (1,'Can you please explain division 3 numbers?','Yes,I will',116,1),(2,'What are Shapes?','Shapes modify',101,2),(3,'Who discover India?','Vasco D Gama discover India',120,1),(9,'explain about neharu chacha?','Pandit Javaharlal Neharu',118,1),(10,'when we celebrate Van Divas..?','5 jun ',119,1),(11,'how to celebrate van divas?','answer uploaded',119,1),(13,'how many vowels are available?','5 vowels are available (a,e,i,o,u)',102,2),(14,'Who discover 0 number?','Aryabhatta',101,9),(15,'list all Alphabets..?',NULL,102,6);
/*!40000 ALTER TABLE `query_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_master`
--

DROP TABLE IF EXISTS `student_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_master` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `Class_id` (`class_id`),
  CONSTRAINT `Class_id` FOREIGN KEY (`class_id`) REFERENCES `class_master` (`class_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2021025 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_master`
--

LOCK TABLES `student_master` WRITE;
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
INSERT INTO `student_master` VALUES (1,2021001,'Shilpa','Sanjay','Narute','shilpa123@gmail.com','9685421363','Baramati','1997-09-18',50),(2,2021002,'Mohini','Kailash','Ugave','mohini@gmail.com','9856478698','Burhanpur','1996-09-12',10),(3,2021003,'Gayatri','Parmanand','Wankhade','gayatri@gmail.com','9856478125','Nagpur','1996-09-19',40),(4,2021004,'Nupur','Shridhar','Muley','nupur@gmail.com','9875848777','Pune','2000-06-15',20),(5,2021005,'Kimaya','Kishor','Khilare','kimaya@gmail.com','9658214522','Pune','1997-04-23',30),(6,2021006,'Shital','Sanjay','Narute','shital@gmail.com','8989876549','baramati','1995-08-17',10),(7,2021007,'Vaibhav','S','Patil','vaibhav@gmail.com','898678954','Pune','2000-05-14',50),(8,2021008,'Kavya','K','Rane','kavya@gmail.com','8976789080','Pune','1999-06-02',30),(9,2021009,'Radhika','Mohan','Rathi','radhika@gmail.com','9876898756','Mumbai','1998-08-12',10);
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_master`
--

DROP TABLE IF EXISTS `subject_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_master` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(45) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `Class_id_fk` (`class_id`),
  CONSTRAINT `Class_id_fk` FOREIGN KEY (`class_id`) REFERENCES `class_master` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_master`
--

LOCK TABLES `subject_master` WRITE;
/*!40000 ALTER TABLE `subject_master` DISABLE KEYS */;
INSERT INTO `subject_master` VALUES (101,'Math',10),(102,'English',10),(103,'Marathi',10),(104,'Math',20),(105,'English',20),(106,'Marathi',20),(107,'Math',30),(108,'English',30),(109,'Marathi',30),(110,'Environment',30),(111,'English',40),(112,'Marathi',40),(113,'History',40),(114,'Math',40),(115,'Environment',40),(116,'Math',50),(117,'English',50),(118,'Marathi',50),(119,'Environment',50),(120,'History',50),(121,'GK',50);
/*!40000 ALTER TABLE `subject_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_master`
--

DROP TABLE IF EXISTS `teacher_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_master` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_master`
--

LOCK TABLES `teacher_master` WRITE;
/*!40000 ALTER TABLE `teacher_master` DISABLE KEYS */;
INSERT INTO `teacher_master` VALUES (1,1001,'Nishi','Sharma','nishi@gmail.com','9856478952','MBA','Pune'),(2,1002,'Bakul ','Joshi','bakul@gmail.com','9874589658','MBA','Pune'),(3,1003,'Trupti','Sathe','trupti@gmail.com','9856478549','MBA','Pune'),(4,1004,'Sayli','Chougule','sayli@gmail.com','9898956214','MTech','Pune'),(5,1005,'Shrinivas ','Jadhav','shri@gmail.com','9856478125','MTech','Pune'),(6,1006,'Sachin','Kulkarni','sachin@gmail.com','8475965841','ME','Pune'),(7,1007,'Sunil','Kulkarni','sunil@gmail.com','8790900908','MTech','Solapur'),(8,1008,'Neha','Karandikar','neha@gmail.com','9878990908','ME','Jalana');
/*!40000 ALTER TABLE `teacher_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-28 13:57:42
