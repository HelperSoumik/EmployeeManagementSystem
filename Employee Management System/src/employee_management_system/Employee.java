package employee_management_system;

public class Employee {

    private String name;
    private String fatherName;
    private String phone;
    private String nid;
    private String email;
    private double salary;
    private String designation;
    private String id;
    private String dob;
    private String address;
    private String education;

    public Employee(String name, String fatherName, String phone, String nid, String email, double salary,
                    String designation, String id, String dob, String address, String education) {
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
        this.nid = nid;
        this.email = email;
        this.salary = salary;
        this.designation = designation;
        this.id = id;
        this.dob = dob;
        this.address = address;
        this.education = education;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", phone='" + phone + '\'' +
                ", nid='" + nid + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", id='" + id + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
