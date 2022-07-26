package com.example.EvaulacionAndresLeon.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaulacionAndresLeon.models.datos;
import com.example.EvaulacionAndresLeon.services.DatosService;

@RestController
@RequestMapping("/quinto")
public class VistaQuinto {
    
    @Autowired
    DatosService datosservice;

    //Con la información almacenada en la Base de Datos del punto 4, 
    //realizar un servicio en donde se consulte todos los title de un userId enviado.

    @GetMapping("/{userId}")
    public ArrayList<datos> obtenertitle(@PathVariable("userId") String  userId){
        return this.datosservice.obtenerPorpostId(userId);
    }




}
