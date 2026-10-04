
package integracionpatrones.interpreter;

public class Variable implements Expresion {

    private final String nombre;

    public Variable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double interpretar(Contexto contexto) {
        return contexto.obtener(nombre);
    }
}