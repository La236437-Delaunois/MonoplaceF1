import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;
import exceptions.EmptyArgumentException;
import exceptions.NegativeArgumentException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test de la classe MonoplaceDTO
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMonoplaceDTO {

    @BeforeEach
    void avantChaqueTest(TestInfo testInfo) {
        System.out.println("Test en cours : " + testInfo.getDisplayName());
    }

    /**
     * Test de la création d'une monoplace avec les informations suivantes :
     * - Nom de la monoplace : SF-24
     * - Ecurie : Ferrari
     * - Pilote : Charles Leclerc
     * - Ingénieur de course : Bryan Bozzi
     * - Entrepôt : Maranello
     */
    @Test
    @Order(1)
    @DisplayName("1. Test de la création d'une monoplace")
    public void testCreationMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        assertEquals("SF-24", monoplace.getNomMonoplace());
        assertEquals("Ferrari", monoplace.getEcurie());
        assertEquals("Charles Leclerc", monoplace.getPilote());
        assertEquals("Bryan Bozzi", monoplace.getIngenieurCourse());
        assertEquals("Maranello", monoplace.getEntrepot());
    }

    /**
     * Test de la création d'une monoplace grand constructeur avec les informations suivantes :
     * - Nom de la monoplace : RB20
     * - Ecurie : Red Bull Racing
     * - Nom du moteur : Honda RA622H
     * - Aileron avant : Aileron avant aérodynamique
     * - Aileron arrière : Aileron arrière réglable
     * - Freins : Freins carbone
     * - Boîte de vitesses : Boîte de vitesses semi-automatique
     * - Pneus : Pneus Pirelli
     * - Poids : 798.0
     * - Capacité maximale du réservoir : 110.0
     * - Châssis : Châssis en fibre de carbone
     * - Suspension : Suspension indépendante
     * - Fond plat : Fond plat avec effets de sol
     * - Ingénieur de course : Adrian Newey
     * - Entrepôt : Hangar 13
     * - Pilote : Max Verstappen
     */
    @Test
    @Order(2)
    @DisplayName("2. Test de la création d'une monoplace grand constructeur")
    public void testCreationMonoplaceGrandConstructeur() {
        MonoplaceDTO monoplace = new MonoplaceDTO("RB20", "Red Bull Racing", "Honda RA622H", "Aileron avant aérodynamique", "Aileron arrière réglable", "Freins carbone", "Boîte de vitesses semi-automatique", "Pneus Pirelli", 798.0, 110.0, "Châssis en fibre de carbone", "Suspension indépendante", "Fond plat avec effets de sol", "Adrian Newey", "Hangar 13", "Max Verstappen");
        assertEquals("RB20", monoplace.getNomMonoplace());
        assertEquals("Red Bull Racing", monoplace.getEcurie());
        assertEquals("Honda RA622H", monoplace.getNomMoteur());
        assertEquals("Aileron avant aérodynamique", monoplace.getAileronAvant());
        assertEquals("Aileron arrière réglable", monoplace.getAileronArriere());
        assertEquals("Freins carbone", monoplace.getFreins());
        assertEquals("Boîte de vitesses semi-automatique", monoplace.getBoiteVitesse());
        assertEquals("Pneus Pirelli", monoplace.getPneus());
        assertEquals(798.0, monoplace.getPoids(), 0.0);
        assertEquals(110.0, monoplace.getCapaciteMaxReservoir(), 0.0);
        assertEquals("Châssis en fibre de carbone", monoplace.getChassis());
        assertEquals("Suspension indépendante", monoplace.getSuspension());
        assertEquals("Fond plat avec effets de sol", monoplace.getFondPlat());
        assertEquals("Adrian Newey", monoplace.getIngenieurCourse());
        assertEquals("Hangar 13", monoplace.getEntrepot());
        assertEquals("Max Verstappen", monoplace.getPilote());
    }

    /**
     * Test de la modification d'une monoplace
     */
    @Test
    @Order(3)
    @DisplayName("3. Test de la modification d'une monoplace avec les setters")
    public void testModificationMonoplace() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        monoplace.setNomMonoplace("SF-25");
        monoplace.setEcurie("Red Bull Racing");
        monoplace.setPilote("Max Verstappen");
        monoplace.setIngenieurCourse("Adrian Newey");
        monoplace.setEntrepot("Hangar 13");
        assertEquals("SF-25", monoplace.getNomMonoplace());
        assertEquals("Red Bull Racing", monoplace.getEcurie());
        assertEquals("Max Verstappen", monoplace.getPilote());
        assertEquals("Adrian Newey", monoplace.getIngenieurCourse());
        assertEquals("Hangar 13", monoplace.getEntrepot());
    }

    /**
     * Test de modification du nom de la monoplace vide
     * @throws IllegalArgumentException
     */
    @Test
    @Order(4)
    @DisplayName("4. Test de modification du nom de la monoplace vide")
    public void testModificationNomMonoplaceVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setNomMonoplace(""));
        assertEquals("Le nom de la monoplace ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification du nom de l'écurie vide
     * @throws IllegalArgumentException
     */
    @Test
    @Order(5)
    @DisplayName("5. Test de modification du nom de l'écurie vide")
    public void testModificationNomEcurieVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setEcurie(""));
        assertEquals("Le nom de l'écurie ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification du nom du moteur vide
     */
    @Test
    @Order(6)
    @DisplayName("6. Test de modification du nom du moteur vide")
    public void testModificationNomMoteurVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setNomMoteur(""));
        assertEquals("Le nom du moteur ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de l'aileron avant vide
     */
    @Test
    @Order(7)
    @DisplayName("7. Test de modification de l'aileron avant vide")
    public void testModificationAileronAvantVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setAileronAvant(""));
        assertEquals("Le type d'aileron avant ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de l'aileron arrière vide
     */
    @Test
    @Order(8)
    @DisplayName("8. Test de modification de l'aileron arrière vide")
    public void testModificationAileronArriereVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setAileronArriere(""));
        assertEquals("Le type d'aileron arrière ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification des freins vide
     */
    @Test
    @Order(9)
    @DisplayName("9. Test de modification des freins vide")
    public void testModificationFreinsVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setFreins(""));
        assertEquals("Le type de freins ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de la boîte de vitesses vide
     */
    @Test
    @Order(10)
    @DisplayName("10. Test de modification de la boîte de vitesses vide")
    public void testModificationBoiteVitesseVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setBoiteVitesse(""));
        assertEquals("Le type de boîte de vitesses ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification des pneus vide
     */
    @Test
    @Order(11)
    @DisplayName("11. Test de modification des pneus vide")
    public void testModificationPneusVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setPneus(""));
        assertEquals("Le type de pneus ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification du poids négatif
     */
    @Test
    @Order(12)
    @DisplayName("12. Test de modification du poids négatif")
    public void testModificationPoidsNegatif() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        NegativeArgumentException exception = Assertions.assertThrows(NegativeArgumentException.class, () -> monoplace.setPoids(-1.0));
        assertEquals("Le poids de la monoplace ne peut pas être négatif.", exception.getMessage());
    }

    /**
     * Test de modification de la capacité maximale du réservoir négative
     */
    @Test
    @Order(13)
    @DisplayName("13. Test de modification de la capacité maximale du réservoir négative")
    public void testModificationCapaciteMaxReservoirNegative() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        NegativeArgumentException exception = Assertions.assertThrows(NegativeArgumentException.class, () -> monoplace.setCapaciteMaxReservoir(-1.0));
        assertEquals("La capacité maximale du réservoir ne peut pas être négative.", exception.getMessage());
    }

    /**
     * Test de modification du châssis vide
     */
    @Test
    @Order(14)
    @DisplayName("14. Test de modification du châssis vide")
    public void testModificationChassisVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setChassis(""));
        assertEquals("Le type de châssis ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de la suspension vide
     */
    @Test
    @Order(15)
    @DisplayName("15. Test de modification de la suspension vide")
    public void testModificationSuspensionVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setSuspension(""));
        assertEquals("Le type de suspension ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification du fond plat vide
     */
    @Test
    @Order(16)
    @DisplayName("16. Test de modification du fond plat vide")
    public void testModificationFondPlatVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setFondPlat(""));
        assertEquals("Le type de fond plat ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de l'ingénieur de course vide
     */
    @Test
    @Order(17)
    @DisplayName("17. Test de modification de l'ingénieur de course vide")
    public void testModificationIngenieurCourseVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setIngenieurCourse(""));
        assertEquals("Le nom de l'ingénieur de course ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification de l'entrepôt vide
     */
    @Test
    @Order(18)
    @DisplayName("18. Test de modification de l'entrepôt vide")
    public void testModificationEntrepotVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setEntrepot(""));
        assertEquals("Le nom de l'entrepôt ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de modification du pilote vide
     */
    @Test
    @Order(19)
    @DisplayName("19. Test de modification du pilote vide")
    public void testModificationPiloteVide() {
        MonoplaceDTO monoplace = new MonoplaceDTO("SF-24", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello");
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> monoplace.setPilote(""));
        assertEquals("Le nom du pilote ne peut pas être vide.", exception.getMessage());
    }

    /**
     * Test de la création d'une monoplace avec un argument vide
     */
    @Test
    @Order(20)
    @DisplayName("20. Test de la création d'une monoplace avec un argument vide")
    public void testCreationMonoplaceAvecArgumentVide() {
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> new MonoplaceDTO("", "Ferrari", "Charles Leclerc", "Bryan Bozzi", "Maranello"));
        assertEquals("Tous les champs doivent être remplis.", exception.getMessage());
    }

    /**
     * Test de la création d'une monoplace grand constructeur avec un argument vide
     */
    @Test
    @Order(21)
    @DisplayName("21. Test de la création d'une monoplace grand constructeur avec un argument vide")
    public void testCreationMonoplaceGrandConstructeurAvecArgumentVide() {
        EmptyArgumentException exception = Assertions.assertThrows(EmptyArgumentException.class, () -> new MonoplaceDTO("RB20", "Red Bull Racing", "", "Aileron avant aérodynamique", "Aileron arrière réglable", "Freins carbone", "Boîte de vitesses semi-automatique", "Pneus Pirelli", 798.0, 110.0, "Châssis en fibre de carbone", "Suspension indépendante", "Fond plat avec effets de sol", "Adrian Newey", "Hangar 13", "Max Verstappen"));
        assertEquals("Tous les champs doivent être remplis.", exception.getMessage());
    }
}