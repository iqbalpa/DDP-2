
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
		if (this.getTahun() == this.maturitas){
			this.jatuhTempo = true;
		}
		
		if (!jatuhTempo){
			super.nextYear();
			// TODO tambahkan bunga ke total pendapatan Pacilnomo
			Pacilnomo.addToEarnings(this.bunga * this.getHarga() * this.getJumlah());
		}
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		String output = String.format("Tipe: Obligasi%nHarga: %.2f%nJumlah: %d%nBunga: %.2f%nJatuh Tempo: %b", this.getHarga(), this.getJumlah(), this.bunga, this.jatuhTempo);

		return output;
	}

	// TODO buat getter dan setter untuk fields pada class ini
}
