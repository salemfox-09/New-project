import java.util.ArrayList;
import java.util.Scanner;  

class Employee {
    private String name;
    private int hoursWorked;
    private double weeklyPay;

    // Constructor es lo que se llama para crear un nuevo objeto de la clase Employee
    public Employee(String name, int hoursWorked, double weeklyPay) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.weeklyPay = weeklyPay;
    }

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getWeeklyPay() {
        return weeklyPay;
    }

    public String toString() {
        return "Employee: " + name + ", Hours Worked: " + hoursWorked + ", Weekly Pay: $" + weeklyPay;
    }

}

public class FooCorporation {

    private static ArrayList<Employee> employeesList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        boolean continueProgram = true; 
        
        while (continueProgram) {
            System.out.println("Enter employee name:");
            String name = inputScanner.next();

            System.out.println("Enter how many hours you work this week:");
            int hoursWorked = inputScanner.nextInt();

            printWeeklyPay(name, hoursWorked);

            System.out.println("Do you want to calculate another employee? (yes/no)");
            String answer = inputScanner.next();

            if (answer.equalsIgnoreCase("no")) {
                continueProgram = false;
            }
        }

        showAllEmployees();

        inputScanner.close();
    }

    

   public static void printWeeklyPay(String name, int hoursWorked) {
        double hourlyRate = 8.0;
        
        // Validar PRIMERO los errores
        if (hoursWorked > 60) {
            System.out.println("Error: Hours worked cannot exceed 60.");
            return; // Salir del método sin calcular nada
        }
        else if (hoursWorked <= 0) {
            System.out.println("Error: Hours worked cannot be negative.");
            return; // Salir del método sin calcular nada
        }
        
        // Si llegamos aquí, los datos son válidos
        double weeklyPay = hoursWorked * hourlyRate;

        if (hoursWorked > 40) {
            int overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * hourlyRate * 0.5; // Solo el extra
            weeklyPay += overtimePay;
            System.out.println("Employee: " + name);
            System.out.println("Overtime pay: $" + overtimePay);
        }

         System.out.println("Employee: " + name);
        System.out.println("Weekly pay: $" + weeklyPay);
        System.out.println("--------------------------");

        Employee newEmployee = new Employee(name, hoursWorked, weeklyPay);
        employeesList.add(newEmployee);
        System.out.println("Employee added to the list!");

         
    }

    public static void showAllEmployees() {
        System.out.println("\n========== LIST OF ALL EMPLOYEES ==========");
        
        if (employeesList.isEmpty()) {
            System.out.println("No employees registered.");
        } else {
            double totalPays = 0;
            
            for (int i = 0; i < employeesList.size(); i++) {
                System.out.println((i + 1) + ". " + employeesList.get(i));
                totalPays += employeesList.get(i).getWeeklyPay();
            }
            
            System.out.println("\nTotal employees: " + employeesList.size());
            System.out.println("Total payroll: $" + totalPays);
        }
        
        System.out.println("==========================================");
    }
}

// El programa solicita el nombre del empleado y las horas trabajadas, luego calcula el pago semanal considerando las horas extras. Si se ingresan horas inválidas, muestra un mensaje de error y no realiza el cálculo. El programa continúa hasta que el usuario decida salir.