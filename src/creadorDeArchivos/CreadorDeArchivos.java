/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadorDeArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Year;

/**
 *
 * @author happy
 */
public class CreadorDeArchivos {
    private String ruta = "/media/happy/PartitionTwo/Cosas/ParcialFinal/Parcial/src/creadorDeArchivos/salesForecast.txt";
    private String contenido = "";
    
    public CreadorDeArchivos(){
        
    }
    
    public void añadirTxt(String txt){
        try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bfW = new BufferedWriter(fw);
            bfW.write(txt);
            bfW.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    public void crearArchivo(){
        contenido = "-----------Sales Forecast-----------\n\n";
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                System.out.println("El archivo no existe, se creó uno");
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            System.out.println("Archivo modificado satisfactoriamente..");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
