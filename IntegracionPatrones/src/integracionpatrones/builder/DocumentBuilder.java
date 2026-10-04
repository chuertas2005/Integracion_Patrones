package integracionpatrones.builder;

import com.documentengine.model.Document;

public interface DocumentBuilder {

    DocumentBuilder addHeader(String text);

    DocumentBuilder addParagraph(String text);

    DocumentBuilder addTable(String data);

    DocumentBuilder addFooter(String text);

    Document build();
}
