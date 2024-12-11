package be.helha.projetFinal;
import be.helha.projetFinal.DAO.MonoplaceDAOImpl;
import be.helha.projetFinal.MonoplaceDTO.MonoplaceDTO;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);

        MonoplaceDAOImpl monoplaceDAO = MonoplaceDAOImpl.getInstance();

        boolean continuer = true;
        do {
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
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix){
                case 1:
                    System.out.println("Voici la liste des monoplaces : ");
                    monoplaceDAO.obtenirToutesLesMonoplaces().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Ajout d'un monoplace : ");
                    System.out.println("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.println("Ecurie : ");
                    String ecurie = scanner.nextLine();
                    System.out.println("Pilote : ");
                    String pilote = scanner.nextLine();
                    System.out.println("Ingenieur : ");
                    String ingenieur = scanner.nextLine();
                    System.out.println("Entrpot : ");
                    String entrepot = scanner.nextLine();

                    MonoplaceDTO monoplace = new MonoplaceDTO(nom, ecurie, pilote, ingenieur, entrepot);
                    monoplaceDAO.ajouterMonoplace(monoplace);
                    break;
                case 3:
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
                    break;
                case 4:
                    System.out.println("Affichage d'un monoplace par son id : ");
                    System.out.println("Id : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    monoplaceDAO.obtenirMonoplaceParId(id);
                    if (monoplaceDAO.obtenirMonoplaceParId(id) == null){
                        System.out.println("Monoplace non trouvé");
                    }else {
                        System.out.println(monoplaceDAO.obtenirMonoplaceParId(id));
                    }
                    break;
                case 5:
                    System.out.println("Affichage d'un monoplace par son nom : ");
                    System.out.println("Nom : ");
                    String nomMonoplace = scanner.nextLine();
                    monoplaceDAO.obtenirMonoplace(nomMonoplace);
                    if (monoplaceDAO.obtenirMonoplace(nomMonoplace) == null){
                        System.out.println("Monoplace non trouvé");
                    }else {
                        System.out.println(monoplaceDAO.obtenirMonoplace(nomMonoplace));
                    }
                    break;
                case 6:
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
                    break;
                case 7:
                    System.out.println("Suppression d'un monoplace : ");
                    System.out.println("Id : ");
                    int idMonoplaceSuppr = scanner.nextInt();
                    monoplaceDAO.supprimerMonoplace(idMonoplaceSuppr);
                    break;
                case 8:
                    continuer = false;
                    break;
            }
        }while (continuer==true);
    }
}