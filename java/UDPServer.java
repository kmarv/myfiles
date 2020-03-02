import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.ConsoleHandler;
import java.util.regex.Pattern;

public class UDPServer{
    static String reverseWords(String str)
    {
        // Specifying the pattern to be searched
        Pattern pattern = Pattern.compile("\\s");

        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        String result = "";
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }

    public static void main(String args[]) {
        DatagramSocket serverSocket = null;

        try {
            serverSocket = new DatagramSocket(6789);
            System.out.println("Server Started");
            byte[] receiveRequestData = new byte[1024];
            while (true) {
                /*Server Preparing to receive the request*/
                DatagramPacket request = new DatagramPacket(receiveRequestData, receiveRequestData.length);
                serverSocket.receive(request);
                
                String sentence = new String (request.getData());
                System.out.println("RECEIVED: "+ sentence);

                /*Server preparing to send a response*/
                byte [] sendResponse = new byte[1024];
                String modified = reverseWords(sentence);
                System.out.println("SERVER RESPONSE============: "+ modified);
                receiveRequestData = modified.getBytes();
                InetAddress ipAddress = request.getAddress();
                int port = request.getPort();

                DatagramPacket reply = new DatagramPacket(receiveRequestData,
                        receiveRequestData.length, ipAddress, port);
                serverSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}


