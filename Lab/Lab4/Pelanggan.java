import java.util.Arrays;

public class Pelanggan {
  
    //TODO: Tambahkan modifier
    private String nama;
    private int uang;
    private Order[] keranjang = new Order[0];
    private int kapasitasKeranjang = 5000;

    //TODO: Buat Constructor
    // public Pelanggan(String nama, int uang, int kapasitas) {
    //     this.nama = nama;
    //     this.uang = uang;
    // }
    public Pelanggan(String nama, int uang) {
        this.nama = nama;
        this.uang = uang;
    }
    
    // TODO: lengkapi method di bawah ini
    String addBarang(Barang barang, int banyakBarang){

        // jika stock barang masih ada
        if (barang.cekStock(banyakBarang)) {

            if (kapasitasKeranjang < (barang.getBeratBarang() * banyakBarang)){
                int oldBanyakBarang = banyakBarang;
                banyakBarang = kapasitasKeranjang / barang.getBeratBarang();
                //System.out.println("Maaf " + oldBanyakBarang + " " + barang.getNama() + " terlalu berat, tetapi " + banyakBarang + " " + barang.getNama() + " berhasil ditambahkan");
                System.out.printf("Maaf %d %s terlalu berat, tetapi %d %s berhasil ditambahkan\n", oldBanyakBarang, barang.getNama(), banyakBarang, barang.getNama());
            }

            // kapasitas keranjang berkurang 
            kapasitasKeranjang -= barang.getBeratBarang() * banyakBarang;

            // cek apakah barang sudah ada di kerjanjang atau belum
            for(Order b: keranjang) {

                // jika barang sudah ada di keranjang
                if (b.getBarang().getNama().equals(barang.getNama())) {
                    b.setBanyakBarang(b.getBanyakBarang() + banyakBarang);

                    // mengurangi stok barang yg dibeli
                    barang.setStock(barang.getStock() - banyakBarang);

                    System.out.printf("%s berhasil menambahkan %d %s\n", nama, banyakBarang, barang.getNama());
                    return "";
                }
            }
            
            // jika barang belum ada di keranjang
            Order newOrder = new Order(barang, banyakBarang);
            keranjang = Arrays.copyOf(keranjang, keranjang.length+1);
            keranjang[keranjang.length-1] = newOrder;

            // mengurangi stok barang yg dibeli
            barang.setStock(barang.getStock() - banyakBarang);
            return "";
            
        }
        System.out.printf("Stok %s kurang", barang.getNama());

        return "";
    }
    
    // TODO: lengkapi method di bawah ini
    int totalHargaBarang(){
        int totalHarga = 0;
        for (Order b: keranjang) {
            totalHarga += b.getBarang().getHarga() * b.getBanyakBarang();
        }
        return totalHarga;
    }
    
    // TODO: lengkapi method di bawah ini
    String cekUang(){
        return "Uang " + nama + " sekarang " + uang;
    }

    // Setter and Getter dan lengkapi modifier
    String getNama() {
        return this.nama;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    int getUang() {
        return this.uang;
    }

    void setUang(int uang) {
        this.uang = uang;
    }

    Order[] getKeranjang() {
        return keranjang;
    }

    void resetKeranjang() {
        this.keranjang = Arrays.copyOf(this.keranjang, 0);
    }
    
    void resetKapasitasKeranjang(){
        this.kapasitasKeranjang = 5000;
    }
}