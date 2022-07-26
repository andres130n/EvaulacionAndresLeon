package com.example.EvaulacionAndresLeon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tercero")
public class VistaTercera {
    

    // Escriba un método que ordene de mayor a menor el siguiente arreglo utilizando un método de su elección:
    // int arreglo[]=[50,5,10,36,25,85,23,65];

    @GetMapping("")
    public int[] ordenamientoNumeros(){

        int areglo[] = new int[] {50,5,10,36,25,85,23,65};
        
        int elementoActual, elementoSiguiente;

        for (int w = 0; w < areglo.length; w++){
            for (int i = 0; i < areglo.length - 1 ; i++){

                elementoActual = areglo[i];
                elementoSiguiente = areglo[i+1];

                if (elementoActual < elementoSiguiente){

                    areglo[i] = elementoSiguiente;
                    areglo[i +1] = elementoActual;

                }

            }

        }
        return areglo;
    }
    
}
