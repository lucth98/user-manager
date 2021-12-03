package controller;

import model.User;
import service.UserService;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class RemoveButtonController extends ControllerSubject implements ActionListener {

    private final MainFrame mainFrame;
    private final UserService userService;

    public RemoveButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: (Onur) Wenn der Benutzer den Account löschen will muss der Benutzer eine Sicherheitsabfrage „Wollen Sie den Account wirklich löschen“ bestätigen
        userService.delete(mainFrame.getAccountUsernameField().getText());
        mainFrame.getMainPane().setEnabledAt(MainFrame.ACCOUNT_PANE_INDEX, false);
        mainFrame.getMainPane().setEnabledAt(MainFrame.LOGIN_PANE_INDEX, true);
        mainFrame.getMainPane().setEnabledAt(MainFrame.REGISTER_PANE_INDEX, true);
        mainFrame.getMainPane().setSelectedIndex(MainFrame.LOGIN_PANE_INDEX);

        notifyObserver();
    }
}
