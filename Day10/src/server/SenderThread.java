package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread extends Thread {
    Socket socket;
    String name;
    SenderThread(Socket socket, String name) { 
        this.socket = socket;
        this.name = name;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    //입력 쓰레드 
            PrintWriter writer = new PrintWriter(socket.getOutputStream());                  //출력 쓰레드
            
	    // 제일 먼저 서버로 대화명 송신한다.
	    writer.println(name);
            writer.flush();
           
	   // 키보드로 입력된 메시지를 서버로 송신 
	    while (true) {
                String str = reader.readLine();
                if (str.equals("bye"))
                    break;
                writer.println(str);
                writer.flush();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
