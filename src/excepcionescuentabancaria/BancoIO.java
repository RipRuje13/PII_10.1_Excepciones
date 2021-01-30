/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionescuentabancaria;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BancoIO {
    Scanner input = null;
    PrintWriter out = null;
    
    
    public void escribirArchivo(String NombreArchivo, Banco banco){
        String Nom = NombreArchivo;
        Banco banc = banco;
        
        try{
            out = new PrintWriter(Nom);
            out.write(banc.toString());
        }catch(FileNotFoundException e){
            System.out.println("\nNo se pudo crear\n");
        }       
        finally{
            if(out != null)
                out.close();
        }
    }
    
    
    public  void LeerArchivo(String nombreArchivo, Banco banco){
        
        Banco b = banco;
        String nom = nombreArchivo;
        
        try{
            
            Scanner input = new Scanner(new FileReader(nom));
            int i=1;
            do{ 
                leerCuenta(input);
                b.agregarCuenta(leerCuenta(input));
                System.out.println(i++);
            }while(input.hasNextLine());
            System.out.println("\n Cuentas cargadas \n");
        }catch(FileNotFoundException e){
            System.out.println("\n Archivo no encontradon \n");
        } catch (IOException ex) {
            System.out.println("Problema con las lecturas");
        }
        finally{
            if(input != null)
                input.close();
        }  
    }
    
    
    
    public static CuentaBancaria leerCuenta(Scanner sc){
        Scanner scan = sc;
        double balance;
        int ncuenta,cont ;
        
        String prueba = scan.nextLine();
        String aux1, aux2;
        cont = prueba.length();
        
        aux1=prueba.substring(0,5);
        aux2=prueba.substring(7,cont);
        
        ncuenta = Integer.parseInt(aux1);
        balance = Double.parseDouble(aux2);
      CuentaBancaria cuentac  = new CuentaBancaria(balance,ncuenta);
        System.out.println(cuentac);
        return  cuentac;
    }
}
