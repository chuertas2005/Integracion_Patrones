package integracionpatrones.flyweight;

public class IconFlyweight implements DocumentElement {

    private final String iconName;
    private final String baseImage;

    public IconFlyweight(String iconName, String baseImage) {
        this.iconName = iconName;
        this.baseImage = baseImage;
    }

    public String getIconName() {
        return iconName;
    }

    public String getBaseImage() {
        return baseImage;
    }

    @Override
    public String render(int x, int y, int size, String color) {
        return "[" + iconName + "]";
    }
}
