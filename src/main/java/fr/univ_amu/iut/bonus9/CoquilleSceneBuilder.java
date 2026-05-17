package fr.univ_amu.iut.bonus9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Bonus 9 - refaire la coquille de l'exercice 4 avec <b>SceneBuilder</b>.
 *
 * <p>Ce bonus n'apporte pas de nouveau concept JavaFX : son objectif est de prendre en main <a
 * href="https://gluonhq.com/products/scene-builder/">SceneBuilder</a>, l'éditeur graphique
 * incontournable de la communauté JavaFX, que vous utiliserez à coup sûr en SAE. Vous reprenez la
 * coquille du parcours M-Sites (BorderPane + MenuBar + zone centrale + pied de fenêtre), mais cette
 * fois en <b>glissant-déposant</b> les composants dans SceneBuilder plutôt qu'en tapant le XML à la
 * main.
 *
 * <p>Procédure rapide :
 *
 * <ol>
 *   <li>Installez SceneBuilder (Gluon).
 *   <li>Ouvrez {@code CoquilleSceneBuilderView.fxml} dans SceneBuilder (clic droit → ouvrir avec).
 *   <li>Construisez la coquille (BorderPane → top : MenuBar ; center : VBox ; bottom : HBox).
 *   <li>Reliez le contrôleur via le panneau Controller (à droite), {@code fx:controller =
 *       fr.univ_amu.iut.bonus9.CoquilleSceneBuilderController}.
 *   <li>Donnez des {@code fx:id} aux composants utiles depuis le panneau Code (à droite).
 *   <li>Relancez {@code ./mvnw javafx:run} et choisissez « Bonus 9 » dans le Lanceur.
 * </ol>
 *
 * <p>Aucun test automatique n'est associé à ce bonus : il est <b>formatif</b>. Le rendu en cours
 * (au TP ou en SAE) est constaté en ouvrant l'application.
 */
public class CoquilleSceneBuilder extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("CoquilleSceneBuilderView.fxml"));
    primaryStage.setTitle("Bonus 9 - Coquille construite avec SceneBuilder");
    primaryStage.setScene(new Scene(racine, 720, 480));
    primaryStage.show();
  }
}
