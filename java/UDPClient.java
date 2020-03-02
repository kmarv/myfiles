import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {

    public static void main(String args[]){
        DatagramSocket clientSocket = null;
        try {
//            Preparing to receive input from the user.
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            clientSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 6789;
            System.out.println("Please Enter anything and I will reverse it: ");
            String sentence = inFromUser.readLine();

            /*Organising to send request to the server*/
            byte []sendData = new byte[1024];
            sendData = sentence.getBytes();
            DatagramPacket request = new DatagramPacket(sendData, sendData.length, aHost, serverPort);
            System.out.println("The Client Request: "+ sentence);
            clientSocket.send(request);

            /*Organising to receive server response*/
            byte[] receiveResponse = new byte[1024];
            DatagramPacket reply = new DatagramPacket(receiveResponse, receiveResponse.length);
            clientSocket.receive(reply);
            System.out.println("Reply: "+ new String(reply.getData()));

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (clientSocket != null){clientSocket.close();}
        }


    }
}
