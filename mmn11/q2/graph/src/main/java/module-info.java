module com.openu.mmn11.q2.graph {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.openu.mmn11.q2.graph to javafx.fxml;
    exports com.openu.mmn11.q2.graph;
}