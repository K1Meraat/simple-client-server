import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
    private Socket client;
    private PrintWriter printer;
    private BufferedReader reader;

    public Client(Socket clientSocket) throws IOException{
        // this: client belongs to the class Client
        this.client=clientSocket;
        reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
        printer=new PrintWriter(client.getOutputStream(), true);
    }
    @Override
    public void run() {
        try{

        

            String clientData = "";
            int x=-1;
            System.out.println("x = "+ x);
            while(true){
                //readLine is a method of BufferReader
                clientData = reader.readLine();
                System.out.println(clientData);
                //print on client side
                printer.println(clientData);
                System.out.println(clientData.equals("quit"));
                if(clientData.equals("quit")){

                    printer.println("over and out");
                    break;
                }
                System.out.println("x = "+ x);
            }
            printer.close();
            client.close();

        }catch (IOException e) {
            System.err.println("ahmagh jann");
        }
        System.out.println("Closing");
    }


}