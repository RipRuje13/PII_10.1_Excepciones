package excepcionescuentabancaria;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ExcepcionesCuentaBancaria {
    
    static Scanner sc = new Scanner(System.in);
    private static double cantidad;
    private static int noCuenta;
    
    private static int obtenerOpcionUsuario(){
        int opcion;  
        do {
            opcion = 0;
            System.out.println("Opciones Menú:");      
            System.out.println("1) Crear nueva cuenta");
            System.out.println("2) Depositar cuenta actual");
            System.out.println("3) Retirar cuenta actual");
            System.out.println("4) Buscar cuenta");
            System.out.println("5) Imprimir todas las cuentas");
            System.out.println("6) Salir");
            System.out.print("Digita tu opción(1 - 6): ");
            try{
                opcion = sc.nextInt();
                }catch(InputMismatchException e){
                 System.out.println("Lo que usted ingreso no es un numero");
                }
            if (opcion < 1 || opcion > 6)
                System.out.println("Opción inválida");
        }while (opcion > 1 && opcion < 6);
        return opcion;
    } 
    
    private static double obtenerCantidad() {       
         try{
            System.out.print("Digita la cantidad de la cuenta: $");
            cantidad = sc.nextDouble();
            }catch(InputMismatchException e){
             System.out.print("ERROR... Digita correctamente la cantidad de la cuenta");
             cantidad = sc.nextDouble();
            }
             
         return cantidad;
        
        
    }
   
    private static int obtenerNoCuenta() {
        System.out.print("Digita el numero de cuenta: ");
        try{ 
           noCuenta = sc.nextInt();
           String x = Integer.toString(noCuenta);
            if( x.length() != 5 ) 
             System.out.print(" La cuenta debe ser de 5 dijitos ");      
        }catch(InputMismatchException e){
            System.out.print("Digita correctamente el numero de cuenta, deben ser digitos");
            noCuenta = sc.nextInt();
           String x = Integer.toString(noCuenta);
            }
            
                   
        return noCuenta;
        
    }

    public static void main(String[] args) {
        Banco banco = new Banco(10);
        CuentaBancaria cuenta = null;
        double cantidad;
        int noCuenta, opcion;
        
        do {
            opcion = obtenerOpcionUsuario();
            
            switch (opcion) {
            case 1:   
                try{
                cantidad = obtenerCantidad();
                noCuenta = obtenerNoCuenta();
                cuenta = new CuentaBancaria(cantidad, noCuenta);
                banco.agregarCuenta(cuenta);
                System.out.println("Información cuenta: " + cuenta + "\n");
                }catch(IllegalArgumentException e){
                    
                }
                
                break;
            case 2:
                cantidad = obtenerCantidad();
                try{
                cuenta.depositar(cantidad);
                System.out.println("Información de la cuenta: " + cuenta + "\n");
                }catch(NullPointerException e){
                      System.out.println("ERROR: No existe la cuenta. Busque o cree una cuenta previamente.");
                    
                    }
                       
                break;
            case 3:
                cantidad = obtenerCantidad();
                try{
                cuenta.retirar(cantidad);
                System.out.println("Información de la cuenta: " + cuenta + "\n");
                }catch(FondosInsuficientesExcepcion e){
                    e.getMessage();
                    
                }
                break;                
            case 4:
                noCuenta = obtenerNoCuenta();
                CuentaBancaria b = banco.buscarCuenta(noCuenta);
                if (b != null) {
                    cuenta = b;
                    System.out.println("Información cuenta: " + cuenta + "\n");
                } 
                else {
                    System.out.println("\n*****ERROR*****: Cuenta bancaria " + noCuenta + " no encontrada!\n");
                }
                break;
                
            case 5:
                System.out.print("\n\nLas cuentas: \n" + banco + "\n\n");
                break;
            }
         } while (opcion != 0);
        System.out.println("\n\nHasta luego!");
    }
}
  