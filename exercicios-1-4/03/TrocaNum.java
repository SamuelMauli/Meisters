import java.util.Scanner;

public class TrocaNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número:");
        int a = scanner.nextInt();
        
        System.out.println("Digite o segundo número:");
        int b = scanner.nextInt();
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Antes da troca:");
        System.out.println("primeiro número = " + a);
        System.out.println("segundo número = " + b);
        
        a = a + b; 
        b = a - b; 
        a = a - b; 

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Depois da troca:");
        System.out.println("primeiro número = " + a);
        System.out.println("segundo número = " + b);
        
        scanner.close();
    }
}

