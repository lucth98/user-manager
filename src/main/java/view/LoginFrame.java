package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private JTextField textField1;
    private JButton loginButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel welcomeLabel;


    public LoginFrame()
    {
        setSize(500,500);
        setLocationRelativeTo(this);
        setTitle("Login");
        addActionListener();
        add(mainPanel);
        setVisible(true);
    }
    public void addActionListener()
    {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new LoginController(this));
    }
}
