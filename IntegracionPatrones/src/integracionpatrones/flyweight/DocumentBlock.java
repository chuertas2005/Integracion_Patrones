package integracionatrones.flyweight;

import java.util.ArrayList;
import java.util.List;

public class DocumentBlock {

    private final String type;
    private final List<PositionedElement> elements;

    public DocumentBlock(String type) {
        this.type = type;
        this.elements = new ArrayList<>();
    }

    public void addElement(PositionedElement element) {
        elements.add(element);
    }

    public String getType() {
        return type;
    }

    public List<PositionedElement> getElements() {
        return elements;
    }

    public String render() {
        StringBuilder result = new StringBuilder();

        for (PositionedElement element : elements) {
            result.append(element.render());
        }

        return result.toString();
    }
}
