-- cheatsheet

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


--
-- Database: `megaapp`
--

CREATE DATABASE megaapp;
USE megaapp;

--
-- User for megaapp
--

CREATE USER megaapp_user@localhost identified with mysql_native_password by 'megaapp_app_user_pwd';
GRANT SELECT ON megaapp.* TO 'megaapp_user'@'localhost';

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(255) NOT NULL,
  `user_password` char(40) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=cp1251 AUTO_INCREMENT=2;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_login`, `user_password`) VALUES ('buga', '02c489c2827bdc42fb9159cb98fccdf174fe3b2e');
