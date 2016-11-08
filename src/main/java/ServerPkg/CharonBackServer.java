package ServerPkg;

import ServerHandler.MyHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class CharonBackServer {


    private int port;
    private HttpServer server;

    public CharonBackServer(int port) {
        this.port = port;
    }

    /***
     * Starts Server on port 8000
     * Create new routes/handlers withe server.createContext
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv("BE_SERVER_PORT"));
        CharonBackServer b = new CharonBackServer(port);
        b.startServer();
    }

    public void startServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server started on port: " + port);
    }

}
