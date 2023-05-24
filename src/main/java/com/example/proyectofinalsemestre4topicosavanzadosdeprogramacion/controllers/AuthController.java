package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;

import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private ImageView lock;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            lock.setImage(new Image(new FileInputStream("src/main/resources/images/Lock.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Realizar autenticación desde base de datos
                if (txtUserName.getText().equals("luisleal") && txtPassword.getText().equals("12345")) {
                    //TODO: Cambiar pantalla cuando la autenticación es correcta
                }
            }
        });
    }

}