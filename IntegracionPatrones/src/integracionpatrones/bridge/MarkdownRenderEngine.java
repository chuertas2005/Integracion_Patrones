package integracionpatrones.bridge;

public class MarkdownRenderEngine implements RenderEngine {
    @Override
    public void renderHeader(String header) {
        System.out.println("# " + header);
    }

    @Override
    public void renderParagraph(String text) {
        System.out.println(text);
    }

    @Override
    public void renderFooter(String footer) {
        System.out.println("--- \n" + footer);
    }
}