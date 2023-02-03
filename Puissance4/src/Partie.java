import java.util.Scanner;

public class Partie {

  // Attributes
  private Joueur j1;
  private Joueur j2;
  private Puissance4 p4;
  private int positions[][];
  private int Tour;

  // Constructeur
  public Partie(Joueur j1, Joueur j2) {
    this.j1 = j1;
    this.j2 = j2;
    this.p4 = new Puissance4();
    this.positions = new int[7][6];
    this.Tour = 0;
  }

  // Methode
  // Initialiser le plateau
  public void initialiserPlateau() {
    this.p4.initialiserPlateau();
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 6; j++) {
        this.positions[i][j] = 0;
      }
    }
  }

  // Jouer un tour
  public void jouerTour(int colonne, int couleur) {
    for (int i = 5; i >= 0; i--) {
      if (this.positions[i][colonne] == 0) {
        try {
          this.p4.jouerTour(colonne, couleur);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        this.positions[i][colonne] = couleur;
        break;
      }
    }
    this.Tour++;
  }

  // Lancer une partie
  public void lancerPartie() {
    this.initialiserPlateau();
    while (true) {
      this.p4.afficherPlateau();
      Joueur joueur = this.Tour % 2 == 0 ? this.j1 : this.j2;
      System.out.println("Au tour de " + joueur.getNom());
      int colonne = demanderColonne(joueur);
      this.jouerTour(colonne, joueur.getCouleur());
      if (this.p4.detecterVictoire()) {
        this.p4.afficherPlateau();
        System.out.println("Victoire de " + joueur.getNom());
        creerScore(joueur);
        break;
      }
      if (this.Tour == 42) {
        this.p4.afficherPlateau();
        System.out.println("Match nul !");
        break;
      }
    }
  }

  // Demander colonne
  private int demanderColonne(Joueur joueur) {
    while (true) {
      System.out.println("Joueur " + joueur.getNom() + ", choisissez votre colonne (1 à 7): ");
      Scanner sc = new Scanner(System.in);
      int colonne = sc.nextInt();
      if (colonne >= 1 && colonne <= 7 && this.positions[0][colonne - 1] == 0) {
        return colonne - 1;
      } else {
        System.out.println("Il n'y a pas de place disponible, veuillez choisir une autre colonne !");
      }
    }
  }

  // Creer le score
  public void creerScore(Joueur joueur) {
    Score s = new Score(joueur, this.Tour);
    s.verifTop10();
  }
}