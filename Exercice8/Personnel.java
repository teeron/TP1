

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personnel implements Serializable {

    private List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public Personnel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public void afficherSalaires() {
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public void getSize(){
        System.out.println("Employe size : " + employees.size());
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: employees) {
            total += employee.calculerSalaire();
        }
        return total / employees.size();
    }
}
