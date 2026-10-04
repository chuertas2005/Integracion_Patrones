package integracionpatrones.chain;

public class FiltroPalabrasProhibidas extends ProcessorHandler {
    private final String[] palabrasProhibidas = {"CONFIDENCIAL", "SECRETO", "PROHIBIDO"};

    @Override
    public String process(String content) {
        if (content == null) return null;

        String result = content;
        for (String palabra : palabrasProhibidas) {
            result = result.replaceAll("(?i)" + palabra, "****");
        }
        System.out.println("[FiltroPalabrasProhibidas] Palabras sensibles censuradas.");
        return processNext(result);
    }
}