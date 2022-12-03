import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server{

    private static ArrayList<Client> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
     public static void main(String[] args) throws IOException{

        // listener is an object of class ServerSocket with port 9999
        ServerSocket listener = new ServerSocket(9999);
        try{    
            while(true){

                System.out.println("Waiting for connection");
                Socket clientSocket = listener.accept();
                PrintWriter printer = new PrintWriter(
                    // autoFlush: push data out of the buffer as soon as you hit next println
                    clientSocket.getOutputStream(), true);
            
            
            

                //create object printer, of class PrinterStream
                // printer accept getOutputStream from port 9999 
            
                printer.println("A dollar for a blind man?");
                Client clientThread = new Client(clientSocket);
                clients.add(clientThread);

                pool.execute(clientThread);
            }
        }finally{
        listener.close();
        }
  
    
    
        //getInputStream from clientSocket, read it with InputStreamReader
        // BufferedReader reader = new BufferedReader(
        //                       new InputStreamReader(clientSocket.getInputStream()));

              
        }
            
}