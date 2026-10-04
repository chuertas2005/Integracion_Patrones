package integracionpatrones.bridge;

public interface RenderEngine {
    void renderHeader(String header);
    void renderParagraph(String text);
    void renderFooter(String footer);
}