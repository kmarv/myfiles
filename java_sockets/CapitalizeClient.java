// importing the necessary libraries
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
        try (var socket = new Socket(args[1], 59898)) {
            // display on client's side
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            // store client's request in a variable var
            var scanner = new Scanner(System.in);

            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }
    }
}