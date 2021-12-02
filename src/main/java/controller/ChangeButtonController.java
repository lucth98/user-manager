package controller;

import service.UserService;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeButtonController implements ActionListener {
    private MainFrame mainFrame;
    private UserService userService = UserService.getInstance();
    private boolean clickedForFirstTime = true;

    public ChangeButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (clickedForFirstTime) {
            mainFrame.setChangePasswordFieldsVisibilty(true);
            clickedForFirstTime = !clickedForFirstTime;
        } else {
            String pwd1 = new String(mainFrame.getPasswordFieldCreate().getPassword());
            String pwd2 = new String(mainFrame.getPasswordFieldCreateAgain().getPassword());
            String username = mainFrame.getUsernameField().getText();
            if (pwd1.equals(pwd2)){
                userService.changePassword(username, pwd1);
                mainFrame.getRegisterErrorField().setText("Password updated successfully!");
                mainFrame.setChangePasswordFieldsVisibilty(false);
                clickedForFirstTime = !clickedForFirstTime;
            } else{
                mainFrame.getRegisterErrorField().setText("Given passwords don't match!");
            }
        }


    }

}
