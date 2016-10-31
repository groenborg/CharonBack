package services;

import contract.*;
import eto.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by simon on 31/10/2016.
 */
public class ContractService implements UserContract {

    public Collection<DepartureTime> getAllDepartures(Date date, FerryLineInfo ferryLineInfo) throws InvalidDateException, InvalidRouteException {
        return null;
    }

    public Reservation createReservation(PersonInfo personInfo, FerryLineInfo ferryLineInfo, DepartureTime departureTime, Vehicle vehicle, Number number, Number number1) throws NoVacanciesException, InvalidDateException {
        return null;
    }

    public Number deleteReservation(Number number, String s) throws InvalidReservationIdException, InvalidEmailException, InvalidReservationException {
        return null;
    }

    public Reservation ViewReservation(Number number, String s) throws InvalidReservationIdException, InvalidEmailException, InvalidReservationException {
        return null;
    }
}
