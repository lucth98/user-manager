package controller;

import service.UserService;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterButtonController extends ControllerSubject implements ActionListener {
    private final MainFrame mainFrame;

    public RegisterButtonController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserService userService = UserService.getInstance();

        String username = mainFrame.getRegisterUsernameField().getText();
        String firstName = mainFrame.getFirstNameField().getText();
        String lastName = mainFrame.getRegisterLastNameField().getText();
        String password = mainFrame.getPasswordField().getText();

        if (userService.checkIfUsernameExists(username).isPresent()) {
            //TODO open dialog with already exists message
            System.err.println("username already exists");

        } else {
            userService.register(username, password, firstName, lastName);
        }
    }
}
