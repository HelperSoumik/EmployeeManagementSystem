package employee_management_system;

import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon img1 = new ImageIcon(getClass().getResource("icons/front.gif"));
        //ImageIcon img1 = new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\front.gif");
        Image img2 = img1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,1170,650);
        this.add(image);


        this.setSize(1170,650);
        this.setLocation(200,50);
        this.setLayout(null);
        this.setVisible(true);

        try{
            Thread.sleep(5000);
            this.setVisible(false);
            new Login();

        }catch (Exception e){
            e.printStackTrace();
        }


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Splash();

    }
}
