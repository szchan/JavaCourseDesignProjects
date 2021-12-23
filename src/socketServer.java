import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer implements Runnable {

    public socketServer() {

    }


    @Override
    public void run() {
        //监听端口
        int port = 20126;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RequestExecute requestExecute = new RequestExecute(socket);
            requestExecute.start();
        }

    }
    public static void main(String[] args) {
        socketServer socketServer = new socketServer();
        new Thread((Runnable) socketServer).start();
    }
}
