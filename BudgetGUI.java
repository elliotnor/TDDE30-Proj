import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
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

        // Set up the transaction table
        String[] columnNames = {"Amount", "Source Account", "Destination Account"};
        tableModel = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(tableModel);
        transactionTable.setGridColor(Color.BLACK); // Set grid color
        transactionTable.setShowVerticalLines(true); // Ensure vertical lines are shown
        transactionTable.setIntercellSpacing(new Dimension(1, 1)); // Add spacing between cells for better visibility

        // Custom renderer for thicker vertical lines
        transactionTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column < table.getColumnCount() - 1) {
                    ((JComponent) cell).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK)); // Vertical line on the right
                } else {
                    ((JComponent) cell).setBorder(BorderFactory.createEmptyBorder()); // No border for the last column
                }
                return cell;
            }
        });

        // Custom header renderer for larger text and horizontal line
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 14)); // Larger and bold text
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center text
                headerLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Bottom border
                return headerLabel;
            }
        };
        for (int i = 0; i < transactionTable.getColumnModel().getColumnCount(); i++) {
            transactionTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(10, 140, width / 2 - 20, height - 200);
        add(scrollPane);

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

            // Add transaction data to the table
            tableModel.addRow(new Object[]{amount, sourceAccountName, destinationAccountName});
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
