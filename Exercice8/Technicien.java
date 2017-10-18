public class Technicien extends Employee {

    private final double units;
    private final double UNIT_PRICE = 5;

    public Technicien(String firstname, String lastname, int age, String entryYear, double units) {
        super(firstname, lastname, age, entryYear);
        this.units = units;
    }

    @Override
    public double calculerSalaire() {
        return (double) units * UNIT_PRICE;
    }

    @Override
    public String getPosition() {
        return "Le technicien";
    }
}
