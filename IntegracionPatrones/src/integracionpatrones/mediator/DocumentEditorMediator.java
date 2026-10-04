
package integracionpatrones.mediator;

public interface DocumentEditorMediator {

    void cambiarFormato(String formato);

    void configurarBuilder();

    void actualizarVistaPrevia();

    void exportar();

    void registrarSelector(SelectorDeFormato selector);

    void registrarBarraHerramientas(
            BarraDeHerramientasBuilder barraHerramientas);

    void registrarVistaPrevia(VistaPrevia vistaPrevia);

    void registrarBotonExportar(BotonExportar botonExportar);
}