package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Exercice 6 : application composée à partir de deux sous-vues FXML, chacune avec son contrôleur.
 *
 * <p>Cette application reproduit la maquette M-Sites du brief SAE 2.01, mais cette fois la coquille
 * est <b>assemblée</b> à partir de deux vues séparées : un <b>en-tête</b> (titre, compteur, bouton
 * « + Nouveau site ») et une <b>liste</b> de cartes. Le mécanisme central est {@code fx:include} +
 * l'injection des sous-contrôleurs via le motif {@code <fxId>Controller}.
 *
 * <p>Concepts mis en pratique :
 *
 * <ul>
 *   <li>{@code <fx:include source="..." fx:id="..."/>} pour incorporer une vue dans une autre
 *   <li>injection automatique du sous-contrôleur sous le nom {@code <fxId>Controller}
 *   <li>communication entre deux contrôleurs <b>via le contrôleur parent</b> (et non pas en se
 *       référençant directement) - chacun reste indépendant et testable isolément
 *   <li>réutilisation du composant {@link fr.univ_amu.iut.exercice5.SiteCarte} de l'exercice 5
 * </ul>
 */
public class VueAccueil extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent racine = FXMLLoader.load(getClass().getResource("VueAccueilView.fxml"));
    primaryStage.setTitle("VigieChiro - Mes sites de suivi");
    primaryStage.setScene(new Scene(racine, 820, 480));
    primaryStage.show();
  }
}
