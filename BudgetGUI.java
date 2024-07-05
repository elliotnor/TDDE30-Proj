import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetGUI extends JFrame {
    private BudgetManager budgetManager;
    private JTextField amountField;
    private JTextField sourceAccountField;
    private JTextField destinationAccountField;
    private JButton addButton;
    private JTextArea displayArea;

    public BudgetGUI() {
        budgetManager = new BudgetManager();

        setTitle("Budgetizer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

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
        add(destinationAccountLabel);

        destinationAccountField = new JTextField(20);
        destinationAccountField.setBounds(150, 80, 165, 25);
        add(destinationAccountField);

        addButton = new JButton("Add Transaction");
        addButton.setBounds(10, 110, 150, 25);
        add(addButton);

        displayArea = new JTextArea();
        displayArea.setBounds(10, 140, 460, 200);
        displayArea.setEditable(false);
        add(displayArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
    }

    private void addTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String sourceAccountName = sourceAccountField.getText();
            String destinationAccountName = destinationAccountField.getText();

            // Create Account objects with default initial balance
            double initialBalance = 0.0;
            Account sourceAccount = new Account(sourceAccountName, initialBalance);
            Account destinationAccount = new Account(destinationAccountName, initialBalance);

            // Create a TransferTransaction with the correct constructor
            TransferTransaction transaction = new TransferTransaction(sourceAccount, destinationAccount, amount, sourceAccountName, destinationAccountName);

            budgetManager.addTransaction(transaction);

            displayArea.setText("Transaction added:\n" + transaction.toString());
        } catch (NumberFormatException ex) {
            displayArea.setText("Invalid amount");
        } catch (Exception ex) {
            displayArea.setText("Error: " + ex.getMessage());
        }
    }



    private void displayTransactions() {
        StringBuilder displayText = new StringBuilder();
        for (Transaction transaction : budgetManager.getTransactions()) {
            displayText.append(transaction).append("\n");
        }
        displayArea.setText(displayText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BudgetGUI().setVisible(true);
            }
        });
    }
}
