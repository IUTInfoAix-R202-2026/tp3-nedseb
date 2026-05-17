package fr.univ_amu.iut;

import fr.univ_amu.iut.bonus10.OthelloMain;
import fr.univ_amu.iut.bonus8.ThemeToggle;
import fr.univ_amu.iut.bonus9.CoquilleSceneBuilder;
import fr.univ_amu.iut.exercice1.PremiereVueFXML;
import fr.univ_amu.iut.exercice2.CompteurFXML;
import fr.univ_amu.iut.exercice3.FormulaireConnexionFXML;
import fr.univ_amu.iut.exercice4.CoquilleAccueil;
import fr.univ_amu.iut.exercice5.SiteCarteDemo;
import fr.univ_amu.iut.exercice6.VueAccueil;
import fr.univ_amu.iut.exercice7.Qualification;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Supplier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Lanceur du TP3. Affiche un menu avec un bouton par exercice ; cliquer lance l'exercice
 * correspondant dans une nouvelle fenêtre.
 *
 * <p>Point d'entrée par défaut de {@code ./mvnw javafx:run}.
 */
public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    Label titre = new Label("TP3 - FXML");
    titre.setId("titre-tp3");
    titre.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    VBox root = new VBox(10);
    root.setPadding(new Insets(20));
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(titre);
    root.getChildren().add(bouton("Exercice 1 - Première vue FXML", PremiereVueFXML::new));
    root.getChildren().add(bouton("Exercice 2 - Compteur FXML", CompteurFXML::new));
    root.getChildren()
        .add(bouton("Exercice 3 - Formulaire de connexion", FormulaireConnexionFXML::new));
    root.getChildren()
        .add(bouton("Exercice 4 - Coquille d'accueil (M-Sites)", CoquilleAccueil::new));
    root.getChildren()
        .add(bouton("Exercice 5 - SiteCarte (composant fx:root)", SiteCarteDemo::new));
    root.getChildren().add(bouton("Exercice 6 - VueAccueil (fx:include)", VueAccueil::new));
    root.getChildren()
        .add(bouton("Exercice 7 - Vérifier l'enregistrement (MVC)", Qualification::new));

    Label sousTitreBonus = new Label("Bonus");
    sousTitreBonus.setStyle("-fx-font-size: 13px; -fx-text-fill: #6a737d; -fx-padding: 10 0 0 0;");
    root.getChildren().add(sousTitreBonus);
    root.getChildren().add(bouton("Bonus 8 - Thème clair / sombre", ThemeToggle::new));
    root.getChildren()
        .add(bouton("Bonus 9 - Coquille SceneBuilder (formatif)", CoquilleSceneBuilder::new));
    root.getChildren().add(bouton("Bonus 10 - Othello (MVC ludique)", OthelloMain::new));

    primaryStage.setTitle("TP3 - FXML - Lanceur");
    primaryStage.setScene(new Scene(root, 480, 600));
    primaryStage.show();
  }

  private Button bouton(String libelle, Supplier<Application> fabrique) {
    Button btn = new Button(libelle);
    btn.setMaxWidth(Double.MAX_VALUE);
    btn.setOnAction(e -> lancerExercice(libelle, fabrique));
    return btn;
  }

  private void lancerExercice(String libelle, Supplier<Application> fabrique) {
    int fenetresAvant = Window.getWindows().size();
    try {
      fabrique.get().start(new Stage());
    } catch (Exception ex) {
      StringWriter sw = new StringWriter();
      ex.printStackTrace(new PrintWriter(sw));
      afficherAlerte(
          AlertType.ERROR,
          "Exception pendant le lancement de " + libelle,
          "L'exercice a levé une exception. Extrait :\n\n" + sw.toString().split("\n")[0],
          sw.toString());
      return;
    }
    int fenetresApres = Window.getWindows().size();
    if (fenetresApres == fenetresAvant) {
      afficherAlerte(
          AlertType.INFORMATION,
          libelle + " - rien à afficher",
          "La méthode start() de cet exercice ne produit aucune fenêtre.",
          "C'est normal si vous n'avez pas encore implémenté l'exercice.\n\n"
              + "Prochaines étapes :\n"
              + "  1. Ouvrir la classe de l'exercice dans src/main/java/...\n"
              + "  2. Remplacer le TODO par l'implémentation attendue\n"
              + "  3. Vérifier que le test passe avec ./mvnw test\n"
              + "  4. Relancer l'application : le bouton ouvrira maintenant une fenêtre");
    }
  }

  private void afficherAlerte(AlertType type, String titre, String entete, String contenu) {
    Alert alert = new Alert(type);
    alert.setTitle(titre);
    alert.setHeaderText(entete);
    alert.setContentText(contenu);
    alert.setResizable(true);
    alert.getDialogPane().setPrefWidth(520);
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
