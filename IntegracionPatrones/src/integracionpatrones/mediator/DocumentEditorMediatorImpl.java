
package integracionpatrones.mediator;

public class DocumentEditorMediatorImpl
        implements DocumentEditorMediator {

    private SelectorDeFormato selector;
    private BarraDeHerramientasBuilder barraHerramientas;
    private VistaPrevia vistaPrevia;
    private BotonExportar botonExportar;

    private String formatoActual;

    @Override
    public void registrarSelector(
            SelectorDeFormato selector) {

        this.selector = selector;
    }

    @Override
    public void registrarBarraHerramientas(
            BarraDeHerramientasBuilder barraHerramientas) {

        this.barraHerramientas = barraHerramientas;
    }

    @Override
    public void registrarVistaPrevia(
            VistaPrevia vistaPrevia) {

        this.vistaPrevia = vistaPrevia;
    }

    @Override
    public void registrarBotonExportar(
            BotonExportar botonExportar) {

        this.botonExportar = botonExportar;
    }

    @Override
    public void cambiarFormato(String formato) {

        this.formatoActual = formato;

        System.out.println(
                "[Mediator] Cambiando formato a: "
                        + formato
        );

        configurarBuilder();

        actualizarVistaPrevia();
    }

    @Override
    public void configurarBuilder() {

        System.out.println(
                "[Mediator] Reconfigurando Builder..."
        );

        if (barraHerramientas != null) {

            System.out.println(
                    "[Mediator] Tipo actual: "
                            + barraHerramientas
                            .getTipoDocumento()
            );
        }
    }

    @Override
    public void actualizarVistaPrevia() {

        if (vistaPrevia != null) {
            vistaPrevia.actualizar();
        }
    }

    @Override
    public void exportar() {

        if (formatoActual == null) {

            System.out.println(
                    "[Mediator] No se puede exportar: "
                            + "no hay formato seleccionado."
            );

            return;
        }

        System.out.println(
                "[Mediator] Exportando documento en "
                        + formatoActual
        );
    }
}