package employee_management_system;
import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RemoveEmployee extends JFrame implements ActionListener {

    protected ArrayList<Employee> employees;  // Reference to the employee list
    private DefaultTableModel tableModel;  // Reference to the table model

    private JTable employeeTable;  // JTable to display employee details

    private JButton backButton, editButton;  // Buttons for back and edit

    public RemoveEmployee(ArrayList<Employee> employees) {
        this.employees = employees;  // Store reference to the employee list

        this.getContentPane().setBackground(Color.pink);

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

        editButton = new JButton("Delete");
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
            this.dispose();  // Close the ViewEmployee window
            new MainClass();
        } else if (e.getSource() == editButton) {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {  // Check if a row is selected
                try {
                    // Get selected cell values and update employee object

                    this.employees.remove(selectedRow);
                    AddEmployee.setEmployees(this.employees);


                    tableModel.fireTableDataChanged();


                    JOptionPane.showMessageDialog(null, "Employee Deleted successfully!");



                    setVisible(false);
                    new MainClass();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid data format for salary. Please enter a number.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to Delete!");
            }
        }
    }
}