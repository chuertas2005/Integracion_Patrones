package integracionpatrones.bridge;

public abstract class Document {
    protected RenderEngine renderEngine;
    protected String header;
    protected String content;
    protected String footer;

    public Document(RenderEngine renderEngine) {
        this.renderEngine = renderEngine;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public abstract void render();
}