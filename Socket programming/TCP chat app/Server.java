import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Server implements Runnable{
    public static void main(String args[]){

        private ArrayList<ConnectionHandler> connections; // to maintain the list of connections

    
    // overriding the run method in the runnable interface
        @Override
        public void run(){

       /* 
         9999 is a port and default ip is loopback ip address i.e 127.0.0.1 
         If a IP address is needed, we will specific it in the server socket
         We also use try-catch since we may get an IO exception
         */
         try{
            SeverSocket server = new SeverSocket(9999); 

            Socket client = server.accept(); // to accept the connection

            ConnectionHandler handler = new ConnectionHandler(client);

            connections.add(handler); // maintains a list of all connectionhandler objects
         }
         catch(IOException ie){
            ie.printStackTrace(); // This will print the stack trace of the exception occured
         }

        }


    // to broadcast the message to all connections
     void broadCast(String message){

        for(Connectionhandler con: connections )
        {
            con.sendMessage(message);
        }

     }

        // Inner class to take multiple client requests via request handler. Each handler is a client
        class ConnectionHandler implements Runnable{

            private Socket client;
            private BufferedReader in; // object to take input
            private out; // object to take output
            private String username;

            // To handle multiple connection handlers of the client via a constructor
            ConnectionHandler(Socket client){
              this.client = client;

            }

            @Override
            public void run(){

                try{

                 out = new PrintWriter(client.getOutputStream(), true);
            /* To get the message from the client and print it. It also use autoflush feature
             to be true 
             */


               
               in = new BufferedReader(new InputStreamReader(client.getInputStream()));
               /*
                  To give any input to the client
               */

               out.println("Enter a one-time username: ");
               username =  in.readLine();

               broadCast(username + " has entered the chatroom");


               // To take message from the client in a loop
               String message;

               while((message = in.readLine()) != null){

               // To check if the client wants to quit
                if(message.startsWith("quit")){

                }else{
                   broadCast(username + ": " + message);
                }

               }

                }catch(IOException ie){

                }

            }


        // To send any message to the client via the handler
        void sendMessage(String message){
            out.println(message);

        }


        }




    }
}


/* 
Use runnable interface to implement a thread pool to accept multiple client requests

writers, readers, and sockets always give io exception. So, we use try-catch for them

*/