// untuk pengubahan data type, saya merujuk pada artikel-artikel yang ada di "free code camp"
// https://www.freecodecamp.org/news/tag/java/


import java.util.Scanner;

public class ValidasiKodeIMEI {

    // return TRUE jika Kode IMEI memenuhi semua ketentuan
    public static boolean isValid(long kode) {
        return cekPrefix(kode)
            && (getPanjangKode(kode) == 11)
            && ((jumlahDoublePosisiGanjil(kode) + jumlahPosisiGenap(kode)) % 10 == 0);
    }

    // menghitung jumlah angka di posisi ganjil
    public static int jumlahDoublePosisiGanjil(long kode) {

        // mengubah "kode" ke bentuk string
        String kodeStr = Long.toString(kode);

        // base case untuk recursive
        if (kodeStr.length() == 1) {

            // mendapatkan angka posisi ganjil yg terakhir
            int number = getDigit(Integer.parseInt(kodeStr));
            return number;
        }

        // recursive case
        // head adalah digit pertama tiap recursive
        int head = getDigit(Integer.parseInt(kodeStr.substring(0, 1)));
        return head + jumlahDoublePosisiGanjil(Long.parseLong(kodeStr.substring(2)));
    }

    // memproses angka di posisi ganjil 
    public static int getDigit(int number) {
        int newNumber = number * 2;

        // mengubah "number" ke bentuk string
        String numberStr = Integer.toString(newNumber);

        // jika hasil kali suatu angka ada 2 digit, 
        // kedua digit tsb dijumlahkan
        if (numberStr.length() == 2) {
            int digit1 = Character.getNumericValue(numberStr.charAt(0));
            int digit2 = Character.getNumericValue(numberStr.charAt(1));
            newNumber = digit1 + digit2;
        }
        return newNumber;
    }

    // menghitung jumlah angka di posisi genap
    public static int jumlahPosisiGenap(long kode) {

        // mendapatkan "kode" dalam bentuk srting dengan menghilangkan digit pertama,
        // agar dapat langsung mengakses ke angka di posisi genap
        String kodeStr = jumlahPosisiGenapHelper(kode);

        // base case untuk recursive
        if (kodeStr.length() == 2) {

            // mendapatkan angka posisi genap yg terakhir
            int number = Integer.parseInt(kodeStr.substring(0, 1));
            return number;
        }

        // recursive case
        // head adalah digit pertama tiap recursive
        int head = Integer.parseInt(kodeStr.substring(0,1));
        return head + jumlahPosisiGenap(Long.parseLong(kodeStr.substring(1)));
    }

    // helper method
    public static String jumlahPosisiGenapHelper(long kode) {

        // mengubah "kode" ke bentuk string
        String kodeStr = Long.toString(kode);

        // mengembalikan seluruh kode tanpa digit pertamanya
        return kodeStr.substring(1);
    }

    // method untuk mengecek prefix Kode IMEI
    public static boolean cekPrefix(long kode) {
        String kodeStr = Long.toString(kode);

        // jika Kode IMEI diawali dengan angka 18 atau 2, maka return true
        if (kodeStr.startsWith("18") || kodeStr.startsWith("2")) {
            return true;
        }
        return false;
    }

    // method untuk mendapatkan panjang Kode IMEI
    public static int getPanjangKode(long kode) {
        String kodeStr = Long.toString(kode);
        return kodeStr.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // array untuk menyimpan hasil validasi tiap Kode IMEI
        String[] valid = new String[n];

        // meminta input Kode IMEI
        for (int i=0; i < n; i++) {
            long kode = sc.nextLong();
            valid[i] = (isValid(kode) ? "YES" : "NO");
        }

        // mencetak hasil validasi
        for (int j=0; j < n; j++) {
            System.out.println(valid[j]);
        }
        sc.close();
    }
}
