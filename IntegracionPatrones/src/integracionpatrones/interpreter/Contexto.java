
package integracionpatrones.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Contexto {

    private final Map<String, Double> variables;

    public Contexto() {
        variables = new HashMap<>();
    }

    public void asignar(String nombre, double valor) {
        variables.put(nombre, valor);
    }

    public double obtener(String nombre) {
        if (!variables.containsKey(nombre)) {
            throw new IllegalArgumentException(
                "La variable '" + nombre + "' no existe en el contexto."
            );
        }

        return variables.get(nombre);
    }

    public boolean contiene(String nombre) {
        return variables.containsKey(nombre);
    }
}