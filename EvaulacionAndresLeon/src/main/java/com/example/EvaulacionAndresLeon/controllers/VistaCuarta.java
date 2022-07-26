package com.example.EvaulacionAndresLeon.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaulacionAndresLeon.models.datos;
import com.example.EvaulacionAndresLeon.services.DatosService;

@RestController
@RequestMapping("/cuarto")
public class VistaCuarta {
    
    @Autowired
    DatosService datosServicess;

    //Consumir el servicio  https://jsonplaceholder.typicode.com/posts   y almacenar el resultado  en  una Base de Datos.

    @GetMapping("")
    public String consumoApirest(){

        

        String respuesta = "";
        int contador = 0;

        //variables de datos 
        String  DpostId = "", Did = "";
        String Dname = "", Demail = "", Dbody = "";

        try {
            
            //establecemos la url que itilizaremos para obtener los datos
            URL miUrl = new URL("https://jsonplaceholder.typicode.com/comments");
            
            //abrimos una conexion HTTP
            HttpURLConnection conexion = (HttpURLConnection) miUrl.openConnection();
            
            //le indicamos el método de solicitud que utilizaremos, 
            //en este caso GET
            conexion.setRequestMethod("GET");
            
            //indicamos que recibiremos datos en formato JSON
            conexion.setRequestProperty("Accept", "application/json");
            
            //leeemos la respuesta de la petición y la colocamos en un buffer
            InputStreamReader isr = new InputStreamReader(conexion.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            
            //iteramos el buffer leyendo una línea a la vez y la imprimimos
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                // reinicia el contador 
                if (contador == 8){
                    contador = 1;
                }
                
                //capturamos los datos 
                if (contador == 2){
                    DpostId = linea.replace("\"postId\":", "").replace(",", "").replace("\"", "");
                }
                if (contador == 3){
                    Did = linea.replace("\"id\":", "").replace(",", "").replace("\"", "");
                }
                if (contador == 4){
                    Dname = linea.replace("\"name\":", "").replace(",", "").replace("\"", "");
                }
                if (contador == 5){
                    Demail = linea.replace("\"email\":", "").replace(",", "").replace("\"", "");
                }
                if (contador == 6){
                    Dbody = linea.replace("\"body\":", "").replace(",", "").replace("\"", "");
                }
                // validados que la variable 
                //System.out.println(Dbody);

                //Almacenamos los datos 
                if (contador == 7){
                   datos datoAlmcenar = new datos();
                   datoAlmcenar.setBody(Dbody);
                   datoAlmcenar.setEmail(Demail);
                   datoAlmcenar.setName(Dname);
                   datoAlmcenar.setPostId(DpostId);

                   this.datosServicess.guardarDatos(datoAlmcenar);

                }

                respuesta = respuesta + contador + (linea) + "</p>";

                contador ++;
                
            }
            
            //por último liberamos la conexión
            conexion.disconnect();
         
          //en caso de que ocurra un excepción mostramos el mensaje de error  
        } catch (Exception ex) {
            System.out.println("Excepción: " + ex.getMessage());
        }

        return respuesta;

      }

}
