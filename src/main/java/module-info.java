module com.mycompany.javatreegui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.javatreegui to javafx.fxml;
    exports com.mycompany.javatreegui;
}
