import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Score {

  // Attributs
  private Joueur joueur;
  private int tour;

  // Constructeur
  public Score(Joueur joueur, int tour) {
    this.joueur = joueur;
    this.tour = tour;
  }

  // Methode
  // Verifier le top 10
  public void verifTop10() {
    BufferedReader br;
    String line;
    List<String> noms = new ArrayList<>();
    List<Integer> tours = new ArrayList<>();
    try {
      br = new BufferedReader(new FileReader("top10.txt"));
      while ((line = br.readLine()) != null) {
        if (line != "" || line != null) {
          noms.add(line.split("=")[0]);
          tours.add(Integer.valueOf(line.split("=")[1]));
        }
      }
      br.close();
    } catch (Exception e) {
      System.out.println("Erreur: " + e);
    }
    List<String> nomsNouveauTop10 = noms;
    List<Integer> toursNouveauTop10 = tours;
    int i = 0;
    for (int tour : tours) {
      if (this.tour < tour) {
        nomsNouveauTop10.remove(i);
        toursNouveauTop10.remove(i);
        i--;
      }
      if (nomsNouveauTop10.size() == 11) {
        nomsNouveauTop10.remove(10);
        toursNouveauTop10.remove(10);
      }
      i++;
    }
    nomsNouveauTop10.add(this.joueur.getNom());
    toursNouveauTop10.add(this.tour);
    File f = new File("top10.txt");
    f.delete();
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("top10.txt", true));
      for (int j = 0; j < 10; j++) {
        bw.write(nomsNouveauTop10.get(j) + "=" + toursNouveauTop10.get(j) + "\n");
      }
      bw.close();
    } catch (Exception e) {
      System.out.println("Erreur: " + e);
    }
  }

}