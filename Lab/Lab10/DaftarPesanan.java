import java.util.ArrayList;
import java.util.Collections;

public class DaftarPesanan<T extends Pesanan> {
    // TODO: tambahkan attributes
    private ArrayList<T> pesanans;

    public DaftarPesanan() {
        // TODO: Lengkapi Constructor berikut
        this.pesanans = new ArrayList<T>();
    }

    public void tambahPesanan(T pesanan) {
        // TODO: proses tambah pesanan
        this.pesanans.add(pesanan);
    }

    public T nextPesanan() {
        // TODO: return sesuai dengan urutan prioritas
        Collections.sort(pesanans);
        T pesanan = this.pesanans.get(0);
        this.pesanans.remove(0);
        return pesanan;
    }

    // Tambahkan getter-setter apabila diperlukan
    public int getJumlahPesanan() {
        return this.pesanans.size();
    }
}
