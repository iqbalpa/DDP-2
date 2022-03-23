
public class Obligasi extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double bunga;
	private int maturitas;
	private boolean jatuhTempo = false;
	
	Obligasi(String nama, int jumlah, double harga, double bunga, int maturitas) {
		// TODO lengkapi constructor ini
		super(nama, jumlah, harga);
		this.bunga = bunga;
		this.maturitas = maturitas;
	}
	
	@Override
	void nextYear() {
		// TODO validasi jatuh tempo
		// jika jumlah tahun sama dengan maturitas, maka jatuh tempo akan true
		if (this.getTahun() == this.maturitas){
			this.jatuhTempo = true;
			Pacilnomo.addToEarnings(this.bunga * this.getHarga() * this.getJumlah());
		}
		
		super.nextYear();

		// TODO tambahkan bunga ke total pendapatan Pacilnomo
		// jika belum jatuh tempo, maka akan ditambahkan Bunga ke Earnings
		if (!jatuhTempo){
			Pacilnomo.addToEarnings(this.bunga * this.getHarga() * this.getJumlah());
		}
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		String output = String.format("%s%nTipe: Obligasi%nHarga: %.2f%nJumlah: %d%nBunga: %.2f%nJatuh Tempo: %b", this.getNama(),this.getHarga(), this.getJumlah(), this.bunga, this.jatuhTempo);

		return output;
	}

	// TODO buat getter dan setter untuk fields pada class ini
}
