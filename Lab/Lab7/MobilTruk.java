public class MobilTruk extends Mobil{ //TODO: impelementasikan sesuai UML diagram

    public MobilTruk(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        // TODO: Lengkapi Constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Truk");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){
        if (this.getIsOn()){
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak meledak.";
        } else {
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat digaskeun kembali!", this.getBahanBakar());    
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){
        String[] output = new String[7];
        output[0] = this.start();
        for (int i=0; i<4; i++){
            output[i+1] = this.gas();
        }
        output[5] = this.stop();
        output[6] = this.isiBahanBakar();
        return output;
    }
}