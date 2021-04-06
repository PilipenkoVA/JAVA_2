package ru.client_server.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String ADDRESS = "localhost";
    private static final int PORT = 8089;

    public static void main(String[] args)  {
        Socket socket =null;
        try {
            socket = new Socket(ADDRESS, PORT);
            System.out.println("Client connected " + socket.getInetAddress());
            Scanner send = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Thread outMessage = new Thread(()->{
                while (true) {
                    String msg = send.nextLine();
                    out.println(msg);
                    if ("/end".equals(msg)) {
                        break;
                    }
                }
            });
            outMessage.setDaemon(true);
            outMessage.start();
            Thread inMessage = new Thread(()->{
                while (true) {
                    String msg = in.nextLine();
                    if ("/end".equals(msg)) {
                        out.println(msg);
                        break;
                    }
                    System.out.println(msg);
                }
            });
            inMessage.start();
            try {
                inMessage.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }catch (IOException e){

            e.printStackTrace();
        }finally {
            try {
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

