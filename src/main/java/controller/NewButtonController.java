package controller;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: Das System muss dem Benutzer die Möglichkeit bieten einen Account mit Vorname, Nachname, Benutzername und Kennwort anzulegen. --> nur mehr logik
//TODO: Wenn der Benutzer einen neuen Account anlegen will muss das System auf Existenz des Usernames prüfen
//TODO: Wenn der Username existiert muss das System die Meldung „Username existiert bereits“ ausgeben
//TODO: Das System muss das Kennwort verschlüsselt speichern

public class NewButtonController implements ActionListener {
    private MainFrame mainFrame;

    public NewButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getTextPane().setText("New Button gedrückt");

    }
}
