
package integracionpatrones.interpreter;

public class Resta extends ExpresionNoTerminal {

    public Resta(
            Expresion izquierda,
            Expresion derecha) {

        super(izquierda, derecha);
    }

    @Override
    public double interpretar(Contexto contexto) {

        return izquierda.interpretar(contexto)
                - derecha.interpretar(contexto);
    }
}