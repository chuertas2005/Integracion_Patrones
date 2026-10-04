package integracionpatrones.chain;

public class Sanitizador extends ProcessorHandler {
    @Override
    public String process(String content) {
        if (content == null) return null;
        
        // Limpia espacios duplicados o caracteres HTML no deseados
        String sanitized = content.replaceAll("<script.*?>.*?</script>", "")
                                  .trim();
        System.out.println("[Sanitizador] Contenido sanitizado.");
        return processNext(sanitized);
    }
}