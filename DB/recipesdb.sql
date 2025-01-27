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
  `servings` VARCHAR(25) NULL,
  `prep_time_minutes` INT NULL,
  `cook_time_minutes` INT NULL,
  `total_time_minutes` INT NULL,
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
  `description` VARCHAR(500) NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe_ingredient` ;

CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `recipe_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  `quantity_amount` VARCHAR(45) NULL,
  `quantity_unit` VARCHAR(45) NULL,
  `notes` VARCHAR(100) NULL,
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
INSERT INTO `food_type` (`id`, `name`) VALUES (1, 'Other');
INSERT INTO `food_type` (`id`, `name`) VALUES (2, 'Korean');
INSERT INTO `food_type` (`id`, `name`) VALUES (3, 'Japanese');
INSERT INTO `food_type` (`id`, `name`) VALUES (4, 'Italian');
INSERT INTO `food_type` (`id`, `name`) VALUES (5, 'Indian');
INSERT INTO `food_type` (`id`, `name`) VALUES (6, 'American');
INSERT INTO `food_type` (`id`, `name`) VALUES (7, 'Vietnamese');

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe` (`id`, `food_type_id`, `title`, `description`, `servings`, `prep_time_minutes`, `cook_time_minutes`, `total_time_minutes`, `directions`, `source`, `website_url`, `image_url`, `create_date`, `last_update`, `enabled`) VALUES (1, 2, 'Korean Beef Bowls', 'Ground beef, veggies, and white rice with a flavorful Korean sauce.', '3-4', 10, 15, 25, '1. In a small bowl, whisk together brown sugar, soy sauce, sesame oil, red pepper flakes, and ginger.; 2. Heat vegetable oil in a large skillet over medium-high heat. Add garlic and cook, stirring constantly, until fragrant, about 1 minute. Add ground beef and cook until browned, about 3-5 minutes. Crumble the beef as it cookes; drain the excess fat.; 3. Stir in soy sauce mixture and green onions until combined. Simmer until heated through, about 2 minutes. Serve immediately with rice, vegetables, and whatever toppings you have on hand (fried egg, sesame seeds, furikake, kewpie, etc.).', 'Damn Delicious', 'https://damndelicious.net/2013/07/07/korean-beef-bowl/', 'https://s23209.pcdn.co/wp-content/uploads/2013/07/Korean-Beef-Bowl_111-760x1140.jpg.webp', '2025-01-01 12:00', '2025-01-01 12:00', 1);
INSERT INTO `recipe` (`id`, `food_type_id`, `title`, `description`, `servings`, `prep_time_minutes`, `cook_time_minutes`, `total_time_minutes`, `directions`, `source`, `website_url`, `image_url`, `create_date`, `last_update`, `enabled`) VALUES (2, 2, 'Green Onion Chili Oil Noodles', 'Vinegary and oniony with a little bit of heat and lots of sesame seeds. Enjoy with or without veggies or a protein.', '2', 5, 5, 10, '1. Cook the noodles per packaging.; 2. Add the spices, sesame seeds, and sugar together in a large pan.; 3. Heat the oil in a small pan over medium high heat, turn it off and immediately add green onions and garlic for a few seconds.; 4. Immediately pour over spices, sugar, and sesame seeds and mix together with soy sauce and red vinegar.; 5. Add in cooked noodles and mix well.', 'thespicyjuju', 'https://www.instagram.com/thespicyjuju/reel/CtPYcI6OueO/', NULL, '2025-01-01 12:00', '2025-01-01 12:00', 1);
INSERT INTO `recipe` (`id`, `food_type_id`, `title`, `description`, `servings`, `prep_time_minutes`, `cook_time_minutes`, `total_time_minutes`, `directions`, `source`, `website_url`, `image_url`, `create_date`, `last_update`, `enabled`) VALUES (3, 7, 'Spring Rolls', 'Refreshing and packed with flavor, these spring rolls are a fun way to get your vegetables in.', '10-12', 25, 5, 30, '1. Prep your fillings, cutting the vegetables into slices the desired length of your spring rolls. Season the tofu and airfry until cooked through.; 2. Make the peanut dipping sauce: combine the sweet chili sauce, peanut butter, soy sauce, and hoisin sauce to a food processor or blender and pulse until smooth.; 3. Cook the rice noodles per package directions.; 4. In a large bowl or pot of warm water, gently soak one rice paper wrapper at a time for 10-15 seconds (the rice paper will continue to soften after being removed from the water so don\'t soak too long or your roll will tear).; 5. Lay your rice paper out and assemble your spring roll in the 1/3 closest to you, leaving space on each side. Start rolling from the bottom and roll the sides in, like you\'re rolling a burrito.; 6. Top with sesame seeds and serve with sweet chili sauce or other desired sauce.', 'Tastes Better from Scratch', 'https://tastesbetterfromscratch.com/fresh-spring-rolls/', 'https://tastesbetterfromscratch.com/wp-content/uploads/2018/03/Spring-Rolls-14.jpg', '2025-01-01 12:00', '2025-01-01 12:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `review` (`id`, `recipe_id`, `title`, `date_cooked`, `remarks`, `difficulty`, `rating`, `notes_for_future`, `last_update`, `enabled`) VALUES (1, 1, 'KBB', '2025-01-06', 'Perfect with fried onion, kewpie, siracha, avocado, and sesame seeds on top and seaweed sheets on the side.', 'easy', 8.5, 'Prep everything while the rice is cooking.', NULL, 1);
INSERT INTO `review` (`id`, `recipe_id`, `title`, `date_cooked`, `remarks`, `difficulty`, `rating`, `notes_for_future`, `last_update`, `enabled`) VALUES (2, 1, 'Korean Beef Bowls - but with Udon!', '2025-01-24', 'To mix things up, I used udon noodles instead of rice, and I think I like it better! The udon noodles are chewy and thick and hold the sauce well. For veggies I used carrots, broccoli, and onions.', 'easy', 9.0, 'Boil water for noodles while prepping everything, then cook beef and udon at the same time.', NULL, 1);
INSERT INTO `review` (`id`, `recipe_id`, `title`, `date_cooked`, `remarks`, `difficulty`, `rating`, `notes_for_future`, `last_update`, `enabled`) VALUES (3, 2, 'Easy Chili Oil Noodles', '2025-01-08', 'I love these noodles - the vinegar mixed with the sesame seeds and noodles is the perfect combination. The sauce is best with thick noodles with ridges that can hold the onions and sesame seeds.', 'easy', 8.0, 'Add thinly sliced vegetables like carrots and snow peas next time!', NULL, 1);
INSERT INTO `review` (`id`, `recipe_id`, `title`, `date_cooked`, `remarks`, `difficulty`, `rating`, `notes_for_future`, `last_update`, `enabled`) VALUES (4, 3, 'Girls Night Spring Rolls', '2025-01-18', 'These spring rolls are so easy to make and fun to share with a group! The tasks were easy to divide amongst ourselves, and we got to catch up and hang out while prepping everything. We set everything out like a buffet so everyone could make their own roll(s) to their liking. Everyone enjoyed the rolls and spending time together!', 'easy', 9.0, 'This recipe includes a lot of prepwork - having pre cut and washed vegetables will make your life easier! Or just make with lots of friends :)', NULL, NULL);

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
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (1, 'Oil', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (2, 'Salt and pepper', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (3, 'Garlic', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (4, 'Soy sauce', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (5, 'Grated ginger', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (6, 'Green onions', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (7, 'White rice', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (8, 'Ground beef', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (9, 'Red pepper flakes', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (10, 'Brown sugar', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (11, 'Gochugaru', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (12, 'Sesame seeds', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (13, 'Red vinegar', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (14, 'Noodles', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (15, 'Granulated sugar', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (16, 'Sesame oil', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (17, 'Rice paper spring roll wrappers', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (18, 'Vermicilli rice noodles', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (19, 'Carrots', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (20, 'Cucumbers', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (21, 'Cilantro', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (22, 'Tofu', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (23, 'Rotisserie chicken', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (24, 'Mint', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (25, 'Red peppers', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (26, 'Avocado', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (27, 'Lettuce', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (28, 'Sweet chili sauce', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (29, 'Peanut butter', NULL, NULL);
INSERT INTO `ingredient` (`id`, `name`, `description`, `image_url`) VALUES (30, 'Hoisin sauce', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_ingredient`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 1, '1', 'tbsp', 'vegetable oil');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 3, '3', 'cloves, minced', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 4, '1/4', 'cup', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 5, '1', 'tsp', 'feel free to add more');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 6, '2', NULL, 'thinly sliced');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 7, '2', 'cups', '20-25 min cook time');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 8, '1', 'lb', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 9, '1/2', 'tsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (1, 10, '1/3', 'cup', 'packed');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 1, '3', 'tbsp', 'neutral oil');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 6, '1/2', 'cup', 'sliced');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 3, '3', 'cloves, minced', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 11, '1/2', 'tsp', 'add less or more depending on spice tolerance');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 15, '1', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 12, '1', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 9, '1', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 4, '4', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 13, '2', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 16, '1', 'tbsp', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (2, 14, '2', 'packs', 'knife cut, udon, etc. Would not recommend with thin noodles like rice noodles.');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 17, '1', 'package', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 18, '1', 'package', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 19, '2', 'large carrots', 'peeled and shredded or sliced into thin strips');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 25, '1', 'pepper', 'sliced into thin strips');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 20, '1', 'cucumber', 'sliced into thin strips');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 22, '1', 'package', 'remove water and slice into thin strips');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 23, '1', 'chicken, shredded', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 24, '1', 'bunch', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 21, '1', 'bunch', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 26, '2', 'avocados, sliced', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 27, '1', 'bunch, chopped', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 28, '3/4', 'cup', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 29, '1/3', 'cup', 'smooth or crunchy');
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 4, '1/2', 'teaspoon', NULL);
INSERT INTO `recipe_ingredient` (`recipe_id`, `ingredient_id`, `quantity_amount`, `quantity_unit`, `notes`) VALUES (3, 30, '1/2', 'teaspoon ', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipesdb`;
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (1, 3);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (2, 3);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (2, 8);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (1, 8);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (2, 6);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (3, 2);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (3, 3);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (3, 7);
INSERT INTO `recipe_category` (`recipe_id`, `category_id`) VALUES (3, 8);

COMMIT;

