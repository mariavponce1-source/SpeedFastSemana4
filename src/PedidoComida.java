public class PedidoComida extends Pedido {
    private boolean requiereMochilaTermica;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, boolean requiereMochilaTermica) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    @Override
    public int calcularTiempoEntrega() {
        // 5 min base + 3 min por km
        return (int) (5 + (getDistanciaKm() * 3));
    }
}