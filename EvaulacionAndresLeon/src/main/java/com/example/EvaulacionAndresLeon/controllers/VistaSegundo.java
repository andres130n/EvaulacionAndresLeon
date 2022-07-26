package com.example.EvaulacionAndresLeon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/segundo")
public class VistaSegundo {
    
    // Escriba un método que decida si dos String son anagramas o no.
    // Ejemplo: ACUERDO – ECUADOR.
    
    @GetMapping()
    public String anagramas(){

        String respuesta = "";

        char comparacionA  , comparacionB ;
        String palabra1 = "ACUERDO", palabra2 = "ECUADOR"; 

        int ControlLetras = 0;

        if (palabra1.length() ==  palabra2.length()){

            //respuesta = respuesta + "Tiene el mismo numero de caracteres </p>";

            for (int y = 0; y <= palabra1.length() -1; y ++){

                comparacionA = palabra1.charAt(y);
                for (int w = 0; w <= palabra2.length() - 1; w++){

                    comparacionB = palabra2.charAt(w);

                    if (comparacionA == comparacionB){
                        ControlLetras++;
                    }
                }

            }

            if (ControlLetras == palabra1.length()){
                respuesta = respuesta + "es un anagrama";
            }else{
                respuesta = respuesta + "No es un anagrama";
            }

        }else {

            respuesta = respuesta + "No es un anagrama";
        }

        return respuesta;

    }

}
