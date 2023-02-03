public class Joueur {

  // Attributs
  private String nom;
  private char forme;
  private int couleur;

  // Constructeur par défaut
  public Joueur() {
    this.nom = "";
    this.forme = ' ';
    this.couleur = 0;
  }

  // Constructeur
  public Joueur(String nom, char forme, int couleur) {
    this.nom = nom;
    this.forme = forme;
    this.couleur = couleur;
  }

  // Getters et Setters
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public char getForme() {
    return forme;
  }

  public void setForme(char forme) {
    this.forme = forme;
  }

  public int getCouleur() {
    return couleur;
  }

  public void setCouleur(int couleur) {
    this.couleur = couleur;
  }
}