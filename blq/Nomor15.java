import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Nomor15 {
    public static void main(String[] args) {
        String waktu12Jam = "03:40:44 PM";
        String waktu24Jam = convertTo24HourFormat(waktu12Jam);

        System.out.println("Format waktu 12 jam: " + waktu12Jam);
        System.out.println("Format waktu 24 jam: " + waktu24Jam);
    }

    private static String convertTo24HourFormat(String waktu12Jam) {
        DateTimeFormatter format12Jam = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter format24Jam = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime localTime = LocalTime.parse(waktu12Jam, format12Jam);
        return localTime.format(format24Jam);
    }
}
