package multithreaded;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){
//        return new Consumer<Socket>() {
//            @Override
//            public void accept(Socket clientSocket){
//              try{
//                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
//                toClient.println("Hello Client from server");
//                toClient.flush();
//                toClient.close();
//                clientSocket.close();
//
//
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//          }
//        };



        //using lambda function
        return(clientSocket)->{
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello Client from server");
                toClient.flush();
                toClient.close();
                clientSocket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        };
    }



    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        int poolsize = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(poolsize);
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listening on port " + port);
            serverSocket.setSoTimeout(10000);

            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println("Accepted connection from " + accept);
                //Thread thread = new Thread(()->server.getConsumer().accept(accept));
                //thread.start();
                threadPool.submit(()->server.getConsumer().accept(accept));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            threadPool.shutdown();
        }
    }
}
