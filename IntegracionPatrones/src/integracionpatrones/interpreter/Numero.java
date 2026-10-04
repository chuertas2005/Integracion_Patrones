
package integracionpatrones.interpreter;

public class Numero implements Expresion {

    private final double valor;

    public Numero(double valor) {
        this.valor = valor;
    }

    @Override
    public double interpretar(Contexto contexto) {
        return valor;
    }
}