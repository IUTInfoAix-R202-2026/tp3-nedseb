package fr.univ_amu.iut.exercice2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Exercice 2 : un compteur avec FXML + contrôleur.
 *
 * <p>Différence vs exercice 1 :
 *
 * <ul>
 *   <li>Le FXML déclare un {@code fx:controller} pointant sur {@link CompteurController}
 *   <li>Les boutons déclenchent des méthodes du contrôleur via {@code onAction="#..."}
 *   <li>La valeur affichée est liée au modèle par un binding
 * </ul>
 */
public class CompteurFXML extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("CompteurView.fxml"));
    primaryStage.setTitle("Compteur FXML");
    primaryStage.setScene(new Scene(racine));
    primaryStage.show();
  }
}
