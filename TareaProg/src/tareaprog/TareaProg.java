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
    private Direccion direccion;

    public Cliente(String nombre, String rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "Rut: " + rut + ", Direccion: " + direccion;
    }
    
    
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

    public Pago(float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Pago{" + "monto:" + monto + ", fecha:" + fecha + '}';
    }
    
}

class Efectivo extends Pago{
    private float vuelto;

    public Efectivo(float monto, Date fecha) {
        super(monto, fecha);
        vuelto=0;
    }
    public void calcDevolucion(float pago){
        vuelto = super.getMonto() - pago;
    }

    @Override
    public String toString() {
        return super.toString()+"vuelto: " + vuelto;
    }
    
    
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;

    public Transferencia(String banco, String numCuenta, float monto, Date fecha) {
        super(monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return super.toString()+ "banco: " + banco + ", numCuenta: " + numCuenta;
    }
    
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;

    public Tarjeta(String tipo, String numTransaccion) {
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }
    
}
