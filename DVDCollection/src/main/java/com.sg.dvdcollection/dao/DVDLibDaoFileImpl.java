package com.sg.dvdcollection.dao;

import java.io.*;
import java.util.*;

import com.sg.dvdcollection.dto.DVDLib;

public class DVDLibDaoFileImpl implements DVDLibDao{

    private Map<String, DVDLib> dvds = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVDLib addDVD(String title, DVDLib dvd)
            throws DVDLibDaoException {
        DVDLib newDVD = dvds.put(title, dvd);
        try {
            writeDVD();
        } catch (DVDLibDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return newDVD;
    }

    @Override
    public List<DVDLib> getAllDVDs()
            throws DVDLibDaoException {
        loadDVD();
        return new ArrayList<DVDLib>(dvds.values());
    }

    @Override
    public DVDLib removeDVD(String title) throws DVDLibDaoException {
        DVDLib removedDVD = dvds.remove(title);
        try {
            writeDVD();
        } catch (DVDLibDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return removedDVD;
    }

    @Override
    public DVDLib getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVDLib editDVD(String title, DVDLib dvd) {
        //DVDLib editedDVD = dvds.get(title);
        dvds.put(title, dvd);
        return dvd;
    }

    private void loadDVD() throws DVDLibDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibDaoException(
                    "-_- Could not load library data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVDLib currentDVD = new DVDLib(currentTokens[0]);

            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setStudio(currentTokens[2]);
            currentDVD.setDirectorsName(currentTokens[3]);
            currentDVD.setUserRating(currentTokens[4]);
            currentDVD.setMpaaRating(currentTokens[5]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private void writeDVD() throws DVDLibDaoException, IOException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibDaoException(
                    "Could not save dvd data.", e);
        }

        List<DVDLib> dvdList = this.getAllDVDs();
        for (DVDLib currentDVD : dvdList) {

            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getDirectorsName() + DELIMITER
                    + currentDVD.getUserRating() + DELIMITER
                    + currentDVD.getMpaaRating());

            out.flush();
        }

        out.close();
    }


} // end of main class
