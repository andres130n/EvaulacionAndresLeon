package com.example.EvaulacionAndresLeon.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaulacionAndresLeon.models.datos;
import com.example.EvaulacionAndresLeon.repositories.datosRepository;

@Service
public class DatosService {
    
    @Autowired
    datosRepository DatosRepository;

    public ArrayList<datos> ObternerDatos(){
        return (ArrayList<datos>) DatosRepository.findAll(); 
    }

    public datos guardarDatos(datos dat){
        return DatosRepository.save(dat);
    }

    public ArrayList<datos> obtenerPorpostId(String postId){
        return DatosRepository.findByPostId(postId);
    }
}
