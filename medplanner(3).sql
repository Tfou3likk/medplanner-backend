-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 03 jan. 2026 à 18:56
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
-- Base de données : `medplanner`
--
CREATE DATABASE IF NOT EXISTS `medplanner` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `medplanner`;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

DROP TABLE IF EXISTS `etablissement`;
CREATE TABLE `etablissement` (
  `id_etablissement` int(11) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `lieu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etablissement`
--

INSERT INTO `etablissement` (`id_etablissement`, `nom`, `lieu`) VALUES
(1, 'Hopital', 'Clocheville-Tours');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE `medecin` (
  `id_medecin` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_specialite` int(11) NOT NULL,
  `id_etablissement` int(11) NOT NULL,
  `duree_rdv` int(11) NOT NULL,
  `heure_embauche` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id_medecin`, `nom`, `prenom`, `id_specialite`, `id_etablissement`, `duree_rdv`, `heure_embauche`) VALUES
(2, 'Dupont', 'Jean', 1, 1, 15, '09:00:00'),
(3, 'Dupont', 'Jean', 1, 1, 15, '09:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `date_naissance` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `email`, `password`, `nom`, `prenom`, `date_naissance`) VALUES
(1, 'fares@etu.fr', '123', 'Farès', 'Denguiz', '2005-11-08'),
(2, 'Test@test', 'mdp', 'Test', 'Test', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `rdv_collection_entity`
--

DROP TABLE IF EXISTS `rdv_collection_entity`;
CREATE TABLE `rdv_collection_entity` (
  `id` int(11) NOT NULL,
  `date_reservation` datetime(6) DEFAULT NULL,
  `id_patient` int(11) DEFAULT NULL,
  `id_rdv` int(11) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rdv_collection_patient`
--

DROP TABLE IF EXISTS `rdv_collection_patient`;
CREATE TABLE `rdv_collection_patient` (
  `id` int(11) NOT NULL,
  `id_rdv` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `date_reservation` datetime NOT NULL DEFAULT current_timestamp(),
  `statut` varchar(20) NOT NULL DEFAULT 'RESERVE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rdv_dispo`
--

DROP TABLE IF EXISTS `rdv_dispo`;
CREATE TABLE `rdv_dispo` (
  `id_rdv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
CREATE TABLE `rendez_vous` (
  `id_rdv` int(11) NOT NULL,
  `id_medecin` int(11) NOT NULL,
  `date_rdv` date NOT NULL,
  `heure` time NOT NULL,
  `compte_rendu` varchar(255) DEFAULT NULL,
  `dispo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

DROP TABLE IF EXISTS `specialite`;
CREATE TABLE `specialite` (
  `id_specialite` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `specialite`
--

INSERT INTO `specialite` (`id_specialite`, `libelle`) VALUES
(1, 'Cardiologie');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`id_etablissement`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`),
  ADD KEY `idx_medecin_specialite` (`id_specialite`),
  ADD KEY `idx_medecin_etablissement` (`id_etablissement`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`),
  ADD UNIQUE KEY `uq_patient_email` (`email`),
  ADD KEY `idx_patient_email` (`email`);

--
-- Index pour la table `rdv_collection_entity`
--
ALTER TABLE `rdv_collection_entity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rdv_collection_patient`
--
ALTER TABLE `rdv_collection_patient`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_patient_rdv` (`id_patient`,`id_rdv`),
  ADD KEY `idx_collec_patient` (`id_patient`),
  ADD KEY `idx_collec_rdv` (`id_rdv`);

--
-- Index pour la table `rdv_dispo`
--
ALTER TABLE `rdv_dispo`
  ADD PRIMARY KEY (`id_rdv`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `idx_rdv_medecin` (`id_medecin`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`id_specialite`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `etablissement`
--
ALTER TABLE `etablissement`
  MODIFY `id_etablissement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `rdv_collection_entity`
--
ALTER TABLE `rdv_collection_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rdv_collection_patient`
--
ALTER TABLE `rdv_collection_patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `id_specialite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_medecin_etablissement` FOREIGN KEY (`id_etablissement`) REFERENCES `etablissement` (`id_etablissement`),
  ADD CONSTRAINT `fk_medecin_specialite` FOREIGN KEY (`id_specialite`) REFERENCES `specialite` (`id_specialite`);

--
-- Contraintes pour la table `rdv_collection_patient`
--
ALTER TABLE `rdv_collection_patient`
  ADD CONSTRAINT `fk_collec_patient` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`),
  ADD CONSTRAINT `fk_collec_rdv` FOREIGN KEY (`id_rdv`) REFERENCES `rendez_vous` (`id_rdv`);

--
-- Contraintes pour la table `rdv_dispo`
--
ALTER TABLE `rdv_dispo`
  ADD CONSTRAINT `fk_dispo_rdv` FOREIGN KEY (`id_rdv`) REFERENCES `rendez_vous` (`id_rdv`) ON DELETE CASCADE;

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `fk_rdv_medecin` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id_medecin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
