
package integracionpatrones.mediator;

public class SelectorDeFormato
        extends ComponenteEditor {

    private String formatoSeleccionado;

    public SelectorDeFormato(
            DocumentEditorMediator mediator) {

        super(mediator);
    }

    public void seleccionarFormato(String formato) {

        this.formatoSeleccionado = formato;

        System.out.println(
                "[Selector] Formato seleccionado: "
                        + formato
        );

        mediator.cambiarFormato(formato);
    }

    public String getFormatoSeleccionado() {
        return formatoSeleccionado;
    }
}