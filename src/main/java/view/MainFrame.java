package view;

import controller.ChangeButtonController;
import controller.LogoutController;
import controller.NewButtonController;
import controller.RemoveButtonController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton newButton;
    private JButton changeButton;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTabbedPane logoutPane;
    private JTextField textField2;
    private JTextField textField3;
    private JTextPane textPane;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel newPasswordLabel;
    private JLabel newPasswordAgainLabel;
    private JPasswordField passwordField3;
    private JButton removeButton;
    private JButton logoutButton;


    public MainFrame()
    {
        setContentPane(mainPanel);
        setTitle("MyAccount");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
       // initMenuBar();
        addListener();
        setVisible(true);



    }
    public void initMenuBar()
    {
        JMenuBar bar = new JMenuBar();

        JMenu m = new JMenu("MyAccount");
        JMenuItem menuItem = new JMenuItem("Beispiel");

          bar.add(m);
          m.add(menuItem);

        setJMenuBar(bar);
    }
    public void addListener()
    {
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPasswordLabel.setVisible(true);
                newPasswordAgainLabel.setVisible(true);
                passwordField1.setVisible(true);
                passwordField2.setVisible(true);
            }
        });
        newButton.addActionListener(new NewButtonController(this));
        changeButton.addActionListener(new ChangeButtonController(this));
        removeButton.addActionListener(new RemoveButtonController(this));
        logoutButton.addActionListener(new LogoutController(this));
    }

    public static void main(String[] args)
    {
        // LoginForm l = new LoginForm();
        MainFrame n = new MainFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JTextPane getTextPane() {
        return textPane;
    }
}
