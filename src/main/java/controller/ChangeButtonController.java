package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO:Wenn der Benutzer angemeldet ist muss der UserManager dem Benutzer die Möglichkeit bieten das Kennwort zu ändern.
//TODO: Ausgabe wenn Benutzer erfolgreich verändert wurde oder Fehlermeldungen
//Done: Wenn der Benutzer das Kennwort ändert muss das System dem Benutzer die Möglichkeit bieten das neue Kennwort zweimal einzugeben.
//TODO:Wenn der Benutzer das Kennwort ändert und zweimal eingegeben hat muss das System die Kennwörter vergleichen.
//TODO: Wenn die verglichenen Kennwörter gleich sind muss das System das Kennwort aktualisieren
//TODO: Wenn die verglichenen Kennwörter ungleich sind muss das System die Fehlermeldung Kennwörter nicht gleich ausgeben“.
//TODO: Das System muss das Kennwort verschlüsselt speichern

public class ChangeButtonController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Change button gedrückt");
    }
}
