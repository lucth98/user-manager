package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import view.MainFrame;

//TODO: Der UserManager muss dem Benutzer die Möglichkeit bieten sich mit username und password anzumelden.
//TODO: Wenn username oder password nicht mit den gespeicherten übereinstimmen muss das System die Fehlermeldung „username oder password nicht korrekt“ ausgeben.
//TODO: Das System muss dem Benutzer drei Versuche zum Einloggen anbieten.
//
public class LoginController implements ActionListener {
    private MainFrame mainFrame;
    private int loginCounter = 0;
    private final UserService userService;

    public LoginController(MainFrame mainFrame)
    {
        //falls ihr komponenten braucht, mit get methoden holen
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
        userService.register("dd", "dd", "d", "d");
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
        String username = mainFrame.getLoginUsernameField().getText();
        String pwd = new String(mainFrame.getLoginPasswordField().getPassword());

        if(userService.login(username, pwd)){
            loginCounter = 0;

            String firstName = userService.getUserInfo(username,"firstname");
            String lastName  = userService.getUserInfo(username,"lastname");
            mainFrame.getMyAccountPane().setTitleAt(1,"MyAccount");
            mainFrame.getLogoutButton().setVisible(true);
            mainFrame.getChangeButton().setVisible(true);
            mainFrame.getRemoveButton().setVisible(true);
            mainFrame.getClearButton().setVisible(true);
            mainFrame.getMyDataButton().setVisible(true);
            mainFrame.getFirstNameField().setText(firstName);
            mainFrame.getLastNameField().setText(lastName);
            mainFrame.getUsernameField().setText(username);

            mainFrame.getErrorLabel().setText("Hello "+userService.getUserInfo(username,"firstname")+", you are logged in");
            mainFrame.getRegisterErrorField().setText("");

            mainFrame.getErrorLabel().setForeground(Color.green);
            mainFrame.getErrorLabel().setVisible(true);

            mainFrame.getMyDataButton().addActionListener(new MyDataButtonController(mainFrame,username));

        } else{
            mainFrame.setErrorLabelVisibility(true);
            loginCounter++;
            if (loginCounter ==3){
                System.err.println("Exceeded maximum number of login attempts");
                System.exit(-1);
            }
        }
    }
}
