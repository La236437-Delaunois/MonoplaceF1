package be.helha.projetFinal.MonoplaceDTO;

import exceptions.EmptyArgumentException;
import exceptions.NegativeArgumentException;

/**
 * Classe MonoplaceDTO représente une monoplace de Formule 1 avec ses caractéristiques.
 */
public class MonoplaceDTO {
    private int idMonoplace;
    private String nomMonoplace;
    private String ecurie;
    private String nomMoteur;
    private String aileronAvant;
    private String aileronArriere;
    private String freins;
    private String boiteVitesse;
    private String pneus;
    private double poids;
    private double capaciteMaxReservoir;
    private String chassis;
    private String suspension;
    private String fondPlat;
    private String ingenieurCourse;
    private String entrepot;
    private String pilote;

    /**
     * Constructeur avec tous les paramètres.
     *
     * @param nomMonoplace le nom de la monoplace
     * @param ecurie le nom de l'écurie
     * @param nomMoteur le nom du moteur
     * @param aileronAvant le type d'aileron avant
     * @param aileronArriere le type d'aileron arrière
     * @param freins le type de freins
     * @param boiteVitesse le type de boîte de vitesse
     * @param pneus le type de pneus
     * @param poids le poids de la monoplace
     * @param capaciteMaxReservoir la capacité maximale du réservoir
     * @param chassis le type de châssis
     * @param suspension le type de suspension
     * @param fondPlat le type de fond plat
     * @param ingenieurCourse le nom de l'ingénieur de course
     * @param entrepot le nom de l'entrepôt
     * @param pilote le nom du pilote
     *
     * @throws EmptyArgumentException si un des paramètres est vide
     */
    public MonoplaceDTO(String nomMonoplace, String ecurie, String nomMoteur, String aileronAvant, String aileronArriere, String freins, String boiteVitesse, String pneus, double poids, double capaciteMaxReservoir, String chassis, String suspension, String fondPlat, String ingenieurCourse, String entrepot, String pilote) throws  EmptyArgumentException {
        if (nomMonoplace.isEmpty() || ecurie.isEmpty() || nomMoteur.isEmpty() || aileronAvant.isEmpty() || aileronArriere.isEmpty() || freins.isEmpty() || boiteVitesse.isEmpty() || pneus.isEmpty() || chassis.isEmpty() || suspension.isEmpty() || fondPlat.isEmpty() || ingenieurCourse.isEmpty() || entrepot.isEmpty() || pilote.isEmpty()) {
            throw new EmptyArgumentException("Tous les champs doivent être remplis.");
        }else {
            this.idMonoplace = -1;
            this.nomMonoplace = nomMonoplace;
            this.ecurie = ecurie;
            this.nomMoteur = nomMoteur;
            this.aileronAvant = aileronAvant;
            this.aileronArriere = aileronArriere;
            this.freins = freins;
            this.boiteVitesse = boiteVitesse;
            this.pneus = pneus;
            this.poids = poids;
            this.capaciteMaxReservoir = capaciteMaxReservoir;
            this.chassis = chassis;
            this.suspension = suspension;
            this.fondPlat = fondPlat;
            this.ingenieurCourse = ingenieurCourse;
            this.entrepot = entrepot;
            this.pilote = pilote;
        }
    }

    /**
     * Constructeur avec les paramètres principaux.
     *
     * @param nomMonoplace le nom de la monoplace
     * @param ecurie le nom de l'écurie
     * @param pilote le nom du pilote
     * @param ingenieurCourse le nom de l'ingénieur de course
     * @param entrepot le nom de l'entrepôt
     *
     * @throws EmptyArgumentException si un des paramètres est vide
     */
    public MonoplaceDTO(String nomMonoplace, String ecurie, String pilote, String ingenieurCourse, String entrepot) throws EmptyArgumentException {
        if(nomMonoplace.isEmpty() || ecurie.isEmpty() || pilote.isEmpty() || ingenieurCourse.isEmpty() || entrepot.isEmpty()) {
            throw new EmptyArgumentException("Tous les champs doivent être remplis.");
        }else {
            this.idMonoplace = -1;
            this.nomMonoplace = nomMonoplace;
            this.ecurie = ecurie;
            this.pilote = pilote;
            this.ingenieurCourse = ingenieurCourse;
            this.entrepot = entrepot;
            this.nomMoteur = "non défini";
            this.aileronAvant = "non défini";
            this.aileronArriere = "non défini";
            this.freins = "non défini";
            this.boiteVitesse = "non défini";
            this.pneus = "non défini";
            this.poids = 0;
            this.capaciteMaxReservoir = 0;
            this.chassis = "non défini";
            this.suspension = "non défini";
            this.fondPlat = "non défini";

        }
    }

    /**
     * Obtient l'identifiant de la monoplace.
     *
     * @return l'identifiant de la monoplace
     */
    public int getIdMonoplace() {
        return idMonoplace;
    }

    /**
     * Définit l'identifiant de la monoplace.
     *
     * @param idMonoplace l'identifiant de la monoplace
     */
    public void setIdMonoplace(int idMonoplace) {
        this.idMonoplace = idMonoplace;
    }

    /**
     * Obtient le nom de la monoplace.
     *
     * @return le nom de la monoplace
     */
    public String getNomMonoplace() {
        return nomMonoplace;
    }

    /**
     * Définit le nom de la monoplace.
     *
     * @param nomMonoplace le nom de la monoplace
     */
    public void setNomMonoplace(String nomMonoplace) throws EmptyArgumentException {
        if(nomMonoplace.isEmpty()) throw new EmptyArgumentException("Le nom de la monoplace ne peut pas être vide.");
        else this.nomMonoplace = nomMonoplace;
    }

    /**
     * Obtient le nom de l'écurie.
     *
     * @return le nom de l'écurie
     */
    public String getEcurie() {
        return ecurie;
    }

    /**
     * Définit le nom de l'écurie.
     *
     * @param ecurie le nom de l'écurie
     */
    public void setEcurie(String ecurie) throws EmptyArgumentException {
        if(ecurie.isEmpty()) throw new EmptyArgumentException("Le nom de l'écurie ne peut pas être vide.");
        else this.ecurie = ecurie;
    }

    /**
     * Obtient le nom du moteur.
     *
     * @return le nom du moteur
     */
    public String getNomMoteur() {
        return nomMoteur;
    }

    /**
     * Définit le nom du moteur.
     *
     * @param nomMoteur le nom du moteur
     */
    public void setNomMoteur(String nomMoteur) throws EmptyArgumentException {
        if(nomMoteur.isEmpty()) throw new EmptyArgumentException("Le nom du moteur ne peut pas être vide.");
        else this.nomMoteur = nomMoteur;
    }

    /**
     * Obtient le type d'aileron avant.
     *
     * @return le type d'aileron avant
     */
    public String getAileronAvant() {
        return aileronAvant;
    }

    /**
     * Définit le type d'aileron avant.
     *
     * @param aileronAvant le type d'aileron avant
     */
    public void setAileronAvant(String aileronAvant) throws EmptyArgumentException {
        if(aileronAvant.isEmpty()) throw new EmptyArgumentException("Le type d'aileron avant ne peut pas être vide.");
        else this.aileronAvant = aileronAvant;
    }

    /**
     * Obtient le type d'aileron arrière.
     *
     * @return le type d'aileron arrière
     */
    public String getAileronArriere() {
        return aileronArriere;
    }

    /**
     * Définit le type d'aileron arrière.
     *
     * @param aileronArriere le type d'aileron arrière
     */
    public void setAileronArriere(String aileronArriere) throws EmptyArgumentException {
        if(aileronArriere.isEmpty()) throw new EmptyArgumentException("Le type d'aileron arrière ne peut pas être vide.");
        else this.aileronArriere = aileronArriere;
    }

    /**
     * Obtient le type de freins.
     *
     * @return le type de freins
     */
    public String getFreins() {
        return freins;
    }

    /**
     * Définit le type de freins.
     *
     * @param freins le type de freins
     */
    public void setFreins(String freins) throws EmptyArgumentException {
        if(freins.isEmpty()) throw new EmptyArgumentException("Le type de freins ne peut pas être vide.");
        else this.freins = freins;
    }

    /**
     * Obtient le type de boîte de vitesse.
     *
     * @return le type de boîte de vitesse
     */
    public String getBoiteVitesse() {
        return boiteVitesse;
    }

    /**
     * Définit le type de boîte de vitesse.
     *
     * @param boiteVitesse le type de boîte de vitesse
     */
    public void setBoiteVitesse(String boiteVitesse) throws EmptyArgumentException {
        if(boiteVitesse.isEmpty()) throw new EmptyArgumentException("Le type de boîte de vitesses ne peut pas être vide.");
        else this.boiteVitesse = boiteVitesse;
    }

    /**
     * Obtient le type de pneus.
     *
     * @return le type de pneus
     */
    public String getPneus() {
        return pneus;
    }

    /**
     * Définit le type de pneus.
     *
     * @param pneus le type de pneus
     */
    public void setPneus(String pneus)throws EmptyArgumentException {
        if(pneus.isEmpty()) throw new EmptyArgumentException("Le type de pneus ne peut pas être vide.");
        else this.pneus = pneus;
    }

    /**
     * Obtient le poids de la monoplace.
     *
     * @return le poids de la monoplace
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Définit le poids de la monoplace.
     *
     * @param poids le poids de la monoplace
     */
    public void setPoids(double poids) throws NegativeArgumentException {
        if(poids < 0) throw new NegativeArgumentException("Le poids de la monoplace ne peut pas être négatif.");
        else this.poids = poids;
    }

    /**
     * Obtient la capacité maximale du réservoir.
     *
     * @return la capacité maximale du réservoir
     */
    public double getCapaciteMaxReservoir() {
        return capaciteMaxReservoir;
    }

    /**
     * Définit la capacité maximale du réservoir.
     *
     * @param capaciteMaxReservoir la capacité maximale du réservoir
     */
    public void setCapaciteMaxReservoir(double capaciteMaxReservoir) throws NegativeArgumentException {
        if(capaciteMaxReservoir < 0) throw new NegativeArgumentException("La capacité maximale du réservoir ne peut pas être négative.");
        else this.capaciteMaxReservoir = capaciteMaxReservoir;
    }

    /**
     * Obtient le type de châssis.
     *
     * @return le type de châssis
     */
    public String getChassis() {
        return chassis;
    }

    /**
     * Définit le type de châssis.
     *
     * @param chassis le type de châssis
     */
    public void setChassis(String chassis) throws EmptyArgumentException {
        if(chassis.isEmpty()) throw new EmptyArgumentException("Le type de châssis ne peut pas être vide.");
        else this.chassis = chassis;
    }

    /**
     * Obtient le type de suspension.
     *
     * @return le type de suspension
     */
    public String getSuspension() {
        return suspension;
    }

    /**
     * Définit le type de suspension.
     *
     * @param suspension le type de suspension
     */
    public void setSuspension(String suspension) throws EmptyArgumentException {
        if(suspension.isEmpty()) throw new EmptyArgumentException("Le type de suspension ne peut pas être vide.");
        else this.suspension = suspension;
    }

    /**
     * Obtient le type de fond plat.
     *
     * @return le type de fond plat
     */
    public String getFondPlat() {
        return fondPlat;
    }

    /**
     * Définit le type de fond plat.
     *
     * @param fondPlat le type de fond plat
     */
    public void setFondPlat(String fondPlat) throws EmptyArgumentException {
        if(fondPlat.isEmpty()) throw new EmptyArgumentException("Le type de fond plat ne peut pas être vide.");
        else this.fondPlat = fondPlat;
    }

    /**
     * Obtient le nom de l'ingénieur de course.
     *
     * @return le nom de l'ingénieur de course
     */
    public String getIngenieurCourse() {
        return ingenieurCourse;
    }

    /**
     * Définit le nom de l'ingénieur de course.
     *
     * @param ingenieurCourse le nom de l'ingénieur de course
     */
    public void setIngenieurCourse(String ingenieurCourse) throws EmptyArgumentException {
        if (ingenieurCourse.isEmpty()) throw new EmptyArgumentException("Le nom de l'ingénieur de course ne peut pas être vide.");
        else this.ingenieurCourse = ingenieurCourse;
    }

    /**
     * Obtient le nom de l'entrepôt.
     *
     * @return le nom de l'entrepôt
     */
    public String getEntrepot() {
        return entrepot;
    }

    /**
     * Définit le nom de l'entrepôt.
     *
     * @param entrepot le nom de l'entrepôt
     */
    public void setEntrepot(String entrepot) throws EmptyArgumentException {
        if(entrepot.isEmpty()) throw new EmptyArgumentException("Le nom de l'entrepôt ne peut pas être vide.");
        else this.entrepot = entrepot;
    }

    /**
     * Obtient le nom du pilote.
     *
     * @return le nom du pilote
     */
    public String getPilote() {
        return pilote;
    }

    /**
     * Définit le nom du pilote.
     *
     * @param pilote le nom du pilote
     */
    public void setPilote(String pilote) throws EmptyArgumentException {
        if(pilote.isEmpty()) throw new EmptyArgumentException("Le nom du pilote ne peut pas être vide.");
        else this.pilote = pilote;

    }

    /**
     * Obtient une représentation textuelle de la monoplace.
     * @return une représentation textuelle de la monoplace
     */
    @Override
    public String toString() {
        return "====================================== 🏎️ ======================================\n" +
                " Monoplace DTO \n" +
                "-------------------------------------------------------------------------------\n" +
                "    Id Monoplace          = " + idMonoplace + "\n" +
                "    Nom Monoplace         = '" + nomMonoplace + "'\n" +
                "    Écurie                = '" + ecurie + "'\n" +
                "    Nom Moteur            = '" + nomMoteur + "'\n" +
                "    Aileron Avant         = '" + aileronAvant + "'\n" +
                "    Aileron Arrière       = '" + aileronArriere + "'\n" +
                "    Freins                = '" + freins + "'\n" +
                "    Boîte Vitesse         = '" + boiteVitesse + "'\n" +
                "    Pneus                 = '" + pneus + "'\n" +
                "    Poids                 = " + poids + " kg\n" +
                "    Capacité Max Réservoir = " + capaciteMaxReservoir + " L\n" +
                "    Châssis               = '" + chassis + "'\n" +
                "    Suspension            = '" + suspension + "'\n" +
                "    Fond Plat             = '" + fondPlat + "'\n" +
                "    Ingénieur Course      = '" + ingenieurCourse + "'\n" +
                "    Entrepôt              = '" + entrepot + "'\n" +
                "    Pilote                = '" + pilote + "'\n" +
                "-------------------------------------------------------------------------------\n" +
                "====================================== 🏎️ ======================================\n";
    }
}