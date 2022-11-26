import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {

        try(Socket client = new Socket("localhost", 8989);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);){

            String question = "What is last city?";
            System.out.println(question);
            out.println(question);

            String city = in.readLine();

            System.out.println("From server> Last city is " + city);
            System.out.println("Please input next city");
            Scanner scanner = new Scanner(System.in);
            String newCity = scanner.nextLine();

            out.println(newCity);

            String result = in.readLine();

            System.out.println("From Server> " + result);


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
