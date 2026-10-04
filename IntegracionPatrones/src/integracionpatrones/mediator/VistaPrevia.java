
package integracionpatrones.mediator;

public class VistaPrevia
        extends ComponenteEditor {

    public VistaPrevia(
            DocumentEditorMediator mediator) {

        super(mediator);
    }

    public void actualizar() {

        System.out.println(
                "[VistaPrevia] Actualizando vista previa..."
        );
    }
}