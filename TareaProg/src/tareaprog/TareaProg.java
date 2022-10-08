package tareaprog;

import java.util.Date;

public class TareaProg {

    public static void main(String[] args) {
        
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
}

class Cliente{
    private String nombre;
    private String rut;
}

class Direccion{
    private String direccion;
}

class DetalleOrden{
    private int cantidad;
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
}

class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
}

class Boleta extends DocTributario{}

class Factura extends DocTributario{}

class Pago{
    private float monto;
    private Date fecha;
}

class Efectivo extends Pago{}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
}
