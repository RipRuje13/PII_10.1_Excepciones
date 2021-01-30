
package excepcionescuentabancaria;


public class CuentaBancaria {
     private double balance;
    private int noCuenta;

    public CuentaBancaria(double balanceInicial, int noCuenta){
        this.balance=balanceInicial;
        this.noCuenta= noCuenta ;
        if(balanceInicial < 0)
            throw new IllegalArgumentException("El balance inicial no puede ser negativo");
        
        String x = Integer.toString(noCuenta);
        if( x.length() != 5 )
           throw new IllegalArgumentException("El numero de cuenta debe ser de 5 digitos");
        
    }
    
    public double getBalance() {
        return balance;
    }

    public int getNoCuenta() {
        return noCuenta;
    }
    
    public void depositar(double cantidad) {
        if (cantidad < 0)
          throw new IllegalArgumentException("¡Cantidad negativa, no es posible depositar! Proporcione un valor positivo.");
        balance = balance + cantidad;
    }

    public void retirar(double cantidad) throws FondosInsuficientesExcepcion {
        if(cantidad < 0)
            throw new IllegalArgumentException("¡Cantidad negativa, no es posible retirar! Proporcione un valor positivo.");
        if(cantidad > balance)
            throw new FondosInsuficientesExcepcion();
            balance = balance - cantidad;
            
    }
    
    @Override
    public String toString () {
        return "" + noCuenta + " $" + balance;
    }
    
}
