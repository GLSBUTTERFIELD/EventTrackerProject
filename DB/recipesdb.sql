-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema recipesdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `recipesdb` ;

-- -----------------------------------------------------
-- Schema recipesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `recipesdb` DEFAULT CHARACTER SET utf8 ;
USE `recipesdb` ;

-- -----------------------------------------------------
-- Table `recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NOT NULL,
  `description` VARCHAR(500) NULL,
  `prep_time` INT NULL,
  `cook_time` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS recipesuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'recipesuser'@'localhost' IDENTIFIED BY 'recipes';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'recipesuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe` (`id`, `title`, `description`, `prep_time`, `cook_time`) VALUES (1, 'Korean Beef Bowls', 'kbb description', 15, 30);

COMMIT;

