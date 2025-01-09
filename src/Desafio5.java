import java.util.Scanner;

public class Desafio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String textToReverte = sc.nextLine();

        System.out.println("O Texto: "+ textToReverte+ "ao contrario eh: "+ reverseString(textToReverte));
    }

    public static String reverseString(String text){
        if(text == null){
            return text;
        }
        String reverse = "";
        for(int i = text.length()-1; i>=0; i--){
            reverse += text.charAt(i);
        }
        return reverse;
    }
}
