import be.helha.projetFinal.DAO.MonoplaceDAOImpl;
import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMonoplaceDAO {
    private MonoplaceDAOImpl instance;

    @BeforeEach
    public void setup(){
        instance = new MonoplaceDAOImpl();
        instance.supprimerAllMonoplace();
    }

    @BeforeEach
    void avantChaqueTest(TestInfo testInfo) {
        System.out.println("Test : " + testInfo.getDisplayName());
    }

    /**
     * Test de l'ajout d'une monoplace
     * On ajoute une monoplace à la base de données et on vérifie qu'elle a bien été ajoutée
     * On vérifie que la taille de la liste de monoplaces est égale à 1
     */
    @Test
    @Order(1)
    @DisplayName("1. Test de l'ajout d'une monoplace")
    void testAjouterMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        assertEquals(1, instance.obtenirToutesLesMonoplaces().size());
    }

    /**
     * Test de la suppression d'une monoplace
     * On ajoute une monoplace à la base de données
     * On supprime la monoplace ajoutée
     * On vérifie que la taille de la liste de monoplaces est égale à 0
     */
    @Test
    @Order(2)
    @DisplayName("2. Test de la suppression d'une monoplace")
    void testSupprimerMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        instance.supprimerMonoplace(1);
        assertEquals(0, instance.obtenirToutesLesMonoplaces().size());
    }

    /**
     * Test de la suppression de toutes les monoplaces
     * On ajoute une monoplace à la base de données
     * On supprime toutes les monoplaces
     * On vérifie que la taille de la liste de monoplaces est égale à 0
     */
    @Test
    @Order(3)
    @DisplayName("3. Test de la suppression de toutes les monoplaces")
    void testSupprimerToutesLesMonoplaces() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        MonoplaceDTO monoplace2 = new MonoplaceDTO("SF-25", "Ferrari", "Carlos Sainz", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        instance.ajouterMonoplace(monoplace2);
        assertEquals(2, instance.obtenirToutesLesMonoplaces().size());
        instance.supprimerAllMonoplace();
        assertEquals(0, instance.obtenirToutesLesMonoplaces().size());
    }

    /**
     * Test de la modification d'une monoplace
     * On ajoute une monoplace à la base de données
     * On modifie la monoplace ajoutée
     * On vérifie que la monoplace a bien été modifiée
     */
    @Test
    @Order(4)
    @DisplayName("4. Test de la modification d'une monoplace")
    void testModifierMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        monoplace.setNomMonoplace("SF-25");
        instance.modifierMonoplace(monoplace);
        assertEquals("SF-25", instance.obtenirMonoplaceParId(1).getNomMonoplace());
    }

    /**
     * Test de l'obtention d'une monoplace par son nom
     * On ajoute une monoplace à la base de données
     * On obtient la monoplace par son nom
     * On vérifie que la monoplace obtenue est bien celle ajoutée
     */
    @Test
    @Order(5)
    @DisplayName("5. Test de l'obtention d'une monoplace par son nom")
    void testObtenirMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        assertEquals("SF-24", instance.obtenirMonoplace("SF-24").getNomMonoplace());
    }

    /**
     * Test de l'obtention d'une monoplace par son id
     * On ajoute une monoplace à la base de données
     * On obtient la monoplace par son id
     * On vérifie que la monoplace obtenue est bien celle ajoutée
     */
    @Test
    @Order(6)
    @DisplayName("6. Test de l'obtention d'une monoplace par son id")
    void testObtenirMonoplaceParId() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        assertEquals("SF-24", instance.obtenirMonoplaceParId(1).getNomMonoplace());
    }

    /**
     * Test de l'obtention de toutes les monoplaces
     * On ajoute une monoplace à la base de données
     * On obtient toutes les monoplaces
     * On vérifie que la taille de la liste de monoplaces est égale à 1
     */
    @Test
    @Order(7)
    @DisplayName("7. Test de l'obtention de toutes les monoplaces")
    void testObtenirToutesLesMonoplaces() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        instance.ajouterMonoplace(monoplace);
        assertEquals(1, instance.obtenirToutesLesMonoplaces().size());
    }
}
