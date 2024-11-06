import java.util.LinkedList;

class ColaBanco {
    private LinkedList<String> clientes;

    public ColaBanco() {
        clientes = new LinkedList<>();
    }

    public void agregarCliente(String nombre) {
        clientes.add(nombre);
        System.out.println("Se agregó el cliente " + nombre + " a la cola.");
    }

    public String atenderCliente() {
        if (!clientes.isEmpty()) {
            String clienteAtendido = clientes.removeFirst();
            System.out.println(clienteAtendido + " ha sido atendido.");
            return clienteAtendido;
        } else {
            System.out.println("La cola está vacía. No hay clientes para atender.");
            return null;
        }
    }

    public String obtenerClientesEnCola() {
        if (!clientes.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Clientes en la cola:\n");
            for (String cliente : clientes) {
                resultado.append(cliente).append("\n");
            }
            return resultado.toString();
        } else {
            return "La cola está vacía.";
        }
    }
}