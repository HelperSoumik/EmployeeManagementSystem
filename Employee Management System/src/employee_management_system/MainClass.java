package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame implements ActionListener{
    JButton add,rem,view;
    MainClass(){
        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        this.add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(this);
        img.add(add);

        view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(this);
        img.add(view);

        rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(this);
        img.add(rem);



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1120,630);
        this.setLocation(250,100);
        this.setLayout(null);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new MainClass();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            new AddEmployee();
            this.setVisible(false);
        }
        else if(e.getSource() == view){
            new ViewEmployee(AddEmployee.getEmployees());
            this.setVisible(false);
        }
        else{
            new RemoveEmployee(AddEmployee.getEmployees());
            this.setVisible(false);
        }

    }
}
