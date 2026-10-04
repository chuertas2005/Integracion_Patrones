package integracionpatrones.chain;

public class EvaluadorExpresiones extends ProcessorHandler {
    @Override
    public String process(String content) {
        if (content == null) return null;

        // Procesa marcadores dinámicos o expresiones (conectado funcionalmente con el paquete Interpreter)
        String evaluated = content.replace("#{PRECIO}", "100.00");
        System.out.println("[EvaluadorExpresiones] Expresiones dinámicas evaluadas.");
        return processNext(evaluated);
    }
}