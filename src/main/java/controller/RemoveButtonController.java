package controller;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: Wenn ein Benutzer eingeloggt ist muss das System dem Benutzer die Möglichkeit bieten seinen Account zu löschen.
//TODO: (Onur) Wenn der Benutzer den Account löschen will muss der Benutzer eine Sicherheitsabfrage „Wollen Sie den Account wirklich löschen“ bestätigen


public class RemoveButtonController implements ActionListener {

    private MainFrame mainFrame;
    public RemoveButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getRegisterErrorField().setText("Remove Button geklickt");
    }
}
