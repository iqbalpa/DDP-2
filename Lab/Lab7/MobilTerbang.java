public class MobilTerbang extends Mobil{ //TODO: impelementasikan sesuai UML diagram
    
    public MobilTerbang(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        // TODO: Lengkapi Constructor berikut
        super(nama, engineBehaviour, bahanBakar, "Terbang");
    }

    // TODO: Lengkapi method ini
    @Override
    public String isiBahanBakar(){
        if (this.getIsOn()){
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak jatuh.";
        } else {
            this.setPersenFuel(100);
            return String.format("%s sekarang sudah penuh, mobil dapat terbang kembali!", this.getBahanBakar());    
        }
    }

    // TODO: Lengkapi method ini
    @Override
    public String[] simulasi(){
        String[] output = new String[5];
        output[0] = this.start();
        for (int i=0; i<2; i++){
            output[i+1] = this.gas();
        }
        output[3] = this.stop();
        output[4] = this.isiBahanBakar();
        return output;
    }
}