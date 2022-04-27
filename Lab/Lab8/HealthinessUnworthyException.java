public class HealthinessUnworthyException extends Exception {
    public HealthinessUnworthyException(String nama) {
        super(nama + ": TIDAK LAYAK");
    }
}