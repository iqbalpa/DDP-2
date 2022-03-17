public class Pelanggan {
  
    //TODO: Tambahkan modifier
    private String nama;
    private int uang;
    private Order[] keranjang;
    private int kapasitasKeranjang = 5000;

    //TODO: Buat Constructor
    public Pelanggan(String nama, int uang, int kapasitas) {
        this.nama = nama;
        this.uang = uang;
        this.keranjang = new Order[kapasitas];
    }
    
    // TODO: lengkapi method di bawah ini
    String addBarang(Barang barang, int banyakBarang){

        String output = nama + " berhasil menambahkan " + banyakBarang + " " + barang.getNama() +"\n";

        // jika stock barang cukup
        if (barang.cekStock(banyakBarang)) {

            // jika kapasitas keranjang < beban barang baru
            if (kapasitasKeranjang < (barang.getBeratBarang() * banyakBarang)){
                int oldBanyakBarang = banyakBarang;

                // jumlah barang yg ingin dibeli dikurangi hingga cukup untuk masuk keranjang
                banyakBarang = kapasitasKeranjang / barang.getBeratBarang();
               
                output = "Maaf " + oldBanyakBarang + " " + barang.getNama() + " terlalu berat, tetapi " + banyakBarang + " " + barang.getNama() + " berhasil ditambahkan\n";
                
            }

            // kapasitas keranjang dikurangi beban barang baru
            kapasitasKeranjang -= barang.getBeratBarang() * banyakBarang;

            // cek apakah barang sudah ada di kerjanjang atau belum
            for(Order b: keranjang) {

                if (b != null) {

                    // jika barang sudah ada di keranjang
                    if (b.getBarang().getNama().equals(barang.getNama())) {

                        // tambah jumlah yg ada di keranjang
                        b.setBanyakBarang(b.getBanyakBarang() + banyakBarang);

                        // mengurangi stok barang yg dibeli
                        barang.setStock(barang.getStock() - banyakBarang);
                        return output;
                    }
                }
            }
            
            // jika barang belum ada di keranjang
            for (int i=0; i<this.keranjang.length; i++){
                if (this.keranjang[i] != null) {
                    continue;
                } else {
                    Order newOrder = new Order(barang, banyakBarang);
                    this.keranjang[i] = newOrder;
                    break;
                }
            }

            // mengurangi stok barang yg dibeli
            barang.setStock(barang.getStock() - banyakBarang);
            return output;
        }

        // jika stok barang tidak cukup
        return ("Stok " + barang.getNama() + " kurang\n");
    }
    
    // TODO: lengkapi method di bawah ini
    // mendapatkan total harga barang
    int totalHargaBarang(){
        int totalHarga = 0;
        for (Order b: keranjang) {
            if (b != null) {
                totalHarga += b.getBarang().getHarga() * b.getBanyakBarang();
            }
        }
        return totalHarga;
    }
    
    // TODO: lengkapi method di bawah ini
    String cekUang(){
        return "Uang " + nama + " sekarang " + uang + "\n";
    }

    // Setter and Getter dan lengkapi modifier
    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUang() {
        return this.uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public Order[] getKeranjang() {
        return keranjang;
    }

    // untuk mereset keranjang menjadi kosong
    void resetKeranjang() {
        for (int i=0; i<this.keranjang.length; i++){
            this.keranjang[i] = null;
        }
    }
    
    // untuk mereset kapasitas keranjang menjadi 5000
    void resetKapasitasKeranjang(){
        this.kapasitasKeranjang = 5000;
    }
}