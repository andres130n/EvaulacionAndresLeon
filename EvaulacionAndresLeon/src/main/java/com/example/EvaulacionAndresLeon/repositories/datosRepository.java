package com.example.EvaulacionAndresLeon.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.EvaulacionAndresLeon.models.datos;

@Repository
public interface datosRepository extends CrudRepository<datos, Long> {
    
    public abstract ArrayList<datos> findByPostId(String postId);


}
