/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Informacion.Datos;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estef
 */
public class Archivo {
    public void agregausuario(Datos datos){
        String cadena; 
        cadena = convJson(datos);
        grabar(cadena);
        
    }
    
    public List<Datos> leerDatos(){
        List<Datos> listdatos = new ArrayList<>();
        String cadena;
        try{
            FileReader archivo = new FileReader("datos.txt");
            BufferedReader br = new BufferedReader(archivo);
            while((cadena = br.readLine())!=null){
                listdatos.add(convDatos(cadena));
        }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return listdatos;
    }
    
    private void grabar(String cadena){
       try{
           FileWriter archivo = new FileWriter("datos.txt",true);
           BufferedWriter bw = new BufferedWriter(archivo);
           archivo.write(cadena + "\n");
           archivo.close();
           
       } catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    private String convJson(Datos datos){
        String cadena;
        Gson gson = new Gson();
        cadena = gson.toJson(datos);
        return cadena; 
        
    }
    
    private Datos convDatos(String cadena){
        Datos datos = new Datos();
        Gson gson = new Gson();
        
        datos = gson.fromJson(cadena, Datos.class);
        return datos; 
        
    }
}
