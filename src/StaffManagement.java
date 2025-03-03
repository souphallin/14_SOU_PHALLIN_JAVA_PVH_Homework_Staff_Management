import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StaffManagement {
    private static final List<StaffMember> staffList = new ArrayList<>();

    private static int idAutoIncrement = 1;

    static void insert(Scanner scanner) {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_WIDE, ShownBorders.SURROUND);
        table.setColumnWidth(0, 35, 50);

        table.addCell("1. VOLUNTEER", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell("2. SALARIES EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell("3. HOURLY EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell("4. BACK", new CellStyle(CellStyle.HorizontalAlign.LEFT));

        System.out.println(table.render());

        System.out.print("\nCHOOSE AN OPTION TO INSERT : ");
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
            Table table = new Table(1, BorderStyle.UNICODE_BOX_WIDE, ShownBorders.SURROUND);
            table.setColumnWidth(0, 35, 50);
            StaffMember staff = optionalStaffMember.get();

            table.addCell("1. NAME", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("2. ADDRESS", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("3. CANCEL", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            System.out.println(table.render());

            System.out.print("\nCHOOSE AN OPTION (1-3) TO UPDATE : ");
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
                    System.out.println("=============================");
                    System.out.println("UPDATE CANCELLED..!!! : ");
                    System.out.println("=============================");

                    break;
                default:
                    System.out.println("Invalid choice..!!");
            }
        }else {
            System.out.println("(ID) not found..!!");
        }
    }

    static void sampleData() {
        staffList.add(new Volunteer(idAutoIncrement++, "KoKoWah", "Phnom Penh"));
        staffList.add(new SalariedEmployee(idAutoIncrement++, "WoEhEh", "Takeo", 300.0, 50.0));
        staffList.add(new HourlySalaryEmployee(idAutoIncrement++, "Ah Loy", "Kampong Som", 50, 10));
    }

    static void display(Scanner scanner){
        System.out.println("\n======| EMPLOYEE LIST |======");
        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 25,35);
        table.setColumnWidth(1, 10,15);
        table.setColumnWidth(2, 15,25);
        table.setColumnWidth(3, 15,25);
        table.setColumnWidth(4, 10,15);
        table.setColumnWidth(5, 10,15);
        table.setColumnWidth(6, 10,15);
        table.setColumnWidth(7, 10,15);
        table.setColumnWidth(8, 10,15);

        table.addCell("TYPE", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("NAME", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("ADDRESS", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("SALARY", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("BONUS", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("HOUR", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("RATE", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("PAYMENT", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        staffList.forEach(staffMember -> {
            if(staffMember instanceof Volunteer) {
                Volunteer volunteer = (Volunteer) staffMember;

                table.addCell(("VOLUNTEER"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(volunteer.id), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(volunteer.name), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(volunteer.address), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(volunteer.salary), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(volunteer.pay()), new CellStyle(CellStyle.HorizontalAlign.CENTER));

            }else if(staffMember instanceof SalariedEmployee) {
                SalariedEmployee salariedEmployee = (SalariedEmployee) staffMember;

                table.addCell(("SALARIED EMPLOYEE"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.id), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.name), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.address), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.salary), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.bonus), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(salariedEmployee.pay()), new CellStyle(CellStyle.HorizontalAlign.CENTER));

            }else {
                HourlySalaryEmployee hourlyEmployee = (HourlySalaryEmployee) staffMember;

                table.addCell(("HOURLY SALARY EMPLOYEE"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.id), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.name), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.address), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(("--"), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.hoursWorked), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.rate), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(hourlyEmployee.pay()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
        });
        System.out.println(table.render());
    }


    static void remove(Scanner scanner) {
        System.out.print("ENTER (ID) TO REMOVE : ");
        int id = scanner.nextInt();

        boolean removed = staffList.removeIf(s -> s.id == id);
        if(removed) {

            System.out.println("=============================");
            System.out.println("REMOVED SUCCESSFULLY");
            System.out.println("=============================");

        }else {
                System.out.println("(ID) NOT FOUND..!!");
        }
    }
}