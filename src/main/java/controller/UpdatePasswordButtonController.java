package controller;

import service.UserService;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class UpdatePasswordButtonController implements ActionListener {
    private final MainFrame mainFrame;
    private final UserService userService;

    public UpdatePasswordButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Arrays.equals(mainFrame.getAccountPasswordField().getPassword(), mainFrame.getAccountRepeatPasswordField().getPassword())) {
            userService.changePassword(mainFrame.getAccountUsernameField().getText(), new String(mainFrame.getAccountPasswordField().getPassword()));
        } else {
            //TODO Open dialog if passwords are not equal
        }
    }
}
