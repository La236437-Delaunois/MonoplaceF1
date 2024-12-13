package be.helha.projetfinal.moduleapi;
import be.helha.projetFinal.DAO.MonoplaceDAOImpl;
import be.helha.projetFinal.MonoplaceDTO.*;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MonoplaceF1ControllerTest {

    private MonoplaceF1Controller monoplaceF1Controller;
    private MonoplaceDAOImpl monoplaceF1DAO;

    /**
     * Création d'une instance et suppression de toutes les monoplaces avant chaque test
     */
    @BeforeEach
    public void setUp() {
        monoplaceF1DAO = MonoplaceDAOImpl.getInstance();
        monoplaceF1Controller = new MonoplaceF1Controller();

        monoplaceF1DAO.supprimerAllMonoplace();
    }

    /**
     * Affichage du nom du test en cours
     * @param testInfo informations sur le test en cours
     */
    @BeforeEach
    public void DisplayName(TestInfo testInfo) {
        System.out.println("Test en cours : " + testInfo.getDisplayName());
    }

    /**
     * Test de l'ajout d'une monoplace
     */
    @Test
    @Order(1)
    @DisplayName("1. Test de l'ajout d'une monoplace")
    public void testAjouterMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-25", "Ferrari", "Charles Leclerc", "Inge1", "Monza");
        ResponseEntity<String> reponse = monoplaceF1Controller.ajouterMonoplace(monoplace);
        assertEquals(HttpStatus.OK, reponse.getStatusCode());
        assertEquals(1, monoplaceF1DAO.obtenirToutesLesMonoplaces().size());
    }

    /**
     * Test de la recherche d'une monoplace par son nom
     */
    @Test
    @Order(2)
    @DisplayName("2. Rechercher Ferrari")
    public void testRechercherMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-25", "Ferrari", "Charles Leclerc", "Inge1", "Monza");
        monoplaceF1Controller.ajouterMonoplace(monoplace);
        ResponseEntity<MonoplaceDTO> reponse = monoplaceF1Controller.rechercherMonoplaceNom("Ferrari");
        assertEquals(HttpStatus.OK, reponse.getStatusCode());
    }

    /**
     * Test de la recherche d'une monoplace par son id
     */
    @Test
    @Order(3)
    @DisplayName("3. Rechercher SF-25 par son id")
    public void testRechercherMonoplaceID() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-25", "Ferrari", "Charles Leclerc", "Inge1", "Monza");
        monoplaceF1Controller.ajouterMonoplace(monoplace);
        ResponseEntity<MonoplaceDTO> reponse = monoplaceF1Controller.rechercherMonoplaceID(1);
        assertEquals(HttpStatus.OK, reponse.getStatusCode());
        assertNotNull(reponse.getBody());
    }

    /**
     * Test de la suppression d'une monoplace
     */
    @Test
    @Order(4)
    @DisplayName("4. Test de la suppression d'une monoplace")
    public void testSupprimerMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-25", "Ferrari", "Charles Leclerc", "Inge1", "Monza");
        monoplaceF1Controller.ajouterMonoplace(monoplace);
        ResponseEntity<String> reponse = monoplaceF1Controller.supprimerMonoplace(1);
        assertEquals(HttpStatus.OK, reponse.getStatusCode());
        assertEquals(0, monoplaceF1DAO.obtenirToutesLesMonoplaces().size());
    }

    /**
     * Test de la mise à jour d'une monoplace
     */
    @Test
    @Order(5)
    @DisplayName("5. Test de la mise à jour d'une monoplace")
    public void testMettreAJourMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-25", "Ferrari", "Charles Leclerc", "Inge1", "Monza");
        monoplaceF1Controller.ajouterMonoplace(monoplace);
        monoplace.setNomMonoplace("SF-26");
        ResponseEntity<String> reponse = monoplaceF1Controller.mettreAJourMonoplace(monoplace);
        assertEquals(HttpStatus.OK, reponse.getStatusCode());
        assertEquals("SF-26", monoplaceF1DAO.obtenirMonoplaceParId(1).getNomMonoplace());
    }

}
