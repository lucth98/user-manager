package controller;

import com.sun.tools.javac.Main;
import service.UserService;
import view.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class LogoutButtonController implements ActionListener {
    private final MainFrame mainFrame;
    private final UserService userService;

    private Timer timer=new Timer();

    public LogoutButtonController(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.userService = UserService.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        logout();
    }

    private void logout() {
        userService.logout(mainFrame.getAccountUsernameField().getText());
        mainFrame.getMainPane().setEnabledAt(MainFrame.ACCOUNT_PANE_INDEX, false);
        mainFrame.getMainPane().setEnabledAt(MainFrame.LOGIN_PANE_INDEX, true);
        mainFrame.getMainPane().setEnabledAt(MainFrame.REGISTER_PANE_INDEX, true);
        mainFrame.getMainPane().setSelectedIndex(MainFrame.LOGIN_PANE_INDEX);
    }


    //TODO: calling start & reset
    private void startTimer(){
        TimerTask timerTask =new TimerTask() {
            @Override
            public void run() {
                logout();
            }
        };

        //setting date = now +1 min
        LocalDateTime localDateTime=LocalDateTime.now().plus(Duration.of(1, ChronoUnit.MINUTES));
        Date date=Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


        timer.schedule(timerTask,date);
    }

    private void resetTimer(){
        timer.cancel();
        startTimer();
    }


}
