public class SalariedEmployee extends StaffMember{
    double salary;
    double bonus;

    SalariedEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }
    double pay(){
        return salary + bonus; // if Employees have bonus return salary + bonus
    }

    public String toString() {
//        return "ID : " + id + " | Name : " + name + " | Address : " + address + " | Salary : " + salary + " | Bonus : " + bonus;
        return "Salary Employee = " + super.toString() + " | Salary: " + salary + " | Bonus: " + bonus + " | Payment : " + pay();
    }
}
