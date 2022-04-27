import java.io.*;
import java.util.*;

public class HealthWorthinessChecker {
    private static int MINIMUM_TINGKAT_KESEHATAN = 70;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inputFile = null;
        PrintWriter outputFile = null;
        int jumlahMahasiswa = 0;

        System.out.println("Selamat datang di program Health Worthiness Checker.");
        System.out.println("-------------------------------------------------------");

        System.out.print("Silakan masukkan nama file masukan: ");
        String inputFileName = in.next();
        System.out.print("Silakan masukkan nama file keluaran: ");
        String outputFileName = in.next();

        System.out.println("-------------------------------------------------------");

        in.close();

        try {
            inputFile = new Scanner(new File(inputFileName));
            System.out.println("Data sedang diproses, harap menunggu...");

            String line = inputFile.nextLine();

            jumlahMahasiswa = Integer.valueOf(line);
            // TODO: Implementasi inisiasi array penyimpanan data
            Mahasiswa[] daftarMahasiswa = new Mahasiswa[jumlahMahasiswa];
            int pointer = 0;

            while (inputFile.hasNextLine()) {
                line = inputFile.nextLine();
                // TODO: Implementasi penyimpanan data mahasiswa ke array sesuai spesifikasi

                // nama adalah line pertama
                String nama = line;

                // dataKesehatan adalah line kedua
                String[] dataKesehatan = inputFile.nextLine().split(" ");

                // menjumlahkan setiap dataKesehatan dan dikalikan 2
                int tingkatKesehatan = 0;
                for (int i = 0; i < dataKesehatan.length; i++) {
                    tingkatKesehatan += 2 * Integer.valueOf(dataKesehatan[i]);
                }

                // membuat object mahasiswa
                Mahasiswa newMahasiswa = new Mahasiswa(nama, tingkatKesehatan);

                // menambahkan object mahasiswa baru ke array daftarMahasiswa
                daftarMahasiswa[pointer] = newMahasiswa;
                pointer++;
            }

            // Proses data mahasiswa
            System.out.println("\nLOG:");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                try {
                    // TODO: Implementasi pengecekan tingkat kesehatan mahasiswa

                    // jika tingkat kesehatan >= 70, maka status layak
                    if (daftarMahasiswa[i].getTingkatKesehatan() >= MINIMUM_TINGKAT_KESEHATAN) {
                        System.out.println(daftarMahasiswa[i].getNama() + ": LAYAK");
                    } 
                    // jika tidak, maka tidak layak dan akan melempar exception HealthinessUnworthyException
                    else {
                        throw new HealthinessUnworthyException(daftarMahasiswa[i].getNama());
                    }
                } catch (HealthinessUnworthyException e) {
                    // TODO: Implementasi output ketika mahasiswa tidak memenuhi kelayakan
                    System.out.println(e.getMessage());
                }
            }

            // Output ke teks
            outputFile = new PrintWriter(new File(outputFileName));

            outputFile.write("Nama Mahasiswa          | Status\n");
            outputFile.write("-------------------------------------------------------\n");
            // TODO: Implementasi output data mahasiswa ke file output
            for (int i=0; i<jumlahMahasiswa; i++){
                outputFile.write(daftarMahasiswa[i].toString());
            }

            System.out.println("\nData mahasiswa berhasil diproses!");

        } catch (FileNotFoundException e) {
            // TODO: Implementasi output ketika file tidak ditemukan
            System.out.println("ERROR: File masukan tidak ditemukan.");
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program Health Worthiness Checker.");
    }
}
