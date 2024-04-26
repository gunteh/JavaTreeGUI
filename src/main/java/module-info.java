module com.mycompany.javatreegui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.mycompany.javatreegui to javafx.fxml;
    exports com.mycompany.javatreegui;
}
