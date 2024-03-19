USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Inserting data for table `users`
--

-- INSERT INTO `users` 
-- VALUES 
-- ('john','{noop}test123',1),
-- ('mary','{noop}test123',1),
-- ('susan','{noop}test123',1);

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$nsk0un83ejJjC.2r0EnKBeElmS3Q5LXAzvGM..DngHNKm8rvqx1ay',1),
('mary','{bcrypt}$2a$10$du5Dxo7GfRtKTwN6yliq3e9Mf3cbAmY1xHRKTxlmXulLoxCmd5ene',1),
('susan','{bcrypt}$2a$10$pVpDcOPAIa3zz87JuPZHZeXoqCdTOM47tw2TGBhftET5KIi1JaZtG',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');


