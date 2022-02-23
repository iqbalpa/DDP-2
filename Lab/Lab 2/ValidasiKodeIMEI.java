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
        int total = 0;
        String kodeStr = Long.toString(kode);
        for (int i=0; i < kodeStr.length(); i++) {
            if ( ((i+1)%2) == 1) {
                int digit = Character.getNumericValue(kodeStr.charAt(i));
                int newDigit = getDigit(digit);
                total += newDigit;
                // System.out.println(newDigit);
            }
        }
        // System.out.println("posisi ganjil: " + total);
        return total;
    }

    /**
     * Jika hasil kali dua digit tersebut menghasilkan angka yang lebih dari 9,
     * tambahkan dua digit angka tersebut untuk mendapatkan angka yang <= 9.
     */
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

    /**
     * Dapatkan hasil dari langkah (c)
     * (harus rekursif), boleh menggunakan helper method
     */
    public static int jumlahPosisiGenap(long kode) {
        int total = 0;
        String kodeStr = Long.toString(kode);
        for (int i=0; i < kodeStr.length(); i++) {
            if ( ((i+1)%2) == 0) {
                int digit = Character.getNumericValue(kodeStr.charAt(i));
                // System.out.println(digit);
                total += digit;
            }
        }
        // System.out.println("posisi genap: " + total);
        return total;
    }

    /** Return true jika kode merupakan prefix yang valid */
    public static boolean cekPrefix(long kode) {
        String kodeStr = Long.toString(kode);
        if (kodeStr.startsWith("18") || kodeStr.startsWith("2")) {
            // System.out.println("prefix true");
            return true;
        }
        // System.out.println("prefix false");
        return false;
    }

    /** Return panjang kode */
    public static int getPanjangKode(long kode) {
        String kodeStr = Long.toString(kode);
        // System.out.println("panjang: " + kodeStr.length());
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
