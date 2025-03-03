import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class Main extends StaffManagement{
    public static void main(String[] args) {

        sampleData();
        Scanner scanner = new Scanner(System.in);

        while (true){
            Table table = new Table(1, BorderStyle.UNICODE_BOX_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            table.setColumnWidth(0, 35, 50);
            table.addCell("STAFF MANAGEMENT SYSTEM", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("1.INSERT EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("2.UPDATE EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("3.DISPLAY EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("4.REMOVE EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.LEFT));
            table.addCell("5.EXIT", new CellStyle(CellStyle.HorizontalAlign.LEFT));

            System.out.println(table.render());
            System.out.print("\n|==> CHOOSE AN OPTION (1-5) : ");
            int choice = scanner.nextInt();
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

                    System.out.println("=============================");
                    System.out.println("|==> PROGRAM EXITED..!!!");
                    System.out.println("=============================");

                    return;
                default:

                    System.out.println("=============================");
                    System.out.println("|==> INVALID CHOICE..!!!");
                    System.out.println("=============================");

            }
        }
    }
}