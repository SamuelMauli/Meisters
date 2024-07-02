import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ListaStringsFiltro {

    public static void main(String[] args) {
        try {
            List<String> palavras = Files.readAllLines(Paths.get("C:/Meisters/01/palavras.txt"));
            //talvez seja necessário mudar o caminho para executar devidamente. 

            List<String> palavrasFiltradas = palavras.stream()
                    .filter(palavra -> palavra.startsWith("a") && palavra.length() == 3)
                    .sorted() // Coloca em ordem alfabética
                    .collect(Collectors.toList());

            int numeroPalavras = palavrasFiltradas.size();

            System.out.println("Existem " + numeroPalavras + " palavras que começam com 'a' e possuem 3 letras, em ordem alfabética: " + palavrasFiltradas);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
