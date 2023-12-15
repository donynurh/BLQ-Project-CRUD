public class Nomor06 {
    public static void main(String[] args) {
        String kata1 = "katak";
        String kata2 = "rusak";

        System.out.println(kata1 + " adalah palindrome: " + isPalindrome(kata1));
        System.out.println(kata2 + " adalah palindrome: " + isPalindrome(kata2));
    }

    static boolean isPalindrome(String kata) {
        int panjang = kata.length();

        for (int i = 0; i < panjang / 2; i++) {
            if (kata.charAt(i) != kata.charAt(panjang - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
