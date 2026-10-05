package integracionpatrones.flyweight;

public class CharacterFlyweight implements DocumentElement {

    private final char character;
    private final String font;

    public CharacterFlyweight(char character, String font) {
        this.character = character;
        this.font = font;
    }

    public char getCharacter() {
        return character;
    }

    public String getFont() {
        return font;
    }

    @Override
    public String render(int x, int y, int size, String color) {
        return String.valueOf(character);
    }
}
