-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-03-2020 a las 17:29:14
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `damas`
--
CREATE DATABASE IF NOT EXISTS `damas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `damas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moviments`
--

CREATE TABLE `moviments` (
  `numeroPartida` int(64) NOT NULL,
  `numeroMoviments` int(64) NOT NULL,
  `tablerojuego` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `moviments`
--

INSERT INTO `moviments` (`numeroPartida`, `numeroMoviments`, `tablerojuego`) VALUES
(38, 2, 'X X X X  X   X X  X                             O O O O  O O O O'),
(38, 3, 'X X X X  X   X X  X                        O    O   O O  O O O O'),
(38, 5, 'X X X X  X   X X           X               O    O   O O  O O O O'),
(38, 6, 'X X X X  X   X X           X      O             O   O O  O O O O'),
(38, 8, 'X X X X  X   X X                  X             O   O O  O O O O');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `numeroPartida` int(255) NOT NULL,
  `data` date NOT NULL,
  `numeroMoviments` int(255) NOT NULL,
  `quiHaGuanyat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`numeroPartida`, `data`, `numeroMoviments`, `quiHaGuanyat`) VALUES
(38, '2020-03-05', 8, 'Guanya X'),
(39, '2020-03-05', 0, ''),
(40, '2020-03-05', 0, 'Empat'),
(41, '2020-03-05', 0, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `moviments`
--
ALTER TABLE `moviments`
  ADD PRIMARY KEY (`numeroPartida`,`numeroMoviments`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`numeroPartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `numeroPartida` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `moviments`
--
ALTER TABLE `moviments`
  ADD CONSTRAINT `moviments_ibfk_1` FOREIGN KEY (`numeroPartida`) REFERENCES `partida` (`numeroPartida`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
