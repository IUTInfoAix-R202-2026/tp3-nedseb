package fr.univ_amu.iut.exercice7;

import java.time.LocalTime;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Modèle agrégé d'une nuit de capture en cours de vérification (parcours P3 du brief SAE 2.01).
 *
 * <p>Une nuit contient une liste observable de {@link Sequence}, un verdict global ({@code "OK"},
 * {@code "Douteux"} ou {@code "À jeter"}) et un commentaire libre. La vue se branche directement
 * sur l'{@link ObservableList} via {@code tableView.setItems(...)} : toute modification du modèle
 * se propage automatiquement à la table.
 */
public class NuitVerification {

  private final ObservableList<Sequence> sequences = FXCollections.observableArrayList();

  private final StringProperty verdictGlobal = new SimpleStringProperty(this, "verdictGlobal", "");

  private final StringProperty commentaire = new SimpleStringProperty(this, "commentaire", "");

  public ObservableList<Sequence> getSequences() {
    return sequences;
  }

  public StringProperty verdictGlobalProperty() {
    return verdictGlobal;
  }

  public String getVerdictGlobal() {
    return verdictGlobal.get();
  }

  public void setVerdictGlobal(String value) {
    verdictGlobal.set(value);
  }

  public StringProperty commentaireProperty() {
    return commentaire;
  }

  public String getCommentaire() {
    return commentaire.get();
  }

  public void setCommentaire(String value) {
    commentaire.set(value);
  }

  /**
   * Génère une nuit factice avec {@code n} séquences réparties régulièrement entre 20h00 et 06h00
   * (la nuit type d'enregistrement d'un PR), avec des fréquences pseudo-aléatoires entre 20 et 120
   * kHz (bande utile pour les chiroptères). Le générateur utilise un seed fixe pour rendre la démo
   * et les tests reproductibles.
   *
   * @param n nombre de séquences à générer (ignoré si &lt;= 0)
   * @return une nouvelle nuit pré-remplie avec ses séquences
   */
  public static NuitVerification genererJeu(int n) {
    NuitVerification nuit = new NuitVerification();
    if (n <= 0) {
      return nuit;
    }
    Random rng = new Random(42L);
    int debutMin = 20 * 60; // 20h00
    int finMin = 30 * 60; // 06h00 le lendemain (1800 min)
    int delta = n == 1 ? 0 : (finMin - debutMin) / (n - 1);
    for (int i = 0; i < n; i++) {
      int min = (debutMin + i * delta) % (24 * 60);
      LocalTime t = LocalTime.of(min / 60, min % 60);
      double freq = 20.0 + rng.nextDouble() * 100.0;
      nuit.sequences.add(new Sequence(t, freq, 5));
    }
    return nuit;
  }
}
