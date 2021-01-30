
package excepcionescuentabancaria;

import java.io.IOException;


public class FondosInsuficientesExcepcion extends IOException {

  
    public FondosInsuficientesExcepcion() {
        super("¡No es posible retirar, fondos insuficientes!");
    }

    
    public FondosInsuficientesExcepcion(String msg) {
        super(msg);
    }
}
