import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Nomor02 {
    public static void main(String[] args) {

        String startA = "28/02/2016";
        String endA = "07/03/2016";

        String startB = "29/04/2018";
        String endB = "30/05/2018";

        System.out.println("a. Total denda: " + hitungDenda(startA, endA));
        System.out.println("b. Total denda: " + hitungDenda(startB, endB));

    }

    public static int hitungDenda (String a, String b){
        int[] durasiBuku = {14,3,7,7};

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

        long selisih = 0, hari = 0;

        try {
            Date dateDari = format.parse(a);
            Date dateSampai = format.parse(b);

            selisih = dateSampai.getTime() - dateDari.getTime();
            hari = TimeUnit.MILLISECONDS.toDays(selisih);

            System.out.println("Peminjaman: " + hari + " hari");


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int denda = 0;
        for (int i = 0; i < durasiBuku.length; i++) {
            if(hari > durasiBuku[i]){
                denda += ((int)hari - durasiBuku[i]) * 100;
            } else {
                denda = 0;
            }
        }
        return denda;
    }
}
