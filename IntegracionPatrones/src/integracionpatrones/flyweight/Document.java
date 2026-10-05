package integracionpatrones.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<DocumentBlock> blocks;

    public Document() {
        this.blocks = new ArrayList<>();
    }

    public void addBlock(DocumentBlock block) {
        blocks.add(block);
    }

    public List<DocumentBlock> getBlocks() {
        return blocks;
    }

    public String render() {
        StringBuilder result = new StringBuilder();

        for (DocumentBlock block : blocks) {
            result.append("[")
                  .append(block.getType())
                  .append("]\n");

            result.append(block.render())
                  .append("\n\n");
        }

        return result.toString();
    }
}
