import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {

        List<Employee> employees = createEmployees();

        System.out.println("Исходный список сотрудников:");
        employees.forEach(System.out::println);

        List<Employee> sortedEmployees =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary))
                        .toList();

        System.out.println("\nСотрудники, отсортированные по зарплате:");
        sortedEmployees.forEach(System.out::println);
    }

    public static ArrayList<Employee> createEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Иванов Иван", 30, "Cooking", 85000.0));
        employees.add(new Employee("Петров Петр", 28, "HR", 60000.0));
        employees.add(new Employee("Сидоров Сидр", 35, "Fishing", 200000.0));
        employees.add(new Employee("Кузнецов Кузнец", 40, "IT", 120000.0));
        employees.add(new Employee("Смирнова Смирна", 26, "Marketing", 70000.0));

        return employees;
    }
}