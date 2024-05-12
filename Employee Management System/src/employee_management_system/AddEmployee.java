package employee_management_system;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
    protected static ArrayList<Employee> employees = new ArrayList<>();

    JTextField tname,tfname,taddress,tphone,tnid,temail,tsalary,tdesignation;
    JLabel tempid;
    JTextField dobd,dobm,doby;
    JButton add,back;
    JComboBox Boxeducation;



    AddEmployee(){

        this.getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        this.add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        this.add(tname);


        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        this.add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(dob);

        dobd = new JTextField();
        dobd.setBounds(200,200,50,30);
        dobd.setBackground(new Color(177,252,197));
        this.add(dobd);

        dobm = new JTextField();
        dobm.setBounds(250,200,50,30);
        dobm.setBackground(new Color(177,252,197));
        this.add(dobm);

        doby = new JTextField();
        doby.setBounds(300,200,50,30);
        doby.setBackground(new Color(177,252,197));
        this.add(doby);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        this.add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        this.add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        this.add(tphone);


        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        this.add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(education);

        String []items = new String[]{"BBA","B.Tech","BSC","BCA","BA","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        this.add(Boxeducation);

        JLabel nid = new JLabel("NID");
        nid.setBounds(400,350,150,30);
        nid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(nid);

        tnid = new JTextField();
        tnid.setBounds(600,350,150,30);
        tnid.setBackground(new Color(177,252,197));
        this.add(tnid);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        this.add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        this.add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        this.add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        this.add(add);

        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        this.add(back);









        this.setSize(900,700);
        this.setLocation(200,50);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        AddEmployee.employees = employees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{if(e.getSource() == add){

            String dob = dobd.getText()+"/"+dobm.getText()+"/"+doby.getText();
            double salary = Double.parseDouble(tsalary.getText());
            String edu = (String) Boxeducation.getSelectedItem();
            Employee employee = new Employee(tname.getText(),tfname.getText(),tphone.getText(),tnid.getText(),tempid.getText(),salary,tdesignation.getText(),tempid.getText(),dob,taddress.getText(),edu);
            JOptionPane.showMessageDialog(null, "Employee added successfully!");
            employees.add(employee);
            setVisible(false);
            new MainClass();

        }
        else {
            setVisible(false);
            new MainClass();
        }}catch(Exception E){
            JOptionPane.showMessageDialog(null,"Fill All Details");
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }


}
