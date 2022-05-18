public class Pesanan implements Comparable<Pesanan> {
    // TODO: tambahkan attributes
    private String name;
    private int harga;
    private int prioritas;

    public Pesanan(String nama, int harga, int prioritas) {
        // TODO: Lengkapi Constructor berikut
        this.name = nama;
        this.harga = harga;
        this.prioritas = prioritas;
    }

    @Override
    public int compareTo(Pesanan o) {
        // TODO: Lengkapi method ini
        if (this.prioritas > o.prioritas) {
            return 1;
        } else if (this.prioritas < o.prioritas) {
            return -1;
        } else {
            return 0;
        }
    }

    // Tambahkan getter-setter bila diperlukan
    public String getNama() {
        return this.name;
    }
}