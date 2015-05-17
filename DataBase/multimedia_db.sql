-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 29, 2015 at 07:53 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `multimedia_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Admin_Id` varchar(30) NOT NULL,
  `Email_Id` varchar(40) NOT NULL,
  `First_Name` varchar(20) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `Password` varchar(35) NOT NULL,
  PRIMARY KEY (`Admin_Id`),
  UNIQUE KEY `Email_Id` (`Email_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_Id`, `Email_Id`, `First_Name`, `Last_Name`, `Password`) VALUES
('asimzaman11', 'asimzaman16@gmail.com', 'Asim', 'Zaman', 'asim1234');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `Category_Id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'primary key of table',
  `Name` varchar(30) NOT NULL,
  PRIMARY KEY (`Category_Id`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Category_Id`, `Name`) VALUES
(1, 'Animation'),
(3, 'Comedy'),
(2, 'Documentary'),
(5, 'Dramas'),
(10, 'Educational'),
(7, 'Horror'),
(11, 'Islamic'),
(6, 'Movies'),
(9, 'Music'),
(8, 'News'),
(4, 'Sports');

-- --------------------------------------------------------

--
-- Table structure for table `channel`
--

CREATE TABLE IF NOT EXISTS `channel` (
  `Channel_Id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'primary key of table',
  `Name` varchar(30) NOT NULL,
  PRIMARY KEY (`Channel_Id`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `channel`
--

INSERT INTO `channel` (`Channel_Id`, `Name`) VALUES
(5, 'A Plus'),
(11, 'ARY Digital'),
(2, 'Ary News'),
(13, 'AVT KHYBER'),
(1, 'Geo News'),
(12, 'Geo Super'),
(10, 'HBO'),
(7, 'Khyber News'),
(6, 'PTV Home'),
(4, 'PTV Sports'),
(9, 'Star Sports'),
(3, 'Ten Sports'),
(8, 'TV One');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `Comment_Id` int(32) NOT NULL AUTO_INCREMENT,
  `Comment` text NOT NULL,
  `Content_Id` int(32) NOT NULL,
  `User_Name` varchar(30) NOT NULL,
  PRIMARY KEY (`Comment_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`Comment_Id`, `Comment`, `Content_Id`, `User_Name`) VALUES
(1, 'very lesson full video', 3, 'asim123');

-- --------------------------------------------------------

--
-- Table structure for table `mm_content`
--

CREATE TABLE IF NOT EXISTS `mm_content` (
  `Content_Id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'primary key of table',
  `Title` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `Icon` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Ratting` int(32) DEFAULT NULL,
  `Like` int(32) DEFAULT NULL,
  `Type` varchar(25) NOT NULL,
  `size` int(32) NOT NULL,
  `Content_Path` varchar(50) NOT NULL,
  `Icon_Path` varchar(50) NOT NULL,
  `Admin_Id` varchar(30) NOT NULL,
  `Category_Id` int(4) NOT NULL,
  `Channel_Id` int(4) NOT NULL,
  PRIMARY KEY (`Content_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `mm_content`
--

INSERT INTO `mm_content` (`Content_Id`, `Title`, `Description`, `Icon`, `Date`, `Ratting`, `Like`, `Type`, `size`, `Content_Path`, `Icon_Path`, `Admin_Id`, `Category_Id`, `Channel_Id`) VALUES
(1, 'Son Back To Home', 'the Son is found after 4-6 years and come back to home.... ', 'son back to home', '2015-04-25', NULL, NULL, 'mp4', 112233, 'contents/sonback.mp4', 'icons/son.PNG', 'asimzaman11', 8, 7),
(2, 'About Cheelam', 'A Vidoe About Cheelam Or Sheesha By Khyber News... ', 'Cheelam', '2015-04-25', NULL, NULL, '3gp', 204008, 'contents/About cheelam.3gp', 'icons/cheelam.PNG', 'asimzaman11', 8, 7),
(3, 'School', 'About School Different Education System In Pakistan...', 'School', '2015-04-17', NULL, NULL, '3gp', 2000023, 'contents/About School 2.3gp', 'icons/school.PNG', 'asimzaman11', 8, 7),
(4, 'Traffic Police', 'Khyber News Team Inspecting the services of Traffic Police Traffic Police Taking money from Drivers....', 'Traffic Police', '2015-04-26', NULL, NULL, '3gp', 2000023, 'contents/Contenar part.3gp', 'icons/cont.PNG', 'asimzaman11', 8, 7),
(5, 'Dance', 'Traditional Pakhtoon gada ...', 'Dance', '2015-04-26', NULL, NULL, '3gp', 239567, 'contents/dance.3gp', 'icons/dance.JPG', 'asimzaman11', 9, 11),
(6, 'Dil Raj Da Gula', 'Pashto Tapee....', 'Dil Raj Da Gula', '2015-04-26', NULL, NULL, 'mp3', 120090, 'contents/DIL RAAJ DA GULA.mp3', 'icons/dil.JPG', 'asimzaman11', 9, 11),
(7, 'Hashmy janan', 'Pashto naat Pa Hashme Janan By ...', 'Pa Hashme', '2015-04-26', NULL, NULL, 'mp3', 2345, 'contents/pa hashamy.mp3', 'icons/hashmy.JPG', 'asimzaman11', 11, 6),
(8, 'Ghairat song', 'New Pahto Film Ghairat Song', 'Gairat', '2015-04-26', NULL, NULL, 'mp4', 12345, 'contents/ghairat.mp4', 'icons/ghairat.PNG', 'asimzaman11', 9, 10),
(9, 'Ghairat Movie song', 'New Pashto Movie Ghairat song...', 'Ghairat', '2015-04-26', NULL, NULL, 'mp4', 123412, 'contents/ghairat1.mp4', 'icons/ghairat1.PNG', 'asimzaman11', 9, 10),
(10, 'Musafar', 'Khyber News Program ''Jwand Da Musafaroo'' about the life of pakistani residents in UAE PART 1', 'Musafar', '2015-04-26', NULL, NULL, 'mp4', 12321, 'contents/musafar.mp4', 'icons/musafar.PNG', 'asimzaman11', 8, 7),
(11, 'Musafar Part2', 'Khyber News Program ''Jwand Da Musafaroo'' about the life of pakistani residents in UAE PART 2', 'musafar Part2', '2015-04-26', NULL, NULL, 'mp4', 19546448, 'contents/musafar1.mp4', 'icons/musafar1.PNG', 'asimzaman11', 8, 7),
(12, 'Musafar Part3', 'Khyber News Program ''Jwand Da Musafaroo'' about the life of pakistani residents in UAE PART 3', 'Musafar Part3', '2015-04-26', NULL, NULL, 'mp4', 45678, 'contents/musafar2.mp4', 'icons/musafar2.PNG', 'asimzaman11', 8, 7),
(13, 'IMF', 'Khyber News Road Show About IMF And govt of Pakistan...', 'imf', '2015-04-26', NULL, NULL, '3gp', 23145, 'contents/I.M.F 4.3gp', 'icons/imf.PNG', 'asimzaman11', 8, 7),
(14, 'Muje Pyar Karo', 'Indian Movie Hindi Song "Muje Pyar Karo" with Video', 'Muje Pyar Karo', '2015-04-26', NULL, NULL, 'mp4', 123678, 'contents/muje pyar karo.mp4', 'icons/muje.PNG', 'asimzaman11', 9, 8),
(15, 'Muje Pyar Karo', 'Indian Movie Song "MUJE PYAR KARO" full mp3 ', 'Muje Pyar Karo', '2015-04-26', NULL, NULL, 'mp3', 12354, 'contents/muje pyar.mp3', 'icons/pyar.JPG', 'asimzaman11', 9, 8),
(16, 'TUM SE', 'indian movie song "TUM SE HAI DUNYA..."mp4 full song', 'Tum Se', '2015-04-26', NULL, NULL, 'mp4', 45321, 'contents/tum se he.mp4', 'icons/tumse.PNG', 'asimzaman11', 9, 8),
(17, 'Commedy Cercus', 'Commedy Performance By Shakeel And Oor washe At COmede Cercus...', 'Commedy Cercus', '2015-04-26', NULL, NULL, 'mp4', 6976817, 'contents/comede cercus.mp4', 'icons/comede cercus.PNG', 'asimzaman11', 3, 5),
(18, 'Afghan Army Dance', 'Afghan Army Dance(Atanr)VIDEO CLIP MP4 full...', 'Afghan Army Dance', '2015-04-26', NULL, NULL, 'mp4', 1234522, 'contents/afghan army.mp4', 'icons/afghan army.PNG', 'asimzaman11', 9, 13),
(19, 'Dil Tu He Bta', 'Indian Song "DIL TU HE BATA" mp4 ..', 'Dil Tu He ', '2015-04-14', NULL, NULL, 'mp4', 103450, 'contents/dil tu he.mp4', 'icons/dil tu he.JPG', 'asimzaman11', 9, 8);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `Order_Id` int(32) NOT NULL AUTO_INCREMENT,
  `Order_Date` date NOT NULL,
  `Content_Id` int(32) NOT NULL,
  `User_Name` varchar(30) NOT NULL,
  `Package_Id` int(4) NOT NULL,
  PRIMARY KEY (`Order_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_Id`, `Order_Date`, `Content_Id`, `User_Name`, `Package_Id`) VALUES
(1, '2015-04-26', 3, 'asim123', 3),
(2, '2015-04-26', 3, 'asim123', 3),
(3, '2015-04-26', 1, 'asim123', 3),
(4, '2015-04-26', 2, 'asim123', 3);

-- --------------------------------------------------------

--
-- Table structure for table `pay_package`
--

CREATE TABLE IF NOT EXISTS `pay_package` (
  `Package_Id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Price` int(4) NOT NULL,
  PRIMARY KEY (`Package_Id`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `pay_package`
--

INSERT INTO `pay_package` (`Package_Id`, `Name`, `Price`) VALUES
(1, 'Daily Package', 30),
(2, 'Weekly Package', 100),
(3, 'WeekEnd Package', 60),
(4, 'Monthly Package', 200);

-- --------------------------------------------------------

--
-- Table structure for table `r_user`
--

CREATE TABLE IF NOT EXISTS `r_user` (
  `User_Name` varchar(30) NOT NULL,
  `First_Name` varchar(20) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `Email_Id` varchar(40) NOT NULL,
  `Password` varchar(35) NOT NULL,
  `Activation_Code` varchar(20) NOT NULL,
  PRIMARY KEY (`User_Name`),
  UNIQUE KEY `Email_Id` (`Email_Id`),
  UNIQUE KEY `Activation_Code` (`Activation_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `r_user`
--

INSERT INTO `r_user` (`User_Name`, `First_Name`, `Last_Name`, `Email_Id`, `Password`, `Activation_Code`) VALUES
('asim123', 'Asim', 'Zaman', 'asimzaman16@gmail.com', 'asim4321', '1122');

-- --------------------------------------------------------

--
-- Table structure for table `subscribe`
--

CREATE TABLE IF NOT EXISTS `subscribe` (
  `Channel_Id` int(4) NOT NULL,
  `User_Name` varchar(30) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  PRIMARY KEY (`Channel_Id`,`User_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subscribe`
--

INSERT INTO `subscribe` (`Channel_Id`, `User_Name`, `Start_Date`, `End_Date`) VALUES
(3, 'asim123', '2015-04-27', '2015-06-01'),
(12, 'asim123', '2015-04-23', '2015-05-29');
