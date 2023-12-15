public class Nomor17 {
    public static void main(String[] args) {

        String aJalan[] = "N N T N N N T T T T T N T T T N T N".split(" ");
        int mdpl = 0, gunung = 0, lembah = 0;
        int perjalanan = 0;
        for (int i = 0; i < aJalan.length; i++) {
            if (aJalan[i].equalsIgnoreCase("N")) {// track ketemu N
                mdpl++;
            } else if (aJalan[i].equalsIgnoreCase("T")) {// track ketemu T
                mdpl--;
            }
            // catat perjalanan
            if (mdpl > 0) {
                perjalanan = 1;
            } else if (mdpl < 0) {
                perjalanan = -1;
            }
            // catat jumlah gunung dan lembah
            if (perjalanan == 1 && mdpl == 0) {
                gunung++;
                perjalanan = 0;
            } else if (perjalanan == -1 && mdpl == 0) {
                lembah++;
                perjalanan = 0;
            }

        }
        System.out.println("Gunung : "+gunung);
        System.out.println("Lembah : "+lembah);
    }
}
