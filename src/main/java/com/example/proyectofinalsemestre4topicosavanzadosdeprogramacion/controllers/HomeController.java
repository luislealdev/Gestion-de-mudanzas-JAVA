package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private ImageView homeImage, contactImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            homeImage.setImage(new Image(new FileInputStream("src/main/resources/images/home.jpg")));
            contactImage.setImage(new Image(new FileInputStream("src/main/resources/images/contacto.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
