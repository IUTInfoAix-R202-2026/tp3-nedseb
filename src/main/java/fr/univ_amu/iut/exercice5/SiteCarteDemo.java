package fr.univ_amu.iut.exercice5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Démonstration du composant {@link SiteCarte} - équivalent du wireframe principal de la maquette
 * M-Sites du brief SAE 2.01.
 *
 * <p>Trois cartes sont instanciées :
 *
 * <ul>
 *   <li>Carré 640380 (Étang de la Tuilière) - 3 points, 7 passages, badge frais (2 jours)
 *   <li>Carré 752204 (ZAC Nord) - 2 points, 3 passages, badge orange (8 jours)
 *   <li>Carré 013570 (Carré de test) - 1 point, 0 passage, badge gris (jamais utilisé)
 * </ul>
 *
 * <p>Aucune logique métier ici : on prouve simplement que le composant s'utilise comme n'importe
 * quel Node, qu'on peut alimenter ses propriétés en Java pur, et que le badge change de couleur
 * tout seul via la classe CSS sélectionnée dans le contrôleur.
 */
public class SiteCarteDemo extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    SiteCarte carte1 = new SiteCarte();
    carte1.setNumeroCarre("Carré 640380");
    carte1.setNomConvivial("📍 Étang de la Tuilière (Aix-en-Provence)");
    carte1.setNombrePoints(3);
    carte1.setNombrePassages(7);
    carte1.setJoursDepuisDernierPassage(2);

    SiteCarte carte2 = new SiteCarte();
    carte2.setNumeroCarre("Carré 752204");
    carte2.setNomConvivial("📍 ZAC Nord (Marseille)");
    carte2.setNombrePoints(2);
    carte2.setNombrePassages(3);
    carte2.setJoursDepuisDernierPassage(8);

    SiteCarte carte3 = new SiteCarte();
    carte3.setNumeroCarre("Carré 013570");
    carte3.setNomConvivial("📍 Carré de test (sans coordonnées GPS)");
    carte3.setNombrePoints(1);
    carte3.setNombrePassages(0);
    carte3.setJoursDepuisDernierPassage(-1);

    Label titre = new Label("Mes sites de suivi");
    titre.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

    VBox root = new VBox(12, titre, carte1, carte2, carte3);
    root.setPadding(new Insets(20));
    root.setStyle("-fx-background-color: #fafbfc;");

    primaryStage.setTitle("VigieChiro - Démo SiteCarte (maquette M-Sites)");
    primaryStage.setScene(new Scene(root, 760, 480));
    primaryStage.show();
  }
}
