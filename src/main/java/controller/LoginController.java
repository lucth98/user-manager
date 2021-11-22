package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginFrame;
import view.MainFrame;

//TODO: Der UserManager muss dem Benutzer die Möglichkeit bieten sich mit username und password anzumelden.
//TODO: Wenn username oder password nicht mit den gespeicherten übereinstimmen muss das System die Fehlermeldung „username oder password nicht korrekt“ ausgeben.
//TODO: Das System muss dem Benutzer drei Versuche zum Einloggen anbieten.
//
public class LoginController implements ActionListener {
    private LoginFrame loginFrame;

    public LoginController(LoginFrame frame)
    {
        //falls ihr komponenten braucht, mit get methoden holen
        this.loginFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Login"))
        {
            loginFrame.setVisible(false);
            MainFrame mainFrame = new MainFrame();
        }


        if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }
}
