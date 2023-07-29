import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame {
    private DoublyLinkedList studentList;

    // GUI components
    private JTextField idField;
    private JTextField nameField;
    private JTextField fieldField;
    private JTextField semesterField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextArea outputArea;

    public StudentRegistrationForm() {
        studentList = new DoublyLinkedList();

        // Create GUI components
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(10);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);

        JLabel fieldLabel = new JLabel("Field:");
        fieldField = new JTextField(10);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterField = new JTextField(10);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(10);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(10);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton addFirstButton = new JButton("Add First");
        addFirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentFirst();
            }
        });

        JButton addLastButton = new JButton("Add Last");
        addLastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentLast();
            }
        });

        JButton addPositionButton = new JButton("Add Position");
        addPositionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentPosition();
            }
        });

        JButton removeFirstButton = new JButton("Remove First");
        removeFirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeFirstStudent();
            }
        });

        JButton removeLastButton = new JButton("Remove Last");
        removeLastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeLastStudent();
            }
        });

        JButton removePositionButton = new JButton("Remove Position");
        removePositionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudentPosition();
            }
        });

        outputArea = new JTextArea(25, 100);
        outputArea.setEditable(false);

        // Create layout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2));
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(fieldLabel);
        inputPanel.add(fieldField);
        inputPanel.add(semesterLabel);
        inputPanel.add(semesterField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(phoneNumberLabel);
        inputPanel.add(phoneNumberField);
        inputPanel.add(addButton);
        inputPanel.add(addFirstButton);
        inputPanel.add(addLastButton);
        inputPanel.add(addPositionButton);

        JPanel removePanel = new JPanel();
        removePanel.setLayout(new GridLayout(1, 3));
        removePanel.add(removeFirstButton);
        removePanel.add(removeLastButton);
        removePanel.add(removePositionButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(removePanel, BorderLayout.SOUTH);

        setTitle("Student Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String field = fieldField.getText();
        String semester = semesterField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        Student student = new Student(id, name, field, semester, email, phoneNumber);
        studentList.addLast(student);

        displayStudents();
        clearFields();
    }

    private void addStudentFirst() {
        String id = idField.getText();
        String name = nameField.getText();
        String field = fieldField.getText();
        String semester = semesterField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        Student student = new Student(id, name, field, semester, email, phoneNumber);
        studentList.addFirst(student);

        displayStudents();
        clearFields();
    }

    private void addStudentLast() {
        addStudent();
    }

			
    private void addStudentPosition() {
    String id = idField.getText();
    String name = nameField.getText();
    String field = fieldField.getText();
    String semester = semesterField.getText();
    String email = emailField.getText();
    String phoneNumber = phoneNumberField.getText();

    // Show a message box to input the position
    String positionStr = JOptionPane.showInputDialog(this, "Enter the position:");

    try {
        int position = Integer.parseInt(positionStr);

        Student student = new Student(id, name, field, semester, email, phoneNumber);
        studentList.addAtPosition(student, position);

        displayStudents();
        clearFields();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid position entered!");
    }
}

    private void removeFirstStudent() {
        studentList.removeFirst();

        displayStudents();
        clearFields();
    }

    private void removeLastStudent() {
        studentList.removeLast();

        displayStudents();
        clearFields();
    }

   private void removeStudentPosition() {
    // Show a message box to input the position
    String positionStr = JOptionPane.showInputDialog(this, "Enter the position you want to remove:");

    try {
        int position = Integer.parseInt(positionStr);
        studentList.removeAtPosition(position);

        displayStudents();
        clearFields();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid position entered!");
    }
}


    private void displayStudents() {
        outputArea.setText("");
        DoublyLinkedList.Node current = studentList.getHead();
        while (current != null) {
            Student student = current.getStudent();
            outputArea.append("ID: " + student.getId() + "\n");
            outputArea.append("Name: " + student.getName() + "\n");
            outputArea.append("Field: " + student.getField() + "\n");
            outputArea.append("Semester: " + student.getSemester() + "\n");
            outputArea.append("Email: " + student.getEmail() + "\n");
            outputArea.append("Phone Number: " + student.getPhoneNumber() + "\n\n");
            current = current.getNext();
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        fieldField.setText("");
        semesterField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        idField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistrationForm();
            }
        });
    }
}
