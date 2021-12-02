package view;

import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {


    //login fields
    private JLabel usernameLabel;

    private JLabel passwordLabel;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    //private JLabel errorLabel;


    //myaccount/register fields
    private JButton newButton;
    private JButton changeButton;
    private JPanel mainPanel;
    private JTabbedPane myAccountPane;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordFieldCreate;
    private JPasswordField passwordFieldCreateAgain;
    private JLabel newPasswordLabel;
    private JLabel newPasswordAgainLabel;
    private JPasswordField passwordField;
    private JButton removeButton;
    private JButton logoutButton;
    private JTextField usernameField;
    private JLabel errorLabel;
    private JLabel registerErrorField;
    private JButton myDataButton;
    private JButton clearButton;


    public MainFrame()
    {
        setContentPane(mainPanel);
        setTitle("MyAccount");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
       // initMenuBar();
        addListener();
        errorLabel.setVisible(false);

        changeButton.setVisible(false);
        logoutButton.setVisible(false);
        removeButton.setVisible(false);
        myDataButton.setVisible(false);
        clearButton.setVisible(false);

        setVisible(true);

    }

    public void addListener()
    {
        loginButton.addActionListener(new LoginController(this));
        newButton.addActionListener(new NewButtonController(this));
        changeButton.addActionListener(new ChangeButtonController(this));
        removeButton.addActionListener(new RemoveButtonController(this));
        logoutButton.addActionListener(new LogoutButtonController(this));

        clearButton.addActionListener(new ClearButtonController(this));
    }

    public static void main(String[] args)
    {
        // LoginForm l = new LoginForm();
        MainFrame n = new MainFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    public JTextField getLoginUsernameField() {
        return loginUsernameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTabbedPane getMyAccountPane() {
        return myAccountPane;
    }

    public JButton getChangeButton() {
        return changeButton;
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

    public JLabel getRegisterErrorField() {
        return registerErrorField;
    }

    public JButton getMyDataButton() {
        return myDataButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JPasswordField getPasswordFieldCreate() {
        return passwordFieldCreate;
    }

    public JPasswordField getPasswordFieldCreateAgain() {
        return passwordFieldCreateAgain;
    }

    public JLabel getNewPasswordLabel() {
        return newPasswordLabel;
    }

    public JLabel getNewPasswordAgainLabel() {
        return newPasswordAgainLabel;
    }

    public void setChangePasswordFieldsVisibilty(boolean visible){
        newPasswordLabel.setVisible(visible);
        newPasswordAgainLabel.setVisible(visible);
        passwordFieldCreate.setVisible(visible);
        passwordFieldCreateAgain.setVisible(visible);
    }

    public void setErrorLabelVisibility(boolean visible){
        this.errorLabel.setVisible(visible);
    }
}
