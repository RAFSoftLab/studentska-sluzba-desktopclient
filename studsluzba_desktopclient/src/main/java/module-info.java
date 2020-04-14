module org.raflab.studsluzba_desktopclient {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.raflab.studsluzba_desktopclient.controllers to javafx.fxml;
    opens org.raflab.studsluzba_desktopclient to javafx.fxml;
    exports org.raflab.studsluzba_desktopclient;
    
}