import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    public Automotora(){
        this.vehiculosAVenta= new ArrayList<Vehiculo>();
        this.vehiculosVendidos= new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<Vendedor>();
        this.clientes = new ArrayList<Cliente>();
        this.ventas = new ArrayList<Venta>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

    public void añadirVehiculosPorVender(){
        this.vehiculosAVenta.add(new Vehiculo("Celerio","Gris","Suzuki",
                2018,5000000,40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux","Rojo","Toyota",
                2020,12000000,1000));
        this.vehiculosAVenta.add(new Vehiculo("Qashqai","Blanco","Nissan",
                2018,10590000,20000.23));
        this.vehiculosAVenta.add(new Vehiculo("Cruze","Celeste","Chevrolet",
                2010,4500000,105000.144));
        this.vehiculosAVenta.add(new Vehiculo("Sail","Gris","Chevrolet",
                2020,6000000,0));
    }

    public void venderAuto(String nombre, int año){
        for(Vehiculo auto: this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre) && auto.getAño()==año){
               this.vehiculosVendidos.add(auto);
               this.vehiculosAVenta.remove(auto);
               break;
            }
        }
    }

    public List<Vehiculo> buscarAutoNombreForBasico(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<>();
        for(int i=0; i<this.vehiculosAVenta.size(); i++){
            if(this.vehiculosAVenta.get(i).getNombre().equals(nombre)){
                vehiculos.add(this.vehiculosAVenta.get(i));
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoNombre(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
        }

    public List<Vehiculo> buscarAutoMarca(String marca){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getMarca().equals(marca)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public void mostrarAutosLista(List<Vehiculo> vehiculos){
        for(Vehiculo auto : vehiculos){
            String datos="nombre: "+auto.getNombre()+", marca: "+auto.getMarca()+", año: "+auto.getAño()
                    +", color= "+auto.getColor()+", precio: "+auto.getPrecio()+", kmRecorridos: "+auto.getKmRecorridos();
            System.out.println(datos);
        }
    }

    public void probarSistema(){
        Automotora automotora= new Automotora();
        automotora.añadirVehiculosPorVender();
        automotora.mostrarAutosLista(automotora.buscarAutoNombre("Celerio"));
        automotora.venderAuto("Celerio",2018);
        automotora.mostrarAutosLista(automotora.getVehiculosVendidos());
    }


    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void añadirVendedores(){
        CalculoRut calculoRut = new CalculoRut();
        Vendedor vendedor = new Vendedor("German","20.919.321-3",20);
        if (CalculoRut.verificarRut(vendedor.getRut())){
            this.vendedores.add(vendedor);
        }else{
            System.out.println("Rut no válido");
        }
    }

    public List<Vendedor> buscarVendedorNombre(String nombre){
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public List<Vendedor> buscarVendedorRut(String rut){
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getRut().equals(rut)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void añadirClientes(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void eliminarClientes(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public List<Cliente> buscarClienteNombre(String nombre){
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getNombre().equals(nombre)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public List<Cliente> buscarClienteRut(String rut){
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getRut().equals(rut)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void añadirVenta(){
        Vendedor vendedor = (Vendedor) buscarVendedorNombre("German");
        Cliente cliente = (Cliente) buscarClienteNombre("Pedrito");
        Vehiculo vehiculo = (Vehiculo) buscarAutoNombre("Celerio");
        Venta venta = new Venta(vendedor, cliente, vehiculo);
        this.ventas.add(venta);
    }

}


