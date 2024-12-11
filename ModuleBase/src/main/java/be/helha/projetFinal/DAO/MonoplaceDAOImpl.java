package be.helha.projetFinal.DAO;

import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;
import com.google.gson.Gson;

import java.sql.*;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class MonoplaceDAOImpl implements MonoplaceDAO {
    private static MonoplaceDAOImpl instance;
    private static Connection connection;

    /**
     * Constructeur privé pour le singleton
     * Crée une connexion à la base de données
     * Utilise le fichier de configuration config.json
     */
    public MonoplaceDAOImpl() {
        String filename = "src/main/resources/config.json";
        Path path = Paths.get(filename);
        Gson gson = new Gson();
        Configuration configuration = new Configuration();

        try
        {  Reader reader = newBufferedReader(path, StandardCharsets.UTF_8);
            configuration = gson.fromJson(reader, Configuration.class);
            System.out.println(configuration.ConnectionType);
            System.out.println(configuration.DBType);
            System.out.println(configuration.BDCredentials.Port);
            System.out.println(configuration.BDCredentials.DBName);
            System.out.println(configuration.BDCredentials.HostName);
            System.out.println("jdbc:"+configuration.DBType+"://"+configuration.BDCredentials.HostName+":"+configuration.BDCredentials.Port+";databaseName="+configuration.BDCredentials.DBName+";encrypt=false;user="+configuration.BDCredentials.UserName+";password="+configuration.BDCredentials.Password+";");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:"+configuration.DBType+"://"+configuration.BDCredentials.HostName+":"+configuration.BDCredentials.Port+";databaseName="+configuration.BDCredentials.DBName+";encrypt=false;user="+configuration.BDCredentials.UserName+";password="+configuration.BDCredentials.Password+";");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Singleton
     * @return instance
     */
    public synchronized static MonoplaceDAOImpl getInstance() {
        if (instance == null) {
            instance = new MonoplaceDAOImpl();
        }
        return instance;
    }

    /**
     * Ajouter une monoplace dans la base de données
     * @param monoplace monoplace à ajouter
     */
    @Override
    public void ajouterMonoplace(MonoplaceDTO monoplace) {
        String sql = "INSERT INTO Monoplace (nomMonoplace, ecurie, nomMoteur, modeleMoteur, aileronAvant, aileronArriere, freins, boiteVitesse, pneus, poids, capaciteMaxReservoir, chassis, suspension, fondPlat, ingenieurCourse, entrepot, pilote) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, monoplace.getNomMonoplace());
            pstmt.setString(2, monoplace.getEcurie());
            pstmt.setString(3, monoplace.getNomMoteur());
            pstmt.setString(4, monoplace.getModeleMoteur());
            pstmt.setString(5, monoplace.getAileronAvant());
            pstmt.setString(6, monoplace.getAileronArriere());
            pstmt.setString(7, monoplace.getFreins());
            pstmt.setString(8, monoplace.getBoiteVitesse());
            pstmt.setString(9, monoplace.getPneus());
            pstmt.setDouble(10, monoplace.getPoids());
            pstmt.setDouble(11, monoplace.getCapaciteMaxReservoir());
            pstmt.setString(12, monoplace.getChassis());
            pstmt.setString(13, monoplace.getSuspension());
            pstmt.setString(14, monoplace.getFondPlat());
            pstmt.setString(15, monoplace.getIngenieurCourse());
            pstmt.setString(16, monoplace.getEntrepot());
            pstmt.setString(17, monoplace.getPilote());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprimer une monoplace de la base de données
     * @param monoplace monoplace à supprimer
     */
    @Override
    public void supprimerMonoplace(int id) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM Monoplace WHERE idMonoplace = " + id);
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Modifier une monoplace dans la base de données
     * @param monoplace monoplace à modifier
     */
    @Override
    public void modifierMonoplace(MonoplaceDTO monoplace){
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE Monoplace SET nomMonoplace = '" + monoplace.getNomMonoplace() + "', ecurie = '" + monoplace.getEcurie() + "', nomMoteur = '" + monoplace.getNomMoteur() + "', modeleMoteur = '" + monoplace.getModeleMoteur() + "', aileronAvant = '" + monoplace.getAileronAvant() + "', aileronArriere = '" + monoplace.getAileronArriere() + "', freins = '" + monoplace.getFreins() + "', boiteVitesse = '" + monoplace.getBoiteVitesse() + "', pneus = '" + monoplace.getPneus() + "', poids = " + monoplace.getPoids() + ", capaciteMaxReservoir = " + monoplace.getCapaciteMaxReservoir() + ", chassis = '" + monoplace.getChassis() + "', suspension = '" + monoplace.getSuspension() + "', fondPlat = '" + monoplace.getFondPlat() + "', ingenieurCourse = '" + monoplace.getIngenieurCourse() + "', entrepot = '" + monoplace.getEntrepot() + "', pilote = '" + monoplace.getPilote() + "' WHERE idMonoplace = " + monoplace.getIdMonoplace());
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Obtenir une monoplace par son nom
     * @param nom nom de la monoplace
     * @return la monoplace ou null
     */
    public MonoplaceDTO obtenirMonoplace(String nom){
        String sql = "SELECT * FROM Monoplace WHERE nomMonoplace = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    MonoplaceDTO monoplace = new MonoplaceDTO(rs.getString("nomMonoplace"), rs.getString("ecurie"), rs.getString("nomMoteur"), rs.getString("modeleMoteur"), rs.getString("aileronAvant"), rs.getString("aileronArriere"), rs.getString("freins"), rs.getString("boiteVitesse"), rs.getString("pneus"), rs.getDouble("poids"), rs.getDouble("capaciteMaxReservoir"), rs.getString("chassis"), rs.getString("suspension"), rs.getString("fondPlat"), rs.getString("ingenieurCourse"), rs.getString("entrepot"), rs.getString("pilote"));
                    monoplace.setIdMonoplace(rs.getInt("idMonoplace"));
                    return monoplace;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Obtenir une monoplace par son id
     * @param id id de la monoplace
     */
    @Override
    public MonoplaceDTO obtenirMonoplaceParId(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Monoplace WHERE idMonoplace = " + id);
            rs.next();
            MonoplaceDTO monoplace = new MonoplaceDTO(rs.getString("nomMonoplace"), rs.getString("ecurie"), rs.getString("nomMoteur"), rs.getString("modeleMoteur"), rs.getString("aileronAvant"), rs.getString("aileronArriere"), rs.getString("freins"), rs.getString("boiteVitesse"), rs.getString("pneus"), rs.getDouble("poids"), rs.getDouble("capaciteMaxReservoir"), rs.getString("chassis"), rs.getString("suspension"), rs.getString("fondPlat"), rs.getString("ingenieurCourse"), rs.getString("entrepot"), rs.getString("pilote"));
            monoplace.setIdMonoplace(rs.getInt("idMonoplace"));
            rs.close();
            stmt.close();
            return monoplace;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Obtenir toutes les monoplaces
     * @return la liste des monoplaces
     */
    public List<MonoplaceDTO> obtenirToutesLesMonoplaces(){
        List<MonoplaceDTO> monoplaces = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Monoplace");
            while (rs.next()) {
                MonoplaceDTO monoplace = new MonoplaceDTO(rs.getString("nomMonoplace"), rs.getString("ecurie"), rs.getString("nomMoteur"), rs.getString("modeleMoteur"), rs.getString("aileronAvant"), rs.getString("aileronArriere"), rs.getString("freins"), rs.getString("boiteVitesse"), rs.getString("pneus"), rs.getDouble("poids"), rs.getDouble("capaciteMaxReservoir"), rs.getString("chassis"), rs.getString("suspension"), rs.getString("fondPlat"), rs.getString("ingenieurCourse"), rs.getString("entrepot"), rs.getString("pilote"));
                monoplace.setIdMonoplace(rs.getInt("idMonoplace"));
                monoplaces.add(monoplace);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return monoplaces;
    }

    /**
     * Supprimer toutes les monoplaces de la base de données
     */
    public void supprimerAllMonoplace(){
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM Monoplace");
            stmt.close();
            resetId();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Réinitialiser le conteur d'id
     */
    public void resetId(){
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DBCC CHECKIDENT ('Monoplace', RESEED, 0)");
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Fermer la connexion
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
