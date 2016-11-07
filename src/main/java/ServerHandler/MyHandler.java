package ServerHandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/***
 * Example handler shows how to detect GET/POST requests
 * GET writes response
 * POST returns body
 */
public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {

        String response = "";

        if (t.getRequestMethod().equalsIgnoreCase("GET")){
            response = "GET Request Recieved";

        }else if (t.getRequestMethod().equalsIgnoreCase("POST")){
            response = "POST Request Recieved \n";
            InputStreamReader isr =  new InputStreamReader(t.getRequestBody(),"utf-8");
            BufferedReader br = new BufferedReader(isr);

            int b;
            StringBuilder buf = new StringBuilder();
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }

            br.close();
            isr.close();

            response += buf.toString();

        }

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
