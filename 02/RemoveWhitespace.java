import java.util.Scanner;

public class RemoveWhitespace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite um texto:");
        String input = scanner.nextLine();
        
        String result = removeWhitespace(input);
        
        System.out.println("texto original: " + input);
        System.out.println("texto sem espaços: " + result);
        
        scanner.close();
    }

    public static String removeWhitespace(String input) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
