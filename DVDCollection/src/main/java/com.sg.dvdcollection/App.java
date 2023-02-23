package com.sg.dvdcollection;


import com.sg.dvdcollection.controller.DVDLibController;
import com.sg.dvdcollection.dao.DVDLibDao;
import com.sg.dvdcollection.dao.DVDLibDaoFileImpl;
import com.sg.dvdcollection.ui.DVDLibView;
import com.sg.dvdcollection.ui.UserIO;
import com.sg.dvdcollection.ui.UserIOConsoleImpl;

// Set up similar to Class Rooster
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibView myView = new DVDLibView(myIo);
        DVDLibDao myDao = new DVDLibDaoFileImpl();
        DVDLibController controller = new DVDLibController(myDao, myView);
        controller.run();
    } // end of main class

} // end of app class
