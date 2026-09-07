# SpeedFast - Sistema Concurrente de Entregas (Semana 4)

Este proyecto corresponde a la actividad formativa individual **"Ejecutando tareas en paralelo con hilos en Java"**. En esta etapa se extiende el modelo orientado a objetos de **SpeedFast** para simular entregas de pedidos de forma simultánea mediante programación concurrente con `Thread`, `Runnable` y `ExecutorService`.

---

## 📌 Descripción del Caso

SpeedFast requiere simular la operación en tiempo real de múltiples repartidores. Cada repartidor actúa como un hilo de ejecución independiente, despachando su lista de pedidos asignada de forma secuencial, mientras que el conjunto de repartidores opera en paralelo.

### Componentes Clave:
* **Polimorfismo e Interfaces:** Reutilización de la clase abstracta `Pedido` y sus subtipos (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`), implementando los contratos `Despachable`, `Cancelable` y `Rastreable`.
* **Concurrencia con `Runnable`:** La clase `Repartidor` implementa `Runnable`. En su método `run()`, itera sus pedidos asignados simulando traslados con pausas no bloqueantes para el resto de los hilos (`Thread.sleep()` con intervalos aleatorios).
* **Gestión con `ExecutorService`:** Se utiliza un pool de hilos (`Executors.newFixedThreadPool`) para coordinar la ejecución paralela y `awaitTermination` para asegurar que el programa principal espere hasta que concluyan todas las rutas.

---

## 📁 Estructura del Proyecto

```text
semana 4/
└── src/
    ├── Cancelable.java
    ├── Despachable.java
    ├── Rastreable.java
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    ├── PedidoExpress.java
    ├── Repartidor.java
    └── Main.java