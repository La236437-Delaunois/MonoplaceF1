CREATE DATABASE MonoplaceF1;
-- Utiliser la base de données MonoplaceF1
USE MonoplaceF1;
GO

-- Créer la table Voitures
CREATE TABLE Monoplace (
                           id INT PRIMARY KEY IDENTITY(1,1),
                           nomMonoplace NVARCHAR(50) NOT NULL,
                           ecurie NVARCHAR(50) NOT NULL,
                           pilote NVARCHAR(50) NOT NULL,
                           ingenieurCourse NVARCHAR(50) NOT NULL,
                           entrepot NVARCHAR(50) NOT NULL,
                           nomMoteur NVARCHAR(50),
                           aileronAvant NVARCHAR(50),
                           aileronArriere NVARCHAR(50),
                           freins NVARCHAR(50),
                           boiteVitesse NVARCHAR(50),
                           pneus NVARCHAR(50),
                           poids FLOAT,
                           capaciteMaxReservoir FLOAT,
                           chassis NVARCHAR(50),
                           suspension NVARCHAR(50),
                           fondPlat NVARCHAR(50)
);