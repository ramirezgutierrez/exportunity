module com.migra {
    exports com.migra;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens com.migra;
    opens images;
    
}