import java.util.Scanner;
import java.lang.Math;

public class KalkulatorBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di program kalkulator BMI!");
        System.out.println("--------------------------------------------------------");
        System.out.print("Masukkan jumlah mahasiswa yang akan dihitung datanya: ");

        int jumlah = input.nextInt();

        // inisialisasi jumlah awal untuk setiap kategori
        int bawahNormal = 0, normal = 0, atasNormal = 0, obesitas = 0;

        for (int i = 0; i < jumlah; i++) {
            System.out.println("--------------------DATA MAHASISWA " + (i + 1) + "--------------------");
            System.out.print("Standar pengukuran apakah yang digunakan? ");

            String standarPengukuran = input.next();

            // jika standar pengukuran adalah METRIK
            if (standarPengukuran.equals("METRIK")) {
                System.out.print("Masukkan massa tubuh mahasiswa (kilogram): ");
                double massa = input.nextDouble();
                System.out.print("Masukkan tinggi tubuh mahasiswa (sentimeter): ");
                double tinggiSenti = input.nextDouble();

                // ubah tinggi badan ke satuan meter
                double tinggiMeter = tinggiSenti / 100;

                // rumus untuk menghitung BMI
                double bmi = massa / Math.pow(tinggiMeter, 2);

                // kondisi untuk beberapa nilai BMI
                // jika masuk ke salah satu kategori, maka jumlah kategori akan bertambah
                // (increment)
                if (bmi < 18.5) {
                    bawahNormal++;
                } else if (bmi >= 18.5 && bmi < 25) {
                    normal++;
                } else if (bmi >= 25 && bmi < 30) {
                    atasNormal++;
                } else {
                    obesitas++;
                }

            }
            // jika standar pengukuran adalah IMPERIAL
            else if (standarPengukuran.equals("IMPERIAL")) {
                System.out.print("Masukkan massa tubuh mahasiswa (pon): ");
                double massa = input.nextDouble();
                System.out.print("Masukkan tinggi tubuh mahasiswa (inci): ");
                double tinggi = input.nextDouble();

                // rumus untuk menghitung BMI
                double bmi = 703 * massa / Math.pow(tinggi, 2);

                // kondisi untuk beberapa nilai BMI
                // jika masuk ke salah satu kategori, maka jumlah kategori akan bertambah
                // (increment)
                if (bmi < 18.5) {
                    bawahNormal++;
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    normal++;
                } else if (bmi >= 25 && bmi <= 29.9) {
                    atasNormal++;
                } else {
                    obesitas++;
                }

            }
        }

        System.out.println("---------------------RINGKASAN DATA---------------------");
        System.out.println("Berikut merupakan ringkasan hasil pengukuran BMI dari " + jumlah + " mahasiswa.");
        System.out.println("Jumlah mahasiswa dengan berat badan di bawah normal: " + bawahNormal);
        System.out.println("Jumlah mahasiswa dengan berat badan normal: " + normal);
        System.out.println("Jumlah mahasiswa dengan berat badan di atas normal: " + atasNormal);
        System.out.println("Jumlah mahasiswa obesitas: " + obesitas);
        System.out.println("--------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program kalkulator BMI!");

        input.close();
    }
}
