package controller;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonController implements ActionListener {

    public MainFrame mainFrame;

    public ClearButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        mainFrame.getUsernameField().setText("");
        mainFrame.getFirstNameField().setText("");
        mainFrame.getLastNameField().setText("");
        mainFrame.getPasswordField().setText("");
        mainFrame.getPasswordFieldCreate().setText("");
        mainFrame.getPasswordFieldCreateAgain().setText("");


    }
}
