public class Nomor20 {
    public static void main(String[] args) {
        String hasil = tentukanPemenang(2, "GGG", "KKB");
        System.out.println(hasil);
    }

    private static String tentukanPemenang(int jarakAwal, String suitA, String suitB) {
        int jarak = jarakAwal;

        for (int i = 0; i < suitA.length(); i++) {
            char gerakanA = suitA.charAt(i);
            char gerakanB = suitB.charAt(i);

            if (gerakanA == 'G') {
                jarak += 2;  // A maju 2 langkah
            } else if (gerakanA == 'K') {
                jarak -= 1;  // A mundur 1 langkah
            }

            if (jarak == 0) {
                return "A";  // A menang
            }

            if (gerakanB == 'G') {
                jarak -= 1;  // B mundur 1 langkah
            } else if (gerakanB == 'K') {
                jarak += 2;  // B maju 2 langkah
            }

            if (jarak == 0) {
                return "B";  // B menang
            }
        }

        return "Draw";  // Jika tidak ada pemenang
    }
}
