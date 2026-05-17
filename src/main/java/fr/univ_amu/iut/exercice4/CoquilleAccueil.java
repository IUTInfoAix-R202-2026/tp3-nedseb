package fr.univ_amu.iut.exercice4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Exercice 4 : la coquille principale de l'application VigieChiro PR Companion.
 *
 * <p>Vous avez déjà construit ce type de mise en page <b>en Java</b> au TP1 exercice 4 (BorderPane
 * + GridPane + HBox + MenuBar). Vous obtenez ici la <b>même</b> coquille par chargement d'un
 * fichier {@code .fxml}, sans une seule ligne de Java pour créer les nœuds : tout est déclaré dans
 * {@code CoquilleAccueilView.fxml}. Ouvrez les deux côte à côte pour mesurer ce que le déclaratif
 * apporte.
 *
 * <p><b>Lien avec la SAE 2.01</b> : cette coquille reproduit (en plus simple) la maquette M-Sites
 * du brief VigieChiro : une barre de menus en haut, le titre de l'écran courant au centre, et une
 * barre de statut qui rappelle l'emplacement de la base locale. Les quatre rubriques du menu
 * Affichage (Mes sites, Importer une nuit, Vue tabulaire, Paramètres) correspondent à la navigation
 * principale attendue par les personas Marie, Karim et Samuel.
 *
 * <p>Le contrôleur ({@link CoquilleAccueilController}) ajoute le comportement : chaque clic sur un
 * item de menu change le titre affiché au centre et alimente une zone de statut en bas de fenêtre.
 */
public class CoquilleAccueil extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("CoquilleAccueilView.fxml"));
    primaryStage.setTitle("VigieChiro PR Companion - Mes sites de suivi");
    primaryStage.setScene(new Scene(racine, 720, 480));
    primaryStage.show();
  }
}
