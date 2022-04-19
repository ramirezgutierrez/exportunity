module com.migra {
    exports com.migra;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.migra to javafx.fxml;
    
}