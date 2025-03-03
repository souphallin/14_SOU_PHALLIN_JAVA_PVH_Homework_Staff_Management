import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class StaffManagement {
//    private static Scanner scanner = new Scanner(System.in);
    private static final List<StaffMember> staffList = new ArrayList<>();

    private static int idAutoIncrement = 1;

    static void insert(Scanner scanner) {
        System.out.println("\n1. VOLUNTEER");
        System.out.println("2. SALARIES EMPLOYEE");
        System.out.println("3. HOURLY EMPLOYEE");
        System.out.println("4. BACK");
        System.out.print("CHOOSE AN OPTION TO INSERT : ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("\nVOLUNTEER NAME : ");
                String name = scanner.next();
                System.out.print("VOLUNTEER ADDRESS : ");
                String address = scanner.next();
                staffList.add(new Volunteer(idAutoIncrement++, name, address));
                break;
            case 2:
                System.out.print("SALARIED EMPLOYEE NAME : ");
                String name1 = scanner.next();
                System.out.print("SALARIED EMPLOYEE ADDRESS : ");
                String address1 = scanner.next();
                System.out.print("SALARIED EMPLOYEE SALARY : ");
                double salary = scanner.nextDouble();
                System.out.print("SALARIED EMPLOYEE BONUS : ");
                double bonus = scanner.nextDouble();
                staffList.add(new SalariedEmployee(idAutoIncrement++, name1, address1, salary, bonus));
                break;
            case 3:
                System.out.print("HOURLY SALARY EMPLOYEE NAME : ");
                String name2 = scanner.next();
                System.out.print("HOURLY SALARY EMPLOYEE ADDRESS : ");
                String address2 = scanner.next();
                System.out.print("HOURLY SALARY EMPLOYEE WORKED HOUR : ");
                int hour = scanner.nextInt();
                System.out.print("HOURLY SALARY EMPLOYEE RATE : ");
                double rate = scanner.nextDouble();
                staffList.add(new HourlySalaryEmployee(idAutoIncrement++, name2, address2, hour, rate));
                break;
            case 4:
                System.out.println("=============================");
                System.out.println("CANCELLED..!!!");
                System.out.println("=============================");
                break;
            default:
                System.out.println("Invalid choice..!!");
        }
    }
    static void update(Scanner scanner) {
        System.out.print("INPUT (ID) TO UPDATE : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<StaffMember> optionalStaffMember = staffList.stream().filter(s -> s.id == id).findFirst();
        if(optionalStaffMember.isPresent()) {
            StaffMember staff = optionalStaffMember.get();

            System.out.println("1. NAME");
            System.out.println("2. ADDRESS");
            System.out.println("3. CANCEL");
            System.out.print("CHOOSE AN OPTION (1-3) TO UPDATE : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("NAME : ");
                    staff.name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("ADDRESS : ");
                    staff.address = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("UPDATE CANCELLED..!!! : ");
                    break;
                default:
                    System.out.println("Invalid choice..!!");
            }
        }else {
            System.out.println("(ID) not found..!!");
        }
    }


    static void display(Scanner scanner){
        staffList.add(new Volunteer(idAutoIncrement++, "KoKoWah", "Phnom Penh"));
        staffList.add(new SalariedEmployee(idAutoIncrement++, "WoEhEh", "Takeo", 300.0, 50.0));
        staffList.add(new HourlySalaryEmployee(idAutoIncrement++, "Ah Loy", "Kampong Som", 50, 10));

        System.out.println("\n======| EMPLOYEE LIST |======");
        staffList.forEach(staffMember -> System.out.println(staffMember.toString()));
    }
    static void remove(Scanner scanner) {

    }
}