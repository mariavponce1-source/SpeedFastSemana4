import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidosAsignados;
    private Random random;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidosAsignados = new ArrayList<>();
        this.random = new Random();
    }

    public void asignarPedido(Pedido pedido) {
        this.pedidosAsignados.add(pedido);
    }

    @Override
    public void run() {
        System.out.println(">>> [" + nombre + "] Inicia su turno con " + pedidosAsignados.size() + " pedidos.");

        for (Pedido pedido : pedidosAsignados) {
            System.out.println("[" + nombre + "] En camino a entregar: " + pedido.getIdPedido());

            try {
                // Simula el trayecto de entrega entre 1500ms y 4000ms
                int tiempoSimuladoMs = 1500 + random.nextInt(2500);
                Thread.sleep(tiempoSimuladoMs);

                System.out.println("✔ [" + nombre + "] ¡Entrega completada! Pedido: "
                        + pedido.getIdPedido() + " (Tardó: " + (tiempoSimuladoMs / 1000.0) + "s)");
            } catch (InterruptedException e) {
                System.err.println("[" + nombre + "] Entrega interrumpida para: " + pedido.getIdPedido());
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("=== [" + nombre + "] Ha completado todas sus entregas asignadas. ===");
    }

    public String getNombre() {
        return nombre;
    }
}