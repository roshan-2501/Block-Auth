-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2019 at 02:01 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecsauthority`
--

-- --------------------------------------------------------

--
-- Table structure for table `qrdocs`
--

CREATE TABLE `qrdocs` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `documents` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `verification`
--

CREATE TABLE `verification` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `requestType` varchar(255) DEFAULT NULL,
  `qrcode` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `verification`
--

INSERT INTO `verification` (`id`, `email`, `requestType`, `qrcode`, `status`) VALUES
(1, 'nitish@gmail.com', 'passport', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/nitish@gmail.com.png', 'issued'),
(2, 'nitish@gmail.com', 'license', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/nitish@gmail.com.png', 'issued'),
(3, 'a@gmail.com', 'passport', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/a@gmail.com.png', 'issued'),
(4, 'a@gmail.com', 'license', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/a@gmail.com.png', 'issued'),
(5, 'd@gmail.com', 'passport', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/d@gmail.com.png', 'issued'),
(6, 'd@gmail.com', 'license', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/d@gmail.com.png', 'issued'),
(7, 'k@gmail.com', 'passport', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/k@gmail.com.png', 'issued'),
(8, 'k@gmail.com', 'license', 'http://localhost:8888/ECSCentralBoardServer/QR Codes/k@gmail.com.png', 'issued');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `qrdocs`
--
ALTER TABLE `qrdocs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `verification`
--
ALTER TABLE `verification`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `qrdocs`
--
ALTER TABLE `qrdocs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `verification`
--
ALTER TABLE `verification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
