import java.util.Scanner;

public class Menu {

  // Afficher le Menu
  public void afficherMenu() {
    System.out.println("=========== Puissance 4 ===========");
    System.out.println("1 - Jouer à 2");
    System.out.println("2 - Afficher le TOP 10");
    System.out.println("3 - Quitter");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Votre choix : ");
  }

  // Demande de l'utilisateur
  public void choixUtilisateur() {
    Scanner sc = new Scanner(System.in);
    int choix = sc.nextInt();

    switch (choix) {
      case 1:
        jouer();
        break;
      case 2:
        top10();
        break;
      case 3:
        quitter();
        break;
    }
  }

  // Jouer à 2
  public void jouer() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Veuillez entrer le nom du Joueur 1 : ");
    String nomJoueur1 = sc.nextLine();
    System.out.println("Veuillez choisir le symbole du Joueur 1 (@ ou =) : ");
    char symboleJoueur1 = sc.nextLine().charAt(0);
    System.out.println("Veuillez choisir la couleur du Joueur 1 (bleu ou rouge) : ");
    int couleurJoueur1 = getCouleur(sc.nextLine());

    System.out.println("Veuillez entrer le nom du Joueur 2 : ");
    String nomJoueur2 = sc.nextLine();
    System.out.println("Veuillez choisir le symbole du Joueur 2 (@ ou =) :");
    char symboleJoueur2 = sc.nextLine().charAt(0);
    System.out.println("Veuillez choisir la couleur du Joueur 2 (bleu ou rouge) : ");
    int couleurJoueur2 = getCouleur(sc.nextLine());

    Joueur j1 = new Joueur(nomJoueur1, symboleJoueur1, couleurJoueur1);
    Joueur j2 = new Joueur(nomJoueur2, symboleJoueur2, couleurJoueur2);

    Partie p = new Partie(j1, j2);
    p.lancerPartie();
  }

  // Methode pour déterminer la couleur
  private int getCouleur(String couleur) {
    int couleurInt;
    if (couleur.equalsIgnoreCase("bleu")) {
      couleurInt = 1;
    } else {
      couleurInt = 2;
    }
    return couleurInt;
  }

  // Afficher le TOP10
  public void top10() {
    System.out.println("------ Top 10 des meilleurs scores ------");
    // Afficher le contenu du fichier (Top10 à partir du fichier scores.txt)
  }

  // Quitter le jeu
  public void quitter() {
    System.out.println("Au revoir !");
    System.exit(0);
  }
}