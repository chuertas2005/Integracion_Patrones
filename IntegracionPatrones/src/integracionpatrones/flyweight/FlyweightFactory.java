package integracionpatrones.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.documentengine.model.CharacterFlyweight;
import com.documentengine.model.IconFlyweight;

public class FlyweightFactory {

    private final Map<String, CharacterFlyweight> characters =
            new HashMap<>();

    private final Map<String, IconFlyweight> icons =
            new HashMap<>();

    public CharacterFlyweight getCharacter(char character, String font) {

        String key = character + "|" + font;

        return characters.computeIfAbsent(
                key,
                k -> new CharacterFlyweight(character, font)
        );
    }

    public IconFlyweight getIcon(String name, String baseImage) {

        return icons.computeIfAbsent(
                name,
                k -> new IconFlyweight(name, baseImage)
        );
    }

    public int getCharacterCount() {
        return characters.size();
    }

    public int getIconCount() {
        return icons.size();
    }

    public int getTotalFlyweights() {
        return characters.size() + icons.size();
    }
}
