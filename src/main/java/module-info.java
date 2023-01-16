module br.edu.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens br.edu.poo.gui to javafx.fxml;
    exports br.edu.poo.gui;
    exports br.edu.poo.back;
}
