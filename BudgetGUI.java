import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetGUI extends JFrame {
    private BudgetManager budgetManager;
    private JTextField amountField;
    private JTextField sourceAccountField;
    private JTextField destinationAccountField;
    private JButton addButton;
    private JTextArea displayArea;
    private JPanel graphPanel;

    public BudgetGUI() {
        budgetManager = new BudgetManager();

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
        add(destinationAccountLabel);

        destinationAccountField = new JTextField(20);
        destinationAccountField.setBounds(150, 80, 165, 25);
        add(destinationAccountField);

        addButton = new JButton("Add Transaction");
        addButton.setBounds(10, 110, 150, 25);
        add(addButton);

        // Set displayArea to take up 50% of the width
        displayArea = new JTextArea();
        displayArea.setBounds(10, 140, width / 2 - 20, height - 200); // Adjust width and height as needed
        displayArea.setEditable(false);
        add(displayArea);

        // Set graphPanel to take up the other 50% of the width
        graphPanel = new JPanel();
        graphPanel.setBounds(width / 2, 140, width / 2 - 20, height - 200); // Adjust width and height as needed
        graphPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(graphPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
                updateGraph();
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

    private void updateGraph() {
        // Placeholder for graph update logic
        graphPanel.removeAll();
        graphPanel.add(new JLabel("Graph data here"));
        graphPanel.revalidate();
        graphPanel.repaint();
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
