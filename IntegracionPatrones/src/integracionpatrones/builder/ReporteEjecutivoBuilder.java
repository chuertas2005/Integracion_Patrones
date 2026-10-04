package integracionpatrones.builder;

import flyweight.FlyweightFactory;

public class ReporteEjecutivoBuilder extends BaseDocumentBuilder {

    public ReporteEjecutivoBuilder(FlyweightFactory factory) {
        super(factory);
    }

    @Override
    public ReporteEjecutivoBuilder addHeader(String text) {
        super.addHeader(text);
        return this;
    }

    @Override
    public ReporteEjecutivoBuilder addParagraph(String text) {
        super.addParagraph(text);
        return this;
    }

    @Override
    public ReporteEjecutivoBuilder addTable(String data) {
        super.addTable(data);
        return this;
    }

    @Override
    public ReporteEjecutivoBuilder addFooter(String text) {
        super.addFooter(text);
        return this;
    }
}
