package be.helha.projetfinal.moduleapi;

import be.helha.projetFinal.DAO.MonoplaceDAOImpl;
import be.helha.projetFinal.MonoplaceDTO.*;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller pour les monoplaces de F1
 */
@RestController
@RequestMapping("/monoplaceF1")
public class MonoplaceF1Controller {

    private MonoplaceDAOImpl monoplaceF1DAO = MonoplaceDAOImpl.getInstance();

    /**
     * Vider la base de données
     * @return ResponseEntity avec un message de confirmation
     */
    @DeleteMapping
    public ResponseEntity<String> viderDB() {
        monoplaceF1DAO.supprimerAllMonoplace();
        return ResponseEntity.ok("Base de données vidée");
    }

    /**
     * Ajouter une monoplace à la DB
     * @return ResponseEntity avec un message de confirmation
     */
    @PostMapping
    public ResponseEntity<String> ajouterMonoplace(@RequestBody MonoplaceDTO monoplace) {

        monoplaceF1DAO.ajouterMonoplace(monoplace);
        return ResponseEntity.ok("Monoplace ajoutée");
    }

    /**
     * Lister toutes les monoplaces de la DB
     * @return ResponseEntity avec un message de confirmation
     */
    @GetMapping
    public ResponseEntity<List> listerMonoplaces() {
        // affiche la liste de toutes les monoplaces via la méthode de MonoplaceDAOImpl
        return ResponseEntity.ok(monoplaceF1DAO.obtenirToutesLesMonoplaces());
    }

    /**
     * Supprimer une monoplace de la DB
     * @return ResponseEntity avec un message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMonoplace(@RequestBody int id) {

        monoplaceF1DAO.supprimerMonoplace(id);
        return ResponseEntity.ok("Monoplace supprimée");
    }

    /**
     * Rechercher une monoplace par son id
     * @return ResponseEntity avec un message de confirmation
     */
    @GetMapping("/recupererMonoplace/{id}")
    public ResponseEntity<MonoplaceDTO> rechercherMonoplaceID(@PathVariable int id) {

        return ResponseEntity.ok(monoplaceF1DAO.obtenirMonoplaceParId(id));
    }

    /**
     * Rechercher une monoplace par son nom
     * @return ResponseEntity avec un message de confirmation
     */
    @GetMapping("/rechercheNom/{nom}")
    public ResponseEntity<MonoplaceDTO> rechercherMonoplaceNom(@PathVariable String nom) {

        return ResponseEntity.ok(monoplaceF1DAO.obtenirMonoplace(nom));
    }

    /**
     * Mettre à jour une monoplace de la DB
     * @return ResponseEntity avec un message de confirmation
     */
    @PutMapping("/{monoplace}")
    public ResponseEntity<String> mettreAJourMonoplace(@RequestBody MonoplaceDTO monoplace) {

        monoplaceF1DAO.modifierMonoplace(monoplace);
        return ResponseEntity.ok("Monoplace mise à jour");
    }
}
