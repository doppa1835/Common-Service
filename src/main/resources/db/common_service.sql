-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:21 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `common_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `address_desc` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `pincode` varchar(5) NOT NULL,
  `is_permanent` bit(1) NOT NULL DEFAULT b'0',
  `user_id` bigint(20) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `fax_number` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `campus`
--

CREATE TABLE `campus` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `college_id` bigint(20) NOT NULL,
  `is_main_campus` bit(1) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `code` varchar(100) CHARACTER SET utf8 NOT NULL,
  `theme_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE `college` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `code` varchar(100) CHARACTER SET utf8 NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `affiliated_to` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `id` bigint(20) NOT NULL,
  `type` varchar(45) CHARACTER SET utf8 NOT NULL,
  `complaint_by` bigint(20) NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 NOT NULL,
  `is_resolved` bit(1) NOT NULL,
  `action_taken` varchar(100) CHARACTER SET utf8 NOT NULL,
  `action_date` bigint(30) NOT NULL,
  `complaint_date` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `code` varchar(45) CHARACTER SET utf8 NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL DEFAULT b'0',
  `duration` varchar(45) CHARACTER SET utf8 NOT NULL,
  `in_take` int(10) NOT NULL DEFAULT 0,
  `course_fee` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `code` varchar(45) CHARACTER SET utf8 NOT NULL,
  `stream_id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `email_details`
--

CREATE TABLE `email_details` (
  `id` bigint(20) NOT NULL,
  `sender_email` varchar(45) CHARACTER SET utf8 NOT NULL,
  `receipent_email` varchar(45) CHARACTER SET utf8 NOT NULL,
  `template` varchar(45) CHARACTER SET utf8 NOT NULL,
  `status` varchar(45) CHARACTER SET utf8 NOT NULL,
  `type` varchar(45) CHARACTER SET utf8 NOT NULL,
  `sent_on` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL,
  `reported_by_id` bigint(20) NOT NULL,
  `reported_to_id` bigint(20) NOT NULL,
  `type(studen/faculty)` varchar(45) CHARACTER SET utf8 NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `description` varchar(45) CHARACTER SET utf8 NOT NULL,
  `rating` varchar(45) CHARACTER SET utf8 NOT NULL,
  `submitted_on` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `news_events`
--

CREATE TABLE `news_events` (
  `id` bigint(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `url` varchar(150) NOT NULL,
  `image_path` varchar(100) NOT NULL,
  `start_date` bigint(30) NOT NULL,
  `end_date` bigint(30) NOT NULL,
  `news_date` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL,
  `message` varchar(200) CHARACTER SET utf8 NOT NULL,
  `status` varchar(45) CHARACTER SET utf8 NOT NULL,
  `to_users` bigint(20) NOT NULL,
  `created_on` bigint(30) NOT NULL,
  `read_on` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `qualification`
--

CREATE TABLE `qualification` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `percentage/cgpa` varchar(45) CHARACTER SET utf8 NOT NULL,
  `is_cgpa` bit(1) NOT NULL,
  `type` varchar(45) CHARACTER SET utf8 NOT NULL,
  `institute` varchar(150) CHARACTER SET utf8 NOT NULL,
  `university` varchar(200) CHARACTER SET utf8 NOT NULL,
  `grade` varchar(50) CHARACTER SET utf8 NOT NULL,
  `from_date` bigint(30) NOT NULL,
  `to_date` bigint(30) NOT NULL,
  `certificate` varchar(100) CHARACTER SET utf8 NOT NULL,
  `other` varchar(150) CHARACTER SET utf8 NOT NULL,
  `is_highest_qualification` bit(1) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `institute_location` varchar(200) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `code` varchar(45) CHARACTER SET utf8 NOT NULL,
  `is_active` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `streams`
--

CREATE TABLE `streams` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `medium` varchar(50) CHARACTER SET utf8 NOT NULL,
  `is_active` bit(1) NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 NOT NULL,
  `campus_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `type` varchar(50) NOT NULL,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `internal_marks` int(11) NOT NULL,
  `external_marks` int(11) NOT NULL,
  `course_year` varchar(45) NOT NULL,
  `semester` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `subject_timetable`
--

CREATE TABLE `subject_timetable` (
  `id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `faculty_id` bigint(20) NOT NULL,
  `from_time` bigint(30) NOT NULL,
  `to_time` bigint(30) NOT NULL,
  `type` varchar(45) NOT NULL,
  `days` varchar(45) NOT NULL,
  `start_date` bigint(30) NOT NULL,
  `end_date` bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `theme`
--

CREATE TABLE `theme` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `campus_id` bigint(20) NOT NULL,
  `images` varchar(300) NOT NULL,
  `baner_images` varchar(300) NOT NULL,
  `logo_images` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `security_question` varchar(45) NOT NULL,
  `answer` varchar(45) NOT NULL,
  `is_active` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- Indexes for table `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `college_id_idx` (`college_id`),
  ADD KEY `address_id_idx` (`address_id`),
  ADD KEY `theme_id_idx` (`theme_id`);

--
-- Indexes for table `college`
--
ALTER TABLE `college`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address_id_idx` (`address_id`);

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`id`),
  ADD KEY `compaint_by_idx` (`complaint_by`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dept_id_idx` (`dept_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stream_id_idx` (`stream_id`);

--
-- Indexes for table `email_details`
--
ALTER TABLE `email_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reported_by_to_idx` (`reported_by_id`),
  ADD KEY `reported_to_id_idx` (`reported_to_id`),
  ADD KEY `subject_id_idx` (`subject_id`);

--
-- Indexes for table `news_events`
--
ALTER TABLE `news_events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `to_users_idx` (`to_users`);

--
-- Indexes for table `qualification`
--
ALTER TABLE `qualification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `streams`
--
ALTER TABLE `streams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `campus_id_idx` (`campus_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_id_idx` (`course_id`);

--
-- Indexes for table `subject_timetable`
--
ALTER TABLE `subject_timetable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id_idx` (`subject_id`),
  ADD KEY `faculty_id_idx` (`faculty_id`);

--
-- Indexes for table `theme`
--
ALTER TABLE `theme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `campus_id_idx` (`campus_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id_idx` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `campus`
--
ALTER TABLE `campus`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `college`
--
ALTER TABLE `college`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `email_details`
--
ALTER TABLE `email_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `news_events`
--
ALTER TABLE `news_events`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `qualification`
--
ALTER TABLE `qualification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `streams`
--
ALTER TABLE `streams`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject_timetable`
--
ALTER TABLE `subject_timetable`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `theme`
--
ALTER TABLE `theme`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `campus`
--
ALTER TABLE `campus`
  ADD CONSTRAINT `address_id1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `theme_id` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `college`
--
ALTER TABLE `college`
  ADD CONSTRAINT `address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `complaint`
--
ALTER TABLE `complaint`
  ADD CONSTRAINT `compaint_by` FOREIGN KEY (`complaint_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `stream_id` FOREIGN KEY (`stream_id`) REFERENCES `streams` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `reported_by_id` FOREIGN KEY (`reported_by_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `reported_to_id` FOREIGN KEY (`reported_to_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `to_users` FOREIGN KEY (`to_users`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `qualification`
--
ALTER TABLE `qualification`
  ADD CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `streams`
--
ALTER TABLE `streams`
  ADD CONSTRAINT `campus_id` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `subject_timetable`
--
ALTER TABLE `subject_timetable`
  ADD CONSTRAINT `faculty_id` FOREIGN KEY (`faculty_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `subject_id_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Constraints for table `theme`
--
ALTER TABLE `theme`
  ADD CONSTRAINT `campus_id1` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
