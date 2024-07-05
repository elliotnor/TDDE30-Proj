import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetGUI extends JFrame {
    private BudgetManager budgetManager;
    private JTextField amountField;
    private JTextField sourceAccountField;
    private JTextField destinationAccountField;
    private JButton addButton;
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private JPanel graphPanel;

    public BudgetGUI() {
        budgetManager = new BudgetManager(new User("John Doe", 1000.0));

        setTitle("Budgetizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.85); // 85% of screen width
        int height = (int) (screenSize.height * 0.85); // 85% of screen height
        setSize(width, height);
        setLocationRelativeTo(null); // Center the window

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 20, 80, 25);
        add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(150, 20, 165, 25);
        add(amountField);

        JLabel sourceAccountLabel = new JLabel("Source Account:");
        sourceAccountLabel.setBounds(10, 50, 120, 25);
        add(sourceAccountLabel);

        sourceAccountField = new JTextField(20);
        sourceAccountField.setBounds(150, 50, 165, 25);
        add(sourceAccountField);

        JLabel destinationAccountLabel = new JLabel("Destination Account:");
        destinationAccountLabel.setBounds(10, 80, 150, 25);
        add(destinationAccountField);

        destinationAccountField = new JTextField(20);
        destinationAccountField.setBounds(150, 80, 165, 25);
        add(destinationAccountField);

        JButton addButton = new JButton("Add Transaction");
        addButton.setBounds(10, 110, 150, 25);
        add(addButton);

        // Savings Goals Components
        JLabel goalNameLabel = new JLabel("Savings Goal Name:");
        goalNameLabel.setBounds(10, 140, 150, 25);
        add(goalNameLabel);

        JTextField goalNameField = new JTextField(20);
        goalNameField.setBounds(150, 140, 165, 25);
        add(goalNameField);

        JLabel goalAmountLabel = new JLabel("Target Amount:");
        goalAmountLabel.setBounds(10, 170, 150, 25);
        add(goalAmountLabel);

        JTextField goalAmountField = new JTextField(10);
        goalAmountField.setBounds(150, 170, 165, 25);
        add(goalAmountField);

        JButton addGoalButton = new JButton("Add Goal");
        addGoalButton.setBounds(10, 200, 150, 25);
        add(addGoalButton);

        addGoalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = goalNameField.getText();
                double targetAmount = Double.parseDouble(goalAmountField.getText());
                SavingsGoal goal = new SavingsGoal(name, targetAmount);
                budgetManager.getUser().addSavingsGoal(goal);
                // Update the UI to reflect the new goal
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BudgetGUI();
    }
}