public class Manutentionnaire extends Employee {

    public static final double PRICE_PER_HOUR = 65;
    private final double hours;

    public Manutentionnaire(String firstname, String lastname, int age, String entryYear, double hours) {
        super(firstname, lastname, age, entryYear);
        this.hours = hours;
    }

    @Override
    public double calculerSalaire() {
        return PRICE_PER_HOUR * (double) hours;
    }

    @Override
    public String getPosition() {
        return "Le manut.";
    }
}
