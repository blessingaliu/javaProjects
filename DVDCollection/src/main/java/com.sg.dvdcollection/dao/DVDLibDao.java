package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVDLib;
import java.util.List;

public interface DVDLibDao {

    DVDLib addDVD(String title, DVDLib dvd)
            throws DVDLibDaoException;

    List<DVDLib> getAllDVDs()
            throws DVDLibDaoException;

    DVDLib getDVD(String title)
            throws DVDLibDaoException;

    DVDLib removeDVD(String title)
            throws DVDLibDaoException;

    DVDLib editDVD(String title, DVDLib dvd)
            throws DVDLibDaoException;

} // end of interface
