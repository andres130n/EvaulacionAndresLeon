package com.example.EvaulacionAndresLeon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primero")
public class VistaPrimera {
    

    // Se necesita escribir un programa Java que imprima en pantalla los números del 1 al 100, 
    // sustituyendo los  múltiplo de 3 por la palabra “SOMOS” y los múltiplo de 5 por “BA”.
    // Para los números múltiplos de 3 y 5 a la vez sustituir con la combinación de “SOMOS BA”

    @GetMapping()
    public String secuenciaNumero(){

        String respuesta = "";
        int controlMultiplo3 = 0, controlMultiplo5 = 0;

        for (int i = 1; i <= 100; i++){

            controlMultiplo3++;
            controlMultiplo5++;

            if ((controlMultiplo3 == 3) && (controlMultiplo5 == 5)){
                
                respuesta = respuesta  + "SOMOS BAN</p>";
                controlMultiplo3 = 0;
                controlMultiplo5 = 0;

            }else{
                if (controlMultiplo3 == 3){
                    respuesta = respuesta +  "SOMOS </p>";
                    controlMultiplo3 = 0;
                }else{
    
                    if (controlMultiplo5 == 5){
                        respuesta = respuesta +  "BAN </p>";
                        controlMultiplo5 = 0;
                    }else{
                        respuesta = respuesta + i + "</p>";
                    }    
    
                    
                }
            }

            

            
        }

        return respuesta;
    }

}
