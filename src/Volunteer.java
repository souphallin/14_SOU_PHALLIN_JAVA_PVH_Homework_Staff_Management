public class Volunteer extends StaffMember{
    Double salary;

    Volunteer(int id, String name, String address) {
        super(id, name, address);
    }

    public double pay(){
        return salary = 0.0;  //    return 0 cause volunteer didn't get the salary
    }

    public String toString(){
        return "Volunteer = " + super.toString() + " | Salary : " + pay();
    }
}