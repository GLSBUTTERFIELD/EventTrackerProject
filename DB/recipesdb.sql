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
-- Table `food_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `food_type` ;

CREATE TABLE IF NOT EXISTS `food_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `food_type_id` INT NOT NULL,
  `title` VARCHAR(150) NOT NULL,
  `description` VARCHAR(500) NULL,
  `servings` INT NULL,
  `prep_time_minutes` INT NULL,
  `cook_time_minutes` INT NULL,
  `directions` TEXT NULL,
  `source` VARCHAR(200) NULL,
  `website_url` VARCHAR(2000) NULL,
  `image_url` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE,
  INDEX `fk_recipe_food_type1_idx` (`food_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_recipe_food_type1`
    FOREIGN KEY (`food_type_id`)
    REFERENCES `food_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `recipe_id` INT NOT NULL,
  `title` VARCHAR(150) NOT NULL,
  `date_cooked` DATE NULL,
  `remarks` TEXT NULL,
  `difficulty` VARCHAR(45) NULL,
  `rating` DOUBLE NULL,
  `notes_for_future` VARCHAR(2000) NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_review_recipe1_idx` (`recipe_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingredient` ;

CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `quantity_amount` DOUBLE NULL,
  `quantity_unit` VARCHAR(45) NULL,
  `notes` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_ingredient` ;

CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `recipe_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  PRIMARY KEY (`recipe_id`, `ingredient_id`),
  INDEX `fk_recipe_has_ingredient_ingredient1_idx` (`ingredient_id` ASC) VISIBLE,
  INDEX `fk_recipe_has_ingredient_recipe_idx` (`recipe_id` ASC) VISIBLE,
  CONSTRAINT `fk_recipe_has_ingredient_recipe`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_ingredient_ingredient1`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `ingredient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_category` ;

CREATE TABLE IF NOT EXISTS `recipe_category` (
  `recipe_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`recipe_id`, `category_id`),
  INDEX `fk_recipe_has_category_category1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_recipe_has_category_recipe1_idx` (`recipe_id` ASC) VISIBLE,
  CONSTRAINT `fk_recipe_has_category_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `food_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `food_type` (`id`, `name`) VALUES (1, 'Asian');
INSERT INTO `food_type` (`id`, `name`) VALUES (2, 'Mexican');
INSERT INTO `food_type` (`id`, `name`) VALUES (3, 'Pasta');
INSERT INTO `food_type` (`id`, `name`) VALUES (4, 'Italian');
INSERT INTO `food_type` (`id`, `name`) VALUES (5, 'Indian');
INSERT INTO `food_type` (`id`, `name`) VALUES (6, 'American');

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe` (`id`, `food_type_id`, `title`, `description`, `servings`, `prep_time_minutes`, `cook_time_minutes`, `directions`, `source`, `website_url`, `image_url`, `create_date`, `last_update`, `enabled`) VALUES (1, 1, 'Korean Beef Bowls', 'kbb description', 2, 15, 30, 'kbb directions', NULL, NULL, NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `review` (`id`, `recipe_id`, `title`, `date_cooked`, `remarks`, `difficulty`, `rating`, `notes_for_future`, `last_update`, `enabled`) VALUES (1, 1, 'KBB', '2025-01-24', 'tasty!', 'easy', 4.5, 'start rice earlier', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `category` (`id`, `name`) VALUES (1, 'Breakfast');
INSERT INTO `category` (`id`, `name`) VALUES (2, 'Lunch');
INSERT INTO `category` (`id`, `name`) VALUES (3, 'Dinner');
INSERT INTO `category` (`id`, `name`) VALUES (4, 'Dessert');
INSERT INTO `category` (`id`, `name`) VALUES (5, 'Snack');
INSERT INTO `category` (`id`, `name`) VALUES (6, 'Vegetarian');
INSERT INTO `category` (`id`, `name`) VALUES (7, 'Gluten free');
INSERT INTO `category` (`id`, `name`) VALUES (8, 'Quick');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `ingredient` (`id`, `name`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 'White rice', NULL, NULL, '~20-25 minutes to cook');
INSERT INTO `ingredient` (`id`, `name`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 'Ground beef', 1, 'lb', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`) VALUES (1, 1);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (1, 3);

COMMIT;

