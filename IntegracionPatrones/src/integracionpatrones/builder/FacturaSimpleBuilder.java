package integracionpatrones.builder;

import integracionpatrones.flyweight.FlyweightFactory;

public class FacturaSimpleBuilder extends BaseDocumentBuilder {

    public FacturaSimpleBuilder(FlyweightFactory factory) {
        super(factory);
    }

    @Override
    public FacturaSimpleBuilder addHeader(String text) {
        super.addHeader(text);
        return this;
    }

    @Override
    public FacturaSimpleBuilder addParagraph(String text) {
        super.addParagraph(text);
        return this;
    }

    @Override
    public FacturaSimpleBuilder addTable(String data) {
        super.addTable(data);
        return this;
    }

    @Override
    public FacturaSimpleBuilder addFooter(String text) {
        super.addFooter(text);
        return this;
    }
    @Override
    public FacturaSimpleBuilder addIcon(String name, String baseImage) {
        super.addIcon(name, baseImage);
        return this;
}
}
