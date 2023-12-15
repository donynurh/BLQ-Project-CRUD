import java.util.Scanner;

public class Nomor10 {
    public static void main(String[] args) {

        String nama = "Susilo Bambang Yudoyono";
        String aNama[] = nama.split(" ");

        for (int i = 0; i < aNama.length; i++) {
            System.out.print(aNama[i].substring(0, 1));
            for (int j = 0; j < aNama[i].length() - 2; j++) {
                System.out.print("*");
            }
            System.out.print(aNama[i].substring(aNama[i].length() - 1));
            System.out.print(" ");
        }

    }
}
