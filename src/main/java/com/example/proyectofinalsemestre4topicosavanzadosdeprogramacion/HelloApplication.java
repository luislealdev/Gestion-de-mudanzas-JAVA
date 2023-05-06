package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private BorderPane borderPane;
    @Override
    public void start(Stage primaryStage) throws IOException {
        //CREATE THE NAVBAR
        //Create elements
        HBox navbar = new HBox();

        Text txt_app_name = new Text("MoveItNow");
        txt_app_name.getStyleClass().add("app-name");

        Button btn_inicio = new Button("Inicio");
        Button btn_solicitud = new Button("Solicitud");
        Button btn_contacto = new Button("Contacto");
        Button btn_admin = new Button("Admin");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinWidth(Region.USE_PREF_SIZE);

        HBox navbar_items = new HBox();
        navbar_items.getChildren().addAll(btn_inicio,btn_solicitud, btn_contacto, btn_admin);

        navbar.getChildren().addAll(txt_app_name,spacer,navbar_items);

        //CREATE SECTIONS
        //Add styles to elements
        navbar.getStyleClass().add("navbar");

        btn_inicio.getStyleClass().setAll("navbar-button");
        btn_solicitud.getStyleClass().setAll("navbar-button");
        btn_contacto.getStyleClass().setAll("navbar-button");
        btn_admin.getStyleClass().setAll("navbar-button");

        //Add icons to buttons
        FontIcon icon_products = new FontIcon();
        icon_products.setIconLiteral("fas-home");
        icon_products.setIconColor(Paint.valueOf("white"));
        btn_inicio.setGraphic(icon_products);

        FontIcon icon_employees = new FontIcon();
        icon_employees.setIconLiteral("far-newspaper");
        icon_employees.setIconColor(Paint.valueOf("white"));
        btn_solicitud.setGraphic(icon_employees);

        FontIcon icon_clients = new FontIcon();
        icon_clients.setIconLiteral("fas-phone");
        icon_clients.setIconColor(Paint.valueOf("white"));
        btn_contacto.setGraphic(icon_clients);

        FontIcon icon_offices = new FontIcon();
        icon_offices.setIconLiteral("fas-portrait");
        icon_offices.setIconColor(Paint.valueOf("white"));
        btn_admin.setGraphic(icon_offices);

        //Create footer
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.getStyleClass().add("footer");
        Label footer_text = new Label("Copyright 2023 Move It Now");
        footer_text.setTextFill(Paint.valueOf("white"));
        footer.getChildren().add(footer_text);

        borderPane = new BorderPane();
        borderPane.setTop(navbar);
        borderPane.setBottom(footer);

        borderPane.setCenter(home_section());

        //ADD ACTIONS TO BUTTONS
        btn_inicio.setOnAction(event -> {
            try {
                switchPanes(home_section());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btn_solicitud.setOnAction(event -> {
            try {
                switchPanes(solicitud_section());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btn_contacto.setOnAction(event -> {
            try {
                switchPanes(contacto_section());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btn_admin.setOnAction(event -> {
            try {
                switchPanes(admin_section());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Scene scene = new Scene(borderPane, 1500, 800);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/index.css")).toString());
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private Parent home_section() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        return fxmlLoader.load();
    }

    private Parent solicitud_section() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("solicitud-view.fxml"));
        return fxmlLoader.load();
    }

    private Parent contacto_section() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contacto-view.fxml"));
        return fxmlLoader.load();
    }

    private Parent admin_section() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        return fxmlLoader.load();
    }

    public void switchPanes(Parent newView) {
        borderPane.setCenter(newView);
    }

    public static void main(String[] args) {
        launch();
    }
}