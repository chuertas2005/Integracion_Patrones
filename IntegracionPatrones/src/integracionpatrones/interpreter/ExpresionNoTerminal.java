
package integracionpatrones.interpreter;

public abstract class ExpresionNoTerminal implements Expresion {

    protected final Expresion izquierda;
    protected final Expresion derecha;

    public ExpresionNoTerminal(
            Expresion izquierda,
            Expresion derecha) {

        this.izquierda = izquierda;
        this.derecha = derecha;
    }
}