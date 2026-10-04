
package integracionpatrones.mediator;

public class BotonExportar
        extends ComponenteEditor {

    public BotonExportar(
            DocumentEditorMediator mediator) {

        super(mediator);
    }

    public void presionar() {

        System.out.println(
                "[BotonExportar] Botón presionado."
        );

        mediator.exportar();
    }
}