package integracionpatrones.bridge;

public class DocumentPaginado extends Document {

    public DocumentPaginado(RenderEngine renderEngine) {
        super(renderEngine);
    }

    @Override
    public void render() {
        System.out.println("=== RENDERIZANDO DOCUMENTO PAGINADO ===");
        renderEngine.renderHeader(header != null ? header : "Encabezado de Página");
        renderEngine.renderParagraph(content != null ? content : "");
        renderEngine.renderFooter(footer != null ? footer : "Página 1 de 1");
    }
}