public class Nomor08 {
    public static void main(String[] args) {
        int[] deret = {1, 2, 4, 7, 8, 6, 9};

        System.out.println("Nilai minimal penjumlahan dari 4 komponen adalah : " +cariMinimal(deret));
        System.out.println("Nilai maksimal penjumlahan dari 4 komponen adalah : " +cariMaksimal(deret));

    }

    static int cariMinimal(int[] deret){
        int jumlah = 4;
        int minimal = 0;
        for (int j = 0; j < deret.length; j++) {
            for (int i = 0; i < deret.length - 1; i++) {
                int awal = deret[i];
                if (deret[i] > deret[i + 1]) {
                    deret[i] = deret[i + 1];
                    deret[i + 1] = awal;
                }
            }
        }

        for (int i = 0; i < jumlah; i++) {
            minimal += deret[i];
        }

        return minimal;
    }

    static int cariMaksimal(int[] deret){
        int jumlah = 4;
        int maksimal = 0;
        for (int j = 0; j < deret.length; j++) {
            for (int i = 0; i < deret.length - 1; i++) {
                int awal = deret[i];
                if (deret[i] < deret[i + 1]) {
                    deret[i] = deret[i + 1];
                    deret[i + 1] = awal;
                }
            }
        }

        for (int i = 0; i < jumlah; i++) {
            maksimal += deret[i];
        }

        return maksimal;
    }
}
