import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {


    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8989)){
            System.out.println("Server started...");
                try(
                        Socket client = server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter out = new PrintWriter(client.getOutputStream());
                ){
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
                }
        }catch (IOException e){
            System.out.println("Не могу создать сервер!");
            e.printStackTrace();
        }

        System.out.println("Server stopped!");
    }

}
