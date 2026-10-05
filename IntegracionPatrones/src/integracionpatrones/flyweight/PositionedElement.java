package integracionpatrones.flyweight;

public class PositionedElement {

    private final DocumentElement element;
    private final int x;
    private final int y;
    private final int size;
    private final String color;

    public PositionedElement(
            DocumentElement element,
            int x,
            int y,
            int size,
            String color) {

        this.element = element;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public String render() {
        return element.render(x, y, size, color);
    }

    public DocumentElement getElement() {
        return element;
    }
}
