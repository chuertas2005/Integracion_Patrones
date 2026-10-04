
package integracionpatrones.interpreter;

public class Suma extends ExpresionNoTerminal {

    public Suma(
            Expresion izquierda,
            Expresion derecha) {

        super(izquierda, derecha);
    }

    @Override
    public double interpretar(Contexto contexto) {

        return izquierda.interpretar(contexto)
                + derecha.interpretar(contexto);
    }
}