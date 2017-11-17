-- phpMyAdmin SQL Dump
-- version 4.2.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 02, 2016 at 12:32 AM
-- Server version: 5.5.38
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `510labs`
--

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_docter_detail`
--

CREATE TABLE IF NOT EXISTS `pmohan_docter_detail` (
  `docId` int(11) NOT NULL,
  `docName` varchar(100) NOT NULL,
  `specilaist` varchar(50) NOT NULL,
  `phone` int(12) NOT NULL,
  `location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pmohan_docter_detail`
--

INSERT INTO `pmohan_docter_detail` (`docId`, `docName`, `specilaist`, `phone`, `location`) VALUES
(3322, 'pradeep', 'general', 984153315, 'india'),
(3323, 'raja', 'surgery', 846132, 'chennai');

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_family_details`
--

CREATE TABLE IF NOT EXISTS `pmohan_family_details` (
  `fid` int(5) DEFAULT NULL,
  `fname` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pmohan_family_details`
--

INSERT INTO `pmohan_family_details` (`fid`, `fname`, `address`, `phone`) VALUES
(2222, 'b', NULL, NULL),
(2223, 'pra', NULL, NULL),
(2224, 'dd', NULL, NULL),
(222, 'd', NULL, NULL),
(2225, 'tamil', NULL, NULL),
(2226, 'fggfad''', NULL, NULL),
(2227, 'geethu', NULL, NULL),
(2227, 'prem', NULL, NULL),
(2228, 'view', NULL, NULL),
(2228, 'show', NULL, NULL),
(2229, 'dfghj', NULL, NULL),
(2230, 'patient', NULL, NULL),
(2231, 'dd', NULL, NULL),
(2232, 's', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_login`
--

CREATE TABLE IF NOT EXISTS `pmohan_login` (
`id` int(5) NOT NULL COMMENT 'vbn',
  `username` varchar(25) NOT NULL DEFAULT '',
  `password` varchar(25) NOT NULL,
  `role` tinyint(1) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3324 ;

--
-- Dumping data for table `pmohan_login`
--

INSERT INTO `pmohan_login` (`id`, `username`, `password`, `role`) VALUES
(12, 'ID', 'ID', 0),
(31, 'pradeep', 'pradeep', 0),
(32, 'vicky', 'vicky', 0),
(33, 'geethu', 'geethu', 0),
(34, 'dinesh', 'dinesh', 0),
(44, 'moein', 'moein', 0),
(45, 'prad', 'prad', 0),
(46, 'dd', 'dd', 0),
(48, 'tamil', 'tamil', 0),
(49, 'Otha', 'Omalae', 0),
(50, 'geeth', 'geeth', 0),
(51, 'prem', 'prem', 0),
(52, 'view', 'view', 0),
(53, 'show', 'show', 0),
(54, 'm', 'm', 0),
(55, 'patient', 'patient', 0),
(56, 'ddddd', 'ddddd', 0),
(57, 's', 's', 0),
(3322, 'd', 'd', 1),
(3323, 'doctor', 'doctor', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_medicine`
--

CREATE TABLE IF NOT EXISTS `pmohan_medicine` (
  `medicineName` varchar(50) NOT NULL,
  `review` varchar(500) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `Did` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pmohan_medicine`
--

INSERT INTO `pmohan_medicine` (`medicineName`, `review`, `pid`, `pname`, `Did`) VALUES
('amaalgam', 'gjuilj', 31, 'pradeep', 0),
('paracitomol', 'kbekl', 31, 'pradeep', 0),
('amaalgam', 'mnmmnmn', 31, 'pradeep', 0),
('amaalgam', 'sdfsdf', 31, 'pradeep', 3322),
('amaalgam', 'dfghjk', 31, 'pradeep', 3322),
('paracitomol', 'poi savu', 31, 'pradeep', 3322),
('Famotidine', '', 31, 'pradeep', 3322),
('paracitomol', '', 31, 'pradeep', 3322),
('paracitomol', 'g', 31, 'pradeep', 3322),
('Forteo', 'fghjkl', 54, 'm', 3323),
('Tadalafil', 'ffffffffff', 55, 'patient', 3323),
('Thiotepa', 'evwe', 55, 'patient', 3323),
('Terramycin', 'sethutan da', 31, 'pradeep', 3322),
('Aminosyn II 8.5%', 'vbnjmkl', 57, 's', 3323);

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_medicine_details`
--

CREATE TABLE IF NOT EXISTS `pmohan_medicine_details` (
`mid` int(5) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `mpurpose` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `pmohan_medicine_details`
--

INSERT INTO `pmohan_medicine_details` (`mid`, `mname`, `mpurpose`) VALUES
(1, 'Abarelix', 'general'),
(2, 'Actemra', 'heart'),
(3, 'Adderall', 'liver'),
(4, 'Aminosyn II 8.5%', 'general'),
(5, 'Famotidine', 'kungs'),
(6, 'Fenofibrate', 'general'),
(7, 'Flavoxate HCl', 'muscle'),
(8, 'Forteo', 'general'),
(20, 'Taclonex Scalp', 'general'),
(21, 'Tadalafil', 'general'),
(22, 'Terramycin', 'general'),
(23, 'Thiotepa', 'general'),
(24, 'Tobrex', 'general'),
(25, 'Tranexamic Acid', 'general'),
(26, 'Twynsta', 'general'),
(27, 'Xeloda', 'general'),
(28, 'Xyrem', 'general'),
(29, 'Icodextrin', 'general'),
(30, 'Inderide', 'general');

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_patient_details`
--

CREATE TABLE IF NOT EXISTS `pmohan_patient_details` (
  `fid` int(5) NOT NULL,
`pid` int(5) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dob` date NOT NULL,
  `age` int(11) NOT NULL,
  `docId` int(5) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=ucs2 AUTO_INCREMENT=58 ;

--
-- Dumping data for table `pmohan_patient_details`
--

INSERT INTO `pmohan_patient_details` (`fid`, `pid`, `firstname`, `lastname`, `gender`, `dob`, `age`, `docId`) VALUES
(12, 31, 'pradeep', 'pradeep', 'MALE', '2016-04-13', 12, 3322),
(12, 32, 'vicky', 'leone', 'MALE', '2016-04-14', 122, 3322),
(12, 33, 'geethu ', 'mami', 'FEMALE', '2016-04-11', 21, 3322),
(12, 34, 'dinesh', 'thala', 'MALE', '2016-03-30', 12, 3322),
(12, 41, 'IDDID', 'IDIDID', 'MALE', '2016-04-12', 12, 3322),
(12, 42, 'VIVEK', 'VEVEK', 'MALE', '2016-04-26', 22, 3322),
(12, 43, 'ghjk', 'hjk', 'MALE', '2016-04-06', 12, 3322),
(12, 44, 'moein', 'moein', 'MALE', '2010-04-21', 6, 3322),
(2223, 45, 'pra', 'prad', 'MALE', '2016-04-13', 2, 3322),
(2224, 46, 'dd', 'ddd', 'MALE', '2016-04-11', 0, 3322),
(222, 47, 'd', 'd', 'MALE', '2016-04-06', 0, 3322),
(2225, 48, 'tamil', 'arasan', 'MALE', '2013-04-23', 3, 3322),
(2226, 49, 'fggfad''', 'nskka', 'MALE', '2016-05-31', 0, 3322),
(2227, 50, 'geethu', 'ma', 'MALE', '2013-04-10', 3, 3323),
(2227, 51, 'prem', 'prem', 'FEMALE', '2013-04-24', 3, 3323),
(2228, 52, 'view', 'view', 'MALE', '2012-04-18', 4, 3323),
(2228, 53, 'show', 'show', 'MALE', '2015-04-01', 1, 3323),
(2229, 54, 'dfghj', 'dfghjnm', 'MALE', '2013-04-11', 3, 3323),
(2230, 55, 'patient', 'patient', 'FEMALE', '2013-04-26', 3, 3323),
(2231, 56, 'dd', 'dddd', 'MALE', '2016-05-25', 0, 3322),
(2232, 57, 's', 's', 'MALE', '2014-05-14', 2, 3323);

-- --------------------------------------------------------

--
-- Table structure for table `pmohan_prescription`
--

CREATE TABLE IF NOT EXISTS `pmohan_prescription` (
  `fid` int(5) NOT NULL,
  `pid` int(5) DEFAULT NULL,
  `docId` int(5) DEFAULT NULL,
  `mName` varchar(50) NOT NULL,
  `mpurpose` varchar(100) NOT NULL,
  `mTiming` varchar(10) NOT NULL,
  `pName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pmohan_prescription`
--

INSERT INTO `pmohan_prescription` (`fid`, `pid`, `docId`, `mName`, `mpurpose`, `mTiming`, `pName`) VALUES
(12, 32, 3322, 'anamica', 'diarreha', 'M-0-N', 'vicky'),
(12, 33, 3322, 'diet iru', 'gundu', 'M-0-N', 'geethu '),
(12, 33, 3322, 'phone erichidu', 'selfi addict', '0-A-N', 'geethu '),
(12, 34, 3322, 'diet iru di', 'faaattty', 'M-A-0', 'dinesh'),
(12, 41, 3322, 'Famotidine', 'dfgb', 'M-0-0', 'IDDID'),
(12, 32, 3322, 'Actemra', 'fgfgdf', 'M-0-0', 'vicky'),
(2225, 48, 3322, 'Actemra', 'kal vali', 'M-A-0', 'tamil'),
(12, 33, 3323, 'Tobrex', 'selfipula', 'M-0-N', 'geethu'),
(12, 33, 3323, 'Tadalafil', 'vbm', 'M-0-0', 'geethu'),
(12, 33, 3323, 'Abarelix', 'selfi addcit', 'M-0-N', 'geethu'),
(2227, 50, 3323, 'Abarelix', 'fghjk', '0-A-0', 'geethu'),
(2228, 52, 3323, 'Twynsta', 'hi', '0-A-0', 'view'),
(2228, 53, 3323, 'Tadalafil', 'hi', '0-A-0', 'show'),
(2229, 54, 3323, 'Forteo', 'bbbb', 'M-0-N', 'dfghj'),
(2230, 55, 3323, 'Tadalafil', 'problem', 'M-A-N', 'patient'),
(2230, 55, 3323, 'Thiotepa', 'hello world', 'M-A-0', 'patient'),
(12, 31, 3322, 'Terramycin', 'savvuuuuu da', 'M-0-N', 'pradeep'),
(2232, 57, 3323, 'Tranexamic Acid', 'dd', 'M-0-0', 's'),
(2232, 57, 3323, 'Aminosyn II 8.5%', 'sssssss', 'M-0-N', 's');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pmohan_login`
--
ALTER TABLE `pmohan_login`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pmohan_medicine_details`
--
ALTER TABLE `pmohan_medicine_details`
 ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `pmohan_patient_details`
--
ALTER TABLE `pmohan_patient_details`
 ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `pmohan_prescription`
--
ALTER TABLE `pmohan_prescription`
 ADD KEY `patient name_idx` (`pName`), ADD KEY `pid_idx` (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pmohan_login`
--
ALTER TABLE `pmohan_login`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'vbn',AUTO_INCREMENT=3324;
--
-- AUTO_INCREMENT for table `pmohan_medicine_details`
--
ALTER TABLE `pmohan_medicine_details`
MODIFY `mid` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `pmohan_patient_details`
--
ALTER TABLE `pmohan_patient_details`
MODIFY `pid` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
