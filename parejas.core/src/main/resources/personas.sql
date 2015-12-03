--connect ${db.url}
CREATE TABLE `test`.`personas` (
  `id` INTEGER UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INTEGER UNSIGNED NOT NULL,
  `altura` FLOAT NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;
