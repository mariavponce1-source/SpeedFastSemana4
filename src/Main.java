import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SPEEDFAST - SIMULADOR DE ENTREGAS CONCURRENTE   ");
        System.out.println("==================================================\n");

        // 1. Instanciar Repartidores
        Repartidor r1 = new Repartidor("Carlos (Moto 01)");
        Repartidor r2 = new Repartidor("Lucía (Bicicleta 02)");
        Repartidor r3 = new Repartidor("Marcos (Auto 03)");

        // 2. Asignar pedidos (mínimo 2 por repartidor)
        r1.asignarPedido(new PedidoComida("COM-101", "Av. Providencia 1200", 3.2, true));
        r1.asignarPedido(new PedidoExpress("EXP-201", "Calle Los Leones 450", 1.8, 1));

        r2.asignarPedido(new PedidoExpress("EXP-202", "Pedro de Valdivia 890", 2.1, 1));
        r2.asignarPedido(new PedidoComida("COM-102", "Manuel Montt 340", 1.5, false));

        r3.asignarPedido(new PedidoEncomienda("ENC-301", "Av. Las Condes 7800", 9.4, 4.5));
        r3.asignarPedido(new PedidoEncomienda("ENC-302", "Vitacura 4200", 6.0, 2.0));

        // 3. Pool de hilos con ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 4. Enviar tareas al ejecutor
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        // 5. Cierre ordenado y espera de finalización
        executor.shutdown();

        try {
            // Espera hasta 2 minutos a que terminen todos los repartidores
            boolean finalizado = executor.awaitTermination(2, TimeUnit.MINUTES);

            if (finalizado) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("Todas las entregas de SpeedFast concluyeron con éxito.");
                System.out.println("--------------------------------------------------");
            } else {
                System.out.println("\nSe alcanzó el tiempo límite de espera.");
            }
        } catch (InterruptedException e) {
            System.err.println("La simulación global fue interrumpida.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}