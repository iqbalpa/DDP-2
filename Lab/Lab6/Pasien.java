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

		// menambahkan Warga X ke LogInteraksi
		addLogInteraksi(X);

		// jika Warga X adalah Pasien, maka happiness bertambah 5
		if (X instanceof Pasien){
			this.happiness += 5;
			
			// untuk handle apabila happiness > 100 atau < 0
			handleHappiness();
		} 
		// jika Warga X adalah Dokter
		else {

			// jika Pasien masih sakit
			if (!this.pasienSembuh) {

				// jika X adalah Dokter dengan keahlian yg sama dengan penyakit Pasien, maka
				// Pasien akan sembuh dan happiness bertambah 20
				if (((Dokter)X).getPenyakitKeahlian().equals(this.penyakit)){
					this.pasienSembuh = true;
					this.happiness += 20;

					// untuk handle apabila happiness > 100 atau < 0
					handleHappiness();
				}
			}

			// jika X adalah Dokter yg ramah
			if (((Dokter)X).getDokterRamah()){
				this.happiness += 10;

				// untuk handle apabila happiness > 100 atau < 0
				handleHappiness();
			} 
			// jika X adalah Dokter yg tidak ramah
			else {
				this.happiness -= 5;

				// untuk handle apabila happiness > 100 atau < 0
				handleHappiness();
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

	// untuk handle jika happiness > 100 atau < 0
	public void handleHappiness(){
		if (this.happiness > 100){
			this.happiness = 100;
		} else if (this.happiness < 0){
			this.happiness = 0;
		}
	}

}
