import java.util.Scanner;

public class Nomor14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] deret = { 3, 9, 0, 7, 1, 2, 4 };

        System.out.print("deret awal: ");

        for (int i = 0; i < deret.length; i++) {
            System.out.print(deret[i] + " ");
        }

        System.out.println();
        System.out.print("N: ");
        int x = input.nextInt();

        System.out.print("deret akhir: ");

        for (int j = 1; j <= x; j++) {
            int wadah = deret[0];
            for (int i = 0; i < deret.length - 1; i++) {
                deret[i] = deret[i + 1];
            }
            deret[deret.length - 1] = wadah;

            if (j == x){
                for (int i = 0; i < deret.length; i++) {
                    System.out.print(deret[i] + " ");

                }
            }

        }

        input.close();

    }
}
