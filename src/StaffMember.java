abstract class StaffMember {
    int id;
    String name;
    String address;

    StaffMember(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    abstract double pay();

    public String toString() {
        return "ID : " + id + " | Name : " + name + " | Address : " + address;
    }
}
