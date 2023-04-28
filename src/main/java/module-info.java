module com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion to javafx.fxml;
    opens com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;
    exports com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion;


}