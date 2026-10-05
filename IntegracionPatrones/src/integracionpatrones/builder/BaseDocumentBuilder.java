package integracionpatrones.builder;

import integracionpatrones.flyweight.Document;
import integracionpatrones.flyweight.DocumentBlock;
import integracionpatrones.flyweight.FlyweightFactory;
import integracionpatrones.flyweight.PositionedElement;

public abstract class BaseDocumentBuilder implements DocumentBuilder {

    protected Document document;
    protected final FlyweightFactory factory;
    protected int currentY = 0;

    protected BaseDocumentBuilder(FlyweightFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("FlyweightFactory no puede ser null");
        }
        this.factory = factory;
        this.document = new Document();
    }

    protected void addTextBlock(String type, String text, int size, String color) {
        if (text == null) {
            throw new IllegalArgumentException("El contenido no puede ser null");
        }
        DocumentBlock block = new DocumentBlock(type);
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            PositionedElement element = new PositionedElement(
                    factory.getCharacter(character, "Arial"),
                    i, currentY, size, color);
            block.addElement(element);
        }
        document.addBlock(block);
        currentY++;
    }

    @Override
    public DocumentBuilder addHeader(String text) {
        addTextBlock("HEADER", text, 20, "black");
        return this;
    }

    @Override
    public DocumentBuilder addParagraph(String text) {
        addTextBlock("PARAGRAPH", text, 12, "black");
        return this;
    }

    @Override
    public DocumentBuilder addTable(String data) {
        addTextBlock("TABLE", data, 12, "black");
        return this;
    }

    @Override
    public DocumentBuilder addFooter(String text) {
        addTextBlock("FOOTER", text, 10, "gray");
        return this;
    }

    @Override
    public DocumentBuilder addIcon(String name, String baseImage) {
        DocumentBlock block = new DocumentBlock("ICON");
        block.addElement(new PositionedElement(
                factory.getIcon(name, baseImage), 0, currentY, 24, "black"));
        document.addBlock(block);
        currentY++;
        return this;
    }

    @Override
    public Document build() {
        Document completedDocument = document;
        document = new Document();
        currentY = 0;
        return completedDocument;
    }
}
