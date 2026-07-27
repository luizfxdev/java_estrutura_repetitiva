package exercicio5;

import java.util.Scanner;

public class Fatorial {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            long fatorial = 1;
            
            for (int i = 2; i <= n; i++) {
                fatorial *= i;
            }
            
            System.out.println(fatorial);
        }
    }
}