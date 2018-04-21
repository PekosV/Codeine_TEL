-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` INT NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `customer_boolean` TINYINT NOT NULL,
  `admin_boolean` TINYINT NOT NULL,
  `fee` INT NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`team` (
  `team_id` INT NOT NULL,
  `team_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE INDEX `teamcol_UNIQUE` (`team_name` ASC),
  UNIQUE INDEX `team_id_UNIQUE` (`team_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`team_has_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`team_has_user` (
  `team_team_id` INT NOT NULL,
  `user_iduser` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`team_team_id`, `user_iduser`),
  INDEX `fk_team_has_user_user1_idx` (`user_iduser` ASC),
  INDEX `fk_team_has_user_team1_idx` (`team_team_id` ASC),
  CONSTRAINT `fk_team_has_user_team1`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `mydb`.`team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_team_has_user_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`project` (
  `project_id` INT NOT NULL,
  `project_name` VARCHAR(45) NOT NULL,
  `team_team_id` INT NOT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC),
  UNIQUE INDEX `project_name_UNIQUE` (`project_name` ASC),
  INDEX `fk_project_team1_idx` (`team_team_id` ASC),
  CONSTRAINT `fk_project_team1`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `mydb`.`team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_has_project` (
  `user_iduser` INT UNSIGNED NOT NULL,
  `project_project_id` INT NOT NULL,
  `permissions` INT NOT NULL,
  PRIMARY KEY (`user_iduser`, `project_project_id`),
  INDEX `fk_user_has_project_project1_idx` (`project_project_id` ASC),
  INDEX `fk_user_has_project_user1_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_user_has_project_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_project_project1`
    FOREIGN KEY (`project_project_id`)
    REFERENCES `mydb`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
