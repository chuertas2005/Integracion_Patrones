
package integracionpatrones.mediator;

public class BarraDeHerramientasBuilder
        extends ComponenteEditor {

    private String tipoDocumento;

    public BarraDeHerramientasBuilder(
            DocumentEditorMediator mediator) {

        super(mediator);
    }

    public void seleccionarTipoDocumento(
            String tipoDocumento) {

        this.tipoDocumento = tipoDocumento;

        System.out.println(
                "[Toolbar] Tipo de documento: "
                        + tipoDocumento
        );

        mediator.configurarBuilder();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }
}