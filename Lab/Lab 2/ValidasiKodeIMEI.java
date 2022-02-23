import java.util.Scanner;

public class ValidasiKodeIMEI {
    public static boolean isValid(long kode) {
        return cekPrefix(kode)
            && (getPanjangKode(kode) == 11)
            && ((jumlahDoublePosisiGanjil(kode) + jumlahPosisiGenap(kode)) % 10 == 0);
    }

    public static int jumlahDoublePosisiGanjil(long kode) {
        String kodeStr = Long.toString(kode);
        if (kodeStr.length() == 1) {
            int number = getDigit(Integer.parseInt(kodeStr));
            return number;
        }
        int head = getDigit(Integer.parseInt(kodeStr.substring(0, 1)));
        return head + jumlahDoublePosisiGanjil(Long.parseLong(kodeStr.substring(2)));
    }

    public static int getDigit(int number) {
        int newNumber = number * 2;
        String numberStr = Integer.toString(newNumber);
        if (numberStr.length() == 2) {
            int digit1 = Character.getNumericValue(numberStr.charAt(0));
            int digit2 = Character.getNumericValue(numberStr.charAt(1));
            newNumber = digit1 + digit2;
        }
        return newNumber;
    }

    public static int jumlahPosisiGenap(long kode) {
        String kodeStr = jumlahPosisiGenapHelper(kode);
        if (kodeStr.length() == 2) {
            int number = Integer.parseInt(kodeStr.substring(0, 1));
            return number;
        }
        int head = Integer.parseInt(kodeStr.substring(0,1));
        return head + jumlahPosisiGenap(Long.parseLong(kodeStr.substring(1)));
    }

    public static String jumlahPosisiGenapHelper(long kode) {
        String kodeStr = Long.toString(kode);
        return kodeStr.substring(1);
    }

    public static boolean cekPrefix(long kode) {
        String kodeStr = Long.toString(kode);
        if (kodeStr.startsWith("18") || kodeStr.startsWith("2")) {
            return true;
        }
        return false;
    }

    public static int getPanjangKode(long kode) {
        String kodeStr = Long.toString(kode);
        return kodeStr.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] valid = new String[n];

        for (int i=0; i < n; i++) {
            long kode = sc.nextLong();
            valid[i] = (isValid(kode) ? "YES" : "NO");
        }
        for (int j=0; j < n; j++) {
            System.out.println(valid[j]);
        }
        sc.close();
    }
}
