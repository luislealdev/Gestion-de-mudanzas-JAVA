package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;
import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Database.Dao.tipoServicioDao;
import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Models.TipoServicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SolicitudController implements Initializable {
    @FXML
    private VBox select_services;
    @FXML
    private Button btn_solicitar_ahora;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoServicioDao tipoServicioDao = new tipoServicioDao();


        List<TipoServicio> servicios = tipoServicioDao.findAll();
        for (TipoServicio s : servicios) {
            CheckBox cb = new CheckBox(s.getServicio());
            cb.setStyle("-fx-padding: 5");
            select_services.getChildren().add(cb);
        }

        btn_solicitar_ahora.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
