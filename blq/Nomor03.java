import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Nomor03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tglA = "27/01/2019 05:00:01";
        String tglB = "27/01/2019 17:45:03";

        long selisih = 0, jam = 0, menit = 0, detik = 0;
        int bayar = 0, bayar24 = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try {
            Date dTglA = format.parse(tglA);
            Date dTglB = format.parse(tglB);
            selisih = dTglB.getTime() - dTglA.getTime();
            jam = TimeUnit.MILLISECONDS.toHours(selisih);
            menit = TimeUnit.MILLISECONDS.toMinutes(selisih)
                    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(selisih));
            detik = TimeUnit.MILLISECONDS.toSeconds(selisih)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(selisih));
            System.out.println("Selisih Jam : " + jam + " Jam");
            System.out.println("Selisih Menit : " + menit + " Menit");
            System.out.println("Selisih Detik : " + detik + " Detik");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (menit > 0 || detik > 0) {
            long pembulatan = 0;
            pembulatan = jam + 1;
            if (pembulatan >= 1 && pembulatan <= 8) {
                int pemb = (int) (pembulatan);
                bayar = pemb * 1000;
                System.out.println("Dibulatkan menjadi " + pembulatan + " Jam");
                System.out.println("Bayar : " + bayar);
            } else if (pembulatan >= 8 && pembulatan <= 24) {
                bayar = 8000;
                pembulatan = jam + 1;
                System.out.println("Dibulatkan menjadi " + pembulatan + " Jam");
                System.out.println("Bayar : " + bayar);
            } else if (pembulatan > 24) {
                pembulatan = pembulatan - 24;
                bayar24 = 15000;
                if (pembulatan >= 1 && pembulatan <= 8) {
                    int pemb = (int) (pembulatan);
                    bayar = (pemb * 1000) + bayar24;
                    System.out.println("Dibulatkan menjadi 1 hari " + pembulatan + " Jam");
                    System.out.println("Bayar : " + bayar);
                } else if (pembulatan >= 8 && pembulatan <= 24) {
                    bayar = 8000 + bayar24;
                    pembulatan = jam + 1;
                    System.out.println("Dibulatkan menjadi 1 hari " + pembulatan + " Jam");
                    System.out.println("Bayar : " + bayar);
                }
            }
        } else {
            if (jam >= 1 && jam <= 8) {
                bayar = (int) jam * 1000;
                System.out.println("Bayar : " + bayar);
            } else if (jam > 8 && jam <= 24) {
                bayar = 8000;
                System.out.println("Bayar : " + bayar);
            } else if (jam > 24) {
                jam = jam - 24;
                bayar24 = 15000;
                if (jam >= 1 && jam <= 8) {
                    bayar = ((int) jam * 1000) + bayar24;
                    System.out.println("Bayar : " + bayar);
                } else if (jam > 8 && jam <= 24) {
                    bayar = 8000 + bayar24;
                    System.out.println("Bayar : " + bayar);
                }
            }
        }

        input.close();

    }
}
