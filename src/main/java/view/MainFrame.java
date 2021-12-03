package view;

import controller.*;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane mainPane;
    private JLabel errorLabel;

    //login fields
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    //private JLabel errorLabel;

    //register fields
    private JTextField registerFirstNameField;
    private JTextField registerLastNameField;
    private JTextField registerUsernameField;
    private JPasswordField registerPasswordField;
    private JButton registerButton;
    private JLabel registerErrorField;

    //account fields
    private JButton removeButton;
    private JButton logoutButton;
    private JButton updateButton;
    private JTextField accountFirstNameField;
    private JTextField accountLastnameField;
    private JTextField accountUsernameField;
    private JPasswordField accountPasswordField;
    private JPasswordField accountRepeatPasswordField;

    public static final int LOGIN_PANE_INDEX = 0;
    public static final int REGISTER_PANE_INDEX = 1;
    public static final int ACCOUNT_PANE_INDEX = 2;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("User Manager");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        addListener();
        errorLabel.setVisible(false);
        logoutButton.setVisible(false);
        mainPane.setEnabledAt(2, false);
        setVisible(true);
    }

    public void addListener() {
        RegisterButtonController registerButtonController = new RegisterButtonController(this);
        LoginController loginController = new LoginController(this);
        RemoveButtonController removeButtonController = new RemoveButtonController(this);
        UpdatePasswordButtonController updatePasswordButtonController = new UpdatePasswordButtonController(this);
        LogoutButtonController logoutButtonController = new LogoutButtonController(this);

        loginController.addObserver(logoutButtonController);
        updatePasswordButtonController.addObserver(logoutButtonController);

        loginButton.addActionListener(loginController);
        registerButton.addActionListener(registerButtonController);
        removeButton.addActionListener(removeButtonController);
        logoutButton.addActionListener(logoutButtonController);
        updateButton.addActionListener(updatePasswordButtonController);
    }

    public static void main(String[] args) {
        MainFrame n = new MainFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JTextField getFirstNameField() {
        return registerFirstNameField;
    }

    public JTextField getRegisterLastNameField() {
        return registerLastNameField;
    }

    public JTextField getPasswordField() {
        return registerPasswordField;
    }

    public JPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    public JTextField getLoginUsernameField() {
        return loginUsernameField;
    }

    public JTextField getRegisterUsernameField() {
        return registerUsernameField;
    }

    public JTabbedPane getMainPane() {
        return mainPane;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }


    public void setErrorLabelVisibility(boolean visible) {
        this.errorLabel.setVisible(visible);
    }

    public JTextField getAccountFirstNameField() {
        return accountFirstNameField;
    }

    public JTextField getAccountLastnameField() {
        return accountLastnameField;
    }

    public JTextField getAccountUsernameField() {
        return accountUsernameField;
    }

    public JPasswordField getAccountPasswordField() {
        return accountPasswordField;
    }

    public JPasswordField getAccountRepeatPasswordField() {
        return accountRepeatPasswordField;
    }
}
