package ru.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket client = null;
        try {
            serverSocket = new ServerSocket(8089);
            System.out.println("Server started");
            client = serverSocket.accept();
            System.out.println("Client connected  " + client.getInetAddress());
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            Scanner send = new Scanner(System.in);
            Thread outMessage = new Thread(() -> {
                while (true){
                    String msg = send.nextLine();
                    out.println("message from Server: " + msg);
                    if("/end".equals(msg)){
                        break;
                    }
                }
            });
            outMessage.setDaemon(true);
            outMessage.start();
            Thread inMessage =new Thread(()->{
                while (true){
                    String str = in.nextLine();
                    if("/end".equals(str)){
                        out.println(str);
                        break;
                    }
                    System.out.println(str);
                }
            });
            inMessage.start();
            try {
                inMessage.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            disconnect(serverSocket,client);
        }
    }

    public static void disconnect(ServerSocket serverSocket, Socket client){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
