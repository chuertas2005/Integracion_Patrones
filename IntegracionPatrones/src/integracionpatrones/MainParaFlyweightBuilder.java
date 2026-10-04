
package integracionpatrones;

import integracionpatrones.builder.*;
import integracionpatrones.flyweight.*;

public class MainParaFlyweightBuilder {

    public static void main(String[] args) {

        // Fábrica compartida para todos los documentos
        FlyweightFactory factory = new FlyweightFactory();

        // 1. Construcción del reporte

        ReporteEjecutivoBuilder reporteBuilder =
                new ReporteEjecutivoBuilder(factory);

        Document reporte = reporteBuilder
                .addHeader("Reporte financiero")
                .addParagraph("Empresa: Tecnologia Documental")
                .addParagraph("Precio base: 100000")
                .addTable("Producto | Precio | Cantidad")
                .addIcon("Grafico", "grafico.png")
                .addFooter("Fin del reporte")
                .build();

        // 2. Construcción de la factura

        FacturaSimpleBuilder facturaBuilder =
                new FacturaSimpleBuilder(factory);

        Document factura = facturaBuilder
                .addHeader("Factura de venta")
                .addParagraph("Empresa: Tecnologia Documental")
                .addParagraph("Total: 119000")
                .addIcon("Grafico", "grafico.png")
                .addFooter("Gracias por su compra")
                .build();

        // 3. Mostrar los documentos

        System.out.println("===== REPORTE =====");
        System.out.println(reporte.render());

        System.out.println("===== FACTURA =====");
        System.out.println(factura.render());

        // 4. Comprobar reutilización

        CharacterFlyweight a1 =
                factory.getCharacter('a', "Arial");

        CharacterFlyweight a2 =
                factory.getCharacter('a', "Arial");

        System.out.println("===== FLYWEIGHT =====");

        System.out.println("¿Se reutiliza la letra 'a'?: " + (a1 == a2));

        System.out.println("Caracteres compartidos: " +factory.getCharacterCount());

        System.out.println("Iconos compartidos: " + factory.getIconCount());

        System.out.println("Total de Flyweights: " + factory.getTotalFlyweights());
    }
}
