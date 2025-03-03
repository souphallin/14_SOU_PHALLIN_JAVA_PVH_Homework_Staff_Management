public class HourlySalaryEmployee extends StaffMember{
    int hoursWorked;
    double rate;

    public HourlySalaryEmployee(int id, String name, String address, int hoursWorked, double rate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    double pay(){
        return hoursWorked * rate; // return rate * hour to see the payment that employee worked
    }
    public String toString() {
//        return "ID : " + id + " | Name : " + name + " | Address : " + address + " | Worked Hours : " + workedHours + " | Rate : " + rate;
        return "Hourly Salary Employee = " + super.toString() + " | Worked Hour : " + hoursWorked + " | Rate : " + rate + " | Payment : " + pay();
    }
}
