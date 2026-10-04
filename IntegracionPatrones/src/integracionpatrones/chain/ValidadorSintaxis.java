package integracionpatrones.chain;

public class ValidadorSintaxis extends ProcessorHandler {
    @Override
    public String process(String content) {
        if (content == null || content.contains("<corrupto>")) {
            System.err.println("[ValidadorSintaxis] Error: Contenido sintácticamente inválido o corrupto.");
            return null; // Interrumpe la cadena
        }
        System.out.println("[ValidadorSintaxis] Sintaxis válida.");
        return processNext(content);
    }
}