public class Pasien extends Warga {
	// TODO: Ubah modifier atribut pada class Pasien agar code menjadi lebih aman
	private int happiness;
	private String penyakit;
	private boolean pasienSembuh;

	// TODO: Lengkapi constructor
	Pasien(String nama, String penyakit) {
		super(nama);
		this.penyakit = penyakit;
		this.happiness = 0;
		this.pasienSembuh = false;
	}

	// TODO: Lengkapi method berinteraksi untuk pasien
	@Override
	public void berinteraksi(Warga X) {
		if ((Pasien)X instanceof Pasien){
			this.happiness += 5;
		} else {
			if (((Dokter)X).getDokterRamah()){
				this.happiness += 10;
			} else {
				this.happiness -= 5;
			}
		}
	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getHappiness() {
		return this.happiness;
	}

	public boolean getStatusSembuh() {
		return this.pasienSembuh;
	}

	public String getPenyakit() {
		return this.penyakit;
	}

}
