package integracionpatrones.builder;

import flyweight.Document;

public interface DocumentBuilder {

    DocumentBuilder addHeader(String text);

    DocumentBuilder addParagraph(String text);

    DocumentBuilder addTable(String data);

    DocumentBuilder addFooter(String text);

    Document build();
}
