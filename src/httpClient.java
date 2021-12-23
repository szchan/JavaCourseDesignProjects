import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class httpClient {

    public static String post(String jsonObject, String urls, String encoding){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            //创建URL资源
            URL url = new URL(urls);
            //建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置允许输出
            conn.setDoOutput(true);
            //设置不用缓存
            conn.setUseCaches(false);
            //设置传递方式
            conn.setRequestMethod("POST");
            //设置维持长连接
            conn.setRequestProperty("Connection","Keep-Alive");
            //设置文件字符集
            conn.setRequestProperty("Charset",encoding);
            //转换为字节数组
            byte[] data = (jsonObject.toString()).getBytes(encoding);
            //设置文件长度
            conn.setRequestProperty("Content-Length",String.valueOf(data.length));
            //设置文件类型
            conn.setRequestProperty("Content-Type","application/json;charset="+encoding);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(60*10000*2);
            //开始连接请求
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            //写入请求的字符串
            out.write(jsonObject.toString().getBytes(encoding));
            out.flush();
            out.close();


            //请求返回的状态
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                //请求返回的数据
                InputStream in = conn.getInputStream();
                try{
                    String readLine = "";
                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(in,encoding));
                    while ((readLine = responseReader.readLine())!=null){
                        stringBuffer.append(readLine);
                    }
                    responseReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static void httpQueryUser(String username,String password){
        String url = "127.0.0.1:20126";
        Map <String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("username",username);
        jsonMap.put("password",password);
        httpPost(jsonMap,url);

    }

    public static JSONObject httpPost(Map<String, Object> jsonMap, String url){
        String postBody = JSONObject.quote(String.valueOf(jsonMap)).toString();
        System.out.println(postBody);
        String getResult = post(JSONObject.quote(String.valueOf(jsonMap)),url,"UTF-8");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(getResult.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void test(Map<String, Object> jsonMap, String url){
        String postBody = JSONObject.quote(String.valueOf(jsonMap));
        System.out.println(postBody);
    }
    public static void main(String[] args) throws IOException {
        //httpQueryUser("18259211305","123456");
        socketClient.client("queryUser 18259211305 123456");
    }
}
