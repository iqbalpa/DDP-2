public class Dokter extends Warga {
	// TODO: Ubah modifier atribut pada class Dokter agar code menjadi lebih aman
	private int jumlahPasienDitemui;
	private String penyakitKeahlian;
	private boolean dokterRamah;
	
	// TODO: Lengkapi constructor
	Dokter(String nama, String keahlian, String keramahan) {
		super(nama);
		this.penyakitKeahlian = keahlian;
		this.jumlahPasienDitemui = 0;
		if (keramahan.equals("Yes")){
			this.dokterRamah = true;
		} else {
			this.dokterRamah = false;
		}
	}

	// TODO: Lengkapi method berinteraksi untuk dokter
	@Override
	public void berinteraksi(Warga X){
		if (X instanceof Pasien){
			this.jumlahPasienDitemui++;
		}
	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getJumlahPasienDitemui(){
		return this.jumlahPasienDitemui;
	}

	public String getPenyakitKeahlian(){
		return this.penyakitKeahlian;
	}

	public boolean getDokterRamah(){
		return this.dokterRamah;
	}

}
