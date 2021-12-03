package controller;

import service.UserService;
import view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: Wenn username oder password nicht mit den gespeicherten übereinstimmen muss das System die Fehlermeldung „username oder password nicht korrekt“ ausgeben.

public class LoginController implements ActionListener {
    private final MainFrame mainFrame;
    private int loginCounter = 0;
    private final UserService userService;

    public LoginController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            login();
        }
    }

    private void login() {
        String username = mainFrame.getLoginUsernameField().getText();
        String pwd = new String(mainFrame.getLoginPasswordField().getPassword());

        if (userService.login(username, pwd)) {
            loginCounter = 0;
            String firstName = userService.getUser(username).getFirstName();
            String lastName = userService.getUser(username).getLastName();
            mainFrame.getLogoutButton().setVisible(true);
            mainFrame.getRemoveButton().setVisible(true);
            mainFrame.getAccountFirstNameField().setText(firstName);
            mainFrame.getAccountLastnameField().setText(lastName);
            mainFrame.getAccountUsernameField().setText(username);
            mainFrame.getMainPane().setEnabledAt(MainFrame.ACCOUNT_PANE_INDEX, true);
            mainFrame.getMainPane().setEnabledAt(MainFrame.LOGIN_PANE_INDEX, false);
            mainFrame.getMainPane().setEnabledAt(MainFrame.REGISTER_PANE_INDEX, false);
            mainFrame.getMainPane().setSelectedIndex(MainFrame.ACCOUNT_PANE_INDEX);
            mainFrame.getErrorLabel().setForeground(Color.green);
            mainFrame.getErrorLabel().setVisible(true);
            mainFrame.getLoginUsernameField().setText("");
            mainFrame.getLoginPasswordField().setText("");
        } else {
            mainFrame.setErrorLabelVisibility(true);
            loginCounter++;
            if (loginCounter == 3) {
                System.err.println("Exceeded maximum number of login attempts");
                System.exit(-1);
            }else {
                System.err.println("username or password not correct");
            }
        }
    }
}
