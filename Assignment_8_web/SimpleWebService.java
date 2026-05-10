import com.sun.net.httpserver.*;
import java.net.*;
import java.io.*;

public class SimpleWebService {

    public static void main(String[] args) throws Exception {

        HttpServer server =
            HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/add", exchange -> {

            String q = exchange.getRequestURI().getQuery();

            int a = Integer.parseInt(q.split("&")[0].split("=")[1]);
            int b = Integer.parseInt(q.split("&")[1].split("=")[1]);

            String response = "Result = " + (a + b);

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        server.start();

        System.out.println("Server Started");
    }
}