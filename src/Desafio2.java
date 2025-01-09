import java.util.Scanner;
public class Desafio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int num = sc.nextInt();

        int primeiro = 0;
        int segundo = 1;
        int fib = 0;
        boolean existe = false;

        while (fib <= num) {
            if (fib == num) {
                existe = true;
                break;
            }
            fib = primeiro + segundo;
            primeiro = segundo;
            segundo = fib;
        }

        System.out.println("O número existe na sequência de Fibonacci? " + existe);
        sc.close();
    }
}