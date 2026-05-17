/**
 * Module JavaFX pour le TP TP3.
 *
 * <p>Ce module exporte les paquetages nécessaires pour les exercices. Ajoutez les exports des
 * nouveaux paquetages d'exercices au fur et à mesure.
 */
open module tp3.javafx {
  // JavaFX dependencies
  requires transitive javafx.base;
  requires transitive javafx.controls;
  requires transitive javafx.graphics;
  requires transitive javafx.fxml;

  // Export base package
  exports fr.univ_amu.iut;

// ========== EXERCICES - Ajouter les exports ici ==========
// exports fr.univ_amu.iut.exercice1;
// exports fr.univ_amu.iut.exercice2;
// ...
}
