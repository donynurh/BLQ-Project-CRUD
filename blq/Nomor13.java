public class Nomor13 {
    public static void main(String[] args) {
        int sudut1 = hitungSudut(3, 0);
        int sudut2 = hitungSudut(5, 30);
        int sudut3 = hitungSudut(2, 20);

        System.out.println("Derajat sudut untuk jam 3:00: " + sudut1);
        System.out.println("Derajat sudut untuk jam 5:30: " + sudut2);
        System.out.println("Derajat sudut untuk jam 2:20: " + sudut3);
    }

    // Fungsi untuk menghitung derajat sudut antara jarum jam dan menit
    private static int hitungSudut(int jam, int menit) {
        if (jam == 12) {
            jam = 0;
        }

        int derajatJarumMenit = 6 * menit;
        double derajatJarumJam = 30 * jam + 0.5 * menit;

        double selisih = Math.abs(derajatJarumJam - derajatJarumMenit);

        return (int) Math.min(selisih, 360 - selisih);  // Mengambil sudut terkecil
    }
}
