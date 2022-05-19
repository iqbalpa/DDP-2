import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    // Gunakan out sebagai pengganti System.out
    // out ini akan menahan output sampai dia di-(close/flush)
    // Contoh jika ingin print("merah"), maka tulis out.print("merah")

    // TODO: Ubahlah "?" menjadi class yang tepat
    private static DaftarPesanan<Makanan> daftarMakanan = new DaftarPesanan<>();
    private static DaftarPesanan<Minuman> daftarMinuman = new DaftarPesanan<>();

    // TODO: Lengkapi method main
    public static void main(String[] args) {
        int jumlahMakanan = in.nextInt();
        int jumlahMinuman = in.nextInt();

        for (int i = 0; i < jumlahMakanan; i++) {
            String namaMakanan = in.next();
            int harga = in.nextInt();
            int prioritas = in.nextInt();
            int tingkatKepedasan = in.nextInt();
            // TODO: tambahkan ke daftarMakanan

            // buat object makanan baru
            Makanan newMakanan = new Makanan(namaMakanan, harga, prioritas, tingkatKepedasan);

            // tambah makanan baru ke daftar makanan
            daftarMakanan.tambahPesanan(newMakanan);
        }

        for (int i = 0; i < jumlahMinuman; i++) {
            String namaMinuman = in.next();
            int harga = in.nextInt();
            int prioritas = in.nextInt();
            boolean isPakeEs = in.next().equals("YES");
            // TODO: tambahkan ke daftarMinuman

            // buat object minuman baru
            Minuman newMinuman = new Minuman(namaMinuman, harga, prioritas, isPakeEs);

            // tambah minuman baru ke daftar minuman
            daftarMinuman.tambahPesanan(newMinuman);
        }

        while (true) {
            String command = in.next();
            if (command.equals("KELUAR")) {
                break;
            }

            String tipe = in.next();

            if (tipe.equals("MAKANAN")) {
                // TODO: serve makanan

                // jika makanan sudah disajikan semua
                if (daftarMakanan.getJumlahPesanan() == 0){
                    out.println("Semua pesanan makanan telah disajikan!");
                } 
                // jika makanan masih ada yg akan disajikan
                else {
                    Makanan makanan = daftarMakanan.nextPesanan();
                    out.println(makanan.toString() + " telah disajikan.");
                }
            } else {
                // TODO: serve minuman

                // jika minuman sudah disajikan semua
                if (daftarMinuman.getJumlahPesanan() == 0){
                    out.println("Semua pesanan minuman telah disajikan!");
                } 
                // jika minuman masih ada yg akan disajikan
                else {
                    Minuman minuman = daftarMinuman.nextPesanan();
                    out.println(minuman.toString() + " telah disajikan.");
                }
            }
        }

        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the
    // usual Scanner(System.in) and System.out
    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
