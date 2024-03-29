public class MobilAir extends Mobil { //TODO: impelementasikan sesuai UML diagram
  
    public MobilAir(String nama, EngineBehaviour engineBehaviour, String bahanBakar){
        // TODO: Lengkapi constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Air");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){

        // jika mobil masih menyala
        if (this.getIsOn()){
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak tenggelam.";
        } 
        // jka mobil sudah mati
        else {

            // set persenFuel ke 100%
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat digunakan kembali!", this.getBahanBakar());
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){

        // output berisi string-string dari fungsi start, gas, stop, isiBahanBakar
        String[] output = new String[8];
        output[0] = this.start();
        for (int i=0; i<5; i++){
            output[i+1] = this.gas();
        }
        output[6] = this.stop();
        output[7] = this.isiBahanBakar();
        return output;
    }   
}