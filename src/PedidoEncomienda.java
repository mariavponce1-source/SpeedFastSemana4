public class PedidoEncomienda extends Pedido {
    private double pesoKg;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, double pesoKg) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
    }

    @Override
    public int calcularTiempoEntrega() {
        // Encomienda más pesada añade tiempo de manejo
        return (int) (15 + (getDistanciaKm() * 2) + (pesoKg * 0.5));
    }
}