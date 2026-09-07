public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public abstract int calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.printf("[%s] Destino: %s | Distancia: %.1f km | Tiempo estimado: %d min%n",
                idPedido, direccionEntrega, distanciaKm, calcularTiempoEntrega());
    }

    @Override
    public void despachar() {
        System.out.println("El pedido " + idPedido + " ha salido a despacho.");
    }

    @Override
    public void cancelar() {
        System.out.println("El pedido " + idPedido + " ha sido cancelado.");
    }

    @Override
    public String rastrear() {
        return "Rastreando " + idPedido + " rumbo a " + direccionEntrega;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }
}