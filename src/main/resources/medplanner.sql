-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 04 jan. 2026 à 14:33
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
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE `medecin` (
  `id_medecin` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_specialite` int(11) NOT NULL,
  `id_ville` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id_medecin`, `nom`, `prenom`, `email`, `password`, `id_specialite`, `id_ville`) VALUES
(1, 'Lucie', 'Adam', 'Lucie@Adam', 'mdp', 1, 45),
(2, 'Mehdi', 'Aitou', 'Mehdi@Aitou', 'mdp', 1, 271),
(3, 'Philippine', 'Allard', 'Philippine@Allard', 'mdp', 17, 132),
(4, 'Ilyes', 'Amara', 'Ilyes@Amara', 'mdp', 4, 7),
(5, 'Samuel', 'Arnaud', 'Samuel@Arnaud', 'mdp', 29, 198),
(6, 'Clara', 'Aubert', 'Clara@Aubert', 'mdp', 12, 64),
(7, 'Sonia', 'Azzouzi', 'Sonia@Azzouzi', 'mdp', 8, 250),
(8, 'Corentin', 'Bailly', 'Corentin@Bailly', 'mdp', 21, 19),
(9, 'Anais', 'Barbe', 'Anais@Barbe', 'mdp', 3, 86),
(10, 'Enzo', 'Bartoli', 'Enzo@Bartoli', 'mdp', 14, 143),
(11, 'Franck', 'Beaulieu', 'Franck@Beaulieu', 'mdp', 6, 12),
(12, 'Souad', 'Belhadj', 'Souad@Belhadj', 'mdp', 22, 220),
(13, 'Yanis', 'Belkacem', 'Yanis@Belkacem', 'mdp', 9, 97),
(14, 'Karim', 'Benali', 'Karim@Benali', 'mdp', 1, 5),
(15, 'Mourad', 'Bensaid', 'Mourad@Bensaid', 'mdp', 27, 168),
(16, 'Naima', 'Benyahia', 'Naima@Benyahia', 'mdp', 19, 34),
(17, 'Lois', 'Berger', 'Lois@Berger', 'mdp', 5, 201),
(18, 'Chloé', 'Bernard', 'Chloé@Bernard', 'mdp', 11, 156),
(19, 'Sarah', 'Blanchard', 'Sarah@Blanchard', 'mdp', 24, 78),
(20, 'Gael', 'Bodin', 'Gael@Bodin', 'mdp', 7, 260),
(21, 'Juliette', 'Bonnet', 'Juliette@Bonnet', 'mdp', 16, 91),
(22, 'Théo', 'Boucher', 'Théo@Boucher', 'mdp', 2, 14),
(23, 'Amine', 'Boudjemaa', 'Amine@Boudjemaa', 'mdp', 28, 187),
(24, 'Samira', 'Bouzid', 'Samira@Bouzid', 'mdp', 10, 229),
(25, 'Morgane', 'Breton', 'Morgane@Breton', 'mdp', 18, 53),
(26, 'Nicolas', 'Brun', 'Nicolas@Brun', 'mdp', 13, 102),
(27, 'Elise', 'Caron', 'Elise@Caron', 'mdp', 20, 170),
(28, 'Loubna', 'Chafik', 'Loubna@Chafik', 'mdp', 25, 8),
(29, 'Rémi', 'Chartier', 'Rémi@Chartier', 'mdp', 15, 264),
(30, 'Hakim', 'Cherif', 'Hakim@Cherif', 'mdp', 4, 120),
(31, 'Inès', 'Chevalier', 'Inès@Chevalier', 'mdp', 9, 66),
(32, 'Thibault', 'Chiron', 'Thibault@Chiron', 'mdp', 26, 241),
(33, 'Ismael', 'Choukri', 'Ismael@Choukri', 'mdp', 6, 29),
(34, 'Bastien', 'Colas', 'Bastien@Colas', 'mdp', 1, 195),
(35, 'Alexandre', 'Colin', 'Alexandre@Colin', 'mdp', 23, 151),
(36, 'Alan', 'Coste', 'Alan@Coste', 'mdp', 17, 4),
(37, 'Perrine', 'Coulon', 'Perrine@Coulon', 'mdp', 12, 88),
(38, 'Maelle', 'Courtois', 'Maelle@Courtois', 'mdp', 8, 214),
(39, 'Dylan', 'Cousin', 'Dylan@Cousin', 'mdp', 29, 163),
(40, 'Pauline', 'Cros', 'Pauline@Cros', 'mdp', 14, 57),
(41, 'Marion', 'Delmas', 'Marion@Delmas', 'mdp', 5, 272),
(42, 'Olivia', 'Denis', 'Olivia@Denis', 'mdp', 21, 109),
(43, 'Louis', 'Deschamps', 'Louis@Deschamps', 'mdp', 3, 21),
(44, 'Margaux', 'Devaux', 'Margaux@Devaux', 'mdp', 16, 176),
(45, 'Hawa', 'Diallo', 'Hawa@Diallo', 'mdp', 27, 233),
(46, 'Emma', 'Dubois', 'Emma@Dubois', 'mdp', 11, 94),
(47, 'Alice', 'Dumas', 'Alice@Dumas', 'mdp', 19, 10),
(48, 'Arnaud', 'Dupont', 'Arnaud@Dupont', 'mdp', 7, 185),
(49, 'Romain', 'Durand', 'Romain@Durand', 'mdp', 24, 247),
(50, 'Meryem', 'El Fassi', 'Meryem@El Fassi', 'mdp', 2, 69),
(51, 'Nour', 'El Hadi', 'Nour@El Hadi', 'mdp', 10, 131),
(52, 'Farid', 'El Idrissi', 'Farid@El Idrissi', 'mdp', 18, 206),
(53, 'Paul', 'Faure', 'Paul@Faure', 'mdp', 13, 36),
(54, 'Jean-Baptiste', 'Feral', 'Jean-Baptiste@Feral', 'mdp', 28, 160),
(55, 'Justine', 'Foucault', 'Justine@Foucault', 'mdp', 20, 118),
(56, 'Camille', 'Fournier', 'Camille@Fournier', 'mdp', 15, 252),
(57, 'Maxime', 'Garnier', 'Maxime@Garnier', 'mdp', 25, 75),
(58, 'Jade', 'Gauthier', 'Jade@Gauthier', 'mdp', 4, 3),
(59, 'Julien', 'Girard', 'Julien@Girard', 'mdp', 9, 224),
(60, 'Salomé', 'Granger', 'Salomé@Granger', 'mdp', 6, 99),
(61, 'Justine', 'Guérin', 'Justine@Guérin', 'mdp', 1, 147),
(62, 'Océane', 'Guillon', 'Océane@Guillon', 'mdp', 26, 62),
(63, 'Yannis', 'Haddad', 'Yannis@Haddad', 'mdp', 22, 190),
(64, 'Walid', 'Hamzaoui', 'Walid@Hamzaoui', 'mdp', 12, 259),
(65, 'Céline', 'Hardy', 'Céline@Hardy', 'mdp', 17, 28),
(66, 'Ã‰milie', 'Hebert', 'Ã‰milie@Hebert', 'mdp', 5, 83),
(67, 'Sébastien', 'Henry', 'Sébastien@Henry', 'mdp', 29, 171),
(68, 'Damien', 'Hoarau', 'Damien@Hoarau', 'mdp', 8, 215),
(69, 'AnaÃ«lle', 'Hubert', 'AnaÃ«lle@Hubert', 'mdp', 14, 49),
(70, 'Mathilde', 'Joly', 'Mathilde@Joly', 'mdp', 3, 137),
(71, 'Fatima', 'Kaci', 'Fatima@Kaci', 'mdp', 21, 266),
(72, 'Ophélie', 'Kerjean', 'Ophélie@Kerjean', 'mdp', 16, 104),
(73, 'Raphael', 'Klein', 'Raphael@Klein', 'mdp', 27, 16),
(74, 'Benjamin', 'Lacroix', 'Benjamin@Lacroix', 'mdp', 11, 183),
(75, 'Denis', 'Lafont', 'Denis@Lafont', 'mdp', 19, 239),
(76, 'Yasmina', 'Lahlou', 'Yasmina@Lahlou', 'mdp', 24, 92),
(77, 'Khadija', 'Lamrani', 'Khadija@Lamrani', 'mdp', 7, 55),
(78, 'Michael', 'Lamy', 'Michael@Lamy', 'mdp', 2, 200),
(79, 'Enora', 'Le Gall', 'Enora@Le Gall', 'mdp', 10, 154),
(80, 'Fanny', 'Leclerc', 'Fanny@Leclerc', 'mdp', 18, 6),
(81, 'Vincent', 'Leduc', 'Vincent@Leduc', 'mdp', 13, 127),
(82, 'Manon', 'Lefèvre', 'Manon@Lefèvre', 'mdp', 28, 261),
(83, 'Baptiste', 'Lemoine', 'Baptiste@Lemoine', 'mdp', 20, 81),
(84, 'Nathan', 'Leroy', 'Nathan@Leroy', 'mdp', 15, 31),
(85, 'Audrey', 'Lhoste', 'Audrey@Lhoste', 'mdp', 25, 168),
(86, 'Mathieu', 'Lopez', 'Mathieu@Lopez', 'mdp', 9, 218),
(87, 'Tiphaine', 'Lucas', 'Tiphaine@Lucas', 'mdp', 4, 112),
(88, 'Rosalie', 'Magnin', 'Rosalie@Magnin', 'mdp', 1, 44),
(89, 'Etienne', 'Mallet', 'Etienne@Mallet', 'mdp', 6, 255),
(90, 'Pauline', 'Marchand', 'Pauline@Marchand', 'mdp', 26, 73),
(91, 'Lucas', 'Martin', 'Lucas@Martin', 'mdp', 22, 196),
(92, 'Eva', 'Masson', 'Eva@Masson', 'mdp', 12, 149),
(93, 'Florian', 'Mathieu', 'Florian@Mathieu', 'mdp', 5, 9),
(94, 'Antoine', 'Mercier', 'Antoine@Mercier', 'mdp', 17, 222),
(95, 'Victor', 'Meunier', 'Victor@Meunier', 'mdp', 29, 87),
(96, 'Laure', 'Michaud', 'Laure@Michaud', 'mdp', 8, 134),
(97, 'Anthony', 'Millet', 'Anthony@Millet', 'mdp', 14, 270),
(98, 'Rachid', 'Mokrani', 'Rachid@Mokrani', 'mdp', 21, 61),
(99, 'Pierre', 'Monnier', 'Pierre@Monnier', 'mdp', 3, 18),
(100, 'Gaspard', 'Montel', 'Gaspard@Montel', 'mdp', 16, 178),
(101, 'Hugo', 'Moreau', 'Hugo@Moreau', 'mdp', 27, 231),
(102, 'Agathe', 'Morin', 'Agathe@Morin', 'mdp', 11, 96),
(103, 'Valérie', 'Moulin', 'Valérie@Moulin', 'mdp', 19, 52),
(104, 'Sophie', 'Navarro', 'Sophie@Navarro', 'mdp', 24, 205),
(105, 'Mathis', 'Nguyen', 'Mathis@Nguyen', 'mdp', 7, 158),
(106, 'Patrice', 'Noel', 'Patrice@Noel', 'mdp', 2, 24),
(107, 'Bilal', 'Ouali', 'Bilal@Ouali', 'mdp', 10, 121),
(108, 'Irène', 'Pasquier', 'Irène@Pasquier', 'mdp', 18, 248),
(109, 'Amandine', 'Paulin', 'Amandine@Paulin', 'mdp', 13, 79),
(110, 'Louise', 'Pelletier', 'Louise@Pelletier', 'mdp', 28, 35),
(111, 'Laura', 'Perrin', 'Laura@Perrin', 'mdp', 20, 191),
(112, 'Léa', 'Petit', 'Léa@Petit', 'mdp', 15, 213),
(113, 'Adrien', 'Picard', 'Adrien@Picard', 'mdp', 25, 106),
(114, 'Valentin', 'Pichon', 'Valentin@Pichon', 'mdp', 9, 67),
(115, 'Lila', 'Poirier', 'Lila@Poirier', 'mdp', 4, 164),
(116, 'Alain', 'Poncelet', 'Alain@Poncelet', 'mdp', 1, 225),
(117, 'Cédric', 'Pottier', 'Cédric@Pottier', 'mdp', 6, 41),
(118, 'Cindy', 'Prévost', 'Cindy@Prévost', 'mdp', 26, 139),
(119, 'Coline', 'Pruvost', 'Coline@Pruvost', 'mdp', 22, 263),
(120, 'Sofiane', 'Rahmani', 'Sofiane@Rahmani', 'mdp', 12, 98),
(121, 'Zoé', 'Renard', 'Zoé@Renard', 'mdp', 5, 15),
(122, 'Noémie', 'Rey', 'Noémie@Rey', 'mdp', 17, 184),
(123, 'Stéphane', 'Richet', 'Stéphane@Richet', 'mdp', 29, 240),
(124, 'Clément', 'Rivière', 'Clément@Rivière', 'mdp', 8, 90),
(125, 'Elodie', 'Robert', 'Elodie@Robert', 'mdp', 14, 58),
(126, 'Quentin', 'Roche', 'Quentin@Roche', 'mdp', 21, 199),
(127, 'Delphine', 'Rocher', 'Delphine@Rocher', 'mdp', 3, 152),
(128, 'Kévin', 'Rolland', 'Kévin@Rolland', 'mdp', 16, 2),
(129, 'Thomas', 'Rousseau', 'Thomas@Rousseau', 'mdp', 27, 128),
(130, 'Claire', 'Roussel', 'Claire@Roussel', 'mdp', 11, 258),
(131, 'Myriam', 'Saad', 'Myriam@Saad', 'mdp', 19, 85),
(132, 'Nora', 'Said', 'Nora@Said', 'mdp', 24, 27),
(133, 'Brahim', 'Saidi', 'Brahim@Saidi', 'mdp', 7, 172),
(134, 'Olivier', 'Samson', 'Olivier@Samson', 'mdp', 2, 219),
(135, 'Bérénice', 'Savary', 'Bérénice@Savary', 'mdp', 10, 114),
(136, 'Charlotte', 'Schmitt', 'Charlotte@Schmitt', 'mdp', 18, 47),
(137, 'Patrick', 'Sevin', 'Patrick@Sevin', 'mdp', 13, 256),
(138, 'Aurore', 'Stein', 'Aurore@Stein', 'mdp', 28, 71),
(139, 'Jonathan', 'Texier', 'Jonathan@Texier', 'mdp', 20, 193),
(140, 'Robin', 'Théry', 'Robin@Théry', 'mdp', 15, 146),
(141, 'Loic', 'Thomas', 'Loic@Thomas', 'mdp', 25, 11),
(142, 'Aicha', 'Touré', 'Aicha@Touré', 'mdp', 9, 223),
(143, 'Elisabeth', 'Tournier', 'Elisabeth@Tournier', 'mdp', 6, 89),
(144, 'Jérome', 'Valette', 'Jérome@Valette', 'mdp', 1, 135),
(145, 'Mélanie', 'Vasseur', 'Mélanie@Vasseur', 'mdp', 26, 269),
(146, 'Christophe', 'Vidal', 'Christophe@Vidal', 'mdp', 22, 63),
(147, 'Sacha', 'Villiers', 'Sacha@Villiers', 'mdp', 12, 20),
(148, 'Hélène', 'Voisin', 'Hélène@Voisin', 'mdp', 12, 179),
(149, 'Nabil', 'Zeroual', 'Nabil@Zeroual', 'mdp', 5, 234),
(150, 'Imane', 'Ziani', 'Imane@Ziani', 'mdp', 17, 95);

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `date_naissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `email`, `password`, `nom`, `prenom`, `date_naissance`) VALUES
(1, 'allo', 'mdp', 'allo', 'allo', '2026-01-05');

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
CREATE TABLE `rendez_vous` (
  `id_rdv` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_medecin` int(11) NOT NULL,
  `date_rdv` date NOT NULL,
  `heure_rdv` time NOT NULL,
  `compte_rendu_rdv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`id_rdv`, `id_patient`, `id_medecin`, `date_rdv`, `heure_rdv`, `compte_rendu_rdv`) VALUES
(2, 1, 2, '2026-03-17', '15:00:00', NULL),
(3, 1, 2, '2026-03-18', '15:00:00', NULL),
(4, 1, 4, '2026-03-20', '17:00:00', NULL),
(5, 1, 25, '2026-03-22', '16:00:00', NULL),
(6, 1, 65, '2026-03-23', '11:00:00', NULL),
(7, 1, 3, '2026-03-24', '09:00:00', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

DROP TABLE IF EXISTS `specialite`;
CREATE TABLE `specialite` (
  `id_specialite` int(11) NOT NULL,
  `libelle_specialite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `specialite`
--

INSERT INTO `specialite` (`id_specialite`, `libelle_specialite`) VALUES
(1, ' Médecin généraliste'),
(2, ' Anesthésiste-Réanimateur'),
(3, ' Biologiste médical'),
(4, ' Cardiologue'),
(5, ' Chirurgien'),
(6, ' Dentiste'),
(7, ' Dermatologue'),
(8, ' Endocrinologue'),
(9, ' Gastro-Entérologue'),
(10, ' Généticien'),
(11, ' Gynécologue-obstétricien'),
(12, ' Hématologue'),
(13, ' Masseur Kinésithérapeute'),
(14, ' Médecin du travail'),
(15, ' Médecin légiste'),
(16, ' Médecin Nucléaire'),
(17, ' Néphrologue'),
(18, ' Neurochirurgien'),
(19, ' Neurologue'),
(20, ' Oncologue'),
(21, ' Ophtalmologue/Ophtalmologiste'),
(22, ' ORL'),
(23, ' Pédiatre'),
(24, ' Pharmacien'),
(25, ' Pneumologue'),
(26, ' Psychiatre'),
(27, ' Radiologue'),
(28, ' Rhumatologue'),
(29, ' Sage-Femme');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE `ville` (
  `id_ville` int(11) NOT NULL,
  `nom_ville` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`id_ville`, `nom_ville`) VALUES
(1, 'Abilly'),
(2, 'Ambillou'),
(3, 'Amboise'),
(4, 'Anché'),
(5, 'Antogny-le-Tillac'),
(6, 'Artannes-sur-Indre'),
(7, 'Assay'),
(8, 'Athée-sur-Cher'),
(9, 'Autrèche'),
(10, 'Auzouer-en-Touraine'),
(11, 'Avoine'),
(12, 'Avon-les-Roches'),
(13, 'Avrillé-les-Ponceaux'),
(14, 'Azay-le-Rideau'),
(15, 'Azay-sur-Cher'),
(16, 'Azay-sur-Indre'),
(17, 'Ballan-Miré'),
(18, 'Barrou'),
(19, 'Beaulieu-lès-Loches'),
(20, 'Beaumont-en-Véron'),
(21, 'Beaumont-Louestault'),
(22, 'Beaumont-Village'),
(23, 'Benais'),
(24, 'Berthenay'),
(25, 'Betz-le-Château'),
(26, 'Bléré'),
(27, 'Bossay-sur-Claise'),
(28, 'Bossée'),
(29, 'Bourgueil'),
(30, 'Bournan'),
(31, 'Boussay'),
(32, 'Braslou'),
(33, 'Braye-sous-Faye'),
(34, 'Braye-sur-Maulne'),
(35, 'Brèches'),
(36, 'Bréhémont'),
(37, 'Bridoré'),
(38, 'Brizay'),
(39, 'Bueil-en-Touraine'),
(40, 'Candes-Saint-Martin'),
(41, 'Cangey'),
(42, 'Céré-la-Ronde'),
(43, 'Cerelles'),
(44, 'Chambon'),
(45, 'Chambourg-sur-Indre'),
(46, 'Chambray-lès-Tours'),
(47, 'Champigny-sur-Veude'),
(48, 'Chançay'),
(49, 'Chanceaux-près-Loches'),
(50, 'Chanceaux-sur-Choisille'),
(51, 'Channay-sur-Lathan'),
(52, 'Charentilly'),
(53, 'Chargé'),
(54, 'Charnizay'),
(55, 'Château-la-Vallière'),
(56, 'Château-Renault'),
(57, 'Chaumussay'),
(58, 'Chaveignes'),
(59, 'Chédigny'),
(60, 'Cheillé'),
(61, 'Chemillé-sur-Dême'),
(62, 'Chemillé-sur-Indrois'),
(63, 'Chenonceaux'),
(64, 'Chezelles'),
(65, 'Chinon'),
(66, 'Chisseaux'),
(67, 'Chouzé-sur-Loire'),
(68, 'Cigogné'),
(69, 'Cinais'),
(70, 'Cinq-Mars-la-Pile'),
(71, 'Ciran'),
(72, 'Civray-de-Touraine'),
(73, 'Civray-sur-Esves'),
(74, 'Cléré-les-Pins'),
(75, 'Continvoir'),
(76, 'Cormery'),
(77, 'Coteaux-sur-Loire'),
(78, 'Couesmes'),
(79, 'Courçay'),
(80, 'Courcelles-de-Touraine'),
(81, 'Courcoué'),
(82, 'Couziers'),
(83, 'Cravant-les-Côteaux'),
(84, 'Crissay-sur-Manse'),
(85, 'Crotelles'),
(86, 'Crouzilles'),
(87, 'Cussay'),
(88, 'Dame-Marie-les-Bois'),
(89, 'Descartes'),
(90, 'Dierre'),
(91, 'Dolus-le-Sec'),
(92, 'Draché'),
(93, 'Druye'),
(94, 'Épeigné-les-Bois'),
(95, 'Épeigné-sur-Dême'),
(96, 'Esves-le-Moutier'),
(97, 'Esvres'),
(98, 'Faye-la-Vineuse'),
(99, 'Ferrière-Larçon'),
(100, 'Ferrière-sur-Beaulieu'),
(101, 'Fondettes'),
(102, 'Francueil'),
(103, 'Genillé'),
(104, 'Gizeux'),
(105, 'Hommes'),
(106, 'Huismes'),
(107, 'Indre-et-Loire'),
(108, 'Jaulnay'),
(109, 'Joué-lès-Tours'),
(110, 'La Celle-Guenand'),
(111, 'La Celle-Saint-Avant'),
(112, 'La Chapelle-aux-Naux'),
(113, 'La Chapelle-Blanche-Saint-Martin'),
(114, 'La Chapelle-sur-Loire'),
(115, 'La Croix-en-Touraine'),
(116, 'La Ferrière'),
(117, 'La Guerche'),
(118, 'La Membrolle-sur-Choisille'),
(119, 'La Riche'),
(120, 'La Roche-Clermault'),
(121, 'La Tour-Saint-Gelin'),
(122, 'La Ville-aux-Dames'),
(123, 'Langeais'),
(124, 'Larçay'),
(125, 'Le Boulay'),
(126, 'Le Grand-Pressigny'),
(127, 'Le Liège'),
(128, 'Le Louroux'),
(129, 'Le Petit-Pressigny'),
(130, 'Lémeré'),
(131, 'Lerné'),
(132, 'Les Hermites'),
(133, 'Lignières-de-Touraine'),
(134, 'Ligré'),
(135, 'Ligueil'),
(136, 'L Île-Bouchard'),
(137, 'Limeray'),
(138, 'Loches'),
(139, 'Loché-sur-Indrois'),
(140, 'Louans'),
(141, 'Lublé'),
(142, 'Lussault-sur-Loire'),
(143, 'Luynes'),
(144, 'Luzé'),
(145, 'Luzillé'),
(146, 'Maillé'),
(147, 'Manthelan'),
(148, 'Marçay'),
(149, 'Marcé-sur-Esves'),
(150, 'Marcilly-sur-Maulne'),
(151, 'Marcilly-sur-Vienne'),
(152, 'Marigny-Marmande'),
(153, 'Marray'),
(154, 'Mazières-de-Touraine'),
(155, 'Mettray'),
(156, 'Monnaie'),
(157, 'Montbazon'),
(158, 'Monthodon'),
(159, 'Montlouis-sur-Loire'),
(160, 'Montrésor'),
(161, 'Montreuil-en-Touraine'),
(162, 'Monts'),
(163, 'Morand'),
(164, 'Mosnes'),
(165, 'Mouzay'),
(166, 'Nazelles-Négron'),
(167, 'Neuil'),
(168, 'Neuillé-le-Lierre'),
(169, 'Neuillé-Pont-Pierre'),
(170, 'Neuilly-le-Brignon'),
(171, 'Neuville-sur-Brenne'),
(172, 'Neuvy-le-Roi'),
(173, 'Noizay'),
(174, 'Notre-Dame-d Oé'),
(175, 'Nouans-les-Fontaines'),
(176, 'Nouâtre'),
(177, 'Nouzilly'),
(178, 'Noyant-de-Touraine'),
(179, 'Orbigny'),
(180, 'Panzoult'),
(181, 'Parçay-Meslay'),
(182, 'Parçay-sur-Vienne'),
(183, 'Paulmy'),
(184, 'Pernay'),
(185, 'Perrusson'),
(186, 'Pocé-sur-Cisse'),
(187, 'Pont-de-Ruan'),
(188, 'Ports-sur-Vienne'),
(189, 'Pouzay'),
(190, 'Preuilly-sur-Claise'),
(191, 'Pussigny'),
(192, 'Razines'),
(193, 'Reignac-sur-Indre'),
(194, 'Restigné'),
(195, 'Reugny'),
(196, 'Richelieu'),
(197, 'Rigny-Ussé'),
(198, 'Rillé'),
(199, 'Rilly-sur-Vienne'),
(200, 'Rivarennes'),
(201, 'Rivière'),
(202, 'Rochecorbon'),
(203, 'Rouziers-de-Touraine'),
(204, 'Saché'),
(205, 'Saint-Antoine-du-Rocher'),
(206, 'Saint-Aubin-le-Dépeint'),
(207, 'Saint-Avertin'),
(208, 'Saint-Benoît-la-Forêt'),
(209, 'Saint-Branchs'),
(210, 'Saint-Christophe-sur-le-Nais'),
(211, 'Saint-Cyr-sur-Loire'),
(212, 'Sainte-Catherine-de-Fierbois'),
(213, 'Sainte-Maure-de-Touraine'),
(214, 'Saint-Épain'),
(215, 'Saint-Étienne-de-Chigny'),
(216, 'Saint-Flovier'),
(217, 'Saint-Genouph'),
(218, 'Saint-Germain-sur-Vienne'),
(219, 'Saint-Hippolyte'),
(220, 'Saint-Jean-Saint-Germain'),
(221, 'Saint-Laurent-de-Lin'),
(222, 'Saint-Laurent-en-Gâtines'),
(223, 'Saint-Martin-le-Beau'),
(224, 'Saint-Nicolas-de-Bourgueil'),
(225, 'Saint-Nicolas-des-Motets'),
(226, 'Saint-Ouen-les-Vignes'),
(227, 'Saint-Paterne-Racan'),
(228, 'Saint-Pierre-des-Corps'),
(229, 'Saint-Quentin-sur-Indrois'),
(230, 'Saint-Règle'),
(231, 'Saint-Roch'),
(232, 'Saint-Senoch'),
(233, 'Saunay'),
(234, 'Savigné-sur-Lathan'),
(235, 'Savigny-en-Véron'),
(236, 'Savonnières'),
(237, 'Sazilly'),
(238, 'Semblançay'),
(239, 'Sennevières'),
(240, 'Sepmes'),
(241, 'Seuilly'),
(242, 'Sonzay'),
(243, 'Sorigny'),
(244, 'Souvigné'),
(245, 'Souvigny-de-Touraine'),
(246, 'Sublaines'),
(247, 'Tauxigny-Saint-Bauld'),
(248, 'Tavant'),
(249, 'Theneuil'),
(250, 'Thilouze'),
(251, 'Thizay'),
(252, 'Tournon-Saint-Pierre'),
(253, 'Tours'),
(254, 'Trogues'),
(255, 'Truyes'),
(256, 'Vallères'),
(257, 'Varennes'),
(258, 'Veigné'),
(259, 'Véretz'),
(260, 'Verneuil-le-Château'),
(261, 'Verneuil-sur-Indre'),
(262, 'Vernou-sur-Brenne'),
(263, 'Villaines-les-Rochers'),
(264, 'Villandry'),
(265, 'Villebourg'),
(266, 'Villedômain'),
(267, 'Villedômer'),
(268, 'Villeloin-Coulangé'),
(269, 'Villeperdue'),
(270, 'Villiers-au-Bouin'),
(271, 'Vou'),
(272, 'Vouvray'),
(273, 'Yzeures-sur-Creuse');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`),
  ADD KEY `FK93b78n43sryed6qbrkc4tj9oc` (`id_specialite`),
  ADD KEY `FKn6rhbkqwu8oxny2sjes45mnc9` (`id_ville`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `FK23pdxpwet91lgm8aefj3qlhyy` (`id_medecin`),
  ADD KEY `FKisdwkxyn5ftxv0psmslfpgw1s` (`id_patient`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`id_specialite`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id_ville`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `id_specialite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `id_ville` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=274;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `FK93b78n43sryed6qbrkc4tj9oc` FOREIGN KEY (`id_specialite`) REFERENCES `specialite` (`id_specialite`),
  ADD CONSTRAINT `FKn6rhbkqwu8oxny2sjes45mnc9` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id_ville`);

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `FK23pdxpwet91lgm8aefj3qlhyy` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id_medecin`),
  ADD CONSTRAINT `FKisdwkxyn5ftxv0psmslfpgw1s` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
