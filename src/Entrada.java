import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    public static int lerInteiros(Scanner s) {
        int leitura = 0;
        boolean continua = true;

        while (continua){
            try {
                leitura = s.nextInt();
                s.nextLine();
                continua = false;
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas numero");
                s.nextLine();
            }
        }
        return leitura;
    }
}
