-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 13 déc. 2024 à 17:06
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `inscription`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` varchar(20) NOT NULL,
  `NomClient` varchar(20) NOT NULL,
  `Contact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `NomClient`, `Contact`) VALUES
('cl001', 'gabriel', 655432011),
('cl002', 'Guy', 5443678);

-- --------------------------------------------------------




--
-- Structure de la table `intervention`
--

CREATE TABLE `intervention` (
  `idIntervention` varchar(20) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `typeIntervention` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `Immatriculation` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`idIntervention`, `Date`, `typeIntervention`, `Description`, `Immatriculation`, `Nom`) VALUES
('inter1', '23/11/2024', 'diagnostic', 'pares brises endommagees', 'lt2379jrgn', 'Kamga'),
('inter2', '23/11/2024', 'reparation', 'qwertyuiop[', 'LT2002', 'ghil'),
('inter3', '12/10/2024', 'diagnostic', 'pneus dechires', 'lt53435', 'gab');

-- --------------------------------------------------------

--
-- Structure de la table `loginmecano`
--

CREATE TABLE `loginmecano` (
  `Nom` varchar(20) NOT NULL,
  `Motdepasse` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `loginmecano`
--

INSERT INTO `loginmecano` (`Nom`, `Motdepasse`) VALUES
('ghil', 'gab34');

-- --------------------------------------------------------

--
-- Structure de la table `mecanicien`
--

CREATE TABLE `mecanicien` (
  `idMecanicien` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `mecanicien`
--

INSERT INTO `mecanicien` (`idMecanicien`, `Nom`, `Telephone`) VALUES
('mecano1', 'Kamga', 678990765),
('mecano2', 'gab', 6778975),
('mecano3', 'Jacksn', 67890098),
('mecano4', 'Kamguia', 677890098);

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

CREATE TABLE `piece` (
  `refPiece` varchar(20) NOT NULL,
  `NomP` varchar(20) NOT NULL,
  `Quantite` int(11) NOT NULL,
  `Prixunitaire` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `piece`
--

INSERT INTO `piece` (`refPiece`, `NomP`, `Quantite`, `Prixunitaire`) VALUES
('piece1', 'Bougie', 50, 1000),
('piece2', 'Disque', 30, 5000),
('piece3', 'Moteur', 10, 20000),
('piece4', 'Gentes', 5, 10000),
('piece5', 'Batterie', 10, 25000);

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE `rapport` (
  `idRapport` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `NomClient` varchar(20) NOT NULL,
  `Immatriculation` varchar(20) NOT NULL,
  `typeIntervention` varchar(20) NOT NULL,
  `Nbrepieces` int(11) NOT NULL,
  `Details` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `rapport`
--

INSERT INTO `rapport` (`idRapport`, `Nom`, `NomClient`, `Immatriculation`, `typeIntervention`, `Nbrepieces`, `Details`) VALUES
('eesrqw', 'Kamga', 'gabriel', 'fufu', 'gh', 5, 'dfecfq	'),
('frytui', 'Kamga', 'gabriel', 'fufu', 'gh', 5, 'fgdertyuioijhbvc'),
('rapport1', 'Kamga', 'gabriel', 'fufu', 'reparation', 3, 'wrertyuij');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `Id` varchar(20) NOT NULL,
  `Nomutilisateur` varchar(20) NOT NULL,
  `Motdepasse` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`Id`, `Nomutilisateur`, `Motdepasse`) VALUES
('rtu24', 'gabou', 'gab2356');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `Immatriculation` varchar(20) NOT NULL,
  `Modele` varchar(20) NOT NULL,
  `Marque` varchar(20) NOT NULL,
  `idClient` varchar(20) NOT NULL,
  `NomClient` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`Immatriculation`, `Modele`, `Marque`, `idClient`, `NomClient`) VALUES
('fufu', 'finf', 'ind', '', ''),
('ghjkl', 'fghb', 'tgiujm', '', 'gabriel'),
('LT2002', 'Yaris', 'toyota', '', ''),
('lt234y', 'toyota camy', 'Toyota', 'cl002', 'Guy'),
('lt2379jrgn', 'rtyui', 'wretty', '', ''),
('lt43', 'fghj', 'dtyu', '', 'gabriel'),
('lt53435', 'mhg', 'yaris', '', ''),
('nana', 'nana', 'nan', '', ''),
('OU218TT', 'yifgq', 'tyuyufh', 'cl001', 'gabriel'),
('rfug', 'jidj', 'djid', '', ''),
('yuy', 'jidj', 'djid', '', '');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);




--
-- Index pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD PRIMARY KEY (`idIntervention`),
  ADD KEY `Immatriculation` (`Immatriculation`),
  ADD KEY `Nom` (`Nom`);

--
-- Index pour la table `loginmecano`
--
ALTER TABLE `loginmecano`
  ADD PRIMARY KEY (`Nom`);

--
-- Index pour la table `mecanicien`
--
ALTER TABLE `mecanicien`
  ADD PRIMARY KEY (`idMecanicien`);

--
-- Index pour la table `piece`
--
ALTER TABLE `piece`
  ADD PRIMARY KEY (`refPiece`);

--
-- Index pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`idRapport`),
  ADD KEY `Nom` (`Nom`),
  ADD KEY `NomClient` (`NomClient`),
  ADD KEY `Immatriculation` (`Immatriculation`),
  ADD KEY `typeIntervention` (`typeIntervention`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`Immatriculation`),
  ADD KEY `NomClient` (`NomClient`);

--
-- Contraintes pour les tables déchargées
--

--

--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
