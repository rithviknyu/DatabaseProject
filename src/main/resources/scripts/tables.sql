CREATE TABLE `prs_login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(225) DEFAULT NULL,
  `login_type` enum('CL','EL') DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `prs_customerlogintable` (
  `username` varchar(50) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  KEY `username` (`username`),
  KEY `customerId` (`customer_id`),
  CONSTRAINT `prs_customerlogintable_ibfk_1` FOREIGN KEY (`username`) REFERENCES `prs_login` (`username`),
  CONSTRAINT `prs_customerlogintable_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `prs_customer` (`custid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `prs_employeelogintable` (
  `username` varchar(50) DEFAULT NULL,
  `LocationId` int DEFAULT NULL,
  KEY `username` (`username`),
  KEY `LocationId` (`LocationId`),
  CONSTRAINT `prs_employeelogintable_ibfk_1` FOREIGN KEY (`username`) REFERENCES `prs_login` (`username`),
  CONSTRAINT `prs_employeelogintable_ibfk_2` FOREIGN KEY (`LocationId`) REFERENCES `prs_office_location` (`locationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
