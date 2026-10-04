package integracionpatrones.bridge;

public class PdfRenderEngine implements RenderEngine {
    @Override
    public void renderHeader(String header) {
        System.out.println("[PDF Header] " + header);
    }

    @Override
    public void renderParagraph(String text) {
        System.out.println("[PDF Body] " + text);
    }

    @Override
    public void renderFooter(String footer) {
        System.out.println("[PDF Footer] " + footer);
    }
}