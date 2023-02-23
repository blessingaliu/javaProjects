package com.sg.dvdcollection.controller;

import com.sg.dvdcollection.dao.DVDLibDao;
import com.sg.dvdcollection.dao.DVDLibDaoException;
import com.sg.dvdcollection.dto.DVDLib;
import com.sg.dvdcollection.ui.DVDLibView;

import java.util.List;

public class DVDLibController {

    DVDLibView view;
    DVDLibDao dao;

    //private UserIO io = new UserIOConsoleImpl();

    public DVDLibController(DVDLibDao dao, DVDLibView view) {
        this.dao = dao;
        this.view = view;
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                try {
                    menuSelection = getMenuSelection();
                } catch (NumberFormatException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                }


                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void listDVDs() throws DVDLibDaoException {
        view.displayDisplayAllBanner();
        List<DVDLib> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDLibDaoException {
        view.displayCreateDVDBanner();
        DVDLib newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void viewDVD() throws DVDLibDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVDLib dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void editDVD() throws DVDLibDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVDLib previousDVD = dao.getDVD(title);
        DVDLib editedDVD = view.editDVD(previousDVD);
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEditSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }


} // end of controller class
