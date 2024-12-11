package be.helha.projetFinal.DAO;
import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;
import java.util.List;

public interface MonoplaceDAO {
     void ajouterMonoplace(MonoplaceDTO monoplace);
     void supprimerMonoplace(int id);
     void modifierMonoplace(MonoplaceDTO monoplace);
     MonoplaceDTO obtenirMonoplace(String nom);
    MonoplaceDTO obtenirMonoplaceParId(int id);
     List<MonoplaceDTO> obtenirToutesLesMonoplaces();
     void supprimerAllMonoplace();
}
