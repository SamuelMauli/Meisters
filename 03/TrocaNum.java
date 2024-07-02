import java.util.Scanner;

public class TrocaNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número (a):");
        int a = scanner.nextInt();
        
        System.out.println("Digite o segundo número (b):");
        int b = scanner.nextInt();
        
        System.out.println("Antes da troca:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        a = a + b; 
        b = a - b; 
        a = a - b; 
        
        System.out.println("Depois da troca:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        scanner.close();
    }
}

