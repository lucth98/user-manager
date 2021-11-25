package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.NoSuchElementException;

import service.UserService;
import view.LoginFrame;
import view.MainFrame;

//TODO: Der UserManager muss dem Benutzer die Möglichkeit bieten sich mit username und password anzumelden.
//TODO: Wenn username oder password nicht mit den gespeicherten übereinstimmen muss das System die Fehlermeldung „username oder password nicht korrekt“ ausgeben.
//TODO: Das System muss dem Benutzer drei Versuche zum Einloggen anbieten.
//
public class LoginController implements ActionListener {
    private LoginFrame loginFrame;
    private int loginCounter = 0;
    private UserService userService;

    public LoginController(LoginFrame frame)
    {
        //falls ihr komponenten braucht, mit get methoden holen
        this.loginFrame = frame;
        this.userService = UserService.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Login"))
        {
            login();
        }


        if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    private void login(){
        if(userService.login(loginFrame.getUsernameField1().getText(),
                Arrays.toString(loginFrame.getPasswordField1().getPassword()))){
            loginCounter = 0;
            loginFrame.setVisible(false);
            MainFrame mainFrame = new MainFrame();
        }else{
            loginFrame.setErrorLabelVisibility(true);
            if (loginCounter ==2){
                System.err.println("Exceeded maximum number of login attempts");
                System.exit(-1);
            }else loginCounter++;
        }
    }
}
