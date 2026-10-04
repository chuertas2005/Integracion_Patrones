package integracionpatrones.chain;

public abstract class ProcessorHandler {
    protected ProcessorHandler nextHandler;

    public ProcessorHandler setNext(ProcessorHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract String process(String content);

    protected String processNext(String content) {
        if (nextHandler != null) {
            return nextHandler.process(content);
        }
        return content;
    }
}