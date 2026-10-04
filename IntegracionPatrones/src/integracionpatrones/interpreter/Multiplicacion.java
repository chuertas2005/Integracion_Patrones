
package integracionpatrones.interpreter;

public class Multiplicacion extends ExpresionNoTerminal {

    public Multiplicacion(
            Expresion izquierda,
            Expresion derecha) {

        super(izquierda, derecha);
    }

    @Override
    public double interpretar(Contexto contexto) {

        return izquierda.interpretar(contexto)
                * derecha.interpretar(contexto);
    }
}