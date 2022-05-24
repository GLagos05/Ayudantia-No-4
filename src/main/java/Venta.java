
public class Venta {
    private Vendedor vendedor;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Venta(Vendedor vendedor, Cliente cliente, Vehiculo vehiculo) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public Venta() {
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
