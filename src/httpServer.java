import java.net.ServerSocket;
import java.net.Socket;

public class httpServer implements Runnable {
//    private static int port = 20126;
    private static int port = 20126;

    public httpServer(int port) {
    }

    @Override
    public void run() {
        //线程的主程序
        //声明ServerSocket对象
        ServerSocket serverSocket = null;
         try{
             //创建ServerSocket对象
            serverSocket = new ServerSocket(port);
            //开始监听
             while (true) {
                 Socket socket = serverSocket.accept();
                 System.out.println("success");
                 //将socket交给RequestExecute处理
                 RequestExecute requestExecute = new RequestExecute(socket);
                 requestExecute.start();
             }
         }catch(Exception e){
             e.printStackTrace();
         }
    }

    public static void main(String[] args) {
        //创建线程类对象
        httpServer httpServer = new httpServer(port);
        //利用Thread启动线程
        new Thread(httpServer).start();
    }
}
