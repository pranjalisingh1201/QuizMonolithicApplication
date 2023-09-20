-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema question
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema question
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `question` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `question` ;

-- -----------------------------------------------------
-- Table `question`.`questiontb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question`.`questiontb` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `question_title` VARCHAR(255) NULL DEFAULT NULL,
  `option1` VARCHAR(255) NULL DEFAULT NULL,
  `option2` VARCHAR(255) NULL DEFAULT NULL,
  `option3` VARCHAR(255) NULL DEFAULT NULL,
  `option4` VARCHAR(255) NULL DEFAULT NULL,
  `right_answer` VARCHAR(255) NULL DEFAULT NULL,
  `difficultylevel` VARCHAR(255) NULL DEFAULT NULL,
  `category` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `question`.`quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question`.`quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `question`.`quiz_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question`.`quiz_questions` (
  `quiz_id` INT NOT NULL,
  `questions_id` INT NOT NULL,
  INDEX `FKqu5p1784w7e8mqt5f0hc1feeb` (`questions_id` ASC) VISIBLE,
  INDEX `FKcgp9e1c6ww3t383aui4w8feae` (`quiz_id` ASC) VISIBLE,
  CONSTRAINT `FKcgp9e1c6ww3t383aui4w8feae`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `question`.`quiz` (`id`),
  CONSTRAINT `FKqu5p1784w7e8mqt5f0hc1feeb`
    FOREIGN KEY (`questions_id`)
    REFERENCES `question`.`questiontb` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
