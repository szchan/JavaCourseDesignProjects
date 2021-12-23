import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class RequestExecute extends Thread{
    //将Socket定义为成员变量，用构造方法初始化
    private Socket socket;
    public RequestExecute(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        //从Socket中取出输入流，然后从输入流中取出数据
        InputStream inputStream = null;
        //将字节输入流转化为缓冲字符输入流
        InputStreamReader inputStreamReader = null;//转换流
        BufferedReader bufferedReader = null;//字符缓冲流
        try {
            //从socket中获取字节输入流
            inputStream = socket.getInputStream();
            //转换和包装
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            //循环地从字符流中获取字符
            String line = null;
            String outputMessage = null;
            String result = null;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                result = String.valueOf(switchService.service(line));
                if (line.equals("")) {//因为长连接无末尾，读取到空行就退出
                    break;
                }
            }
            OutputStream outputStream = socket.getOutputStream();
            outputMessage = String.valueOf(switchService.service(result));
            socket.getOutputStream().write(outputMessage.getBytes("UTF-8"));
            //OutputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(inputStream != null){
                    inputStream.close();
                }
                if (inputStreamReader != null){
                    inputStreamReader.close();
                }
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
