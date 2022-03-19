package com.imshy.Backend;

import com.imshy.Main;
import com.imshy.UserInterface.UI;

public class Controller {
    private static Controller instance;
    private static String[] args;

    public static Controller getInstance(String[] args) {
        if (instance == null) {
            instance = new Controller(args);
        }
        return instance;
    }
    private Controller(String[] args) {
        Controller.args = args;
    }
    public void run() {
        UI ui = new UI();
        ui.start();
    }


}
