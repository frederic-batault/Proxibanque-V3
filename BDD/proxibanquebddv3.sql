-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 25 avr. 2018 à 09:52
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquebddv3`
--
CREATE DATABASE IF NOT EXISTS `proxibanquebddv3` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `proxibanquebddv3`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  `codePostal` varchar(45) NOT NULL,
  `ville` varchar(45) NOT NULL,
  `idConseiller` int(11) NOT NULL,
  PRIMARY KEY (`idClient`),
  KEY `fk_conseiller_idx` (`idConseiller`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `email`, `adresse`, `codePostal`, `ville`, `idConseiller`) VALUES
(1, 'AAA', 'bbb', 'test@gtm.fr', 'test', 'test', 'test', 1),
(4, 'qsd', 'qsd', 'qsd@qsd', 'qsd', 'qsd', 'qsd', 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `idCompte` int(11) NOT NULL AUTO_INCREMENT,
  `numCompte` varchar(45) NOT NULL,
  `dateCreation` varchar(20) NOT NULL,
  `solde` float NOT NULL DEFAULT '0',
  `idTypeCompte` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `decouvert` float DEFAULT NULL,
  `taux` float DEFAULT NULL,
  PRIMARY KEY (`idCompte`),
  KEY `fk_type_idx` (`idTypeCompte`),
  KEY `fk_client_idx` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `numCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `decouvert`, `taux`) VALUES
(1, 'numCompte', '25-04-2018', 0, 1, 2, 1000, NULL),
(2, 'numCompte', '25-04-2018', 0, 2, 2, NULL, 0),
(3, 'numCompte', '25-04-2018', 0, 2, 4, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

DROP TABLE IF EXISTS `conseiller`;
CREATE TABLE IF NOT EXISTS `conseiller` (
  `idConseiller` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nbClients` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idConseiller`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nom`, `prenom`, `login`, `password`, `nbClients`) VALUES
(1, 'PRO', 'david', 'david.pro', '123', 0);

-- --------------------------------------------------------

--
-- Structure de la table `typecompte`
--

DROP TABLE IF EXISTS `typecompte`;
CREATE TABLE IF NOT EXISTS `typecompte` (
  `idTypeCompte` int(11) NOT NULL AUTO_INCREMENT,
  `nomType` varchar(45) NOT NULL,
  PRIMARY KEY (`idTypeCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `typecompte`
--

INSERT INTO `typecompte` (`idTypeCompte`, `nomType`) VALUES
(1, 'courant'),
(2, 'épargne');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
