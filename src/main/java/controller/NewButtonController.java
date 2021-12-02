package controller;

import service.UserService;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewButtonController implements ActionListener {
    private MainFrame mainFrame;

    public NewButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        mainFrame.getRegisterErrorField().setText("New Button geklickt");
        UserService userService = UserService.getInstance();

        String username = mainFrame.getUsernameField().getText();
        String firstName = mainFrame.getFirstNameField().getText();
        String lastName = mainFrame.getLastNameField().getText();
        String password = mainFrame.getPasswordField().getText();

        // Validations

        if (userService.checkIfUsernameExists(username).isPresent()) {

            return;
        }

        // Validations end

        userService.register(username, password, firstName, lastName);

        mainFrame.getRegisterErrorField().setText("User wurde erfolgreich angelegt");
    }
}
