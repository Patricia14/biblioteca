-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-04-2016 a las 17:34:48
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `carnet_administrador` varchar(8) NOT NULL,
  `nombre_administrador` varchar(25) NOT NULL,
  `apellido_administrador` varchar(25) NOT NULL,
  `telefono_administrador` varchar(9) NOT NULL,
  `direccion_administrador` varchar(50) NOT NULL,
  `correo_administrador` varchar(50) NOT NULL,
  `contraseña_administrador` varchar(8) NOT NULL,
  `id_tipo_administrador` int(2) NOT NULL,
  PRIMARY KEY (`carnet_administrador`),
  KEY `id_tipo_administrador` (`id_tipo_administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`carnet_administrador`, `nombre_administrador`, `apellido_administrador`, `telefono_administrador`, `direccion_administrador`, `correo_administrador`, `contraseña_administrador`, `id_tipo_administrador`) VALUES
('AH102589', 'Raúl Eduardo', 'Almora Hernández', '7896-3254', 'San Salvador, Calle Matamoros No. 310', 'raul_hernandez00@gmail.com', 'root', 2),
('DE521235', 'Douglas Odir', 'Duke Erazo', '7531-5432', 'San Salvador, Soyapango Las Margaritas Pasaje 2 n1', 'Doueglasodir@gmail.com', '12345678', 2),
('EV130075', 'Manuel Alejandro', 'Espinoza Valle', '2299-9825', 'Prados 4 de Venecia Grupo33 pj42 Casa#11', 'manuel-alejandro_02@hotmail.com', '4322', 1),
('HA118598', 'Rosario', 'Hernández Arias', '7896-0178', 'San Salvador, AV. 20 DE NOVIEMBRE NO.859-B', 'rosarioarias88@gmail.com', 'qwer1', 2),
('ML521234', 'Edgardo Mauricio', 'Pérez López', '75315431', 'San Salvador, Soyapango Reparto Los santos 2 psj 1', 'Edgardolopez@hotmail.com', '1234', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE IF NOT EXISTS `ejemplar` (
  `id_ejemplar` varchar(8) NOT NULL,
  `id_estado_ejemplar` varchar(8) NOT NULL,
  `estante` varchar(10) NOT NULL,
  PRIMARY KEY (`id_ejemplar`),
  KEY `id_estado_ejemplar` (`id_estado_ejemplar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id_ejemplar`, `id_estado_ejemplar`, `estante`) VALUES
('M1', 'EE4', 'E4'),
('M2', 'EE4', 'e5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_ejemplar`
--

CREATE TABLE IF NOT EXISTS `estado_ejemplar` (
  `id_estado` varchar(8) NOT NULL,
  `estado_nombre` varchar(25) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_ejemplar`
--

INSERT INTO `estado_ejemplar` (`id_estado`, `estado_nombre`, `descripcion`) VALUES
('EE1', 'prestado', 'libro permanece fuera de del resgistro'),
('EE2', 'reservado', 'no se puede encontrar '),
('EE3', 'perdido', 'no se encuentra en la BD'),
('EE4', 'existencia', 'se encuentra dentro de la BD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_prestamo`
--

CREATE TABLE IF NOT EXISTS `estado_prestamo` (
  `id_estado` varchar(8) NOT NULL,
  `estado_del_prestamo` varchar(10) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_prestamo`
--

INSERT INTO `estado_prestamo` (`id_estado`, `estado_del_prestamo`) VALUES
('EP1', 'Activo'),
('EP2', 'Reservado'),
('EP3', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE IF NOT EXISTS `material` (
  `codigo_material` varchar(8) NOT NULL,
  `nombre_material` varchar(50) NOT NULL,
  `id_tipo_material` int(8) NOT NULL,
  `resumen` varchar(100) NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `fecha_adquisicion` date NOT NULL,
  `cantidad_material` int(8) NOT NULL,
  PRIMARY KEY (`codigo_material`),
  KEY `id_tipo_material` (`id_tipo_material`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`codigo_material`, `nombre_material`, `id_tipo_material`, `resumen`, `fecha_publicacion`, `fecha_adquisicion`, `cantidad_material`) VALUES
('M1', 'El árbol generoso', 11, 'Narra la historia entre un niño y un árbol que se hacen amigos. ', '1964-10-10', '2013-08-12', 3),
('M2', 'Practica PostgreSQL ', 11, 'Técnicas y funciones avanzadas de SQL', '2002-05-05', '2011-01-11', 2),
('M3', 'Introducción a la programacion orientada a objetos', 22, 'En el video se muestra las partes básicas de las que consta la programación orientada a objetos  ', '2015-12-10', '2016-01-11', 2),
('M4', 'Caballo De Troya Jerusalen', 22, 'Caballo de Troya es una obra de género fantástico que consta de nueve libros publicados', '2014-12-04', '2015-01-10', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material_audiovisual`
--

CREATE TABLE IF NOT EXISTS `material_audiovisual` (
  `id_material_audiovisual` varchar(8) NOT NULL,
  `duracion` time NOT NULL,
  `codigo_material` varchar(8) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY (`id_material_audiovisual`),
  KEY `codigo_material` (`codigo_material`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `material_audiovisual`
--

INSERT INTO `material_audiovisual` (`id_material_audiovisual`, `duracion`, `codigo_material`, `descripcion`) VALUES
('AV3', '00:21:00', 'M3', 'CD'),
('AV4', '00:01:20', 'M4', 'DVD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material_escrito`
--

CREATE TABLE IF NOT EXISTS `material_escrito` (
  `id_material_escrito` varchar(8) NOT NULL,
  `ISBN` varchar(17) NOT NULL,
  `editorial` varchar(25) NOT NULL,
  `numero_paginas` varchar(7) NOT NULL,
  `codigo_material` varchar(8) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id_material_escrito`),
  KEY `codigo_material` (`codigo_material`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `material_escrito`
--

INSERT INTO `material_escrito` (`id_material_escrito`, `ISBN`, `editorial`, `numero_paginas`, `codigo_material`, `descripcion`) VALUES
('ME1', '978-0-06-025665-4', 'Harper & Row', '120', 'M1', ''),
('ME2', '156-592-84-2366-3', 'La torre', '103', 'M2', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE IF NOT EXISTS `personal` (
  `carnet_personal` varchar(8) NOT NULL,
  `nombre_personal` varchar(25) NOT NULL,
  `apellido_personal` varchar(25) NOT NULL,
  `correo_personal` varchar(50) NOT NULL,
  `telefono_personal` varchar(9) NOT NULL,
  `direccion_personal` varchar(50) NOT NULL,
  `id_tipo_personal` varchar(8) NOT NULL,
  PRIMARY KEY (`carnet_personal`),
  KEY `id_tipo_personal` (`id_tipo_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`carnet_personal`, `nombre_personal`, `apellido_personal`, `correo_personal`, `telefono_personal`, `direccion_personal`, `id_tipo_personal`) VALUES
('AP521236', 'Carlos Eduardo', 'Arenivar Palacios', 'arlo12@gmail.com', '7531-5434', 'Col. Escalón', 'TP2'),
('AW123456', 'Alejadro', 'Caminos', 'Ale_cam@gmail.com', '22290394', 'Colonia mexico', 'TP2'),
('FR102589', 'Edwin Eduardo', 'Flores Romero', 'Eduardo_flores83@gmail.com', '7852-9632', 'San Salvador, AV. 20 DE N', 'TP1'),
('GP098541', 'Miriam Elizabeth', 'García Peralta', 'Mirian_peralta96@gmail.com', '7103-9585', 'San Salvador, BLVD. Benit', 'TP2'),
('MM141011', 'Kevin Alejandro', 'Martinez Maldonado', 'martinezkevin@gmail.com', '7531-5435', 'San salvador,Soyapango, G', 'TP1'),
('OI423402', 'poakposdkpaosd', 'sdapsdpaks', 'iiojoijoijo', '32423454', 'adoasdoiasjd', 'TP2'),
('QR140595', 'Patricia', 'Quintanilla', 'patricia_12@gmail.com', '21090438', 'Col.San Andres', 'TP1'),
('RE102847', 'Pedro', 'Erazo', 'jose_@hotmail.com', '99999999', 'Colonia', 'TP1'),
('TE492304', 'oaskpdoakps', 'poskdpaokdsp', 'sdpoaksdpoa', '98749287', 'sdapokspdoa', 'TP2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo_material`
--

CREATE TABLE IF NOT EXISTS `prestamo_material` (
  `id_prestamo_material` int(8) NOT NULL AUTO_INCREMENT,
  `codigo_material_p_m` varchar(8) NOT NULL,
  `carnet_personal_p_m` varchar(8) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date NOT NULL,
  `personal_mora` float NOT NULL,
  `id_estado_prestamo` varchar(8) NOT NULL,
  PRIMARY KEY (`id_prestamo_material`),
  KEY `codigo_material_p_m` (`codigo_material_p_m`),
  KEY `id_estado_prestamo` (`id_estado_prestamo`),
  KEY `carnet_personal_p_m` (`carnet_personal_p_m`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `prestamo_material`
--

INSERT INTO `prestamo_material` (`id_prestamo_material`, `codigo_material_p_m`, `carnet_personal_p_m`, `fecha_prestamo`, `fecha_devolucion`, `personal_mora`, `id_estado_prestamo`) VALUES
(8, 'M1', 'AP521236', '2016-02-29', '2016-03-31', 0, 'EP3'),
(9, 'M1', 'AP521236', '2016-02-29', '2016-03-31', 0, 'EP3'),
(10, 'M1', 'AP521236', '2016-02-29', '2016-03-31', 0, 'EP3'),
(11, 'M2', 'OI423402', '2016-03-31', '2016-04-04', 0, 'EP3'),
(12, 'M2', 'RE102847', '2016-03-31', '2016-04-04', 0.25, 'EP1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_administrador`
--

CREATE TABLE IF NOT EXISTS `tipo_administrador` (
  `id_tipo_administrador` int(2) NOT NULL,
  `nombre_tipo_administrador` varchar(25) NOT NULL,
  PRIMARY KEY (`id_tipo_administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_administrador`
--

INSERT INTO `tipo_administrador` (`id_tipo_administrador`, `nombre_tipo_administrador`) VALUES
(1, 'Administrador'),
(2, 'Biblioteca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_material`
--

CREATE TABLE IF NOT EXISTS `tipo_material` (
  `id_tipo_material` int(8) NOT NULL,
  `nombre_tipo_material` varchar(25) NOT NULL,
  PRIMARY KEY (`id_tipo_material`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_material`
--

INSERT INTO `tipo_material` (`id_tipo_material`, `nombre_tipo_material`) VALUES
(11, 'Material escrito'),
(22, 'Material audiovisual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personal`
--

CREATE TABLE IF NOT EXISTS `tipo_personal` (
  `id_tipo_personal` varchar(8) NOT NULL,
  `nombre_personal_tipo` varchar(10) NOT NULL,
  `limite_material` int(2) NOT NULL,
  `mora_monto` double NOT NULL,
  PRIMARY KEY (`id_tipo_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_personal`
--

INSERT INTO `tipo_personal` (`id_tipo_personal`, `nombre_personal_tipo`, `limite_material`, `mora_monto`) VALUES
('TP1', 'Alumno', 3, 0),
('TP2', 'Maestro', 6, 0.25);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_tipo_administrador`) REFERENCES `tipo_administrador` (`id_tipo_administrador`);

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`id_estado_ejemplar`) REFERENCES `estado_ejemplar` (`id_estado`),
  ADD CONSTRAINT `ejemplar_ibfk_2` FOREIGN KEY (`id_ejemplar`) REFERENCES `material` (`codigo_material`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_tipo_material`) REFERENCES `tipo_material` (`id_tipo_material`);

--
-- Filtros para la tabla `material_audiovisual`
--
ALTER TABLE `material_audiovisual`
  ADD CONSTRAINT `material_audiovisual_ibfk_1` FOREIGN KEY (`codigo_material`) REFERENCES `material` (`codigo_material`);

--
-- Filtros para la tabla `material_escrito`
--
ALTER TABLE `material_escrito`
  ADD CONSTRAINT `material_escrito_ibfk_1` FOREIGN KEY (`codigo_material`) REFERENCES `material` (`codigo_material`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`id_tipo_personal`) REFERENCES `tipo_personal` (`id_tipo_personal`);

--
-- Filtros para la tabla `prestamo_material`
--
ALTER TABLE `prestamo_material`
  ADD CONSTRAINT `prestamo_material_ibfk_1` FOREIGN KEY (`codigo_material_p_m`) REFERENCES `material` (`codigo_material`),
  ADD CONSTRAINT `prestamo_material_ibfk_2` FOREIGN KEY (`id_estado_prestamo`) REFERENCES `estado_prestamo` (`id_estado`),
  ADD CONSTRAINT `prestamo_material_ibfk_3` FOREIGN KEY (`carnet_personal_p_m`) REFERENCES `personal` (`carnet_personal`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
