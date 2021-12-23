import java.io.*;
import java.net.Socket;

public class socketClient {
    public socketClient(String s) {
    }

    public static String client(String message) throws IOException {
        String result = "";
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 20126;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        //String message = "你好  陈少泽";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        //通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();


        //从Socket中取出输入流，然后从输入流中取出数据
        InputStream inputStream = null;
        //将字节输入流转化为缓冲字符输入流
        InputStreamReader inputStreamReader = null;//转换流
        BufferedReader bufferedReader = null;//字符缓冲流
        String line = null;
        try {
            //从socket中获取字节输入流
            inputStream = socket.getInputStream();
            //转换和包装
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();
            //System.out.println(line);
            result = line;
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        public static void main(String[] args){
//        client();
//    }
        System.out.println(line);
        return result;
    }
}
