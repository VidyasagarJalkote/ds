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


import com.sun.net.httpserver.*;
import java.net.*;
import java.io.*;
import java.net.http.*;

public class WeatherWebService {

    public static void main(String[] args) throws Exception {

        HttpServer server =
            HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/weather", exchange -> {

            // Example URL:
            // http://localhost:8000/weather?city=London

            String query = exchange.getRequestURI().getQuery();

            String city = query.split("=")[1];

            // Your API Key
            String apiKey = "YOUR_API_KEY";

            String apiURL =
                "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid="
                + apiKey
                + "&units=metric";

            // HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request =
                HttpRequest.newBuilder()
                    .uri(URI.create(apiURL))
                    .build();

            HttpResponse<String> responseAPI =
                client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String response = responseAPI.body();

            exchange.sendResponseHeaders(200,
                response.getBytes().length);

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        server.start();

        System.out.println("Weather Server Started");
    }
}

import com.sun.net.httpserver.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class StudentService {

    // Student storage
    static HashMap<Integer, String> students =
            new HashMap<>();

    public static void main(String[] args) throws Exception {

        // Create server on port 8000
        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(8000),
                        0
                );

        // ---------------- ADD STUDENT ----------------
        server.createContext("/addStudent", exchange -> {

            // URL Example:
            // http://localhost:8000/addStudent?id=1&name=Rahul

            String query =
                    exchange.getRequestURI().getQuery();

            Map<String, String> params =
                    getParams(query);

            int id =
                    Integer.parseInt(params.get("id"));

            String name =
                    params.get("name");

            students.put(id, name);

            String response =
                    "Student Added Successfully";

            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );

            OutputStream os =
                    exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        // ---------------- VIEW STUDENT ----------------
        server.createContext("/getStudent", exchange -> {

            // URL Example:
            // http://localhost:8000/getStudent?id=1

            String query =
                    exchange.getRequestURI().getQuery();

            Map<String, String> params =
                    getParams(query);

            int id =
                    Integer.parseInt(params.get("id"));

            String response;

            if (students.containsKey(id)) {

                response =
                        "Student ID: " + id +
                        "\nStudent Name: " +
                        students.get(id);

            } else {

                response = "Student Not Found";
            }

            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );

            OutputStream os =
                    exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        // ---------------- VIEW ALL STUDENTS ----------------
        server.createContext("/allStudents", exchange -> {

            StringBuilder response =
                    new StringBuilder();

            for (Integer id : students.keySet()) {

                response.append(
                        "ID: ")
                        .append(id)
                        .append(" Name: ")
                        .append(students.get(id))
                        .append("\n");
            }

            exchange.sendResponseHeaders(
                    200,
                    response.toString().length()
            );

            OutputStream os =
                    exchange.getResponseBody();

            os.write(
                    response.toString().getBytes()
            );

            os.close();
        });

        // Start server
        server.start();

        System.out.println(
                "Student Web Service Started on Port 8000"
        );
    }

    // Utility method to parse URL parameters
    public static Map<String, String>
    getParams(String query) {

        Map<String, String> map =
                new HashMap<>();

        String pairs[] = query.split("&");

        for (String p : pairs) {

            String keyValue[] = p.split("=");

            map.put(
                    keyValue[0],
                    keyValue[1]
            );
        }

        return map;
    }
}
