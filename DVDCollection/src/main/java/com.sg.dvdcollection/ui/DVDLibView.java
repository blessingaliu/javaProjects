package com.sg.dvdcollection.ui;

import com.sg.dvdcollection.dto.DVDLib;

import java.util.List;


public class DVDLibView {
    private UserIO io;

    public DVDLibView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD Titles");
        io.print("2. Create New DVD");
        io.print("3. Find a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);

    }

    public void displayDisplayAllBanner() {
        io.print("*** Display All DVDs ***");
    }

    public void displayDVDList(List<DVDLib> dvdList) {
        for (DVDLib currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + " "
                    + currentDVD.getReleaseDate() + " "
                    + currentDVD.getMpaaRating() + " "
                    + currentDVD.getDirectorsName() + " "
                    + currentDVD.getStudio() + " "
                    + currentDVD.getUserRating() + " ");

        }
        io.readString("Please hit enter to continue.");
    }

    public void displayCreateDVDBanner() {
        io.print("*** Create DVD ***");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD has been successfully created.  Please hit enter to continue");
    }

    public DVDLib getNewDVDInfo() {//Menu 2.
        String title = io.readString("Please enter the DVD Title");
        String year = io.readString("Please enter the Release Date");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        String directorsName = io.readString("Please enter the Directors name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter a rating 1 - 5 stars");
        DVDLib currentDVD = new DVDLib(title);
        currentDVD.setReleaseDate(year);
        currentDVD.setStudio(studio);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setUserRating(userRating);
        currentDVD.setMpaaRating(mpaaRating);
        return currentDVD;
    }

    public DVDLib editDVD(DVDLib dvd) {

        String releaseDate = io.readString("Please enter the Release date");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        String directorsName = io.readString("Please enter the Directors name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter a rating 1 - 5 stars");


        dvd.setReleaseDate(releaseDate);
        dvd.setMpaaRating(mpaaRating);
        dvd.setDirectorsName(directorsName);
        dvd.setStudio(studio);
        dvd.setUserRating(userRating);


        return dvd;
    }

    public String getDVDTitleChoice() { //Menu 3.
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDisplayDVDBanner() { //Menu 3.
        io.print("*** Display DVD ***");
    }

    public void displayDVD(DVDLib dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate() + " " + dvd.getStudio());
            io.print(dvd.getDirectorsName() + " " + dvd.getUserRating());
            io.print(dvd.getMpaaRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("*** Remove DVD ***");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("See you again!");
    }

    public void displayEditDVDBanner() {
        io.print("*** Edit DVD ***");
    }

    public void displayEditSuccessBanner() {
        io.readString("DVD successfully Edited. Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("This is a invalid input, please try again!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("*** ERROR ***");
        io.print(errorMsg);
    }

} // end of view class
