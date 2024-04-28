module com.springdemo.oop_projekat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.springdemo.oop_projekat to javafx.fxml;
    opens com.springdemo.Controllers to javafx.fxml;
    exports com.springdemo.oop_projekat;
    exports com.springdemo.Controllers;

}