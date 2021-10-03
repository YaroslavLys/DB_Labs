-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lys_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lys_db` DEFAULT CHARACTER SET utf8 ;
USE `lys_db` ;

-- -----------------------------------------------------
-- Table `lys_db`.`hotel_chain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lys_db`.`hotel_chain`;
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
DROP TABLE IF EXISTS `lys_db`.`country`;
CREATE TABLE IF NOT EXISTS `lys_db`.`country` (
  `name` VARCHAR(40) NOT NULL,
  `population` INT NULL,
  `area` INT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lys_db`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lys_db`.`region`;
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
DROP TABLE IF EXISTS `lys_db`.`city`;
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
DROP TABLE IF EXISTS `lys_db`.`hotel`;
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
DROP TABLE IF EXISTS `lys_db`.`user`;
CREATE TABLE IF NOT EXISTS `lys_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
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
DROP TABLE IF EXISTS `lys_db`.`review`;
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
DROP TABLE IF EXISTS `lys_db`.`security`;
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
DROP TABLE IF EXISTS `lys_db`.`room`;
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
DROP TABLE IF EXISTS `lys_db`.`reservation`;
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
DROP TABLE IF EXISTS `lys_db`.`amenity`;
CREATE TABLE IF NOT EXISTS `lys_db`.`amenity` (
  `id` INT NOT NULL AUTO_INCREMENT,
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

USE `lys_db` ;

INSERT INTO `lys_db`.`country` (`name`) VALUES ('Ukraine');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Poland');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Germany');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('United States');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('France');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Italy');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('China');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Japan');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Spain');
INSERT INTO `lys_db`.`country` (`name`) VALUES ('Russia');

INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Lviv Oblast', 'Ukraine');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Moscow Oblast', 'Russia');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Masovia', 'Poland');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Brandenburg', 'Germany');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Normandy', 'France');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Sicily', 'Italy');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('California', 'United States');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Catalonia', 'Spain');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Kansai', 'Japan');
INSERT INTO `lys_db`.`region` (`name`, `country_name`) VALUES ('Fujian', 'China');

INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Lviv', 'Lviv Oblast', 'Ukraine');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Berlin', 'Brandenburg', 'Germany');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Los Angeles', 'California', 'United States');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Barselona', 'Catalonia', 'Spain');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Peking', 'Fujian', 'China');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Tokio', 'Kansai', 'Japan');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Warsaw', 'Masovia', 'Poland');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Moscow', 'Moscow Oblast', 'Russia');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Caen', 'Normandy', 'France');
INSERT INTO `lys_db`.`city` (`name`, `region_name`, `region_country_name`) VALUES ('Palermo', 'Sicily', 'Italy');

INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Best Western', 'Marketing cooperative');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Hilton', 'Subsidiary');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Holiday Inn', 'Public company');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Hanting Express', 'Marketing cooperative');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Home Inn', 'Public company');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Marriott', 'Marketing cooperative');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Mercure', 'Marketing cooperative');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Novotel', 'Public company');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Ramada', 'Marketing cooperative');
INSERT INTO `lys_db`.`hotel_chain` (`name`, `type`) VALUES ('Sheraton', 'Public company');

INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('The Albatros Hotel', '1', 'Barselona', 'Catalonia', 'Spain');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Elexus Hotel', '2', 'Berlin', 'Brandenburg', 'Germany');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Blue Mountain', '3', 'Caen', 'Normandy', 'France');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Los Picos', '4', 'Los Angeles', 'California', 'United States');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('International Hotel Casino', '5', 'Lviv', 'Lviv Oblast', 'Ukraine');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Gold Hotel', '6', 'Moscow', 'Moscow Oblast', 'Russia');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Platinum Hotel', '7', 'Palermo', 'Sicily', 'Italy');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Best Hotel', '8', 'Peking', 'Fujian', 'China');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('Hotel Olimpia', '9', 'Tokio', 'Kansai', 'Japan');
INSERT INTO `lys_db`.`hotel` (`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES ('InterContinental', '10', 'Warsaw', 'Masovia', 'Poland');

INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('1', '496');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('2', '574');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('3', '357');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('4', '978');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('5', '675');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('6', '354');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('7', '768');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('8', '232');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('9', '342');
INSERT INTO `lys_db`.`room` (`hotel_id`, `room_number`) VALUES ('10', '987');

INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('1');
INSERT INTO `lys_db`.`amenity` ( `room_id`) VALUES ('2');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('3');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('4');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('5');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('6');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('7');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('8');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('9');
INSERT INTO `lys_db`.`amenity` (`room_id`) VALUES ('10');

INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Baran', 'Yuliya', 'yulbaran@gmail.com', 'female');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Borysov', 'Karyna', 'karborysova@gmail.com', 'female');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Sobol', 'Vladyslav', 'vlad1234@gmail.com', 'male');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Shevchuk', 'Milana', 'milashev@gmail.com', 'female');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Odarka', 'Oksana', 'odarkaa@gmail.com', 'female');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Melnyk', 'Davyd', 'davydmelnyk@gmail.com', 'male');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Pasternak', 'Yevgen', 'zhenia69@gmail.com', 'male');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Kovalenko', 'Viktoriya', 'kovalenkovika@gmail.com', 'female');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Tkachenko', 'Maks', 'maks42@gmail.com', 'male');
INSERT INTO `lys_db`.`user` (`surname`, `name`, `email`, `gender`) VALUES ('Gavrilyuk', 'Olexiy', 'alexgavrilyuk@gmail.com', 'male');

INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('1', 'vlad123', 'asdf');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('2', 'milash', 'qwer');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('3', 'odarkaa', 'zcxv');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('4', 'davydmelny', 'ghj');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('5', 'zhenia69', 'dfgh');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('6', 'kovalenkovika', 'tyui');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('7', 'maks4', 'gjhk');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('8', 'alexgavrily', 'bmpi');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('9', 'yulbaran', '3456');
INSERT INTO `lys_db`.`security` (`user_id`, `login`, `password`) VALUES ('10', 'karborys', 'jhg');

INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('1', '10');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('2', '9');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('3', '8');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('4', '7');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('5', '6');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('6', '5');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('7', '4');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('8', '3');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('9', '2');
INSERT INTO `lys_db`.`review` (`hotel_id`, `user_id`) VALUES ('10', '1');

INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('1', '10');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('2', '9');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('3', '8');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('4', '7');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('5', '6');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('6', '5');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('7', '4');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('8', '3');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('9', '2');
INSERT INTO `lys_db`.`reservation` (`user_id`, `room_id`) VALUES ('10', '1');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
