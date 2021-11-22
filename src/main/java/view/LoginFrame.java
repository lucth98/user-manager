package view;

import controller.LoginController;

import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginFrame extends JFrame{




   // public static JFrame loginFrame;
    public static JTextField loginField;
    private JLabel lblWelcome;
    public static JPasswordField passwordField;
    public static JLabel loginFehler ;




    private JLabel lblNewLabel;
    public LoginFrame()
    {
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
     //   loginFrame = new JFrame();
        setTitle("Passwort Manager");
        setLocationRelativeTo(this);
        setSize(1000,1000);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        loginField = new JTextField();
        loginField.setFont(new Font("Dialog", Font.PLAIN, 24));
        loginField.setBounds(392, 358, 222, 56);
        getContentPane().add(loginField);
        loginField.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblUsername.setForeground(Color.YELLOW);
        lblUsername.setBounds(114, 354, 159, 56);
        getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblPassword.setForeground(Color.YELLOW);
        lblPassword.setBounds(117, 446, 177, 64);
        getContentPane().add(lblPassword);

        lblWelcome = new JLabel("Welcome");
        lblWelcome.setForeground(Color.YELLOW);
        lblWelcome.setBounds(377, 129, 512, 184);
        lblWelcome.setFont(new Font("Segoe UI Semilight", Font.BOLD, 53));
        getContentPane().add(lblWelcome);

        passwordField = new JPasswordField();
        passwordField.setBounds(392, 458, 222, 56);
        getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.YELLOW);
        btnLogin.setBounds(337, 591, 113, 64);
        btnLogin.setActionCommand("Login");
        btnLogin.addActionListener(new LoginController(this));
        getContentPane().add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.YELLOW);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(new LoginController(this));

        btnExit.setBounds(501, 591, 113, 64);
        getContentPane().add(btnExit);

        loginFehler = new JLabel("");

        loginFehler.setFont(new Font("Segoe UI", Font.BOLD, 17));
        loginFehler.setForeground(Color.YELLOW);
        loginFehler.setBounds(314, 693, 557, 119);
        getContentPane().add(loginFehler);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 982, 953);
        getContentPane().add(lblNewLabel);
        //frame.setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setVisible(true);

    }






    public static void main(String[] args)
    {
        // LoginForm l = new LoginForm();
        LoginFrame n = new LoginFrame();
    }
}
