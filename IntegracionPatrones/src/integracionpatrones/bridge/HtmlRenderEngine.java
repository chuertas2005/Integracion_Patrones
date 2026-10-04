package integracionpatrones.bridge;

public class HtmlRenderEngine implements RenderEngine {
    @Override
    public void renderHeader(String header) {
        System.out.println("<h1>" + header + "</h1>");
    }

    @Override
    public void renderParagraph(String text) {
        System.out.println("<p>" + text + "</p>");
    }

    @Override
    public void renderFooter(String footer) {
        System.out.println("<footer>" + footer + "</footer>");
    }
}