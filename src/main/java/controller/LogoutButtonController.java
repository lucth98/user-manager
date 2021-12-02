package controller;

import com.sun.tools.javac.Main;
import service.UserService;
import view.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: Das System muss den Benutzer nach 60 Sekunden Inaktivität ausloggen

public class LogoutButtonController implements ActionListener {
    private final MainFrame mainFrame;
    private final UserService userService;

    public LogoutButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        userService.logout(mainFrame.getAccountUsernameField().getText());
        mainFrame.getMainPane().setEnabledAt(MainFrame.ACCOUNT_PANE_INDEX, false);
        mainFrame.getMainPane().setEnabledAt(MainFrame.LOGIN_PANE_INDEX, true);
        mainFrame.getMainPane().setEnabledAt(MainFrame.REGISTER_PANE_INDEX, true);
        mainFrame.getMainPane().setSelectedIndex(MainFrame.LOGIN_PANE_INDEX);
    }
}
