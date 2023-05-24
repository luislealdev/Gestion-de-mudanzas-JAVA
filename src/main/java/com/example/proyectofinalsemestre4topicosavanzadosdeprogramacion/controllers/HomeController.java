package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;

import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Database.Dao.tipoServicioDao;
import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Models.TipoServicio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private ImageView homeImage, contactImage;
    @FXML
    private VBox vbox_servicios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoServicioDao tipoServicioDao = new tipoServicioDao();

        List<TipoServicio> servicios = tipoServicioDao.findAll();
        for (TipoServicio s : servicios) {
            Label l = new Label("✔ "+s.getServicio());
            l.setStyle("-fx-font-size: 20px");
            vbox_servicios.getChildren().add(l);
        }
//hola guapo
        try {
            homeImage.setImage(new Image(new FileInputStream("src/main/resources/images/home.jpg")));
            contactImage.setImage(new Image(new FileInputStream("src/main/resources/images/contacto.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
