package controller;

import java.util.ArrayList;

public abstract class ControllerSubject {
    ArrayList<ControllerObserver> observers = new ArrayList<>();

    public void addObserver(ControllerObserver controllerObserver) {
        observers.add(controllerObserver);
    }

    public void deleteObserver(ControllerObserver controllerObserver) {
        observers.remove(controllerObserver);
    }

    public void notifyObserver() {
        for (ControllerObserver observer : observers) {
            observer.update();
        }
    }
}
