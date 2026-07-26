
import java.util.Scanner;

public class Divisao {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (b == 0) {
                    System.out.println("divisao impossivel");
                } else {
                    double resultado = (double) a / b;
                    System.out.println(resultado);
                }
            }
        }
    }
}
