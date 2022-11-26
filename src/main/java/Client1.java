import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) {

        try(Socket client = new Socket("localhost", 8989);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);){
            out.println("client1");
            System.out.println("FromServer> " + in.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
