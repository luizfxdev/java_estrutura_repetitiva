import java.util.Scanner;

public class QuadradoECubo {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            for (int i = 1; i <= n; i++) {
                int quadrado = i * i;
                int cubo = i * i * i;
                
                System.out.println(i + " " + quadrado + " " + cubo);
            }
        }
    }
}