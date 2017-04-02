-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.10a-beta-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema railway
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ railway;
USE railway;

--
-- Table structure for table `railway`.`class_cost`
--

DROP TABLE IF EXISTS `class_cost`;
CREATE TABLE `class_cost` (
  `class_name` varchar(45) default NULL,
  `cost` int(10) unsigned default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`class_cost`
--

/*!40000 ALTER TABLE `class_cost` DISABLE KEYS */;
INSERT INTO `class_cost` (`class_name`,`cost`) VALUES 
 ('Sleeper',80),
 ('General',50),
 ('AC',120);
/*!40000 ALTER TABLE `class_cost` ENABLE KEYS */;


--
-- Table structure for table `railway`.`namelist`
--

DROP TABLE IF EXISTS `namelist`;
CREATE TABLE `namelist` (
  `pid` int(10) unsigned NOT NULL,
  `noseats` int(10) unsigned NOT NULL,
  `n1` varchar(45) default NULL,
  `n2` varchar(45) default NULL,
  `n3` varchar(45) default NULL,
  `n4` varchar(45) default NULL,
  `n5` varchar(45) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`namelist`
--

/*!40000 ALTER TABLE `namelist` DISABLE KEYS */;
INSERT INTO `namelist` (`pid`,`noseats`,`n1`,`n2`,`n3`,`n4`,`n5`) VALUES 
 (1,2,'namrta','','','',''),
 (2,3,'namrta','ananya','','',''),
 (3,4,'namrta','sonali','arpita','',''),
 (4,3,'nidhi','nitika','','','');
/*!40000 ALTER TABLE `namelist` ENABLE KEYS */;


--
-- Table structure for table `railway`.`passenger`
--

DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger` (
  `pid` int(10) unsigned NOT NULL,
  `pname` varchar(45) default NULL,
  `page` int(10) unsigned default NULL,
  `pgender` varchar(45) default NULL,
  `paddress` varchar(45) default NULL,
  `pcategory` varchar(45) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`passenger`
--

/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` (`pid`,`pname`,`page`,`pgender`,`paddress`,`pcategory`) VALUES 
 (1,'arpita',24,'Female','alambagh lucknow','General'),
 (2,'abhilasha',21,'Female','sbjsbkjsbxknSAK','General'),
 (3,'archna',23,'Female','sbbsjkaasbaj','General'),
 (4,'namrta saxena',23,'Female','sbhewjnddjwn','General');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;


--
-- Table structure for table `railway`.`pnrenquiry`
--

DROP TABLE IF EXISTS `pnrenquiry`;
CREATE TABLE `pnrenquiry` (
  `epnrno` int(11) NOT NULL,
  `passname` varchar(45) default NULL,
  `seatcon` varchar(45) default NULL,
  `wait` varchar(45) default NULL,
  `esource` varchar(45) default NULL,
  `edsti` varchar(45) default NULL,
  `doj` varchar(45) default NULL,
  PRIMARY KEY  (`epnrno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`pnrenquiry`
--

/*!40000 ALTER TABLE `pnrenquiry` DISABLE KEYS */;
INSERT INTO `pnrenquiry` (`epnrno`,`passname`,`seatcon`,`wait`,`esource`,`edsti`,`doj`) VALUES 
 (1,'arpita','confirmed','no','lucknow','kanpur','19-8-2016'),
 (2,'abhilasha','confirmed','no','lucknow','allahabad','12-09-2016'),
 (3,'archna','confirmed ','no','lucknow','kanpur','12-11-2016'),
 (4,'namrta saxena','confirmed ','no','lucknow','kanpur','12-12-2016');
/*!40000 ALTER TABLE `pnrenquiry` ENABLE KEYS */;


--
-- Table structure for table `railway`.`reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `etrainno` double default NULL,
  `etrainname` varchar(45) default NULL,
  `eclass` varchar(45) default NULL,
  `esource` varchar(45) default NULL,
  `edestination` varchar(45) default NULL,
  `eboarding` varchar(45) default NULL,
  `edate` varchar(45) default NULL,
  `seats` int(10) unsigned default NULL,
  `upper` int(10) unsigned default NULL,
  `lower` int(10) unsigned default NULL,
  `middle` int(10) unsigned default NULL,
  `total_cost` int(10) unsigned default NULL,
  `pid` int(10) unsigned default NULL,
  `epnr` int(11) default NULL,
  KEY `pid` (`pid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `passenger` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`reservation`
--

/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`etrainno`,`etrainname`,`eclass`,`esource`,`edestination`,`eboarding`,`edate`,`seats`,`upper`,`lower`,`middle`,`total_cost`,`pid`,`epnr`) VALUES 
 (1001,'shatabdi','genral','lucknow','kanpur','lucknow','19-8-2016',2,1,1,0,0,1,1),
 (1001,'shtabdi','Sleeper','lucknow','allahabad','lucknow','12-09-2016',3,1,0,2,240,2,2),
 (1001,'shatabdi','General','lucknow','kanpur','lucknow','12-11-2016',4,2,1,1,200,3,3),
 (1001,'shatabdi','AC','lucknow','kanpur','lucknow','12-12-2016',3,1,2,0,360,4,4);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;


--
-- Table structure for table `railway`.`signup`
--

DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `name` varchar(45) default NULL,
  `dateofbirth` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `userid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `quest` varchar(45) NOT NULL,
  `answer` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `railway`.`signup`
--

/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` (`name`,`dateofbirth`,`gender`,`userid`,`password`,`quest`,`answer`) VALUES 
 ('meera saxena','13-4-1956','Female','meera123','saxena123','ddggdsjs','sshhsshj');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
