public class PedidoExpress extends Pedido {
    private int prioridad; // 1 = Alta, 2 = Media

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm, int prioridad) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.prioridad = prioridad;
    }

    @Override
    public int calcularTiempoEntrega() {
        // Prioridad alta optimiza rutas directas
        return (int) (2 + (getDistanciaKm() * 1.5));
    }
}