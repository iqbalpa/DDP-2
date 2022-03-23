
public class Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private String nama;
	private int jumlah;
	private double harga;
	private int tahun = 0;
	
	Aset(String nama, int jumlah, double harga) {
		// TODO lengkapi constructor ini
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;
	}
	
	// Increment tahun
	void nextYear() {
		this.tahun++;
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public String getNama(){
		return this.nama;
	}
	public int getJumlah(){
		return this.jumlah;
	}
	public double getHarga(){
		return this.harga;
	}
	public int getTahun(){
		return this.tahun;
	}

	public void setHarga(double newHarga){
		this.harga = newHarga;
	}
}
