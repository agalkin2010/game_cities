import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    private static String city;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8989)){
            System.out.println("Server started...");
            while (true){
                try(
                        Socket client = server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                ){
                    System.out.println("New connection accepted");
                    System.out.println("From client> " + in.readLine());

                    String answer;

                    if (city == null) answer = "???"; else answer  = city;
                    out.println(answer);
                    System.out.println(answer);

                    String cityNew = in.readLine();
                    System.out.println("New city from client> " + cityNew);

                    if (city == null || city.charAt(city.length() - 1) == cityNew.charAt(0)) {
                        city = cityNew;
                        out.println("Ok");
                        System.out.println("Ok");
                    } else {
                        out.println("Not Ok");
                        System.out.println("Not Ok");
                    }
                    System.out.println();
                    System.out.println("Next player");
                }
            }
        }catch (IOException e){
            System.out.println("Не могу создать сервер!");
            e.printStackTrace();
        }

        System.out.println("Server stopped");
    }

}
