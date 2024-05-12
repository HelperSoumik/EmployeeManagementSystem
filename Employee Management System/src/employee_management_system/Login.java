package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;
    private String usr = "admin";
    private String pass ="admin";
    Login(){
        JLabel username =new JLabel("Username");
        username.setBounds(40,20,100,30);
        this.add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        this.add(tusername);

        JLabel password =new JLabel("Password");
        password.setBounds(40,70,100,30);
        this.add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        this.add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        this.add(login);

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        this.add(back);

        ImageIcon i11 = new ImageIcon(getClass().getResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image1 = new JLabel(i33);
        image1.setBounds(350,10,600,400);
        this.add(image1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,300);
        this.add(image);

        this.setSize(600,300);
        this.setLocation(450,200);
        this.setLayout(null);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            if(tusername.getText().equals(usr)  && tpassword.getText().equals(pass)){
                setVisible(false);
                new MainClass();

            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            }

        }
        else if(e.getSource() == back){
            System.exit(54);
        }
    }
}
