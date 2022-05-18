import java.util.ArrayList;
import java.util.Collections;

public class DaftarPesanan<T extends Pesanan> {
    // TODO: tambahkan attributes
    private ArrayList<T> pesanans;

    public DaftarPesanan() {
        // TODO: Lengkapi Constructor berikut
        // buat ArrayList pesanans
        this.pesanans = new ArrayList<T>();
    }

    public void tambahPesanan(T pesanan) {
        // TODO: proses tambah pesanan
        this.pesanans.add(pesanan);
    }

    public T nextPesanan() {
        // TODO: return sesuai dengan urutan prioritas
        Collections.sort(pesanans);

        // mendapatkan pesanan prioritas tertinggi
        T pesanan = this.pesanans.get(0);

        // menghapus pesanan prioritas tertinggi
        this.pesanans.remove(0);

        // mengembalikan pesanan prioritas tertinggi
        return pesanan;
    }

    // Tambahkan getter-setter apabila diperlukan
    // mendapatkan jumlah pesanan
    public int getJumlahPesanan() {
        return this.pesanans.size();
    }
}
