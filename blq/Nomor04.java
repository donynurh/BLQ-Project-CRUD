public class Nomor04 {
    public static void main(String[] args) {
        int n = 12;
        int count = 0;
        int num = 2;

        System.out.println("Daftar " + n + " bilangan prima pertama:");

        while (count < n) {
            boolean isPrima = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrima = false;
                    break;
                }
            }

            if (isPrima) {
                System.out.print(num + " ");
                count++;
            }

            num++;
        }

        System.out.println();
    }
}
