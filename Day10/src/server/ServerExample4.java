package server;

import java.net.ServerSocket;
import java.net.Socket;

class ServerExample4 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9002);    //소켓 생성
            while (true) {
                Socket socket = serverSocket.accept();  // 클라이언트에서 요청오기전까지 소켓 무한루프 
                Thread thread = new PerClinetThread(socket);  //클라이언트 요청에 맞춰 쓰레드 생성
                thread.start(); //쓰레드 시작
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}