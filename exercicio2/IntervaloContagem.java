import java.util.Scanner;

public class IntervaloContagem {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            int in = 0;
            int out = 0;
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                
                if (x >= 10 && x <= 20) {
                    in++;
                }
                else {
                    out++;
                }
            }
            
            System.out.println("In: " + in);
            System.out.println("Out: " + out);
        }
    }
}