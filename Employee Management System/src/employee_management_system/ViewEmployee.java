package employee_management_system;
import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
public class ViewEmployee extends JFrame {

    ViewEmployee(){
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20,20,150,20);
        this.setSize(900,700);
        this.setLayout(null);
        this.setLocation(300,100);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new ViewEmployee();

    }
}

 */
/*
public class ViewEmployee extends JFrame implements ActionListener {

    private ArrayList<Employee> employees;  // Reference to the employee list

    private JTable employeeTable;  // JTable to display employee details

    private JButton backButton;  // Button to return to the main menu

    public ViewEmployee(ArrayList<Employee> employees) {
        this.employees = employees;  // Store reference to the employee list

        this.getContentPane().setBackground(Color.yellow);

        JLabel titleLabel = new JLabel("Employee List", JLabel.CENTER);
        titleLabel.setFont(new Font("serif", Font.BOLD, 20));
        titleLabel.setBounds(200, 30, 500, 50);
        this.add(titleLabel);

        // Create table model with column names
        String[] columnNames = {"Name", "ID", "Designation", "Salary", "Phone", "Email", "Father's Name", "NID", "DOB", "Address", "Education"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Add employee data to table model
        for (Employee employee : employees) {
            String[] employeeData = {employee.getName(), employee.getId(),
                    employee.getDesignation(), String.valueOf(employee.getSalary()), employee.getPhone(),
                    employee.getEmail(), employee.getFatherName(), employee.getNid(), employee.getDob(),
                    employee.getAddress(), employee.getEducation()};
            tableModel.addRow(employeeData);
        }

        // Initialize JTable with table model
        employeeTable = new JTable(tableModel);
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // Prevent automatic resizing
        employeeTable.setPreferredScrollableViewportSize(new Dimension(1000, 400)); // Set preferred size

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(50, 100, 1000, 400);
        this.add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(450, 550, 150, 40);
        backButton.addActionListener(this);
        this.add(backButton);

        this.setSize(1100, 650);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();  // Close the ViewEmployee window
        }
    }
}
*/

public class ViewEmployee extends JFrame implements ActionListener {

    protected ArrayList<Employee> employees;  // Reference to the employee list
    private DefaultTableModel tableModel;  // Reference to the table model

    private JTable employeeTable;  // JTable to display employee details

    private JButton backButton, editButton;  // Buttons for back and edit

    public ViewEmployee(ArrayList<Employee> employees) {
        this.employees = employees;  // Store reference to the employee list

        this.getContentPane().setBackground(Color.lightGray);

        JLabel titleLabel = new JLabel("Employee List", JLabel.CENTER);
        titleLabel.setFont(new Font("serif", Font.BOLD, 20));
        titleLabel.setBounds(200, 30, 500, 50);
        this.add(titleLabel);

        // Create table model with column names
        String[] columnNames = {"Name", "ID", "Designation", "Salary", "Phone", "Email",
                "Father's Name", "NID", "DOB", "Address", "Education"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Add employee data to table model
        for (Employee employee : employees) {
            String[] employeeData = {employee.getName(), employee.getId(),
                    employee.getDesignation(), String.valueOf(employee.getSalary()), employee.getPhone(),
                    employee.getEmail(), employee.getFatherName(), employee.getNid(), employee.getDob(),
                    employee.getAddress(), employee.getEducation()};
            tableModel.addRow(employeeData);
        }

        // Initialize JTable with table model and allow cell editing
        employeeTable = new JTable(tableModel);
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // Prevent automatic resizing
        employeeTable.setPreferredScrollableViewportSize(new Dimension(1000, 400)); // Set preferred size
        employeeTable.setCellSelectionEnabled(true);  // Enable cell selection
        employeeTable.getTableHeader().setResizingAllowed(true);  // Allow column resizing

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(50, 100, 1000, 400);
        this.add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(450, 550, 150, 40);
        backButton.addActionListener(this);
        this.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(250, 550, 150, 40);
        editButton.addActionListener(this);
        this.add(editButton);

        this.setSize(1100, 650);
        this.setLocation(200,50);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            new MainClass();// Close the ViewEmployee window
        } else if (e.getSource() == editButton) {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {  // Check if a row is selected
                try {


                    // Get selected cell values and update employee object
                    String name = (String) tableModel.getValueAt(selectedRow, 0);
                    String id = (String) tableModel.getValueAt(selectedRow, 1);
                    String designation = (String) tableModel.getValueAt(selectedRow, 2);
                    double salary = Double.parseDouble((String) tableModel.getValueAt(selectedRow, 3));
                    String phone = (String) tableModel.getValueAt(selectedRow, 4);
                    String email = (String) tableModel.getValueAt(selectedRow, 5);
                    String fatherName = (String) tableModel.getValueAt(selectedRow, 6);
                    String nid = (String) tableModel.getValueAt(selectedRow, 7);
                    String dob = (String) tableModel.getValueAt(selectedRow, 8);
                    String address = (String) tableModel.getValueAt(selectedRow, 9);
                    String education = (String) tableModel.getValueAt(selectedRow, 10);

                    // Create a new employee object with updated values
                    Employee updatedEmployee = new Employee(name, fatherName, phone, nid, email, salary, designation, id, dob, address, education);

                    // Update employee data in the list (implementation depends on your system)
                    // This part requires integrating with your chosen persistence method (e.g., file system, database)

                    // Update in-memory list (temporary)
                    this.employees.set(selectedRow, updatedEmployee);
                    AddEmployee.setEmployees(this.employees);


                    // Update table model with new employee data
                    tableModel.setValueAt(name, selectedRow, 0);
                    tableModel.setValueAt(id, selectedRow, 1);
                    tableModel.setValueAt(designation, selectedRow, 2);
                    tableModel.setValueAt(String.valueOf(salary), selectedRow, 3); // Convert salary to String
                    tableModel.setValueAt(phone, selectedRow, 4);
                    tableModel.setValueAt(email, selectedRow, 5);
                    tableModel.setValueAt(fatherName, selectedRow, 6);
                    tableModel.setValueAt(nid, selectedRow, 7);
                    tableModel.setValueAt(dob, selectedRow, 8);
                    tableModel.setValueAt(address, selectedRow, 9);
                    tableModel.setValueAt(education, selectedRow, 10);
                    tableModel.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "Employee edited successfully!");
                    setVisible(false);
                    new MainClass();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid data format for salary. Please enter a number.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to edit!");

            }
        }
    }
}