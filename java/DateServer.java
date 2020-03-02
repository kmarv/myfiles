import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class DateServer {
    public static void main(String[] args) throws IOException {
        // creating a socket for listening from client's end
        try (var listener = new ServerSocket(59090)) {
            System.out.println("The date server is running...");
            while (true) {
                try (var socket = listener.accept()) {
                    // get current date stamp
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    // print date stamp to the client's side 
                    out.println(new Date().toString());
                }
            }
        }
    }
}