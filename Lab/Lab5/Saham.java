
public class Saham extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double dividen;
	private double pertumbuhan;
	
	Saham(String nama, int jumlah, double harga, double pertumbuhan, double dividen) {
		super(nama, jumlah, harga);
		this.dividen = dividen;
		this.pertumbuhan = pertumbuhan;
	}

	@Override
	void nextYear() {
		super.nextYear();
		grow();
		
		// TODO modifikasi harga sesuai dengan pertumbuhan sekarang dan tambahkan dividen ke earnings
		Pacilnomo.addToEarnings(this.dividen * this.getHarga() * this.getJumlah());
		double newHarga = this.pertumbuhan * this.getHarga();
		this.setHarga(newHarga);
	}

	// Linear congruential generator for subsequent growth
	void grow() {
		int a = 0x4b;
		int c = 0x4a;
		int m = 2;
		pertumbuhan = ((a * pertumbuhan + c) % m) - 1;
		pertumbuhan = pertumbuhan < 0 ? pertumbuhan % -m : pertumbuhan;
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		String output = String.format("Tipe: Saham%nHarga: %.2f%nJumlah: %d%nDividen: %.2f%nPertumbuhan: %.2f", this.getHarga(), this.getJumlah(), this.dividen, this.pertumbuhan);

		return output;
	}

	// TODO buat getter dan setter untuk fields pada class ini
}
