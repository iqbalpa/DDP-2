// Ikuti UML diagram

public class Minuman extends Pesanan {
    // TODO: tambahkan attributes
    private boolean isPakeEs;

    public Minuman(String nama, int harga, int prioritas, boolean isPakeEs) {
        // TODO: Lengkapi Constructor berikut
        super(nama, harga, prioritas);
        this.isPakeEs = isPakeEs;
    }

    @Override
    public String toString() {
        // TODO: return deskripsi sesuai dengan ketentuan soal
        if (this.isPakeEs) {
            return (this.getNama() + " dingin");
        } else {
            return (this.getNama() + " hangat");
        }
    }

    // Tambahkan getter-setter bila diperlukan
}
