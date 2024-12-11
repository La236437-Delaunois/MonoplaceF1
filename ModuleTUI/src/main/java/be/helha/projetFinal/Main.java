package be.helha.projetFinal;

import be.helha.projetFinal.DAO.MonoplaceDAOImpl;
import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Classe principale pour l'application de gestion des monoplaces.
 */
public class Main {
    /**
     * Méthode principale pour exécuter l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);

        MonoplaceDAOImpl monoplaceDAO = MonoplaceDAOImpl.getInstance();

        boolean continuer = true;
        do {
            afficherMenu();
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    afficherToutesLesMonoplaces(monoplaceDAO);
                    break;
                case 2:
                    ajouterMonoplace(scanner, monoplaceDAO);
                    break;
                case 3:
                    ajouterMonoplaceAvecTousLesChamps(scanner, monoplaceDAO);
                    break;
                case 4:
                    afficherMonoplaceParId(scanner, monoplaceDAO);
                    break;
                case 5:
                    afficherMonoplaceParNom(scanner, monoplaceDAO);
                    break;
                case 6:
                    modifierMonoplace(scanner, monoplaceDAO);
                    break;
                case 7:
                    supprimerMonoplace(scanner, monoplaceDAO);
                    break;
                case 8:
                    continuer = false;
                    break;
            }
        } while (continuer);
    }

    /**
     * Affiche le menu principal.
     */
    private static void afficherMenu() {
        System.out.println("===================================");
        System.out.println("    Menu : ");
        System.out.println("    1. Afficher les monoplaces");
        System.out.println("    2. Ajouter un monoplace");
        System.out.println("    3. Ajouter un monoplace avec tous les champs");
        System.out.println("    4. Afficher un monoplace par son id");
        System.out.println("    5. Afficher un monoplace par son nom");
        System.out.println("    6. Modifier un monoplace");
        System.out.println("    7. Supprimer un monoplace");
        System.out.println("    8. Quitter");
        System.out.println("===================================");
    }

    /**
     * Affiche toutes les monoplaces.
     *
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void afficherToutesLesMonoplaces(MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Voici la liste des monoplaces : ");
        monoplaceDAO.obtenirToutesLesMonoplaces().forEach(System.out::println);
    }

    /**
     * Ajoute une nouvelle monoplace.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void ajouterMonoplace(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Ajout d'un monoplace : ");
        System.out.println("Nom : ");
        String nom = scanner.nextLine();
        System.out.println("Ecurie : ");
        String ecurie = scanner.nextLine();
        System.out.println("Pilote : ");
        String pilote = scanner.nextLine();
        System.out.println("Ingenieur : ");
        String ingenieur = scanner.nextLine();
        System.out.println("Entrepot : ");
        String entrepot = scanner.nextLine();

        MonoplaceDTO monoplace = new MonoplaceDTO(nom, ecurie, pilote, ingenieur, entrepot);
        monoplaceDAO.ajouterMonoplace(monoplace);
    }

    /**
     * Ajoute une nouvelle monoplace avec tous les champs.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void ajouterMonoplaceAvecTousLesChamps(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Ajout d'un monoplace avec tous les champs : ");
        System.out.println("Nom : ");
        String nomComplet = scanner.nextLine();
        System.out.println("Ecurie : ");
        String ecurieComplet = scanner.nextLine();
        System.out.println("Nom moteur : ");
        String nomMoteurComplet = scanner.nextLine();
        System.out.println("Aileron avant : ");
        String aileronAvantComplet = scanner.nextLine();
        System.out.println("Aileron arriere : ");
        String aileronArriereComplet = scanner.nextLine();
        System.out.println("Freins : ");
        String freinsComplet = scanner.nextLine();
        System.out.println("Boite de vitesse : ");
        String boiteVitesseComplet = scanner.nextLine();
        System.out.println("Pneus : ");
        String pneusComplet = scanner.nextLine();
        System.out.println("Poids : ");
        double poidsComplet = scanner.nextDouble();
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.println("Capacité max du reservoir : ");
        double capaciteMaxReservoirComplet = scanner.nextDouble();
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.println("Châssis : ");
        String chassisComplet = scanner.nextLine();
        System.out.println("Suspension : ");
        String suspensionComplet = scanner.nextLine();
        System.out.println("Fond plat : ");
        String fondPlatComplet = scanner.nextLine();
        System.out.println("Ingenieur : ");
        String ingenieurComplet = scanner.nextLine();
        System.out.println("Entrepot : ");
        String entrepotComplet = scanner.nextLine();
        System.out.println("Pilote : ");
        String piloteComplet = scanner.nextLine();

        MonoplaceDTO monoplaceComplet = new MonoplaceDTO(nomComplet, ecurieComplet, nomMoteurComplet, aileronAvantComplet, aileronArriereComplet, freinsComplet, boiteVitesseComplet, pneusComplet, poidsComplet, capaciteMaxReservoirComplet, chassisComplet, suspensionComplet, fondPlatComplet, ingenieurComplet, entrepotComplet, piloteComplet);
        monoplaceDAO.ajouterMonoplace(monoplaceComplet);
    }

    /**
     * Affiche une monoplace par son identifiant.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void afficherMonoplaceParId(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Affichage d'un monoplace par son id : ");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        MonoplaceDTO monoplace = monoplaceDAO.obtenirMonoplaceParId(id);
        if (monoplace == null) {
            System.out.println("Monoplace non trouvé");
        } else {
            System.out.println(monoplace);
        }
    }

    /**
     * Affiche une monoplace par son nom.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void afficherMonoplaceParNom(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Affichage d'un monoplace par son nom : ");
        System.out.println("Nom : ");
        String nomMonoplace = scanner.nextLine();
        MonoplaceDTO monoplace = monoplaceDAO.obtenirMonoplace(nomMonoplace);
        if (monoplace == null) {
            System.out.println("Monoplace non trouvé");
        } else {
            System.out.println(monoplace);
        }
    }

    /**
     * Modifie une monoplace existante.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void modifierMonoplace(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Modification d'un monoplace : ");
        System.out.println("Id : ");
        int idMonoplace = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.println("Nom : ");
        String nomMonoplaceModif = scanner.nextLine();
        System.out.println("Ecurie : ");
        String ecurieMonoplaceModif = scanner.nextLine();
        System.out.println("Pilote : ");
        String piloteMonoplaceModif = scanner.nextLine();
        System.out.println("Ingenieur : ");
        String ingenieurMonoplaceModif = scanner.nextLine();
        System.out.println("Entrepot : ");
        String entrepotMonoplaceModif = scanner.nextLine();

        MonoplaceDTO monoplaceModif = new MonoplaceDTO(nomMonoplaceModif, ecurieMonoplaceModif, piloteMonoplaceModif, ingenieurMonoplaceModif, entrepotMonoplaceModif);
        monoplaceModif.setIdMonoplace(idMonoplace);
        monoplaceDAO.modifierMonoplace(monoplaceModif);
    }

    /**
     * Supprime une monoplace par son identifiant.
     *
     * @param scanner      l'instance de Scanner pour lire les entrées utilisateur
     * @param monoplaceDAO l'instance de MonoplaceDAOImpl
     */
    private static void supprimerMonoplace(Scanner scanner, MonoplaceDAOImpl monoplaceDAO) {
        System.out.println("Suppression d'un monoplace : ");
        System.out.println("Id : ");
        int idMonoplaceSuppr = scanner.nextInt();
        monoplaceDAO.supprimerMonoplace(idMonoplaceSuppr);
    }
}