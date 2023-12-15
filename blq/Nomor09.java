import java.util.Scanner;

public class Nomor09 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = 0;
        System.out.print("Masukkan N : ");
        N = input.nextInt();
        int len = N;

        for (int i = 0; i < len; i++) {
            System.out.print(N+ " ");
            N += len;

        }

        input.close();
    }

}
