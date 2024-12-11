CREATE DATABASE MonoplaceF1;
-- Utiliser la base de données MonoplaceF1
USE MonoplaceF1;
GO

-- Créer la table Voitures
CREATE TABLE Voitures (
                          VoitureID INT PRIMARY KEY IDENTITY(1,1),
                          NomVoiture NVARCHAR(100) NOT NULL,
                          Ecurie NVARCHAR(100) NOT NULL,
                          NomMoteur NVARCHAR(100) NOT NULL,
                          ModeleMoteur NVARCHAR(100) NOT NULL,
                          AileronAvant NVARCHAR(100) NOT NULL,
                          AileronArriere NVARCHAR(100) NOT NULL,
                          Freins NVARCHAR(100) NOT NULL,
                          BoiteVitesse NVARCHAR(100) NOT NULL,
                          Pneus NVARCHAR(100) NOT NULL,
                          Poids FLOAT NOT NULL,
                          CapaciteMaxReservoir FLOAT NOT NULL,
                          Chassis NVARCHAR(100) NOT NULL,
                          Suspension NVARCHAR(100) NOT NULL,
                          FondPlat NVARCHAR(100) NOT NULL,
                          IngenieurCourse NVARCHAR(100) NOT NULL,
                          Entrepot NVARCHAR(100) NOT NULL
);