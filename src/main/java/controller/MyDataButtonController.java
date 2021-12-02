package controller;

import service.UserService;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDataButtonController implements ActionListener {

    private MainFrame mainFrame;
    private String username;

    public MyDataButtonController(MainFrame mainFrame,String username)
    {
        this.mainFrame = mainFrame;
        this.username = username;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        UserService userService = UserService.getInstance();
        String firstName = userService.getUserInfo(username,"firstname");
        String lastName = userService.getUserInfo(username,"lastname");

        mainFrame.getFirstNameField().setText(firstName);
        mainFrame.getLastNameField().setText((lastName));
        mainFrame.getUsernameField().setText(username);

    }
}
