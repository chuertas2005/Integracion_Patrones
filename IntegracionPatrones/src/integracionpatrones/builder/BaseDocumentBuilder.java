package integracionpatrones.builder;

import flyweight.FlyweightFactory;
import flyweight.Document;
import flyweight.DocumentBlock;
import flyweight.PositionedElement;

public abstract class BaseDocumentBuilder implements DocumentBuilder {

    protected Document document;
    protected final FlyweightFactory factory;

    protected int currentY = 0;

    protected BaseDocumentBuilder(FlyweightFactory factory) {
        this.factory = factory;
        this.document = new Document();
    }

    protected void addTextBlock(String type, String text,
                                int size, String color) {

        DocumentBlock block = new DocumentBlock(type);

        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            PositionedElement element = new PositionedElement(
                    factory.getCharacter(character, "Arial"),
                    i,
                    currentY,
                    size,
                    color
            );

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
    public Document build() {
        Document completedDocument = document;

        document = new Document();
        currentY = 0;

        return completedDocument;
    }
}
