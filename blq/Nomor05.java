public class Nomor05 {
    public static void main(String[] args) {
        int n = 10;
        int num1 = 0, num2 = 1;

        System.out.println("Daftar " + n + " bilangan Fibonacci pertama:");

        for (int i = 0; i < n; i++) {
            System.out.print(num1 + " ");

            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }

    }
}
