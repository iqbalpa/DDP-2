abstract class Mobil {
    private String nama;
    private int persenFuel;
    private String bahanBakar;
    private String jenis;
    private EngineBehaviour engineBehaviour;
    private boolean isOn;

    protected Mobil (String nama, EngineBehaviour engineBehaviour, String bahanBakar, String jenis){
        // TODO: Lengkapi constructor berikut
        this.nama = nama;
        this.persenFuel = 100;
        this.bahanBakar = bahanBakar;
        this.jenis = jenis;
        this.engineBehaviour = engineBehaviour;
        this.isOn = false;
    }

    // TODO: Lengkapi method ini
    public String start(){
        this.isOn = true;

        // memanggil fungsi start di EngineBehaviour dan mereturn output string yg sesuai
        return this.engineBehaviour.start(this);
    }

    // TODO: Lengkapi method ini
    public String gas(){

        // jika mobil sudah menyala
        if (this.isOn){

            // jika bensin habis
            if (this.persenFuel == 0){
                return "Bensin habis!";
            } 
            // jika bensin masih ada
            else {

                // bensin berkurang sesuai EngineBehaviour
                this.setPersenFuel(this.engineBehaviour.gas(this.persenFuel));
                String Z = "";

                // jika jenis adalah Air, maka ngegas di Laut
                if (this.jenis.equals("Air")){
                    Z = "Laut";
                } 
                // jika jenis adalah Terbang, maka ngegas di Langit
                else if (this.jenis.equals("Terbang")){
                    Z = "Langit";
                } 
                // jika jenis adalah Truk, maka ngegas di Raya
                else {
                    Z = "Raya";
                }
                return String.format("%s digas dengan cepat di %s! Bahan bakar mobil %s sekarang %d", this.nama, Z, this.bahanBakar, this.persenFuel) + "%.";
            }
        } 
        // jika mobil belum menyala
        else {
            return "Nyalakan mobil dulu!";
        }
    }
  
    // TODO: Lengkapi method ini
    public String stop(){
        this.isOn = false;

        // memanggil fungsi stop di EngineBehavior dan mereturn string yg sesuai
        return this.engineBehaviour.stop(this);
    }
  
    public abstract String isiBahanBakar();
    public abstract String[] simulasi();

    // Getter & Setter
    public String getNama() {
        return nama; 
    }

    public int getPersenFuel() {
        return persenFuel; 
    }

    public void setPersenFuel(int persenFuel) {
        this.persenFuel = persenFuel;
    }

    public String getBahanBakar() {
        return bahanBakar; 
    }
  
    public boolean getIsOn() {
        return isOn; 
    }

}