-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ptoventa
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ptoventa
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ptoventa` ;
CREATE SCHEMA `ptoventa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ptoventa` ;

-- -----------------------------------------------------
-- Table `ptoventa`.`tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`tienda` (
  `nombre` VARCHAR(16) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `max_articulos` INT NULL DEFAULT '100',
  `max_vendedores` INT NULL DEFAULT '10',
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
 

-- -----------------------------------------------------
-- Table `ptoventa`.`energeticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`energeticas` (
  `marca` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `envase` CHAR(1) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `cafeina` DOUBLE NULL DEFAULT NULL,
  `taurina` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `precio` DECIMAL(15,2) NULL DEFAULT NULL,
  `idtienda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`marca`, `nombre`),
  INDEX `fke1_idx` (`idtienda` ASC) VISIBLE,
  CONSTRAINT `fke1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `ptoventa`.`tienda` (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ptoventa`.`art_energeticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`art_energeticas` (
  `marca` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `envase` CHAR(1) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `cafeina` DOUBLE NULL DEFAULT NULL,
  `taurina` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `precio` DECIMAL(15,2) NULL DEFAULT NULL,
  PRIMARY KEY (`marca`, `nombre`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ptoventa`.`art_energeticas`
  values ('MO-Tropic','Monster','A',330,0.001,0.005,12, 0.8);
insert into `ptoventa`.`art_energeticas`
  values ('MO-BlueIce','Monster','A',330,0.001,0.003,12, 0.8);
insert into `ptoventa`.`art_energeticas`
  values ('RB-Classic','RedBull','A',330,0.001,0.004,12, 0.8);
insert into `ptoventa`.`art_energeticas`
  values ('RB-Zero','RedBull','A',330,0.001,0.002,12, 0.8);  
-- -----------------------------------------------------
-- Table `ptoventa`.`refrescos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`refrescos` (
  `marca` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `envase` CHAR(1) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `nutriscore` CHAR(1) NULL DEFAULT NULL,
  `glucosa` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `precio` DECIMAL(15,2) NULL DEFAULT NULL,
  `idtienda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`marca`, `nombre`),
  INDEX `fkr1_idx` (`idtienda` ASC) VISIBLE,
  CONSTRAINT `fkr1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `ptoventa`.`tienda` (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ptoventa`.`art_refrescos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`art_refrescos` (
  `marca` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `envase` CHAR(1) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `nutriscore` CHAR(1) NULL DEFAULT NULL,
  `glucosa` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `precio` DECIMAL(15,2) NULL DEFAULT NULL,
  PRIMARY KEY (`marca`, `nombre`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ptoventa`.`art_refrescos` 
values ('ZU-Tropical','Zumosol','C',330,'E',0.006,  48,0.8);
insert into `ptoventa`.`art_refrescos` 
values ('FA-Fanta','Fanta','V',330,'D',0.003,  48,0.8);


-- -----------------------------------------------------
-- Table `ptoventa`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`vendedor` (
  `matricula` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `ventas` DOUBLE NULL DEFAULT '0',
  `vendedorcol` VARCHAR(45) NULL DEFAULT NULL,
  `idtienda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fkv1_idx` (`idtienda` ASC) VISIBLE,
  CONSTRAINT `fkv1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `ptoventa`.`tienda` (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



-- -----------------------------------------------------
-- Table `ptoventa`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ptoventa`.`personal` (
  `matricula` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ptoventa`.`personal` 
values (100,'Jorge','Ramirez Prado');
insert into `ptoventa`.`personal` 
values (101,'Carlos','Padial Cuesta');
insert into `ptoventa`.`personal` 
values (102,'Eduardo','Ruiz Castillo');
insert into `ptoventa`.`personal` 
values (103,'Juan','Mancha Pons');
insert into `ptoventa`.`personal` 
values (104,'Alfredo','Esteban Rivas');
insert into `ptoventa`.`personal` 
values (105,'Ramiro','Llorente Tui');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
