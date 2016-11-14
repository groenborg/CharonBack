package services;

import contract.*;
import eto.*;

import java.util.*;

/**
 * Created by simon on 31/10/2016.
 */
public class ContractService implements UserContract {

    public Collection<DepartureTime> getAllDepartures(Date date, FerryLineInfo ferryLineInfo) throws InvalidDateException, InvalidRouteException {
        /*
        Creates a list with departureTime objects, then sets the HOUR variable of every object to be 1 hour apart.
        If startDestination is "fyn" then there will be 8 departures, if not, there will be 4.
        */
        Collection<DepartureTime> departureTimes = new ArrayList<>();
        int count;
        int startTime;
        if (ferryLineInfo.getStartDestination().equalsIgnoreCase("fyn")){
            count = 8;
            startTime = 10;
        }
        else{
            count = 4;
            startTime = 11;
        }
        for (int i = 0; i < count; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, startTime+i);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            DepartureTime dt = new DepartureTime(cal.getTime());

            departureTimes.add(dt);
        }
        return departureTimes;
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
