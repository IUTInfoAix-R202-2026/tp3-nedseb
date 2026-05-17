package fr.univ_amu.iut.exercice7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Exercice 7 - Pierre angulaire MVC : vérification d'une nuit de capture (parcours P3 de la SAÉ).
 *
 * <p>Cet exercice fait converger tous les apports du TP3 :
 *
 * <ul>
 *   <li>un <b>modèle métier</b> propre ({@link NuitVerification} agrège des {@link Sequence})
 *   <li>une <b>vue FXML</b> entièrement déclarative (SplitPane + TableView avec ses colonnes
 *       déclarées en FXML, panneau de détail à droite)
 *   <li>un <b>contrôleur</b> ({@link QualificationController}) qui branche la vue au modèle :
 *       <ul>
 *         <li>{@code tableView.setItems(nuit.getSequences())}
 *         <li>{@code cellValueFactory} sur chaque {@code TableColumn}
 *         <li>écouteur sur la sélection pour alimenter le panneau de droite
 *         <li>{@code disableProperty()} du bouton Écouter lié à la sélection
 *         <li>{@code bindBidirectional()} entre la TextArea de commentaire et le modèle
 *         <li>{@code Bindings.when().then().otherwise()} pour afficher le verdict
 *       </ul>
 * </ul>
 *
 * <p>La lecture audio est <b>simulée</b> : on ne lit pas réellement un fichier WAV - on change
 * juste le statut de la séquence et on affiche un texte « Lecture en cours... » pendant un court
 * délai. Implémenter la vraie lecture est un objet de la SAE.
 */
public class Qualification extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("QualificationView.fxml"));
    primaryStage.setTitle("VigieChiro - Vérifier l'enregistrement");
    primaryStage.setScene(new Scene(racine, 880, 520));
    primaryStage.show();
  }
}
