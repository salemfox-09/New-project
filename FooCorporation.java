import java.util.Scanner;  

public class FooCorporation {
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
            System.out.println("Overtime pay: $" + overtimePay);
        }

         System.out.println("Employee: " + name);
        System.out.println("Weekly pay: $" + weeklyPay);
        System.out.println("--------------------------");
    }
}
