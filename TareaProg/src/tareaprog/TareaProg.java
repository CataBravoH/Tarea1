package tareaprog;

import java.util.ArrayList;
import java.util.Date;

public class TareaProg {

    public static void main(String[] args) {
        Articulo art1 = new Articulo(1,"lente vogue","de piña",2000);
        Articulo art2 = new Articulo(2,"lente ralph","lente mk",7000);
        Articulo art3 = new Articulo(3,"lente rayban","lente armani",70000);
        Articulo art4 = new Articulo(4,"lente gucci","lente arnette",300);
        Articulo art5 = new Articulo(3,"lente polaroid","lente versage",5000);
        
        DetalleOrden det1 = new DetalleOrden(3, art1);
        DetalleOrden det2 = new DetalleOrden(5, art2);
        DetalleOrden det3 = new DetalleOrden(1, art3);
        DetalleOrden det4 = new DetalleOrden(4, art4);
        DetalleOrden det5 = new DetalleOrden(2, art5);
        
        Direccion adress1 = new Direccion(" direcion 23");
        Direccion adress2 = new Direccion(" direccion 333");
        
        Cliente cataa = new Cliente("Catalina", "jaja");
        Cliente caraaa = new Cliente("Catalin", "188");
        cataa.setDireccion(adress1);
        caraaa.setDireccion(adress2);
        
        
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    private DetalleOrden[] detalleorden;
    private Cliente cliente;
    private ArrayList<Pago> pago;
    
    public OrdenCompra(DocTributario doctributario, DetalleOrden[] detalleorden, Cliente cliente, ArrayList<Pago> pago){
        this.fecha = doctributario.getFecha();
        this.estado = "Por pagar";
        this.detalleorden = detalleorden;
        this.cliente = cliente;
        this.pago = pago;
    }
    public void verificarEstado(){
        float aux = 0; 
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecio();
        }
        Pago aux1;
        float monto = 0;
        for(int i = 0; i<pago.size();++i){
            aux1 = pago.get(i);
            monto = monto + aux1.getMonto();
        }
        if(aux <= monto){
            estado = "Cancelado";
        }else{
            estado = "Por pagar";
        }
    }
    public float calcPrecioSinIVA(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecioSinIVA();
        }
        return aux;
    }
    public float calcIVA(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcIVA();
        }
        return aux;
    }
    public float calcPrecio(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecio();
        }
        return aux;
    }
    public float calcPeso(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPeso();
        }
        return aux;
    }
    
    public DetalleOrden[] getDetalleOrden(){
        return detalleorden;
    }
    public ArrayList<Pago> getPago(){
        return pago;
    }
    public Date getFecha(){
        return fecha;
    }
    public String getEstado(){
        return estado;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    @Override
    public String toString(){
        return "Esta clase contiene:  *Fecha:"+fecha+"*Estado:"+estado+"  de la clase OrdenCompra";
    }
      
}

class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;

    public Cliente(String nombre, String rut ) {
        this.nombre = nombre;
        this.rut = rut;
        
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

    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Direccion: " + direccion;
    }
    
}

class DetalleOrden{
    private int cantidad;
    private Articulo art;
    private OrdenCompra OC;

    public DetalleOrden(int cantidad, Articulo art) {
        this.cantidad = cantidad;
        this.art = art;
        
    }
    public float calcPrecioSinIVA() {
        return cantidad * art.getPrecio();
    }
    public float calcIVA() {
        return (art.getPrecio() * 0.19f) * cantidad;
    }
    public float calcPrecio() {
        return this.calcIVA() + this.calcPrecioSinIVA();
    }
    public float calcPeso() {
        return cantidad * art.getPeso();
    }

    public int getCantidad() {
        return cantidad;
    }
    public Articulo getArticulo() {
        return art;
    }
    public OrdenCompra getOrden() {
        return OC;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setArticulo(Articulo articulo) {
        this.art = articulo;
    }
    public void setOrden(OrdenCompra orden) {
        this.OC = orden;
    }
    @Override
    public String toString() {
        return "Unidades: "+cantidad + " " +art.toString();
    }
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
    private Direccion direccion;
    private OrdenCompra OC;

    public DocTributario(String numero, String rut, Date fecha, Direccion direccion) {
        this.numero = numero;
        this.rut = rut;
        this.direccion = direccion;
        if (fecha == null)
            this.fecha= new Date();
        else
            this.fecha = fecha;
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public OrdenCompra getOC() {
        return OC;
    }

    public void setOC(OrdenCompra OC) {
        this.OC = OC;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", rut=" + rut + ", fecha=" + fecha + ", direccion=" + direccion;
    }
    
    
}

class Boleta extends DocTributario{

    public Boleta(String numero, String rut, Date fecha, Direccion direccion) {
        super(numero, rut, fecha, direccion);
    }
    @Override
    public String toString(){
        return "Boleta:"+super.toString();
    }
}

class Factura extends DocTributario{

    public Factura(String numero, String rut, Date fecha, Direccion direccion) {
        super(numero, rut, fecha, direccion);
    }
    @Override
    public String toString(){
        return "Factura: "+super.toString();
    }
}

class Pago{
    float monto;
    private Date fecha;
    OrdenCompra OC;

    public Pago(float monto, Date fecha, OrdenCompra OC) {
        this.monto = monto;
        this.OC = OC;
        if (fecha == null)
            this.fecha= new Date();
        else
            this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public OrdenCompra getOC() {
        return OC;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setOC(OrdenCompra OC) {
        this.OC = OC;
    }
    

    @Override
    public String toString() {
        return "Monto: " + monto + "Fecha: " + fecha;
    }
    
}

class Efectivo extends Pago{
    private float vuelto;

    public Efectivo(float vuelto, float monto, Date fecha, OrdenCompra OC) {
        super(monto, fecha, OC);
        this.vuelto = vuelto;
    }
    
    public float calcDevolucion(float pago){
        return (this.monto > pago) ? (this.monto - pago) : 0;
    }

    @Override
    public String toString() {
        return "Efectivo: "+ super.toString();
    }
    
    
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;

    public Transferencia(String banco, String numCuenta, float monto, Date fecha, OrdenCompra OC) {
        super(monto, fecha, OC);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    
    @Override
    public String toString() {
        return "Transferencia: " + super.toString()+ "banco: " + banco + ", numCuenta: " + numCuenta;
    }
    
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;

    public Tarjeta(String tipo, String numTransaccion, float monto, Date fecha, OrdenCompra OC) {
        super(monto, fecha, OC);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

    public String getNumTransaccion() {
        return numTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNumTransaccion(String numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tarjeta:" + super.toString() + "tipo tarjeta: " + tipo + "Numero de Transaccion: " + numTransaccion;
    }

    
    
}
