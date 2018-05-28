-- MySQL Script generated by MySQL Workbench
-- Sun May  6 11:51:48 2018
-- Model: New Model    Version: 1.0
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
  `iduser` INT  NOT NULL AUTO_INCREMENT,
`firstname` VARCHAR(45) NOT NULL,
`lastname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role`  VARCHAR(45) NOT NULL,
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
  `team_id` INT NOT NULL AUTO_INCREMENT,
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
  `user_iduser` INT  NOT NULL,
  PRIMARY KEY (`team_team_id`, `user_iduser`),
  INDEX `fk_team_has_user_user1_idx` (`user_iduser` ASC),
  INDEX `fk_team_has_user_team1_idx` (`team_team_id` ASC),
  CONSTRAINT `fk_team_has_user_team1`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `mydb`.`team` (`team_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_team_has_user_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`project` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `project_name` VARCHAR(45) NOT NULL,
  `team_team_id` INT NOT NULL,
  PRIMARY KEY (`project_id`) ,
  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC),
  UNIQUE INDEX `project_name_UNIQUE` (`project_name` ASC),
  INDEX `fk_project_team1_idx` (`team_team_id` ASC),
  CONSTRAINT `fk_project_team1`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `mydb`.`team` (`team_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_has_project` (
  `user_iduser` INT  NOT NULL,
  `project_project_id` INT NOT NULL,
  `permissions` INT NOT NULL,
  PRIMARY KEY (`user_iduser`, `project_project_id`),
  INDEX `fk_user_has_project_project1_idx` (`project_project_id` ASC),
  INDEX `fk_user_has_project_user1_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_user_has_project_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_project_project1`
    FOREIGN KEY (`project_project_id`)
    REFERENCES `mydb`.`project` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sprints`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sprints` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `deadline` VARCHAR(45) NOT NULL,
  `starting_date` VARCHAR(45) NOT NULL,
  `project_project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_sprints_project1_idx` (`project_project_id` ASC),
  CONSTRAINT `fk_sprints_project1`
    FOREIGN KEY (`project_project_id`)
    REFERENCES `mydb`.`project` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sprint_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sprint_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sprints_has_sprint_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sprints_has_sprint_task` (
  `sprints_id` INT NOT NULL,
  `sprint_task_id` INT NOT NULL,
  PRIMARY KEY (`sprints_id`, `sprint_task_id`),
  INDEX `fk_sprints_has_sprint_task_sprint_task1_idx` (`sprint_task_id` ASC),
  INDEX `fk_sprints_has_sprint_task_sprints1_idx` (`sprints_id` ASC),
  CONSTRAINT `fk_sprints_has_sprint_task_sprints1`
    FOREIGN KEY (`sprints_id`)
    REFERENCES `mydb`.`sprints` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sprints_has_sprint_task_sprint_task1`
    FOREIGN KEY (`sprint_task_id`)
    REFERENCES `mydb`.`sprint_task` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`epic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`epic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `due` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `priority` VARCHAR(45) NOT NULL,
  `affects versions` VARCHAR(45) NOT NULL,
  `storycol` VARCHAR(45) NULL,
  `team_team_id` INT NOT NULL,
  `epic_id` INT NOT NULL,
  `date_due` VARCHAR(45) NOT NULL,
  `date_created` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_story_team1_idx` (`team_team_id` ASC),
  INDEX `fk_story_epic1_idx` (`epic_id` ASC),
  CONSTRAINT `fk_story_team1`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `mydb`.`team` (`team_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_story_epic1`
    FOREIGN KEY (`epic_id`)
    REFERENCES `mydb`.`epic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`epic_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`epic_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `epic_id` INT NOT NULL,
  PRIMARY KEY (`id`, `epic_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_epic_task_epic1_idx` (`epic_id` ASC),
  CONSTRAINT `fk_epic_task_epic1`
    FOREIGN KEY (`epic_id`)
    REFERENCES `mydb`.`epic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tasks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `assigned_to` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `hours_worked` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `project_project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_tasks_project1_idx` (`project_project_id` ASC),
  CONSTRAINT `fk_tasks_project1`
    FOREIGN KEY (`project_project_id`)
    REFERENCES `mydb`.`project` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sub_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sub_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `assigned_to` VARCHAR(45) NOT NULL,
  `progress` INT NOT NULL,
  `hours_worked` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `tasks_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_sub_task_tasks1_idx` (`tasks_id` ASC),
  CONSTRAINT `fk_sub_task_tasks1`
    FOREIGN KEY (`tasks_id`)
    REFERENCES `mydb`.`tasks` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
