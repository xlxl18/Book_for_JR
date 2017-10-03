DROP DATABASE IF EXISTS test;

CREATE DATABASE test ;

USE test;

CREATE TABLE `book`
(
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(100) NOT NULL DEFAULT '0',
	`description` VARCHAR(255) NOT NULL DEFAULT '0',
	`author` VARCHAR(100) NOT NULL DEFAULT '0',
	`isbn` VARCHAR(20) NOT NULL DEFAULT '0',
	`printYear` INT DEFAULT '0',
	`readAlready` BOOLEAN DEFAULT false,
	 PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci';


INSERT INTO `book` (`id`,`title`,`description`,`author`,`isbn`, `printYear`, `readAlready`)
VALUES (1,"Iola","who are you?","I", "978-82-995326-9-3",2015, false),
       (2,"Christian","", "", "000-82-995326-9-3", 2011, false),
  (3,"Alfreda","", "", "000-82-995326-9-3", 2011, false),
  (4,"Dominic","", "", "000-82-995326-9-3", 2014, false),
  (5,"Lila","", "", "000-82-995326-9-3", 1998, false),
  (6,"Chase","", "", "000-82-995326-9-3", 1694, false),
  (7,"Eric","", "", "000-82-995326-9-3", 2017, false),
  (8,"Nora","", "", "000-82-995326-9-3", 2017, false),
  (9,"Hollee","", "", "000-82-995326-9-3", 2017, false),
  (10,"Troy","", "", "000-82-995326-9-3", 2011, false),
  (11,"Donna","", "", "000-82-995326-9-3", 2012, false),
  (12,"Laura","", "", "000-82-995326-9-3", 2014, false),
  (13,"Blake","", "", "000-82-995326-9-3", 2017, TRUE ),
  (14,"Dustin","", "", "000-82-995326-9-3", 2014, false),
  (15,"Callum","", "", "000-82-995326-9-3", 2014, false),
  (16,"Dacey","", "", "000-82-995326-9-3", 2012, false),
  (17,"Emily","", "", "000-82-995326-9-3", 2014, false),
  (18,"Denise","", "", "000-82-995326-9-3", 2010, false),
  (19,"Armand","", "", "000-82-995326-9-3", 2009, false),
 (20,"Iola","who are you?","I", "979-82-995326-9-3",2016, false);