public class Puissance4 {

  // Attributs
  private int[][] plateau;
  private int tour;

  // Constructeur
  public Puissance4() {
    this.plateau = new int[7][6];
    this.tour = 0;
  }

  // Méthodes
  // Initialiser le plateau
  public void initialiserPlateau() {
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 6; j++) {
        this.plateau[i][j] = 0;
      }
    }
  }

  // Jouer un tour
  public void jouerTour(int colonne, int couleur) throws Exception {
    if (colonne < 0 || colonne >= 7) { // Vérification du numéro de colonne
      throw new Exception("Numéro de colonne invalid !");
    }
    for (int i = 5; i >= 0; i--) {
      if (this.plateau[i][colonne] == 0) { // Vérification s'il y a déjà un pion dans la colonne
        this.plateau[i][colonne] = couleur;
        break;
      }
    }
    this.tour++;
  }

  // Détecter la victoire
  public boolean detecterVictoire() {
    int couleur = 0;
    // Horizontal
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        couleur = this.plateau[i][j];
        if (j + 3 < 6) { // Vérification s’il y a 4 pions aligné
          // Vérification des cases adjacentes
          if (couleur != 0 && couleur == this.plateau[i][j + 1] && couleur == this.plateau[i][j + 2]
              && couleur == this.plateau[i][j + 3] && this.plateau[i][j - 1] == couleur) {
            return true;
          } else if (couleur != 0 && couleur == this.plateau[i][j + 1] && couleur == this.plateau[i][j + 2]
              && couleur == this.plateau[i][j + 3] && this.plateau[i][j + 4] == couleur) {
            return true;
          }
        }
      }
    }
    // Vertical
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 3; j++) {
        couleur = this.plateau[j][i];
        // Vérification des cases adjacentes
        if (couleur != 0 && couleur == this.plateau[j + 1][i] && couleur == this.plateau[j + 2][i]
            && couleur == this.plateau[j + 3][i] && couleur == this.plateau[j - 1][i]) {
          return true;
        } else if (couleur != 0 && couleur == this.plateau[j + 1][i] && couleur == this.plateau[j + 2][i]
            && couleur == this.plateau[j + 3][i] && couleur == this.plateau[j + 4][i]) {
          return true;
        }
      }
    }
    // Diagonale Haut-Gauche à Bas-Droite
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        couleur = this.plateau[i][j];
        // Vérification des cases adjacentes
        if (couleur != 0 && couleur == this.plateau[i + 1][j + 1] && couleur == this.plateau[i + 2][j + 2]
            && couleur == this.plateau[i + 3][j + 3] && couleur == this.plateau[i - 1][j - 1]) {
          return true;
        } else if (couleur != 0 && couleur == this.plateau[i + 1][j + 1] && couleur == this.plateau[i + 2][j + 2]
            && couleur == this.plateau[i + 3][j + 3] && couleur == this.plateau[i + 4][j + 4]) {
          return true;
        }
      }
    }
    // Diagonale Bas-Gauche à Haut-Droite
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        couleur = this.plateau[i + 3][j];
        if (j + 3 < 7) { // Vérification s’il y a 4 pions aligné
          // Vérification des cases adjacentes
          if (couleur != 0 && couleur == this.plateau[i + 2][j + 1] && couleur == this.plateau[i + 1][j + 2]
              && couleur == this.plateau[i][j + 3] && couleur == this.plateau[i + 4][j - 1]) {
            return true;
          } else if (couleur != 0 && couleur == this.plateau[i + 2][j + 1] && couleur == this.plateau[i + 1][j + 2]
              && couleur == this.plateau[i][j + 3] && couleur == this.plateau[i - 1][j + 4]) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // Générer un pion
  public void genererPion(int couleur) throws Exception {
    boolean verif = false;
    while (true) {
      int colonne = (int) (Math.random() * (6)); // Modification du nombre 6
      if (this.plateau[0][colonne] == 0) {
        jouerTour(colonne, couleur);
        verif = true;
        break;
      }
    }
    if (!verif) {
      throw new Exception("Tous les pions sont déjà placés !");
    }
  }

  // Afficher le plateau
  public void afficherPlateau() {
    System.out.println("  1   2   3   4   5   6   7");
    System.out.println("----------------------------");
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (j < 6) {
          if (this.plateau[i][j] == 0)
            System.out.print("|   ");
          else if (this.plateau[i][j] == 1)
            System.out.print("| @ ");
          else
            System.out.print("| = ");
        }
      }
      System.out.println("|");
      System.out.println("----------------------------");
    }
  }

  // Getters
  public int[][] getPlateau() {
    return this.plateau;
  }

  public int getTour() {
    return this.tour;
  }
}