package ServerPkg;

import ServerHandler.MyHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class CharonBackServer {

    /***
     * Starts Server on port 8000
     * Create new routes/handlers withe server.createContext
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null);
        server.start();
    }
}
