import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class window implements ActionListener {
    private JButton newWButton;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        window instance = new window() {};

        instance.newWButton = new JButton("New window");
        instance.newWButton.addActionListener(instance);

        mainWindow.add(instance.newWButton);
        mainWindow.setSize(900, 900);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newWButton) {
            System.out.println("New window button clicked");
            JFrame newWindow = new JFrame();
            window instance = new window() {};
            newWindow.setSize(300,300);
            newWindow.setVisible(true);
        }
    }
}