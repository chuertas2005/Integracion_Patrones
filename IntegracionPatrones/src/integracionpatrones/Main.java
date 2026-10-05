package integracionpatrones;

import integracionpatrones.bridge.DocumentContinuo;
import integracionpatrones.bridge.DocumentPaginado;
import integracionpatrones.bridge.HtmlRenderEngine;
import integracionpatrones.bridge.MarkdownRenderEngine;
import integracionpatrones.bridge.PdfRenderEngine;
import integracionpatrones.builder.ReporteEjecutivoBuilder;
import integracionpatrones.chain.EvaluadorExpresiones;
import integracionpatrones.chain.FiltroPalabrasProhibidas;
import integracionpatrones.chain.ProcessorHandler;
import integracionpatrones.chain.Sanitizador;
import integracionpatrones.chain.ValidadorSintaxis;
import integracionpatrones.flyweight.FlyweightFactory;
import integracionpatrones.interpreter.Contexto;
import integracionpatrones.interpreter.Expresion;
import integracionpatrones.interpreter.Multiplicacion;
import integracionpatrones.interpreter.Numero;
import integracionpatrones.interpreter.Resta;
import integracionpatrones.interpreter.Variable;
import integracionpatrones.mediator.BarraDeHerramientasBuilder;
import integracionpatrones.mediator.BotonExportar;
import integracionpatrones.mediator.DocumentEditorMediatorImpl;
import integracionpatrones.mediator.SelectorDeFormato;
import integracionpatrones.mediator.VistaPrevia;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== MOTOR DE DOCUMENTOS INTELIGENTES ===");

        DocumentEditorMediatorImpl mediator = new DocumentEditorMediatorImpl();
        SelectorDeFormato selector = new SelectorDeFormato(mediator);
        BarraDeHerramientasBuilder barra = new BarraDeHerramientasBuilder(mediator);
        VistaPrevia vistaPrevia = new VistaPrevia(mediator);
        BotonExportar botonExportar = new BotonExportar(mediator);

        mediator.registrarSelector(selector);
        mediator.registrarBarraHerramientas(barra);
        mediator.registrarVistaPrevia(vistaPrevia);
        mediator.registrarBotonExportar(botonExportar);

        barra.seleccionarTipoDocumento("Reporte ejecutivo");
        selector.seleccionarFormato("PDF");

        Contexto contexto = new Contexto();
        contexto.asignar("PRECIO_BASE", 100000);
        contexto.asignar("DESCUENTO", 5000);

        Expresion formula = new Resta(
                new Multiplicacion(
                        new Variable("PRECIO_BASE"),
                        new Numero(1.19)),
                new Variable("DESCUENTO"));
        double total = formula.interpretar(contexto);
        String totalFormateado = String.format(Locale.ROOT, "%,.2f", total);

        System.out.println("\n=== INTERPRETER ===");
        System.out.println("#{PRECIO_BASE * 1.19 - DESCUENTO} = $" + totalFormateado);

        FlyweightFactory flyweightFactory = new FlyweightFactory();
        integracionpatrones.flyweight.Document documento =
                new ReporteEjecutivoBuilder(flyweightFactory)
                        .addHeader("Reporte financiero")
                        .addParagraph("Empresa: Tecnologia Documental")
                        .addParagraph("Total (Interpreter): $" + totalFormateado)
                        .addParagraph("Precio de referencia: #{PRECIO}")
                        .addParagraph("Nota: CONFIDENCIAL")
                        .addTable("Concepto | Importe\nServicio | $" + totalFormateado)
                        .addIcon("Grafico", "grafico.png")
                        .addFooter("Fin del reporte")
                        .build();

        System.out.println("\n=== BUILDER Y FLYWEIGHT ===");
        System.out.println(documento.render());

        var caracterA1 = flyweightFactory.getCharacter('a', "Arial");
        var caracterA2 = flyweightFactory.getCharacter('a', "Arial");
        System.out.println("¿Se reutiliza el flyweight de 'a'?: " + (caracterA1 == caracterA2));
        System.out.println("Caracteres compartidos: " + flyweightFactory.getCharacterCount());
        System.out.println("Iconos compartidos: " + flyweightFactory.getIconCount());
        System.out.println("Total de flyweights: " + flyweightFactory.getTotalFlyweights());

        ProcessorHandler pipeline = new ValidadorSintaxis();
        pipeline.setNext(new FiltroPalabrasProhibidas())
                .setNext(new Sanitizador())
                .setNext(new EvaluadorExpresiones());

        System.out.println("\n=== CHAIN OF RESPONSIBILITY ===");
        String contenidoProcesado = pipeline.process(documento.render());
        if (contenidoProcesado == null) {
            throw new IllegalStateException("El procesamiento del documento fue interrumpido.");
        }

        renderizarEnFormato(selector, botonExportar, "PDF", contenidoProcesado);
        renderizarEnFormato(selector, botonExportar, "HTML", contenidoProcesado);
        renderizarEnFormato(selector, botonExportar, "Markdown", contenidoProcesado);
    }

    private static void renderizarEnFormato(
            SelectorDeFormato selector,
            BotonExportar botonExportar,
            String formato,
            String contenido) {
        System.out.println("\n=== MEDIATOR: EXPORTAR " + formato + " ===");
        selector.seleccionarFormato(formato);
        botonExportar.presionar();

        switch (formato) {
            case "PDF":
                DocumentPaginado pdf = new DocumentPaginado(new PdfRenderEngine());
                pdf.setHeader("Reporte financiero");
                pdf.setContent(contenido);
                pdf.setFooter("Página 1 de 1");
                pdf.render();
                break;
            case "HTML":
                DocumentContinuo html = new DocumentContinuo(new HtmlRenderEngine());
                html.setHeader("Reporte financiero");
                html.setContent(contenido);
                html.setFooter("Fin del reporte");
                html.render();
                break;
            case "Markdown":
                DocumentContinuo markdown =
                        new DocumentContinuo(new MarkdownRenderEngine());
                markdown.setHeader("Reporte financiero");
                markdown.setContent(contenido);
                markdown.setFooter("Fin del reporte");
                markdown.render();
                break;
            default:
                throw new IllegalArgumentException("Formato no soportado: " + formato);
        }
    }
}
