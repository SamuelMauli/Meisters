import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListaStringsFiltro {

    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("azul", "carro", "amor", "gato", "abelha", "computador");

        List<String> palavrasFiltradas = palavras.stream()
                .filter(palavra -> palavra.startsWith("a") && palavra.length() == 3)
                .collect(Collectors.toList());

        System.out.println("Palavras que começam com 'a' e possuem 3 letras: " + palavrasFiltradas);
    }
}
