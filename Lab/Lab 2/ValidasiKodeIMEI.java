import java.util.Scanner;

public class ValidasiKodeIMEI {
    /** Return true jika kode memenuhi ketentuan */
    public static boolean isValid(long kode) {
        return cekPrefix(kode)
            && (getPanjangKode(kode) == 11)
            && ((jumlahDoublePosisiGanjil(kode) + jumlahPosisiGenap(kode)) % 10 == 0);
    }

    /**
     * Dapatkan hasil dari langkah (b)
     * (harus rekursif), boleh menggunakan helper method
     */
    public static int jumlahDoublePosisiGanjil(long kode) {

        return -1;
    }

    /**
     * Jika hasil kali dua digit tersebut menghasilkan angka yang lebih dari 9,
     * tambahkan dua digit angka tersebut untuk mendapatkan angka yang <= 9.
     */
    public static int getDigit(int number) {
        int newNumber = number;
        String numberStr = Integer.toString(number);
        if (numberStr.length() == 2) {
            int digit1 = Integer.valueOf(numberStr.charAt(0));
            int digit2 = Integer.valueOf(numberStr.charAt(1));
            newNumber = digit1 + digit2;
        }
        return newNumber;
    }

    /**
     * Dapatkan hasil dari langkah (c)
     * (harus rekursif), boleh menggunakan helper method
     */
    public static int jumlahPosisiGenap(long kode) {

        return -1;
    }

    /** Return true jika kode merupakan prefix yang valid */
    public static boolean cekPrefix(long kode) {
        String kodeStr = Long.toString(kode);
        if (kodeStr.startsWith("18") || kodeStr.startsWith("2")) {
            return true;
        }
        return false;
    }

    /** Return panjang kode */
    public static int getPanjangKode(long kode) {
        String kodeStr = Long.toString(kode);
        return kodeStr.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            long kode = sc.nextLong();
            System.out.println(isValid(kode) ? "YES" : "NO");
        }
        sc.close();
    }
}
