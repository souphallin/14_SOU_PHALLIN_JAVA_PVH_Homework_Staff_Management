import java.util.Scanner;

public class Main extends StaffManagement{
    public static void main(String[] args) {

        sampleData();
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("\n=====| STAFF MANAGEMENT SYSTEM |=====");
            System.out.println("|=> 1.INSERT EMPLOYEE");
            System.out.println("|=> 2.UPDATE EMPLOYEE");
            System.out.println("|=> 3.DISPLAY EMPLOYEE");
            System.out.println("|=> 4.REMOVE EMPLOYEE");
            System.out.println("|=> 5.EXIT");
            System.out.print("\n|==> CHOOSE AN OPTION (1-5) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    insert(scanner);
                    break;
                case 2:
                    update(scanner);
                    break;
                case 3:
                    display(scanner);
                    break;
                case 4:
                    remove(scanner);
                    break;
                case 5:
                    System.out.println("|==> PROGRAM EXITED..!!!");
                    return;
                default:
                    System.out.println("|==> INVALID CHOICE..!!!");
            }
        }
    }
}