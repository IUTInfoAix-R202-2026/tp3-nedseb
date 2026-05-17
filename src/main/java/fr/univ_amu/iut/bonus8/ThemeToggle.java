package fr.univ_amu.iut.bonus8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Bonus 8 - bascule thème clair / sombre.
 *
 * <p>Démontre comment changer dynamiquement le thème d'une scène en remplaçant les feuilles CSS
 * actives via {@code Scene.getStylesheets()}. Aligné sur l'objectif qualité O2 (Facilité
 * d'apprentissage / accessibilité) du brief SAE 2.01 : les utilisatrices avec une déficience
 * visuelle légère peuvent préférer un thème à fort contraste.
 *
 * <p>Concepts mis en pratique :
 *
 * <ul>
 *   <li>{@code scene.getStylesheets().setAll(...)} pour échanger une feuille CSS à chaud
 *   <li>chaque thème vit dans son propre fichier CSS, chargé via une URL classpath
 *   <li>la bascule se déclenche par un {@link javafx.scene.control.ToggleButton} et n'a pas besoin
 *       de reconstruire la scène
 * </ul>
 */
public class ThemeToggle extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("ThemeToggleView.fxml"));
    Scene scene = new Scene(racine, 520, 320);
    scene.getStylesheets().add(getClass().getResource("theme-clair.css").toExternalForm());
    primaryStage.setTitle("Bonus 8 - Thème clair / sombre");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
