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

    public Articulo(float peso, String nombre, String descripcion, float precio) {
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
    
    public void setPeso(float pe){
        peso = pe;
    }
    public void setNombre(String n){
        nombre = n;
    }
    public void setDescripcion(String d){
        descripcion = d;
    }
    public void setPrecio(float pre){
        precio = pre;
    }
    public String toString(){
        return "Nombre: "+nombre+" Precio: "+precio+" Peso: "+peso+" Descripcion: "+descripcion;
    }
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

    public Tarjeta(String tipo, String numTransaccion) {
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }
    
}
