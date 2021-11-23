package controller;

import com.sun.tools.javac.Main;
import view.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO:Das System muss dem Benutzer die Möglichkeit bieten auszuloggen.
//TODO: Das System muss den Benutzer nach 60 Sekunden Inaktivität ausloggen

public class LogoutController implements ActionListener {
    private MainFrame mainFrame;

    public LogoutController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getTextPane().setText("Logout Button gedrückt");
    }
}
