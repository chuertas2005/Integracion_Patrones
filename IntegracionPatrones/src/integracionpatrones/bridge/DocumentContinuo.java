package integracionpatrones.bridge;

public class DocumentContinuo extends Document {

    public DocumentContinuo(RenderEngine renderEngine) {
        super(renderEngine);
    }

    @Override
    public void render() {
        System.out.println("=== RENDERIZANDO DOCUMENTO CONTINUO ===");
        if (header != null) {
            renderEngine.renderHeader(header);
        }
        renderEngine.renderParagraph(content != null ? content : "");
        if (footer != null) {
            renderEngine.renderFooter(footer);
        }
    }
}