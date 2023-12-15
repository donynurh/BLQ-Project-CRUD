public class Nomor11 {
    public static void main(String[] args) {
        String nama = "Jeruk";

        String aNama[] = nama.split("");
        String len = "";
        for (int i = 0; i < (aNama.length)/2; i++) {
            len += "*";
        }

        for(int i = aNama.length-1 ; i >= 0 ; i--){
            System.out.println(len + aNama[i] + len);
        }

    }
}
