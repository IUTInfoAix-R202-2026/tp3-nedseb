package fr.univ_amu.iut.exercice3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Exercice 3 : un formulaire de connexion en FXML, avec controleur et CSS.
 *
 * <p>Pont avec le TP2 exercice 6 : la même fenêtre de connexion (avec les mêmes règles de
 * validation par bindings) est ici décrite en FXML et stylée par une feuille CSS. Vous comparerez
 * les deux écritures :
 *
 * <ul>
 *   <li>côté TP2 : tout est construit en Java (création des nœuds, ajout au GridPane, écouteurs)
 *   <li>côté TP3 : la structure visuelle est dans le {@code .fxml}, le style dans le {@code .css},
 *       et seule la logique reste en Java (controleur)
 * </ul>
 *
 * <p>La feuille de style {@code FormulaireConnexion.css} est référencée depuis le FXML par
 * l'attribut {@code stylesheets="@FormulaireConnexion.css"} sur la racine.
 */
public class FormulaireConnexionFXML extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("FormulaireConnexionView.fxml"));
    primaryStage.setTitle("Connexion");
    primaryStage.setScene(new Scene(racine));
    primaryStage.show();
  }
}
