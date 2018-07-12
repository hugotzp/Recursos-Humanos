-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.2.6-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para base_rrhh
CREATE DATABASE IF NOT EXISTS `base_rrhh` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `base_rrhh`;

-- Volcando estructura para tabla base_rrhh.aspirante
CREATE TABLE IF NOT EXISTS `aspirante` (
  `Persona_idPersona` int(11) NOT NULL,
  `Reclutamiento_idReclutamiento` int(11) NOT NULL,
  `enProceso` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'Activo: 0\nDesactivo: 1',
  `SalarioEsperado` float NOT NULL,
  `idAspirante` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idAspirante`),
  KEY `fk_Persona_has_Reclutamiento_Reclutamiento1_idx` (`Reclutamiento_idReclutamiento`),
  KEY `fk_Persona_has_Reclutamiento_Persona1_idx` (`Persona_idPersona`),
  CONSTRAINT `fk_Persona_has_Reclutamiento_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_has_Reclutamiento_Reclutamiento1` FOREIGN KEY (`Reclutamiento_idReclutamiento`) REFERENCES `reclutamiento` (`idReclutamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.bonificacion
CREATE TABLE IF NOT EXISTS `bonificacion` (
  `idBonificacion` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL DEFAULT 0,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idBonificacion`),
  KEY `fk_Bonificacion_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_Bonificacion_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.calificacionesaspirante
CREATE TABLE IF NOT EXISTS `calificacionesaspirante` (
  `Aspirante_idAspirante` int(11) NOT NULL,
  `FaseReclutamiento_idFaseReclutamiento` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date DEFAULT NULL,
  `numeroFase` int(11) NOT NULL,
  `desempeño` varchar(45) NOT NULL,
  `idCalificacionesAspirante` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCalificacionesAspirante`),
  KEY `fk_Aspirante_has_FaseReclutamiento_FaseReclutamiento1_idx` (`FaseReclutamiento_idFaseReclutamiento`),
  KEY `fk_Aspirante_has_FaseReclutamiento_Aspirante1_idx` (`Aspirante_idAspirante`),
  CONSTRAINT `fk_Aspirante_has_FaseReclutamiento_Aspirante1` FOREIGN KEY (`Aspirante_idAspirante`) REFERENCES `aspirante` (`idAspirante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aspirante_has_FaseReclutamiento_FaseReclutamiento1` FOREIGN KEY (`FaseReclutamiento_idFaseReclutamiento`) REFERENCES `fasereclutamiento` (`idFaseReclutamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.cheque
CREATE TABLE IF NOT EXISTS `cheque` (
  `idCheque` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCheque` varchar(30) NOT NULL,
  `cuentaEmpresa` varchar(30) NOT NULL,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idCheque`),
  KEY `fk_Cheque_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_Cheque_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.efectivo
CREATE TABLE IF NOT EXISTS `efectivo` (
  `idEfectivo` int(11) NOT NULL AUTO_INCREMENT,
  `numeroBoleta` varchar(25) NOT NULL,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idEfectivo`),
  KEY `fk_Efectivo_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_Efectivo_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.empleo
CREATE TABLE IF NOT EXISTS `empleo` (
  `idEmpleo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpleo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.fasereclutamiento
CREATE TABLE IF NOT EXISTS `fasereclutamiento` (
  `idFaseReclutamiento` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idFaseReclutamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.fasesdereclutamiento
CREATE TABLE IF NOT EXISTS `fasesdereclutamiento` (
  `Reclutamiento_idReclutamiento` int(11) NOT NULL,
  `FaseReclutamiento_idFaseReclutamiento` int(11) NOT NULL,
  `idFasesDeReclutamiento` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idFasesDeReclutamiento`),
  KEY `fk_Reclutamiento_has_FaseReclutamiento_FaseReclutamiento1_idx` (`FaseReclutamiento_idFaseReclutamiento`),
  KEY `fk_Reclutamiento_has_FaseReclutamiento_Reclutamiento1_idx` (`Reclutamiento_idReclutamiento`),
  CONSTRAINT `fk_Reclutamiento_has_FaseReclutamiento_FaseReclutamiento1` FOREIGN KEY (`FaseReclutamiento_idFaseReclutamiento`) REFERENCES `fasereclutamiento` (`idFaseReclutamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reclutamiento_has_FaseReclutamiento_Reclutamiento1` FOREIGN KEY (`Reclutamiento_idReclutamiento`) REFERENCES `reclutamiento` (`idReclutamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.formulario
CREATE TABLE IF NOT EXISTS `formulario` (
  `idFormulario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `Paquete_idPaquete` int(11) NOT NULL,
  PRIMARY KEY (`idFormulario`),
  KEY `fk_Formulario_Paquete1_idx` (`Paquete_idPaquete`),
  CONSTRAINT `fk_Formulario_Paquete1` FOREIGN KEY (`Paquete_idPaquete`) REFERENCES `paquete` (`idPaquete`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.horasextra
CREATE TABLE IF NOT EXISTS `horasextra` (
  `idHorasExtra` int(11) NOT NULL AUTO_INCREMENT,
  `numeroHorasExtra` float NOT NULL,
  `salarioBase` float NOT NULL,
  `porcentajeHoraExtra` float NOT NULL,
  `totalHorasLaboradas` float NOT NULL,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idHorasExtra`),
  KEY `fk_HorasExtra_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_HorasExtra_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.igss
CREATE TABLE IF NOT EXISTS `igss` (
  `idIGSS` int(11) NOT NULL AUTO_INCREMENT,
  `porcentaje` float NOT NULL,
  `salarioBase` float NOT NULL,
  `horaExtra` float NOT NULL,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idIGSS`),
  KEY `fk_IGSS_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_IGSS_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.notadebito
CREATE TABLE IF NOT EXISTS `notadebito` (
  `idNotaDebito` int(11) NOT NULL AUTO_INCREMENT,
  `cuentaEmpresa` varchar(30) NOT NULL,
  `cuentaEmpleado` varchar(30) NOT NULL,
  `numeroNota` varchar(30) NOT NULL,
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idNotaDebito`),
  KEY `fk_NotaDebito_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_NotaDebito_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `idPago` int(11) NOT NULL AUTO_INCREMENT,
  `TotalPagado` float NOT NULL,
  `tipoPago` int(11) NOT NULL COMMENT '0: Efectivo\n1: Cheque\n2: Nota Debito',
  `Trabajador_idTrabajador` int(11) NOT NULL,
  `Planilla_idPlanillaGeneral` int(11) NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_Trabajador_has_Planilla_Planilla1_idx` (`Planilla_idPlanillaGeneral`),
  KEY `fk_Trabajador_has_Planilla_Trabajador1_idx` (`Trabajador_idTrabajador`),
  CONSTRAINT `fk_Trabajador_has_Planilla_Planilla1` FOREIGN KEY (`Planilla_idPlanillaGeneral`) REFERENCES `planilla` (`idPlanillaGeneral`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trabajador_has_Planilla_Trabajador1` FOREIGN KEY (`Trabajador_idTrabajador`) REFERENCES `trabajador` (`idTrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.paquete
CREATE TABLE IF NOT EXISTS `paquete` (
  `idPaquete` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idPaquete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.permiso
CREATE TABLE IF NOT EXISTS `permiso` (
  `idPermiso` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `DPI` varchar(13) NOT NULL,
  `Genero` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'hombre:1\nmujer:0',
  `FechaNacimiento` date NOT NULL,
  `Telefono` varchar(8) NOT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.planilla
CREATE TABLE IF NOT EXISTS `planilla` (
  `idPlanillaGeneral` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `Departamento_idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idPlanillaGeneral`),
  KEY `fk_Planilla_Departamento1_idx` (`Departamento_idDepartamento`),
  CONSTRAINT `fk_Planilla_Departamento1` FOREIGN KEY (`Departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `idPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `TotalPrestamo` float NOT NULL,
  `NumeroPagos` float NOT NULL,
  `Vigente` tinyint(4) NOT NULL COMMENT '0: Vigente\n1: Terminado',
  `Pago_idPago` int(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  KEY `fk_Prestamo_Pago1_idx` (`Pago_idPago`),
  CONSTRAINT `fk_Prestamo_Pago1` FOREIGN KEY (`Pago_idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.propuesta
CREATE TABLE IF NOT EXISTS `propuesta` (
  `idPropuesta` int(11) NOT NULL,
  `Empleo_idEmpleo` int(11) NOT NULL,
  `Descripcion` longtext NOT NULL,
  `Requisitos` longtext NOT NULL,
  `SalarioPropuesto` float NOT NULL,
  `Departamento_idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idPropuesta`),
  KEY `fk_Propuesta_Empleo1_idx` (`Empleo_idEmpleo`),
  KEY `fk_Propuesta_Departamento1_idx` (`Departamento_idDepartamento`),
  CONSTRAINT `fk_Propuesta_Departamento1` FOREIGN KEY (`Departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Propuesta_Empleo1` FOREIGN KEY (`Empleo_idEmpleo`) REFERENCES `empleo` (`idEmpleo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.reclutamiento
CREATE TABLE IF NOT EXISTS `reclutamiento` (
  `idReclutamiento` int(11) NOT NULL AUTO_INCREMENT,
  `fechaContratacion` date DEFAULT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date DEFAULT NULL,
  `Propuesta_idPropuesta` int(11) NOT NULL,
  PRIMARY KEY (`idReclutamiento`),
  KEY `fk_Reclutamiento_Propuesta1_idx` (`Propuesta_idPropuesta`),
  CONSTRAINT `fk_Reclutamiento_Propuesta1` FOREIGN KEY (`Propuesta_idPropuesta`) REFERENCES `propuesta` (`idPropuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `idRol` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.sequence
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(45) NOT NULL,
  `SEQ_COUNT` decimal(10,0) NOT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.trabajador
CREATE TABLE IF NOT EXISTS `trabajador` (
  `idTrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `Salario` float NOT NULL,
  `Persona_idPersona` int(11) NOT NULL,
  `Empleo_idEmpleo` int(11) NOT NULL,
  `Departamento_idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idTrabajador`),
  KEY `fk_Persona_has_Empleo_Empleo1_idx` (`Empleo_idEmpleo`),
  KEY `fk_Persona_has_Empleo_Persona1_idx` (`Persona_idPersona`),
  KEY `fk_Trabajador_Departamento1_idx` (`Departamento_idDepartamento`),
  CONSTRAINT `fk_Persona_has_Empleo_Empleo1` FOREIGN KEY (`Empleo_idEmpleo`) REFERENCES `empleo` (`idEmpleo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_has_Empleo_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trabajador_Departamento1` FOREIGN KEY (`Departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla base_rrhh.valordelpermiso
CREATE TABLE IF NOT EXISTS `valordelpermiso` (
  `Permiso_idPermiso` int(11) NOT NULL,
  `Rol_idRol` int(11) NOT NULL,
  `Formulario_idFormulario` int(11) NOT NULL,
  `acceso` tinyint(4) NOT NULL,
  `idValorDelPermiso` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idValorDelPermiso`),
  KEY `fk_Permiso_has_Rol_Rol1_idx` (`Rol_idRol`),
  KEY `fk_Permiso_has_Rol_Permiso1_idx` (`Permiso_idPermiso`),
  KEY `fk_ValorDelPermiso_Formulario1_idx` (`Formulario_idFormulario`),
  CONSTRAINT `fk_Permiso_has_Rol_Permiso1` FOREIGN KEY (`Permiso_idPermiso`) REFERENCES `permiso` (`idPermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Permiso_has_Rol_Rol1` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ValorDelPermiso_Formulario1` FOREIGN KEY (`Formulario_idFormulario`) REFERENCES `formulario` (`idFormulario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
