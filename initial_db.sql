CREATE DATABASE  IF NOT EXISTS `expenses_tracker`;
USE `expenses_tracker`;

CREATE TABLE `expenses_tracker`.`category` (
  `CategoryId` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(45) NULL,
  PRIMARY KEY (`CategoryId`));
  
  
  CREATE TABLE `expenses_tracker`.`expense` (
  `ExpenseId` INT NOT NULL AUTO_INCREMENT,
  `Amount` DOUBLE NULL,
  `Date` DATETIME NULL,
  `CategoryId` INT NULL,
  PRIMARY KEY (`ExpenseId`),
  INDEX `CategoryId_idx` (`CategoryId` ASC) VISIBLE,
  CONSTRAINT `CategoryId`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `expenses_tracker`.`category` (`CategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	

CREATE TABLE `expenses_tracker`.`income` (
  `IncomeId` INT NOT NULL AUTO_INCREMENT,
  `Amount` DOUBLE NULL,
  `CategoryId` INT NOT NULL,
  `Date` DATETIME NOT NULL,
  PRIMARY KEY (`IncomeId`),
  INDEX `CategoryId_idx` (`CategoryId` ASC) VISIBLE,
  CONSTRAINT `CategoryId_Income`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `expenses_tracker`.`category` (`CategoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('1', 'General');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('2', 'Fuel');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('3', 'Clothes');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('4', 'Eating Out');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('5', 'Gifts');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('6', 'Sports');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('7', 'Travel');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('8', 'Kids');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('8', 'Fund');
INSERT INTO `expenses_tracker`.`category` (`CategoryId`, `CategoryName`) VALUES ('8', 'Rent');

