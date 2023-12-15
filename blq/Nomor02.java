import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Nomor02 {
    public static void main(String[] args) {

        String peminjamanA = "28/02/2016";
        String pengembalianA = "07/03/2016";

        String peminjamanB = "29/04/2018";
        String pengembalianB = "30/05/2018";

        System.out.println("a. Total denda: " + hitungDenda(peminjamanA, pengembalianA));
        System.out.println("b. Total denda: " + hitungDenda(peminjamanB, pengembalianB));

    }

    public static int hitungDenda (String a, String b){
        int[] durasiBuku = {14,3,7,7};

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

        long selisih = 0, hari = 0;

        try {
            Date datePinjam = format.parse(a);
            Date dateKembali = format.parse(b);

            selisih = dateKembali.getTime() - datePinjam.getTime();
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
