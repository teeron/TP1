public class ManutARisque extends Manutentionnaire implements ARisque {

    public ManutARisque(String firstname, String lastname, int age, String entryYear, double base) {
        super(firstname, lastname, age, entryYear, base);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + getPrime();
    }

    @Override
    public double getPrime() {
        return 200;
    }
}
