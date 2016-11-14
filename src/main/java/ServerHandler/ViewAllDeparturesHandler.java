package ServerHandler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import contract.DepartureTime;
import contract.FerryLineInfo;
import eto.InvalidDateException;
import eto.InvalidRouteException;
import services.ContractService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by Uffe on 11-11-2016.
 */
public class ViewAllDeparturesHandler implements HttpHandler {

    public void handle(HttpExchange t) throws IOException {

        /*
        This handler returns a list of DepartureTimes in Json.
        Correct query is: api/viewAllDepatures?Date=dd-mm-yyyy&startDestination=startDestination&endDestination=endDestination
        if startDestination == "fyn" 8 departures will show, if not, 4 will show.
        */

        ContractService service = new ContractService();
        Gson gson = new Gson();
        String result;
        Calendar cal;
        String startDestination;
        String endDestination;

        try{
            String[] date = t.getRequestURI().getQuery().split("&")[0].split("=")[1].split("-");

            cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(date[2]));
            cal.set(Calendar.MONTH, Integer.parseInt(date[1]) - 1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));

            startDestination = t.getRequestURI().getQuery().split("&")[1].split("=")[1];
            endDestination = t.getRequestURI().getQuery().split("&")[2].split("=")[1];

            Date departureDate = cal.getTime();

            Collection<DepartureTime> departureTimes = service.getAllDepartures(departureDate, new FerryLineInfo(startDestination, endDestination));

            result = gson.toJson(departureTimes);

            t.sendResponseHeaders(200, result.length());
            OutputStream os = t.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
        catch(InvalidDateException | InvalidRouteException e){
            result = "Wrong Data";
            t.sendResponseHeaders(400, result.length());
            OutputStream os = t.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
        catch (Exception e){
            result = "Are you sure the written url is correct?\n" +
                     "Correct query is: /api/viewAllDepartures?Date=dd-mm-yyyy&startDestination=\"startDestination\"&endDestination=\"endDestination\"\n" +
                     "You have written: "+t.getRequestURI();
            t.sendResponseHeaders(404, result.length());
            OutputStream os = t.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
    }
}