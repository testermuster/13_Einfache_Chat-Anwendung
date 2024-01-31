import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;
        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                out.println(userInput);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Fehler: " + e.getMessage());
        }
    }
}
