public class Nomor07 {
    public static void main(String[] args) {

        int[] deret = {8, 7, 0, 2, 7, 1, 7, 6, 3, 0, 7, 1, 3, 4, 6, 1, 6, 4, 3};
        System.out.println("Nilai mean dari deret tersebut adalah : " + mean(deret));
        median(deret);

    }

    //Mencari mean
    static int mean(int[] deret) {
        int hasil;
        int total = 0;
        for (int i = 0; i < deret.length; i++) {
            total += deret[i];
        }
        hasil = total/deret.length;
        return hasil;
    }

    //Mencari median
    static void median(int[] deret) {
        int elemen_median = 0;
        int median = 0;
        int elemen_median2 = 0;
        int median2 = 0;
        float hasil = 0;

        for (int j = 0; j < deret.length; j++) {
            for (int i = 0; i < deret.length - 1; i++) {
                int awal = deret[i];
                if (deret[i] > deret[i + 1]) {
                    deret[i] = deret[i + 1];
                    deret[i + 1] = awal;
                }
            }
        }

        if (deret.length % 2 == 1) {
            elemen_median = (deret.length + 1) / 2;
            median = deret[elemen_median - 1];
            System.out.println("Nilai median dari deret tersebut adalah : " + median);
        } else if (deret.length % 2 == 0) {
            elemen_median = ((deret.length / 2) - 1);
            median = deret[elemen_median];
            elemen_median2 = deret.length / 2;
            median2 = deret[elemen_median2];
            hasil = (float) (median + median2) / 2;
            System.out.println("Nilai median dari deret tersebut adalah : " + hasil);
        }


    }

    static int modus(int[] deret) {
        int hasil = 1;
        return hasil;
    }
}
