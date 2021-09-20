-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lys_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lys_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lys_db` DEFAULT CHARACTER SET utf8 ;
USE `lys_db` ;

-- -----------------------------------------------------
-- Table `lys_db`.`hotel_chain`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`hotel_chain` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `type` VARCHAR(60) NOT NULL,
  `parent_company` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`country` (
  `name` VARCHAR(40) NOT NULL,
  `population` INT NULL,
  `area` INT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`region` (
  `name` VARCHAR(45) NOT NULL,
  `country_name` VARCHAR(40) NOT NULL,
  `climate` VARCHAR(45) NULL,
  PRIMARY KEY (`name`, `country_name`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_region_country1_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_region_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `lys_db`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`city` (
  `name` VARCHAR(45) NOT NULL,
  `region_name` VARCHAR(45) NOT NULL,
  `region_country_name` VARCHAR(40) NOT NULL,
  `language` VARCHAR(45) NULL,
  PRIMARY KEY (`name`, `region_name`, `region_country_name`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_city_region1_idx` (`region_name` ASC, `region_country_name` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_name` , `region_country_name`)
    REFERENCES `lys_db`.`region` (`name` , `country_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `hotel_chain_id` INT NOT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  `city_region_name` VARCHAR(45) NOT NULL,
  `city_region_country_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotel_hotel_chain1_idx` (`hotel_chain_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_hotel_city1_idx` (`city_name` ASC, `city_region_name` ASC, `city_region_country_name` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_hotel_chain1`
    FOREIGN KEY (`hotel_chain_id`)
    REFERENCES `lys_db`.`hotel_chain` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_city1`
    FOREIGN KEY (`city_name` , `city_region_name` , `city_region_country_name`)
    REFERENCES `lys_db`.`city` (`name` , `region_name` , `region_country_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`user` (
  `id` INT NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(40) NOT NULL,
  `age` INT NULL,
  `birthday` DATETIME NULL,
  `phone` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(500) NULL,
  `rate` INT NULL,
  `hotel_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `lys_db`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lys_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`security` (
  `user_id` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  INDEX `fk_security_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_security_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lys_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hotel_id` INT NOT NULL,
  `room_number` VARCHAR(5) NOT NULL,
  `description` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_room_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `lys_db`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `room_id` INT NOT NULL,
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `payment_amount` DECIMAL(2) NULL,
  `adults` INT NULL,
  `kids` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservation_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_reservation_room1_idx` (`room_id` ASC) VISIBLE,
  CONSTRAINT `fk_reservation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lys_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `lys_db`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`amenity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lys_db`.`amenity` (
  `id` INT NOT NULL,
  `room_id` INT NOT NULL,
  `name` VARCHAR(50) NULL,
  `price` DECIMAL(2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_amenity_room1_idx` (`room_id` ASC) VISIBLE,
  CONSTRAINT `fk_amenity_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `lys_db`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
