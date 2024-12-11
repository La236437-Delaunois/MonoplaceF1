package be.helha.projetFinal.MonoplaceDTO;

/**
 * Classe MonoplaceDTO représente une monoplace de Formule 1 avec ses caractéristiques.
 */
public class MonoplaceDTO {
    private int idMonoplace;
    private String nomMonoplace;
    private String ecurie;
    private String nomMoteur;
    private String modeleMoteur;
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
     * @param modeleMoteur le modèle du moteur
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
     */
    public MonoplaceDTO(String nomMonoplace, String ecurie, String nomMoteur, String modeleMoteur, String aileronAvant, String aileronArriere, String freins, String boiteVitesse, String pneus, double poids, double capaciteMaxReservoir, String chassis, String suspension, String fondPlat, String ingenieurCourse, String entrepot, String pilote) {
        this.nomMonoplace = nomMonoplace;
        this.ecurie = ecurie;
        this.nomMoteur = nomMoteur;
        this.modeleMoteur = modeleMoteur;
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

    /**
     * Constructeur avec les paramètres principaux.
     *
     * @param nomMonoplace le nom de la monoplace
     * @param ecurie le nom de l'écurie
     * @param pilote le nom du pilote
     * @param ingenieurCourse le nom de l'ingénieur de course
     * @param entrepot le nom de l'entrepôt
     */
    public MonoplaceDTO(String nomMonoplace, String ecurie, String pilote, String ingenieurCourse, String entrepot) {
        this.nomMonoplace = nomMonoplace;
        this.ecurie = ecurie;
        this.pilote = pilote;
        this.ingenieurCourse = ingenieurCourse;
        this.entrepot = entrepot;
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
    public void setNomMonoplace(String nomMonoplace) {
        this.nomMonoplace = nomMonoplace;
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
    public void setEcurie(String ecurie) {
        this.ecurie = ecurie;
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
    public void setNomMoteur(String nomMoteur) {
        this.nomMoteur = nomMoteur;
    }

    /**
     * Obtient le modèle du moteur.
     *
     * @return le modèle du moteur
     */
    public String getModeleMoteur() {
        return modeleMoteur;
    }

    /**
     * Définit le modèle du moteur.
     *
     * @param modeleMoteur le modèle du moteur
     */
    public void setModeleMoteur(String modeleMoteur) {
        this.modeleMoteur = modeleMoteur;
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
    public void setAileronAvant(String aileronAvant) {
        this.aileronAvant = aileronAvant;
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
    public void setAileronArriere(String aileronArriere) {
        this.aileronArriere = aileronArriere;
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
    public void setFreins(String freins) {
        this.freins = freins;
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
    public void setBoiteVitesse(String boiteVitesse) {
        this.boiteVitesse = boiteVitesse;
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
    public void setPneus(String pneus) {
        this.pneus = pneus;
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
    public void setPoids(double poids) {
        this.poids = poids;
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
    public void setCapaciteMaxReservoir(double capaciteMaxReservoir) {
        this.capaciteMaxReservoir = capaciteMaxReservoir;
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
    public void setChassis(String chassis) {
        this.chassis = chassis;
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
    public void setSuspension(String suspension) {
        this.suspension = suspension;
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
    public void setFondPlat(String fondPlat) {
        this.fondPlat = fondPlat;
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
    public void setIngenieurCourse(String ingenieurCourse) {
        this.ingenieurCourse = ingenieurCourse;
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
    public void setEntrepot(String entrepot) {
        this.entrepot = entrepot;
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
    public void setPilote(String pilote) {
        this.pilote = pilote;
    }
}