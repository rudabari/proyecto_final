-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto_final` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `proyecto_final` ;

-- -----------------------------------------------------
-- Table `proyecto_final`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`persona` (
  `IDENTIFICACION` INT NOT NULL,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `EDAD` INT NOT NULL,
  PRIMARY KEY (`IDENTIFICACION`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto_final`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`producto` (
  `CODIGO` INT NOT NULL,
  `DESCRIPCION` VARCHAR(50) NOT NULL,
  `PRECIO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  PRIMARY KEY (`CODIGO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto_final`.`facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`facturacion` (
  `NUMEROFACTURA` INT NOT NULL,
  `IDENTIFICACIONCLIENTE` INT NOT NULL,
  `CODIGOPRODUCTO` INT NOT NULL,
  `PRECIOUNITARIO` INT NOT NULL,
  `CANTIDADCOMPRADA` INT NOT NULL,
  `FECHAFACTURA` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`NUMEROFACTURA`, `IDENTIFICACIONCLIENTE`, `CODIGOPRODUCTO`),
  INDEX `ID_idx` (`IDENTIFICACIONCLIENTE` ASC) VISIBLE,
  INDEX `FACTURACION_PRODUCTOS_idx` (`CODIGOPRODUCTO` ASC) VISIBLE,
  CONSTRAINT `FACTURACION_CLIENTES`
    FOREIGN KEY (`IDENTIFICACIONCLIENTE`)
    REFERENCES `proyecto_final`.`persona` (`IDENTIFICACION`),
  CONSTRAINT `FACTURACION_PRODUCTOS`
    FOREIGN KEY (`CODIGOPRODUCTO`)
    REFERENCES `proyecto_final`.`producto` (`CODIGO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `proyecto_final` ;

-- -----------------------------------------------------
-- Placeholder table for view `proyecto_final`.`vistafacturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`vistafacturas` (`NUMEROFACTURA` INT, `FECHAFACTURACHAR` INT, `identificacioncliente` INT, `nombre` INT, `codigoproducto` INT, `descripcion` INT, `cantidadcomprada` INT, `preciounitario` INT, `SUBTOTAL` INT);

-- -----------------------------------------------------
-- View `proyecto_final`.`vistafacturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_final`.`vistafacturas`;
USE `proyecto_final`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `proyecto_final`.`vistafacturas` AS select `proyecto_final`.`facturacion`.`NUMEROFACTURA` AS `NUMEROFACTURA`,cast(`proyecto_final`.`facturacion`.`FECHAFACTURA` as char charset utf8mb4) AS `FECHAFACTURACHAR`,`proyecto_final`.`facturacion`.`IDENTIFICACIONCLIENTE` AS `identificacioncliente`,`proyecto_final`.`persona`.`NOMBRE` AS `nombre`,`proyecto_final`.`facturacion`.`CODIGOPRODUCTO` AS `codigoproducto`,`proyecto_final`.`producto`.`DESCRIPCION` AS `descripcion`,`proyecto_final`.`facturacion`.`CANTIDADCOMPRADA` AS `cantidadcomprada`,`proyecto_final`.`facturacion`.`PRECIOUNITARIO` AS `preciounitario`,(`proyecto_final`.`facturacion`.`CANTIDADCOMPRADA` * `proyecto_final`.`facturacion`.`PRECIOUNITARIO`) AS `SUBTOTAL` from ((`proyecto_final`.`facturacion` join `proyecto_final`.`persona`) join `proyecto_final`.`producto`) where ((`proyecto_final`.`facturacion`.`IDENTIFICACIONCLIENTE` = `proyecto_final`.`persona`.`IDENTIFICACION`) and (`proyecto_final`.`facturacion`.`CODIGOPRODUCTO` = `proyecto_final`.`producto`.`CODIGO`)) order by `proyecto_final`.`facturacion`.`NUMEROFACTURA`,`proyecto_final`.`facturacion`.`CODIGOPRODUCTO`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
