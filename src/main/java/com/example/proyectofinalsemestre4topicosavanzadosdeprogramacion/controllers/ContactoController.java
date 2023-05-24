package com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.controllers;

import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Database.Dao.empresaDao;
import com.example.proyectofinalsemestre4topicosavanzadosdeprogramacion.Models.EmpresaContacto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ContactoController implements Initializable {
    @FXML
    Label email, phone1, phone2, address;
    //facebook, instagram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        empresaDao empresaDao = new empresaDao();
        List<EmpresaContacto> empresas = empresaDao.findAll();
        email.setText(empresas.get(0).getCorreo());
        phone1.setText(empresas.get(0).getNum_ofi());
        phone2.setText(empresas.get(0).getNum_movil());
        address.setText(empresas.get(0).getDireccion());
        //address.setText(empresas.get(0).getFacebook());
    }
}
